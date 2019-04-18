package faceBookDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CreateNewFBAccount {
	WebDriver driver;
	WebElement element;
	Actions act;
	Select month,day,year;
	public CreateNewFBAccount() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Chaitanya\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/campaign/landing.php?&campaign_id=296985387669172&extra_1=s%7Cc%7C322173475883%7Ce%7Cfacebook%20log%20in%7C&placement=&creative=322173475883&keyword=facebook%20log%20in&partner_id=googlesem&extra_2=campaignid%3D1667656791%26adgroupid%3D63650030359%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D1t1%26target%3D%26targetid%3Dkwd-298195186078%26loc_physical_ms%3D9030068%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMI5IaPn_2Q4AIVkx6tBh0xbgsWEAAYASAAEgI2nvD_BwE");
	}
	
	public void createNewAccount() throws Exception {
		driver.findElement(By.name("firstname")).sendKeys("raji");
		driver.findElement(By.name("lastname")).sendKeys("raji");
		driver.findElement(By.id("u_0_p")).sendKeys("raji@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("raji");
		//act=new Actions(driver);
		//act.moveToElement(driver.findElement(By.id("month"))).click();
		driver.findElement(By.id("month")).click();
		Thread.sleep(2000);
		selectDate();
		
		driver.findElement(By.xpath("//span/span[1]/label")).click();
		driver.findElement(By.name("websubmit")).click();
		
	}
	public void selectDate()
	{
		Select month=new Select(driver.findElement(By.id("month")));
		List<WebElement> monthList=month.getOptions();
		for(int i=0;i<monthList.size();i++)
		{
			element=monthList.get(i);
			System.out.println("Month List"+element.getText());
		
			if(element.getText().contentEquals("May"))
			{
				element.click();
				break;
			}
		}
		Select day=new Select(driver.findElement(By.id("day")));
		day.selectByIndex(4);
		Select year=new Select(driver.findElement(By.id("year")));
		year.selectByValue("1978");
	}
	public static void main(String[] args)throws Exception {
		
		CreateNewFBAccount obj=new CreateNewFBAccount();
		obj.createNewAccount();
		
		
	}

}
