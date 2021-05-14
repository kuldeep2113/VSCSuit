package suite.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class RCPage extends PageBase{


	public RCPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting the pageUrl
	 * 
	 * @param pageURL
	 * @return pageURL
	 */

	public RCPage  getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}



	@FindBy(css = ".nav-item>button#clr-tab-link-0")
	private WebElement gettingStartedTxt;

	@FindBy(css= ".sandbox-iframe")
	private WebElement  iFrame;
	
	@FindBy(css = "div>vsc-navigation-view-menu>clr-dropdown")
	private WebElement menuBar;
	
	@FindBy(css = "span[class$='_vschtmlplugin-vendorIcon1")
	private WebElement vscPlugin;
	
	@FindBy(css = ".vui-icon.com_fujitsu_vschtmlplugin-vendorIcon18")
	private WebElement vscPluginForFuji;

	@FindBy(css = ".vui-icon.com_lenovo_vschtmlplugin-vendorIcon18")
	private WebElement vscPluginForLen;
	
	@FindBy(css =".clr-col-md-12.clr-col-sm-12.clr-col-xs-12.gettingstart-title")
	private WebElement  vscDescription;
	
	@FindBy(xpath = "//*[contains(@type,'button') and contains(@class,'dropdown-toggle')]")
	private WebElement helpDropDown;
	
	@FindBy(id = "clr-id-4")
	private WebElement helpLink;

	@FindBy(css = ".scrollable.title-offset>ul>li:nth-child(5)>a>span:nth-child(2)")
	private WebElement settings;
	
	@FindBy(css= "body>my-app>netapp-settings>div>div>div>clr-tabs>ul.nav>li:nth-child(3)>button")
	private WebElement nfsVaaiTab;
	
	@FindBy(css = "section>div>netapp-nfs-settings>div:nth-child(2)>span")
	private WebElement nfsVaaiDescription;
	
	@FindBy(css = ".change-detail-link:nth-child(1)")
	private WebElement changeLink;
	
	@FindBy(css = "section>div>netapp-nfs-settings>div:nth-child(4)>div>div:nth-child(3)>label")
	private WebElement browseBtn;
	
	@FindBy(css = "section>div>netapp-nfs-settings>div:nth-child(4)>div>div:nth-child(3)>label>input")
	private WebElement browseBtn2;
	
	@FindBy(css = "section>div>netapp-nfs-settings>div:nth-child(4)>div>div:nth-child(3)>div>button")
	private WebElement uploadBtn;
	
	@FindBy(css = "#clr-dg-row1>div.datagrid-row-scrollable>div>clr-dg-cell:nth-child(3)")
	private WebElement scpMsgForPlatnum;
	
	@FindBy(css = "#clr-dg-row2>div.datagrid-row-scrollable>div>clr-dg-cell:nth-child(3)")
	private WebElement scpMsgForBronze;
	
	@FindBy(css = ".scrollable.title-offset>ul>li:nth-child(3)>a>span:nth-child(2)")
	private WebElement clickOnScp;
	
	@FindBy(css = ".summary-action-link")
	private WebElement actionLink;
	
	@FindBy(css = ".k-sprite.com_fujitsu_vschtmlplugin-vendorIcon18")
	private WebElement logoForFujiFromActions;

	@FindBy(css = ".k-sprite.com_lenovo_vschtmlplugin-vendorIcon18")
	private WebElement logoForLenFromActions;
	
	@FindBy(css = ".k-sprite.vsphere-icon-datacenter.Datacenter")
	private WebElement dataCenter;
	
	@FindBy(linkText = "content")
	private WebElement contentTxtLinkMob;
	
	@FindBy(linkText = "ExtensionManager")
	private WebElement extensionManagerLink;
	
	@FindBy(linkText = "(more...)")
	private WebElement moreLink;
	
	@FindBy(linkText = "extensionList[\"com.fujitsu_ontap.nvpf\"]")
	private WebElement fujiEmListLink1;
	
	@FindBy(linkText = "extensionList[\"com.fujitsu_ontap.vsch5\"]")
	private WebElement fujiEmListLink2;
	
	@FindBy(linkText = "extensionList[\"com.lenovo.nvpf\"]")
	private WebElement lenEmListLink1;
	
	@FindBy(linkText = "extensionList['com.lenovo.vsch5']")
	private WebElement lenEmListLink2;
	
	@FindBy(css = ".content-area:nth-child(1)>app-alert>clr-alert>div>div>clr-alert-item>span")
	private WebElement invalidVibFileErrorMsg;
	
	@FindBy(css = ".content-area:nth-child(1)>app-alert>clr-alert>div>div>clr-alert-item>span")
	private WebElement fileUploadSuccessMsg;
	
	
	
	

	
	
	/**
	 * for switching to iframe
	 * @return Webelement of iframe class
	 */

	public void getIframe() 
	{
		switchToIframeByClass(iFrame); 
	}

	
	/**
	 * for clicking on Menu bar
	 * 
	 * @return object of current class
	 */

	public RCPage clickOnMenu() {
		clickingElement(menuBar);
		return this;
	}
	
	
	/**
	 * for clicking in VSC plugin
	 * @return class object
	 */

	public RCPage clickOnPlugin() {
		clickingElement(vscPlugin);
		return this;
	}
	
	/**
	 * for getting text of the element
	 * 
	 * @return text
	 */
	public boolean getLenPluginLogo() {
		return isWebElementDisplayed(vscPlugin);
	}
	
	
	/**
	 * for getting text of the element
	 * 
	 * @return text
	 */
	public boolean getFujiPluginLogo() {
		return isWebElementDisplayed(vscPlugin);
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
	 * for clicking on help icon
	 * 
	 * @return object of the current class
	 */
	public RCPage clickOnHelpDropDown() {
		switchToIframeByIndex(0);
		clickingElement(helpDropDown);
		return this;
	}
	
	/**
	 * for clicking on help
	 * 
	 * @return current class object
	 */
	public RCPage clickOnHelp() {
		clickingElement(helpLink);
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
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnSettings() {
		clickingElement(settings);
		return this;
	}
	
	/**
	 * for clicking on NFS VAAI Tab
	 * 
	 * @return current class object
	 */
	public RCPage clickOnNFSVAAI() {
		switchToPage();
		switchToIframeByIndex(0);
		clickingElement(nfsVaaiTab);
		return this;
	}
	
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getNfsVaaiDescription() {
	   switchToPage();
	//	getIframe();
	   switchToIframeByIndex(0);
		return getText(nfsVaaiDescription);
	}
	
	
	/**
	 * @throws Exception 
	 * for clicking on change keyword
	 * 
	 * @return current class object
	 * @throws  
	 */
	public RCPage clickOnChange() {
		switchToPage();
		switchToIframeByIndex(0);
		clickingElement(changeLink);
		return this;
	}
	
	
	/**
	 * for clicking on Browse button
	 * 
	 * @return current class object
	 * @throws Exception 
	 */
	public RCPage clickOnBrowseBtn(String filePath) throws Exception {
		switchToPage();
		getIframe();
		Thread.sleep(3000);
		fileUpload(By.cssSelector("section>div>netapp-nfs-settings>div:nth-child(4)>div>div:nth-child(3)>label>input"), filePath);
		Thread.sleep(3000);
		return this;
	}
	

	
	/**
	 * for clicking on upload button
	 * 
	 * @return current class object
	 */
	public RCPage clickOnUploadBtn() {
		switchToPage();
		getIframe();
		clickingElement(uploadBtn);
		return this;
	}
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getInvalidFileUploadErrorMsg() {
	   switchToPage();
		getIframe();;
		return getText(invalidVibFileErrorMsg);
	}
	
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getSuccessMsgForFileUpload() {
	   switchToPage();
		getIframe();;
		return getText(fileUploadSuccessMsg);
	}
	
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnScp() {
		clickingElement(clickOnScp);
		return this;
	}
	
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getPlatinumDesc() {
	   switchToPage();
		getIframe();
		return getText(scpMsgForPlatnum);
	}
	
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getBronzeDesc() {
	   switchToPage();
		getIframe();
		return getText(scpMsgForBronze);
	}
	
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnAction() {
		clickingElement(actionLink);
		return this;
	}
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnDc() {
		clickingElement(dataCenter);
		return this;
	}
	
	

	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage rightClickOnDc() {
		
		rightClick(dataCenter);
		scrollTo(vscPlugin);
		return this;
	}
	
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage rightClickOnHost() {
		
		rightClick(dataCenter);
		scrollTo(vscPlugin);
		return this;
	}

	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public boolean getFujiLogoDCAction() {
		scrollTo(logoForFujiFromActions);
			return isWebElementDisplayed(logoForFujiFromActions);
	}
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public boolean getLenLogoDCAction() {
		scrollTo(logoForLenFromActions);
			return isWebElementDisplayed(logoForLenFromActions);
	}
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnContentMob() {
		clickingElement(contentTxtLinkMob);
		return this;
	}
	
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnExtensionManager() {
		clickingElement(extensionManagerLink);
		return this;
	}
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public RCPage clickOnMoreMob() {
		clickingElement(moreLink);
		return this;
	}
	
	

	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getFujiMobLink1() {
			return getText(fujiEmListLink1);
	}
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getFujiMobLink2() {
			return getText(fujiEmListLink2);
	}
	
	

	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getLenMobLink1() {
			return getText(lenEmListLink1);
	}
	
	/**
	 * for getting  NFS VAAI description 
	 * 
	 * @return NFS VAAI description text
	 */
	public String getLenMobLink2() {
			return getText(lenEmListLink2);
	}
}