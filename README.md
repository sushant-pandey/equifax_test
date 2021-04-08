# These are the required test scripts for coding test.

## Command to execute tests

mvn test
mvn test -Dbrowser=chrome

## Required Chrome version

89

#### No support for any other browser

## Location of UI Test Fixture:

src/test/resources/AmazonCheckout.feature

## Location of API Test Fixture

src/test/resources/RestApiTest.feature

## Location of Step Definitions

src/test/resources/ -> org.mindtree.equifax.stepsdefinition

## Location of Configuration.properties
/src/test/resources/config/Configuration.properties

## Location of JUnit TestRunner

src/test/resources/ -> org.mindtree.equifax.testrunner

## Location of Page Objects

src/main/java

## Location of Reports

target/

### KNOWN ISSUES:

The API URL repeatedly throws error [429 - Too Many Requests]

