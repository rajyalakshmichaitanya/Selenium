package learnAutomation;

import java.awt.RenderingHints.Key;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.crypt.dsig.KeyInfoKeySelector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

public class WindowHandle {
	
	WebDriver driver;
	WebElement element;
	Actions act1,act2;
	@Test
	public void explicitTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.hotels.com/");
		act1=new Actions(driver);
		act1.contextClick(driver.findElement(By.partialLinkText("Gift Cards"))).click();
		act1.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		act1.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		String parent=driver.getWindowHandle();
		Set<String> allwindowHandles=driver.getWindowHandles();
		System.out.println("size"+allwindowHandles.size());
		/*for (String childwindow : allwindowHandles) {
			System.out.println("window        "+childwindow );
			if(!parent.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
			}
			
		}*/
		java.util.Iterator<String> it=allwindowHandles.iterator();
		it.next();
		String str=it.next();
		driver.switchTo().window(str);
		System.out.println("title of the page"+driver.getTitle());
		driver.close();

}
}

