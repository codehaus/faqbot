/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * Schedule for a project.
 * 
 * @version $Revision$ $Date$
 */
public class XFSchedule implements java.io.Serializable {

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
     * Field delay
     */
    private int delay = 0;

    /**
     * Field cronExpression
     */
    private String cronExpression;


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

        if (!(other instanceof XFSchedule)) { return false; }

        XFSchedule that = (XFSchedule) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Get null
     */
    public String getCronExpression() {
        return this.cronExpression;
    } // -- String getCronExpression()


    /**
     * Get Delay in seconds.
     */
    public int getDelay() {
        return this.delay;
    } // -- int getDelay()


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
    public String getName() {
        return this.name;
    } // -- String getName()


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
     * @param cronExpression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    } // -- void setCronExpression(String)


    /**
     * Set Delay in seconds.
     * 
     * @param delay
     */
    public void setDelay(int delay) {
        this.delay = delay;
    } // -- void setDelay(int)


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
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    } // -- void setName(String)


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
