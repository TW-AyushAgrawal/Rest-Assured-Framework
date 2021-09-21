package hooks;

import Utils.HttpMethodUtils;
import Utils.RequestSpecBuilder;
import Utils.ResponseExtractor;
import contexts.TestContext;
import data.TestDataBuilder;
import enums.APIResources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

public final class Hooks {
    TestContext testContext;
    Response response;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setEndpoint(){
        RequestSpecBuilder.initRequestSpec(APIResources.valueOf("base_url").getResource());
    }

    @Before(value = "@Delete_User")
    public void hitPostEndpoint(){
        response = HttpMethodUtils.post("POST_USER_REQUEST", TestDataBuilder.getPostUserData("Test1", "job"));
        testContext.getScenarioContext().setContext(APIResources.USER_ID, ResponseExtractor.getValue(response, "id"));
        System.out.println("Newely created user is " + testContext.getScenarioContext().getContext(APIResources.USER_ID));
    }

    @After(value = "@Add_User")
    public void afterAddScenario() {
        HttpMethodUtils.delete("DELETE_USER_REQUEST", testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), "id");
        System.out.println("Deleted the newly created user id : " + testContext.getScenarioContext().getContext(APIResources.USER_ID).toString());
    }
}
