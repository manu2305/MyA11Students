package ListenersMethod;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.OrangeHRMBase1;
@Listeners(com.crm.listeners.ReportwithScreenshot.class)
public class AttachScreenshotInReport extends OrangeHRMBase1 {
	@Test()
	public void pk() throws InterruptedException {
		System.out.println("iam pk");
		fail();
	}
		@Test(dependsOnMethods = "pk")
	public void mi() {
		System.out.println("iam mi");
	}
		@Test()
	public void rcb() {
	System.out.println("iam rcb");
	}
		@Test
		public void dws() {
		System.out.println("dws");
			fail();
		}
}
