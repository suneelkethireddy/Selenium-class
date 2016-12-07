package testcase;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstWebDriver {

	public static void main(String[] args) {

		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.ebay.com");
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("email")).sendKeys("**********************@gmail.com");
		driver.findElement(By.name("remail")).sendKeys("******************@gmail.com");
		driver.findElement(By.id("PASSWORD")).sendKeys("************");
		driver.findElement(By.cssSelector("input#firstname.fld.wide")).sendKeys("***********");
		driver.findElement(By.cssSelector("input#lastname.fld.wide")).sendKeys("************");
		driver.findElement(By.xpath("//a[contains(text(),'have a mobile phone')]")).sendKeys("************");
		driver.findElement(By.id("sbtBtn")).click();
	}
}
