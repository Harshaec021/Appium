package com.apps.AppiumTest;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumGalleryPinchOutTest {

	AndroidDriver<AndroidElement> driver;
	boolean ElementFound = false;

	@Test
	public void f() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.tap(1, 530, 700, 1);
		Thread.sleep(1000);
		System.out.println(driver.getPageSource());
		driver.tap(1, 119, 335, 2);
		Thread.sleep(1000);
		
//		MultiTouchAction mta=new MultiTouchAction(driver);
	
		TouchAction ta1=new TouchAction(driver);
		ta1.longPress(300, 240,8);
		TouchAction ta2=new TouchAction(driver);
		ta2.longPress(300, 400,8).moveTo(300, 1000);
		MultiTouchAction mta=new MultiTouchAction(driver);
		mta.add(ta1).add(ta2).perform();
		
		driver.zoom(300, 400);

	}

	@BeforeTest
	public void afterTest() throws MalformedURLException {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.android.gallery3d.app.GalleryActivity");
		ds.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.android.gallery3d");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		ds.setCapability("newCommandTimeout", 1000);
		driver = new AndroidDriver<AndroidElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	
}
