package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AbstractPage {
	public static Properties PageResources;
	
	public static void LoadResourceFile(FileInputStream stream) throws IOException	{
		PageResources = new Properties();
		PageResources.load(stream);
	}
}
