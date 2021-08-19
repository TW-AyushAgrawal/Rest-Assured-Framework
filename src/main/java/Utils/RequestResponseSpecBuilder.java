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

public class RequestResponseSpecBuilder extends BaseTest {

//    private static RequestSpecification req;
//    private static ResponseSpecification res;
//    private static PrintStream logFile;

//    static {
//        try {
//            logFile = FileHandler.getInstance().getLogFile();
//            Properties prop= new Properties();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public RequestResponseSpecBuilder()  {
        try{
            logFile = new FileHandler().getLogFile();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public  RequestSpecification getRequestSpec() throws IOException {
        if (requestSpecification == null) {
            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(prop.getProperty("base_url"))
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(logFile))
                    .addFilter(ResponseLoggingFilter.logResponseTo(logFile))
                    .build();
        }
        return requestSpecification;
    }

    public  ResponseSpecification getResponseSpec() {
        if (responseSpecification == null) {
            responseSpecification = new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .setDefaultParser(Parser.JSON)
                    .build();
        }
        return responseSpecification;
    }
}
