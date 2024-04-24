package testpack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pages.ProductSearchToCheckout;
import utils.Utility;


public class VerifyProductSearchToCheckout extends Browser{
	WebDriver driver;
   
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;

	@BeforeTest 
	public void launchBrowser(@Optional("Chrome") String browserName)
	{

		
		  reporter=new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		  ExtentReports extend=new ExtentReports(); extend.attachReporter(reporter);
		 
		if(browserName.equals("Chrome"))
		{
		
		driver=launchChrome();
		
	    }

		if(browserName.equals("Edge"))
		{
		 
		 driver=launchEdge();
	   			   
	     }
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));   
	}
    @BeforeClass
    public void creatingPOMObject()
    {
    	
    }

	@BeforeMethod
	public void openLoginPage() throws InterruptedException
	{
		driver.get("https://www.amazon.in");	
	    driver.manage().window().maximize();
	   
	   
	}
	
	@Test(priority=1)
	public void VerifySearchProductFunctionality() throws InterruptedException
	{
		 ProductSearchToCheckout productsearchtocheckout=new ProductSearchToCheckout(driver); 
		 productsearchtocheckout.enterProductNameForSearch();
		 productsearchtocheckout.clickOnsearchProductButton();
		 productsearchtocheckout.clickOnSortByFeatured();
		 productsearchtocheckout.clickOnPriceLowToHigh();
		
		 //Thread.sleep(5000);
		 productsearchtocheckout.clickOnProduct();
		 
		 productsearchtocheckout.clickOnAddToCartButton();
		 productsearchtocheckout.clickOnProceedToBuy();
		 
	}
	
	@Test(priority=2)
	public void VerifyProductFilterFunctionality() throws InterruptedException
	{
		 ProductSearchToCheckout productsearchtocheckout=new ProductSearchToCheckout(driver); 
		 productsearchtocheckout.clickOnSortByFeatured();
		 productsearchtocheckout.clickOnPriceLowToHigh();
		
		 //Thread.sleep(5000);
		 productsearchtocheckout.clickOnProduct();
		 
		 productsearchtocheckout.clickOnAddToCartButton();
		 productsearchtocheckout.clickOnProceedToBuy();
		 
	}
	@Test(priority=3)
	public void VerifyProductSelectFunctionality() throws InterruptedException
	{
		 ProductSearchToCheckout productsearchtocheckout=new ProductSearchToCheckout(driver); 
		 
		 productsearchtocheckout.clickOnProduct();
		 
		 productsearchtocheckout.clickOnAddToCartButton();
		 productsearchtocheckout.clickOnProceedToBuy();
		 
	}
	
	
	@Test(priority=4)
	public void VerifyAddToCartFunctionality() throws InterruptedException
	{
		 ProductSearchToCheckout productsearchtocheckout=new ProductSearchToCheckout(driver); 	 
		 productsearchtocheckout.clickOnAddToCartButton();
		 productsearchtocheckout.clickOnProceedToBuy();
		 
	}
	
	@Test(priority=5)
	public void VerifyProceedToBuyFunctionality() throws InterruptedException
	{
		 ProductSearchToCheckout productsearchtocheckout=new ProductSearchToCheckout(driver); 	 
		 productsearchtocheckout.clickOnProceedToBuy();
		 
	}
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException
	{
		System.out.println(ITestResult.FAILURE==result.getStatus());
		if(ITestResult.FAILURE==result.getStatus())
		{
			
		Utility.captureFailScreenshot(driver,"A123");
		}
		System.out.println("LogOut");
		
	}
	 
	@AfterClass
	public void clearObject()
	{
		//productsearchtocheckout=null;
		
	}
	@AfterTest
	public void closeBrowser()
	{
		
		//driver.quit();
		driver=null;
		
		System.gc();
	}
	
		
		
	
	
}
