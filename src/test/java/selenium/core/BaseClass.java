package core;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public WebDriver webDriver;
	public String BaseUrl;
	
	public BaseClass() throws IOException {
		Properties configs = Utilities.LoadConfigurations();
		BaseUrl = configs.getProperty("BaseUrl");
	}
	
	public void InstantiateWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriver.manage().window().maximize();
	}
	
	public void NavigateTo(String url){
		this.webDriver.navigate().to(BaseUrl + url);
	}
}
