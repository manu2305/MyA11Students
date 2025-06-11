package com.crm.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.OrangeHRMBase1;

public class ReportwithScreenshot extends OrangeHRMBase1 implements ITestListener{
	public static ExtentSparkReporter spark=null;
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name+" is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = result.getMethod().getMethodName();
		test.log(Status.FAIL, name+" is fail");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, name+" is skip");
		
	}

	@Override
	public void onStart(ITestContext context) {
		//create extentSparkReporter
				spark=new ExtentSparkReporter(".\\src\\test\\resources\\ExtentReport\\SampleTestCase.html");
				//configure the extentsparkreporter
				spark.config().setDocumentTitle("Testng Iam your dad");
				spark.config().setReportName("Manikandan j");
				spark.config().setTheme(Theme.DARK);
				//create ExtentReports
				report=new ExtentReports();
				//set extentReports
				report.setSystemInfo("Browser","Chrome-111");
				report.setSystemInfo("OS","Windows-11");
				//attach the ExtentSparkReporter to ExtentReport
				report.attachReporter(spark);
				//create ExtentTest 
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
