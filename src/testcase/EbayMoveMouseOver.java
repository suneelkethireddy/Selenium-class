package testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EbayMoveMouseOver {
	
	public static void main(String args[]) throws InterruptedException, AWTException{
		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.ebay.com/");
		
		Robot rob=new Robot();
		rob.mouseMove(0, 0);
		
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//a[@class='rt' and contains(text(),'Motors')]"));	
		action.moveToElement(ele).build().perform();
		
		Thread.sleep(9000);
		
		
		List<WebElement> Init=driver.findElements(By.xpath("//td[contains(@class,'cat show')]/div[2]/div/div/ul/li"));
		Iterator<WebElement> iterator = Init.iterator();
		while(iterator.hasNext()){
			WebElement cat=driver.findElement(By.xpath("//div[@class='sub-cats']/div/ul/li[1]"));
			System.out.println(iterator.next().getText());
		
		//	for(WebElement ele: iterator.next().findElements(By.xpath(xpathExpression))){
         //       ele.sendKeys("hexbytes");  
		
		        }
		}
		
				
		
	}
	
	


