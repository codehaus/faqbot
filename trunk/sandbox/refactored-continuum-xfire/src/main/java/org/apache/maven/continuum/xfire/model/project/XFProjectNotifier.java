/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * Configures one method for notifying users/developers when a build breaks.
 * 
 * @version $Revision$ $Date$
 */
public class XFProjectNotifier implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field id
     */
    private int id = 0;

    /**
     * Field type
     */
    private String type = "mail";

    /**
     * Field from
     */
    private int from = 0;

    /**
     * Field enabled
     */
    private boolean enabled = true;

    /**
     * Field recipientType
     */
    private int recipientType = 0;

    /**
     * Field sendOnSuccess
     */
    private boolean sendOnSuccess = true;

    /**
     * Field sendOnFailure
     */
    private boolean sendOnFailure = true;

    /**
     * Field sendOnError
     */
    private boolean sendOnError = true;

    /**
     * Field sendOnWarning
     */
    private boolean sendOnWarning = true;

    /**
     * Field configuration
     */
    private java.util.Map configuration;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method addConfiguration
     * 
     * @param key
     * @param value
     */
    public void addConfiguration(Object key, String value) {
        getConfiguration ().put (key, value);
    } // -- void addConfiguration(Object, String)


    /**
     * Method equals
     * 
     * @param other
     */
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (!(other instanceof XFProjectNotifier)) { return false; }

        XFProjectNotifier that = (XFProjectNotifier) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Method getConfiguration
     */
    public java.util.Map getConfiguration() {
        if (this.configuration == null) {
            this.configuration = new java.util.HashMap ();
        }

        return this.configuration;
    } // -- java.util.Map getConfiguration()


    /**
     * Get The origin of the notifier (pom or user).
     */
    public int getFrom() {
        return this.from;
    } // -- int getFrom()


    /**
     * Get null
     */
    public int getId() {
        return this.id;
    } // -- int getId()


    /**
     * Get null
     */
    public int getRecipientType() {
        return this.recipientType;
    } // -- int getRecipientType()


    /**
     * Get The mechanism used to deliver notifications.
     */
    public String getType() {
        return this.type;
    } // -- String getType()


    /**
     * Method hashCode
     */
    public int hashCode() {
        int result = 17;
        long tmp;
        result = 37 * result + (int) id;
        return result;
    } // -- int hashCode()


    /**
     * Get null
     */
    public boolean isEnabled() {
        return this.enabled;
    } // -- boolean isEnabled()


    /**
     * Get null
     */
    public boolean isSendOnError() {
        return this.sendOnError;
    } // -- boolean isSendOnError()


    /**
     * Get null
     */
    public boolean isSendOnFailure() {
        return this.sendOnFailure;
    } // -- boolean isSendOnFailure()


    /**
     * Get null
     */
    public boolean isSendOnSuccess() {
        return this.sendOnSuccess;
    } // -- boolean isSendOnSuccess()


    /**
     * Get null
     */
    public boolean isSendOnWarning() {
        return this.sendOnWarning;
    } // -- boolean isSendOnWarning()


    /**
     * Set Extended configuration specific to this notifier goes here.
     * 
     * @param configuration
     */
    public void setConfiguration(java.util.Map configuration) {
        this.configuration = configuration;
    } // -- void setConfiguration(java.util.Map)


    /**
     * Set null
     * 
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    } // -- void setEnabled(boolean)


    /**
     * Set The origin of the notifier (pom or user).
     * 
     * @param from
     */
    public void setFrom(int from) {
        this.from = from;
    } // -- void setFrom(int)


    /**
     * Set null
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    } // -- void setId(int)


    /**
     * Set null
     * 
     * @param recipientType
     */
    public void setRecipientType(int recipientType) {
        this.recipientType = recipientType;
    } // -- void setRecipientType(int)


    /**
     * Set null
     * 
     * @param sendOnError
     */
    public void setSendOnError(boolean sendOnError) {
        this.sendOnError = sendOnError;
    } // -- void setSendOnError(boolean)


    /**
     * Set null
     * 
     * @param sendOnFailure
     */
    public void setSendOnFailure(boolean sendOnFailure) {
        this.sendOnFailure = sendOnFailure;
    } // -- void setSendOnFailure(boolean)


    /**
     * Set null
     * 
     * @param sendOnSuccess
     */
    public void setSendOnSuccess(boolean sendOnSuccess) {
        this.sendOnSuccess = sendOnSuccess;
    } // -- void setSendOnSuccess(boolean)


    /**
     * Set null
     * 
     * @param sendOnWarning
     */
    public void setSendOnWarning(boolean sendOnWarning) {
        this.sendOnWarning = sendOnWarning;
    } // -- void setSendOnWarning(boolean)


    /**
     * Set The mechanism used to deliver notifications.
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    } // -- void setType(String)


    /**
     * Method toString
     */
    public java.lang.String toString() {
        StringBuffer buf = new StringBuffer ();
        buf.append ("id = '");
        buf.append (getId () + "'");
        return buf.toString ();
    } // -- java.lang.String toString()

    public static final int FROM_PROJECT = 1;

    public static final int FROM_USER = 2;


    public boolean isFromProject() {
        return from == FROM_PROJECT;
    }


    public boolean isFromUser() {
        return from == FROM_USER;
    }

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
