package com.apps.AppiumTest;

import java.awt.Desktop.Action;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AppiumMessengerTest{

	AndroidDriver driver;
	
	@Test
	public void messageAppTest() {
		String expectedph = "fsvdfvd";
		driver.findElement(By.id("com.android.mms:id/floating_action_button"))
				.click();
		driver.findElement(By.id("com.android.mms:id/recipients_editor"))
				.sendKeys(expectedph);
		driver.findElement(By.id("com.android.mms:id/embedded_text_editor"))
				.sendKeys("Hello new contact");
		driver.findElement(By.id("com.android.mms:id/send_button_sms")).click();
		// driver.findElement(By.id("android:id/up")).click();
		String Error = driver.findElement(By.id("android:id/alertTitle"))
				.getText();
		Assert.assertEquals(Error, "Can't send message");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		// Caluculator
		/*
		 * DesiredCapabilities ds=new DesiredCapabilities();
		 * ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
		 * "com.android.contacts.activities.PeopleActivity");
		 * ds.setCapability(MobileCapabilityType.APP_PACKAGE,
		 * "com.android.contacts");
		 * ds.setCapability(MobileCapabilityType.DEVICE_NAME,
		 * "192.168.113.101:5555");
		 * ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 * ds.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
		 * ds.setCapability("newCOmmandTimeout", 2000);
		 * driver=new AndroidDriver<WebElement>(new
		 * URL("http://127.0.0.1:4723/wd/hub"),ds);
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */

		
		  DesiredCapabilities ds=new DesiredCapabilities();
		  ds.setCapability(MobileCapabilityType.APP_ACTIVITY,
		  "com.android.mms.ui.ConversationList");
		  ds.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.mms");
		  ds.setCapability(MobileCapabilityType.DEVICE_NAME, "YT910LQ91K");
		  ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  ds.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
		  ds.setCapability("newCOmmandTimeout", 1000);
		  driver=new AndroidDriver<AndroidElement>(new
		  URL("http://127.0.0.1:4723/wd/hub"),ds);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	

	}

	@AfterTest
	public void afterTest() {
		
		
		driver.close();
	}

}
