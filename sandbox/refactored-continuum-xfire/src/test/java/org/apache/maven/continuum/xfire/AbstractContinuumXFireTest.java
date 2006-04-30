/**
 * 
 */
package org.apache.maven.continuum.xfire;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.apache.maven.continuum.configuration.ConfigurationService;
import org.apache.maven.continuum.execution.ContinuumBuildExecutor;
import org.apache.maven.continuum.model.project.BuildDefinition;
import org.apache.maven.continuum.model.project.Project;
import org.apache.maven.continuum.model.project.ProjectGroup;
import org.apache.maven.continuum.model.project.ProjectNotifier;
import org.apache.maven.continuum.model.scm.ScmResult;
import org.apache.maven.continuum.store.ContinuumStore;
import org.apache.maven.continuum.store.ContinuumStoreException;
import org.codehaus.plexus.PlexusTestCase;
import org.codehaus.plexus.jdo.ConfigurableJdoFactory;
import org.codehaus.plexus.jdo.DefaultConfigurableJdoFactory;
import org.codehaus.plexus.jdo.JdoFactory;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.XFire;
import org.codehaus.xfire.exchange.InMessage;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.ServiceFactory;
import org.codehaus.xfire.service.ServiceRegistry;
import org.codehaus.xfire.service.binding.MessageBindingProvider;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.soap.Soap11;
import org.codehaus.xfire.soap.Soap12;
import org.codehaus.xfire.soap.SoapConstants;
import org.codehaus.xfire.test.XPathAssert;
import org.codehaus.xfire.transport.Channel;
import org.codehaus.xfire.transport.Transport;
import org.codehaus.xfire.transport.local.LocalTransport;
import org.codehaus.xfire.util.STAXUtils;
import org.codehaus.xfire.util.jdom.StaxBuilder;
import org.codehaus.xfire.wsdl.WSDLWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.jpox.SchemaTool;

