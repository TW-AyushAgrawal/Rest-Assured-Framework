package Utils;

import io.restassured.RestAssured;

public class HttpMethods extends BaseTest   {

    public HttpMethods(String baseURL) {
        RestAssured.baseURI = baseURL;

        requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        setHeader();
    }

    public void setHeader() {
        requestSpecification.header("Content-Type", "application/json");
    }
}
