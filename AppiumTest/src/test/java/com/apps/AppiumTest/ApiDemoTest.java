package com.apps.AppiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ApiDemoTest {
	
	AppiumDriverLocalService service;
	AppiumServiceBuilder builder;
	AppiumDriver<AndroidElement> driver;
	
	@Test
	public void f() {
		
		driver.scrollTo("Views").click();
		driver.scrollTo("Seek Bar").click();
		
		AndroidElement seekbar=driver.findElementById("com.example.android.apis:id/seek");
		Point loc_seek=seekbar.getLocation();
		int intx=loc_seek.getX();
		int inty=loc_seek.getY();
		int width=seekbar.getSize().getWidth();
		
		System.out.println(intx+" "+inty+" "+width);
		
		TouchAction ta=new TouchAction(driver);
		ta.press(intx, inty).moveTo((int)(width*0.8), inty).perform();
		
		
		driver.swipe(367, 14, 360, 1120, 2000);
		driver.swipe(367, 14, 360, 1120, 2000);
		AndroidElement not_seek_bar=driver.findElementById("com.android.systemui:id/slider");
		Point loc_not_seek_bar=seekbar.getLocation();
		int intx1=loc_not_seek_bar.getX();
		int inty1=loc_not_seek_bar.getY();
		int width1=not_seek_bar.getSize().getWidth();
		TouchAction ta1=new TouchAction(driver);
		ta1.press(intx1, inty1).moveTo((int)(width1*0.8), inty1).perform();
		
		
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		builder = new AppiumServiceBuilder();

		builder.usingPort(4728)
				.usingDriverExecutable(
						new File("C:\\Program Files (x86)\\Appium\\node.exe"))
				.withAppiumJS(
						new File(
								"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
				.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER,"1234");
				
		service = AppiumDriverLocalService.buildService(builder);
		service.start();

		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
				"com.example.android.apis.ApiDemos");
		// ds.setCapabilitsdfy(MobileCapabilityType.APP,
		// "C:\\Users\\Harsha\\Downloads\\MultiTouch Tester.apk");
		ds.setCapability(MobileCapabilityType.APP_PACKAGE,
				"com.example.android.apis");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.113.101:5555");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.0");
		ds.setCapability(MobileCapabilityType.UDID, "192.168.113.101:5555");
		ds.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
//		ds.setCapability(AndroidMobileCapabilityType., 30);
		ds.setCapability("autoDismissAlerts", false);
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4728/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		service.stop();
	}

}
