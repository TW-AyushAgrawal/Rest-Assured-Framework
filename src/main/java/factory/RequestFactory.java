package factory;

import Utils.RequestResponseSpecBuilder;
import data.TestDataBuilder;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.BiFunction;

public final class RequestFactory {

    private RequestFactory() {}

    private static final HashMap<String, BiFunction<String, String, Response>> MAP = new HashMap();

    private static final BiFunction<String, String, Response> DELETE = (arg, endPoint) -> RestAssured.given().pathParams("id",arg).request(Method.DELETE, endPoint);
    private static final BiFunction<String, String, Response> POST = (args, endPoint) ->
    {
        Response response = null;
        try {
            response =  RequestResponseSpecBuilder.getRequestSpec()
                    .body(new TestDataBuilder().getPostUserData(args.split(",")[0], args.split(",")[1]))
                    .request(Method.POST, endPoint);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
