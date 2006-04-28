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
import org.codehaus.plexus.taskqueue.TaskQueue;
import org.codehaus.plexus.taskqueue.execution.TaskQueueExecutor;

/**
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class ContinuumXFireTest extends AbstractContinuumTest {

    public void testContinuumConfiguration() throws Exception {
        lookup (Continuum.ROLE);
    }


    public void testLookups() throws Exception {
        Object o = lookup (TaskQueue.ROLE, "build-project");
        assertNotNull (o);

        o = lookup (TaskQueue.ROLE, "check-out-project");
        assertNotNull (o);

        o = lookup (TaskQueueExecutor.ROLE, "build-project");
        assertNotNull (o);

        o = lookup (TaskQueueExecutor.ROLE, "check-out-project");
        assertNotNull (o);
    }

}