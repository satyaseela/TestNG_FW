package com.test.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@BeforeTest
	public void LaunchApp() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	}
	
	@Test
	public void LaunchBrowser() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void GetLoginDetails() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		//driver.findElement(By.id("btnLogin")).click();	
	}
	@Test
	public void NavigateToMyInfopage( ) {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
			
	}
	@Test 
	public void VerifyMyInfoPage() {
		System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
	
	}
	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		System.out.println(element.getText());
		System.out.println(element.isDisplayed());
	}
	@Test
	public void NavigateToRecruitmentpage() {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
	
	}
	@Test
	public void VerifyRecruitmentPage() {
		
		driver.findElement(By.cssSelector("select[id='candidateSearch_jobTitle'] option[value='12']")).click();
		driver.findElement(By.cssSelector("#candidateSearch_jobVacancy")).click();
	}
	@AfterTest
	public void tear_down() {
		driver.quit();
		
	}
}



