package testNG.com;

import java.awt.Robot;
import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Configuration;
import org.testng.annotations.Parameters;



public class BaseClass {

	static WebDriver driver=null;
	static Alert alert=null;
	static String URL;
	static Robot robo=null;
	static String browser=null;
	static Actions action;


	@BeforeSuite
   @Configuration
	@Parameters({"browser","URL"})
	public static  void startWebDriver(String browser,String URL){
		
		if(browser.equalsIgnoreCase("chrome")){
			File file=new File("F:/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			File file=new File("F:/IEDriverServer_Win32_2.39.0/IEDriverServer.exe");
			System.getProperty("webdriver.ie.driver",file.getAbsolutePath());
			driver=new InternetExplorerDriver();
		}
		driver.get(URL);
	}

	@AfterSuite
	public void CLoseBroswer(){

		driver.quit();

	}
}
