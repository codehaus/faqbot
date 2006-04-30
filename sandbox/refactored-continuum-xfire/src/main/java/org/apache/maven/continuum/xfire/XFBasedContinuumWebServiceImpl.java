/**
 * 
 */
package org.apache.maven.continuum.xfire;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
import org.apache.maven.continuum.xfire.model.project.XFBuildResult;
import org.apache.maven.continuum.xfire.model.project.XFProject;
import org.codehaus.plexus.util.dag.CycleDetectedException;

/**
 * Concrete implementation that services the WebService requests.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 * @deprecated <em>Experimental</em>
 */
public class XFBasedContinuumWebServiceImpl implements XFBasedContinuumWebService {

    public void addBuildDefinition(int projectId, BuildDefinition buildDefinition) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void addBuildDefinitionFromParams(int projectId, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public ContinuumProjectBuildingResult addMavenOneProject(String metadataUrl) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public ContinuumProjectBuildingResult addMavenTwoProject(String metadataUrl) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public void addNotifier(int projectId, ProjectNotifier notifier) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void addNotifier(int projectId, String notifierType, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public int addProject(Project project, String executorId) throws ContinuumException {
        // TODO Auto-generated method stub
        return 0;
    }


    public void addSchedule(Schedule schedule) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void addUser(ContinuumUser user) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void addUser(Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void addUserGroup(UserGroup userGroup) {
    // TODO Auto-generated method stub

    }


    public void addUserGroup(Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void buildProject(int projectId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void buildProject(int projectId, int trigger) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void buildProject(int projectId, int buildDefinitionId, int trigger) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void buildProjects() throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void buildProjects(int trigger) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void buildProjects(Schedule schedule) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void checkoutProject(int projectId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public Collection<XFProject> getAllProjects(int start, int end) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public List<XFProject> getAllProjectsWithAllDetails(int start, int end) {
        // TODO Auto-generated method stub
        return null;
    }


    public BuildDefinition getBuildDefinition(int projectId, int buildDefinitionId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public List getBuildDefinitions(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public String getBuildOutput(int projectId, int buildId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public BuildResult getBuildResult(int buildId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public BuildResult getBuildResultByBuildNumber(int projectId, int buildNumber) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Collection getBuildResultsForProject(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Map getBuildResultsInSuccess() {
        // TODO Auto-generated method stub
        return null;
    }


    public List getChangesSinceLastSuccess(int projectId, int buildResultId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public ConfigurationService getConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }


    public BuildDefinition getDefaultBuildDefinition(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public String getFileContent(int projectId, String directory, String filename) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public List getFiles(int projectId, String currentDirectory) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public XFBuildResult getLatestBuildResultForProject(int projectId) {
        // TODO Auto-generated method stub
        return null;
    }


    public Map getLatestBuildResults() {
        // TODO Auto-generated method stub
        return null;
    }


    public ProjectNotifier getNotifier(int projectId, int notifierId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public XFProject getProject(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Project getProjectWithAllDetails(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Project getProjectWithBuilds(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Project getProjectWithCheckoutResult(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Collection<XFProject> getProjects() throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public List getProjectsInBuildOrder() throws CycleDetectedException, ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Collection getProjectsWithDependencies() throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Schedule getSchedule(int id) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public Collection getSchedules() throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public ContinuumSecurity getSecurity() {
        // TODO Auto-generated method stub
        return null;
    }


    public ContinuumUser getUser(int userId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public UserGroup getUserGroup(int userGroupId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public List getUserGroups() throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public List getUsers() throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public File getWorkingDirectory(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return null;
    }


    public boolean isInBuildingQueue(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean isInBuildingQueue(int projectId, int buildDefinitionId) throws ContinuumException {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean isInCheckoutQueue(int projectId) throws ContinuumException {
        // TODO Auto-generated method stub
        return false;
    }


    public void reloadConfiguration() throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void removeBuildDefinition(int projectId, int buildDefinitionId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void removeNotifier(int projectId, int notifierId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void removeProject(int projectId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void removeSchedule(int scheduleId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void removeUser(int userId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void removeUserGroup(int userGroupId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateBuildDefinition(BuildDefinition buildDefinition, int projectId) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateBuildDefinition(int projectId, int buildDefinitionId, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateConfiguration(Map parameters) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateNotifier(int projectId, int notifierId, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateNotifier(int projectId, ProjectNotifier notifier) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateProject(Project project) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateSchedule(Schedule schedule) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateSchedule(int scheduleId, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateUser(ContinuumUser user) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateUser(int userId, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateUserGroup(UserGroup userGroup) throws ContinuumException {
    // TODO Auto-generated method stub

    }


    public void updateUserGroup(int userGroupId, Map configuration) throws ContinuumException {
    // TODO Auto-generated method stub

    }

}
