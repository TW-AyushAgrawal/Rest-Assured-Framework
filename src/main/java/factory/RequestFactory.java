package factory;

import Utils.BaseTest;
import data.TestDataBuilder;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.function.BiFunction;

public final class RequestFactory extends BaseTest {

    private RequestFactory() {}

    private static final HashMap<String, BiFunction<String, String, Response>> MAP = new HashMap();

    private static final BiFunction<String, String, Response> DELETE = (arg, endPoint) -> RestAssured.given().pathParams("id",arg).request(Method.DELETE, endPoint);
    private static final BiFunction<String, String, Response> POST = (args, endPoint) ->
    {
        Response response = null;
        response =  requestSpecification
                .body(TestDataBuilder.getPostUserData(args.split(",")[0], args.split(",")[1]))
                .request(Method.POST, endPoint);

        return response;
    };

    static {
        MAP.put("DELETE_USER_REQUEST", DELETE);
        MAP.put("POST_USER_REQUEST", POST);
    }

    public static Response executeRequest(String requestType, String params, String endPoint){
        return MAP.get(requestType).apply(params, endPoint);
    }
}
