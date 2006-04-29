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

    public static final String CONTINUUM_SERVICE_NAME = "Continuum";

    public static final String CONTINUUM_SERVICE_NAMESPACE = "http://continuum.maven.apache.org/";

    public static final String CONTINUUM_SERVICE_URL = "http://localhost:8081/continuumws/continuum/";


    /**
     * Create a ContinuumWebService instance here.
     * 
     * @return an instance of {@link IContinuumWebService} to be exposed to
     *         clients.
     */
    public static void makeContinuumWebService() {
        ServiceFactory serviceFactory = new ObjectServiceFactory (XFireFactory.newInstance ().getXFire ().getTransportManager (), null);
        Service service = serviceFactory.create (IContinuumWebService.class, CONTINUUM_SERVICE_NAME, CONTINUUM_SERVICE_NAMESPACE, null);
        service.setProperty (ObjectInvoker.SERVICE_IMPL_CLASS, DefaultContinuumWebService.class);
    }

}
