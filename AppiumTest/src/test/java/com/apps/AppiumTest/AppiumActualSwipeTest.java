package com.apps.AppiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AppiumActualSwipeTest {

	AndroidDriver<AndroidElement> driver;

	@Test
	public void f() {

		AndroidElement Download = driver
				.findElement(By
						.xpath("//android.widget.TextView[@resource-id='com.mxtech.videoplayer.ad:id/count']"));
		Download.click();

		driver.scrollTo("SpringBeansDemo").click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Start over']")).tap(1, 1);;


	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		DesiredCapabilities ds = new DesiredCapabilities();
		// ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
		// "com.android.dialer.DialtactsActivity");
		// ds.setCapability(MobileCapabilityType.APP_PACKAGE,
		// "com.android.dialer");
		ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.mxtech.videoplayer.ad.ActivityMediaList");
		ds.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.mxtech.videoplayer.ad");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		ds.setCapability("newCommandTimeout", 1000);
		driver = new AndroidDriver<AndroidElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
