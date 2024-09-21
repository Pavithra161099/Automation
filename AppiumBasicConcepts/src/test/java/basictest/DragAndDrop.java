package basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends BaseClass {

	@Test
	public void dragAndDrop() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		dragAndDrop(source,648, 591);
		
		String res = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(res, "Dropped!");

	}

}
