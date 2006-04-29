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

import java.util.Hashtable;

import org.apache.maven.continuum.AbstractContinuumTest;
import org.apache.maven.continuum.Continuum;
import org.apache.maven.continuum.model.project.Project;
import org.apache.maven.continuum.model.project.ProjectGroup;
import org.apache.maven.continuum.store.ContinuumStore;

/**
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class ContinuumXFireWebServiceTest extends AbstractContinuumTest {

    /**
     * Webservice instance to test.
     */
    ContinuumWebService webService = null;


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.AbstractContinuumTest#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp ();
        webService = (ContinuumWebService) lookup (ContinuumWebService.ROLE);
        // FIXME: Assert that the obtained continuum service was not null.
        assertNotNull (webService);
    }


    public void testBasic() throws Exception {
        ContinuumStore store = (ContinuumStore) lookup (ContinuumStore.ROLE);

        Project project = makeStubProject ("My Project");

        ProjectGroup projectGroup = getDefaultProjectGroup ();

        projectGroup.addProject (project);

        store.updateProjectGroup (projectGroup);

        // ----------------------------------------------------------------------
        //
        // ----------------------------------------------------------------------

        Project p = webService.getProject (project.getId ());
        assertNotNull (p);

    }

}
