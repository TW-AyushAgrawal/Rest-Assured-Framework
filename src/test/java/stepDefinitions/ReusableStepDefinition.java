package stepDefinitions;

import Utils.BaseTest;
import Utils.HttpMethods;
import Utils.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReusableStepDefinition extends BaseTest {
    private static String newlyCreatedId;

    @Given("User have valid endpoint {string}")
    public void setEndpoint(String endPoint) throws Throwable {
        prop = Properties.getInstance();
        mapper = new ObjectMapper();
        endpoint = endPoint;
        httpService = new HttpMethods(prop.getProperty("base_url"));

    }

    @When("User request with json request payload for {string}")
    public void setRequestBodyParams(String requestBody) {

        response = httpService.post(new File(
                        System.getProperty("user.dir") +
                                "/src/test/request/" + requestBody),
                endpoint);

    }

    @Then("User should receive the following response value {string} should be {string}, {string} should be {string} and {int} statusCode")
    public void assertResponseData(String param1, String expectedValue1, String param2,String expectedValue2, int statusCode) {
        JsonPath jsonPath = new JsonPath(response.asString());
        assertEquals(expectedValue1, jsonPath.getString(param1));
        assertEquals(expectedValue2, jsonPath.getString(param2));
        assertEquals(statusCode, response.getStatusCode());
        newlyCreatedId=jsonPath.get("id");

    }
    @When("User calls {string} to delete newly created user for {string}")
    public void userCallsReqResApiWithToDeleteTheUser(String endPont,String deleteKey) {
        response = httpService.deleteWithPathParam(deleteKey,newlyCreatedId, endPont);
    }
}
