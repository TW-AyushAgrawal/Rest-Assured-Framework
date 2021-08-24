package cucumber.options;

import Utils.Properties;
import Utils.RequestSpecBuilder;

import contexts.TestContext;
import enums.APIResources;
import enums.Context;
import factory.RequestFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.AllArgsConstructor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = { "pretty", "html:target/cucumber-reports.html" }
)

public class TestRunner {

    @BeforeClass
    public static void setEndpoint() throws Throwable {
        RequestSpecBuilder.initRequestSpec(Properties.getProperty("base_url"));
    }
    @AfterClass
    public static void afterScenario(){
        RequestFactory.executeRequest("DELETE_USER_REQUEST", TestContext.getScenarioContext().getContext(Context.USER_ID).toString(), APIResources.valueOf("DELETE_USER_REQUEST").getResource());
    }


}
