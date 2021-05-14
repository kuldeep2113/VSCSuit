package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class SCPPage extends PageBase{
	
	
	public SCPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	
	public SCPPage getLoginPage(String pageURL)
	{
		NavigatetoPage(pageURL);
		return this;
		
	}
	
	
	@FindBy(css = ".scrollable.title-offset>ul>li:nth-child(3)>a>span:nth-child(2)")
	private WebElement scpTxt;
	
	@FindBy(id = "heading")
	private WebElement scpHeadingTxt;
	
	@FindBy(css= ".sandbox-iframe")
	private WebElement  iFrame;
	
	@FindBy(css=".btn.btn-primary.btn-sm")
	private WebElement createBtn;
	
	@FindBy(css=".modal-nav.clr-wizard-stepnav-wrapper>h3>clr-wizard-title")
	private WebElement scpPopUpHeading;
	
	@FindBy(css=".clr-form-horizontal.clr-form.ng-untouched.ng-pristine.ng-invalid>div>label")
	private WebElement name;
	
	@FindBy(id="generalName")
	private WebElement scpNameInput;
	
	@FindBy(id="generalDescription")
	private WebElement descriptionInput;
	
	@FindBy(css=".clr-wizard-btn-wrapper:nth-child(3)>button")
	private WebElement nxtBtn;
	
	@FindBy(css=".btn.btn-primary.ng-star-inserted")
	private WebElement finishBtn;
	
	@FindBy(css=".alert.alert-success>div>clr-alert-item>span")
	private WebElement successMsgScp;
	
	@FindBy(css=".clr-subtext.ng-star-inserted")
	private WebElement errorMsg;
	
	
	
	
	
	
	
	
	
	

	/**
	 * for switching to iframe
	 * @return Webelement of iframe class
	 */

	public void getIframe() 
	{
		switchToIframeByClass(iFrame); 
	}

	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getSCPTxt()
	{
		return getText(scpTxt);
	
	}
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getSCPHeadingTxt()
	{
		getIframe();
		return getText(scpHeadingTxt);
	
	}
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getCreateBtnTxt()
	{
		getIframe();
		return getText(createBtn);
	
	}
	
	/**
	 * for clicking on add button
	 * 
	 * @return same class object
	 */
	public SCPPage clickOnCreateBtn(){
		switchToIframeByIndex(0);
		clickingElement(createBtn);
		return this;
	}
	
	

	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getCreateSCPPopUpHeading()
	{
		switchToPage();
		switchToIframeByIndex(1);
		return getText(scpPopUpHeading);
	
	}
	
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getname()
	{
		return getText(name);
	}
	
	
	/**
	 * for entering username
	 * 
	 * @param username
	 * @return object of current class
	 */

	public SCPPage enterScpName(String scp) {
		switchToPage();
		switchToIframeByIndex(1);
		setText(scpNameInput, scp);
		return this;
	}
	
	/**
	 * for entering username
	 * 
	 * @param username
	 * @return object of current class
	 */

	public SCPPage enterDescription(String desc) {
		setText(descriptionInput, desc);
		return this;
	}
	
	/**
	 * for clicking on add button
	 * 
	 * @return same class object
	 */
	public SCPPage clickOnNxtBtn(){
		clickingElement(nxtBtn);
		return this;
	}
	
	/**
	 * for clicking on add button
	 * 
	 * @return same class object
	 */
	public SCPPage clickOnFinishBtn(){
		clickingElement(finishBtn);
		return this;
	}
	
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getSuccessMsg()
	{
		switchToPage();
		switchToIframeByIndex(0);
		return getText(successMsgScp);
	
	}
	/**
	 * for clicking on Setting
	 * 
	 * @return current class object
	 */
	public String getErrorMsg()
	{
		
		return getText(errorMsg);
	
	}
}
