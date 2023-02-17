package utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverSession {

	public static AppiumDriver initializeDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		URL url = new URL("http://0.0.0.0:4723");
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "RR8R105VJLX");

		String appUrl = 
				System.getProperty("user.dir") 
				+ File.separator + "src" 
				+ File.separator + "test" 
				+ File.separator + "resources"
				+ File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
		
		caps.setCapability(MobileCapabilityType.APP, appUrl);
		
		return new AndroidDriver(url, caps);
	}
	
}
