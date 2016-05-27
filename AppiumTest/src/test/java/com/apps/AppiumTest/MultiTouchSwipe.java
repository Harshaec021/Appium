package com.apps.AppiumTest;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.internal.MultiAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiTouchSwipe {
	AndroidDriver driver;
	
	
	@Test
	public void messageAppTest() {
		
//		driver.swipe(364, 199, 666, 966, 10000);
		
		TouchAction ta1=new TouchAction(driver);
		TouchAction ta2=new TouchAction(driver);
		MultiTouchSwipe mts=new MultiTouchSwipe();
		ta1.longPress(360, 720).moveTo(-240, 0).waitAction(10000);
		ta2.longPress(500, 720).moveTo(150, 0).waitAction(10000);
	   MultiTouchAction mta=new MultiTouchAction(driver);
	    mta.add(ta1).add(ta2).perform();
//		TouchActions ta=new TouchActions(driver);
//ta.press(360, 720).moveTo(360, 100).perform();

		
	}

	

	@Parameters({"UdidOrDeviceName","MobileVersion","BrowserName"})
	@BeforeTest
	public void beforeTest(String UdidOrDeviceName,String MobileVersion,String BrowserName) throws MalformedURLException {

	
		  DesiredCapabilities ds=new DesiredCapabilities();
		  ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
		  "com.the511plus.MultiTouchTester.MultiTouchTester");
//		  ds.setCapability(MobileCapabilityType.APP, "C:\\Users\\Harsha\\Downloads\\MultiTouch Tester.apk");
		  ds.setCapability(MobileCapabilityType.APP_PACKAGE,"com.the511plus.MultiTouchTester");
		  ds.setCapability(MobileCapabilityType.DEVICE_NAME, UdidOrDeviceName);
		  ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  ds.setCapability(MobileCapabilityType.PLATFORM_VERSION,MobileVersion);
		  ds.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserName);
		  ds.setCapability(MobileCapabilityType.UDID,UdidOrDeviceName);
		  ds.setCapability("newCommandTimeout", 10);
		  driver=new AndroidDriver<AndroidElement>(new
		  URL("http://192.168.0.104:4444/wd/hub"),ds);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	

	}

	@AfterTest
	public void afterTest() {
		
		
//		driver.quit();
		
	}

}