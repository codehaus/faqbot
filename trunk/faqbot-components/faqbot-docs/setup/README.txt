
Overview
========

This document lists the steps to add ProgramD libraries in to the Maven local repository and create the Eclipse project.


Steps
=====

1)  Latest release for Maven can be obtained from http://maven.apache.org/

2)  Following the instructions to install Maven 2 make it available on $PATH.

3)  Latest release for ProgramD can be obtained from http://www.aitools.org/

4)  After downloading these dependencies, install them in your local Maven 2 
    repository as follows.

    Note the following commands will require you to rename the JARs obtained
    for ProgramD to reflect a Maven convention.
    (*See http://maven.apache.org/guides/mini/guide-installing-3rd-party-jars.html)
    
    * To install programd JARs in local repo execute:
	>   mvn install:install-file -Dfile=programd-main-4.6.jar -DgroupId=org.aitools -DartifactId=programd-main -Dversion=4.6 -Dpackaging=jar

	>   mvn install:install-file -Dfile=programd-rhino-4.6.jar -DgroupId=org.aitools -DartifactId=programd-rhino -Dversion=4.6 -Dpackaging=jar
    

5)  Installing IRC listener JAR in local M2 repo.

  5-1)  Download the IRC listener JAR from: 
        http://aitools.org/downloads/#irclistener

  5-2)  Extract the contents of the downloaded zip archive to a folder.
  
  5-3)  'cd' to the folder in (5-2) and rename pircbot.jar (under 'lib' folder)
        to pircbot-1.4.4.jar

  5-4)  Install the pircbot JAR in local M2 repo using following:
  
	>       mvn install:install-file -Dfile=pircbot-1.4.4.jar -DgroupId=org.jibble -DartifactId=jibble-pircbot -Dversion=1.4.4 -Dpackaging=jar

  5-5)  'cd' to the 'distrib' folder under the folder used in (8-2). Rename 
        'irc-listener.jar'  to 'programD-irc-listener-1.2.1.jar'.
  
  5-6)  Install programD-irc-listener-1.2.1.jar in local M2 repo using: 
  
	>       mvn install:install-file -Dfile=programD-irc-listener-1.2.1.jar -DgroupId=org.aitools -DartifactId=programD-irc-listener -Dversion=1.2.1 -Dpackaging=jar


6)  You will need some AIML sets to get started with ProgramD. Some AIML sets 
    can be obtained from from http://aitools.org/aiml-sets/

7)  Check out FAQBot project from SVN in to a seperate folder.

8)  'cd' to the 'faqbot-components' folder for the project and run the 
    following command:
    
	>   mvn -N install 

    This installs the pom-only project in the local repository and makes it 
    available for child modules.

9)  From the command prompt, 'cd' to the root of each project and run 
	>   mvn eclipse:eclipse -Dwtpversion=1.0 

    This should generate an Eclipse project. Now import the 'sandbox' folder 
    into the workspace. This should setup the appropriate Java projects.

10) Import the projects under /sandbox directory into a separate Eclipse workspace. 

NOTE: As of this writing working code is under sandbox, this will be graduated 
      out to under 'faqbot-components' projects when we are ready to do a first 
      release.
