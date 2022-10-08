package testCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import util.BrowserFactory;

public class TestCode {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		WebDriver driver = BrowserFactory.getBrowser();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.enterUsername("mmm");

	}

}
