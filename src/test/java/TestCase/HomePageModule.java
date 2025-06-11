package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.OrangeHRMBase1;
import com.crm.pom.HomePage;

public class HomePageModule extends OrangeHRMBase1{
@Test(priority = 1)
public void profileCheck() {
	try {
		driver.findElement(By.xpath("//p[text()='Rehan Awan']"));
		Reporter.log("iam in my correct profile",true);
		
	} catch (Exception e) {
		Reporter.log("iam not present in my correct profile",true);
		fail();
	}
	
}
@Test(priority = 2)
public void adminClick() {
	HomePage home=new HomePage(driver);
	assertTrue(home.admin().isEnabled(),"admin button is disabled");
	home.admin().click();
}
@Test(priority = 3)
public void simple() {
	HomePage home=new HomePage(driver);
	assertTrue(home.admin().isEnabled(),"admin button is disabled");
	home.admin().click();
	Reporter.log("simple");
	assertEquals("java","hava");
}
}
