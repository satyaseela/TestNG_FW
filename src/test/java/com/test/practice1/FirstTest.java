package com.test.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void LaunchApp(@Optional("firefox") String browserName) {
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
	@Test
	public void TestGoogle() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id='W0wltc']/div")).click();
		driver.findElement(By.name("q")).sendKeys("w3school",Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
//		driver.quit();
		
	}
	@Test
	public void TestFacebook() {
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.xpath("//*[@id='u_0_e_/H']")).click();
		driver.findElement(By .xpath("//button[@title ='Allow essential and optional cookies' ]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("9133508290", Keys.ENTER);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	
	

	}


