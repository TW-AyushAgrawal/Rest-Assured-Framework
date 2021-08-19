package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import data.TestDataBuilder;
import io.restassured.response.Response;

public abstract class BaseTest {
    public static Response response;
    public static String endpoint;
    public static Properties prop;
    public static HttpMethods httpService;
    public static ObjectMapper mapper;
    public static TestDataBuilder data;
}

