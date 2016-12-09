package testcase;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlerts {

	static WebDriver driver=null;
	static WebDriverWait wait=null;
	static Alert alert=null;
	@Test
	public  void checkAlertMessage(){

		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://spicejet.com");
		driver.findElement(By.xpath("//input[contains(@id,'FindFlights')]")).click();
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		String expectedAlertMsg="Please select Origin and Destination cities";
		alert=driver.switchTo().alert();
		String actualAlertMsg=alert.getText().toString();
		System.out.println("Alert text:"+actualAlertMsg);
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);
	}
}
