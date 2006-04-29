/**
 * 
 */
package org.apache.maven.continuum.xfire;

import org.apache.maven.continuum.Continuum;
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

    private static XFireFactory sf = null;


    /**
     * Create a ContinuumWebService instance here.
     * 
     * @return an instance of {@link IContinuumWebService} to be exposed to
     *         clients.
     */
    public static void makeContinuumWebService() {
        XFireFactory xfireFactory = XFireFactory.newInstance ();
        ServiceFactory serviceFactory = new ObjectServiceFactory (xfireFactory.getXFire ().getTransportManager (), null);
        Service service = serviceFactory.create (Continuum.class, CONTINUUM_SERVICE_NAME, CONTINUUM_SERVICE_NAMESPACE, null);
        service.setProperty (ObjectInvoker.SERVICE_IMPL_CLASS, DefaultContinuumWebService.class);
        sf = xfireFactory;
    }


    /**
     * Returns the instance of {@link ServiceFactory} that was used to create
     * and register the {@link Continuum} service.
     * 
     * @return
     */
    public static XFireFactory getXFireFactory() {
        if (null == sf)
            throw new IllegalStateException ("XFire Service Factory not yet initialized.");
        return sf;
    }

}
