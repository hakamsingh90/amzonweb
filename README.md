# amzonweb
UI Automation using the Java-based POM test framework 

## Features
* Based on Maven build tool and testng based framework
* Provision to supply environment specific configurations 
* able to generate report
* able to take screenshots of failures  TC


## Prerequisite:

* Install JDK  and setup `JAVA_HOME`
* Apache Maven 3.8.6 
* IDE IntelliJ (you can choose any)

* Driver:  
Chrome driver is attached in Driver package. You can update the driver according to your chrome version. 
If you want to run this with a different browser .The driver can be found in the drivers folder.

## Running Tests:
* Clone the repo :
* check POM.xml file formate 
* Build the project by command : mvn dependency:resolve
* Setup testng Configuration 
* Make sure you copied driver accoring to your Browser and OS
* try to run :src/main/java/test/AmazonTest.java
* check report in directory :testoutput 
* check screenshot in directory Screenshots


