/**
 * 
 */
package org.apache.maven.continuum.xfire;

import java.io.File;

import org.codehaus.xfire.plexus.PlexusXFireTest;
import org.codehaus.xfire.plexus.config.ConfigurationService;
import org.codehaus.xfire.service.Service;

/**
 * Test the sanity of the XFire Service setup.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class XFireSetupTest extends PlexusXFireTest {

    public void setUp() throws Exception {
        System.setProperty ("xfire.config", "/org/apache/maven/continuum/xfire/services/services.xml");
        super.setUp ();
        lookup (ConfigurationService.ROLE);
    }


    /**
     * Test that the service was registered and can be obtained.
     * 
     * @throws Exception
     */
    public void testRegister() throws Exception {
        Service service = getServiceRegistry ().getService (ContinuumXFireServiceFactory.CONTINUUM_SERVICE_NAME);
        assertNotNull (service);
    }
}
