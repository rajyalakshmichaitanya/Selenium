package britishAirways;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//@Test
public class BookingPage {
	WebDriver driver;
	WebElement element;
	String[] disElements; 
	//@Test(groups= {"register"})
	public void invokeBrowser() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.britishairways.com/en-us/home#/");
		//discover();
		//flightBooking();
		booking();
		
		
	}
/*	public void flightBooking()
	{
		Actions flightBookingAction=new Actions(driver);
		flightBookingAction.moveToElement(driver.findElement(By.xpath("//li[@id='flightTab']//div[@class='product-tab']"))).build().perform();
		flightBookingAction.contextClick(driver.findElement(By.xpath("//div[@class='product-tab selected']//span[@class='product-type h5 bold ng-binding'][contains(text(),'Flight')]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}*/
	public void discover()
	{
		//driver.findElement(By.xpath(("//img[@class='masterbrandPositiveLogo']"))).click();
		
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
			System.out.println("options are "+element.getText());
			if(option.contains("Book a flight"))
			{
			
				element.click();
				break;
			}
		}
		
				WebDriverWait wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Continue"))).click();
	
				JavascriptExecutor jc=(JavascriptExecutor)driver;
				jc.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@id='depDate']")));
				
			driver.findElement(By.xpath("//input[@id='depDate']")).click();

			List<WebElement> disableDates=driver.findElements(By.xpath("//*[@id='depDate_table']/tbody/tr/td/div[@class='picker__day picker__day--infocus picker__day--disabled']"));
			System.out.println("disable dates are"+disableDates.size());
			for(WebElement ddate:disableDates)
			{
				int i=0;
				disElements[i]=ddate.getText();
				System.out.println("disabled dates are"+ddate.getText());
				i++;
			}
			
			List<WebElement> dates=driver.findElements(By.xpath("//*[@id='depDate_table']/tbody/tr/td/div"));
			System.out.println("size of the list*******"+dates.size());
			for(WebElement date:dates)
			{
			int j=0;
				System.out.println("elements are****************"+date.getText());
				if(!date.getText().equalsIgnoreCase(disElements[j]))
				{
					if((date.getText().equalsIgnoreCase("23")))
					{
					date.click();
					break;
					}
				}
				else
				{
					System.out.println("sorrrrrrrrrrrrrrrrrry");
					break;
				}
				j++;
			}
			
		}
					
			    //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
				//break;
				
				
				
				

	/*	driver.findElement(By.xpath("")).click();
		List<WebElement> selectRadio=driver.findElements(By.xpath("//div[@class='formRow planTripOptions']"));
		System.out.println("size of the list"+selectRadio.size());
		for(int i=0;i<selectRadio.size();i++)
		{
			String radio=selectRadio.get(i).getAttribute("innerHTML");
			System.out.println("radio button options are"+radio);
		}*/
		
	public void createTrip()
	{
		driver.findElement(By.xpath("//header[@aria-labelledby='viewAll']//h3")).click();
		List<WebElement> selectRadio=driver.findElements(By.xpath("//div[@class='formRow planTripOptions']"));
		System.out.println("size of the list"+selectRadio.size());
		for(int i=0;i<selectRadio.size();i++)
		{
			String radio=selectRadio.get(i).getAttribute("innerHTML");
			System.out.println("radio button options are"+radio);
		}
	}
	
	//@Test(groups= {"register"})
	public void registerNow() throws Exception
	{
		
		JavascriptExecutor jc=(JavascriptExecutor)driver;
		jc.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']")));
		Actions registerClick=new Actions(driver);
		driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']")).click();
		//registerClick.contextClick(driver.findElement(By.xpath("//a[@class='button-center secondary medium blue ng-binding ng-isolate-scope']"))).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//WebElement element1=driver.findElement(By.name("Continue"));	
		//element1.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Continue"))).click();
		
		driver.findElement(By.name("emailaddress")).sendKeys("rajyalakshmichaitanya@gmail.com");
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
		driver.findElement(By.xpath("//span[@class='align-right']")).click();

				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingPage obj=new BookingPage();
		try {
			obj.invokeBrowser();
			//obj.createTrip();
			//obj.booking();
			//obj.registerNow();
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
/*Actions flightBookingAction=new Actions(driver);
flightBookingAction.contextClick(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();

System.out.println("title of the page"+driver.getTitle());
String parent=driver.getWindowHandle();
System.out.println("parent window"+parent);
Set<String> allWindows=driver.getWindowHandles();

for(String child:allWindows)
{

	if(!parent.equalsIgnoreCase(child))
	{
		driver.switchTo().window(child);
		break;
	}
}*/
//*[@id="content"]/div[2]/header/div[2]/nav/ul/li[1]/div//a
//div[@class='picker__frame']/div[@class='picker__wrap']/div[@class='picker__box']/div[2]