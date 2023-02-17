package barang;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.DriverSession;

public class PembelianBarang {

	public static void main(String[] args) throws MalformedURLException {
		AppiumDriver driver = DriverSession.initializeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		By item = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"store item text\"])[1]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(item)).click();
		
		By add = AppiumBy.accessibilityId("Add To Cart button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(add)).click();
		
		driver.findElement(AppiumBy.accessibilityId("cart badge")).click();
		
		By checkOut = AppiumBy.accessibilityId("Proceed To Checkout button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut)).click();
		
		By username = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"bob@example.com-autofill\"]/android.widget.TextView");
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).click();
		
		driver.findElement(AppiumBy.accessibilityId("Login button")).click();
		
		By fullName = AppiumBy.accessibilityId("Full Name* input field");
		wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys("Rebecca Winter");
		
		driver.findElement(AppiumBy.accessibilityId("Address Line 1* input field")).sendKeys("Mandorley 112");
		driver.findElement(AppiumBy.accessibilityId("Address Line 2 input field")).sendKeys("Entrance 1");
		driver.findElement(AppiumBy.accessibilityId("City* input field")).sendKeys("Truro");
		driver.findElement(AppiumBy.accessibilityId("State/Region input field")).sendKeys("Cornwall");
		driver.findElement(AppiumBy.accessibilityId("Zip Code* input field")).sendKeys("89750");
		driver.findElement(AppiumBy.accessibilityId("Country* input field")).sendKeys("United Kingdom");
		
		driver.findElement(AppiumBy.accessibilityId("To Payment button")).click();
		
		WebElement card = driver.findElement(AppiumBy.accessibilityId("Full Name* input field"));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(card)));
		driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Rebecca Winter");
		
		driver.findElement(AppiumBy.accessibilityId("Card Number* input field")).sendKeys("325812657568789");
		driver.findElement(AppiumBy.accessibilityId("Expiration Date* input field")).sendKeys("0325");
		driver.findElement(AppiumBy.accessibilityId("Security Code* input field")).sendKeys("123");
		
		driver.findElement(AppiumBy.accessibilityId("Review Order button")).click();
		
		By order = AppiumBy.accessibilityId("Place Order button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(order)).click();
		
		By cont = AppiumBy.accessibilityId("Continue Shopping button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cont)).click();
	}
	
}
