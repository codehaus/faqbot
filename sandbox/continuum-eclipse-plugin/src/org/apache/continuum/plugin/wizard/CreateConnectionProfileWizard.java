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
package org.apache.continuum.plugin.wizard;

import java.util.List;

import org.apache.continuum.plugin.Activator;
import org.apache.continuum.plugin.internal.ConnectionProfileManager;
import org.apache.continuum.plugin.model.ConnectionProfileData;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard to connection to a remote Continuum server and create a Connection
 * Profile.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class CreateConnectionProfileWizard extends Wizard implements INewWizard {

    /**
     * Key under which the Continuum connection settings are captured by the
     * wizard.
     */
    private static final String DIALOG_SETTINGS_KEY = "ContinuumConnectionSettings";

    /**
     * Wizard Page that captures data to create a Connection Profile.
     */
    private WizardPage connectionProfilePage = null;

    /**
     * Model class that holds the Continuum Connection Profile.
     */
    private ConnectionProfileData connectionProfileData;

    private static List<ConnectionProfileData> existingConnectionProfiles = null;

    static {
        try {
            existingConnectionProfiles = ConnectionProfileManager.loadConnectionProfiles ();
        } catch (CoreException e) {
            Activator.getDefault ().getLog ().log (new Status (IStatus.ERROR, Activator.PLUGIN_ID, -1, "Unable to load Continuum Connection Profiles.", e));
        }
    }

    /**
     * Determines if connection profiles settings available with the Connection
     * wizard are new or old.
     * <p>
     * Has a value <code>false</code> if settings obtained are not-NULL, that
     * is <em>not new</em>.
     */
    private boolean newConnectionSettings;


    /**
     * Setup an instance of a create connection wizard.
     * <p>
     * We obtain the dialog settings for our plug-in in context of current
     * workbench.
     */
    public CreateConnectionProfileWizard() {
        super ();
        // Obtain the settings for our plug-in that hold persistent state data.
        IDialogSettings wbSettings = Activator.getDefault ().getDialogSettings ();
        // obtain section specific to continuum settings
        IDialogSettings section = wbSettings.getSection (DIALOG_SETTINGS_KEY);
        if (null != section) {
            newConnectionSettings = false;
        } else {
            newConnectionSettings = true;
            setDialogSettings (section);
        }
    }


    public void init(IWorkbench workbench, IStructuredSelection selection) {
        connectionProfileData = new ConnectionProfileData ();
        setWindowTitle ("Create New Continuumm Connection");
        // we need a progress monitor if the wizard will attempt to connect to
        // the specified Continuum Server.
        // TODO: We could make this optional by having an checkbox option like
        // 'validate connection on finish' similar to CVS repo setup wizard.
        setNeedsProgressMonitor (false);
    }


    @Override
    public void addPages() {
        super.addPages ();
        connectionProfilePage = new ConnectionProfilePage ("Create Continuum Connection Profile", connectionProfileData);
        addPage (connectionProfilePage);
    }


    @Override
    public boolean performFinish() {
        // delegate to wrapped up pages to finish off.
        IWizardPage [] pages = getPages ();
        for (int i = 0; i < getPageCount (); i++) {
            IWizardPage page = pages[i];
            if (page instanceof ConnectionProfilePage) {
                // we allow the wizard to finish only if the user supplied
                // validated values.
                ConnectionProfilePage cpPage = ((ConnectionProfilePage) page);
                if (cpPage.validate ())
                    cpPage.finish ();
                else {
                    MessageDialog.openError (getShell (), "Error", "Missing form fields.");
                    return false;
                }
            }
        }

        if (existingConnectionProfiles.contains (connectionProfileData)) {
            // TODO: Implement a check if a profile with same name exists. Need
            // to override equals().
            MessageDialog.openError (getShell (), "Error", "Profile with name '" + connectionProfileData.getLabel () + "' already exists.");
        }

        Activator.getDefault ().getLog ().log (new Status (IStatus.INFO, Activator.PLUGIN_ID, 0, "Saving Connection profile: " + connectionProfileData.getLabel (), null));
        // TODO: Run a create profile operation here
        try {
            ConnectionProfileManager.saveConnectionProfile (connectionProfileData);
        } catch (CoreException e) {
            MessageDialog.openError (getShell (), "Error", e.getCause ().getMessage ());
        }

        return true;
    }

}
