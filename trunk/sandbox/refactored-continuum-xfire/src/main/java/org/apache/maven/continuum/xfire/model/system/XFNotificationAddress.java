/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.system;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * Configures one method for notifying users/developers when a build breaks.
 * 
 * @version $Revision$ $Date$
 */
public class XFNotificationAddress implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field type
     */
    private String type = "mail";

    /**
     * Field address
     */
    private String address;

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
     * Get null
     */
    public String getAddress() {
        return this.address;
    } // -- String getAddress()


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
     * Get The mechanism used to deliver notifications.
     */
    public String getType() {
        return this.type;
    } // -- String getType()


    /**
     * Set null
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    } // -- void setAddress(String)


    /**
     * Set Extended configuration specific to this notifier goes here.
     * 
     * @param configuration
     */
    public void setConfiguration(java.util.Map configuration) {
        this.configuration = configuration;
    } // -- void setConfiguration(java.util.Map)


    /**
     * Set The mechanism used to deliver notifications.
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    } // -- void setType(String)

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
