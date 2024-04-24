package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureFailScreenshot(WebDriver driver,String testId) throws IOException, InterruptedException
	{

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");  
			String currentDateTime=dateFormat.format(new Date());
			 
		     TakesScreenshot ts=(TakesScreenshot)driver;
		     File src=ts.getScreenshotAs(OutputType.FILE);
		   
		     File dest=new File("test-output\\FailedTestScreenshot\\"+testId+currentDateTime+".png");
		
		 FileHandler.copy(src, dest);
		 Thread.sleep(1000); 
		 
	}
	
}




