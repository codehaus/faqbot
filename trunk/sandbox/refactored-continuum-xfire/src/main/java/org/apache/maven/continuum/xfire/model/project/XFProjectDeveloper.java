/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFProjectDeveloper implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field scmId
     */
    private String scmId;

    /**
     * Field name
     */
    private String name;

    /**
     * Field email
     */
    private String email;

    /**
     * Field continuumId
     */
    private int continuumId = 0;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Get null
     */
    public int getContinuumId() {
        return this.continuumId;
    } // -- int getContinuumId()


    /**
     * Get null
     */
    public String getEmail() {
        return this.email;
    } // -- String getEmail()


    /**
     * Get null
     */
    public String getName() {
        return this.name;
    } // -- String getName()


    /**
     * Get null
     */
    public String getScmId() {
        return this.scmId;
    } // -- String getScmId()


    /**
     * Set null
     * 
     * @param continuumId
     */
    public void setContinuumId(int continuumId) {
        this.continuumId = continuumId;
    } // -- void setContinuumId(int)


    /**
     * Set null
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    } // -- void setEmail(String)


    /**
     * Set null
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    } // -- void setName(String)


    /**
     * Set null
     * 
     * @param scmId
     */
    public void setScmId(String scmId) {
        this.scmId = scmId;
    } // -- void setScmId(String)

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
