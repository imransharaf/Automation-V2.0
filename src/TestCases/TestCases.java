package TestCases;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageActions.HomePage;
import PageActions.SelectFlightPage;
import PageActions.FlightPage;
import PageActions.BookFlightPage;
import TestData.TestData;
import PageUtilities.AutomationGUI;

 
@SuppressWarnings("unused")
public class TestCases {
 	
	//*************Initialize objects*****************
		
    WebDriver driver;
    HomePage objHomePage;
    FlightPage objFlightPage;
    SelectFlightPage objselectflightPage;
    BookFlightPage objBookFlightPage;
    AutomationGUI objAutomationGUI;

    //*************** Launch FireFox Browser and open Application******************* 
    public WebDriver RunBrowser() throws Exception{
    	
    	//driver = new FirefoxDriver();
    	driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com");
        
        
        return driver;

    	}
  
    //*************** TC01 Test Case******************* 
    public void TC01() throws Exception{
 
    	
        HomePage objHomePage = new HomePage(RunBrowser());
 	   
	    String TC1[] = TestData.TestCase1();
	    
	    String Username = TC1[0];
	    String Password = TC1[1];
	  
	    //login to application
     	objHomePage.HomePagelogin(Username,Password);
     	
     	//go to home Page
     	objHomePage.clickSignIn();
      	
    	}

  //*************** TC02 Test Case******************* 
    public void TC02() throws Exception{
 
    	
       TC01();
       FlightPage objFlightPage = new FlightPage(driver);
        
                 	   
	    String[] TC2 = TestData.TestCase2();
	    //System.out.println(Arrays.toString(TestData.TestCase2()));
	    
	    
	    String Passengers = TC2[0];
	    String DepartCity = TC2[1];
	    String DepartMonth = TC2[2]; 
	    String DepartDate = TC2[3];
	    String ArrivalCity = TC2[4];
	    String ArrivalMonth = TC2[5]; 
	    String ArrivalDate = TC2[6];
	    String SeatingClass = TC2[7];
	    String AirlinePreference = TC2[8];
	  
	    /*
	    String Passengers = TestData.TestCase2().get(0);
	    String DepartCity = TestData.TestCase2().get(1);
	    String DepartMonth = TestData.TestCase2().get(2); 
	    String DepartDate = TestData.TestCase2().get(3);
	    String ArrivalCity = TestData.TestCase2().get(4);
	    String ArrivalMonth = TestData.TestCase2().get(5); 
	    String ArrivalDate = TestData.TestCase2().get(6);
	    String SeatingClass = TestData.TestCase2().get(7);
	    String AirlinePreference = TestData.TestCase2().get(8);
	  */
	  
	    //Verify flight Page opened.
	     objFlightPage.verifyFlightPage();
	     
	    //Select Round Trip tickets
	    objFlightPage.RoundTrip(Passengers, DepartCity, DepartMonth, DepartDate, ArrivalCity, ArrivalMonth, ArrivalDate);
	   
	    
	    //Select Seat Preference
	    objFlightPage.Prefrences(SeatingClass);
	     
	    //Select Airline Preference
	    objFlightPage.Airline(AirlinePreference);
	    
	    //Select Continue button
	    objFlightPage.ClickContinueBtn();
	   
	   
      	
    	}

  //*************** TC02 Test Case******************* 
    public void TC03() throws Exception{
 
    	
       TC01();
       FlightPage objFlightPage = new FlightPage(driver);
        
                 	   
	    String[] TC3 = TestData.TestCase3();
	    //System.out.println(Arrays.toString(TestData.TestCase3()));
	    
	    
	    String Passengers = TC3[0];
	    String DepartCity = TC3[1];
	    String DepartMonth = TC3[2]; 
	    String DepartDate = TC3[3];
	    String SeatingClass = TC3[4];
	    String AirlinePreference = TC3[5];
	    
	    //String Passengers = TestData.TestCase3().get(0);
	    //String DepartCity = TestData.TestCase3().get(1);
	    //String DepartMonth = TestData.TestCase3().get(2); 
	    //String DepartDate = TestData.TestCase3().get(3);
	    //String SeatingClass = TestData.TestCase3().get(4);
	    //String AirlinePreference = TestData.TestCase3().get(5);
	   
	    
	    
	    
	    
	    //Verify flight Page opened.
	     objFlightPage.verifyFlightPage();
	     
	    //Select Round Trip tickets
	    objFlightPage.OneWayTrip(Passengers, DepartCity, DepartMonth, DepartDate);
	    
	    //Select Seat Preference
	    objFlightPage.Prefrences(SeatingClass);
	     
	    //Select Airline Preference
	    objFlightPage.Airline(AirlinePreference);
	    
	    //Select Continue button
	    objFlightPage.ClickContinueBtn();
	      
     	
   	}

  
	}  	
