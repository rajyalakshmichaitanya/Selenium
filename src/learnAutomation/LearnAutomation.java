package learnAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnAutomation {
	WebDriver driver;
	Actions act;

	public void invokeBrowser() throws Exception
	{
		try {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://learn-automation.com/");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	public void automationTools()
	{
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.partialLinkText("Automation Tools"))).perform();
			
		List<WebElement>dropdown=driver.findElements(By.xpath("//*[@id=\"menu-item-4270\"]/ul/li"));
		for (int i=0;i<dropdown.size();i++)
		{
			 WebElement dropdownelement=dropdown.get(i);
			String str=dropdownelement.getAttribute("innerHTML");
			System.out.println("value of string*************"+str);
			//System.out.println("string contains"+);
			if(str.contains("Selenium"))
			{
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				//dropdownelement.click();
				break;
			}
		}
		
	}
	public void selectJunkinSelenium()
	{
		WebElement element=driver.findElement(By.xpath("//*[@id=\"menu-item-4269\"]/a/span"));
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//li[@id='menu-item-1745']//span[contains(text(),'Jenkins with Selenium')]")).click();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		//ClickPopupElement.clickByClassName(driver, "sendx-modal-close-dNnOns5gBj56SFGkOimE4p");
		driver.findElement(By.id("sendx-submit-form-dNnOns5gBj56SFGkOimE4p")).click();
		driver.findElement(By.name("First Name")).sendKeys("raji");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sendx-modal-close-dNnOns5gBj56SFGkOimE4p"))).click();
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.className("sendx-modal-close-dNnOns5gBj56SFGkOimE4p"));
			}
		});
		
		//click on the selenium link
		clickseleniumlink.click();*/
		
		}


public void close()
{
	driver.close();
}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		LearnAutomation obj=new LearnAutomation();
		obj.invokeBrowser();
		obj.automationTools();
		obj.selectJunkinSelenium();
	}
}
//*[@id="menu-item-1745"]/a/span*/
