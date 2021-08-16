package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {
    public static Response response;
    public static String endpoint;
    public static Properties prop;
    public static HttpMethods httpService;
    public static ObjectMapper mapper;
}

