package com.apps.AppiumTest;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.internal.MultiAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class MultiTouchSwipe {
	AndroidDriver driver;
	AppiumServiceBuilder builder;
	AppiumDriverLocalService service;

	@Stories(value = { "ST-101" })
	@Features(value = { "Multi Touch Framework" })
	@Attachment
	@Test
	public byte[] messageAppTest() {

		// driver.swipe(364, 199, 666, 966, 10000);

		TouchAction ta1 = new TouchAction(driver);
		TouchAction ta2 = new TouchAction(driver);
		TouchAction ta3 = new TouchAction(driver);
		MultiTouchSwipe mts = new MultiTouchSwipe();
		ta1.longPress(360, 720).moveTo(-240, 0).waitAction(10000);
		ta2.longPress(500, 720).moveTo(150, 0).waitAction(10000);
		ta3.longPress(500, 720).moveTo(150, -300).waitAction(10000);
		MultiTouchAction mta = new MultiTouchAction(driver);
		byte[] file = driver.getScreenshotAs(OutputType.BYTES);

		mta.add(ta1).add(ta2).add(ta3).perform();
		// TouchActions ta=new TouchActions(driver);
		// ta.press(360, 720).moveTo(360, 100).perform();
		return file;

	}

	@Parameters({ "UdidOrDeviceName", "MobileVersion", "BrowserName" })
	@BeforeTest
	public void beforeTest(String UdidOrDeviceName, String MobileVersion,
			String BrowserName) throws MalformedURLException {

		builder = new AppiumServiceBuilder();

		builder.usingPort(4728)
				.usingDriverExecutable(
						new File("C:\\Program Files (x86)\\Appium\\node.exe"))
				.withAppiumJS(
						new File(
								"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"));

		service = AppiumDriverLocalService.buildService(builder);
		service.start();

		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.the511plus.MultiTouchTester.MultiTouchTester");
		// ds.setCapability(MobileCapabilityType.APP,
		// "C:\\Users\\Harsha\\Downloads\\MultiTouch Tester.apk");
		ds.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.the511plus.MultiTouchTester");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, UdidOrDeviceName);
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileVersion);
		// ds.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserName);
		ds.setCapability(MobileCapabilityType.UDID, UdidOrDeviceName);
		ds.setCapability("newCommandTimeout", 20);
		driver = new AndroidDriver<AndroidElement>(new URL(
				"http://localhost:4728/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {

		service.stop();

	}

}