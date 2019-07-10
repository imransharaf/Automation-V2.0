package PageUtilities;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import PageActions.*;


public class Validation {

	
	static WebElement webElement;
	static WebDriver driver;
	HomePage objHomePageElements;
	
	
		public Validation(WebDriver driver){
	
	    	this.driver = driver;
	 
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
		}
    	


		public void waitforText(String Text, WebElement webelement ) throws Exception {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			for(int i=0; i<2 && webelement.equals(Text) ; i++){
				   Thread.sleep(1000);
				}
		}
	
		  
		public void waitforElement_Fluent(WebElement myDynamicElement, int waitinseconds ){
		
			//Using Fluent wait. // Waiting "waitinseconds" e.g.30 seconds for an element to be present on the page, checking
			// for its presence once every 5 seconds. This can be used When you try to test the presence of an element that may appear after every x seconds/minutes
			myDynamicElement = (new WebDriverWait(driver, waitinseconds))
		    		 .until(new ExpectedCondition<WebElement>(){
		    		@Override
		    		public WebElement apply(WebDriver webdriver) {
		    		    return webdriver.findElement(By.id("myDynamicElement"));
		    		}});
				}

				
		
		public void waitforElement(String ElementId, int timeinSeconds ){
				//Recommended using this function since it uses explicit wait
				WebDriverWait wait = new WebDriverWait(driver,timeinSeconds);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ElementId)));
			}
		
		
		public static WebElement FindElementByName(String name){
		      
			try {webElement= driver.findElement(By.name(name)); }
		    catch(Exception e) { }
		     
		    return webElement;
		  }

		  //To find WebElement by Class
		  public static WebElement FindElementByClass(String classname){
		      try {webElement= driver.findElement(By.className(classname));}
		      catch(Exception e){  }
		      
		      return webElement;
		  }

		
		 
		
		
		
		
}
