package testcase;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EbayAssertions {

	static WebDriver driver=null;
	static String actual=null;
	static String expected=null;
	@BeforeSuite
	public static void startWebDriver(){
		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://www.ebay.com/");
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("sbtBtn")).click();
	}
	
	/*For Text below the Error message
	 * 1.Please fix the errors
	 * 2.Email
	 * 3.Reenter Email
	 * 4.password
	 * 5.firstname
	 * 6.lastname
	 */
	@Test
	public static void assertionOnEbay() throws Exception{
		
		actual="Please fix the errors highlighted in the fields below:";
		WebElement ele=driver.findElement((By.id("ertx")));
		expected=ele.getText();
		Assert.assertEquals(actual, expected);
		
		ele=driver.findElement(By.id("er_email"));
		expected=ele.getText();
		actual="Email";
		Assert.assertEquals(actual, expected);
		
		ele=driver.findElement(By.id("er_remail"));
		expected=ele.getText();
		actual="Reenter email";
		Assert.assertEquals(actual, expected);
		
		ele=driver.findElement(By.id("er_PASSWORD"));
		expected=ele.getText();
		actual="Password";
		Assert.assertEquals(actual, expected);
		
		ele=driver.findElement(By.id("er_firstname"));
		expected=ele.getText();
		actual="First name";
		Assert.assertEquals(actual, expected);
		
		ele=driver.findElement(By.id("er_lastname"));
		expected=ele.getText();
		actual="Last name";
		Assert.assertEquals(actual, expected);
	}
	
	/*To check for the text under error message
	 * 1.Email
	 * 2.Re-Enter Email
	 * 3.password
	 * 5.firstname
	 * 6.lastname 
	 */
	@Test
	public static  void assertionUnderTextField(){
		actual="Please enter your email address.";
		WebElement ele=driver.findElement((By.id("email_w")));
		expected=ele.getText();
		Assert.assertEquals(actual, expected);
		
		actual="Don't forget to reenter your email address!";
		 ele=driver.findElement((By.id("remail_w")));
		expected=ele.getText();
		Assert.assertEquals(actual, expected);
		
		actual="Please enter your password.";
		 ele=driver.findElement((By.id("PASSWORD_w")));
		expected=ele.getText();
		Assert.assertEquals(actual, expected);
		
		actual="Please enter your first name.";
		 ele=driver.findElement((By.id("firstname_w")));
		expected=ele.getText();
		Assert.assertEquals(actual, expected);
		
		actual="Please enter your last name.";
		 ele=driver.findElement((By.id("lastname_w")));
		expected=ele.getText();
		Assert.assertEquals(actual, expected);
		
	}
}
