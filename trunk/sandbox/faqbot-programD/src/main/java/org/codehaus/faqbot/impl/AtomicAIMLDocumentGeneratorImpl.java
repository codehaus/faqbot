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

import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.codehaus.faqbot.AtomicAIMLDocumentGenerator;
import org.codehaus.faqbot.KnowledgeMap;
import org.codehaus.faqbot.KnowledgeSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Concrete AIML Document generator implementation
 * 
 * @author <a href='mailto:sebastianmohan@acm.org'>Sebastian Mohan</a>
 *         $Id:...$
 */
public class AtomicAIMLDocumentGeneratorImpl implements AtomicAIMLDocumentGenerator {

    private static final String ELEMENT_TEMPLATE = "template";

    private static final String ELEMENT_PATTERN = "pattern";

    private static final String ELEMENT_CATEGORY = "category";

    private static final String ELEMENT_AIML = "aiml";


    public Document generateAIMLDocument(KnowledgeSource source) {

        Document doc = null;
        KnowledgeMap map = source.getKnowledgeMap ();
        Set<String> names = map.getKnowledgeNames ();
        Iterator<String> iter = names.iterator ();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder ();
            doc = builder.newDocument ();

            Element root = doc.createElement (ELEMENT_AIML);
            doc.appendChild (root);

            while (iter.hasNext ()) {
                String question = iter.next ();
                String answer = map.getKnowledge (question);

                Element category = doc.createElement (ELEMENT_CATEGORY);
                Element pattern = doc.createElement (ELEMENT_PATTERN);
                Element template = doc.createElement (ELEMENT_TEMPLATE);

                pattern.appendChild (doc.createTextNode (question));
                template.appendChild (doc.createTextNode (answer));
                category.appendChild (pattern);
                category.appendChild (template);

                root.appendChild (category);
            }

        } catch (ParserConfigurationException e) {
            // TODO To streamline the Exception handling
            e.printStackTrace ();
        }
        return doc;
    }
}
