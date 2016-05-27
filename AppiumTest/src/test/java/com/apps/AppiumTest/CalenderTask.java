package com.apps.AppiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CalenderTask {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	public void f() throws InterruptedException {
		
		AndroidElement imageTaskButton=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.android.calendar:id/floating_action_button']"));
		imageTaskButton.tap(1, 1);
		
		System.out.println(driver.getPageSource());
		Thread.sleep(2000);
		AndroidElement eventNameButton=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.calendar:id/title'][@text='Event name']"));
		eventNameButton.sendKeys("Appium Event");
		AndroidElement locationNameButton=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.calendar:id/location'][@text='Location']"));
		locationNameButton.sendKeys("Bangalore");
		driver.tap(1, 670, 1130, 1);
		AndroidElement startDateElement=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calendar:id/start_date']"));
		startDateElement.click();
		driver.findElement(By.xpath("//android.view.View[@index='14']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

	/*	DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.android.calendar.AllInOneActivity");
		ds.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.android.calendar");
		ds.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				"Calender Task Test");
//		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.113.101:5555");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.1");
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
		ds.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		ds.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN, true);
		ds.setCapability(MobileCapabilityType.PLATFORM, "Android");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), ds);*/

		  DesiredCapabilities ds=new DesiredCapabilities();
		  ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
		  "de.migali.soft.apkinfo.Start");
		  ds.setCapability(MobileCapabilityType.APP_PACKAGE,
		  "de.migali.soft.apkinfo");
//		  ds.setCapability(MobileCapabilityType.DEVICE_NAME,"192.168.113.101:5555");
		  ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");  
		  ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//		  ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
		  ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		  driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4444/wd/hub"),ds);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@AfterTest
	public void afterTest() {

	}

}
