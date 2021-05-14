package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class LoginPage extends PageBase {


	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting the pageUrl
	 * 
	 * @param pageURL
	 * @return pageURL
	 */

	public LoginPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	
	@FindBy(id = "titleVmware")
	private WebElement loginPageTxt;   
	
	@FindBy(css = "#username")
	private WebElement userNameTxtBox;

	@FindBy(css = "#password")
	private WebElement passwordTxtBox;

	@FindBy(css = "#submit")
	private WebElement loginBtn;

	@FindBy(css = ".main-nav>header>div>a>span:nth-child(2)")
	private WebElement homePageTxt;

	@FindBy(css = "div>vsc-navigation-view-menu>clr-dropdown")
	private WebElement menuBar;

	@FindBy(css = "span[class$='_vschtmlplugin-vendorIcon18']")
	private WebElement vscPlugin;

	@FindBy(xpath = "//*[@id=\"action-homeMenu\"]//*[contains(text(),'ONTAP tools')]")
	private WebElement vscPluginTxt;

	@FindBy(css = "h2#heading.vsc-common-heading")
	private WebElement overviewPageTxt;

	@FindBy(css= ".sandbox-iframe")
	private WebElement  overviewTxtiFrame;
	
	
	/**
	 * for entering username
	 * 
	 * @param username
	 * @return object of current class
	 */

	public String getLoginPageHeading() {
		return getText(loginPageTxt);
	}
	

	/**
	 * for entering username
	 * 
	 * @param username
	 * @return object of current class
	 */

	public LoginPage enterUserName(String username) {
		setText(userNameTxtBox, username);
		return this;
	}

	/**
	 * for entering password
	 * 
	 * @param password
	 * @return object of current class
	 */

	public LoginPage enterPassword(String password) {
		setText(passwordTxtBox, password);
		return this;
	}

	/**
	 * for clicking on login button
	 * 
	 * @return object of current class
	 */
	public LoginPage clickLoginBtn() {
		clickingElement(loginBtn);
		return this;

	}

	/**
	 * for getting home page text
	 * @return WebElement of home page text
	 */
	public String getHomePage() {
		return getText(homePageTxt);
	}

	/**
	 * for getting menu text
	 * 
	 * @return menu text
	 */

	public String getMenuTxt() {
		return getText(menuBar);
	}

	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public LoginPage clickOnMenu() {
		clickingElement(menuBar);
		return this;
	}

	/**
	 * for getting text of the element
	 * 
	 * @return text
	 */
	public String getValidPluginTxt() {
		return getText(vscPluginTxt);
	}
	
	/**
	 * for clicking in VSC plugin
	 * @return class object
	 */

	public LoginPage clickOnPlugin() {
		clickingElement(vscPlugin);
		return this;
	}

	/**
	 * for switching to iframe
	 * @return Webelement of iframe class
	 */

	public void getIframe() 
	{
		 switchToIframeByClass(overviewTxtiFrame); 
	}
	
	/**
	 * for getting string of overview text
	 * @return String of overview Text
	 */
	public String  getOverviewPageTxt() {
		getIframe();
		return getText(overviewPageTxt);
	}
	

}
