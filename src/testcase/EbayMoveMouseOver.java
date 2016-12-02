package testcase;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EbayMoveMouseOver {
	
	public static void main(String args[]){
		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.ebay.com/");
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//a[@class='rt' and contains(text(),'Motors')]"));	
		/*action.moveToElement(ele).moveToElement(driver.findElement((By.xpath("//a[@class='rt' and contains(text(),'Motors')]"))));
		action.moveToElement(ele).build().perform();
		Select select=new Select(ele);
		select.selectByVisibleText("//a[@class='rt' and contains(text(),'Motors')]");
		System.out.println();
		String str=ele.getText();
		System.out.println(str);
		
		Select select=new Select(ele);
		
		List<WebElement> textInIt=driver.findElements(By.xpath("//[contains(@class,'rt')]/a"));
		for(WebElement ele1:textInIt){
			System.out.println(ele1.getText());*/
		
		WebElement selectorElement=driver.findElement(By.xpath("//a[@class='rt' and contains(text(),'Motors')]"));
		
		
		}
		
				
		
	}
	
	


