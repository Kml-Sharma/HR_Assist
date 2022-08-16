/**
 * 
 */
package HR_Assist.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import HR_Assist.base.BaseClass;
import HR_Assist.dataprovider.dtProvider;
import HR_Assist.pageobjects.HomePage;
import HR_Assist.pageobjects.LoginPage;
import HR_Assist.utility.Log;

/**
 * @author Komal
 *
 */
public class HomePageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = dtProvider.class)
	public void logoTest(String uname, String pswd) throws Throwable {
		loginPage=new LoginPage();
		homePage=loginPage.login(uname,pswd,homePage);
		
		boolean result=homePage.validatelogo();
		Assert.assertTrue(result);
		Log.endTestCase("logoTest");
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = dtProvider.class)
	public void dashTest(String uname, String pswd) throws Throwable {
		loginPage=new LoginPage();
		homePage=loginPage.login(uname,pswd,homePage);
		
		boolean result1=homePage.validatedashboard();
		Assert.assertTrue(result1);
		Log.endTestCase("Dashboard Visible Test");
	}
}
