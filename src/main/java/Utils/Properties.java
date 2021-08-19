package Utils;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
    private static Properties propertyObj;

    public static Properties getInstance() {
        if (propertyObj == null) {
            propertyObj = new Properties();
        }
        return propertyObj;
    }

    public String getProperty(String property) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/application_test.properties"));
        return properties.getProperty(property);
    }
}
