package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	public static Properties LoadConfigurations() throws IOException {
		Properties configurations = new Properties();
		String baseDirectory = new File(".").getAbsolutePath();
		String settingsDirectory = baseDirectory + "\\src\\test\\java\\selenium\\core\\settings\\config.properties";
		
		FileInputStream stream = new FileInputStream(settingsDirectory);
		configurations.load(stream);
		
		return configurations;
	}
}
