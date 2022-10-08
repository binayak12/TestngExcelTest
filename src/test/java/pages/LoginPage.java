package pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	static WebDriver driver;
	static String url, afterLoginUrl;
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
		afterLoginUrl = "https://www.saucedemo.com/inventory.html";
		action = new Actions(driver);
	}
	
	public static void getToLoginPage() {
		driver.get(url);
	}
	
	public static void enterUsername(String uname) {
		action.click(unameField).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(unameField, uname).perform();
	}
	
	public static void enterPassword(String pwd) {
		action.click(pwdField).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(pwdField, pwd).perform();
	}
	
	public static void clickLoginBtn() {
		action.click(loginBtn).perform();
	}
	
	public static void login(String uname, String pwd) {
		getToLoginPage();
		enterUsername(uname);
		enterPassword(pwd);
		clickLoginBtn();
	}
	
	public static Boolean checkSuccessfulLogin() {
		String currentUrl = driver.getCurrentUrl();
		
		if (currentUrl.equals(afterLoginUrl))
			return true;
		else
			return false;
	}

}
