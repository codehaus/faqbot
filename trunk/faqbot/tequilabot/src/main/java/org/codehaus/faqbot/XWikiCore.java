package org.codehaus.faqbot;

//com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl
import java.io.*;

import java.net.URL;
import org.aitools.programd.Core;
import org.aitools.programd.CoreSettings;

import org.aitools.programd.util.FileManager;




/**
 * Core of the XWiki faqbot; loads aiml files, returns output from programd interpreter
 * 
 * @author <a href="mailto:dev@faqbot.codehaus.org">Jie Tang</a>
 * @since 0.1
 */
public class XWikiCore 
{
    /** The programD interpreter core */
    private Core core;
    
    String hostName;
    String botName;
    
    /**
     * Creates a <code>XWikiCore</code>. By default, the programD settings file should be located at res/core.xml
     * 
     */
    public XWikiCore()
    {
    	this("res/core.xml");
    }
    
    /**
     * Creates a <code>XWikiCore</code>
     * Gets the path to the configuration files for programD, creates the programD core,
     * and initializes system properties (working directory, xml parser, document builder)
     * 
     * @param settingsPath the path to the settings file for the programD core
     */
    public XWikiCore(String settingsPath)
    {
    	System.out.println("Constructor");
    	URL loc = this.getClass().getResource(settingsPath);
    	settingsPath = loc.getFile();
    	File f = new File(settingsPath);
    	CoreSettings set = new CoreSettings(settingsPath);
    	FileManager.pushWorkingDirectory(f.getParent());
    	FileManager.setRootPath(FileManager.getWorkingDirectory());
    	System.setProperty("user.dir", f.getParent());
    	System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
    	System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
    	System.out.println("TEQUILABOT: Initializing: fileworking= "+FileManager.getWorkingDirectory());
        initialize(set, System.out, System.err);
    }
    
    public XWikiCore(CoreSettings set)
    {
    	initialize(set, System.out, System.err);
    }
    
    /**
     * Creates the core, sets it up, and starts it.
     * 
     * @param settingsPath the path for the settings file to use
     * @param out the stream to use for normal output messages
     * @param err the stream to use for error messages
     */
    private void initialize(CoreSettings settingsPath, PrintStream out, PrintStream err)
    {
    	System.out.println("TEQUILABOT: Core Settings: " + settingsPath.getAimlSchemaLocation() + " " + settingsPath.getAimlSchemaNamespaceUri()+" " + settingsPath.getRootDirectory());
    	
          	
    	core = new Core(settingsPath);
    	
    	//Runtime.getRuntime().addShutdownHook(new CoreShutdownHook(core));
    	System.out.println("Core created");
    	core.setup();
    	hostName = core.getHostname();
    	botName = core.getBots().getABot().getID();
    	System.out.println("Core setup");
    	core.start();
    	System.out.println("Core started");
    	core.processResponse(core.getSettings().getConnectString());
    	core.processResponse("hello");
    }
    
    
    /**
     * Shuts down and cleans up engine
     * 
     */
    public void cleanup()
    {
    	core.shutdown();
    }
    
    /**
     * Wrapper for the ProgramD interpreter processing method
     * 
     * @param input the string to process
     */
    public String doInput(String input)
    {
    	while(core.getStatus() != Core.Status.READY)
    	{
    		try{wait(1000);}catch(InterruptedException ie){}
    	}
    	return core.getResponse(input, hostName, botName);
    }
    
}
