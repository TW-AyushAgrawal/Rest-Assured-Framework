package cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        tags = "@Add_Delete"
)
public class TestRunner {
}
