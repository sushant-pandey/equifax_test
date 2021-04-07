These are the required test scripts for coding test.

Command to execute tests

mvn test
mvn test -Dbrowser=chrome

No support for any other browser

Location of UI Test Fixture:

src/test/resources/AmazonCheckout.feature

Location of API Test Fixture

src/test/resources/RestApiTest.feature

Location of Step Definitions

src/test/resources/ -> org.mindtree.equifax.stepsdefinition

API Tests Covered


Location of Configuration.properties


Location of JUnit TestRunner

src/test/resources/ -> org.mindtree.equifax.testrunner

Location of Page Objects

src/main/java

Location of Reports

target/

KNOWN ISSUES:

URL provided for API Test does not work all the time and repeatedly throws error 429 - Too Many Requests

