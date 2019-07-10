package ComplexFactoryUsage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.SimpleReportFactory;

public class Test002C {

	private ExtentReports reporter = SimpleReportFactory.getReporter();

	@Test
	public void complexTest003() {
		ExtentTest testReporter = reporter.startTest("complexTest003", "This is a simple simpleTest001");
		testReporter.log(LogStatus.INFO, "Starting test complexTest031");
		int a = 100;
		int b = 30;

		testReporter.log(LogStatus.INFO, "Loading the value of a to " + a);
		testReporter.log(LogStatus.PASS, "Loading the value of b to " + b);
		reporter.endTest(testReporter);
	}

	@Test
	public void complexTest004() {
		ExtentTest testReporter = reporter.startTest("complexTest004", "This is a simple simpleTest001");
		testReporter.log(LogStatus.INFO, "Starting test complexTest004");
		int a = 100;
		int b = 30;

		testReporter.log(LogStatus.INFO, "Loading the value of a to " + a);
		testReporter.log(LogStatus.PASS, "Loading the value of b to " + b);
		reporter.endTest(testReporter);

	}


}
