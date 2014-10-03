package pageFlow;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseClass;
import pageObjects.UserHomePage;

public class UserHomePageFlow extends BaseClass {
	
	public UserHomePageFlow(WebDriver webDriver) throws IOException {
		UserHomePage.LoadResources();
		InstantiateWebDriver(webDriver);
	}
	
	public void LogOut(){	
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(UserHomePage.UserAccountAnchor())));
		
		this.webDriver.findElement(By.id(UserHomePage.UserAccountAnchor())).click();
		this.webDriver.findElement(By.xpath(UserHomePage.LogOutButton())).click();
	}
}
