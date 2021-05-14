package suite.test;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;


import suite.base.TestBase;
import suite.page.About;
import suite.page.AboutPage;
import suite.page.GettingStartedPage;
import suite.page.LoginPage;
import suite.testdata.AboutTestData;
import suite.testdata.LoginTestData;
import suite.utils.TestProp;


public class Demo  extends TestBase {

	private About abt;
	


	/**
	 * create excel filel
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("About");
	}


	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}

	/**
	 * for login into VSC screen
	 */
	
	private void login() {
		new LoginPage(getDriver())
	.getLoginPage(getPageURL())
		.enterUserName(getUsername())
		.enterPassword(getPassword())
		.clickLoginBtn();
	
	
		
		//.clickOnMenu()
		//.clickOnPlugin();
	}

	@Test(description = "Verify about text ")
	public void tc_1() 
	{
	
	getP("username");
		
	       
				
			
	}
	}



