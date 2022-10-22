package testng;

import org.testng.annotations.Test;

import pages.LoginPage;
import util.Excel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;

public class NewTest extends commonTestng.BaseSetup{
	
	static boolean dataDetails = true;
	static LoginPage loginPg;
	
	@Parameters({"username", "password"})
  @Test(priority = 0, groups = "smokeTest", retryAnalyzer = commonTestng.Retry.class)
  public void validLogin(String username, String password) {
	  loginPg.enterUsername(username);
	  loginPg.enterPassword(password);
	  loginPg.clickLoginBtn();	  
  }
  
  @Test(dataProvider = "loginDetails", priority = 1, dependsOnMethods = "validLogin", groups = "recursionTest", retryAnalyzer = commonTestng.Retry.class)
  public void testMultipleUserDetials(String uname, String pwd) {
	  if(dataDetails==false) {
		  throw new SkipException("Skipping this Test");
	  }
	  else {
		  loginPg.enterUsername(uname);
		  loginPg.enterPassword(pwd);
		  loginPg.clickLoginBtn();
		  Assert.assertEquals(loginPg.checkSuccessfulLogin(), true);
	  }
  }
  
  
  
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
	  loginPg.getToLoginPage();
  }

    
    @DataProvider
    public Object[][] loginDetails() {
    	Object[][] obj = Excel.excelWithHeadToObj("src/test/resources/userData.xlsx");
    	return obj;
    };
    
  @BeforeTest(alwaysRun = true)
  public void beforeTest() {
	  loginPg = PageFactory.initElements(driver, LoginPage.class);
  }

  @AfterTest(alwaysRun = true)
  public void afterTest() {
	  driver.close();
  }

}
