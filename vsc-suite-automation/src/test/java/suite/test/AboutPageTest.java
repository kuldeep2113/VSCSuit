package suite.test;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;


import suite.base.TestBase;
import suite.page.AboutPage;
import suite.page.LoginPage;
import suite.page.RCPage;

public class AboutPageTest extends TestBase {

	private AboutPage abt;


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
		.clickLoginBtn()
		.clickOnMenu()
		.clickOnPlugin();
	}

	@Test(description = "Verify about text is available correctly in the help drop down",  groups = { "done",	"AboutPageTest" })
	public void AboutTest_1() 
	{
		
		abt = new AboutPage(getDriver());
		login();

		String actual = abt.clickOnHelpDropDown()
				.getAboutTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(4).getStringCellValue());
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

	@Test(description = "Verify title of about wizard title",  groups = { "done",	"AboutPageTest" })
	public void AboutTest_2() 
	{
		
		abt = new AboutPage(getDriver());
		login();

		String actual = abt.clickOnHelpDropDown()
				.clickOnAbt()
				.getAbtPageTitle();

		if(getBrowserLang().contains("japanese")) 
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(3).getStringCellValue());
		}
		else 
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(3).getStringCellValue());
		}
	}


	@Test(description = "Verify vsc version in about wizard",  groups = { "done",	"AboutPageTest" })
	public void AboutTest_3() 
	{
		abt = new AboutPage(getDriver());
	
		login();
		
		String actual = abt.clickOnHelpDropDown()
				.clickOnAbt()
				.getVersion();

		if(getBrowserLang().contains("japanese")) 
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(5).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(5).getStringCellValue());
		}
		else 
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(5).getStringCellValue());
		}
	}

	@Test(description = "Verify copy right info in about wizard",  groups = { "done","AboutPageTest" })
	public void AboutTest_4() 
	{
		
		abt = new AboutPage(getDriver());
		login();

		String actual = abt.clickOnHelpDropDown()
				.clickOnAbt()
				.getCopyRightInfo();

		if(getBrowserLang().contains("eng") &&  getEnvLang().contains("netapp") )
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") &&  getEnvLang().contains("netapp") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese") &&  getEnvLang().contains("netapp") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("eng") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(4).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
		}				
		else if(getBrowserLang().contains("japanese") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(6).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("eng") &&  getEnvLang().contains("fujitsu") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(7).getCell(7).getStringCellValue());
		}
		else
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(7).getStringCellValue());
		}

	}

	@Test(description = "Verify OK button text in About wizard",  groups = { "done",	"AboutPageTest" })
	public void AboutTest_5() 
	{
		
		abt = new AboutPage(getDriver());
		login();

		String actual = abt.clickOnHelpDropDown()
				.clickOnAbt()
				.getOkBtn();


		if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(6).getStringCellValue());
		}
		else 
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(6).getStringCellValue());
		}
	}
	
	
	@Test(description = "Verify when we click on OK,  lend to overview page",  groups = { "done","AboutPageTest" })
	public void AboutTest_6() 
	{
		
		abt = new AboutPage(getDriver());
		login();

		String actual = abt.clickOnHelpDropDown()
				.clickOnAbt()
				.clickOnOkBtn()
				.getOverviewPageTxt();

		Assert.assertEquals(actual, getSheet().getRow(1).getCell(2).getStringCellValue());
	}
	
	@Test(description = "Verify plugin logo",  groups = { "done",	"AboutTest" })
	public void AboutTest_7(){
		
		abt = new AboutPage(getDriver());
		login();

		abt.clickOnHelpDropDown()
				.clickOnAbt();

		if( getEnvLang().contains("lenovo")){
			abt.getLenovoIcon();
		}
		else if(getEnvLang().contains("fujitsu")){
			abt.getFujitsuIcon();
		}	
		else
		{
			abt.getNetappIcon();
		}
	
	}

}




