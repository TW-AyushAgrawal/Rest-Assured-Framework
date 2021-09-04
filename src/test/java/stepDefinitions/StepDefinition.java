package stepDefinitions;

import Utils.HttpMethodUtils;
import Utils.ResponseExtractor;
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

    @When("User calls {string} with {string} and {string}")
    public void userCallsWith(String requestType, String name, String job) {
        response = HttpMethodUtils.post(requestType, TestDataBuilder.getPostUserData(name, job));
        testContext.getScenarioContext().setContext(APIResources.USER_ID, ResponseExtractor.getValue(response, "id"));
        System.out.println("Newly Created user Id is " + testContext.getScenarioContext().getContext(APIResources.USER_ID));
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        assertEquals(value, ResponseExtractor.getValue(response, param));
    }
}
