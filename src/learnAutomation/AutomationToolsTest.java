package learnAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutomationToolsTest extends LearnAutomationTest{
	@Test
	public void automationTools()
	{
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.partialLinkText("Automation Tools"))).perform();
		//act.contextClick(driver.findElement(By.partialLinkText("Automation Tools"))).perform();
		
		List<WebElement>dropdown=driver.findElements(By.xpath("//*[@id=\"menu-item-4270\"]/ul/li"));
		for (int i=0;i<dropdown.size();i++)
		{
			 WebElement dropdownelement=dropdown.get(i);
			String str=dropdownelement.getAttribute("innerHTML");
			System.out.println("value of string*************"+str);
			//System.out.println("string contains"+);
			if(str.contains("Selenium"))
			{
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				//dropdownelement.click();
				break;
			}
		}
		
	}
	@Test(dependsOnMethods="automationTools")
	public void selectJunkinSelenium()
	{
		System.out.println("In select junkins ");
		WebElement element=driver.findElement(By.xpath("//*[@id=\"menu-item-4269\"]/a/span"));
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//li[@id='menu-item-1745']//span[contains(text(),'Jenkins with Selenium')]")).click();
		//WebDriverWait wait= new WebDriverWait(driver, 20);
		//WebElement popup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='sendx-close-dNnOns5gBj56SFGkOimE4p']")));
		//popup.click();
		System.out.println("out of select junkins ");
		}

}
//sendx-submit-form-dNnOns5gBj56SFGkOimE4p
