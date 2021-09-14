package hooks;

import Utils.HttpMethodUtils;
import Utils.RequestSpecBuilder;
import contexts.TestContext;
import enums.APIResources;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public final class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setEndpoint(){
        RequestSpecBuilder.initRequestSpec(APIResources.valueOf("base_url").getResource());
    }

    @After(value = "@Add_User")
    public void afterAddScenario() {
        HttpMethodUtils.delete("DELETE_USER_REQUEST", testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), "id");
        System.out.println("Deleted the newly created user id : " + testContext.getScenarioContext().getContext(APIResources.USER_ID).toString());
    }
}
