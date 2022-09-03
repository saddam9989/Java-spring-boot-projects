//package com.inventory;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//public class VendorTest {
//	//initiated webdriver
//			WebDriver driver=null;
//			
//			@Test
//			public void welcome() {
//				System.out.println("Welcome to InventoryMS Vendor Automation Test");
//			}
//			
//			
//			@Test(groups = "InventoryMS")
//			public void launchInventoryMS() {
//				String path="D:\\Mphasis\\Training Recordings\\Phs 5\\chromedriver_win32\\chromedriver.exe";
//				System.setProperty("webdriver.chrome.driver", path);
//				driver= new ChromeDriver();
//				driver.get("http://localhost:4200/");
//			}
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"launchInventoryMS"})
//			public void vendorlogin() {
//				driver.findElement(By.xpath("//*[@id=\"navbarText\"]/span[3]/button")).click();
//			}
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"vendorlogin"})
//			public void vregister() {
//				driver.findElement(By.xpath("/html/body/app-root/app-vendor-login/div/div/div/div/div/div/div/div/form/div[3]/button[2]")).click();
//			}
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"vregister"})
//			public void register() {
//				driver.findElement(By.name("vendorName")).sendKeys("Ravi");
//				driver.findElement(By.name("vendorEmail")).sendKeys("Ravi@gmail.com");
//				driver.findElement(By.name("vendorAddress")).sendKeys("Pune");
//				driver.findElement(By.name("vendorPhoneNO")).sendKeys("1234567890");
//				driver.findElement(By.name("vendorPassword")).sendKeys("123789");
//				driver.findElement(By.xpath("/html/body/app-root/app-vendor-register/div/div/div/div/div/div/div/div/div/form/div[6]/button")).submit();
//				
//			}
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"register"})
//			public void alert1() {
//				try {
//					Thread.sleep(2000);
//				}
//				catch(Exception e){
//					System.out.println(e.getMessage());
//				}
//				driver.switchTo().alert().accept();
//			}
//			
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"alert1"})
//			public void login() {
//				driver.findElement(By.id("login")).sendKeys("Ravi@gmail.com");
//				driver.findElement(By.id("password")).sendKeys("123789");
//				driver.findElement(By.xpath("/html/body/app-root/app-vendor-login/div/div/div/div/div/div/div/div/form/div[3]/button[1]")).submit();
//				
//			}
//			
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"login"})
//			public void alert() {
//				try {
//					Thread.sleep(2000);
//				}
//				catch(Exception e){
//					System.out.println(e.getMessage());
//				}
//				driver.switchTo().alert().accept();
//			}
//			
//			@Test(groups = "InventoryMS", dependsOnMethods = {"alert"})
//			public void clickviewsales() {
//				driver.findElement(By.id("vsales")).click();
//			}
//			
////			@Test(groups = "InventoryMS", dependsOnMethods = {"clickviewitem"})
////			public void clickviepurchase() {
////				driver.findElement(By.id("viewpurchase")).click();
////			}
//		//	
//				
//		}
