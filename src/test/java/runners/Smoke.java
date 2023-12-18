package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        //glue is where we find implementations for gherkin steps
        //we provide the path of package to get all the step definition
        glue = "steps",
        //dryRun we use to get the step definition of undefined steps
        //if we set it to true, it will quickly scan all gherkin steps whether they are implemented or not
        //if we set it to true, it stops actual execution
        //to execute scripts in real time, we should set this value to false
        dryRun = false,
        //it means the console output for cucumber test is having irrelevant information
        //when we se it to true, it simply removes all the irrelevant information
        monochrome = true,
        tags = "Regression",
        plugin = {"html:target/cucumber.html", "pretty", "json:target/cucumber.json",
        "rerun:target/failed.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Smoke {
}
