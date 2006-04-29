/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import org.apache.maven.continuum.model.system.Installation;

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFProfile implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field id
     */
    private int id = 0;

    /**
     * Field active
     */
    private boolean active = false;

    /**
     * Field name
     */
    private String name;

    /**
     * Field description
     */
    private String description;

    /**
     * Field scmMode
     */
    private int scmMode = 0;

    /**
     * Field buildWithoutChanges
     */
    private boolean buildWithoutChanges = false;

    /**
     * Field jdk
     */
    private Installation jdk;

    /**
     * Field builder
     */
    private Installation builder;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method equals
     * 
     * @param other
     */
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (!(other instanceof XFProfile)) { return false; }

        XFProfile that = (XFProfile) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Get null
     */
    public Installation getBuilder() {
        return this.builder;
    } // -- Installation getBuilder()


    /**
     * Get null
     */
    public String getDescription() {
        return this.description;
    } // -- String getDescription()


    /**
     * Get null
     */
    public int getId() {
        return this.id;
    } // -- int getId()


    /**
     * Get null
     */
    public Installation getJdk() {
        return this.jdk;
    } // -- Installation getJdk()


    /**
     * Get null
     */
    public String getName() {
        return this.name;
    } // -- String getName()


    /**
     * Get null
     */
    public int getScmMode() {
        return this.scmMode;
    } // -- int getScmMode()


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
    public boolean isActive() {
        return this.active;
    } // -- boolean isActive()


    /**
     * Get null
     */
    public boolean isBuildWithoutChanges() {
        return this.buildWithoutChanges;
    } // -- boolean isBuildWithoutChanges()


    /**
     * Set null
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    } // -- void setActive(boolean)


    /**
     * Set null
     * 
     * @param buildWithoutChanges
     */
    public void setBuildWithoutChanges(boolean buildWithoutChanges) {
        this.buildWithoutChanges = buildWithoutChanges;
    } // -- void setBuildWithoutChanges(boolean)


    /**
     * Set null
     * 
     * @param builder
     */
    public void setBuilder(Installation builder) {
        this.builder = builder;
    } // -- void setBuilder(Installation)


    /**
     * Set null
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    } // -- void setDescription(String)


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
     * @param jdk
     */
    public void setJdk(Installation jdk) {
        this.jdk = jdk;
    } // -- void setJdk(Installation)


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
     * @param scmMode
     */
    public void setScmMode(int scmMode) {
        this.scmMode = scmMode;
    } // -- void setScmMode(int)


    /**
     * Method toString
     */
    public java.lang.String toString() {
        StringBuffer buf = new StringBuffer ();
        buf.append ("id = '");
        buf.append (getId () + "'");
        return buf.toString ();
    } // -- java.lang.String toString()

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
