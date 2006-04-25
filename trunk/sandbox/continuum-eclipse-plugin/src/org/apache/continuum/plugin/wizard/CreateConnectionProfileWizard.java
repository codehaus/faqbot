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

import org.eclipse.jface.viewers.IStructuredSelection;
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
     * Wizard Page that captures data to create a Connection Profile.
     */
    private WizardPage connectionProfilePage = null;


    public void init(IWorkbench workbench, IStructuredSelection selection) {
    // TODO Auto-generated method stub

    }


    public void addPages() {
        super.addPages ();
        this.connectionProfilePage = new ConnectionProfilePage ("Create Continuum Connection Profile");
        addPage (this.connectionProfilePage);
    }


    public boolean performFinish() {
        // Save the Connection Profile here
        return true;
    }

}
