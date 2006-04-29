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
public class XFBuildDefinition implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field id
     */
    private int id = 0;

    /**
     * Field defaultForProject
     */
    private boolean defaultForProject = false;

    /**
     * Field goals
     */
    private String goals;

    /**
     * Field arguments
     */
    private String arguments;

    /**
     * Field buildFile
     */
    private String buildFile;

    /**
     * Field schedule
     */
    private XFSchedule schedule;

    /**
     * Field profile
     */
    private XFProfile profile;

    /**
     * Field latestBuildId
     */
    private int latestBuildId = 0;


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

        if (!(other instanceof XFBuildDefinition)) { return false; }

        XFBuildDefinition that = (XFBuildDefinition) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Get null
     */
    public String getArguments() {
        return this.arguments;
    } // -- String getArguments()


    /**
     * Get null
     */
    public String getBuildFile() {
        return this.buildFile;
    } // -- String getBuildFile()


    /**
     * Get null
     */
    public String getGoals() {
        return this.goals;
    } // -- String getGoals()


    /**
     * Get null
     */
    public int getId() {
        return this.id;
    } // -- int getId()


    /**
     * Get null
     */
    public int getLatestBuildId() {
        return this.latestBuildId;
    } // -- int getLatestBuildId()


    /**
     * Get null
     */
    public XFProfile getProfile() {
        return this.profile;
    } // -- Profile getProfile()


    /**
     * Get null
     */
    public XFSchedule getSchedule() {
        return this.schedule;
    } // -- Schedule getSchedule()


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
    public boolean isDefaultForProject() {
        return this.defaultForProject;
    } // -- boolean isDefaultForProject()


    /**
     * Set null
     * 
     * @param arguments
     */
    public void setArguments(String arguments) {
        this.arguments = arguments;
    } // -- void setArguments(String)


    /**
     * Set null
     * 
     * @param buildFile
     */
    public void setBuildFile(String buildFile) {
        this.buildFile = buildFile;
    } // -- void setBuildFile(String)


    /**
     * Set null
     * 
     * @param defaultForProject
     */
    public void setDefaultForProject(boolean defaultForProject) {
        this.defaultForProject = defaultForProject;
    } // -- void setDefaultForProject(boolean)


    /**
     * Set null
     * 
     * @param goals
     */
    public void setGoals(String goals) {
        this.goals = goals;
    } // -- void setGoals(String)


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
     * @param latestBuildId
     */
    public void setLatestBuildId(int latestBuildId) {
        this.latestBuildId = latestBuildId;
    } // -- void setLatestBuildId(int)


    /**
     * Set null
     * 
     * @param profile
     */
    public void setProfile(XFProfile profile) {
        this.profile = profile;
    } // -- void setProfile(Profile)


    /**
     * Set null
     * 
     * @param schedule
     */
    public void setSchedule(XFSchedule schedule) {
        this.schedule = schedule;
    } // -- void setSchedule(Schedule)


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
