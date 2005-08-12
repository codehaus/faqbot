package org.codehaus.faqbot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the XWikiFaqbot class and the LearningEngine class
 */
public class FaqbotTest extends TestCase {

	private XWikiFaqbot bot;
	private String test[];
	private String expected[];
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FaqbotTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FaqbotTest.class );
    }
    
	protected void setUp() throws Exception {
		bot = new XWikiFaqbot();
		test = new String[]{"What is XWiki?",
							"How do you do?",
							"learn The answer to the question of life the universe and everything resp forty-two",
							"The answer to the question of life the universe and everything"};
		expected = new String[]{"XWiki is the eXtended Wiki. In addition to regular wiki functionality, it also has an integrated database, the benefits of a programming language, and multi-language support",
								"I am very well, how are you?",
								"The more people talk to me, the smarter I become.",
								"forty-two"};
	}

	protected void tearDown() throws Exception {
			XWikiFaqbot.getXWikiInstance().cleanup();
	}
	
	/**
     * Test both the responses of the core and the learning engine
     */
    public void testCore()
    {
    	System.out.println("Test run");
    	for(int i = 0; i < test.length; i++)
    	{
    		String t = bot.processQuery(test[i]);
    		assertEquals(t, expected[i]);
    	}
    }

}
