package org.mindtree.equifax.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/RestApiTest.feature",
	glue = "org.mindtree.equifax.stepsdefinition",
	dryRun = false,
	monochrome = true,
	plugin = {"pretty", "html:target/HtmlReports.html", "json:target/cucumber.json"}
)
public class TestApiRunner {

}
