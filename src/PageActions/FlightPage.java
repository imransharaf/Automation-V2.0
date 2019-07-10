package PageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import PageUtilities.Validation;
import PageActions.SelectFlightPage;

public class FlightPage {
	
	
	WebDriver driver;
	Validation objValidation;
	
		
    
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
    WebElement FlightFinderImg;
 
    @FindBy(xpath="//input[@name='tripType']")
    WebElement RoundTripRdBtn;
    
    @FindBy(xpath="(//input[@name='tripType'])[2]")
    WebElement OneWayRdBtn;
    
    @FindBy(xpath="//select[@name='passCount']")
    WebElement PassengersDrpDn;
    
    @FindBy(xpath="//select[@name='fromPort']")
    WebElement DepartingFromDrpDn;
    
    @FindBy(xpath="//select[@name='fromMonth']")
    WebElement DepartMonthDrpDn;
    
    @FindBy(xpath="//select[@name='fromDay']")
    WebElement DepartDayDrpDn;
    
    @FindBy(xpath="//select[@name='toPort']")
    WebElement ArrivingInDrpDn;
      
    @FindBy(xpath="//select[@name='toMonth']")
    WebElement RetruningMonthDrpDn;
    
    @FindBy(xpath="//select[@name='toDay']")
    WebElement ReturningDayDrpDn;
    
    @FindBy(xpath="//input[@name='servClass']")
    WebElement ServiceClassEconomyRdBtn;
    
    @FindBy(xpath="(//input[@name='servClass'])[2]")
    WebElement ServiceClassBusinessRdBtn;
    
    @FindBy(xpath="(//input[@name='servClass'])[3]")
    WebElement ServiceClassFirstRdBtn;
    
    @FindBy(xpath="//select[@name='airline']")
    WebElement AirlineDrpDn;
    
    @FindBy(xpath=" //input[@name='findFlights']")
    WebElement ContinueBtn;
 
    
    
    public FlightPage(WebDriver driver){

    	this.driver = driver;
 
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    	}
    
 	    	    
   
    public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	
    public FlightPage verifyFlightPage() {
		//String expectedPageTitle="Welcome: Mercury Tours";
		
	    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", FlightFinderImg);
	    if (!ImagePresent)
	    	{
	         System.out.println("Flight Page is not displayed");
	    	}
	    return PageFactory.initElements(driver, FlightPage.class);
	}
       
    
		    public void SelectValuefromList(WebElement Webelement,  int Variable ){
				
		    	String Value = String.valueOf(Variable);
				Select droplist = new Select(Webelement);   
				droplist.selectByValue(Value);	
				
			}
		    
		  
		    
		    public void SelectStringfromList(WebElement Webelement,  String Value ){
				
		    	Select droplist = new Select(Webelement);   
				droplist.selectByVisibleText(Value);	
				
			}
		    
		  		      	    
		   
		    
		  /*
		    public Object[] RoundTripInformation(int Passengers, String DepartCity, String DepartMonth, int DepartDate, String ArriveCity, String ArriveMonth , int ArriveDate, String SeatingClass)
		    {
		       final Object[] RoundTripDetails =
		          {Passengers,  DepartCity,  DepartMonth, DepartDate,  ArriveCity,  ArriveMonth , ArriveDate, SeatingClass};
		       return RoundTripDetails;
		    }
		    
		    */
		    public FlightPage RoundTrip(String Passengers, String DepartCity, String DepartMonth, String DepartDate, String ArrivalCity, String ArrivalMonth, String ArrivalDate){
		    	
		   
		    	objValidation = new Validation(driver);
		    	
		    	RoundTripRdBtn.click();
		    	
		    		    	
		    	// Select # of Passenger, City, Month, date for Departure flight
		    	SelectStringfromList(PassengersDrpDn, Passengers);
		    	SelectStringfromList(DepartingFromDrpDn, DepartCity);
		    	SelectStringfromList(DepartMonthDrpDn, DepartMonth);
		    	SelectStringfromList(DepartDayDrpDn, DepartDate);
		    	
		    	// Select City, Month, date for Arrival flight
		    	SelectStringfromList(ArrivingInDrpDn, ArrivalCity);
		    	SelectStringfromList(RetruningMonthDrpDn, ArrivalMonth);
		    	SelectStringfromList(ReturningDayDrpDn, ArrivalDate);
		    	
		    	return PageFactory.initElements(driver, FlightPage.class);
		    }  
		    
		 
		    public FlightPage OneWayTrip(String Passengers, String DepartCity, String DepartMonth, String DepartDate){
		    	objValidation = new Validation(driver);
		    	
		    	OneWayRdBtn.click();
		    	
		    	// Select City, Month, date for Departure flight
		    	SelectStringfromList(PassengersDrpDn, Passengers);
		    	SelectStringfromList(DepartingFromDrpDn, DepartCity);
		    	SelectStringfromList(DepartMonthDrpDn, DepartMonth);
		    	SelectStringfromList(DepartDayDrpDn, DepartDate);
		    	
		    	return PageFactory.initElements(driver, FlightPage.class);
		    }
		    
		    
		    
		    public FlightPage Prefrences(String SeatingClass){
		    	objValidation = new Validation(driver);
		    	
		    	switch (SeatingClass){
		    	
		    	case "Economy":  ServiceClassEconomyRdBtn.click();  break;
		    	case "Business": ServiceClassBusinessRdBtn.click(); break;
		    	case "First":    ServiceClassFirstRdBtn.click();    break;
		    		
		    	}
		    	
		    	return PageFactory.initElements(driver, FlightPage.class);
		    }
			
		    
		    public FlightPage Airline(String AirlinePreference){
		    	objValidation = new Validation(driver);
		    	
		    	SelectStringfromList(AirlineDrpDn, AirlinePreference);
		    			    	
		    	return PageFactory.initElements(driver, FlightPage.class);
		    }
		    
		    
		    public SelectFlightPage ClickContinueBtn(){
		    	objValidation = new Validation(driver);
		    	
		    	ContinueBtn.click();
		    			    			    	
		    	return PageFactory.initElements(driver, SelectFlightPage.class);
		    }
		    
		    
		    
		    

}
