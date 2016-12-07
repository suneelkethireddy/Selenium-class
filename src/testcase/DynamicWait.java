package testcase;

import java.awt.Robot;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicWait {
	WebDriver driver=null;
	@Test
	public void checkingUsingDynamicWeight() throws Exception{
		
		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver=new ChromeDriver();
		driver.get("http://www.ebay.com");
		
		Robot rob=new Robot();
		rob.mouseMove(0, 0);
		WebElement ele=driver.findElement(By.xpath("//a[@class='rt' and contains(text(),'Motors')]"));
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Motors Blog')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a/strong[contains(text(),'Events')]")).click();
		WebElement sm=driver.findElement(By.xpath("//a/span[contains(text(),'Shop Motors')]"));
		action.moveToElement(sm).build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Frontline')]")).click();
	}

}
