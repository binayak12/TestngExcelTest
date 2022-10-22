package commonTestng;

import org.testng.annotations.Test;

import util.BrowserFactory;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseSetup {
	
	public static WebDriver driver;
	
  @BeforeSuite(alwaysRun = true)
  public void beforeSuite() {
	  driver = BrowserFactory.getBrowser();
  }

  @AfterSuite(alwaysRun = true)
  public void afterSuite() {
	  driver.quit();
  }

}
