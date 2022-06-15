# Selenium Page object Model Project 
## Test Cases
* Sign up with valid email
* Attempt to sign up with invalid email
* Attempt to sign up with empty email
* Attempt to sign up with empty name
* Attempt to sign up with empty password
* Attempt to sign up without accepting terms and conditions

## Prerequisites
* Install jdk 8 or any LTS version
* Configure **JAVA_HOME** 
* Download Latest Gradle version and configure **GRADLE_HOME**
* Stable internet connection

## How to run this project
* Clone the repo
* Enter your email in the [information.json](https://github.com/asif-shahriar/Selenium-POM-Miro/blob/main/src/test/resources/information.json "information.json") file
* Open cmd in the root folder
* Give following command
```
gradle clean test
```

**Enter a new email in the "information.json" file each time you run this project**
