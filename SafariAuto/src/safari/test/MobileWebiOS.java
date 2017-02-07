package safari.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;


public class MobileWebiOS {
	

	@SuppressWarnings("rawtypes")
	IOSDriver driver;

	
	@SuppressWarnings({ "static-access", "rawtypes" })
	@BeforeMethod
	 public void setup() throws MalformedURLException, InterruptedException { 
		 
	  String xcodeConfigFile = "/Users/gopikannan/node_modules/webdriveragent/WebDriverAgent/Config.xcconfig";
		 
	  DesiredCapabilities capabilities = new DesiredCapabilities().iphone();
	  capabilities.setCapability("deviceName", "iPhone 5s");
	  capabilities.setCapability("platformName", "iOS");
	  capabilities.setCapability("platformVersion", "10.2");
//	  capabilities.setCapability("udid", "hvbhjvj65455vgvhgvghvhgvhg");
	  capabilities.setCapability("automationName", "XCUITest");
	  capabilities.setCapability("xcodeConfigFile",xcodeConfigFile);
	  capabilities.setCapability("browserName", "safari");
//	  capabilities.setCapability("bundleId", "com.apple.mobilesafari");
	  driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);//instantiate driver
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  Thread.sleep(10000);
//	  driver.get("https://m.hyundai.co.in/mobile/");
	  driver.navigate().to("https://m.hyundai.co.in/mobile/");
	  
	 }

	 @Test
	 public void testHyundai() throws InterruptedException {
		 WebDriverWait waitButton = new WebDriverWait(driver, 60);
		 waitButton.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Special Offers")));
		 driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div[5]/div[1]/div/ul/li[1]/a")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='images/CarModel/b668300c_elite_i20_logo.png']")).click();
		 driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div[4]/div[1]/div[4]/div/div/div[11]/h3/a/span/span[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='images/logo.png']")).click();
		 WebDriverWait waitImage = new WebDriverWait(driver, 30);
	     waitImage.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Special Offers")));
	 }

	 @AfterMethod
	 public void teardown() {
	  driver.quit();
	 }

}
