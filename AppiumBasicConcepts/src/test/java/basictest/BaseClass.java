package basictest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr/local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		UiAutomator2Options option = new UiAutomator2Options();
		option.setApp(
				"//Users//vijaya.bonthu//eclipse-workspace//test1//src//test//java//resources//ApiDemos-debug.apk");
		option.setDeviceName("emulator1");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void longClick(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));

	}

	public void scroll() throws InterruptedException {
		// if no prior idea
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));
		} while (canScrollMore);
	}

	public void swipe(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));

	}

	public void dragAndDrop(WebElement ele, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "endX", x, "endY", y));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
