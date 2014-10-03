package testCases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	protected WebDriver webDriver ;
	
	@Before
	public void setUp() throws Exception {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		webDriver.quit();
	}
	
}
