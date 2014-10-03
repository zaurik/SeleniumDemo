package pageFlow;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.BaseClass;
import pageObjects.LogInPage;

public class LogInPageFlow extends BaseClass {
			
	public LogInPageFlow(WebDriver webDriver) throws IOException {
		LogInPage.LoadResources();
		InstantiateWebDriver(webDriver);
	}
	
	public void LogIn(String username, String password){
		this.webDriver.findElement(By.id(LogInPage.EmailAddress())).sendKeys(username);
		this.webDriver.findElement(By.id(LogInPage.Password())).sendKeys(password);
		
		this.webDriver.findElement(By.id(LogInPage.LogInButton())).click();
	}
}
