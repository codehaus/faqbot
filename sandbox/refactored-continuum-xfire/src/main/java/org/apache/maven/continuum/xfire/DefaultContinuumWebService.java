/**
 * 
 */
package org.apache.maven.continuum.xfire;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.maven.continuum.Continuum;
import org.apache.maven.continuum.ContinuumException;
import org.apache.maven.continuum.configuration.ConfigurationService;
import org.apache.maven.continuum.model.project.BuildDefinition;
import org.apache.maven.continuum.model.project.BuildResult;
import org.apache.maven.continuum.model.project.Project;
import org.apache.maven.continuum.model.project.ProjectNotifier;
import org.apache.maven.continuum.model.project.Schedule;
import org.apache.maven.continuum.model.system.ContinuumUser;
import org.apache.maven.continuum.model.system.UserGroup;
import org.apache.maven.continuum.project.builder.ContinuumProjectBuildingResult;
import org.apache.maven.continuum.security.ContinuumSecurity;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.codehaus.plexus.util.dag.CycleDetectedException;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.ServiceFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.service.invoker.ObjectInvoker;

/**
 * Default implmentation of {@link IContinuumWebService} that uses the Continuum
 * model.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 *         $revision$
 */
public class DefaultContinuumWebService implements ContinuumWebService, Initializable {

    private static final Log log = LogFactory.getLog (DefaultContinuumWebService.class);

    /**
     * Wrapped up Continuum instance to delegate calls to.
     */
    private Continuum continuum;


    public void initialize() throws InitializationException {
        if (log.isInfoEnabled ())
            log.info ("initializing Continuum Web Service...");
        ContinuumXFireServiceFactory.createContinuumWebService ();
        if (log.isInfoEnabled ())
            log.info ("... initialized!");
    }


    /**
     * Obtain the wrapped instance of Continuum
     * 
     * @return
     */
    public Continuum getContinuum() {
        return continuum;
    }


