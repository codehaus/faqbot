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
package org.codehaus.faqbot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.aitools.programd.Core;
import org.aitools.programd.listener.ProgramDPircBot;
import org.aitools.programd.util.DeveloperError;
import org.aitools.programd.util.URLTools;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

/**
 * <em>Test Driver </em><br>
 * Connects to the <code>#faqbot</code> channel on
 * <code>irc.codehaus.org</code> server, outputs a few messages and then
 * exits.
 * 
 * @author <a href='mailto:rahul.thakur.xdev@gmail.com'>Rahul Thakur</a>
 */
public class TestDriver {

    /**
     * @param args
     */
    public static void main(String [] args) {
        URL baseURL;
        ProgramDPircBot bot = null;
        Core core = null;
        try {
            // E:\programd-4.6\ProgramD\conf
            baseURL = URLTools.createValidURL (System.getProperty ("user.dir"));
            // baseURL = URLTools.createValidURL
            // ("E:\\programd-4.6\\ProgramD\\conf");
            core = new Core (baseURL);
            bot = new ProgramDPircBot ("FAQBot01", core, "FAQBot01");
            bot.connect ("irc.codehaus.org");
            bot.joinChannel ("#faqbot");
            System.out.println ("Joined #faqbot channel");
            int msgCount = 5;
            while (bot.isConnected () && msgCount > 0) {
                // do nothing
                Thread.sleep (1000L);
                bot.sendMessage ("#faqbot", "I am still learning!");
                msgCount--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (NickAlreadyInUseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        } catch (IrcException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        } catch (DeveloperError e) {
            e.printStackTrace ();
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace ();
        } finally {
            if (null != bot && bot.isConnected ()) {
                bot.disconnect ();
                core.shutdown ();
                // bot.quitServer ("Bot terminated!");
            }
            // with JDK6.0 - JVM does not exit if this is not called.
            System.exit(0);
        }
    }

}
