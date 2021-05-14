package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;



/**
 * @author kuldeepl
 *
 *Page object class for Control Panel Page
 *
 */
public class ControlPanelPage extends PageBase {


	public ControlPanelPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}


	/**
	 * for getting page url of Control Panel Page
	 * 
	 * @param pageURL
	 * @return page url of the Control Panel  page
	 */

	public ControlPanelPage  getCotrolPanelPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	@FindBy(css="html>body>form>ul>li>label.labelHead")
	private WebElement loginPgeTxt;

	@FindBy(name="j_username")
	private WebElement userNameTxtBox;

	@FindBy(name="j_password")
	private WebElement passwordTxtBox;

	@FindBy(xpath="//*[@type='submit']")
	private WebElement LoginBtn;

	@FindBy(css="html>body>b>h2")
	private WebElement controlPanelHeadingTxt;



	/**
	 * for getting the welcome message of Login page
	 * @return welcome text
	 */

	public String getLoginPgeTxt()
	{
		return getText(loginPgeTxt);
	}


	/**
	 * for getting the Username
	 * @param username
	 * @return current class object
	 */

	public ControlPanelPage enterUserName(String username) 
	{
		setText(userNameTxtBox, username);
		return this;
	}


	/**
	 * for getting the Password
	 * @param password
	 * @return current class object
	 */

	public ControlPanelPage enterPassword(String password)
	{
		setText(passwordTxtBox, password);
		return this;
	}

	/**
	 * for Clicking on login button
	 * @return current class object
	 */

	public ControlPanelPage clickLoginBtn()
	{
		clickingElement(LoginBtn);
		return this;
	}


	/**
	 * for getting the page title
	 * @return page title
	 */

	public String  getPageTitle()
	{
		return getPagetitle();
	}


	/**
	 * for getting home page heading text
	 * @return text
	 */

	public String getControlPanelHeading()
	{
		return getText(controlPanelHeadingTxt);
	}

}