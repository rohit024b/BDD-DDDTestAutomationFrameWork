package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
//		tags = "@smoke",
		features = {"Features/navigationBar.feature"},
		glue = {"stepDefinitions", "pageObjects"},
//		dryRun = true,
//		monochrome = true,
		plugin = {
				"pretty",
				"html:target/CucumberReport.html"
//				"json:build/cucumber-reports/cucumber.json",
//	            "rerun:build/cucumber-reports/rerun.txt"}

		}
		)
public class testRun extends AbstractTestNGCucumberTests{

}
