/**
 * 
 */
package org.apache.maven.continuum.xfire;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.ServiceFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.service.invoker.ObjectInvoker;

/**
 * Service factory to make WebService from a given class.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class ContinuumXFireServiceFactory {

    /**
     * @deprecated <em>Experimental</em>
     */
    private static final String SYS_PROP_XFIRE_CONFIG = "xfire.config";

    /**
     * @deprecated <em>Experimental</em>
     */
    private static final String CONTINUUM_WEB_SERVICE_CONFIG_XML = "/org/apache/maven/continuum/xfire/services/services.xml";

    public static final String CONTINUUM_WEB_SERVICE_NAME = "ContinuumWebService"; // .class.getSimpleName
                                                                                    // ();

    public static final String CONTINUUM_WEB_SERVICE_NAMESPACE = "http://continuum.maven.apache.org/";

    public static final String CONTINUUM_WEB_SERVICE_URL = "http://localhost:8081/continuumws/";


    /**
     * Create a ContinuumWebService instance here.
     * 
     * @return an instance of {@link IContinuumWebService} to be exposed to
     *         clients.
     */
    public static void createContinuumWebService() {
        // System.setProperty (SYS_PROP_XFIRE_CONFIG,
        // CONTINUUM_WEB_SERVICE_CONFIG_XML);
        XFireFactory xfireFactory = XFireFactory.newInstance ();
        ServiceFactory serviceFactory = new ObjectServiceFactory (xfireFactory.getXFire ().getTransportManager (), null);
        Service service = serviceFactory.create (ContinuumWebService.class, CONTINUUM_WEB_SERVICE_NAME, CONTINUUM_WEB_SERVICE_NAMESPACE, null);
        service.setProperty (ObjectInvoker.SERVICE_IMPL_CLASS, DefaultContinuumWebService.class);
    }

}
