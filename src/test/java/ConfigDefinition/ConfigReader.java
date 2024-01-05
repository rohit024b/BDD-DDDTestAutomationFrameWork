package ConfigDefinition;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class ConfigReader {
    private static JSONObject jsonConfig;

    static {
        try {
            // Read the content of the JSON file into a string
            String content = new String(Files.readAllBytes(Paths.get("Resources/config.json")));
            // Parse the string content into a JSONObject
            jsonConfig = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return jsonConfig.getString(key);
    }
}
