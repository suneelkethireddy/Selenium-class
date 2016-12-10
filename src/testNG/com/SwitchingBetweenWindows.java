package testNG.com;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SwitchingBetweenWindows {

	WebDriver driver=null;
	@BeforeSuite
	public void startWebDriver(){

		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
	}

	@Test
	public void switchBetweenWindow(){

		driver.manage().deleteAllCookies();
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@id='terms-link']")).click();                                      //Clicking on "terms" for opening a new window 
		driver.switchTo().window(winHandleBefore);                                                                    //Switching back to the parent window
		 
		driver.findElement(By.xpath("//a[@id='privacy-link']")).click();                               //Clicking on " Data policy"  from Parent window
		driver.switchTo().window(winHandleBefore);                                                                //Switching back to the parent window
		
		driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();                   //Clicking on "Cookie use" from parent window
		driver.switchTo().window(winHandleBefore);                                                            //Switching back to the parent window
		
	}
}


//driver.findElement(By.xpath("//[@id='content']/div/div/ol/li[17]/ol/li[9]/a")).click();

/*	@AfterSuite
public void closeBrowser(){
	driver.close();
}*/

/* for(String winHandle : driver.getWindowHandles()){                                       //Switching to newly opened window 
driver.switchTo().window(winHandle);
System.out.println(driver.getWindowHandle());
} */