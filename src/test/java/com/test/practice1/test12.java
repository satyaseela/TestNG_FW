package com.test.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test12 {
WebDriver driver;
	
	@BeforeTest
	public void LaunchApp() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	}
	@Test
	public void LaunchBrowser() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		
	}
	@Test
	public void LoginDetails() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	}
	
	@Test
	public void NavigateToMyInfopage( ) {
		driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
	}
	
	@Test
	public void NavigateToPersonlInformation() {
	System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Personal Details']")).isDisplayed());	
		
		
	}
	
	
	@Test
	public void Verifylogin() {
		WebElement element = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		System.out.println(element.getText());
		System.out.println(element.isDisplayed());
		
	}
	@Test
	public void NavigateToRecruitmentPage() {
		driver.findElement(By.xpath("//span[normalize-space()='Recruitment']")).click();
	}
	//public void NavigateToContactDetails() {
		//driver.findElement(By.linkText("Contact Details")).click();
		//driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
		//WebElement element = driver.findElement(By.xpath("//textarea[@placeholder='Type comment here']"));
		//System.out.println(element.getText());
		
	
	@AfterTest
	public void tear_down() {
		driver.quit();
		
	}
		
}


