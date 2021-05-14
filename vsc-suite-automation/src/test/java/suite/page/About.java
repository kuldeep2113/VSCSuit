package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class About extends PageBase{


	public About(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting the pageUrl
	 * 
	 * @param pageURL
	 * @return pageURL
	 */

	public About  getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
		}
	
	
	@FindBy(css = ".main-nav>header>div>a>span:nth-child(2)")
	private WebElement homePageTxt;
	
		@FindBy(xpath = "//*[@id='horizontal-panel']/left-panel/div/object-navigator/div/div/div/div/div/div/div/div[2]/ul/li[2]/a/span[2]")
	    private WebElement strgSys;
	    
	    @FindBy(css=".clr-row.action-container>div:nth-child(1)>button:nth-child(1)")
	    private WebElement addbtn;
	    
	    @FindBy(css=".k-sprite.vsphere-icon-vcenter")
	    private WebElement vCenterforRightClick;
	    
	    @FindBy(css="#vui-actions-menu>li:nth-child(2)")
	    private WebElement dataCenter;
	    
	    public About clickOnss() {
	        getWebElement(strgSys).click();
	   
	        return this;
	    }
	    
	    /**
		 * for getting home page text
		 * @return WebElement of home page text
		 */
		public String getHomePage() {
			return getText(homePageTxt);
		}

	
	  public About clickOnAdd() {
	  
	  switchToIframeByIndex(0); clickingElement(addbtn); 
	  return this;
	  
	  }
	 
	    public String  gettext() {
	  return   getText(strgSys);

	    }
	    public About  rightClick() {
	  	  rightClickOnElement(vCenterforRightClick, dataCenter);
	    	return this;

	  	    }

	
	}

