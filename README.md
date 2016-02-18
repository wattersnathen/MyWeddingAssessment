#  MyWeddingAssessment

Site Under Test: [www.mywedding.com](http://www.mywedding.com)

### Project Summmary

This project was created as part of a technical assessment for a Test Automation role for mywedding.com. The objective was to use Java and Selenium WebDriver to navigate through the website and assert:

* that certain elements were present
* that certain elements were not present
* that certain elements contained certain information/data

### Steps to install and reproduce tests (from Eclipse IDE)

* Make sure Firefox is installed
  - tested with version 27
* Download Selenium WebDriver (Java bindings)
* Clone repo to local machine
  - change directory to your Eclipse workspace
  - git clone https:<span></span>//github.com/wattersnathen/MyWeddingAssessment.git
* From Eclipse ->
  - File -> Import...
  - Projects from Git
  - Existing local repository
  - navigate to the repo you cloned earlier
  - Import using the New Project Wizard
  - Chose Java Project
  - Fill in the Project name field with "MyWeddingAssessment"
  - Click next
  - Click on the Libraries tab, then click on "Add External JARs..."
  - Navigate to Selenium WebDriver downloads and chose
    * all .jar files in /lib/
    * selenium-java-*.jar file where * is the version number you downloaded
  - Click finish
  - Let Eclipse do the initial build
  - Go to the FindVendorsPage, right-click the class name:
    * chose Run As -> JUnit test

### Constraints and Conditions

* Used Firefox web browser only to expedite the development process
* Setup a Firefox profile to enable user shared location for mywedding.com
  - View [this post](http://stackoverflow.com/a/28390721) for setting up a Firefox profile on your local computer
  - The current test structure assumes a profile named "TestAutomation". You can change the anticipated profile name [on this line](https://github.com/wattersnathen/MyWeddingAssessment/blob/master/test/com/mywedding/basetest/BaseTestCase.java#L22)
* An Implicit Timeout of 10 seconds was sufficient on my local development machine to be able to locate all the elements necessary for the scenarios (i.e. no explicit waits were needed)
