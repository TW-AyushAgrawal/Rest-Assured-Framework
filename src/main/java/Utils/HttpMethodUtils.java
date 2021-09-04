package Utils;


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

    public static Response delete(String endPoint, String id) {
        return RequestSpecBuilder.getRequestSpec().pathParams("id", id)
                .delete(APIResources.valueOf(endPoint).getResource());
    }
}
