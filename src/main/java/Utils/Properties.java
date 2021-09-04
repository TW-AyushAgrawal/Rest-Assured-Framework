package Utils;

import constants.FilePaths;

import java.io.FileInputStream;
import java.io.IOException;

public final class Properties {

    private Properties() {
    }

    public static String getProperty(String property) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        properties.load(new FileInputStream(FilePaths.getPropertiesFilePath()));
        return properties.getProperty(property);
    }
}