/**
 * Uses <b>Composition</b> to be fuse both Continuum and XFire test harness.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class AbstractContinuumXFireTest extends PlexusTestCase {

    private ContinuumStore store;


    // ----------------------------------------------------------------------
    //
    // ----------------------------------------------------------------------

    protected void setUp() throws Exception {
        super.setUp ();

        getStore ();

        setUpConfigurationService ((ConfigurationService) lookup (ConfigurationService.ROLE));

        // Set up PlexusFireTestcase stuff.
        addNamespace ("s", Soap11.getInstance ().getNamespace ());
        addNamespace ("soap12", Soap12.getInstance ().getNamespace ());
    }


    public static void setUpConfigurationService(ConfigurationService configurationService) throws Exception {
        configurationService.load ();

        configurationService.setBuildOutputDirectory (getTestFile ("target/build-output"));

        configurationService.setWorkingDirectory (getTestFile ("target/working-directory"));

        configurationService.store ();
    }


    protected ProjectGroup getDefaultProjectGroup() throws ContinuumStoreException {
        return store.getDefaultProjectGroup ();
    }


    // ----------------------------------------------------------------------
    // Store
    // ----------------------------------------------------------------------

    protected ContinuumStore getStore() throws Exception {
        if (store != null) { return store; }

        // ----------------------------------------------------------------------
        // Set up the JDO factory
        // ----------------------------------------------------------------------

        Object o = lookup (JdoFactory.ROLE);

        assertEquals (DefaultConfigurableJdoFactory.class.getName (), o.getClass ().getName ());

        ConfigurableJdoFactory jdoFactory = (ConfigurableJdoFactory) o;

        jdoFactory.setPersistenceManagerFactoryClass ("org.jpox.PersistenceManagerFactoryImpl");

        jdoFactory.setDriverName ("org.hsqldb.jdbcDriver");

        jdoFactory.setUrl ("jdbc:hsqldb:mem:" + getClass ().getName () + "." + getName ());

        jdoFactory.setUserName ("sa");

        jdoFactory.setPassword ("");

        jdoFactory.setProperty ("org.jpox.transactionIsolation", "READ_UNCOMMITTED");

        jdoFactory.setProperty ("org.jpox.poid.transactionIsolation", "READ_UNCOMMITTED");

        jdoFactory.setProperty ("org.jpox.autoCreateTables", "true");

        Properties properties = jdoFactory.getProperties ();

        for (Iterator it = properties.entrySet ().iterator (); it.hasNext ();) {
            Map.Entry entry = (Map.Entry) it.next ();

            System.setProperty ((String) entry.getKey (), (String) entry.getValue ());
        }

        SchemaTool.createSchemaTables (new URL[] { getClass ().getResource ("/META-INF/package.jdo")}, false);

        // ----------------------------------------------------------------------
        // Check the configuration
        // ----------------------------------------------------------------------

        PersistenceManagerFactory pmf = jdoFactory.getPersistenceManagerFactory ();

        assertNotNull (pmf);

        PersistenceManager pm = pmf.getPersistenceManager ();

        pm.close ();

        // ----------------------------------------------------------------------
        //
        // ----------------------------------------------------------------------

        store = (ContinuumStore) lookup (ContinuumStore.ROLE);

        return store;
    }


    // ----------------------------------------------------------------------
    // Build Executor
    // ----------------------------------------------------------------------

    protected ContinuumBuildExecutor getBuildExecutor(String id) throws Exception {
        ContinuumBuildExecutor buildExecutor = (ContinuumBuildExecutor) lookup (ContinuumBuildExecutor.ROLE, id);

        assertNotNull ("Could not look up build executor '" + id + "'", buildExecutor);

        return buildExecutor;
    }


    // ----------------------------------------------------------------------
    // Maven 2 Project Generators
    // ----------------------------------------------------------------------

    public static Project makeStubProject(String name) {
        return makeProject (name, "foo@bar.com", "1.0");
    }


    public static Project makeProject(String name, String emailAddress, String version) {
        Project project = new Project ();

        makeProject (project, name, version);

        List notifiers = createMailNotifierList (emailAddress);

        project.setNotifiers (notifiers);

        return project;
    }


    // ----------------------------------------------------------------------
    // Shell Project Generators
    // ----------------------------------------------------------------------

    public static Project makeStubShellProject(String name, String script) {
        Project project = new Project ();

        makeProject (project, name, "1.0");
        project.setExecutorId ("shell");

        BuildDefinition def = new BuildDefinition ();
        def.setBuildFile (script);
        project.addBuildDefinition (def);

        return project;
    }


    public static Project makeProject(Project project, String name, String version) {
        project.setExecutorId ("maven2");
        project.setName (name);
        project.setVersion (version);

        return project;
    }


    protected static List createMailNotifierList(String emailAddress) {
        if (emailAddress == null) { return null; }

        ProjectNotifier notifier = new ProjectNotifier ();

        notifier.setType ("mail");

        Properties props = new Properties ();

        props.put ("address", emailAddress);

        notifier.setConfiguration (props);

        List notifiers = new ArrayList ();

        notifiers.add (notifier);

        return notifiers;
    }


    // ----------------------------------------------------------------------
    // Public utility methods
    // ----------------------------------------------------------------------

    public Project addProject(ContinuumStore store, Project project) throws Exception {
        ProjectGroup defaultProjectGroup = getDefaultProjectGroup ();

        // ----------------------------------------------------------------------
        //
        // ----------------------------------------------------------------------

        ScmResult scmResult = new ScmResult ();

        scmResult.setSuccess (true);

        scmResult.setCommandOutput ("commandOutput");

        scmResult.setProviderMessage ("providerMessage");

        project.setCheckoutResult (scmResult);

        defaultProjectGroup.addProject (project);
        store.updateProjectGroup (defaultProjectGroup);

        project = store.getProject (project.getId ());
        assertNotNull ("project group == null", project.getProjectGroup ());

        return project;
    }


    public Project addProject(ContinuumStore store, String name) throws Exception {
        return addProject (store, makeStubProject (name));
    }


    public Project addProject(ContinuumStore store, String name, String nagEmailAddress, String version) throws Exception {
        return addProject (store, makeProject (name, nagEmailAddress, version));
    }


    public static void setCheckoutDone(ContinuumStore store, Project project, ScmResult scmResult) throws ContinuumStoreException {
        project.setCheckoutResult (scmResult);

        store.updateProject (project);
    }


    // ----------------------------------------------------------------------
    // Assertions
    // ----------------------------------------------------------------------

    public void assertProjectEquals(Project expected, Project actual) {
        assertProjectEquals (expected.getName (), expected.getNotifiers (), expected.getVersion (), actual);
    }


    public void assertProjectEquals(String name, String emailAddress, String version, Project actual) {
        assertProjectEquals (name, createMailNotifierList (emailAddress), version, actual);
    }


    public void assertProjectEquals(String name, List notifiers, String version, Project actual) {
        assertEquals ("project.name", name, actual.getName ());

        // assertEquals( "project.scmUrl", scmUrl, actual.getScmUrl() );

        if (notifiers != null) {
            assertNotNull ("project.notifiers", actual.getNotifiers ());

            assertEquals ("project.notifiers.size", notifiers.size (), actual.getNotifiers ().size ());

            for (int i = 0; i < notifiers.size (); i++) {
                ProjectNotifier notifier = (ProjectNotifier) notifiers.get (i);

                ProjectNotifier actualNotifier = (ProjectNotifier) actual.getNotifiers ().get (i);

                assertEquals ("project.notifiers.notifier.type", notifier.getType (), actualNotifier.getType ());

                assertEquals ("project.notifiers.notifier.configuration.address", notifier.getConfiguration ().get ("address"), actualNotifier.getConfiguration ().get ("address"));
            }
        }

        assertEquals ("project.version", version, actual.getVersion ());
    }


    // ----------------------------------------------------------------------
    // Simple utils
    // ----------------------------------------------------------------------

    public ProjectGroup createStubProjectGroup(String name, String description) {
        ProjectGroup projectGroup = new ProjectGroup ();

        projectGroup.setName (name);

        projectGroup.setDescription (description);

        return projectGroup;
    }

    // ----------------------------------------------------------------------
    // Methods from PlexusXFireTestCase
    // ----------------------------------------------------------------------

    private ServiceFactory factory;

    private XMLInputFactory defaultInputFactory = XMLInputFactory.newInstance ();

    /**
     * Namespaces for the XPath expressions.
     */
    private Map namespaces = new HashMap ();


    protected void printNode(Document node) throws Exception {
        XMLOutputter writer = new XMLOutputter ();

        writer.output (node, System.out);
    }


    protected void printNode(Element node) throws Exception {
        XMLOutputter writer = new XMLOutputter ();

        writer.output (node, System.out);
    }


    /**
     * Invoke a service with the specified document.
     * 
     * @param service
     *            The name of the service.
     * @param document
     *            The request as an xml document in the classpath.
     */
    protected Document invokeService(String service, String document) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream ();
        MessageContext context = new MessageContext ();
        context.setXFire (getXFire ());
        context.setProperty (Channel.BACKCHANNEL_URI, out);

        if (service != null)
            context.setService (getServiceRegistry ().getService (service));

        InputStream stream = getResourceAsStream (document);
        InMessage msg = new InMessage (STAXUtils.createXMLStreamReader (stream, "UTF-8", null));

        Transport t = getXFire ().getTransportManager ().getTransport (LocalTransport.BINDING_ID);
        Channel c = t.createChannel ();

        c.receive (context, msg);

        String response = out.toString ();
        if (response == null || response.length () == 0)
            return null;

        return readDocument (response);
    }


    protected Document readDocument(String text) throws XMLStreamException {
        return readDocument (text, defaultInputFactory);
    }


    protected Document readDocument(String text, XMLInputFactory ifactory) throws XMLStreamException {
        try {
            StaxBuilder builder = new StaxBuilder (ifactory);
            return builder.build (new StringReader (text));
        } catch (XMLStreamException e) {
            System.err.println ("Could not read the document!");
            System.err.println (text);
            throw e;
        }
    }


    protected Document getWSDLDocument(String service) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream ();

        getXFire ().generateWSDL (service, out);

        return readDocument (out.toString ());
    }


    // COMMENTED: Merged into single setup.
    // protected void setUp() throws Exception {
    // super.setUp ();
    // addNamespace ("s", Soap11.getInstance ().getNamespace ());
    // addNamespace ("soap12", Soap12.getInstance ().getNamespace ());
    // }

    /**
     * Assert that the following XPath query selects one or more nodes.
     * 
     * @param xpath
     */
    public List assertValid(String xpath, Object node) throws Exception {
        return XPathAssert.assertValid (xpath, node, namespaces);
    }


    /**
     * Assert that the following XPath query selects no nodes.
     * 
     * @param xpath
     */
    public List assertInvalid(String xpath, Object node) throws Exception {
        return XPathAssert.assertInvalid (xpath, node, namespaces);
    }


    /**
     * Asser that the text of the xpath node retrieved is equal to the value
     * specified.
     * 
     * @param xpath
     * @param value
     * @param node
     */
    public void assertXPathEquals(String xpath, String value, Document node) throws Exception {
        XPathAssert.assertXPathEquals (xpath, value, node, namespaces);
    }


    public void assertNoFault(Document node) throws Exception {
        XPathAssert.assertNoFault (node);
    }


    /**
     * Add a namespace that will be used for XPath expressions.
     * 
     * @param ns
     *            Namespace name.
     * @param uri
     *            The namespace uri.
     */
    public void addNamespace(String ns, String uri) {
        namespaces.put (ns, uri);
    }


    /**
     * Get the WSDL for a service.
     * 
     * @param service
     *            The name of the service.
     */
    protected WSDLWriter getWSDL(String service) throws Exception {
        ServiceRegistry reg = getServiceRegistry ();
        Service hello = reg.getService (service);

        return hello.getWSDLWriter ();
    }


    public ServiceFactory getServiceFactory() throws Exception {
        if (factory == null) {
            ObjectServiceFactory ofactory = new ObjectServiceFactory (getXFire ().getTransportManager (), new MessageBindingProvider ());

            ofactory.setStyle (SoapConstants.STYLE_MESSAGE);

            factory = ofactory;
        }

        return factory;
    }


    public void setServiceFactory(ServiceFactory factory) {
        this.factory = factory;
    }


    protected InputStream getResourceAsStream(String resource) {
        return getClass ().getResourceAsStream (resource);
    }


    protected Reader getResourceAsReader(String resource) {
        return new InputStreamReader (getResourceAsStream (resource));
    }


    protected XFire getXFire() throws Exception {
        return (XFire) lookup (XFire.ROLE);
    }


    protected ServiceRegistry getServiceRegistry() throws Exception {
        return getXFire ().getServiceRegistry ();
    }

}
