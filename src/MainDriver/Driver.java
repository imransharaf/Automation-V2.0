package MainDriver;


import org.junit.Before;
import org.junit.Test;

import ExcelSheet.*;

public class Driver extends TestCasestoExecute{

		
	TestCasestoExecute objTestCasestoExecute = new TestCasestoExecute();
	
@Before	
	public void TestCases() throws Exception {
		
		objTestCasestoExecute.SelectTestCases();
      	
	}
	
@Test	
	public  void Run() throws Exception{
		
		//RunTestCases(TestCasestoExecute.SubMod1TestCaseExecute());
	}
	
	
	
}
