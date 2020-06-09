package com.infi.orange.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void Verifylogin()
	{
		driver.findElement(By.xpath("//div[@class = 'btn-group dropup']")).click();
		String str = driver.findElement(By.xpath("//*[@id=\"loginAsButtonGroup\"]/ul")).getText();
		System.out.println(str);
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//span[text()='Employee List']")).click();
		driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).sendKeys("0044");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String t = driver.findElement(By.xpath("//*[@id=\"employeeListTable\"]/tbody/tr")).getText();
		System.out.println(t);
	}
	

	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
