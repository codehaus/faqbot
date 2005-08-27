Built with maven2

You may need to place the programd-4.5.jar file in your maven2 repository in the folder aitools/programd/4.5/

There is an issue with one of the unit tests locking a file that is later used to build the jar. To get around this, run m2 install then m2 jar:jar to build the jar file.

The tequilabot .jar file produced by maven should be extracted to the web-apps folder of the xwiki install

Alternatively, if you have the packaged xwiki-faqbot-jetty-0.9.84.zip, you can extract it to any folder and run the start.bat file. Go to XWiki.FaqbotClass, create your own Faqbot document, and test it out.