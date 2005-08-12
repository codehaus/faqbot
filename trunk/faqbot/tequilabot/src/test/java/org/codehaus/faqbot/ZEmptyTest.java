package org.codehaus.faqbot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ZEmptyTest extends TestCase {

	protected void setUp() {
		
	}
	
	public static Test suite()
    {
        return new TestSuite( ZEmptyTest.class );
    }
	
	public void testMe()
	{
		assertTrue(true);
	}

}
