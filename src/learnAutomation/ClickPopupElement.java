package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickPopupElement {
	public static void clickByClassName(WebDriver idriver,String name)
	{
		Actions act=new Actions(idriver);
		act.moveToElement(idriver.findElement(By.className(name))).click().build().perform();
	}

}
