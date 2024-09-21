package basictest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AlertDialogsAssignment extends BaseClass {

	@Test
	public void alertDialogs() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

		// ok cancel dialog with a message
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
		System.out.println(driver.findElement(By.id("android:id/alertTitle")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
		driver.findElement(By.id("android:id/button2")).click();

		// ok cancel dialog with a long text
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Header title");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Header title");
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Header title");
		driver.findElement(By.id("android:id/button3")).click();

		// ok cancel dialog with ultra long message
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Header title");
		scroll();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		driver.findElement(By.id("android:id/button3")).click();

		// list dialog
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();

		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Header title");
		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Command one\"]"))
				.click();
		Assert.assertEquals(driver.findElement(By.id("android:id/message")).getText(), "You selected: 0 , Command one");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// progress dialog
		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		Thread.sleep(2000);

		// single choice list
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Single choice list");
		driver.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Satellite\"]"))
				.click();
		driver.findElement(By.id("android:id/button1")).click();

		// repeat alarm
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Repeat alarm");
		driver.findElement(By.xpath(
				"//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Every Saturday\"]"))
				.click();
		driver.findElement(By.xpath(
				"//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Every Sunday\"]"))
				.click();
		driver.findElement(By.id("android:id/button1")).click();

		// text entry dialog
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "Text Entry dialog");
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Pavithra");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Pass123");
		driver.findElement(By.id("android:id/button1")).click();

		// ok cancel dialog with traditional theme
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
		driver.findElement(By.id("android:id/button1")).click();

		// ok cancel dialog with holo light theme
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
		driver.findElement(By.id("android:id/button1")).click();

	}

}
