package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties config;
@BeforeTest 
public static void setup() throws Throwable {
	config = new Properties();
	driver = new ChromeDriver();
	driver.get(config.getProperty("Url"));
	config.load(FileInputStream("D:\\mng\\11-batch\\eclipse-workspace\\DDT-FrameWork\\StockHybridExcel.xlsx"));
}
private static Reader FileInputStream(String string) {
	
	return null;
}
@AfterTest
public static void tear() {
	driver.quit();
}
}
