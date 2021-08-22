package Utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilder extends BaseTest {

    private RequestSpecBuilder(){}

    private static RequestSpecification requestSpecification;

    public static void initRequestSpec(String baseURL){
        requestSpecification =
                RestAssured
                        .given()
                        .baseUri(baseURL)
                        .header("Content-Type", "application/json")
                        .urlEncodingEnabled(false)
                        .filter(RequestLoggingFilter.logRequestTo(logFile))
                        .filter(ResponseLoggingFilter.logResponseTo(logFile));
    }

    public static RequestSpecification getRequestSpec(){
        return requestSpecification;
    }
}
