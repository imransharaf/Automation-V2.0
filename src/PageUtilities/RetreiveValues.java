package PageUtilities;

import java.awt.event.ActionEvent;

import org.openqa.selenium.WebDriver;
import PageUtilities.AutomationGUI;



public class RetreiveValues {

	 	WebDriver driver;
	    AutomationGUI objAutomationGUI;


	    public void setup() throws Exception{
	    	 
	    	
	    	objAutomationGUI = new AutomationGUI(driver);
	    	objAutomationGUI.Menu();
	    }
	    
	    public void actionPerformed(ActionEvent e){
	/*            if(e.getSource()== objAutomationGUI.){
	                // your TODO list here
	            } 	
	    	
	    	
	         
	        //objAutomationGUI.Menu();
	        
	 */       
	    	}



}
