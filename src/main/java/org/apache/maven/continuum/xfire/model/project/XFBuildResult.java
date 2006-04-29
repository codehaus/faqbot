/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import org.apache.maven.continuum.model.scm.ScmResult;

/**
 * This class is a single continuum build.
 * 
 * @version $Revision$ $Date$
 */
public class XFBuildResult implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field project
     */
    private XFProject project;

    /**
     * Field id
     */
    private int id = 0;

    /**
     * Field buildNumber
     */
    private int buildNumber = 0;

    /**
     * Field state
     */
    private int state = 0;

    /**
     * Field trigger
     */
    private int trigger = 0;

    /**
     * Field startTime
     */
    private long startTime = 0;

    /**
     * Field endTime
     */
    private long endTime = 0;

    /**
     * Field error
     */
    private String error;

    /**
     * Field success
     */
    private boolean success = false;

    /**
     * Field exitCode
     */
    private int exitCode = 0;

    /**
     * Field scmResult
     */
    private ScmResult scmResult;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method breakProjectAssociation
     * 
     * @param project
     */
    public void breakProjectAssociation(XFProject project) {
        if (this.project != project) { throw new IllegalStateException ("project isn't associated."); }

        this.project = null;
    } // -- void breakProjectAssociation(Project)


    /**
     * Method createProjectAssociation
     * 
     * @param project
     */
    public void createProjectAssociation(XFProject project) {
        if (this.project != null) {
            breakProjectAssociation (this.project);
        }

        this.project = project;
    } // -- void createProjectAssociation(Project)


    /**
     * Method equals
     * 
     * @param other
     */
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (!(other instanceof XFBuildResult)) { return false; }

        XFBuildResult that = (XFBuildResult) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Get null
     */
    public int getBuildNumber() {
        return this.buildNumber;
    } // -- int getBuildNumber()


    /**
     * Get null
     */
    public long getEndTime() {
        return this.endTime;
    } // -- long getEndTime()


    /**
     * Get null
     */
    public String getError() {
        return this.error;
    } // -- String getError()


    /**
     * Get null
     */
    public int getExitCode() {
        return this.exitCode;
    } // -- int getExitCode()


    /**
     * Get null
     */
    public int getId() {
        return this.id;
    } // -- int getId()


    /**
     * Get null
     */
    public XFProject getProject() {
        return this.project;
    } // -- Project getProject()


    /**
     * Get null
     */
    public ScmResult getScmResult() {
        return this.scmResult;
    } // -- ScmResult getScmResult()


    /**
     * Get null
     */
    public long getStartTime() {
        return this.startTime;
    } // -- long getStartTime()


    /**
     * Get null
     */
    public int getState() {
        return this.state;
    } // -- int getState()


    /**
     * Get null
     */
    public int getTrigger() {
        return this.trigger;
    } // -- int getTrigger()


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
    public boolean isSuccess() {
        return this.success;
    } // -- boolean isSuccess()


    /**
     * Set null
     * 
     * @param buildNumber
     */
    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    } // -- void setBuildNumber(int)


    /**
     * Set null
     * 
     * @param endTime
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    } // -- void setEndTime(long)


    /**
     * Set null
     * 
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    } // -- void setError(String)


    /**
     * Set null
     * 
     * @param exitCode
     */
    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    } // -- void setExitCode(int)


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
     * @param project
     */
    public void setProject(XFProject project) {
        if (this.project != null) {
            this.project.breakBuildResultAssociation (this);
        }

        this.project = project;

        if (project != null) {
            this.project.createBuildResultAssociation (this);
        }
    } // -- void setProject(Project)


    /**
     * Set null
     * 
     * @param scmResult
     */
    public void setScmResult(ScmResult scmResult) {
        this.scmResult = scmResult;
    } // -- void setScmResult(ScmResult)


    /**
     * Set null
     * 
     * @param startTime
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    } // -- void setStartTime(long)


    /**
     * Set null
     * 
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    } // -- void setState(int)


    /**
     * Set null
     * 
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    } // -- void setSuccess(boolean)


    /**
     * Set null
     * 
     * @param trigger
     */
    public void setTrigger(int trigger) {
        this.trigger = trigger;
    } // -- void setTrigger(int)


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
