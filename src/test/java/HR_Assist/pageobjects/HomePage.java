package HR_Assist.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import HR_Assist.actiondriver.Action;
import HR_Assist.base.BaseClass;
import HR_Assist.utility.Log;

public class HomePage extends BaseClass{
	Action action= new Action();
	@FindBy(xpath="//img[@class='logo-lg']")
	WebElement logo;
	@FindBy(xpath="//li[2]/a/span[text()='Dashboard']")
	WebElement Dashboard;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean validatelogo() throws Throwable {
		action.findElement(getDriver(), logo);
		return action.isDisplayed(getDriver(), logo);
	}
	public boolean validatedashboard() throws Throwable {
		action.findElement(getDriver(), Dashboard);
		return action.isDisplayed(getDriver(), Dashboard);
	}
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
}
																																																																																																																																																																																			