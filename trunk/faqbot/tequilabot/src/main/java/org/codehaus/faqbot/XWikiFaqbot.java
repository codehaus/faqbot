/**
 * 
 */
package org.codehaus.faqbot;

/**
 * XWiki faqbot; provides a single instance of both the core and the learning engine for use with XWiki
 * 
 * @author <a href="mailto:dev@faqbot.codehaus.org">Jie Tang</a>
 * @since 0.1
 */
public class XWikiFaqbot 
{
	private static XWikiCore core = new XWikiCore();
	private static LearningEngine learn = new LearningEngine();
	
	
	public XWikiFaqbot()
	{
		
	}
	
	/**
     * Creates the core, sets it up, and starts it.
     * 
     * @returns the reference to the XWikiCore
     */
	public static XWikiCore getXWikiInstance()
	{
		return core;
	}
	
	/**
     * Creates the core, sets it up, and starts it.
     * 
     * @returns the reference to the Learning Engine
     */
	public static LearningEngine getLearnInstance()
	{
		return learn;
	}
	
	/**
     * Process arbitrary input by first sending the query to the learning engine
     * to see if it is a learn command, then sending it to the core for AIML processing
     * 
     * @param the string to process
     */
	public String processQuery(String in)
	{
		XWikiFaqbot.getLearnInstance().learn(in);
		return XWikiFaqbot.getXWikiInstance().doInput(in);
	}
}
