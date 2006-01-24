package org.codehaus.faqbot;

import org.aitools.programd.Core;
import org.aitools.programd.interfaces.Console;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * FAQBot Console for Bot-User interaction.
 * 
 * @author <a href="rahul.thakur.xdev@gmail.com">Rahul Thakur</a>
 * @revision $Id$
 */
public class BotConsole {

    private static final Log log = LogFactory.getLog (BotConsole.class);

    private Core core;

    private Console console;

    /**
     * Flag to determine if the Console is initialized.
     */
    private boolean initialized = false;


    public BotConsole(String coreProps, String consoleProps) {
        this.core = new Core (coreProps);
        this.console = new Console (consoleProps);
    }


    /**
     * Initializes the FAQBot console.
     */
    public void init() {
        if (!isInitialized ()) {
            this.console.attachTo (this.core);
            this.core.setup ();
            this.initialized = true;
        }
    }


    /**
     * Determines if {@link BotConsole} instance was initialized.
     * 
     * @return
     */
    public boolean isInitialized() {
        return this.initialized;
    }


    /**
     * Returns the {@link Console} instance that this {@link BotConsole}
     * instance is using to interact with another client.
     * 
     * @return
     */
    public Console getConsole() {
        return console;
    }


    /**
     * Returns the {@link Core} instance that is attached to the {@link Console}
     * instance being used by this {@link BotConsole}'s instance.
     * 
     * @return
     */
    public Core getCore() {
        return core;
    }


    /**
     * Starts the core and the shell (if enabled) and sends the connect string.
     */
    public void run() {
        if (!isInitialized ())
            throw new IllegalStateException ("BotConsole is not initialized yet");
        this.core.start ();
        if (log.isInfoEnabled ())
            log.info ("Core processing response with connect String: " + this.core.getSettings ().getConnectString ());
        // Send the connect string.
        this.core.processResponse (this.core.getSettings ().getConnectString ());
        this.console.startShell ();
    }

}
