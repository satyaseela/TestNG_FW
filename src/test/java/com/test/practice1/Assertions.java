package com.test.practice1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	@Test
	public void TestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id='W0wltc']/div")).click();
		driver.findElement(By.name("q")).sendKeys("W3Schools - Wikipedia",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"Rzn5id\"]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
		String expectedTitle = "W3Schools - Wikipedia";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,expectedTitle, "Title missmatch" );
		Thread.sleep(2000);
		driver.quit();
}
}
