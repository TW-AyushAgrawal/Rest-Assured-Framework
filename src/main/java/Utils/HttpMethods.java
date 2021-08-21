package Utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class HttpMethods extends BaseTest {

    public HttpMethods(String baseURL) {
        RestAssured.baseURI = baseURL;

        requestSpecification = RestAssured.given().
                urlEncodingEnabled(false)
                .filter(RequestLoggingFilter.logRequestTo(logFile))
                .filter(ResponseLoggingFilter.logResponseTo(logFile));
        setHeader();
    }

    public void setHeader() {
        requestSpecification.header("Content-Type", "application/json");
    }
}
