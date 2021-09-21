package utils;

import io.restassured.response.Response;

public final class ResponseExtractorUtils {
    private ResponseExtractorUtils() {
    }

    public static Object getValue(Response response, String key) {
        return response.jsonPath().get(key);
    }

}
