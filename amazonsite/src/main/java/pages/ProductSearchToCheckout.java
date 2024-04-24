package pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchToCheckout {


	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement SearchTextBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
    private WebElement SearchButton;
	  
    @FindBy(xpath="//span[@class='a-dropdown-prompt']")
    private WebElement SortByFeatured;
	
    
    @FindBy(xpath="//a[@id='s-result-sort-select_1']")
    private WebElement PriceLowToHigh;
    
    @FindBy(xpath="//*[text()='VGRASSP Soft Plush Baby Rattle Ball Stuffed Toy - Multicolour']")
    private WebElement SpecificProduct;
    
    
    @FindBy(xpath="//input[@title='Add to Shopping Cart']")
    private WebElement AddToCart;
  
    @FindBy(xpath="//*[@value='Proceed to checkout']")
    private WebElement ProceedToBuy;
    
    
	private WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public ProductSearchToCheckout(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	//This method enter value in search textbox
	public void enterProductNameForSearch()
	{
		SearchTextBox.sendKeys("Baby Toys");
	}
	
	//This method click on search button
	public void clickOnsearchProductButton()
	{
		SearchButton.click();
	}
	
	
	//This method click on Sort By Featured
		public void clickOnSortByFeatured()
		{
			SortByFeatured.click();
		}
		
	
	//This method click on price Low to high option from dropdown
				public void clickOnPriceLowToHigh()
				{
					PriceLowToHigh.click();
				}
				
   //This method Select the specific product
				
				public void clickOnProduct() throws InterruptedException
				{
					Thread.sleep(3000);
					SpecificProduct.click();
					Thread.sleep(3000);
				}
				
				
   //This method add the specific product into cart
				
				public void clickOnAddToCartButton() throws InterruptedException
				{
					 //js.executeScript("argument[0].scrollIntoView(true)",AddToCart);
					//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",AddToCart);
					System.out.println("fbhdgcv");
					Set<String> windowHandles = driver.getWindowHandles();
					
					String mainWindowHandle = driver.getWindowHandle();
			        
			        for (String handle : windowHandles) {
			            if (!handle.equals(mainWindowHandle)) {
			         
							driver.switchTo().window(handle);
			            }
			        }
					Thread.sleep(5000);
					AddToCart.click();
				}
				
				
	// This method click on proceed to buy button
				public void clickOnProceedToBuy()
				{
					ProceedToBuy.click();
				}
}
