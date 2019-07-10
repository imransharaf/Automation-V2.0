package PageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageUtilities.Validation;



public class BookFlightPage {
	
	WebDriver driver;
	Validation objValidation;
	
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
    WebElement BookFlightImg;
	
	
	 public BookFlightPage(WebDriver driver){

	    	this.driver = driver;
	 
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	    
	 	    	    
	    public String getPageTitle(){
			String title = driver.getTitle();
			return title;
		}
		
	    public BookFlightPage verifyBookFlightPage() {
			//String expectedPageTitle="Welcome: Mercury Tours";
			
		    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", BookFlightImg);
		    if (!ImagePresent)
		    	{
		         System.out.println("Select Flight Page is not displayed");
		    	}
		    return PageFactory.initElements(driver, BookFlightPage.class);
		}
	
	
	

}
