package Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class baseclass {
	
	public WebDriver driver;
	String configpath = "./src/main/resources/properties/Config.properties";
	Propertyfile pf;
	
	@BeforeClass
	public void setUp() throws Exception
	{
		Reporter.log("inside setup");
		pf = new Propertyfile();
		String browsername = pf.callpropertyfile("browser", configpath);
		System.out.println(browsername);
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", pf.callpropertyfile("chromedriver", configpath));
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", pf.callpropertyfile("firefoxdriver", configpath));
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown()
	{
		Reporter.log("inside teadown");
		driver.close();
	}
}
