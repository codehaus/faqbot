Built with maven2

There is an issue with the automated build because one of the unit tests places locks on a file that later needs to be added to the jar. Maven2 will throw an errow when compiled with m2 install. You can build the jar file by cd to the tequilabot subdirectory and running the command m2 jar:jar

You may need to place the programd-4.5.jar file in your maven2 repository in the folder aitools/programd/4.5/

The tequilabot .jar file produced by maven should be extracted to the web-apps folder of the xwiki install

Alternatively, if you have the packaged xwiki-faqbot-jetty-0.9.84.zip, you can extract it to any folder and run the start.bat file. Go to XWiki.FaqbotClass, create your own Faqbot document, and test it out.
