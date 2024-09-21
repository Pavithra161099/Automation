package basictest;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseClass {

	@Test
	public void scroll() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// where to scroll is known prior
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		
		Thread.sleep(2000);

	}
}
