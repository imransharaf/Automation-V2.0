package ComplexFactoryUsage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.SimpleReportFactory;

public class Test001C {

	private ExtentReports reporter = SimpleReportFactory.getReporter();

	@Test
	public void complexTest001() {
		ExtentTest testReporter = reporter.startTest("complexTest001", "This is a simple simpleTest001");
		testReporter.log(LogStatus.INFO, "Starting test complexTest001");
		int a = 100;
		int b = 30;

		testReporter.log(LogStatus.INFO, "Loading the value of a to " + a);
		testReporter.log(LogStatus.PASS, "Loading the value of b to " + b);
		reporter.endTest(testReporter);
	}

	@Test
	public void complexTest002() {
		ExtentTest testReporter = reporter.startTest("complexTest002", "This is a simple simpleTest001");
		testReporter.log(LogStatus.INFO, "Starting test complexTest002");
		int a = 100;
		int b = 30;

		testReporter.log(LogStatus.INFO, "Loading the value of a to " + a);
		testReporter.log(LogStatus.PASS, "Loading the value of b to " + b);
		reporter.endTest(testReporter);

	}
	
	@AfterSuite
	public void afterSuite()
	{
		reporter.close();
	}

}
