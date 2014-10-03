package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import core.Utilities;

public class UserHomePage extends AbstractPage {
	
	public static void LoadResources() throws IOException {
		Properties configs = Utilities.LoadConfigurations(); 
		FileInputStream stream = 
				new FileInputStream(configs.getProperty("ResourceFilesDirectory") + "UserHomePageResources.properties");
		LoadResourceFile(stream);
	}
	
	public static String FBLogo(){
		return PageResources.getProperty("FBLogoXPath");
	}
	
	public static String ProfileName() {
		return PageResources.getProperty("UsersNameLabelXPath");
	}
	
	public static String UserAccountAnchor() {
		return PageResources.getProperty("UserAccountAnchorId");
	}
	
	public static String LogOutButton() {
		return PageResources.getProperty("LogOutButtonXPath");
	}
}
