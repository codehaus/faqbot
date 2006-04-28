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
public class XFChangeFile implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field name
     */
    private String name;

    /**
     * Field revision
     */
    private String revision;

    /**
     * Field status
     */
    private String status;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Get null
     */
    public String getName() {
        return this.name;
    } // -- String getName()


    /**
     * Get null
     */
    public String getRevision() {
        return this.revision;
    } // -- String getRevision()


    /**
     * Get null
     */
    public String getStatus() {
        return this.status;
    } // -- String getStatus()


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
     * @param revision
     */
    public void setRevision(String revision) {
        this.revision = revision;
    } // -- void setRevision(String)


    /**
     * Set null
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    } // -- void setStatus(String)


    /**
     * Provide a version of the object as a string for debugging purposes
     * 
     * @return a {@link String}made up of the properties of the object
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer (getName ());

        if (getRevision () != null) {
            buffer.append (", ").append (getRevision ());
        }

        return buffer.toString ();
    }

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
