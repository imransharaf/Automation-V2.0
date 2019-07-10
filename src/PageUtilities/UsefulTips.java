package PageUtilities;




import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;



public class UsefulTips {

	 static WebElement webElement;
	 static WebDriver driver;
	 static String text = null;
	 String id = null;
	
	public void TestBase() throws Exception{
	    // Firefox profile creation
	    FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
	    profile.setPreference("browser.cache.disk.enable", false); 

	    profile.setPreference("network.proxy.http", "localhost");
	    profile.setPreference("network.proxy.http_port",8080);
	    driver = new FirefoxDriver(profile);
	    //System.setProperty("webdriver.ie.driver","E:\\Phyweb Webdriver\\IEDriverServer.exe");
	    //driver = new InternetExplorerDriver();
	    driver.manage().window().maximize();
	}

	 //To find WebElement by id
	  public static WebElement FindElement(String id)
	  {
	    
		try
	      {
	            
				webElement= driver.findElement(By.id(id));
	      }
	      catch(Exception e)
	      {
	          Print(e);
	      }
	      return webElement;
	  }

	  //To find WebElement by name
	  public static WebElement FindElementByName(String name)
	  {
	      try
	      {
	            webElement= driver.findElement(By.name(name));
	      }
	      catch(Exception e)
	      {
	          Print(e);
	      }
	       return webElement;
	  }

	  //To find WebElement by Class
	  public static WebElement FindElementByClass(String classname)
	  {
	      try
	      {
	            webElement= driver.findElement(By.className(classname));
	      }
	      catch(Exception e)
	      {
	          Print(e);
	      }
	       return webElement;
	  }

	//To get data of a cell
	public static String GetCellData(XSSFSheet sheet,int row,int col)
	{
	    String cellData = null;
	    try 
	    {
	        //cellData=PhyWebUtil.getValueFromExcel(row, col, sheet);
	    }
	    catch (Exception e) 
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return cellData;
	}

	    //To click a button using id
	    public static void ClickButton(String id,String label)
	    {
	        try
	        {
	                WebElement webElement= FindElement(id);
	                Snooze();
	                webElement.click();
	                PrintMessage(label+" is selected");
	        }
	        catch(Exception e)
	        {
	            Print(e);
	        }
	    }   

	            //To click a button using class
	            public void ClickButtonByClass(String classname,String label)
	            {
	                try
	                {
	                        WebElement webElement= FindElementByClass(classname);
	                        Snooze();
	                        webElement.click();
	                        PrintMessage(label+" is selected");
	                }
	                catch(Exception e)
	                {
	                    Print(e);
	                }
	            }   
	     //To enter data into Textbox
	     public String editTextField(int rownum, int celnum,WebElement element ,XSSFSheet sheet,String Label)
	      {
	            XSSFRow row = sheet.getRow(rownum);
	            XSSFCell Cell = row.getCell(celnum);
	            String inputValue = Cell.getStringCellValue().trim();
	            element.clear();//To clear contents if present
	            try
	            {
	                      element.sendKeys(inputValue);
	                      String  elementVal=element.toString();
	                      if(elementVal.contains("password"))
	                      {   
	                          PrintMessage("Password is entered");
	                      }
	                      else
	                      {   
	                          PrintMessage("Value entered for "+Label+" is "+inputValue);
	                      }  
	            }
	            catch(Exception e){
	                Print(e);
	                //cv.verifyTrue(false, "<font color= 'red'> Failed due to : </font> "+e.getMessage());
	            }
	            return inputValue;
	      }

	    //To enter data into Textbox
	     public String editTextFieldDirect(WebElement element ,String text,String label)
	      {
	            element.clear();//To clear contents if present
	            try
	            {
	                      element.sendKeys(text);
	                      String  elementVal=element.toString();
	                      if(elementVal.contains("password"))
	                      {   
	                          PrintMessage("Password is entered");
	                      }
	                      else
	                      {   
	                          PrintMessage("Value entered for "+label+" is "+text);
	                      }  
	            }
	            catch(Exception e){
	                Print(e);
	                //cv.verifyTrue(false, "<font color= 'red'> Failed due to : </font> "+e.getMessage());
	            }
	            return text;
	      }
	        //To select Radio button
	        public void ClickRadioButton(String id)
	        {
	            try
	            {
	                    WebElement webElement= FindElement(id);
	                    Snooze();
	                    webElement.click();                 
	                    String text = webElement.getText();          
	                    PrintMessage(text+" is selected");
	            }
	            catch(Exception e)
	            {
	                Print(e);
	            }
	        } 

	    //To select Link
	    public void ClickLink(String id,String label)
	    {
	        try
	        {
	                ClickButton(id,label);
	        }
	        catch(Exception e)
	        {
	            Print(e);
	        }
	    } 

	  //To Click an Image button
	    public void ClickImage(String xpath)
	    {
	        try
	        {
	                 webElement= FindElement(id);
	                Snooze();
	                webElement.click();
	                text=GetText(webElement);
	                PrintMessage(text+" is selected");
	        }
	        catch(Exception e)
	        {
	            Print(e);
	        }
	    } 

