package org.codehaus.faqbot.impl;

import org.codehaus.faqbot.KnowledgeMap;

import junit.framework.TestCase;

/**
 * @author <a href='mailto:sebastianmohan@acm.org'>Sebastian Mohan</a>
 *         $Revision:...$
 */
public class FileKnowledgeSourceTest extends TestCase {

    public void testAIML() {
        FileKnowledgeSource cSrc = new FileKnowledgeSource ();
        KnowledgeMap knowMap = cSrc.getKnowledgeMap ();
        String knowledge = knowMap.getKnowledge ("Eclipse");

        assertEquals ("Knowledge description should match for eclipse",
                      "Opensource Java Integerated Development Environment",
                      knowledge);
    }
}
