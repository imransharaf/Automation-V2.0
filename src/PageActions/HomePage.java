package PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageUtilities.Validation;
 

	public class HomePage {
	 
		
		WebDriver driver;
		Validation objValidation;
		
		
		//********************Initializing Web Elements for HomePage**********************************************
	    
		@FindBy(xpath="//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/font")
	    WebElement UserName;
	 
	    @FindBy(xpath="//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")
	    WebElement UserNameTextfield;
	    
	    @FindBy(xpath="//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")
	    WebElement PasswordTextfield;
	    
	    @FindBy(xpath="//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")
	    WebElement SignIn;
	    
	    @FindBy(xpath="//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")
	    WebElement FlightDetailsText;
	    
	    
	    //***********Constructor********************
	    public HomePage(WebDriver driver){

	    	   	
	    	this.driver = driver;
	 
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    	}
	    
	 	
	   //************Get Page Title****************** 
	    
	    public String getPageTitle(){
			String title = driver.getTitle();
			return title;
		}
		
	  //************Verify Page Title****************** 
	    
	    public boolean verifyBasePageTitle() {
			String expectedPageTitle="Welcome: Mercury Tours";
			return getPageTitle().contains(expectedPageTitle);
		}
	    
	  //************Home Page Login****************
	    
	    public void HomePagelogin(String Username, String Password) throws Exception{
	    	
	    	objValidation = new Validation(driver);
	    	UserNameTextfield.sendKeys(Username);
	    	PasswordTextfield.sendKeys(Password);
	    		         
	    }
	 
	    
	    //************Verify Flight Page after successful sign in****************
	    
	    public FlightPage clickSignIn(){
	    	
	    	if(SignIn.isDisplayed()||SignIn.isEnabled())
	    		SignIn.click();
			else System.out.println("Element not found");
	    	
	    	return PageFactory.initElements(driver, FlightPage.class);
	    }
	    
		
	    
	    public void clickImagesLink() {
			//It should have a logic to click on images link
			//And it should navigate to google images page
		}
	    
	    
	 
	}
