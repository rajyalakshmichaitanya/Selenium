package ExcelTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.xml.bind.v2.model.core.Element;

import co.selenium.webdriver.basic.GoogleLoginForm;

public class ReadExcelData {
	int  rowcount;
	XSSFSheet sheet1;
	WebDriver driver;
	WebElement element;
	
	
	public void readExcel() throws Exception
	{
		File file=new File("C:\\Users\\Chaitanya\\eclipse-workspace\\Selenium\\Configuration\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//workbook.getSheetAt(0);
		sheet1=workbook.getSheetAt(0);
		rowcount=sheet1.getLastRowNum();
		System.out.println("number of rows"+rowcount);
		
		
	}
	public String getUsername()
	{
		String userName=null;
		for(int i=0;i<=rowcount;i++)
		{
		
			userName=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("rows in excel are          "+userName);
		}
		return userName;
		
	}
	public String getPassword()
	{
		{
			String password=null;
			for(int i=0;i<=rowcount;i++)
			{
			
				password=sheet1.getRow(i).getCell(1).getStringCellValue();
				System.out.println("rows in excel are          "+password);
			}
			return password;
			
		}
		
	}
	public void loginGmail(String user,String pass)
	{
		 element=driver.findElement(By.id("identifierId"));
		element.sendKeys(user);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.id("passwordNext")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
	public void LoginthroughExcel()
	{

		for (int row=0;row<rowcount;row++)
		{
			System.out.println("login to gmail"+row);
			loginGmail(getUsername(), getPassword());
			
		}
	}
	public void logincheck()
	{
		 element=driver.findElement(By.id("identifierId"));
		element.sendKeys(getUsername());
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(getPassword());
		driver.findElement(By.id("passwordNext")).click();
		//driver.findElement(By.xpath("//span[1][contains(text(),'Next')]")).click();
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/content[1]/span[1]")).click();
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReadExcelData excelData=new ReadExcelData();
		GoogleLoginForm obj=new GoogleLoginForm();
		obj.invokeBrowser();
		excelData.readExcel();
		excelData.LoginthroughExcel();
	

	}

}
