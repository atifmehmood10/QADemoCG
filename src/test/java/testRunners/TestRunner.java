package testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features="src/test/resources/features",
        glue={"stepDefinitions", "utilities"},
        tags=""
    )
public class TestRunner extends AbstractTestNGCucumberTests {
}


