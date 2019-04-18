package faceBookDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTest {
	WebDriver driver;
	public void invoke()
	{
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Chaitanya\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Screen screen=new Screen();
		Pattern firstName=new Pattern("C:\\Users\\Chaitanya\\eclipse-workspace\\Images\\FirstName");
		Pattern lastName=new Pattern("C:\\Users\\Chaitanya\\eclipse-workspace\\Images\\LastName.PNG"); 
		try {
			screen.type(firstName, "raji");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)throws Exception {
		

		SikuliTest obj=new SikuliTest();
		obj.invoke();
		
	}

}
