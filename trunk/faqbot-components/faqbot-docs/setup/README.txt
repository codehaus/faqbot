
Overview
========

This document lists the steps to setup ProgramD libraries in the local repository


Steps
=====

1)	Latest release for Maven can be obtained from http://maven.apache.org/
2)  Following the instructions to install Maven 2 make it available on $PATH.
3)  Latest release for ProgramD can be obtained from http://www.aitools.org/
4)  After downloading these dependencies, install them in your local Maven 2 
    repository as follows.

    Note the following commands will require you to rename the JARs obtained
    for ProgramD to reflect a Maven convention.
    
    * To install programd JARs in local repo execute:
>   mvn install:install-file -Dfile=programd-main-4.6.jar -DgroupId=org.aitools -DartifactId=programd-main -Dversion=4.6 -Dpackaging=jar

>   mvn install:install-file -Dfile=programd-rhino-4.6.jar -DgroupId=org.aitools -DartifactId=programd-rhino -Dversion=4.6 -Dpackaging=jar

    (*See http://maven.apache.org/guides/mini/guide-installing-3rd-party-jars.html)

5)  You will need some AIML sets to get started with ProgramD. Some AIML sets 
    can be obtained from from http://aitools.org/aiml-sets/

6)  Check out FAQBot project into a separate Eclipse workspace. 

7)  From the command prompt, 'cd' to the root of each project and run 
>   mvn eclipse:eclipse -Dwtpversion=1.0 

    This should generate an Eclipse project. Now refresh the projects displayed
    in the workspace.


NOTE: As of this writing working code is under sandbox, this will be graduated 
      out to under 'faqbot-components' projects when we are ready to do a first 
      release.
