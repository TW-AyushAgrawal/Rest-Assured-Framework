package stepDefinitions;

import Utils.BaseTest;
import Utils.HttpMethods;
import Utils.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.TestDataBuilder;
import enums.APIResources;
import factory.RequestFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class ReusableStepDefinition extends BaseTest {
    private static String newlyCreatedId;

    @Given("User have valid endpoint {string}")
    public void setEndpoint(String requestType) throws Throwable {
        prop = new Properties();
        mapper = new ObjectMapper();
        data = new TestDataBuilder();
        endpoint = APIResources.valueOf(requestType).getResource();
        httpService = new HttpMethods(prop.getProperty("base_url"));
    }

    @When("User request with json request payload for {string} and {string}")
    public void setRequestBodyParams(String name, String job) {
        response = httpService.post(data.getPostUserData(name, job),
                endpoint);
    }

    @When("User calls {string} to delete newly created user for {string}")
    public void userCallsReqResApiToDeleteTheUser(String requestType, String deleteKey) {
        newlyCreatedId = response.jsonPath().getString("id");
        response = httpService.deleteWithPathParam(deleteKey, newlyCreatedId, APIResources.valueOf(requestType).getResource());
    }

    @Then("API call should return status code {int}")
    public void api_call_should_return_status_code(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @When("User calls {string} with {string}")
    public void userCallsWith(String requestType, String params) {
        response = (Response) RequestFactory.executeRequest(requestType).apply(params, APIResources.valueOf(requestType).getResource());
    }
}
