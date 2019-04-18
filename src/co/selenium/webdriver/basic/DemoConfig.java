package co.selenium.webdriver.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoConfig {
	WebDriver driver;
	Properties prop;
	public void configPropertyFile() throws FileNotFoundException
	{
		File f=new File("./Configuration\\\\config.property");
		try {
			InputStream fis=new FileInputStream(f);
			prop=new Properties();
			prop.load(fis);
			System.out.println("property file"+prop.getProperty("ChromeDriver"));
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriver"));
			driver=new ChromeDriver();
			driver.get("https://www.youtube.com/watch?v=bljA8dpfWeQ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoConfig obj=new DemoConfig();
		try {
			obj.configPropertyFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
