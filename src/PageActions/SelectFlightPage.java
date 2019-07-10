package PageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageUtilities.Validation;


public class SelectFlightPage {
	
	WebDriver driver;
	Validation objValidation;
	
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
    WebElement SelectFlightImg;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/font/b/font")
	WebElement DepartFlightImg;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")
	WebElement ContinueBtn;
	
	
			
			
	 public SelectFlightPage(WebDriver driver){

	    	this.driver = driver;
	 
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	    
	 	    	    
	    public String getPageTitle(){
			String title = driver.getTitle();
			return title;
		}
		
	    public SelectFlightPage verifySelectFlightPage() {
			//String expectedPageTitle="Welcome: Mercury Tours";
			
		    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", SelectFlightImg);
		    if (!ImagePresent)
		    	{
		         System.out.println("Select Flight Page is not displayed");
		    	}
		    return PageFactory.initElements(driver, SelectFlightPage.class);
		}
	       
	    
	    
	
	    public BookFlightPage ClickContinueBtn(){
	    	objValidation = new Validation(driver);
	    	
	    	ContinueBtn.click();
	    	
	    			    	
	    	return PageFactory.initElements(driver, BookFlightPage.class);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
