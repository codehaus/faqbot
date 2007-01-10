/**
 * 
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.codehaus.faqbot.KnowledgeMap;
import org.codehaus.faqbot.KnowledgeSource;

/**
 * Console KnowledgeSource inplementation
 * 
 * @author <a href='mailto:sebastianmohan@acm.org'>Sebastian Mohan</a>
 *         $Id:...$
 */
public class FileKnowledgeSource implements KnowledgeSource {

    private KnowledgeMap knowledgeMap;

    private static String FILE_KNOWLEDGE = "src/resources/knowledge.properties";


    public FileKnowledgeSource() {
        knowledgeMap = new AIMLKnowledgeMap ();
        init ();
    }


    private void init() {
        try {
            Properties properties = new Properties ();
            properties.load (new FileInputStream (FILE_KNOWLEDGE));

            Enumeration<Object> keys = properties.keys ();

            while (keys.hasMoreElements ()) {
                String key = (String) keys.nextElement ();

                knowledgeMap.addKnowledge (key, (String) properties.get (key));

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        }
    }


    public KnowledgeMap getKnowledgeMap() {
        return knowledgeMap;
    }
}
