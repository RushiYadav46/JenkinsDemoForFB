package sample_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookLoginPage {
  
	WebDriver driver;
	@BeforeClass
	public void InitializingDriver()
	{
		Reporter.log("Starting browser...",true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void OpenFBloginPage() 
	{
		Reporter.log("Opening FB login Page...",true);
		driver.get("https://www.facebook.com/signup");
	}
	
	@Test
	public void ValidatingEmptyfield() throws InterruptedException 
	{
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//input[@name='firstname']")).getText();
		Assert.assertEquals(text, "", "Not Empty..");
	}
	
	@AfterMethod
	public void ClosingFBLoginPage() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
