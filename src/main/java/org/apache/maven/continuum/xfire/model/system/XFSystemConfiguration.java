/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.system;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFSystemConfiguration implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field guestAccountEnabled
     */
    private boolean guestAccountEnabled = true;

    /**
     * Field defaultScheduleDescription
     */
    private String defaultScheduleDescription = "Run hourly";

    /**
     * Field defaultScheduleCronExpression
     */
    private String defaultScheduleCronExpression = "0 0 * * * ?";

    /**
     * Field workingDirectory
     */
    private String workingDirectory = "working-directory";

    /**
     * Field buildOutputDirectory
     */
    private String buildOutputDirectory = "build-output-directory";

    /**
     * Field deploymentRepositoryDirectory
     */
    private String deploymentRepositoryDirectory;

    /**
     * Field baseUrl
     */
    private String baseUrl;

    /**
     * Field companyName
     */
    private String companyName;

    /**
     * Field companyLogoUrl
     */
    private String companyLogoUrl;

    /**
     * Field companyUrl
     */
    private String companyUrl;

    /**
     * Field initialized
     */
    private boolean initialized = false;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Get null
     */
    public String getBaseUrl() {
        return this.baseUrl;
    } // -- String getBaseUrl()


    /**
     * Get null
     */
    public String getBuildOutputDirectory() {
        return this.buildOutputDirectory;
    } // -- String getBuildOutputDirectory()


    /**
     * Get null
     */
    public String getCompanyLogoUrl() {
        return this.companyLogoUrl;
    } // -- String getCompanyLogoUrl()


    /**
     * Get null
     */
    public String getCompanyName() {
        return this.companyName;
    } // -- String getCompanyName()


    /**
     * Get null
     */
    public String getCompanyUrl() {
        return this.companyUrl;
    } // -- String getCompanyUrl()


    /**
     * Get null
     */
    public String getDefaultScheduleCronExpression() {
        return this.defaultScheduleCronExpression;
    } // -- String getDefaultScheduleCronExpression()


    /**
     * Get null
     */
    public String getDefaultScheduleDescription() {
        return this.defaultScheduleDescription;
    } // -- String getDefaultScheduleDescription()


    /**
     * Get null
     */
    public String getDeploymentRepositoryDirectory() {
        return this.deploymentRepositoryDirectory;
    } // -- String getDeploymentRepositoryDirectory()


    /**
     * Get null
     */
    public String getWorkingDirectory() {
        return this.workingDirectory;
    } // -- String getWorkingDirectory()


    /**
     * Get null
     */
    public boolean isGuestAccountEnabled() {
        return this.guestAccountEnabled;
    } // -- boolean isGuestAccountEnabled()


    /**
     * Get null
     */
    public boolean isInitialized() {
        return this.initialized;
    } // -- boolean isInitialized()


    /**
     * Set null
     * 
     * @param baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    } // -- void setBaseUrl(String)


    /**
     * Set null
     * 
     * @param buildOutputDirectory
     */
    public void setBuildOutputDirectory(String buildOutputDirectory) {
        this.buildOutputDirectory = buildOutputDirectory;
    } // -- void setBuildOutputDirectory(String)


    /**
     * Set null
     * 
     * @param companyLogoUrl
     */
    public void setCompanyLogoUrl(String companyLogoUrl) {
        this.companyLogoUrl = companyLogoUrl;
    } // -- void setCompanyLogoUrl(String)


    /**
     * Set null
     * 
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    } // -- void setCompanyName(String)


    /**
     * Set null
     * 
     * @param companyUrl
     */
    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    } // -- void setCompanyUrl(String)


    /**
     * Set null
     * 
     * @param defaultScheduleCronExpression
     */
    public void setDefaultScheduleCronExpression(String defaultScheduleCronExpression) {
        this.defaultScheduleCronExpression = defaultScheduleCronExpression;
    } // -- void setDefaultScheduleCronExpression(String)


    /**
     * Set null
     * 
     * @param defaultScheduleDescription
     */
    public void setDefaultScheduleDescription(String defaultScheduleDescription) {
        this.defaultScheduleDescription = defaultScheduleDescription;
    } // -- void setDefaultScheduleDescription(String)


    /**
     * Set null
     * 
     * @param deploymentRepositoryDirectory
     */
    public void setDeploymentRepositoryDirectory(String deploymentRepositoryDirectory) {
        this.deploymentRepositoryDirectory = deploymentRepositoryDirectory;
    } // -- void setDeploymentRepositoryDirectory(String)


    /**
     * Set null
     * 
     * @param guestAccountEnabled
     */
    public void setGuestAccountEnabled(boolean guestAccountEnabled) {
        this.guestAccountEnabled = guestAccountEnabled;
    } // -- void setGuestAccountEnabled(boolean)


    /**
     * Set null
     * 
     * @param initialized
     */
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    } // -- void setInitialized(boolean)


    /**
     * Set null
     * 
     * @param workingDirectory
     */
    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    } // -- void setWorkingDirectory(String)

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
