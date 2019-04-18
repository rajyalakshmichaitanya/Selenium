package learnAutomation;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class RightClick {
	WebDriver driver;
	Actions act1,act2;
	
	
	public void invokeBrowser() throws Exception
	{
		try {
				
				System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Chaitanya\\\\Downloads\\\\geckodriver-v0.23.0-win64\\\\geckodriver.exe");
				driver=new FirefoxDriver();

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://learn-automation.com/");
			System.out.println("i am in befor class");
			automationTools();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void automationTools()
	{
		 act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.partialLinkText("Automation Tools"))).perform();
		//act1.contextClick(driver.findElement(By.partialLinkText("Automation Tools"))).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		
		//driver.findElement(By.partialLinkText("Automation Tools")).sendKeys(Keys.chord(Keys.SHIFT,Keys.F10));
		//act.contextClick(driver.findElement(By.partialLinkText("Automation Tools"))).perform();
		
		List<WebElement>dropdown=driver.findElements(By.xpath("//*[@id=\"menu-item-4270\"]/ul/li"));
		for (int i=0;i<dropdown.size();i++)
		{
			 WebElement dropdownelement=dropdown.get(i);
			String str=dropdownelement.getAttribute("innerHTML");
			System.out.println("value of string*************"+str);
			//System.out.println("string contains"+);
			if(str.contains("TestNG"))
			{
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				act1.contextClick(dropdownelement).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
				
				String parent=driver.getWindowHandle();
				System.out.println("parent window"+parent);
				Set<String> allwindows=driver.getWindowHandles();
				for(String child:allwindows)
				{
					if(!parent.equalsIgnoreCase(child))
					{
						System.out.println("child window"+child);
						driver.switchTo().window(child);
						break;
					}
				}
				
				break;
			}
		}
		
	}
public void getAllLinks()
{
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("nmber of links"+links.size());
	for (int i = 1; i<=links.size(); i = i+1) {
        System.out.println("Name of Link# " + i + links.get(i).getText());
     }
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RightClick obj=new RightClick();
		try {
			obj.invokeBrowser();
			//obj.getAllLinks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
