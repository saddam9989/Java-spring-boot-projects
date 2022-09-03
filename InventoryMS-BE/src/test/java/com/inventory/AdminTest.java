//package com.inventory;
//
//import static org.testng.Assert.assertEquals;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class AdminTest {
//	
//	//initiated webdriver
//	WebDriver driver=null;
//	
//	@Test
//	public void welcome() {
//		System.out.println("Welcome to InventoryMS Admin Automation Test");
//	}
//	
//	
//	@Test(groups = "InventoryMS")
//	public void launchInventoryMS() {
//		String path="D:\\Mphasis\\Training Recordings\\Phs 5\\chromedriver_win32\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", path);
//		driver= new ChromeDriver();
//		driver.get("http://localhost:4200/");
//	}
//	
//	@Test(groups = "InventoryMS", dependsOnMethods = {"launchInventoryMS"})
//	public void adminlogin() {
//		driver.findElement(By.xpath("//*[@id=\"navbarText\"]/span[1]/button")).click();
//	}
//	
//	@Test(groups = "InventoryMS", dependsOnMethods = {"adminlogin"})
//	public void login() {
//		driver.findElement(By.id("ausername")).sendKeys("Admin");
//		driver.findElement(By.id("apassword")).sendKeys("123456");
//		driver.findElement(By.xpath("/html/body/app-root/app-admin-login/div/div/div/div/div/div/div/div/form/div[3]/button[1]")).submit();
//		
//	}
//	
//	
//	@Test(groups = "InventoryMS", dependsOnMethods = {"login"})
//	public void alert() {
//		try {
//			Thread.sleep(2000);
//		}
//		catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//		driver.switchTo().alert().accept();
//	}
//	
//	@Test(groups = "InventoryMS", dependsOnMethods = {"alert"})
//	public void clickviewitem() {
//		driver.findElement(By.id("viewitem")).click();
//	}
//	
////	@Test(groups = "InventoryMS", dependsOnMethods = {"clickviewitem"})
////	public void clickviepurchase() {
////		driver.findElement(By.id("viewpurchase")).click();
////	}
////	
//		
//}
