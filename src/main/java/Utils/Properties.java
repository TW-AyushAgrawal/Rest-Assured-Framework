package Utils;

import java.io.FileInputStream;
import java.io.IOException;

public final class Properties {

    private Properties(){}

    public static String getProperty(String property) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/application_test.properties"));
        return properties.getProperty(property);
    }
}
