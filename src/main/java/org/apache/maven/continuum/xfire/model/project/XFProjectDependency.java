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
public class XFProjectDependency implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field groupId
     */
    private String groupId;

    /**
     * Field artifactId
     */
    private String artifactId;

    /**
     * Field version
     */
    private String version;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Get null
     */
    public String getArtifactId() {
        return this.artifactId;
    } // -- String getArtifactId()


    /**
     * Get null
     */
    public String getGroupId() {
        return this.groupId;
    } // -- String getGroupId()


    /**
     * Get null
     */
    public String getVersion() {
        return this.version;
    } // -- String getVersion()


    /**
     * Set null
     * 
     * @param artifactId
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    } // -- void setArtifactId(String)


    /**
     * Set null
     * 
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    } // -- void setGroupId(String)


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
