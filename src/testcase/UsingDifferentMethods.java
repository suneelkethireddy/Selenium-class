package testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class UsingDifferentMethods {
	static WebDriver driver=null;
	static String URL=null;
	static Robot robo=null;
	static String browser=null;
	public static void startWebdriver(String browser,String URL){
		if(browser.equalsIgnoreCase("chrome")){
			File file=new File("F:/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firfox")){
			File file=new File("F:/firefoxdriver.exe");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new FirefoxDriver();
		}else 
			System.out.println("No browser found");
		driver.get(URL);
	}
	public static void mouseHover(String we) throws AWTException{
		robo=new Robot();
		robo.mouseMove(0, 0);
		/*if(URL.equalsIgnoreCase("http://www.amazon.com")){
			WebElement sm=driver.findElement(By.xpath("//[@id='nav-link-shopall']/span[2]"));
			Actions actions =new Actions(driver);
			actions.moveToElement(sm).build().perform();
			List<WebElement> list=driver.findElements(By.xpath(we+"/span"));
			int size=list.size();
			System.out.println("Size of elements it contains is:"+size);
			for(int i=1;i<=size;i++){
				WebElement cat=driver.findElement(By.xpath(we+"["+i+"]/span"));
				System.out.println(cat.getText().toString());
				actions.moveToElement(cat).build().perform();
			}
		}
		 */
		List<WebElement> list=driver.findElements(By.xpath(we));
		int size=list.size();
		System.out.println("Size of elements it contains is:"+size);
		for(int i=1;i<=size;i++){
			WebElement cat=driver.findElement(By.xpath(we+"["+i+"]"));
			System.out.println(cat.getText().toString());
			Actions actions =new Actions(driver);
			actions.moveToElement(cat).build().perform();
		}
	}
	public static void main(String[] args) throws AWTException, InterruptedException {

		UsingDifferentMethods.startWebdriver("chrome","http://www.macys.com");
		String genalizedXpath="//div[@ id='globalMastheadCategoryMenu']/ul/li";
		UsingDifferentMethods.mouseHover(genalizedXpath);

		UsingDifferentMethods.startWebdriver("chrome", "http://www.ebay.com");
		genalizedXpath="//tbody[@role='navigation']/tr/td";
		UsingDifferentMethods.mouseHover(genalizedXpath);

		UsingDifferentMethods.startWebdriver("chrome", "http://www.amazon.com");
		genalizedXpath="//[@id='nav-flyout-shopAll']/div[2]/span";
		UsingDifferentMethods.mouseHover(genalizedXpath);
	}
}
