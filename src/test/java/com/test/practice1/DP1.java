package com.test.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DP1 {
	
	@Test (dataProvider="loginData")
	public void GetLoginDetails(String userName, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(2000);
		driver.quit();	
	}
	@DataProvider(parallel=true)
	public Object[][] loginData(){
		Object[][] data = new Object[4][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "Admin";
		data[1][1] = "adm123";	
		
		data[2][0] = "admin";
		data[2][1] = "Admin123";
		
		data[3][0] = "admin";
		data[3][1] = "Admin124";
		
		return data;
		
	}
}
