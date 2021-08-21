package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import data.TestDataBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.PrintStream;

public abstract class BaseTest {
    public Response response;
    public static Properties prop;
    public HttpMethods httpService;
    public TestDataBuilder data;
    public static RequestSpecification requestSpecification;
    public static PrintStream logFile;
}

