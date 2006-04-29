/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import java.util.Collection;

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFProjectGroup implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field id
     */
    private int id = 0;

    /**
     * Field groupId
     */
    private String groupId;

    /**
     * Field name
     */
    private String name;

    /**
     * Field description
     */
    private String description;

    /**
     * Field projects
     */
    private java.util.List projects;

    /**
     * Field notifiers
     */
    private java.util.List notifiers;

    /**
     * Field buildDefinitions
     */
    private java.util.List buildDefinitions;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method addBuildDefinition
     * 
     * @param buildDefinition
     */
    public void addBuildDefinition(XFBuildDefinition buildDefinition) {
        getBuildDefinitions ().add (buildDefinition);
    } // -- void addBuildDefinition(BuildDefinition)


    /**
     * Method addNotifier
     * 
     * @param projectNotifier
     */
    public void addNotifier(XFProjectNotifier projectNotifier) {
        getNotifiers ().add (projectNotifier);
    } // -- void addNotifier(ProjectNotifier)


    /**
     * Method addProject
     * 
     * @param project
     */
    public void addProject(XFProject project) {
        getProjects ().add (project);
        project.createProjectGroupAssociation (this);
    } // -- void addProject(Project)


    /**
     * Method breakProjectAssociation
     * 
     * @param project
     */
    public void breakProjectAssociation(XFProject project) {
        if (!getProjects ().contains (project)) { throw new IllegalStateException ("project isn't associated."); }

        getProjects ().remove (project);
    } // -- void breakProjectAssociation(Project)


    /**
     * Method createProjectAssociation
     * 
     * @param project
     */
    public void createProjectAssociation(XFProject project) {
        Collection projects = getProjects ();

        if (getProjects ().contains (project)) { throw new IllegalStateException ("project is already assigned."); }

        projects.add (project);
    } // -- void createProjectAssociation(Project)


    /**
     * Method equals
     * 
     * @param other
     */
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (!(other instanceof XFProjectGroup)) { return false; }

        XFProjectGroup that = (XFProjectGroup) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Method getBuildDefinitions
     */
    public java.util.List getBuildDefinitions() {
        if (this.buildDefinitions == null) {
            this.buildDefinitions = new java.util.ArrayList ();
        }

        return this.buildDefinitions;
    } // -- java.util.List getBuildDefinitions()


    /**
     * Get null
     */
    public String getDescription() {
        return this.description;
    } // -- String getDescription()


    /**
     * Get null
     */
    public String getGroupId() {
        return this.groupId;
    } // -- String getGroupId()


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
     * Method getNotifiers
     */
    public java.util.List getNotifiers() {
        if (this.notifiers == null) {
            this.notifiers = new java.util.ArrayList ();
        }

        return this.notifiers;
    } // -- java.util.List getNotifiers()


    /**
     * Method getProjects
     */
    public java.util.List getProjects() {
        if (this.projects == null) {
            this.projects = new java.util.ArrayList ();
        }

        return this.projects;
    } // -- java.util.List getProjects()


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
     * Method removeBuildDefinition
     * 
     * @param buildDefinition
     */
    public void removeBuildDefinition(XFBuildDefinition buildDefinition) {
        getBuildDefinitions ().remove (buildDefinition);
    } // -- void removeBuildDefinition(BuildDefinition)


    /**
     * Method removeNotifier
     * 
     * @param projectNotifier
     */
    public void removeNotifier(XFProjectNotifier projectNotifier) {
        getNotifiers ().remove (projectNotifier);
    } // -- void removeNotifier(ProjectNotifier)


    /**
     * Method removeProject
     * 
     * @param project
     */
    public void removeProject(XFProject project) {
        project.breakProjectGroupAssociation (this);
        getProjects ().remove (project);
    } // -- void removeProject(Project)


    /**
     * Set null
     * 
     * @param buildDefinitions
     */
    public void setBuildDefinitions(java.util.List buildDefinitions) {
        this.buildDefinitions = buildDefinitions;
    } // -- void setBuildDefinitions(java.util.List)


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
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    } // -- void setGroupId(String)


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
     * Set null
     * 
     * @param notifiers
     */
    public void setNotifiers(java.util.List notifiers) {
        this.notifiers = notifiers;
    } // -- void setNotifiers(java.util.List)


    /**
     * Set null
     * 
     * @param projects
     */
    public void setProjects(java.util.List projects) {
        this.projects = projects;
    } // -- void setProjects(java.util.List)


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
