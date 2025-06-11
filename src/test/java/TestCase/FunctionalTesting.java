package TestCase;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.crm.BaseClass.OrangeHRMBase1;

public class FunctionalTesting extends OrangeHRMBase1 {
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
