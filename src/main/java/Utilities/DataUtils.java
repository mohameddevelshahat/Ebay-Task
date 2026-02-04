package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {

    // TODO: Reading from Json File

    private static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    public static String getJsonData(String fileName , String field) throws FileNotFoundException {

        FileReader reader = new FileReader(TEST_DATA_PATH + fileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }

    // TODO: Reading from Properties File

    public static String getPropertyValue(String fileName , String key) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH + fileName + ".properties"));
        return properties.getProperty(key);
    }
}