	    //Select a checkbox
	    public void CheckboxSelect(String id,String label)
	    {
	        try
	        {
	                WebElement webElement= FindElement(id);
	                Snooze();
	                webElement.click();
	                PrintMessage("Checkbox "+label+" is selected");
	        }
	        catch(Exception e)
	        {
	            Print(e);
	        }
	    } 

	    //To select value in Combobox
	    public void SelectData(String id,String label,String cellval)
	    {
	        try
	        {
	                WebElement webElement= FindElement(id);
	                Snooze();
	                webElement.click();
	                String elementStr=webElement.toString();
	                int itemIndex=elementStr.indexOf("value");
	                if(itemIndex>-1)
	                {   
	                    int endIndex=elementStr.length()-3;
	                    String item=elementStr.substring(itemIndex+7, endIndex);
	                    if(cellval=="0")
	                    {   
	                         PrintMessage(item+" is selected for "+label);
	                    }
	                    else
	                    {
	                        PrintMessage(cellval+"  "+label+" is selected");
	                    }
	                }   
	                else
	                {
	                    PrintMessage(cellval+" is selected for "+label);
	                }
	        }
	        catch(Exception e)
	        {
	            Print(e);
	        }
	    } 

	      //To check if WebElement with id exists
	      public static boolean isExists(String id) 
	      {
	          boolean exists = false;
	          driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	              try 
	              {
	                       exists=driver.findElements( By.id(id) ).size() != 0;    
	              } 
	              catch (Exception e) 
	              {
	                  Print(e);
	             }
	              if(exists==true)


	               return true;


	              else


	               return false;
	      }

	      //To check if WebElement with name exists
	      public static boolean isExistsName(String name) 
	      {
	          boolean exists = false;
	          driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	              try 
	              {
	                       exists=driver.findElements( By.name(name) ).size() != 0;    
	              } 
	              catch (Exception e) 
	              {
	                  if(e.getMessage().contains("InvalidSelectorError"))
	                  {   
	                      System.out.println("");
	                  }
	                  else
	                      Print(e);
	             }
	              if(exists==true)


	               return true;


	              else


	               return false;
	      }

	        //Explicit wait until a element is visible and enabled using id
	        public void ExplicitlyWait(String id)
	          {
	              try
	              {
	                  WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	                            .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	              }
	              catch(Exception e)
	              {
	                  Print(e);
	              }
	          }

	        //Explicit wait until a element is visible and enabled using classname
	        public void ExplicitlyWaitByClass(String classname)
	          {
	              try
	              {
	                  WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	                            .until(ExpectedConditions.presenceOfElementLocated(By.className(classname)));
	              }
	              catch(Exception e)
	              {
	                  Print(e);
	              }
	          }

	        //Explicit wait until a element is visible and enabled using id
	        public void ExplicitlyWaitSpecific(int sec,String id)
	          {
	              try
	              {
	                  WebElement myDynamicElement = (new WebDriverWait(driver, sec))
	                            .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	              }
	              catch(Exception e)
	              {
	                  Print(e);
	              }
	          }

	    //Snooze for 10 seconds
	    public static void Snooze()
	      {
	          try
	          {
	              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          }
	          catch(Exception e)
	          {
	              Print(e);
	          }
	      }

	    //Snooze for Secs
	    public static void SnoozeSpecific(int seconds)
	      {
	          try
	          {
	              driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	          }
	          catch(Exception e)
	          {
	              Print(e);
	          }
	      }

	    //Sleep for milliSeconds
	    public static void Sleep(int milisec) throws InterruptedException
	    {
	        Thread.sleep(milisec);
	    }

	    //To get text using text()
	     public static String GetText(WebElement element)
	     {
	         try
	         {  
	             text=element.getText();
	         }   
	         catch(Exception e){


	             Print(e);
	         }
	        return text;
	     }

	     //To get text using getAttribute("value")
	     public static String GetTextAttribute(WebElement element)
	     {
	         try
	         {  
	             text=element.getAttribute("value");
	         }   
	         catch(Exception e){


	             Print(e);
	         }
	        return text;
	  }
	     //To Print error messages to both Console and Results file
	     public static void Print(Exception e)
	     {
	         Reporter.log("Exception is :"+e.getMessage());
	         System.out.println(e);
	     }

	     //To Print messages to both Console and Results file
	     public static void PrintMessage(String str)
	     {
	         Reporter.log(str);
	         System.out.println(str);
	     }

	    //To Print Blank row
	     public static void BlankRow()
	     {
	         Reporter.log("                                              ");
	         System.out.println("                                              ");
	     }

	    //To Print Sub header
	     public static void Header(String str)
	     {
	         BlankRow();
	         Reporter.log("***********************"+str+" Verifications***********************");
	         System.out.println("***********************"+str+" Verifications***********************");
	         BlankRow();
	     }

	    //To Print Sub header
	     public static void SubHeader(String str)
	     {
	         BlankRow();
	         Reporter.log("-----------------------"+str+" Verifications-----------------------");
	         System.out.println("-----------------------"+str+" Verifications-----------------------");
	         BlankRow();
	     }
	
	
}
