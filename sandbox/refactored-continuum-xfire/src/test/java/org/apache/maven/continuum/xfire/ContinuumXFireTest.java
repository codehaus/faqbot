package org.apache.maven.continuum.xfire;

/*
 * Copyright 2004-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.continuum.AbstractContinuumTest;
import org.apache.maven.continuum.Continuum;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;

/**
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class ContinuumXFireTest extends AbstractContinuumTest {

    /**
     * Webservice instance to test.
     */
    Continuum webService = null;


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.AbstractContinuumTest#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp ();
        Continuum continuum = (Continuum) lookup (Continuum.ROLE);
        ContinuumXFireServiceFactory.makeContinuumWebService ();
        Service service = XFireFactory.newInstance ().getXFire ().getServiceRegistry ().getService (ContinuumXFireServiceFactory.CONTINUUM_SERVICE_NAME);
        // Feels like a hack, is there a better way of doing this?
        DefaultContinuumWebService ws = (DefaultContinuumWebService) new XFireProxyFactory ().create (service, ContinuumXFireServiceFactory.CONTINUUM_SERVICE_URL);
        ws.setContinuum (continuum);
        webService = ws;
    }


    public void testGetConfigurationService() {
    // assertNotNull (webService);
    // ConfigurationService cs = this.webService.getConfiguration ();
    // assertNotNull (cs);
    // System.out.print (cs.getUrl ());
    }

}
