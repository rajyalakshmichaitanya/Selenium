package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfig {
	Properties pro;
	public BrowserConfig()  {
		try {
			

		File file=new File("./Configuration\\config.property");
		
			FileInputStream fis= new FileInputStream(file);
				
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
		//System.out.println("exception is,+"+e.printStackTrace());
		}
			
		
	}
	public String getChromePath() {
		return pro.getProperty("ChromeDriver");
		
	}
	public String getFirefoxpath()
	{
		return pro.getProperty("FirefoxDriver");
	}
	public String getURL()
	{
		return pro.getProperty("URL");
	}

}
