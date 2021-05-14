package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.DSActionPage;
import suite.page.LoginPage;
import suite.page.RCPage;
import suite.testdata.ControlPanelTestData;

public class DSActionsTest extends TestBase {

	private DSActionPage ds;


	/**
	 * create excel file
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("DSAction");
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
	}

	
	@Test(description = "Verify create datastore heading",  groups = { "done",	"DSTest" })
	public void DatastoreProvision_1() 
	{
		ds = new DSActionPage(getDriver());
		login();
		
		String actual =ds.clickOnArrow()
				.clickOnHost()
		.rightClick()
		.hoverToProvisionDS()
		.getProvisionDSTxt();
		
		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(2).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(4).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(4).getStringCellValue());
		}		

	
	}
	@Test(description = "Verify create datastore heading",  groups = { "done",	"DSTest" })
	public void DatastoreProvision_2() 
	{
		ds = new DSActionPage(getDriver());
		login();
		
		String actual =ds.clickOnArrow()
				.clickOnHost()
		.rightClick()
		.hoverToProvisionDS()
		.clickOnProvisionDS()
		.getDsPopupHeadingTxt();
		
		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(4).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(4).getStringCellValue());
		}			
		

	
	}

}
