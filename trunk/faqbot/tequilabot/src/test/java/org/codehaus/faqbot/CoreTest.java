package org.codehaus.faqbot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the XWikiCore class
 */
public class CoreTest 
    extends TestCase
{
	private XWikiCore core;
	private String test[];
	private String expected[];
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CoreTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CoreTest.class );
    }
    
    public void setUp()
    {
    	core = new XWikiCore();
    	test = new String[]{"What is XWiki?", 
    						"How do I make an XWiki link?",
    						"How do I make a new page?"};
        expected = new String[]{"XWiki is the eXtended Wiki. In addition to regular wiki functionality, it also has an integrated database, the benefits of a programming language, and multi-language support",
        						"An XWiki link consists of brackets around the page name [like so|Faqbot.Home], or as an html link <a xmlns=\"http://www.w3.org/1999/xhtml\" href=\"/xwiki/bin/view/Faqbot/Home\">Doc.WebHome</a>",
        						"Make an XWiki link from another, \"parent\" page. The new page will be created when you click on your new link"};
    }
    
    public void tearDown()
    {
    	core.cleanup();
    }

    /**
     * Tests the core with standard question/answers
     */
    public void testCore()
    {
    	System.out.println("Test run");
    	for(int i = 0; i < test.length; i++)
    	{
    		String t = core.doInput(test[i]);
    		assertEquals(t, expected[i]);
    	}
    }
}
