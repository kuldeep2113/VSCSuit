package suite.test;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.LoginPage;

public class LoginPageTest extends TestBase {

	private  LoginPage login;


	/**
	 * create excel filel
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("Login");
	}

	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}


	@Test( description = "Verify login page contains correct text",  groups = { "done",	"LoginTest" })
	public void login_1()
	{
		login = new LoginPage(getDriver());

		String actual = login.getLoginPage(getPageURL())
				.getLoginPageHeading();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(2).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(2).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(2).getStringCellValue());
		}
	}	

	@Test( description = "Verify that after login lended to correct page" ,  groups = { "done",	"LoginTest" })
	public void login_2()
	{
		login = new LoginPage(getDriver());

		String actual = login.getLoginPage(getPageURL())
				.enterUserName(getSheet().getRow(1).getCell(3).getStringCellValue())
				.enterPassword(getSheet().getRow(1).getCell(4).getStringCellValue())
				.clickLoginBtn()
				.getHomePage();

		
		Assert.assertEquals(actual, getSheet().getRow(1).getCell(5).getStringCellValue());
		}
		

	

	@Test(description = "Verify menu text ",  groups = { "done",	"LoginTest" })
	public void login_3() 
	{
		login = new LoginPage(getDriver());

		String actual = login.getLoginPage(getPageURL())
				.enterUserName(getSheet().getRow(1).getCell(3).getStringCellValue())
				.enterPassword(getSheet().getRow(1).getCell(4).getStringCellValue())
				.clickLoginBtn()
				.getMenuTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(8).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(8).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(8).getStringCellValue());
		}
	
	}

	@Test(description = "Verify that VSC Plugin is available with valid logo and text" ,groups = { "donett",	"LoginTest" })
	public void login_4()
	{
		login = new LoginPage(getDriver());

		String actual = login.getLoginPage(getPageURL())
				.enterUserName(getSheet().getRow(1).getCell(3).getStringCellValue())
				.enterPassword(getSheet().getRow(1).getCell(4).getStringCellValue())
				.clickLoginBtn()
				.clickOnMenu()
				.getValidPluginTxt();
		
		Assert.assertEquals(actual, getSheet().getRow(1).getCell(6).getStringCellValue());

	}

	@Test(description = "Verify vsc overview page after clicking on plugin"  ,groups = { "done",	"LoginTest" })
	public void login_5() 
	{
		login = new LoginPage(getDriver());

		String actual = login.getLoginPage(getPageURL())
				.enterUserName(getSheet().getRow(1).getCell(3).getStringCellValue())
				.enterPassword(getSheet().getRow(1).getCell(4).getStringCellValue())
				.clickLoginBtn()
				.clickOnMenu()
				.clickOnPlugin()
				.getOverviewPageTxt();

		Assert.assertEquals(actual, getSheet().getRow(1).getCell(7).getStringCellValue());
	}


}
