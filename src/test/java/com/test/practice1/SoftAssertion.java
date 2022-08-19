package com.test.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertion {
	@Test
	public void TestFacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By .xpath("//button[@title ='Allow essential and optional cookies' ]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("samjafhvYIWRil", Keys.ENTER);
		Thread.sleep(3000);
		
		SoftAssert softassert = new SoftAssert();
		
		//title assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log into Facebook";
		softassert.assertEquals(actualTitle, expectedTitle, "title is mismatched" );
		
		//url assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		softassert.assertNotEquals(actualUrl,  expectedUrl, "Url is mismatched" );
		
		//Text assertion
		String actualText = driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("value");
		String expectedText = "";
		softassert.assertEquals(actualText,  expectedText, "Username is mismatche");
	 
		//border assertion
		String actualBorder = driver.findElement(By.xpath("//input[@id='email']")).getCssValue("border");
		String expectedBorder = "1px solid rgb(221, 223, 226)";
		softassert.assertNotEquals(actualBorder,  expectedBorder, "Username Border is mismatche");
		
//		Error mssage
		String actualErrorMessage = driver.findElement(By.className("_9ay7")).getText();
		String expectedErrorMessage = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
		softassert.assertEquals(actualErrorMessage,  expectedErrorMessage, "ErrorMessage is mismatche");
		

		driver.quit();
		softassert.assertAll();
		
	}

}
