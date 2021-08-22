package stepDefinitions;

import Utils.Properties;
import Utils.RequestSpecBuilder;
import Utils.ResponseExtractor;
import enums.APIResources;
import factory.RequestFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public final class ReusableStepDefinition {

    private Response response;

    @Before("@Add_User")
    public void setEndpoint() throws Throwable {
        RequestSpecBuilder.initRequestSpec(Properties.getProperty("base_url"));
    }

    @Then("API call should return status code {int}")
    public void api_call_should_return_status_code(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @When("User calls {string} with {string}")
    public void userCallsWith(String requestType, String params) {
        response = RequestFactory.executeRequest(requestType, params, APIResources.valueOf(requestType).getResource());
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        assertEquals(value, ResponseExtractor.getValue(response, param));
    }
}
