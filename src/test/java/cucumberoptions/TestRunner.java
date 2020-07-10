package cucumberoptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		features= "src/test/java/features",
		glue="stepdefinations")

public class TestRunner extends AbstractTestNGCucumberTests{

}
