package Utils;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.PrintStream;

public abstract class BaseTest {
    public Response response;
    public HttpMethods httpService;
    public static RequestSpecification requestSpecification;
    public static PrintStream logFile;
}

