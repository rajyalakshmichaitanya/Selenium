package co.selenium.webdriver.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day1 {
	WebDriver driver;
	@Test
	public void invokeBrowser()
	{
		try {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.get("https://www.amazon.com/");
			driver.get("https://www.google.com");
			System.out.println("Title of the current page"+driver.getTitle());
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("tests");
			List<WebElement> searchList=driver.findElements(By.xpath("//div[@class='UUbT9']//li"));
			System.out.println("size of search list is"+searchList.size());
			for(WebElement search:searchList)
			{
				System.out.println(search.getText());
			}
		
			//Thread.sleep(2000);
			//searchBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void searchBooks() {
		try {
			//driver.findElement(By.id("searchDropdownBox")).click();
			Select selectobj=new Select(driver.findElement(By.id("searchDropdownBox")));
			selectobj.selectByVisibleText("Books");
			//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
			//System.out.println("text is"+driver.findElement(By.id("searchDropdownBox")).getText());
			//driver.findElement(By.linkText("Books")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java");
			driver.findElement(By.className("nav-input")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Day1 obj=new Day1();
		obj.invokeBrowser();
		//obj.searchBooks();
		
	}

}
