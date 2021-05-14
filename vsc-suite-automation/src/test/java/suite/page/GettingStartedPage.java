package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;


public class GettingStartedPage extends PageBase{


	public GettingStartedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting the pageUrl
	 * 
	 * @param pageURL
	 * @return pageURL
	 */

	public GettingStartedPage  getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}



	@FindBy(css = ".nav-item>button#clr-tab-link-0")
	private WebElement gettingStartedTxt;

	@FindBy(css= ".sandbox-iframe")
	private WebElement  iFrame;

	@FindBy(css =".clr-col-md-12.clr-col-sm-12.clr-col-xs-12.gettingstart-title")
	private WebElement  vscDescription;

	@FindBy(css =".font-weight-500:nth-child(3)")
	private WebElement  addStorageSysTxt;

	@FindBy(css=".clr-col-md-6.clr-col-sm-12:nth-child(1)>div:nth-child(5)>div>h6")
	private WebElement addStorageDesTxt;

	@FindBy(css=".clr-col-md-6.clr-col-sm-12:nth-child(1)>div:nth-child(5)>div:nth-child(2)>button.btn.btn-success")
	private WebElement addBtn;

	@FindBy(css="#clr-id-0>h3")
	private WebElement addStoragePopUpHeading;

	@FindBy(css =".clr-col-md-6.clr-col-sm-12:nth-child(2)>h4")
	private WebElement  provisionDSTxt;

	@FindBy(css=".clr-col-md-6.clr-col-sm-12:nth-child(2)>div:nth-child(4)>div>h6")
	private WebElement provisionDSDesTxt;

	@FindBy(css=".clr-col-md-6.clr-col-sm-12:nth-child(2)>div:nth-child(4)>div:nth-child(2)>button.btn.btn-success")
	private WebElement provisionBtn;

	@FindBy(css=".clr-wizard-title>clr-wizard-title")
	private WebElement provisionPopUpHeading;

	@FindBy(css = "h4.top-margin-0.font-weight-600")
	private WebElement nextStepsTxt;

	@FindBy(css = ".sidebar>div:nth-child(1)>h4>a")
	private WebElement viewDashboard;

	@FindBy(css="#clr-tab-link-1:nth-child(1)")
	private WebElement traditionalDashboard;

	@FindBy(css=".sidebar>div:nth-child(1)>h6.top-margin-5")
	private WebElement msgBelowVD;

	@FindBy(css = ".sidebar>div:nth-child(2)>h4>a")
	private WebElement settingsLink;

	@FindBy(css=".sidebar>div:nth-child(2)>h6")
	private WebElement msgBelowSettings;

	@FindBy(css="h2#heading")
	private WebElement settingPageHeading;

	@FindBy(css="#footer>div>div:nth-child(1)>h4>span")
	private WebElement whatsNewTxt;

	@FindBy(css="#footer>div>div:nth-child(1)>span")
	private WebElement dateTxt;

	@FindBy(css="#footer>div>div:nth-child(2)>ul>li:nth-child(1)")
	private WebElement listPoint1;

	@FindBy(css="#footer>div>div:nth-child(2)>ul>li:nth-child(2)")
	private WebElement listPoint2;

	@FindBy(css="#footer>div>div:nth-child(2)>ul>li:nth-child(3)")
	private WebElement listPoint3;

	@FindBy(css="#footer>div>div:nth-child(2)>ul>li:nth-child(4)")
	private WebElement listPoint4;
	
	@FindBy(css="#footer>div>div:nth-child(2)>ul>li:nth-child(5)")
	private WebElement  listPoint5;
	
	@FindBy(css="#footer>div>div:nth-child(2)>ul>li:nth-child(6)")
	private WebElement listPoint6;
	
	@FindBy(css=".clr-form-control>label.clr-control-label")
	private WebElement vcenterserverTxt;




	/**
	 * for switching to iframe
	 * @return Webelement of iframe class
	 */

	public void getIframe() 
	{
		switchToIframeByClass(iFrame); 
	}

	/**
	 * for getting string of getting started text
	 * 
	 * @return String of getting started Text
	 */
	public String getGettingStaredTxt() {
		getIframe();
		return getText(gettingStartedTxt);
	}


	/**
	 * for getting  vsc description 
	 * 
	 * @return vsc description text
	 */
	public String getVscDescriptionTxt() {
		getIframe();
		return getText(vscDescription);
	}

	/**
	 * for getting add storage system text
	 * 
	 * @return add storage system text
	 */
	public String getAddStoragSysTxt() {
		getIframe();
		return getText(addStorageSysTxt);
	}

	/**
	 * for getting msg below add storage system
	 * 
	 * @return text
	 */
	public String getAddStorageDescTxt(){
		getIframe();
		return getText(addStorageDesTxt);
	}

	/**
	 * for getting add button text
	 * 
	 * @return add button text
	 */
	public String getAddBtnTxt(){
		getIframe();
		return getText(addBtn);
	}

	/**
	 * for clicking on add button
	 * 
	 * @return same class object
	 */
	public GettingStartedPage clickAddBtn(){
		getIframe();
		clickingElement(addBtn);
		return this;
	}

	/**
	 * for getting add button text
	 * 
	 * @return add button text
	 */
	public String getStoragePopUpHeading(){
		switchToPage();
		switchToIframeByIndex(1);
		return getText(addStoragePopUpHeading);
	}

	/**
	 * for getting Provision data store text
	 * 
	 * @return text
	 */
	public String getProvisionDSTxt() {
		getIframe();
		return getText(provisionDSTxt);
	}

	/**
	 * for getting add storage system text
	 * 
	 * @return add storage system text
	 */
	public String getProvisionDSDescTxt(){
		getIframe();
		return getText(provisionDSDesTxt);
	}

	/**
	 * for getting provision button text
	 * 
	 * @return provision button text
	 */
	public String getProvisionBtnTxt(){
		getIframe();
		return getText(provisionBtn);
	}

	/**
	 * for clicking on provision button
	 * 
	 * @return object of same class
	 */
	public GettingStartedPage clickProvisionBtn(){
		getIframe();
		clickingElement(provisionBtn);
		return this;
	}

	/**
	 * for getting provision ds pop up heading
	 * 
	 * @return text
	 */
	public String getProvisionPopUpHeading(){
		switchToPage();
		switchToIframeByIndex(1);
		return getText(provisionPopUpHeading);
	}

	/**
	 * for getting next step text
	 * 
	 * @return text
	 */
	public String getNextStepsTxt(){
		getIframe();
		return getText(nextStepsTxt);
	}

	/**
	 * for clicking on view dashboard link
	 * 
	 * @return object of same class
	 */
	public GettingStartedPage clickOnViewDashboard(){
		getIframe();
		clickingElement(viewDashboard);
		return this;
	}

	/**
	 * for getting view dashboard text
	 * 
	 * @return  text
	 */
	public String getViewDashboardTxt(){
		getIframe();
		return getText(viewDashboard);
	}

	/**
	 * for getting tradition DashBoard text
	 * 
	 * @return text
	 */
	public String getTraditionDBTxt(){
		//getIframe();
		return getText(traditionalDashboard);
	}

	/**
	 * for getting msg below view dashboard (VD)
	 * 
	 * @return text
	 */
	public String getMsgBelowVD(){
		getIframe();
		return getText(msgBelowVD);
	}

	/**
	 * for getting settings text
	 * 
	 * @return text
	 */
	public String getSettingsTxt(){
		getIframe();
		return getText(settingsLink);
	}

	/**
	 * for clicking on Settings link
	 * 
	 * @return object of same class
	 */
	public GettingStartedPage clickOnSettings(){
		getIframe();
		clickingElement(settingsLink);
		return this;
	}

	/**
	 * for getting Setting page heading
	 * 
	 * @return text
	 */
	public String getSettingPageHeading(){
		getIframe();
		return getText(settingPageHeading);
	}

	/**
	 * for getting msg below setting
	 * 
	 * @return text for msg below setting
	 */
	public String getMsgBelowSettings(){
		getIframe();
		return getText(msgBelowSettings);
	}


	/**
	 * for getting Date below  whats new
	 * 
	 * @return text for date
	 */
	public String getWhatsNewTxt(){
		getIframe();
		return getText(whatsNewTxt);
	}


	/**
	 * for getting whats new text
	 * 
	 * @return text 
	 */
	public String getDateTxt(){
		getIframe();
		scrollTo(dateTxt);
		return getText(dateTxt);
	}


	/**
	 * for getting List point 1 in what's new content
	 * 
	 * @return text for point 1
	 */
	public String getListPoint1Txt(){
		getIframe();
		return getText(listPoint1);
	}


	/**
	 * for getting List point 2 in what's new content
	 * 
	 * @return text for point 2
	 */
	public String getListPoint2(){
		getIframe();
		return getText(listPoint2);
	}


	/**
	 * for getting List point 3 in what's new content
	 * 
	 * @return text for point 3
	 */
	public String getListPoint3(){
		getIframe();
		return getText(listPoint3);
	}

	/**
	 * for getting List point 4 in whats new content
	 * 
	 * @return text for point 4
	 */
	public String getListPoint4(){
		getIframe();
		return getText(listPoint4);
	}
	
	
	/**
	 * for getting List point 4 in whats new content
	 * 
	 * @return text for point 5
	 */
	public String getListPoint5(){
		getIframe();
		return getText(listPoint5);
	}
	
	
	/**
	 * for getting List point 4 in whats new content
	 * 
	 * @return text for point 6
	 */
	public String getListPoint6(){
		getIframe();
		return getText(listPoint6);
	}
	
	/**
	 * for getting vCenter server text top right corner
	 * 
	 * @return text 
	 */
	public String getVcenterServerTxt(){
		getIframe();
		return getText(vcenterserverTxt);
	}


}
