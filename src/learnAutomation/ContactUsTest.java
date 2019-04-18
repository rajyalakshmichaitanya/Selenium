package learnAutomation;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ContactUsTest extends LearnAutomationTest{
	@Test
	public void contactUsTest()
	{
		try {
			//invokeBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//li[@id='menu-item-1744']//span[@class='menu-text'][contains(text(),'Contact us')]")).click();
	}

}
