package learnAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
@Test
public class BookingPageTest {
	WebDriver driver;
	WebElement element;
	public void invokeBrowser() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.britishairways.com/en-us/home#/");
		//discover();
		
		
	}
	public void discover()
	{
		driver.findElement(By.xpath(("//img[@class='masterbrandPositiveLogo']"))).click();
		
		driver.findElement(By.partialLinkText("Discover")).click();
		List<WebElement> bookingList=driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/header/div[2]/nav/ul/li[1]/div//a"));
		System.out.println("size of the list"+bookingList.size());
		for (int i=0;i<bookingList.size();i++)
		{
			element=bookingList.get(i);
			String option=element.getAttribute("innerHTML");
			System.out.println("options are "+element.getAttribute("innerHTML"));
			if(option.contains("Flights to London"))
			{
				element.click();
				break;
			}
			
		}
		}
	
	public void booking() throws Exception
	{
		driver.findElement(By.xpath("//a[@class='ng-binding'][contains(text(),'Book')]")).click();
		Thread.sleep(2000);
		List<WebElement> bookingList=driver.findElements(By.xpath("//div[@class='sub-navigation sub-nav-information two-column open open-click']//div[@class='ng-scope']//a"));
		System.out.println("size of the list"+bookingList.size());
		for (int i=0;i<bookingList.size();i++)
		{
			element=bookingList.get(i);
			String option=element.getAttribute("innerHTML");
			System.out.println("options are "+element.getAttribute("innerHTML"));
			if(option.contains("Book a flight"))
			{
				element.click();
				break;
			}
			
		}
	}
	public void registerNow() throws Exception
	{
		
		JavascriptExecutor jc=(JavascriptExecutor)driver;
		jc.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']")));
		//jc.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']")));
		Actions registerClick=new Actions(driver);
		registerClick.contextClick(driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']"))).sendKeys(Keys.ARROW_DOWN).build().perform();
		Point pt=driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']")).getLocation();
		int x=pt.getX();
		int y=pt.getY();
		System.out.println("values of x and y "+x+ "and"+y);
		//registerClick.moveToElement(driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']"))).click().build().perform();
		
		Thread.sleep(2000);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		//registerClick.moveByOffset(x, y).click().build().perform();
		//registerClick.sendKeys(Keys.ARROW_DOWN).build().perform();
		
		
		//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']
		/*driver.findElement(By.name("emailaddress")).sendKeys("rajyalakshmichaitanya@gmail.com");
		driver.findElement(By.name("confirmemailaddress")).sendKeys("rajyalakshmichaitanya@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Sreeram@123");
		driver.findElement(By.name("confirmpassword")).sendKeys("Sreeram@123");
		Select title=new Select(driver.findElement(By.id("title")));
		List<WebElement> element =title.getOptions();
		for(int i=0;i<element.size();i++)
		{
			if(element.get(i).getText().contentEquals("Miss"))
			{
				element.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("first-name")).sendKeys("Rajyalakshmi");
		driver.findElement(By.id("family-name")).sendKeys("Sanagavarapu");
		driver.findElement(By.xpath("//fieldset[@class='vanilla-exec-section']")).click();
		driver.findElement(By.xpath("//span[@class='align-right']")).click();*/

				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingPageTest obj=new BookingPageTest();
		try {
			obj.invokeBrowser();
			obj.booking();
			obj.registerNow();
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
//*[@id="content"]/div[2]/header/div[2]/nav/ul/li[1]/div//a