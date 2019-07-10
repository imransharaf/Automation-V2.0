package ExcelSheet;


import java.util.ArrayList;
import ExcelSheet.ExcelReadWrite;
import TestData.TestData;
import TestCases.TestCases;



public class TestCasestoExecute extends ExcelReadWrite {

	public TestCasestoExecute(){
		try {
			ExcelReadWrite.ExcelRead();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//********************Define Data sheet names and TestCase Names********************************************
	
		static final String Module = "Module"; static final String SubModule1= "SubModule1"; static final String SubModule2= "SubModule2"; 
		static final String SubModule3= "SubModule3"; static final String SubModule4= "SubModule4";
		
		static final String TC01 ="TC01"; static final String TC02 ="TC02"; static final  String TC03 ="TC03"; static final String TC04 ="TC04"; 
		static final String TC21 ="TC21"; static final String TC22 ="TC22"; static final String TC23 ="TC23"; static final String TC24 ="TC24";
		static final String TC31 ="TC31"; static final String TC32 ="TC32"; static final String TC33 ="TC33"; static final String TC34 ="TC34";
		static final String TC41 ="TC41"; static final String TC42 ="TC42"; static final String TC43 ="TC43"; static final String TC44 ="TC44";
		
		
		//Define object so that Excel file runs before we figure out what test cases need to be run
		static ExcelReadWrite objExcelReadWrite = new ExcelReadWrite();
		static TestCases objTestCases = new TestCases();
		static TestData objTestData = new TestData();
		
		
		
	//******************Select Modules that need to be tested*************************
		
		public static ArrayList<String> ModuleExecute() throws Exception{
			
			ArrayList<String> ModuleExecute = new ArrayList<String>();
			
			for (int i=0; i<(TestData.ModData.length); i++ ) {
			        
			    	if (TestData.ModData[i][1].equals("Y") || TestData.ModData[i][1].equals("y") )
			    	{
			    	   	ModuleExecute.add(TestData.ModData[i][0]);
			    	 }
			    }
			
				return ModuleExecute;
			}
	    
		
	//******************Select SubMod1 Test cases that need to be tested*****************
		
		public static ArrayList<String> SubMod1TestCaseExecute() throws Exception{
			
			ArrayList<String> TestCaseExecute = new ArrayList<String>();
			
			for (int i=0; i<(TestData.SubMod1Data.length); i++ ) {
			        
			    	if (TestData.SubMod1Data[i][2].equals("Y") || TestData.SubMod1Data[i][2].equals("y"))
			    	{
			    	   	TestCaseExecute.add(TestData.SubMod1Data[i][0]);
			    	 }
			    }
			
				return TestCaseExecute;
			}
	    

	//******************Select SubMod2 Test cases that need to be tested*****************
		
		public static ArrayList<String> SubMod2TestCaseExecute() throws Exception{
			
			ArrayList<String> TestCaseExecute = new ArrayList<String>();
			
			for (int i=0; i<(TestData.SubMod2Data.length); i++ ) {
			        
			    	if (TestData.SubMod2Data[i][2].equals("Y") || TestData.SubMod2Data[i][2].equals("y"))
			    	{
			    	   	TestCaseExecute.add(TestData.SubMod2Data[i][0]);
			    	 }
			    }
			
				return TestCaseExecute;
			}
	    
		
	//******************Select SubMod3 Test cases that need to be tested*****************
		
		public static ArrayList<String> SubMod3TestCaseExecute() throws Exception{
			
			ArrayList<String> TestCaseExecute = new ArrayList<String>();
			
			for (int i=0; i<(TestData.SubMod3Data.length); i++ ) {
			        
			    	if (TestData.SubMod3Data[i][2].equals("Y") || TestData.SubMod3Data[i][2].equals("y"))
			    	{
			    	   	TestCaseExecute.add(TestData.SubMod3Data[i][0]);
			    	 }
			    }
			
				return TestCaseExecute;
			}
	    
	//******************Select SubMod4 Test cases that need to be tested*****************
		
			public static ArrayList<String> SubMod4TestCaseExecute() throws Exception{
				
				ArrayList<String> TestCaseExecute = new ArrayList<String>();
				
				for (int i=0; i<(TestData.SubMod4Data.length); i++ ) {
				        
				    	if (TestData.SubMod4Data[i][2].equals("Y") || TestData.SubMod4Data[i][2].equals("y"))
				    	{
				    	   	TestCaseExecute.add(TestData.SubMod4Data[i][0]);
				    	 }
				    }
				
				
					return TestCaseExecute;
				}

	//******************Select What Module/Submodules/TestCases  need to be tested*****************

			public void SelectTestCases() throws Exception {
				
				//Define ArrayList of values for each Sheet and will eventually hold the names of Test Cases that needs to be run
				ArrayList<String> ModuleExecute = TestCasestoExecute.ModuleExecute();
				ArrayList<String> SubMod1TestCasesExecute = TestCasestoExecute.SubMod1TestCaseExecute();
				ArrayList<String> SubMod2TestCasesExecute = TestCasestoExecute.SubMod2TestCaseExecute();
				ArrayList<String> SubMod3TestCasesExecute = TestCasestoExecute.SubMod3TestCaseExecute();
				ArrayList<String> SubMod4TestCasesExecute = TestCasestoExecute.SubMod4TestCaseExecute();
				
				for(int i =0; i<ModuleExecute.size(); i++){
					
					if (ModuleExecute.get(i).toString().equals(SubModule1)){SubModule1RunTestCases(SubMod1TestCasesExecute);}
					else if(ModuleExecute.get(i).toString().equals(SubModule2)){SubModule1RunTestCases(SubMod2TestCasesExecute);}
					else if(ModuleExecute.get(i).toString().equals(SubModule3)){SubModule1RunTestCases(SubMod3TestCasesExecute);}
					else if(ModuleExecute.get(i).toString().equals(SubModule4)){SubModule1RunTestCases(SubMod4TestCasesExecute);}
						
				}
				
			}
	
			
	//******************Run SubModule TestCases that need to be executed*****************
			
			public void SubModule1RunTestCases(ArrayList<String> SubModuleTestCases) throws Exception{
				
				for(int j =0; j<SubModuleTestCases.size(); j++)
	      	        	
      	        	if (SubModuleTestCases.get(j).toString().equals("TC01")){objTestCases.TC01();}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC02")){objTestCases.TC02();}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC03")){objTestCases.TC03();}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC04")){System.out.println("TestCase4");}
				
				}
								
