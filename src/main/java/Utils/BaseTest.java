package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import data.TestDataBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.PrintStream;

public abstract class BaseTest {
    public static Response response;
    public static String endpoint;
    public static Properties prop;
    public static HttpMethods httpService;
    public static ObjectMapper mapper;
    public static TestDataBuilder data;
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public static PrintStream logFile;
}

