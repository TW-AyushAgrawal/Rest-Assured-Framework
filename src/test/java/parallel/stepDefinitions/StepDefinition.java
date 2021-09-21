package parallel.stepDefinitions;

import utils.HttpMethodUtils;
import utils.ResponseExtractorUtils;
import contexts.TestContext;
import builders.TestDataBuilder;
import enums.APIResources;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class StepDefinition {

    TestContext testContext;
    private Response response;

    public StepDefinition(TestContext context) {
        testContext = context;
    }

    @Then("API call should return status code {int}")
    public void api_call_should_return_status_code(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @When("User calls {string} with {string}")
    public void userCallsWith(String requestType, String params) {
        if(requestType.equalsIgnoreCase("POST_USER_REQUEST")){
            response = HttpMethodUtils.post(requestType, TestDataBuilder.getPostUserData(params));
            testContext.getScenarioContext().setContext(APIResources.USER_ID, ResponseExtractorUtils.getValue(response, "id"));
        }
        else if(requestType.equalsIgnoreCase("DELETE_USER_REQUEST")){
            response=HttpMethodUtils.delete(requestType, testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), params);
        }
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        assertEquals(value, ResponseExtractorUtils.getValue(response, param));
    }
}