			public void SubModule2RunTestCases( ArrayList<String> SubModuleTestCases) throws Exception{
				
				for(int j =0; j<SubModuleTestCases.size(); j++)
	      	        	
      	        	if (SubModuleTestCases.get(j).toString().equals("TC21")){System.out.println("TestCase21");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC22")){System.out.println("TestCase22");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC23")){System.out.println("TestCase23");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC24")){System.out.println("TestCase24");}
				
				}
		
			public void SubModule3RunTestCases( ArrayList<String> SubModuleTestCases) throws Exception{
				
				for(int j =0; j<SubModuleTestCases.size(); j++)
	      	        	
      	        	if (SubModuleTestCases.get(j).toString().equals("TC31")){System.out.println("TestCase31");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC32")){System.out.println("TestCase32");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC33")){System.out.println("TestCase33");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC34")){System.out.println("TestCase34");}
				
				}
			 
			public void SubModule4RunTestCases( ArrayList<String> SubModuleTestCases) throws Exception{
				
				for(int j =0; j<SubModuleTestCases.size(); j++)
					
      	        	if (SubModuleTestCases.get(j).toString().equals("TC41")){System.out.println("TestCase41");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC42")){System.out.println("TestCase42");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC43")){System.out.println("TestCase43");}
      	        	else if (SubModuleTestCases.get(j).toString().equals("TC44")){System.out.println("TestCase44");}
				
				}
			 
			
	
	}
