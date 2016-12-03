package testcase;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class Functionality  {

	static WebDriver driver=null;
	//SendingEmails sendingEmails=new SendingEmails();
	@BeforeSuite
	public static void startWebDriver(){

		File file=new File("F:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver=new ChromeDriver();
	}
	public void passingDataToFields() throws InterruptedException{

		String userId1="suneelkumar.kethireddy@gmail.com";
		String password1="kethireddy";
		String EmailId2="suneel.rockstar@gmail.com";
		String emailSubject="Testing sending emails between two mail Id's";
		
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false#identifier");	
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(userId1);
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys(password1);
		driver.findElement(By.id("signIn")).click();

		Thread.sleep(30000);
		//driver.findElement(By.xpath("//[@id=:hx]/div/div")).click();
		//Finding Compose button
		driver.findElement(By.xpath("//div[@class='z0']/div")).click();
		//driver.findElement(By.xpath("//td//img[2]")).click();
		//driver.findElement(By.className("v0"))
		driver.findElement(By.id(":nu")).sendKeys(EmailId2);
		driver.findElement(By.id(":ne")).sendKeys(emailSubject);
		driver.findElement(By.id(":n4")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
		//Assert.assertEquals(expected, actual);
		System.out.println(driver.findElement(By.xpath("//div[@class='y6']/span[@id=':zj']")));
		/*if(driver.findElement(By.xpath("//td[@id=':kh' and contains(text(),"+emailSubject+")]"))!=null){
			System.out.println("Email was successfully sent");
		}
		else
		{
			System.out.println("Email was unsucessfull");
		}*/

	}


}

