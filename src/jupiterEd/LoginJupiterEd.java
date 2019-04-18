package jupiterEd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginJupiterEd {
	WebDriver driver;
	WebElement element;
	Select state;
	Actions action;
	public LoginJupiterEd() {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Chaitanya\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://login.jupitered.com/login/");
	}
	public void parentLogin() throws Exception {
		driver.findElement(By.id("tab_parent")).click();
		driver.findElement(By.id("text_studid1")).sendKeys("Sashank Kocherlakota");
		driver.findElement(By.id("text_password1")).sendKeys("Sashank");
		driver.findElement(By.id("text_school1")).sendKeys("Lincoln Preparatory");
		driver.findElement(By.id("text_city1")).sendKeys("Chandler");
		driver.findElement(By.id("ph_region1")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='menulist_region1']//div[3]")));
		//driver.findElement(By.xpath("//div[@id='menulist_region1']//div[3]")).click();
		System.out.println("string is"+driver.findElement(By.xpath("//div[@id='menulist_region1']//div[3]")).getAttribute("innerHTML"));
		driver.findElement(By.xpath("//div[@id='menulist_region1']//div[3]")).click();
		
		
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LoginJupiterEd obj=new LoginJupiterEd();
		obj.parentLogin();

	}

}
