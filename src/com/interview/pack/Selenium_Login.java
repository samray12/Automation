package com.interview.pack;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_Login 
{
	

	public static String email = "sambitray100@gmail.com";
	public static String pwd = "123456";
	public static String ExpErrormsg = "Email id does not exist!";
	
	
	
	@Test
	public static void LoginNow() throws InterruptedException
	{
	//Initializing the Driver
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//Open browser
	driver.get("https://accounts.datoms.io/login");
	
	//Finding element for login Form
	WebElement emailtextbox = driver.findElement(By.xpath("//*[@id='email']"));
	WebElement passwordtextbox = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement Submitbutton = driver.findElement(By.xpath("//*[@id='form_submit_btn']"));
	
	//Performing action on the webelement
	emailtextbox.sendKeys(email);
	passwordtextbox.sendKeys(pwd);
	Submitbutton.click();
	
	//Extracting the error messgae
	WebElement ErrorMSG = driver.findElement(By.xpath("//*[@id='show_message']"));
	Thread.sleep(3000);
	String error_msg = ErrorMSG.getText();
	System.out.println("The error msg is "+error_msg);
	
	//Validating the error msg with expected error message.
	assertTrue(error_msg.equals(ExpErrormsg), "Actual is not matched with Expected");
	driver.quit();
	
	}
}
