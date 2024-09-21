package basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseClass {

	@Test
	public void miscellaneous() {
		// App activity and app package
		//adb shell dumpsys window| grep -E 'mCurrentFocus' -> for Mac
		//adb shell dumpsys window| find 'mCurrentFocus' -> for windows

		Activity activity = new Activity("io.appium.android.apis",
				"io.appium.android.apis.preference.PreferenceDependencies");
//		driver.startActivity(activity);    --> startActivity() method is deprecated so use below one
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		// rotate screen to landscape mode
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		// copy to clip board and paste it from clip board
		driver.setClipboardText("Pavithra WiFi");
		driver.findElement(By.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		// enter, back and home button click action
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