    /**
     * Set Continuum instance that should service requests.
     * 
     * @param continuum
     */
    public void setContinuum(Continuum continuum) {
        this.continuum = continuum;
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addBuildDefinition(int,
     *      org.apache.maven.continuum.model.project.BuildDefinition)
     */
    public void addBuildDefinition(int arg0, BuildDefinition arg1) throws ContinuumException {
        continuum.addBuildDefinition (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addBuildDefinitionFromParams(int,
     *      java.util.Map)
     */
    public void addBuildDefinitionFromParams(int arg0, Map arg1) throws ContinuumException {
        continuum.addBuildDefinitionFromParams (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addMavenOneProject(java.lang.String)
     */
    public ContinuumProjectBuildingResult addMavenOneProject(String arg0) throws ContinuumException {
        return continuum.addMavenOneProject (arg0);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addMavenTwoProject(java.lang.String)
     */
    public ContinuumProjectBuildingResult addMavenTwoProject(String arg0) throws ContinuumException {
        return continuum.addMavenTwoProject (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addNotifier(int,
     *      org.apache.maven.continuum.model.project.ProjectNotifier)
     */
    public void addNotifier(int arg0, ProjectNotifier arg1) throws ContinuumException {
        continuum.addNotifier (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addNotifier(int,
     *      java.lang.String, java.util.Map)
     */
    public void addNotifier(int arg0, String arg1, Map arg2) throws ContinuumException {
        continuum.addNotifier (arg0, arg1, arg2);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addProject(org.apache.maven.continuum.model.project.Project,
     *      java.lang.String)
     */
    public int addProject(Project arg0, String arg1) throws ContinuumException {
        return continuum.addProject (arg0, arg1);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addSchedule(org.apache.maven.continuum.model.project.Schedule)
     */
    public void addSchedule(Schedule arg0) throws ContinuumException {
        continuum.addSchedule (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addUser(org.apache.maven.continuum.model.system.ContinuumUser)
     */
    public void addUser(ContinuumUser arg0) throws ContinuumException {
        continuum.addUser (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addUser(java.util.Map)
     */
    public void addUser(Map arg0) throws ContinuumException {
        continuum.addUser (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#addUserGroup(java.util.Map)
     */
    public void addUserGroup(Map arg0) throws ContinuumException {
        continuum.addUserGroup (arg0);
    }


    /**
     * @param arg0
     * @see org.apache.maven.continuum.Continuum#addUserGroup(org.apache.maven.continuum.model.system.UserGroup)
     */
    public void addUserGroup(UserGroup arg0) {
        continuum.addUserGroup (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#buildProject(int, int, int)
     */
    public void buildProject(int arg0, int arg1, int arg2) throws ContinuumException {
        continuum.buildProject (arg0, arg1, arg2);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#buildProject(int, int)
     */
    public void buildProject(int arg0, int arg1) throws ContinuumException {
        continuum.buildProject (arg0, arg1);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#buildProject(int)
     */
    public void buildProject(int arg0) throws ContinuumException {
        continuum.buildProject (arg0);
    }


    /**
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#buildProjects()
     */
    public void buildProjects() throws ContinuumException {
        continuum.buildProjects ();
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#buildProjects(int)
     */
    public void buildProjects(int arg0) throws ContinuumException {
        continuum.buildProjects (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#buildProjects(org.apache.maven.continuum.model.project.Schedule)
     */
    public void buildProjects(Schedule arg0) throws ContinuumException {
        continuum.buildProjects (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#checkoutProject(int)
     */
    public void checkoutProject(int arg0) throws ContinuumException {
        continuum.checkoutProject (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getAllProjects(int, int)
     */
    public Collection getAllProjects(int arg0, int arg1) throws ContinuumException {
        return continuum.getAllProjects (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @see org.apache.maven.continuum.Continuum#getAllProjectsWithAllDetails(int,
     *      int)
     */
    public List getAllProjectsWithAllDetails(int arg0, int arg1) {
        return continuum.getAllProjectsWithAllDetails (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getBuildDefinition(int, int)
     */
    public BuildDefinition getBuildDefinition(int arg0, int arg1) throws ContinuumException {
        return continuum.getBuildDefinition (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getBuildDefinitions(int)
     */
    public List getBuildDefinitions(int arg0) throws ContinuumException {
        return continuum.getBuildDefinitions (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getBuildOutput(int, int)
     */
    public String getBuildOutput(int arg0, int arg1) throws ContinuumException {
        return continuum.getBuildOutput (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getBuildResult(int)
     */
    public BuildResult getBuildResult(int arg0) throws ContinuumException {
        return continuum.getBuildResult (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getBuildResultByBuildNumber(int,
     *      int)
     */
    public BuildResult getBuildResultByBuildNumber(int arg0, int arg1) throws ContinuumException {
        return continuum.getBuildResultByBuildNumber (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getBuildResultsForProject(int)
     */
    public Collection getBuildResultsForProject(int arg0) throws ContinuumException {
        return continuum.getBuildResultsForProject (arg0);
    }


    /**
     * @return
     * @see org.apache.maven.continuum.Continuum#getBuildResultsInSuccess()
     */
    public Map getBuildResultsInSuccess() {
        return continuum.getBuildResultsInSuccess ();
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getChangesSinceLastSuccess(int,
     *      int)
     */
    public List getChangesSinceLastSuccess(int arg0, int arg1) throws ContinuumException {
        return continuum.getChangesSinceLastSuccess (arg0, arg1);
    }


    /**
     * @return
     * @see org.apache.maven.continuum.Continuum#getConfiguration()
     */
    public ConfigurationService getConfiguration() {
        return continuum.getConfiguration ();
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getDefaultBuildDefinition(int)
     */
    public BuildDefinition getDefaultBuildDefinition(int arg0) throws ContinuumException {
        return continuum.getDefaultBuildDefinition (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getFileContent(int,
     *      java.lang.String, java.lang.String)
     */
    public String getFileContent(int arg0, String arg1, String arg2) throws ContinuumException {
        return continuum.getFileContent (arg0, arg1, arg2);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getFiles(int, java.lang.String)
     */
    public List getFiles(int arg0, String arg1) throws ContinuumException {
        return continuum.getFiles (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @see org.apache.maven.continuum.Continuum#getLatestBuildResultForProject(int)
     */
    public BuildResult getLatestBuildResultForProject(int arg0) {
        return continuum.getLatestBuildResultForProject (arg0);
    }


    /**
     * @return
     * @see org.apache.maven.continuum.Continuum#getLatestBuildResults()
     */
    public Map getLatestBuildResults() {
        return continuum.getLatestBuildResults ();
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getNotifier(int, int)
     */
    public ProjectNotifier getNotifier(int arg0, int arg1) throws ContinuumException {
        return continuum.getNotifier (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProject(int)
     */
    public Project getProject(int arg0) throws ContinuumException {
        return continuum.getProject (arg0);
    }


    /**
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProjects()
     */
    public Collection getProjects() throws ContinuumException {
        return continuum.getProjects ();
    }


    /**
     * @return
     * @throws CycleDetectedException
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProjectsInBuildOrder()
     */
    public List getProjectsInBuildOrder() throws CycleDetectedException, ContinuumException {
        return continuum.getProjectsInBuildOrder ();
    }


    /**
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProjectsWithDependencies()
     */
    public Collection getProjectsWithDependencies() throws ContinuumException {
        return continuum.getProjectsWithDependencies ();
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProjectWithAllDetails(int)
     */
    public Project getProjectWithAllDetails(int arg0) throws ContinuumException {
        return continuum.getProjectWithAllDetails (arg0);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProjectWithBuilds(int)
     */
    public Project getProjectWithBuilds(int arg0) throws ContinuumException {
        return continuum.getProjectWithBuilds (arg0);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getProjectWithCheckoutResult(int)
     */
    public Project getProjectWithCheckoutResult(int arg0) throws ContinuumException {
        return continuum.getProjectWithCheckoutResult (arg0);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getSchedule(int)
     */
    public Schedule getSchedule(int arg0) throws ContinuumException {
        return continuum.getSchedule (arg0);
    }


    /**
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getSchedules()
     */
    public Collection getSchedules() throws ContinuumException {
        return continuum.getSchedules ();
    }


    /**
     * @return
     * @see org.apache.maven.continuum.Continuum#getSecurity()
     */
    public ContinuumSecurity getSecurity() {
        return continuum.getSecurity ();
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getUser(int)
     */
    public ContinuumUser getUser(int arg0) throws ContinuumException {
        return continuum.getUser (arg0);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getUserGroup(int)
     */
    public UserGroup getUserGroup(int arg0) throws ContinuumException {
        return continuum.getUserGroup (arg0);
    }


    /**
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getUserGroups()
     */
    public List getUserGroups() throws ContinuumException {
        return continuum.getUserGroups ();
    }


    /**
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getUsers()
     */
    public List getUsers() throws ContinuumException {
        return continuum.getUsers ();
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#getWorkingDirectory(int)
     */
    public File getWorkingDirectory(int arg0) throws ContinuumException {
        return continuum.getWorkingDirectory (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#isInBuildingQueue(int, int)
     */
    public boolean isInBuildingQueue(int arg0, int arg1) throws ContinuumException {
        return continuum.isInBuildingQueue (arg0, arg1);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#isInBuildingQueue(int)
     */
    public boolean isInBuildingQueue(int arg0) throws ContinuumException {
        return continuum.isInBuildingQueue (arg0);
    }


    /**
     * @param arg0
     * @return
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#isInCheckoutQueue(int)
     */
    public boolean isInCheckoutQueue(int arg0) throws ContinuumException {
        return continuum.isInCheckoutQueue (arg0);
    }


    /**
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#reloadConfiguration()
     */
    public void reloadConfiguration() throws ContinuumException {
        continuum.reloadConfiguration ();
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#removeBuildDefinition(int, int)
     */
    public void removeBuildDefinition(int arg0, int arg1) throws ContinuumException {
        continuum.removeBuildDefinition (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#removeNotifier(int, int)
     */
    public void removeNotifier(int arg0, int arg1) throws ContinuumException {
        continuum.removeNotifier (arg0, arg1);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#removeProject(int)
     */
    public void removeProject(int arg0) throws ContinuumException {
        continuum.removeProject (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#removeSchedule(int)
     */
    public void removeSchedule(int arg0) throws ContinuumException {
        continuum.removeSchedule (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#removeUser(int)
     */
    public void removeUser(int arg0) throws ContinuumException {
        continuum.removeUser (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#removeUserGroup(int)
     */
    public void removeUserGroup(int arg0) throws ContinuumException {
        continuum.removeUserGroup (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateBuildDefinition(org.apache.maven.continuum.model.project.BuildDefinition,
     *      int)
     */
    public void updateBuildDefinition(BuildDefinition arg0, int arg1) throws ContinuumException {
        continuum.updateBuildDefinition (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateBuildDefinition(int, int,
     *      java.util.Map)
     */
    public void updateBuildDefinition(int arg0, int arg1, Map arg2) throws ContinuumException {
        continuum.updateBuildDefinition (arg0, arg1, arg2);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateConfiguration(java.util.Map)
     */
    public void updateConfiguration(Map arg0) throws ContinuumException {
        continuum.updateConfiguration (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateNotifier(int, int,
     *      java.util.Map)
     */
    public void updateNotifier(int arg0, int arg1, Map arg2) throws ContinuumException {
        continuum.updateNotifier (arg0, arg1, arg2);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateNotifier(int,
     *      org.apache.maven.continuum.model.project.ProjectNotifier)
     */
    public void updateNotifier(int arg0, ProjectNotifier arg1) throws ContinuumException {
        continuum.updateNotifier (arg0, arg1);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateProject(org.apache.maven.continuum.model.project.Project)
     */
    public void updateProject(Project arg0) throws ContinuumException {
        continuum.updateProject (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateSchedule(int,
     *      java.util.Map)
     */
    public void updateSchedule(int arg0, Map arg1) throws ContinuumException {
        continuum.updateSchedule (arg0, arg1);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateSchedule(org.apache.maven.continuum.model.project.Schedule)
     */
    public void updateSchedule(Schedule arg0) throws ContinuumException {
        continuum.updateSchedule (arg0);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateUser(org.apache.maven.continuum.model.system.ContinuumUser)
     */
    public void updateUser(ContinuumUser arg0) throws ContinuumException {
        continuum.updateUser (arg0);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateUser(int, java.util.Map)
     */
    public void updateUser(int arg0, Map arg1) throws ContinuumException {
        continuum.updateUser (arg0, arg1);
    }


    /**
     * @param arg0
     * @param arg1
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateUserGroup(int,
     *      java.util.Map)
     */
    public void updateUserGroup(int arg0, Map arg1) throws ContinuumException {
        continuum.updateUserGroup (arg0, arg1);
    }


    /**
     * @param arg0
     * @throws ContinuumException
     * @see org.apache.maven.continuum.Continuum#updateUserGroup(org.apache.maven.continuum.model.system.UserGroup)
     */
    public void updateUserGroup(UserGroup arg0) throws ContinuumException {
        continuum.updateUserGroup (arg0);
    }

}
