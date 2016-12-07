package testcase;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingIFrames {

	WebDriver driver=null;

	@Test
	public void testIframes() throws InterruptedException{

		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver=new ChromeDriver();

		driver.get("http://www.w3schools.com/js/");
		driver.findElement(By.xpath("//*[@id='main']/div[4]/p/a")).click();
		Thread.sleep(2000);

		//WebElement ele=driver.findElement(By.xpath("//div[@id='iframe']"));
		//driver.findElement(By.xpath("//div[@id='iframe']"));
		//Thread.sleep(2000);
		//driver.switchTo().frame(ele);
		System.out.println("fvovnodvnovdovn  o ono ovonvonnvlnfbnslnldsnv  onon ovn no nv");
		//driver.findElement(By.xpath("//body[contains(text(),'Click me to display Date and Time.")).click();
		//	System.out.println(driver.findElement(By.cssSelector()));


	}

}
