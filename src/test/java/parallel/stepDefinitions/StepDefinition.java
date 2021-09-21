package parallel.stepDefinitions;

import utils.HttpMethodUtils;
import utils.ResponseExtractor;
import contexts.TestContext;
import data.TestDataBuilder;
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
            response = HttpMethodUtils.post(requestType, TestDataBuilder.getPostUserData(params.split(",")[0], params.split(",")[1]));
            testContext.getScenarioContext().setContext(APIResources.USER_ID, ResponseExtractor.getValue(response, "id"));
            System.out.println("Newly Created user Id is " + testContext.getScenarioContext().getContext(APIResources.USER_ID));
        }
        else if(requestType.equalsIgnoreCase("DELETE_USER_REQUEST")){
            response=HttpMethodUtils.delete(requestType, testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), params);
            System.out.println("Deleted new User is "+ testContext.getScenarioContext().getContext(APIResources.USER_ID));

        }
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        assertEquals(value, ResponseExtractor.getValue(response, param));
    }
}
