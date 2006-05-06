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

import org.apache.continuum.plugin.model.ConnectionProfileData;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * WizardPage implementation that captures the information from the user
 * required to create a Continuum Connection Profile.
 * <p>
 * TODO: Review access on setters.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 * @since 1.0
 */
public class ConnectionProfilePage extends WizardPage {

    /**
     * Data model that holds Connection Profile preferences.
     */
    private ConnectionProfileData connectionProfileData;

    private Text profileName;

    private Text serverLocation;

    private Text username;

    private Text password;


    protected ConnectionProfilePage(String pageName, ConnectionProfileData connectionProfileData) {
        super (pageName);
        this.connectionProfileData = connectionProfileData;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent) {
        FormLayout layout = new FormLayout ();

        Composite container = new Composite (parent, SWT.NULL);
        container.setLayout (layout);

        FormData data = new FormData ();
        data.top = new FormAttachment (10, 10);
        data.width = 100;
        Label label = new Label (container, SWT.NULL);
        label.setText ("Profile Name: ");
        label.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (10, 10);
        data.left = new FormAttachment (label, 10);
        data.width = 300;
        this.profileName = new Text (container, SWT.BORDER);
        this.profileName.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (this.profileName, 10);
        data.width = 100;
        label = new Label (container, SWT.NULL);
        label.setText ("Server Location: ");
        label.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (this.profileName, 10);
        data.left = new FormAttachment (label, 10);
        data.width = 300;
        this.serverLocation = new Text (container, SWT.BORDER);
        this.serverLocation.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (this.serverLocation, 10);
        data.width = 100;
        label = new Label (container, SWT.NULL);
        label.setText ("Username: ");
        label.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (this.serverLocation, 10);
        data.left = new FormAttachment (label, 10);
        data.width = 300;
        this.username = new Text (container, SWT.BORDER);
        this.username.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (this.username, 10);
        data.width = 100;
        label = new Label (container, SWT.NULL);
        label.setText ("Password: ");
        label.setLayoutData (data);

        data = new FormData ();
        data.top = new FormAttachment (this.username, 10);
        data.left = new FormAttachment (label, 10);
        data.width = 300;
        this.password = new Text (container, SWT.BORDER | SWT.PASSWORD);
        this.password.setLayoutData (data);

        setControl (container);
    }


    /**
     * Cleanup!
     */
    @Override
    public void dispose() {
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


    /**
     * This is called when the wizard finishes off walking-thru the user.
     */
    public void finish() {
        // populate the connection profile model
        this.connectionProfileData.setId (getProfileName ());
        this.connectionProfileData.setLabel (getProfileName ());
        this.connectionProfileData.setConnectionUrl (getServerLocation ());
        this.connectionProfileData.setUsername (getUsername ());
        this.connectionProfileData.setPassword (getPassword ());
    }


    /**
     * @return the connectionProfileData
     */
    public ConnectionProfileData getConnectionProfileData() {
        return this.connectionProfileData;
    }


    /**
     * @param connectionProfileData
     *            the connectionProfileData to set
     * @deprecated <em>Experimental</em>
     */
    @Deprecated
    public void setConnectionProfileData(ConnectionProfileData connectionProfileData) {
        this.connectionProfileData = connectionProfileData;
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return this.password.getText ();
    }


    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String v) {
        this.password.setText (v);
    }


    /**
     * @return the profileName
     */
    public String getProfileName() {
        return this.profileName.getText ();
    }


    /**
     * @param v
     *            the profileName to set
     */
    public void setProfileName(String v) {
        this.profileName.setText (v);
    }


    /**
     * @return the serverLocation
     */
    public String getServerLocation() {
        return this.serverLocation.getText ();
    }


    /**
     * @param v
     *            the serverLocation to set
     */
    public void setServerLocation(String v) {
        this.serverLocation.setText (v);
    }


    /**
     * @return the username
     */
    public String getUsername() {
        return this.username.getText ();
    }


    /**
     * @param v
     *            the username to set
     */
    public void setUsername(String v) {
        this.username.setText (v);
    }

}
