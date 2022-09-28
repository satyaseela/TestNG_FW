package com.test.practice1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	String nodeURL;
	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
		nodeURL = "http://192.168.1.195:4444/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
    	options.setAcceptInsecureCerts(true);
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL(nodeURL), options);
	}
	
	@Test
	public void LaunchBrowser() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public void GetLoginDetails() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
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
		//driver.quit();
		
	}
}



