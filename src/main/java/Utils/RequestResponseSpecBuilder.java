package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class RequestResponseSpecBuilder {
    private static RequestSpecification req;
    private static ResponseSpecification res;
    private static PrintStream logFile;

    static {
        try {
            logFile = FileHandler.getInstance().getLogFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static RequestSpecification getRequestSpec() throws IOException {
        if (req == null) {
            req = new RequestSpecBuilder()
                    .setBaseUri(Properties.getInstance().getProperty("base_url"))
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(logFile))
                    .addFilter(ResponseLoggingFilter.logResponseTo(logFile))
                    .build();
        }
        return req;
    }

    public static ResponseSpecification getResponseSpec() {
        if (res == null) {
            res = new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .setDefaultParser(Parser.JSON)
                    .build();
        }
        return res;
    }
}
