package factory;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public final class RequestFactory {

    private static final Map<String, BiFunction> MAP = new HashMap();

    public static final BiFunction<String, String, Response> DELETE = (param, endPoint) -> RestAssured.given().pathParams("id",param).request(Method.DELETE, endPoint);

    static {
        MAP.put("DELETE_USER_REQUEST", DELETE);
    }

    public static BiFunction executeRequest(String requestType){
        return MAP.get(requestType);
    }
}
