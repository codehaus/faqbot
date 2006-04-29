/**
 * 
 */
package org.apache.maven.continuum.xfire;

import java.awt.print.Book;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.maven.continuum.Continuum;
import org.codehaus.xfire.DefaultXFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.util.dom.DOMOutHandler;

/**
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class XFireMockClientAppTest {

    public static final String SERVICE_NAMESPACE = "http://xfire.codehaus.org/BookService";

    public static final String SERVICE_URL = "http://localhost:8081/bookws/services/";


    /**
     * @param url
     * @throws MalformedURLException
     */
    public static void executeClient(String serviceName) throws MalformedURLException {
        System.out.println ("Running client...");
        DefaultXFire xfire = (DefaultXFire) XFireFactory.newInstance ().getXFire ();

        xfire.addOutHandler (new DOMOutHandler ());
        Properties properties = new Properties ();

        xfire.addOutHandler (new WSS4JOutHandler (properties));

        Service serviceModel = new ObjectServiceFactory ().create (ContinuumWebService.class, "Continuum", SERVICE_NAMESPACE, null);

        ContinuumWebService service = (ContinuumWebService) new XFireProxyFactory ().create (serviceModel, SERVICE_URL + serviceName);

        System.out.println ("Looking for isbn : 0123456789 ....");

        if (null == service) {
            System.err.println ("Continuum service was null");
        } else {
            System.out.println ("Continuum service was : " + service);
        }

    }


    /**
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception {
        executeClient ("Continuum");
        System.out.println ("Finished!");
    }

}
