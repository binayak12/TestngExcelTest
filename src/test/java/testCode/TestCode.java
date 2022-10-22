package testCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import util.BrowserFactory;

public class TestCode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Date date = new Date();
		
		System.out.println(date.getDate() + "-" + date.getMonth() + "-" + (date.getYear()+ 1900) + " " + date.getHours() + "." + date.getMinutes() + "." + date.getSeconds());

	}

}
