package testNG.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAllTheSites extends StartWebBrowser {

	String expected,actual;

	@Test(groups = "amazon")
	public void verifyBrowserTitleForAmazon(){

		String URL="http://www.amazon.com";
		startWebDriver("chrome", URL);
		String expectedBrowserTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		Assert.assertEquals(driver.getTitle(), expectedBrowserTitle);
	}

	@Test(groups = "macys")
	public void verifyBrowserTitleForMacys(){

		String URL="http://www.macys.com";
		startWebDriver("chrome", URL);
		String expectedBrowserTitle="Macy's - Shop Fashion Clothing & Accessories - Official Site - Macys.com";
		Assert.assertEquals(driver.getTitle(), expectedBrowserTitle);
	}

	@Test(groups="Ebay")
	public void verifyBrowserTitleForEbay(){

		String URL="http://www.ebay.com";
		startWebDriver("chrome", URL);
		String expectedBrowserTitle="Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
		Assert.assertEquals(driver.getTitle(),expectedBrowserTitle);
	}

	@Test(groups="Ebay")
	public void mouseHoveringOnElements(){

		String URL="http://www.ebay.com";
		startWebDriver("chrome", URL);
		String we="//tbody[@role='navigation']/tr/td";
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

	@Test(groups="spicejet")
	public void forSpiceJet(){

		String URL="http://www.spicejet.com";
		startWebDriver("chrome", URL);
		String expectedBrowserTitle="SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(driver.getTitle(),expectedBrowserTitle );
	}

	@Test(groups="Ebay")
	public void toGetIntoRegisterPage(){

		String URL="http://www.ebay.com/";
		startWebDriver("chrome", URL);
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("sbtBtn")).click();
		expected="Please enter your email address.";
		WebElement ele=driver.findElement((By.id("email_w")));
		actual=ele.getText();
		Assert.assertEquals(actual, expected);
	}

	@Test(groups="Ebay")
	public void assertionForRegister1(){

		String URL="http://www.ebay.com/";
		startWebDriver("chrome", URL);
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("sbtBtn")).click();
		expected="Don't forget to reenter your email address!";
		WebElement ele=driver.findElement((By.id("remail_w")));
		actual=ele.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test(groups="Ebay")
	public void assertionForRegister2(){

		String URL="http://www.ebay.com/";
		startWebDriver("chrome", URL);
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("sbtBtn")).click();
		expected="Please enter your password.";
		WebElement  ele=driver.findElement((By.id("PASSWORD_w")));
		actual=ele.getText();
		Assert.assertEquals(actual, expected);
	}

	@Test(groups="Ebay")
	public void assertionForRegister3(){

		String URL="http://www.ebay.com/";
		startWebDriver("chrome", URL);
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("sbtBtn")).click();
		expected="Please enter your first name.";
		WebElement ele=driver.findElement((By.id("firstname_w")));
		actual=ele.getText();
		Assert.assertEquals(actual, expected);
	}

	@Test(groups="Ebay")
	public void assertionForRegister4(){

		String URL="http://www.ebay.com/";
		startWebDriver("chrome", URL);
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		driver.findElement(By.id("sbtBtn")).click();
		expected="Please enter your last name.";
		WebElement ele=driver.findElement((By.id("lastname_w")));
		actual=ele.getText();
		Assert.assertEquals(actual, expected);
	}
}
