package learnAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  System.out.println(" ia m in test f @Test");
  }
  @Test
  public void f1() {
	  System.out.println(" ia m in test f1 @Test");
  }
  @BeforeClass
  public void s() {
	  System.out.println(" ia m in test s @BeforeClass");
  }
  @BeforeTest
  public void fp() {
	  System.out.println(" ia m in test fp BeforeTest");
  }
  @BeforeSuite
  public void lf() {
	  System.out.println(" ia m in test lf @BeforeSuite");
  }
  @AfterTest
  public void ff() {
	  System.out.println(" ia m in test ff@AfterTest ");
  }
  @AfterClass
  public void fa() {
	  System.out.println(" ia m in test fa@AfterClass");
  }
}
