package Utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

public class HttpMethods extends BaseTest   {

//    RequestSpecification httpRequest;
//    Response response;


    public HttpMethods(String baseURL) {
        RestAssured.baseURI = baseURL;

        requestSpecification = RestAssured.given().urlEncodingEnabled(false);
        setHeader();
    }

    public void setHeader() {

        requestSpecification.header("Content-Type", "application/json");

    }

    public Response post(Object jsonPayload, String endPoint) {
        requestSpecification.body(jsonPayload).log().all();
        response = requestSpecification.request(Method.POST, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response getWithQueryParams(Map<String, String> parameters, String endPoint) {
        requestSpecification.queryParams(parameters).log().all();
        response = requestSpecification.request(Method.GET, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response getWithPathParams(String key, String parameters, String endPoint) {
        requestSpecification.pathParams(key, parameters).log().all();
        response = requestSpecification.request(Method.GET, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response put(File jsonPayload, String endPoint) {
        requestSpecification.body(jsonPayload).log().all();
        response = requestSpecification.request(Method.PUT, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response deleteWithPathParam(String key, String parameter, String endPoint) {
        requestSpecification.pathParams(key, parameter).log().all();
        response = requestSpecification.request(Method.DELETE, endPoint);
        response.prettyPrint();
        return response;
    }

}
