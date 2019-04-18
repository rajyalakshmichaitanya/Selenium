package co.selenium.webdriver.basic;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLoginForm {
	WebDriver driver;
	WebElement element;
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			logincheck();
		
			//Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void logincheck()
	{
		 element=driver.findElement(By.id("identifierId"));
		element.sendKeys("rajyalakshmichaitanya");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Chaitanya@123");
		driver.findElement(By.id("passwordNext")).click();
		//driver.findElement(By.xpath("//span[1][contains(text(),'Next')]")).click();
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/content[1]/span[1]")).click();
		compose();
	}
	public void compose()
	{
	 driver.findElement(By.xpath("//*[@class='gb_kf']")).click();
	 driver.findElement(By.xpath("//a[@id='gb23']//span[@class='gb_W']")).click();
	 //driver.findElement(By.id(":k9")).click();	
	}
	public void closeBrowser() {
		try {
			driver.findElement(By.xpath("//*[@class='gb_cb gbii']")).click();
			driver.findElement(By.linkText("Sign out")).click();
			Thread.sleep(2000);
			driver.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoogleLoginForm obj=new GoogleLoginForm();
		obj.invokeBrowser();
		obj.closeBrowser();
	}

}
//*[@id="gb_71"]
//*[@id="gb"]/div[2]
//a[@id='gb23']//span[@class='gb_W']
//*[@id="passwordNext"]/content/span
//*[@id="identifierNext"]/content/span
//*[@id="gbwa"]/div/a/svg/path
//*[@id="gbwa"]/div/a/svg
//*[@id=":k9"]/div/div
