/**
 *    Copyright 2006  <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.continuum.plugin.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.continuum.plugin.model.ConnectionProfile;
import org.eclipse.core.runtime.IPath;

/**
 * Continuum's Connection profile manager.
 * <p>
 * This should handle:<br>
 * <ul>
 * <li>Loading up already created Connection Profiles</li>
 * <li>Create and save new/existing Connection Profiles</li>
 * </ul>
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class ConnectionProfileManager {

    private static final String DATA_PROFILES = "ContinuumProfiles.dat";

    private static IPath storageLocation = null;


    public static IPath getStorageLocation() {
        return storageLocation;
    }


    public static void setStorageLocation(IPath storageLocation) {
        ConnectionProfileManager.storageLocation = storageLocation;
    }


    /**
     * Loads up all the Continuum Connection profiles from the specified file.
     * 
     * @return
     */
    public List<ConnectionProfile> loadConnectionProfiles(File f) {
        List<ConnectionProfile> list = new ArrayList<ConnectionProfile> ();

        // TODO: load Continuum Connection profiles.

        return list;
    }

}
