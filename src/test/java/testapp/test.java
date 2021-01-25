package testapp;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import Utilities.baseclass;

public class test extends baseclass {
	
	WebElement we, we1, we2;
	
	@Test
	public void test1() throws InterruptedException
	{
		Reporter.log("inside test");
		driver.get("https://www.google.co.in");
		we = driver.findElement(By.xpath("//input[@name='q']"));
		we1 = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		if(we.isDisplayed())
		{
			we.sendKeys("Search the article");
			we.sendKeys(Keys.TAB);
		}
		Thread.sleep(5000);
		if(we1.isDisplayed())
		{
			we1.click();
		}
		Thread.sleep(5000);
		
		we2 = driver.findElement(By.linkText("Goog Scholar"));
		try{
//		if()
//		{
//			System.out.println("**************pass");
//			assertTrue(true);
//			assertFalse(true);
			assertEquals(we2.isDisplayed(), true);
//		}
		}
		catch(Exception e)
		{
			System.out.println("**************fail");
			assertTrue(false);
		}
	}
	
	
	
}
