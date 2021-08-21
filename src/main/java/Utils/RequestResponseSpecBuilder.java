package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RequestResponseSpecBuilder extends BaseTest {

    public RequestResponseSpecBuilder()  {
        try{
            logFile = new FileHandler().getLogFile();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public static RequestSpecification getRequestSpec() throws IOException {
        if (requestSpecification == null) {
            requestSpecification = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(logFile))
                    .addFilter(ResponseLoggingFilter.logResponseTo(logFile))
                    .build();
        }
        return requestSpecification;
    }
}
