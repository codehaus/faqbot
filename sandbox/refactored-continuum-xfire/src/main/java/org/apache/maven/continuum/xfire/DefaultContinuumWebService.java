/**
 * 
 */
package org.apache.maven.continuum.xfire;

import java.util.Collection;

import org.apache.maven.continuum.model.project.Project;
import org.apache.maven.continuum.model.scm.ScmResult;
import org.apache.maven.model.Build;
import org.codehaus.xfire.fault.XFireFault;

/**
 * Concrete implementation that services the WebService requests.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class DefaultContinuumWebService implements ContinuumWebService {

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#addMavenOneProject(java.lang.String)
     */
    public Collection addMavenOneProject(String scmUrl) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#addMavenTwoProject(java.lang.String)
     */
    public Collection addMavenTwoProject(String scmUrl) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#addProject(org.apache.maven.continuum.model.project.Project)
     */
    public String addProject(Project project) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#buildProject(java.lang.String,
     *      boolean)
     */
    public void buildProject(int projectId, boolean force) throws XFireFault {
    // TODO Auto-generated method stub

    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#checkoutProject(java.lang.String)
     */
    public void checkoutProject(int id) throws XFireFault {
    // TODO Auto-generated method stub

    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#getBuilds(java.lang.String)
     */
    public Collection getBuildDefinitions(int projectId) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#getLatestBuild(java.lang.String)
     */
    public Build getLatestBuild(int projectId) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#getProject(java.lang.String)
     */
    public Project getProject(int projectId) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#getProjects()
     */
    public Collection getProjects() throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#getScmResult(java.lang.String)
     */
    public ScmResult getScmResult(int projectId) throws XFireFault {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#removeProject(java.lang.String)
     */
    public void removeProject(int projectId) throws XFireFault {
    // TODO Auto-generated method stub

    }


    /*
     * (non-Javadoc)
     * 
     * @see org.apache.maven.continuum.xfire.ContinuumWebService#updateProject(org.apache.maven.continuum.model.project.Project)
     */
    public void updateProject(Project project) throws XFireFault {
    // TODO Auto-generated method stub

    }

}
