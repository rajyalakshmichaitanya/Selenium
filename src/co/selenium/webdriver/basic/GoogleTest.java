package co.selenium.webdriver.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
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
	

	}

}
