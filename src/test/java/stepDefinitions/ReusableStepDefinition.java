package stepDefinitions;

import Utils.ResponseExtractor;
import contexts.TestContext;
import enums.APIResources;
import factory.RequestFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class ReusableStepDefinition {

    TestContext testContext;
    private Response response;

    public ReusableStepDefinition(TestContext context) {
        testContext = context;
    }

    @Then("API call should return status code {int}")
    public void api_call_should_return_status_code(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @When("User calls {string} with {string}")
    public void userCallsWith(String requestType, String params) {
        response = RequestFactory.executeRequest(requestType, params, APIResources.valueOf(requestType).getResource());

        if (requestType.equalsIgnoreCase("POST_USER_REQUEST")) {
            testContext.getScenarioContext().setContext(APIResources.USER_ID, ResponseExtractor.getValue(response, "id"));
            System.out.println("Newly Created user Id is " + testContext.getScenarioContext().getContext(APIResources.USER_ID));
        }
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        assertEquals(value, ResponseExtractor.getValue(response, param));
    }

    @When("User calls {string}")
    public void userCalls(String requestType) {

        response = RequestFactory.executeRequest(requestType, testContext.getScenarioContext().getContext(APIResources.USER_ID).toString(), APIResources.valueOf(requestType).getResource());
    }
}
