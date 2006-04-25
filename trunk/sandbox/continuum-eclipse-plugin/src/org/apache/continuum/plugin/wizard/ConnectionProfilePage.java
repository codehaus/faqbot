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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class ConnectionProfilePage extends WizardPage {

    /**
     * Toolkit reponsible for adapting SWT control behaviour to work in Eclipse
     * Forms.
     */
    private FormToolkit toolkit;

    /**
     * ScrolledForm is a control that is capable of scrolling an instance of the
     * Form class.
     */
    private ScrolledForm form;


    protected ConnectionProfilePage(String pageName) {
        super (pageName);
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent) {
        this.toolkit = new FormToolkit (parent.getDisplay ());
        this.form = this.toolkit.createScrolledForm (parent);
        this.form.setText ("Create new Continuum Connection");

        // layout elements of the form here
        GridLayout layout = new GridLayout ();
        form.getBody ().setLayout (layout);
        Hyperlink link = this.toolkit.createHyperlink (form.getBody (), "Click here to see how to use this wizard", SWT.WRAP);
        link.addHyperlinkListener (new HyperlinkAdapter () {

            public void linkActivated(HyperlinkEvent e) {
                MessageDialog.openInformation (form.getBody ().getShell (), "Not yet implemented", "Help text is not available yet!");
            }

        });
        layout.numColumns = 2;
        GridData gData = new GridData ();
        gData.horizontalSpan = 2;
        link.setLayoutData (gData);

        Label labelCPName = this.toolkit.createLabel (form.getBody (), "Profile Name: ");
        Text txtboxCPName = this.toolkit.createText (form.getBody (), "");
        txtboxCPName.setLayoutData (new GridData (GridData.FILL_HORIZONTAL));
        // provide 'hint' for textbox border rendering.
        txtboxCPName.setData (FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);

        Label labelConnectionUrl = this.toolkit.createLabel (form.getBody (), "Server URL:");
        Text txtboxConnectionURL = this.toolkit.createText (form.getBody (), "");
        txtboxConnectionURL.setLayoutData (new GridData (GridData.FILL_HORIZONTAL));
        txtboxConnectionURL.setData (FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);

        Label labelUsername = this.toolkit.createLabel (form.getBody (), "Username:");
        Text txtboxUsername = this.toolkit.createText (form.getBody (), "");
        txtboxUsername.setLayoutData (new GridData (GridData.FILL_HORIZONTAL));
        txtboxUsername.setData (FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);

        Label labelPassword = this.toolkit.createLabel (form.getBody (), "Password:");
        Text txtboxPassword = this.toolkit.createText (form.getBody (), "", SWT.PASSWORD);
        txtboxPassword.setLayoutData (new GridData (GridData.FILL_HORIZONTAL));
        txtboxPassword.setData (FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);

        // Button button = toolkit.createButton (form.getBody (), "Create
        // Connection", SWT.NO_BACKGROUND);
        // gData = new GridData ();
        // gData.horizontalSpan = 2;
        // button.setLayoutData (gData);

        this.toolkit.paintBordersFor (form.getBody ());
        setControl (parent);
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
     */
    public void setFocus() {
        this.form.setFocus ();
    }


    /**
     * Cleanup!
     */
    public void dispose() {
        this.toolkit.dispose ();
        super.dispose ();
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.DialogPage#getControl()
     */
    @Override
    public Control getControl() {
        return super.getControl ();
    }

}
