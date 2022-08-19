package com.test.practice1;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaOrangeHRM
{
	WebDriver driver;
		@Parameters("browserName")
		@BeforeTest
		public void LaunchApp(String browserName) {
			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
			    driver = new FirefoxDriver();
				break;

			default:
				System.err.println("Browsername is invalid ");
				break;
			}
			 driver.manage().window().maximize();
		}
		
		@Parameters("url")
		@Test
		public void LaunchApplication(String url) throws Exception {
			driver.get(url);
			Thread.sleep(3000);
		}
		@Parameters({"username","password"})
		@Test	
		public void LoginDetails(String username, String password) {
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			
		}
		@Test
		public void NavigateToMyInfopage( ) {
			driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
		
		}
		@Test 
		public void VerifyMyInfoPage() {
		boolean actualValue= driver.findElement(By.xpath("//a[normalize-space()='Personal Details']")).isDisplayed();
		assertTrue(actualValue);
		}
		
		@Test
		public void VerifyLogin() {
			WebElement element = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
			System.out.println(element.getText());
			System.out.println(element.isDisplayed());
			
		}
		@Test
		public void NavigateToRecruitmentpage() {
			driver.findElement(By.xpath("//span[normalize-space()='Recruitment']")).click();
			
		}
		
		@AfterTest
		public void tear_down() {
			driver.quit();
			
		}

	
	}


