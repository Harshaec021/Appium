package com.apps.AppiumTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumAppMenuSwipeTest {

	AndroidDriver<AndroidElement> driver;

	@Test
	public void f() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//android.widget.TextView[@text='Data usage']")));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Data usage']")).click();
//		TouchAction ta=new TouchAction(driver);
//		ta.longPress(366, 990).
//		driver.swipe(366, 990, 450, 270, 5);
		Thread.sleep(1000);
File file=driver.getScreenshotAs(OutputType.FILE);

FileUtils.moveFileToDirectory(file, new File("G:/Selenium2/Appium/AppiumScrenShots"), true);

	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.android.settings.Settings");
		ds.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.android.settings");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		ds.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5);
		driver = new AndroidDriver<AndroidElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

}