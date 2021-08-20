package stepDefinitions;

import Utils.BaseTest;
import Utils.Properties;
import Utils.RequestResponseSpecBuilder;
import data.TestDataBuilder;
import enums.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PlaceStepDefinitions extends BaseTest {
    //    RequestSpecification requestSpecification;
    //    ResponseSpecification responseSpecification;
    //    TestDataBuilder data = new TestDataBuilder();
    //    RequestSpecification request;
    //    Response response;
          String id;


    @Given("Add User payload")
    public void add_place_payload() throws IOException {
        data = new TestDataBuilder();
        prop= new Properties();
        requestSpecification = new RequestResponseSpecBuilder().getRequestSpec();
        responseSpecification = new RequestResponseSpecBuilder().getResponseSpec();
        requestSpecification = given()
                .spec(requestSpecification);

    }

    @When("User calls ReqRes api with {string} with {string} and {string}")
    public void user_calls_req_res_api_with_with_and(String requestType, String name, String job) {
        response = requestSpecification
                .body(data.getPostUserData(name, job))
                .when()
                .post(APIResources.valueOf(requestType).getResource())
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
        id = response.jsonPath().getString("id");
    }

    @Then("API call should return status code {int}")
    public void api_call_should_return_status_code(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        assertEquals(value, response.jsonPath().getString(param));
    }

    @When("User calls ReqRes api with {string} to delete the user")
    public void userCallsReqResApiWithToDeleteTheUser(String requestType) {
        response = requestSpecification
                .when()
                .pathParam("id", id)
                .delete(APIResources.valueOf(requestType).getResource())
                .then()
                .extract()
                .response();
    }
}
