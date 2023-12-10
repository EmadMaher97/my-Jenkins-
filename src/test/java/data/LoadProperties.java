package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    //load the file from the folder
    // Load the file from the folder
    public static Properties userData = loadProperties(System.getProperty("user.dir") + "/src/main/java/properties/userdata.properties");

    private static Properties loadProperties(String path) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
