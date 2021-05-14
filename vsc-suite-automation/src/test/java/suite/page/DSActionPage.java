package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class DSActionPage extends PageBase{

	public DSActionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * for getting the pageUrl
	 * 
	 * @param pageURL
	 * @return pageURL
	 */

	public DSActionPage  getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}
	
	
	@FindBy(css = ".k-sprite.vsphere-icon-host-warning.DcStandaloneHost")
	private WebElement hostIp;
	
	@FindBy(css = ".k-sprite.vsphere-icon-datacenter.Datacenter")
	private WebElement dcToDoubleClick;
	
	@FindBy(css = "#vui-actions-menu>li:nth-child(23)")
	private WebElement hoverToSelectProvisionDS;
	
	@FindBy(css = ".k-group.k-menu-group.k-popup.k-reset.k-state-border-up>li:nth-child(6)")
	private WebElement provisionDS;
	
	@FindBy(css = ".k-icon.k-plus")
	private WebElement dcClickArrow;
	
	@FindBy(css = ".k-in.k-state-selected>span")
	private WebElement hostClick;
	
	@FindBy(css=".modal-nav.clr-wizard-stepnav-wrapper>h3>clr-wizard-title")
	private WebElement dspopupheading;
	
	@FindBy(css = ".sandbox-iframe")
	private WebElement switchiFrame;
	
	
	
	/**
	 * for switching to iframe
	 * 
	 * @return Webelement of iframe class
	 */
	public void getIframe() {
		switchToIframeByClass(switchiFrame);
	}
	
	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public DSActionPage rightClick(){
		rightClick(hostIp);
		scrollTo(hoverToSelectProvisionDS);
		return this;
	}
	
	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public DSActionPage doubleClickOnDC(){
		doubleClick(dcToDoubleClick);
		return this;
	}
	
	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public DSActionPage hoverToProvisionDS(){
		hoverOverElement(hoverToSelectProvisionDS);
		return this;
	}

	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public DSActionPage clickOnProvisionDS(){
		clickingElement(provisionDS);
		return this;
	}
	
	
	
	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public DSActionPage clickOnHost(){
		clickingElement(hostClick);
		return this;
	}
	
	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public DSActionPage clickOnArrow(){
		clickingElement(dcClickArrow);
		return this;
	}
	
	/**
	 * for verifying the navigated tab url
	 *
	 * @return url of current window
	 */
	public String getNavigatedUrl()
	{
	   closePreviousTab();
	 return  getCurrentURL();
	}
	
	
	/**
	 * for verifying the navigated tab url
	 *
	 * @return url of current window
	 */
	public String getProvisionDSTxt()
	{
		return  getText(provisionDS);
	}
	
	/**
	 * for verifying the navigated tab url
	 *
	 * @return url of current window
	 */
	public String getDsPopupHeadingTxt()
	{
		switchToPage();
		getIframe();
		return  getText(dspopupheading);
	}
	

}
