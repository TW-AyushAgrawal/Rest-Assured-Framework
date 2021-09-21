package parallel.hooks;

import contexts.TestContext;
import enums.APIResources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import pojo.PostUsers;
import utils.HttpMethodUtils;
import builders.RequestSpecBuilder;
import utils.ResponseExtractorUtils;

import java.io.IOException;

import static constants.FilePaths.getUsersJsonFilePath;
import static utils.ObjectMapperUtils.getObjectFromJSON;

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
    public void hitPostEndpoint() throws IOException {
        response = HttpMethodUtils.post("POST_USER_REQUEST", getObjectFromJSON(getUsersJsonFilePath(), PostUsers.class));
        testContext.getScenarioContext().setContext(APIResources.USER_ID, ResponseExtractorUtils.getValue(response, "id"));
    }

    @After(value = "@Add_User")
    public void afterAddScenario() {
        response=HttpMethodUtils.delete("DELETE_USER_REQUEST", testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), "id");
    }
}
