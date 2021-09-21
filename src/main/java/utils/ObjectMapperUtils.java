package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.PostUsers;

import java.io.File;
import java.io.IOException;

public final class ObjectMapperUtils {
    private ObjectMapperUtils(){}

    public static Object getObjectFromJSON(String jsonFilePath, Class<PostUsers> targetClass) throws IOException {
        return new ObjectMapper().readValue(new File(jsonFilePath), targetClass);
    }
}
