package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import core.Utilities;

public class LogInPage extends AbstractPage {
	
	public static void LoadResources() throws IOException {
		Properties config = Utilities.LoadConfigurations();
		FileInputStream stream = 
				new FileInputStream(config.getProperty("ResourceFilesDirectory") + "LoginPageResources.properties");
		LoadResourceFile(stream);
	}
	
	public static String EmailAddress() {
		return PageResources.getProperty("emailTextBoxId");
	}
	
	public static String Password() {
		return PageResources.getProperty("passwordTextBoxId");
	}
	
	public static String LogInButton() {
		return PageResources.getProperty("logInButtonId");
	}
}
