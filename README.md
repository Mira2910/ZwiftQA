# README file for Zwift

This is bbd style testing framework with cucumber build on JAVA programming language.
As a built tool I used MAVEN.
I implemented Page Object Model with Singleton Design Pattern.

  Structure of the Project:
    Packages:

	pages  --> I store all my webElements in different classes according to Web Pages
	
	runner --> Start point of execution, I setUp cucumberOption such as plugin, features, glue, dryRun
	
	stepdefenition  --> Here you will find implementation of the scenarios and Hook class where i implement
				takeAScreenShot method if scenario failed and attach this screenshot to report
	
	utils -->  Here I intitialize my webdriver base on name which comes from configuration.properties file, also I have BrowserMethod class
		   where I implement reusable methods, And I have ConfigurationReader to read properties file.


    resources:
		feature: ---> Here is feature file where I Describe Test scenarios and steps using gerking language


Pom dependecies and plugins that I used (all of them are open source):

        webDriverManager 
        selenium-java  
        cucumber-java
        cucumber-junit
        cucubmer-html-report
        junit
	maven-compiler-plugin
	maven-surefire-plugin
	maven-cucumber-reporting

In order to build this project please follow next maven commands in terminal:
	1. mvn clean
	2. mvn install

After execution you will able to find "final-pretty-reports" folder which will be placed under "target" folder.
In "final-pretty-reports" folder will be genereted report.
