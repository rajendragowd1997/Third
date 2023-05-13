  package driverFactory;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelFileUtil;
import commonFunctions.FunctionLibrary;
import config.AppUtil;

public class DriverScript extends AppUtil {
String	inputpath="D:\\mng\\11-batch\\eclipse-workspace\\DDT-FrameWork\\DataTables\\LoginData.xlsx";
String outputpath = "D:\\mng\\11-batch\\eclipse-workspace\\DDT-FrameWork\\TestResults\\DataDrivenResults.xlsx";
ExtentReports report;
ExtentTest test;
//@Test
public void Login() throws Throwable {
	report = new ExtentReports("./?Report/DataDriven.html");
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc = xl.rowcount("Login");
	Reporter.log("No of rows are ::"+rc,true);
	for(int i=1;i<=rc;i++) {
		test = report.startTest("validate Login");
		String user = xl.getCellData("Login", i,0);
		String pass = xl.getCellData("Login", i, 1);
		boolean res = FunctionLibrary.VerifyLogin(user,  pass);
		if(res) {
			xl.setCellData("Login", i, 2, "Login pass", outputpath);
			xl.setCellData("Login", i, 3,"pass", outputpath);
			test.log(LogStatus.PASS,"Login.sucess");
		}else {
			xl.setCellData("Login", i, 2, "Login fail", outputpath);
			xl.setCellData("Login", i, 3,"fail", outputpath);
			test.log(LogStatus.FAIL,"Login Fail");
		} report.endTest(test);
		report.flush();
	}
}
}
