// $headURL$
// $LastChangedBy$
// $LastChangedDate$
/**
 *    Copyright 2006  <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
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
package org.codehaus.faqbot.event;

import java.util.EventObject;

import org.codehaus.faqbot.model.Stimulus;

/**
 * Stimulus is any action by an Actor which can activate the Bot.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 * $Id$
 */
public abstract class StimulusDetectedEvent extends EventObject {
    
    private Object source;
    
    public StimulusDetectedEvent(Object source) {
        super (source);
    }
    
    public Stimulus getStimulus () {
        return (Stimulus) this.source;
    }

}
