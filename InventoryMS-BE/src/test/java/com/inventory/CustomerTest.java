//package com.inventory;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//public class CustomerTest {
//	//initiated webdriver
//		WebDriver driver=null;
//		
//		@Test
//		public void welcome() {
//			System.out.println("Welcome to InventoryMS Customer Automation Test");
//		}
//		
//		
//		@Test(groups = "InventoryMS")
//		public void launchInventoryMS() {
//			String path="D:\\Mphasis\\Training Recordings\\Phs 5\\chromedriver_win32\\chromedriver.exe";
//			System.setProperty("webdriver.chrome.driver", path);
//			driver= new ChromeDriver();
//			driver.get("http://localhost:4200/");
//		}
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"launchInventoryMS"})
//		public void customerlogin() {
//			driver.findElement(By.xpath("//*[@id=\"navbarText\"]/span[2]/button")).click();
//		}
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"customerlogin"})
//		public void cregister() {
//			driver.findElement(By.xpath("/html/body/app-root/app-customer-login/div/div/div/div/div/div/div/div/form/div[3]/button[2]")).click();
//		}
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"cregister"})
//		public void register() {
//			driver.findElement(By.name("customerName")).sendKeys("Sanu");
//			driver.findElement(By.name("customerEmail")).sendKeys("Sanu@gmail.com");
//			driver.findElement(By.name("customerAddress")).sendKeys("Siliguri");
//			driver.findElement(By.name("customerPhoneNO")).sendKeys("1234567890");
//			driver.findElement(By.name("customerPassword")).sendKeys("123456");
//			driver.findElement(By.xpath("/html/body/app-root/app-customer-register/div/div/div/div/div/div/div/div/div/form/div[6]/button")).submit();
//			
//		}
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"register"})
//		public void alert1() {
//			try {
//				Thread.sleep(2000);
//			}
//			catch(Exception e){
//				System.out.println(e.getMessage());
//			}
//			driver.switchTo().alert().accept();
//		}
//		
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"alert1"})
//		public void login() {
//			driver.findElement(By.id("login")).sendKeys("Sanu@gmail.com");
//			driver.findElement(By.id("password")).sendKeys("123456");
//			driver.findElement(By.xpath("/html/body/app-root/app-customer-login/div/div/div/div/div/div/div/div/form/div[3]/button[1]")).submit();
//			
//		}
//		
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"login"})
//		public void alert() {
//			try {
//				Thread.sleep(2000);
//			}
//			catch(Exception e){
//				System.out.println(e.getMessage());
//			}
//			driver.switchTo().alert().accept();
//		}
//		
//		@Test(groups = "InventoryMS", dependsOnMethods = {"alert"})
//		public void clickviewitem() {
//			driver.findElement(By.id("vitem")).click();
//		}
//		
////		@Test(groups = "InventoryMS", dependsOnMethods = {"clickviewitem"})
////		public void clickviepurchase() {
////			driver.findElement(By.id("viewpurchase")).click();
////		}
//	//	
//			
//	}
