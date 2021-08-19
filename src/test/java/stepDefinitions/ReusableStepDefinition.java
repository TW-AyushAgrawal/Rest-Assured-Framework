package stepDefinitions;

import Utils.BaseTest;
import Utils.HttpMethods;
import Utils.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.TestDataBuilder;
import enums.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ReusableStepDefinition extends BaseTest {
    private static String newlyCreatedId;

    @Given("User have valid endpoint {string}")
    public void setEndpoint(String requestType) throws Throwable {
        prop = Properties.getInstance();
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
        newlyCreatedId = response.jsonPath().get("id");
        response = httpService.deleteWithPathParam(deleteKey, newlyCreatedId, APIResources.valueOf(requestType).getResource());
        System.out.println("Response is " + response.prettyPrint());
    }
}
