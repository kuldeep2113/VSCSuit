package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class AboutPage extends PageBase {

	public AboutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting page url of VSC
	 * 
	 * @param pageURL
	 * @return page url of the VSC page
	 */

	public AboutPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}


	@FindBy(css = "h2#heading.vsc-common-heading") 
	private WebElement overviewPageTxt;

	@FindBy(css = ".sandbox-iframe")
	private WebElement switchiFrame;

	@FindBy(xpath = "//*[contains(@type,'button') and contains(@class,'dropdown-toggle')]")
	private WebElement helpDropDown;

	@FindBy(id = "clr-id-2")
	private WebElement aboutLink;

	@FindBy(css = ".modal-title")
	private WebElement abtPageTitle;

	@FindBy(css = ".clr-row.clr-col-10.product-version.ng-star-inserted")
	private WebElement versionText;

	@FindBy(css = ".clr-row.clr-col-10.p3.product-copyright")
	private WebElement copyRigthTxt;

	@FindBy(css = ".btn.btn-primary.btn-footer")
	private WebElement okBtnTxt;
	
	@FindBy(css = ".clr-row.clr-col-10:nth-child(1)>img.fujitsuImage")
	private WebElement fujitsuIcon;
	
	@FindBy(css = ".clr-row.clr-col-10:nth-child(1)>img.netappImage")
	private WebElement netappIcon;
	
	@FindBy(css=".clr-row.clr-col-10:nth-child(1)>img.lenovoImage")
	private WebElement lenovoIcon;
	
	




	/**
	 * for switching to iframe
	 * 
	 * @return Webelement of iframe class
	 */
	public void getIframe() {
		switchToIframeByClass(switchiFrame);
	}

	/**
	 * for clicking on help icon
	 * 
	 * @return object of the current class
	 */
	public AboutPage clickOnHelpDropDown() {
		switchToIframeByIndex(0);
		clickingElement(helpDropDown);
		return this;
	}

	/**
	 * for getting the about text from drop down
	 * 
	 * @return about text
	 */
	public String getAboutTxt() {
		return getText(aboutLink);
	}

	/**
	 * for clicking on About
	 * 
	 * @return current class object
	 */
	public AboutPage clickOnAbt() {
		clickingElement(aboutLink);
		switchToPage();
		return this;
	}

	/**
	 * for getting about pop up title
	 * 
	 * @return title of about pop up
	 */
	public String getAbtPageTitle() {
		switchToIframeByIndex(1);
		return getText(abtPageTitle);
	}

	/**
	 * for getting version text return version text
	 */
	public String getVersion() {
		switchToIframeByIndex(1);
		return getText(versionText);
	}

	/**
	 * for getting copy right info text return copy right text
	 */
	public String getCopyRightInfo() {
		switchToIframeByIndex(1);
		return getText(copyRigthTxt);
	}

	/**
	 * for getting Ok button text return OK button text
	 */
	public String getOkBtn() {
		switchToIframeByIndex(1);
		return getText(okBtnTxt);
	}

	/**
	 * for getting Ok button text return OK button text
	 */
	public AboutPage clickOnOkBtn() {
		switchToIframeByIndex(1);
		clickingElement(okBtnTxt);
		return this;
	}

	/**
	 * for getting string of overview text
	 * 
	 * @return String of overview Text
	 */
	public String getOverviewPageTxt() {
		getIframe();
		return getText(overviewPageTxt);
	}
	

	/**
	 * for getting text of the element
	 * 
	 * @return text
	 */
	public boolean getFujitsuIcon() {
		switchToIframeByIndex(1);
		return isWebElementDisplayed(fujitsuIcon);
	}
	
	
	/**
	 * for getting text of the element
	 * 
	 * @return text
	 */
	public boolean getLenovoIcon() {
		switchToIframeByIndex(1);
		return isWebElementDisplayed(lenovoIcon);
	}

	
	/**
	 * for getting text of the element
	 * 
	 * @return text
	 */
	public boolean getNetappIcon() {
		switchToIframeByIndex(1);
		return isWebElementDisplayed(netappIcon);
	}
}
