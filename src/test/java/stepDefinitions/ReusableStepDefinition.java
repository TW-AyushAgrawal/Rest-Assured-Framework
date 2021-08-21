package stepDefinitions;

import Utils.BaseTest;
import Utils.FileHandler;
import Utils.HttpMethods;
import Utils.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.TestDataBuilder;
import enums.APIResources;
import factory.RequestFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class ReusableStepDefinition extends BaseTest {

    @Given("User have valid endpoint")
    public void setEndpoint() throws Throwable {
        logFile= FileHandler.getLogFile();
        httpService = new HttpMethods(Properties.getProperty("base_url"));
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
        assertEquals(value, response.jsonPath().getString(param));
    }
}
