package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	static {
		loadProperties();
	}

	private static void loadProperties() {
		String path = System.getProperty("user.dir")+ "/src/main/java/config/config.properties";

		try (FileInputStream fis = new FileInputStream(path)) {
			prop = new Properties();
			prop.load(fis);

		} catch (IOException e) {
			throw new RuntimeException("Config file could not be loaded: " + path, e);
		}
	}

	public static String getProperty(String key) {
		String value = prop.getProperty(key);

		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException("Property '" + key + "' is not present in config.properties");
		}
		return value.trim();
	}

}
