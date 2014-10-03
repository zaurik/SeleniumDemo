package testCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFlow.LogInPageFlow;
import pageFlow.UserHomePageFlow;
import pageObjects.UserHomePage;
import testCases.AbstractTest;

@RunWith(Parameterized.class)
public class FBLoginTest extends AbstractTest {
	
	private String emailAddress;
	private String password;
	private String expectedResult;

	public FBLoginTest(String emailAddress, String password, String expectedResult)
	{
		this.emailAddress = emailAddress;
		this.password = password;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<String[]> data() throws IOException {
		return getTestData();
	}
	
	private static Collection<String[]> getTestData() throws IOException {
		String record;
		List<String[]> records = new ArrayList<String[]>();
		
		BufferedReader file = 
				new BufferedReader(new FileReader("src\\test\\java\\selenium\\testData\\files\\LogInData.csv"));
		while ((record = file.readLine()) != null){
			String fields[] = record.split(",");
			records.add(fields);
		}
		
		file.close();
		return records;
	};

	@Test
	public void testSuccessfulLogin() throws IOException {
		LogInPageFlow pageFlow = new LogInPageFlow(this.webDriver);
		
		pageFlow.NavigateTo("");
		pageFlow.LogIn(this.emailAddress, this.password);
		
		UserHomePageFlow homePageFlow = new UserHomePageFlow(this.webDriver);
		
		WebDriverWait wait = new WebDriverWait(this.webDriver, 10);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UserHomePage.FBLogo())));
		
		WebElement profileName = 
				this.webDriver.findElement(By.xpath(UserHomePage.ProfileName()));
		
		Assert.assertTrue("Profile name is different", profileName.getText().equalsIgnoreCase(this.expectedResult));
		
		homePageFlow.LogOut();
	}
}
