package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver getBrowser(String browserName) {
		
		WebDriver driver;
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else {
			WebDriverManager.chromedriver();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static WebDriver getBrowser() {
		WebDriver driver;
		Properties property = new Properties();
		try {
			FileInputStream propertyFile = new FileInputStream("src/test/java/config/properties.feature");
			try {
				property.load(propertyFile);
				driver = getBrowser(property.get("browser").toString());
				return driver;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Not Able to Load the FIle");
				driver = getBrowser("Chrome");
				return driver;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File Not Tracable");
			driver = getBrowser("Chrome");
			return driver;
		}
		
	}

}
