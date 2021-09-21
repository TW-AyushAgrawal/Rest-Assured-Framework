package utils;


import builders.RequestSpecBuilder;
import enums.APIResources;
import io.restassured.response.Response;


public class HttpMethodUtils {
    private HttpMethodUtils() {
    }

    public static Response post(String endPoint, Object object) {
        return RequestSpecBuilder.getRequestSpec()
                .body(object)
                .post(APIResources.valueOf(endPoint).getResource());
    }

    public static Response delete(String endPoint, String id, String paramKey) {
        return RequestSpecBuilder.getRequestSpec().pathParams(paramKey, id)
                .delete(APIResources.valueOf(endPoint).getResource());
    }
}
