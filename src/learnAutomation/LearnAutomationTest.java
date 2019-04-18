package learnAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnAutomationTest {
	WebDriver driver;
	Actions act;
@BeforeTest
@Parameters("browser")
	public void loadDriver(String browsername)
	{
	if (browsername.equalsIgnoreCase("chrome1"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chaitanya\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
	}

	}
@Test(priority=1)
	public void invokeBrowser() throws Exception
	{
		try {
			

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://learn-automation.com/");
			System.out.println("i am in befor class");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		}
@Test
@Parameters({"a","b"})
public void sum(int a,int b)
{
	System.out.println("sum 1111111111111111**"+(a+b));
}
	
/*@AfterClass
public void closeBrower()
{
	//driver.manage().deleteAllCookies();
	System.out.println("i am in after class");
	
}*/
@AfterClass
public void close()
{
	driver.close();
	System.out.println("I am in after test");
}


}
