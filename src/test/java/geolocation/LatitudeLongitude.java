package geolocation;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.DriverSession;

public class LatitudeLongitude {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriver driver = DriverSession.initializeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		By sideMenu = AppiumBy.accessibilityId("open menu");
		wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu)).click();
		
		By geoLoc = AppiumBy.accessibilityId("menu item geo location");
		wait.until(ExpectedConditions.visibilityOfElementLocated(geoLoc)).click();
		
		By permission = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(permission)).click();
		
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.accessibilityId("Stop Observing button")).click();
		
		String latitude = driver.findElement(AppiumBy.accessibilityId("latitude data")).getText();
		String longitude = driver.findElement(AppiumBy.accessibilityId("longitude data")).getText();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu)).click();
		
		By login = AppiumBy.accessibilityId("menu item log in");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
		
		By username = AppiumBy.accessibilityId("Username input field");
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(latitude);
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys(longitude);
		driver.findElement(AppiumBy.accessibilityId("Login button")).click();
	}
}
