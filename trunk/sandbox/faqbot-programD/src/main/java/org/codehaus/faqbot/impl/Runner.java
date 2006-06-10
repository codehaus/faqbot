/**
 * $Id:...$
 *    Copyright 2006  Sebastian Mohan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.faqbot.impl;

import org.codehaus.faqbot.AtomicAIMLDocumentGenerator;
import org.codehaus.faqbot.KnowledgeSource;
import org.w3c.dom.Document;

/**
 * Simple Runner implementation to read Knowedge from Console source and run the
 * Bot instance.
 * 
 * @author <a href='mailto:sebastianmohan@acm.org'>Sebastian Mohan</a>
 *         $Revision:...$
 */
public class Runner {

    public static void main(String args[]) {
        AtomicAIMLDocumentGenerator aimlGenerator = new AtomicAIMLDocumentGeneratorImpl ();
        KnowledgeSource source = new FileKnowledgeSource ();
        Document aimlDoc = aimlGenerator.generateAIMLDocument (source);
    }
}
