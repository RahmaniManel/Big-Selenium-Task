import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    // Properties object to hold the key-value pairs from the configuration file
    private Properties properties;

    // Constructor for the ConfigReader class
    public ConfigReader() {
        properties = new Properties();
        try {
            // Load the configuration file using ClassLoader
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (inputStream != null) {
                // Load the properties from the input stream
                properties.load(inputStream);
                // Close the input stream
                inputStream.close();
            } else {
                // Throw an exception if the configuration file is not found
                throw new IOException("config.properties file not found");
            }
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }

    // Method to get the value of a property by its key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

