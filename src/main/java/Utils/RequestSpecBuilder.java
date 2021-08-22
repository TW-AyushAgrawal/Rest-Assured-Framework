package Utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RequestSpecBuilder extends BaseTest {

    private RequestSpecBuilder(){}

    private static RequestSpecification requestSpecification;

    public static void initRequestSpec(String baseURL){
        try (PrintStream logFile = FileHandler.getLogFile()) {
            requestSpecification =
                    RestAssured
                            .given()
                            .baseUri(baseURL)
                            .header("Content-Type", "application/json")
                            .urlEncodingEnabled(false)
                            .filter(RequestLoggingFilter.logRequestTo(logFile))
                            .filter(ResponseLoggingFilter.logResponseTo(logFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static RequestSpecification getRequestSpec(){
        return requestSpecification;
    }
}
