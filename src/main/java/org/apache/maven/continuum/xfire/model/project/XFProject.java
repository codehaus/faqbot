/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.project;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

import java.util.Collection;

import org.apache.maven.continuum.model.scm.ScmResult;

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFProject implements java.io.Serializable {

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
     * Field artifactId
     */
    private String artifactId;

    /**
     * Field executorId
     */
    private String executorId;

    /**
     * Field name
     */
    private String name;

    /**
     * Field description
     */
    private String description;

    /**
     * Field url
     */
    private String url;

    /**
     * Field scmUrl
     */
    private String scmUrl;

    /**
     * Field scmTag
     */
    private String scmTag;

    /**
     * Field scmUsername
     */
    private String scmUsername;

    /**
     * Field scmPassword
     */
    private String scmPassword;

    /**
     * Field version
     */
    private String version;

    /**
     * Field state
     */
    private int state = 1;

    /**
     * Field oldState
     */
    private int oldState = 0;

    /**
     * Field latestBuildId
     */
    private int latestBuildId = 0;

    /**
     * Field buildNumber
     */
    private int buildNumber = 0;

    /**
     * Field workingDirectory
     */
    private String workingDirectory;

    /**
     * Field buildResults
     */
    private java.util.List buildResults;

    /**
     * Field checkoutResult
     */
    private ScmResult checkoutResult;

    /**
     * Field developers
     */
    private java.util.List developers;

    /**
     * Field parent
     */
    private XFProjectDependency parent;

    /**
     * Field dependencies
     */
    private java.util.List dependencies;

    /**
     * Field projectGroup
     */
    private XFProjectGroup projectGroup;

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
     * Method addBuildResult
     * 
     * @param buildResult
     */
    public void addBuildResult(XFBuildResult buildResult) {
        getBuildResults ().add (buildResult);
        buildResult.createProjectAssociation (this);
    } // -- void addBuildResult(BuildResult)


    /**
     * Method addDependency
     * 
     * @param projectDependency
     */
    public void addDependency(XFProjectDependency projectDependency) {
        getDependencies ().add (projectDependency);
    } // -- void addDependency(ProjectDependency)


    /**
     * Method addDeveloper
     * 
     * @param projectDeveloper
     */
    public void addDeveloper(XFProjectDeveloper projectDeveloper) {
        getDevelopers ().add (projectDeveloper);
    } // -- void addDeveloper(ProjectDeveloper)


    /**
     * Method addNotifier
     * 
     * @param projectNotifier
     */
    public void addNotifier(XFProjectNotifier projectNotifier) {
        getNotifiers ().add (projectNotifier);
    } // -- void addNotifier(ProjectNotifier)


    /**
     * Method breakBuildResultAssociation
     * 
     * @param buildResult
     */
    public void breakBuildResultAssociation(XFBuildResult buildResult) {
        if (!getBuildResults ().contains (buildResult)) { throw new IllegalStateException ("buildResult isn't associated."); }

        getBuildResults ().remove (buildResult);
    } // -- void breakBuildResultAssociation(BuildResult)


    /**
     * Method breakProjectGroupAssociation
     * 
     * @param projectGroup
     */
    public void breakProjectGroupAssociation(XFProjectGroup projectGroup) {
        if (this.projectGroup != projectGroup) { throw new IllegalStateException ("projectGroup isn't associated."); }

        this.projectGroup = null;
    } // -- void breakProjectGroupAssociation(ProjectGroup)


    /**
     * Method createBuildResultAssociation
     * 
     * @param buildResult
     */
    public void createBuildResultAssociation(XFBuildResult buildResult) {
        Collection buildResults = getBuildResults ();

        if (getBuildResults ().contains (buildResult)) { throw new IllegalStateException ("buildResult is already assigned."); }

        buildResults.add (buildResult);
    } // -- void createBuildResultAssociation(BuildResult)


    /**
     * Method createProjectGroupAssociation
     * 
     * @param projectGroup
     */
    public void createProjectGroupAssociation(XFProjectGroup projectGroup) {
        if (this.projectGroup != null) {
            breakProjectGroupAssociation (this.projectGroup);
        }

        this.projectGroup = projectGroup;
    } // -- void createProjectGroupAssociation(ProjectGroup)


    /**
     * Method equals
     * 
     * @param other
     */
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (!(other instanceof XFProject)) { return false; }

        XFProject that = (XFProject) other;
        boolean result = true;
        result = result && id == that.id;
        return result;
    } // -- boolean equals(Object)


    /**
     * Get null
     */
    public String getArtifactId() {
        return this.artifactId;
    } // -- String getArtifactId()


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
    public int getBuildNumber() {
        return this.buildNumber;
    } // -- int getBuildNumber()


    /**
     * Method getBuildResults
     */
    public java.util.List getBuildResults() {
        if (this.buildResults == null) {
            this.buildResults = new java.util.ArrayList ();
        }

        return this.buildResults;
    } // -- java.util.List getBuildResults()


    /**
     * Get null
     */
    public ScmResult getCheckoutResult() {
        return this.checkoutResult;
    } // -- ScmResult getCheckoutResult()


    /**
     * Method getDependencies
     */
    public java.util.List getDependencies() {
        if (this.dependencies == null) {
            this.dependencies = new java.util.ArrayList ();
        }

        return this.dependencies;
    } // -- java.util.List getDependencies()


    /**
     * Get null
     */
    public String getDescription() {
        return this.description;
    } // -- String getDescription()


    /**
     * Method getDevelopers
     */
    public java.util.List getDevelopers() {
        if (this.developers == null) {
            this.developers = new java.util.ArrayList ();
        }

        return this.developers;
    } // -- java.util.List getDevelopers()


    /**
     * Get null
     */
    public String getExecutorId() {
        return this.executorId;
    } // -- String getExecutorId()


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
    public int getLatestBuildId() {
        return this.latestBuildId;
    } // -- int getLatestBuildId()


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
     * Get null
     */
    public int getOldState() {
        return this.oldState;
    } // -- int getOldState()


    /**
     * Get null
     */
    public XFProjectDependency getParent() {
        return this.parent;
    } // -- ProjectDependency getParent()


    /**
     * Get null
     */
    public XFProjectGroup getProjectGroup() {
        return this.projectGroup;
    } // -- ProjectGroup getProjectGroup()


    /**
     * Get null
     */
    public String getScmPassword() {
        return this.scmPassword;
    } // -- String getScmPassword()


    /**
     * Get null
     */
    public String getScmTag() {
        return this.scmTag;
    } // -- String getScmTag()


    /**
     * Get null
     */
    public String getScmUrl() {
        return this.scmUrl;
    } // -- String getScmUrl()


    /**
     * Get null
     */
    public String getScmUsername() {
        return this.scmUsername;
    } // -- String getScmUsername()


    /**
     * Get null
     */
    public int getState() {
        return this.state;
    } // -- int getState()


    /**
     * Get null
     */
    public String getUrl() {
        return this.url;
    } // -- String getUrl()


    /**
     * Get null
     */
    public String getVersion() {
        return this.version;
    } // -- String getVersion()


    /**
     * Get null
     */
    public String getWorkingDirectory() {
        return this.workingDirectory;
    } // -- String getWorkingDirectory()


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
     * Method removeBuildResult
     * 
     * @param buildResult
     */
    public void removeBuildResult(XFBuildResult buildResult) {
        buildResult.breakProjectAssociation (this);
        getBuildResults ().remove (buildResult);
    } // -- void removeBuildResult(BuildResult)


    /**
     * Method removeDependency
     * 
     * @param projectDependency
     */
    public void removeDependency(XFProjectDependency projectDependency) {
        getDependencies ().remove (projectDependency);
    } // -- void removeDependency(ProjectDependency)


    /**
     * Method removeDeveloper
     * 
     * @param projectDeveloper
     */
    public void removeDeveloper(XFProjectDeveloper projectDeveloper) {
        getDevelopers ().remove (projectDeveloper);
    } // -- void removeDeveloper(ProjectDeveloper)


    /**
     * Method removeNotifier
     * 
     * @param projectNotifier
     */
    public void removeNotifier(XFProjectNotifier projectNotifier) {
        getNotifiers ().remove (projectNotifier);
    } // -- void removeNotifier(ProjectNotifier)


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
     * @param buildDefinitions
     */
    public void setBuildDefinitions(java.util.List buildDefinitions) {
        this.buildDefinitions = buildDefinitions;
    } // -- void setBuildDefinitions(java.util.List)


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
     * @param buildResults
     */
    public void setBuildResults(java.util.List buildResults) {
        this.buildResults = buildResults;
    } // -- void setBuildResults(java.util.List)


    /**
     * Set null
     * 
     * @param checkoutResult
     */
    public void setCheckoutResult(ScmResult checkoutResult) {
        this.checkoutResult = checkoutResult;
    } // -- void setCheckoutResult(ScmResult)


    /**
     * Set null
     * 
     * @param dependencies
     */
    public void setDependencies(java.util.List dependencies) {
        this.dependencies = dependencies;
    } // -- void setDependencies(java.util.List)


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
     * @param developers
     */
    public void setDevelopers(java.util.List developers) {
        this.developers = developers;
    } // -- void setDevelopers(java.util.List)


    /**
     * Set null
     * 
     * @param executorId
     */
    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    } // -- void setExecutorId(String)


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
     * @param latestBuildId
     */
    public void setLatestBuildId(int latestBuildId) {
        this.latestBuildId = latestBuildId;
    } // -- void setLatestBuildId(int)


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
     * @param oldState
     */
    public void setOldState(int oldState) {
        this.oldState = oldState;
    } // -- void setOldState(int)


    /**
     * Set null
     * 
     * @param parent
     */
    public void setParent(XFProjectDependency parent) {
        this.parent = parent;
    } // -- void setParent(ProjectDependency)


    /**
     * Set null
     * 
     * @param projectGroup
     */
    public void setProjectGroup(XFProjectGroup projectGroup) {
        if (this.projectGroup != null) {
            this.projectGroup.breakProjectAssociation (this);
        }

        this.projectGroup = projectGroup;

        if (projectGroup != null) {
            this.projectGroup.createProjectAssociation (this);
        }
    } // -- void setProjectGroup(ProjectGroup)


    /**
     * Set null
     * 
     * @param scmPassword
     */
    public void setScmPassword(String scmPassword) {
        this.scmPassword = scmPassword;
    } // -- void setScmPassword(String)


    /**
     * Set null
     * 
     * @param scmTag
     */
    public void setScmTag(String scmTag) {
        this.scmTag = scmTag;
    } // -- void setScmTag(String)


    /**
     * Set null
     * 
     * @param scmUrl
     */
    public void setScmUrl(String scmUrl) {
        this.scmUrl = scmUrl;
    } // -- void setScmUrl(String)


    /**
     * Set null
     * 
     * @param scmUsername
     */
    public void setScmUsername(String scmUsername) {
        this.scmUsername = scmUsername;
    } // -- void setScmUsername(String)


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
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    } // -- void setUrl(String)


    /**
     * Set null
     * 
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    } // -- void setVersion(String)


    /**
     * Set null
     * 
     * @param workingDirectory
     */
    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    } // -- void setWorkingDirectory(String)


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
