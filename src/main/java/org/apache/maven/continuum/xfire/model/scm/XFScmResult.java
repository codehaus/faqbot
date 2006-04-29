/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.scm;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFScmResult implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field success
     */
    private boolean success = false;

    /**
     * Field commandLine
     */
    private String commandLine;

    /**
     * Field providerMessage
     */
    private String providerMessage;

    /**
     * Field commandOutput
     */
    private String commandOutput;

    /**
     * Field exception
     */
    private String exception;

    /**
     * Field changes
     */
    private java.util.List changes;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method addChange
     * 
     * @param changeSet
     */
    public void addChange(XFChangeSet changeSet) {
        getChanges ().add (changeSet);
    } // -- void addChange(ChangeSet)


    /**
     * Method getChanges
     */
    public java.util.List getChanges() {
        if (this.changes == null) {
            this.changes = new java.util.ArrayList ();
        }

        return this.changes;
    } // -- java.util.List getChanges()


    /**
     * Get null
     */
    public String getCommandLine() {
        return this.commandLine;
    } // -- String getCommandLine()


    /**
     * Get null
     */
    public String getCommandOutput() {
        return this.commandOutput;
    } // -- String getCommandOutput()


    /**
     * Get null
     */
    public String getException() {
        return this.exception;
    } // -- String getException()


    /**
     * Get null
     */
    public String getProviderMessage() {
        return this.providerMessage;
    } // -- String getProviderMessage()


    /**
     * Get null
     */
    public boolean isSuccess() {
        return this.success;
    } // -- boolean isSuccess()


    /**
     * Method removeChange
     * 
     * @param changeSet
     */
    public void removeChange(XFChangeSet changeSet) {
        getChanges ().remove (changeSet);
    } // -- void removeChange(ChangeSet)


    /**
     * Set null
     * 
     * @param changes
     */
    public void setChanges(java.util.List changes) {
        this.changes = changes;
    } // -- void setChanges(java.util.List)


    /**
     * Set null
     * 
     * @param commandLine
     */
    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    } // -- void setCommandLine(String)


    /**
     * Set null
     * 
     * @param commandOutput
     */
    public void setCommandOutput(String commandOutput) {
        this.commandOutput = commandOutput;
    } // -- void setCommandOutput(String)


    /**
     * Set null
     * 
     * @param exception
     */
    public void setException(String exception) {
        this.exception = exception;
    } // -- void setException(String)


    /**
     * Set null
     * 
     * @param providerMessage
     */
    public void setProviderMessage(String providerMessage) {
        this.providerMessage = providerMessage;
    } // -- void setProviderMessage(String)


    /**
     * Set null
     * 
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    } // -- void setSuccess(boolean)

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
