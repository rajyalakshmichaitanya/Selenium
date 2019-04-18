package bootStrap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestBootstrap {
	WebDriver driver;
	WebElement dropdownelement;
	Actions act;
	public void invokeBrowser()
	{
		try {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.get("http://archwaylincoln.greatheartsacademies.org/");
			driver.get("https://www.google.com");
			//bootStrap();
		
			//Thread.sleep(2000);
			//searchBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void bootStrap() throws Exception
	{
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-item-19\"]/a"))).perform();
		//driver.findElement(By.xpath("//*[@id=\"menu-item-19\"]/a")).click();
		//Thread.sleep(2000);
		List<WebElement>dropdown=driver.findElements(By.xpath("//*[@id=\"menu-item-19\"]//ul//li//a"));
		for (int i=0;i<dropdown.size();i++)
		{
			dropdownelement=dropdown.get(i);
			String str=dropdownelement.getAttribute("innerHTML");
			System.out.println("value of string*************"+str);
			if(str.contentEquals("Curriculum"))
			{
				dropdownelement.click();
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBootstrap bootstrap=new TestBootstrap();
		bootstrap.invokeBrowser();

	}

}
////li[@id='menu-item-19']//a[@contains title,'academics']//ul[contains(@class,'dropdown-menu')]//li//a
//ul[contains(@class,'dropdown-menu')]//li//a
//li//a[@title='Academics']//ul[contains(@class,'dropdown-menu')
//*[@id="menu-item-19"]//a