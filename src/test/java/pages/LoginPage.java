package pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	static WebDriver driver;
	static String url;
	static Actions action;
	
	@FindBy(id = "user-name")
	static WebElement unameField;
	
	@FindBy(id = "password")
	static WebElement pwdField;
	
	@FindBy(id = "login-button")
	static WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		url = "https://www.saucedemo.com/";
		action = new Actions(driver);
	}
	
	public static void getToLoginPage() {
		driver.get(url);
	}
	
	public static void enterUsername(String uname) {
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(unameField, uname);
		
	}

}
