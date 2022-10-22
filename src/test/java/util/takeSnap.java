package util;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class takeSnap extends commonTestng.BaseSetup{
	
	Date dateTime = new Date();	
	String fileName = dateTime.getDate() + "-" + dateTime.getMonth() + "-" + (dateTime.getYear()+1900) + " " + dateTime.getHours() + "." + dateTime.getMinutes() + "." + dateTime.getSeconds();
	
	File snapFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

}
