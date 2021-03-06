package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;


public class TestBase extends AbstractTestNGCucumberTests {
	
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			String chromePath = System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe";
			// set chrome web driver
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			
		}else if (browsername.equalsIgnoreCase("firefox")) {
			
			String geckoPath = System.getProperty("user.dir") +"\\Drivers\\geckodriver.exe";
			// set gecko web driver
			System.setProperty("webdriver.gecko.driver", geckoPath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.navigate().to("http://tskdportal.megatrust.info/#/auth/login"); //my oddo

	}
	
	@AfterSuite
	public void stopDriver(){
		driver.quit();
	}
	
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot!...");
			Helper.captureScreenshot(driver, result.getName());
		}
	}

}
