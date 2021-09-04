package hooks;

import Utils.Properties;
import Utils.RequestSpecBuilder;
import contexts.TestContext;
import enums.APIResources;
import factory.RequestFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public final class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setEndpoint() throws Throwable {
        RequestSpecBuilder.initRequestSpec(Properties.getProperty("base_url"));
    }

    @After
    public void afterScenario() {
        RequestFactory.executeRequest("DELETE_USER_REQUEST", testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), APIResources.valueOf("DELETE_USER_REQUEST").getResource());
        System.out.println("Deleted the newly created user id : " + testContext.getScenarioContext().getContext(APIResources.USER_ID).toString());
    }
}
