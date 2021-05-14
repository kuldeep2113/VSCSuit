package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;


import suite.base.TestBase;
import suite.page.LoginPage;
import suite.page.RCPage;
import suite.testdata.LoginTestData;

public class RCTest extends TestBase {

	private RCPage rc;


	/**
	 * create excel file
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("RebrandingCheckPoints");
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

	@Test(description = "Verify plugin logo",  groups = { "wip",	"RCTest" })
	public void RC_1() 
	{
		rc = new RCPage(getDriver());
		login();

		rc.clickOnMenu();

		if( getEnvLang().contains("lenovo")){
			rc.getLenPluginLogo();
		}
		else {
			rc.getFujiPluginLogo();
		}	
	
	}


	@Test(description = "Verify vendor name in description at getting started page",  groups = { "done",	"RCTest" })
	public void RC_2() 
	{			
			rc = new RCPage(getDriver());
			login();

			String actual = rc.clickOnMenu()
					.clickOnPlugin()
					.getVscDescriptionTxt();

		if(getBrowserLang().contains("eng") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(10).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(10).getStringCellValue());
		}				
		else if(getBrowserLang().contains("japanese") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(10).getStringCellValue());
		}
		else if(getBrowserLang().contains("eng") &&  getEnvLang().contains("fujitsu") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(4).getCell(10).getStringCellValue());
		}
		else
		{
			Assert.assertEquals(actual, getSheet().getRow(5).getCell(10).getStringCellValue());
		}
	}
	
	


	@Test(description = "Verify help link redirection",  groups = { "done",	"RCTest" })
	public void RC_3() 
	{
		rc = new RCPage(getDriver());
		login();

		String actual =	rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnHelpDropDown()
				.clickOnHelp()
				.getNavigatedUrl();

		if( getEnvLang().contains("fujitsu") ) 
		{
			Assert.assertEquals(actual, LoginTestData.LOGIN_NVG_URL);
		}
		else if( getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, LoginTestData.LOGIN_NVG_URL_LEN);
		}
		
	}

	@Test(description = "Verify scp description for platinum",  groups = { "done",	"RCTest" })
	public void RC_4() 
	{
		rc = new RCPage(getDriver());
		login();

		String actual =	rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp()
				.getPlatinumDesc();

		if( getEnvLang().contains("fujitsu") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(4).getCell(5).getStringCellValue());
		}
		else if( getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(5).getStringCellValue());
		}
	}

	@Test(description = "Verify scp description for Bronze",  groups = { "done",	"RCTest" })
	public void RC_5() 
	{
		rc = new RCPage(getDriver());
		login();

		String actual =	rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp()
				.getBronzeDesc();

		if( getEnvLang().contains("fujitsu") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(4).getCell(6).getStringCellValue());
		}
		else if( getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(6).getStringCellValue());
		}
	}



	@Test(description = "Verify vendor name in NFS VAAI Description",  groups = { "done",	"RCTest" })
	public void RC_6() 
	{
		rc = new RCPage(getDriver());
		login();

		String actual =	rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnSettings()
				.clickOnNFSVAAI()
				.getNfsVaaiDescription();
		
		if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(4).getCell(7).getStringCellValue());
		}
		else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
		}
		else if( getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
		}

	}

	@Test(description = "verify invalid  .vib file upload",  groups = { "wip",	"RCTest" })
	public void RC_7() throws Exception 
	{
		rc = new RCPage(getDriver());
		login();

		rc.clickOnMenu()
		.clickOnPlugin()
		.clickOnSettings()
		.clickOnNFSVAAI()
		.clickOnChange();
		if(getEnvLang().contains("fujitsu"))
		{
			rc.clickOnBrowseBtn("H:/lavvkush/LenovoNasPlugin.vib");
		}
		else
		{
			rc.clickOnBrowseBtn("H:/lavvkush/FujitsuNasPlugin.vib");
		}
		String actual =rc.clickOnUploadBtn()
				.getInvalidFileUploadErrorMsg();

		Assert.assertEquals(actual, getSheet().getRow(1).getCell(8).getStringCellValue());

	}


	@Test(description = "verify valid  .vib file upload",  groups = { "wip",	"RCTest" })
	public void RC_8() throws Exception 
	{
		rc = new RCPage(getDriver());
		login();

		rc.clickOnMenu()
		.clickOnPlugin()
		.clickOnSettings()
		.clickOnNFSVAAI()
		.clickOnChange();

		if(getEnvLang().contains("fujitsu"))
		{
			rc.clickOnBrowseBtn("H:/lavvkush/FujitsuNasPlugin.vib");
		}
		else
		{
			rc.clickOnBrowseBtn("H:/lavvkush/LenovoNasPlugin.vib");
		}
		String actual =rc.clickOnUploadBtn()
				.getSuccessMsgForFileUpload();
		
		if(getEnvLang().contains("eng"))
		{
		Assert.assertEquals(actual, getSheet().getRow(4).getCell(9).getStringCellValue());
		}
		else if(getEnvLang().contains("japanese"))
		{
		Assert.assertEquals(actual, getSheet().getRow(5).getCell(9).getStringCellValue());
		}
		else if(getEnvLang().contains("chinese"))
		{
		Assert.assertEquals(actual, getSheet().getRow(5).getCell(9).getStringCellValue());
		}

		
}

@Test(description = "Verify plugin logo after clicking on action drop down",  groups = { "done",	"RCTest" })
public void RC_9() 
{
	rc = new RCPage(getDriver());
	login();

	rc.clickOnDc()
	.clickOnAction();

	if( getEnvLang().contains("lenovo")){
		rc.getLenLogoDCAction();
	}
	else {
		rc.getFujiLogoDCAction();
	}	

}

@Test(description = "Verify mob page link 1",  groups = { "done",	"RCTest" })
public void RC_10()
{
	rc = new RCPage(getDriver());

	if( getEnvLang().contains("fujitsu")) 
	{
		String actual = rc.getLoginPage(getSheet().getRow(4).getCell(2).getStringCellValue())
				.clickOnContentMob()
				.clickOnExtensionManager()
				.clickOnMoreMob()
				.getFujiMobLink1();	

		Assert.assertEquals(actual, getSheet().getRow(4).getCell(3).getStringCellValue());
	}
	else 
	{
		String actual = rc.getLoginPage(getSheet().getRow(1).getCell(2).getStringCellValue())
				.clickOnContentMob()
				.clickOnExtensionManager()
				.clickOnMoreMob()
				.getLenMobLink1();	

		Assert.assertEquals(actual, getSheet().getRow(1).getCell(3).getStringCellValue());
	}

}


@Test(description = "Verify Mob page link 2",  groups = { "done",	"RCTest" })
public void RC_11()
{
	rc = new RCPage(getDriver());

	if( getEnvLang().contains("fujitsu")) 
	{
		String actual = rc.getLoginPage(getSheet().getRow(5).getCell(2).getStringCellValue())
				.clickOnContentMob()
				.clickOnExtensionManager()
				.clickOnMoreMob()
				.getFujiMobLink2();

		Assert.assertEquals(actual, getSheet().getRow(4).getCell(4).getStringCellValue());
	}
	else
	{
		String actual = rc.getLoginPage(getSheet().getRow(1).getCell(2).getStringCellValue())
				.clickOnContentMob()
				.clickOnExtensionManager()
				.clickOnMoreMob()
				.getLenMobLink2();

		Assert.assertEquals(actual, getSheet().getRow(1).getCell(4).getStringCellValue());
	}

}

@Test(description = "Verify vendor logo, right click on DC",  groups = { "done",	"RCTest" })
public void RC_12() 
{
	rc = new RCPage(getDriver());
	login();

	rc.rightClickOnDc();

	if( getEnvLang().contains("lenovo")){
		rc.getLenPluginLogo();
	}
	else {
		rc.getFujiPluginLogo();
	}	
//	captureScreenshot("Screenshots/PluginLogo.PNG");
}

@Test(description = "Verify vendor logo, right click on Host",  groups = { "done",	"RCTest" })
public void RC_13() 
{
	rc = new RCPage(getDriver());
	login();

	rc.rightClickOnDc();

	if( getEnvLang().contains("lenovo")){
		rc.getLenPluginLogo();
	}
	else {
		rc.getFujiPluginLogo();
	}	
	//captureScreenshot("Screenshots/PluginLogo.PNG");
}

}
