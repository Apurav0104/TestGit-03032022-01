package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Test1 {

	public WebDriver driver;

	String url = "";
	String verificationError = "";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		url = "http://demo.automationtesting.in/Index.html";
	}

	@Test
	public void getHtmlLink() {
		try {
			driver.get(url);
			driver.findElement(By.id("email")).sendKeys("hingeapurav14@gmail.com");
			driver.findElement(By.xpath("//img[@id='enterimg']")).click();

			List<WebElement> allLinks = driver.findElements(By.tagName("a"));

			// driver.findElement(By.tagName("a")).getSize()
			System.out.println("The number of links are - " + allLinks.size());
			// lets print the text of anchor tag a
			for (WebElement element : allLinks) {
				if (!element.getText().equals("")) {
				}

				System.out.println("Print the text - " + element.getText());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			verificationError = ex.getMessage();
		}
	}

	@After
	public void tiredown() {
		driver.quit();
		if (!verificationError.contentEquals("")) {
			Assert.fail();
		}
	}
}