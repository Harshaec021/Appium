package com.apps.AppiumTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropTest {
	AndroidDriver driver;
	
	
	/*@Test(enabled=false)
	public void messageAppTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Basic usage playground']")).click();

		driver.swipe(85, 250, 85, 518, 10000);
		
	}*/
	
	@Test
	public void LauncherSwipe() throws InterruptedException {
		
		driver.swipe(130,670,570, 670, 10000);

		
		
	}
	
	

	

	
	@BeforeTest
	public void beforeTest() throws MalformedURLException {

	
		  DesiredCapabilities ds=new DesiredCapabilities();
		  ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
		  "com.whatsapp.Main");
		  ds.setCapability(MobileCapabilityType.APP_PACKAGE,"com.whatsapp");
		  ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");
		  ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  ds.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");
		  ds.setCapability("newCommandTimeout", 1000);
		  driver=new AndroidDriver<AndroidElement>(new
		  URL("http://127.0.0.1:4723/wd/hub"),ds);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	

	}

	@AfterTest
	public void afterTest() {
		
		
		driver.quit();
		
	}

}