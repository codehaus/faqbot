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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.codehaus.faqbot.KnowledgeMap;

/**
 * Concrete KnowledgeMap implementation
 * 
 * @author <a href='mailto:sebastianmohan@acm.org'>Sebastian Mohan</a>
 *         $Revision:...$
 */
public class AIMLKnowledgeMap implements KnowledgeMap {

    private Map<String, String> knowledgeMap;


    public AIMLKnowledgeMap() {
        knowledgeMap = new HashMap<String, String> ();
    }


    public void addKnowledge(String question, String answer) {
        knowledgeMap.put (question, answer);
    }


    public String getKnowledge(String name) {
        return knowledgeMap.get (name);
    }


    public Set<String> getKnowledgeNames() {
        return knowledgeMap.keySet ();
    }

}
