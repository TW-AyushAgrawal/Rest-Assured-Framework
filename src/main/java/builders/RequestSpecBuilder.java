package builders;

import constants.FilePaths;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.PrintStream;

public final class RequestSpecBuilder {

    private static RequestSpecification requestSpecification;

    private RequestSpecBuilder() {
    }

    public static void initRequestSpec(String baseURL) {
        try {
            PrintStream logFile = new PrintStream(FilePaths.getLogFilePath());
            logFile.flush();
            requestSpecification =
                    RestAssured
                            .given()
                            .baseUri(baseURL)
                            .header("Content-Type", "application/json")
                            .urlEncodingEnabled(false)
                            .filter(RequestLoggingFilter.logRequestTo(logFile))
                            .filter(ResponseLoggingFilter.logResponseTo(logFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpecification;
    }
}
