package learnAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {
	WebDriver driver;
	WebElement element;
	@Test
	public void explicitTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.hotels.com/");
		System.out.println("title of the page"+driver.getTitle());
		//Alert alert=driver.switchTo().alert();
		//alert.dismiss();
		element=driver.findElement(By.xpath("//button[@class='cta widget-overlay-close']"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
		JavascriptExecutor jc=(JavascriptExecutor)driver;
		//jc.executeScript("arguments[0].scrollIntoView(true);",driver.switchTo().frame(1));
		System.out.println("switch to the frame"+driver.switchTo().frame(1).getTitle());
		//*[@id="ftframe3240859"]
		//driver.findElement(By.partialLinkText("SEE DEALS")).click();
		driver.close();
		
	}


}
