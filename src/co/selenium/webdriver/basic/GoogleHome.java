package co.selenium.webdriver.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.BrowserConfig;

public class GoogleHome {
	WebDriver driver;
	public void testGoogleHome()
	{
		BrowserConfig config=new BrowserConfig();
		System.setProperty("webdriver.gecko.driver", config.getChromePath());
		driver=new FirefoxDriver();
		driver.get(config.getURL());
		driver.close();
		//System.setProperty("webdriver.gecko.driver", config.getChromePath());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoogleHome obj=new GoogleHome();
		obj.testGoogleHome();
	}

}
