/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.system;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFInstallation implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field version
     */
    private String version;

    /**
     * Field path
     */
    private String path;

    /**
     * Field name
     */
    private String name;


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
    public String getPath() {
        return this.path;
    } // -- String getPath()


    /**
     * Get null
     */
    public String getVersion() {
        return this.version;
    } // -- String getVersion()


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
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    } // -- void setPath(String)


    /**
     * Set null
     * 
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    } // -- void setVersion(String)

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
