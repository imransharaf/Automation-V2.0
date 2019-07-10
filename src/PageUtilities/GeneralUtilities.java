package PageUtilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.PageFactory;

import PageActions.HomePage;


	public class GeneralUtilities {

	
		WebDriver driver;
		HomePage objHomePageElements;
	
	
		public GeneralUtilities(WebDriver driver){
	
	    	this.driver = driver;
	 
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
		}
    	
		
//--------------------------------------------------------------------------------------------------------	
	
		public int[] getCoordinates(WebElement webelement) throws InterruptedException { 
			
			//Locate element for which you wants to retrieve x y coordinates. 
			WebElement Image = webelement; 
		
			//Used points class to get x and y coordinates of element. 
			Point point = Image.getLocation(); 
			
			int xcord = point.getX(); 
			int ycord = point.getY(); 
			
			return new int[] {xcord, ycord};
			
		/*	To use this function in maid code try following
			public static void main(String[] args) {
				  int[] ret = something();
				  System.out.println(ret[0] + ret[1]);
				} */
		
			}


//--------------------------------------------------------------------------------------------------------	

		public  Map<String, List<String>> retStringArray() throws InterruptedException {

			  Map<String, List<String>> mainlist = new HashMap<String, List<String>>();
			  ArrayList<String> firstname = new ArrayList<String>();
			  ArrayList<String> lastname = new ArrayList<String>();
			  ArrayList<String> email = new ArrayList<String>();
		
			  mainlist.put("email",email);
			  mainlist.put("lastname",lastname);
			  mainlist.put("firstname",firstname);
			      
			  return mainlist;
			      
			   /* To use in the main program write following
			    List<String> emailsList = mainlist.get("email");
			    */
			}


//--------------------------------------------------------------------------------------------------------	
		
		public void captureElementScreenshot(WebElement element, String saveImgfilePath) throws IOException{
			 
			//Capture entire page screenshot as buffer. //Used TakesScreenshot, OutputType Interface of selenium and File class of java to capture screenshot of entire page.
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 

			//Used selenium getSize() method to get height and width of element. //Retrieve width of element.
			int ImageWidth = element.getSize().getWidth(); 

			//Retrieve height of element. 
			int ImageHeight = element.getSize().getHeight();
			 
			//Used selenium Point class to get x y coordinates of Image element. //get location(x y coordinates) of the element. 
			Point point = element.getLocation(); 
			int xcord = point.getX(); 
			int ycord = point.getY(); 

			//Reading full image screenshot. 
			BufferedImage img = ImageIO.read(screen);
			 
			//cut Image using height, width and x y coordinates parameters. 
			BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight); ImageIO.write(dest, "png", screen); 

			//Used FileUtils class of apache.commons.io. Save Image screenshot In D: drive.
			// FilePath should be in the following format-  D:\\screenshot.png
			FileUtils.copyFile(screen, new File(saveImgfilePath)); 
			
			/*
			 * To use it in the main program  following format should be followed
			 	captureElementScreenshot(Image);
			 */
			
			} 

		
//--------------------------------------------------------------------------------------------------------	

		public void selectCheckBoxBeforeText(){ 
			//Locating element using preceding-sibling In XPath. 
			driver.findElement(By.xpath("//td[contains(text(),'Cow')]/preceding-sibling::td/input[@type='checkbox']")).click(); 
		}
		

//--------------------------------------------------------------------------------------------------------	
		
		public void selectCheckBoxAfterText(){
			//Locating element using following-sibling In XPath. 
			driver.findElement(By.xpath("//td[contains(text(),'Dog')]/following-sibling::td/input[@type='checkbox']")).click(); 
		}

//--------------------------------------------------------------------------------------------------------	
		
		public void ScrollPagetoBottom() throws IOException, InterruptedException {
			 //Scroll down to bottom of the page.
			 JavascriptExecutor javascript = (JavascriptExecutor) driver; 
			 javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", ""); 
			 			 
		}

	
//--------------------------------------------------------------------------------------------------------------
		
		public void ScrollPagetillElement(WebElement webelement) throws IOException, InterruptedException {
			 //Scroll down to  the page until find the web element.
			JavascriptExecutor je = (JavascriptExecutor) driver; 
			WebElement element = webelement; 
			je.executeScript("arguments[0].scrollIntoView(true);",element); 

		}

//--------------------------------------------------------------------------------------------------------	
		public void checkPageIsReady(String TexttoCheck, int checkHowmanytimes, int checkAfterinMilliSeconds) {
			 
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			
			//Initially bellow given if condition will check ready state of page. 
			if (js.executeScript("return document.readyState").toString().equals(TexttoCheck)){
			 		return;
			 	}

			//This loop will rotate for 25 times to check If page Is ready after every 1 second. 
			//You can replace your value with 25 If you wants to Increase or decrease wait time. 
			for (int i=0; i<checkHowmanytimes; i++){ 
				try { 
						Thread.sleep(checkAfterinMilliSeconds);
			      		}catch (InterruptedException e) {}
			 		//To check page ready state.
			 	if (js.executeScript("return document.readyState").toString().equals(TexttoCheck)){
			 			break;
			 		}
				} 
			} 

//--------------------------------------------------------------------------------------------------------------
		/*
		public void printJavaScriptPageErrors() throws Exception { 
			//Capture all errors and store them In array.
			List<JavaScriptError> Errors = JavaScriptError.readErrors(driver);
			System.out.println("Total No Of JavaScript Errors : " + Errors.size()); 
			//Print Javascript Errors one by one from array. 
				for (int i = 0; i < Errors.size(); i++) { 
					System.out.println("Error Message : " + Errors.get(i).getErrorMessage()); 
					System.out.println("Error Line No : " + Errors.get(i).getLineNumber()); 
					System.out.println(Errors.get(i).getSourceName()); 
					System.out.println(); 
				} 
			} 		
	
		*/
//--------------------------------------------------------------------------------------------------------------
		
		public void getWebelementList() throws Exception {
		//Storing the list
		List <WebElement> serviceProviderLinks = driver.findElements(By.xpath("//div[@id='ServiceProvider']//ul//li"));
		//Fetching the size of the list
		int listSize = serviceProviderLinks.size();
		for (int i=0; i<listSize; i++){
			// Clicking on each service provider link
		serviceProviderLinks.get(i).click();
		// Navigating back to the previous page that stores link to service providers
		driver.navigate().back();
		}
	}

			
//--------------------------------------------------------------------------------------------------------------
		public void SelectfromList(WebElement Webelement, String Value ) throws Exception {
			
			Select droplist = new Select(Webelement);   
			droplist.selectByVisibleText(Value);	
			
		}

		
		
//--------------------------------------------------------------------------------------------------------------
	

	
	
	}
