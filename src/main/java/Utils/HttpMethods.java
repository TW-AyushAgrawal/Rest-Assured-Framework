package Utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

public class HttpMethods {

    RequestSpecification httpRequest;
    Response response;


    public HttpMethods(String baseURL) {
        RestAssured.baseURI = baseURL;

        this.httpRequest = RestAssured.given().urlEncodingEnabled(false);
        setHeader();
    }

    public void setHeader() {

        httpRequest.header("Content-Type", "application/json");

    }

    public Response post(Object jsonPayload, String endPoint) {
        httpRequest.body(jsonPayload).log().all();
        response = httpRequest.request(Method.POST, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response getWithQueryParams(Map<String, String> parameters, String endPoint) {
        httpRequest.queryParams(parameters).log().all();
        response = httpRequest.request(Method.GET, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response getWithPathParams(String key, String parameters, String endPoint) {
        httpRequest.pathParams(key, parameters).log().all();
        response = httpRequest.request(Method.GET, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response put(File jsonPayload, String endPoint) {
        httpRequest.body(jsonPayload).log().all();
        response = httpRequest.request(Method.PUT, endPoint);
        response.prettyPrint();
        return response;
    }

    public Response deleteWithPathParam(String key, String parameter, String endPoint) {
        httpRequest.pathParams(key, parameter).log().all();
        response = httpRequest.request(Method.DELETE, endPoint);
        response.prettyPrint();
        return response;
    }

}
