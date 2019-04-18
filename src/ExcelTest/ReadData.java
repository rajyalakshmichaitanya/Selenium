package ExcelTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReadData {
	WebDriver driver;
	WebElement element;

	@BeforeMethod
	public void invokeBrowser() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Chaitanya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(
					"https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			
			// Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws InterruptedException, Exception {
		//driver.findElement(By.xpath("//*[@class='gb_cb gbii']")).click();
		driver.findElement(By.linkText("Sign out")).click();
		System.out.println("result of the test case"+result.isSuccess());
		if(ITestResult.FAILURE==result.getStatus())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File file=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\Chaitanya\\eclipse-workspace1\\Scrrenshots\\"+result.getName()+".png"));
			
		}
		driver.close();

	}

	@DataProvider(name="excelDataReader")
	public Object[][] read() throws Exception, IOException {
		File file = new File("C:\\Users\\Chaitanya\\eclipse-workspace\\Selenium\\Configuration\\TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		System.out.println("nember of rows" + rowcount);
		int cellCountInfirstRow = sheet.getRow(0).getLastCellNum();
		System.out.println("Cell count in first row" + cellCountInfirstRow);
		Object[][] data = new Object[rowcount + 1][cellCountInfirstRow];
		for (int i = 0; i <= rowcount; i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}

		}
		return data;

	}
	@Test(dataProvider="excelDataReader")
	public void login(String name,String pwd) throws Exception
	{
		
		element=driver.findElement(By.id("identifierId"));
		element.sendKeys(name);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.id("passwordNext")).click();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Chaitanya\\eclipse-workspace1\\Scrrenshots\\error.png"));
		
		
	}

}
