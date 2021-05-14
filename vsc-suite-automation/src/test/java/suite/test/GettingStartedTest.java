package suite.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.GettingStartedPage;
import suite.page.LoginPage;

/**
 * This class contains test cases for getting started page
 * @author kuldeepl
 *
 */

public class GettingStartedTest extends TestBase {

	private GettingStartedPage gs;
	DataFormatter formatter = new DataFormatter();
	private Cell cell;
	
	private String getDate() {
		 cell= getSheet().getRow(8).getCell(16);
		 return formatter.formatCellValue(cell);
							
	}
	


	/**
	 * create excel file
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("GettingStarted");
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

	@Test(description = "Verify getting started text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_1() 
	{
		gs = new GettingStartedPage(getDriver());
		login();
				
		String actual = gs.getGettingStaredTxt();

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

	@Test(description = "Verify description at getting started page",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_2() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getVscDescriptionTxt();


		if(getBrowserLang().contains("eng") &&  getEnvLang().contains("netapp") )
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") &&  getEnvLang().contains("netapp") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese") &&  getEnvLang().contains("netapp") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("eng") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(4).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(5).getCell(3).getStringCellValue());
		}				
		else if(getBrowserLang().contains("japanese") &&  getEnvLang().contains("lenovo") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(6).getCell(3).getStringCellValue());
		}
		else if(getBrowserLang().contains("eng") &&  getEnvLang().contains("fujitsu") ) 
		{
			Assert.assertEquals(actual, getSheet().getRow(7).getCell(3).getStringCellValue());
		}
		else
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(3).getStringCellValue());
		}
	}

	@Test(description = "Verify add storage system text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_3() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getAddStoragSysTxt();


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

	@Test(description = "Verify description below  add storage",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_4() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getAddStorageDescTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(5).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(5).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(5).getStringCellValue());
		}
	}

	@Test(description = "Verify add button text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_5() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getAddBtnTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(6).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(6).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(6).getStringCellValue());
		}
	}

	@Test(description = "Verify add storage pop up",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_6() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.clickAddBtn()
				.getStoragePopUpHeading();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(4).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(4).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(4).getStringCellValue());
		}
	}
	
	@Test(description = "Verify provision ds text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_7() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getProvisionDSTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(7).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(7).getStringCellValue());
		}
	}

	@Test(description = "Verify description below provision ds",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_8() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getProvisionDSDescTxt();


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

	@Test(description = "Verify provision button text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_9() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getProvisionBtnTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(9).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(9).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(9).getStringCellValue());
		}
	}

	
	@Test(description = "Verify provision ds pop up heading",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_10() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.clickProvisionBtn()
				.getProvisionPopUpHeading();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(23).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(23).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(23).getStringCellValue());
		}
	}

	@Test(description = "Verify Next Steps text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_11() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getNextStepsTxt();


		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(10).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(10).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(10).getStringCellValue());
		}
	}
	
	@Test(description = "Verify view dashboard text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_12() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getViewDashboardTxt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(11).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(11).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(11).getStringCellValue());
		}
	}
	
	@Test(description = "Verify traditional dashboard text after cliking on View Dashboard",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_13() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.clickOnViewDashboard()
					.getTraditionDBTxt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(22).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(22).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(22).getStringCellValue());
		}
	}
	
	@Test(description = "Verify msg below view dashboard",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_14() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getMsgBelowVD();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(12).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(12).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(12).getStringCellValue());
		}
	}
	
	@Test(description = "Verify setting link text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_15() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getSettingsTxt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(13).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(13).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(13).getStringCellValue());
		}
	}
	
	@Test(description = "Verify heading of setting page after cliking on setting link",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_16() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.clickOnSettings()
					.getSettingPageHeading();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(13).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(13).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(13).getStringCellValue());
		}
	}
	
	@Test(description = "Verify msg below setting link",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_17() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getMsgBelowSettings();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(14).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(14).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(14).getStringCellValue());
		}
	}

	
	@Test(description = "Verify what's new text",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_18() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getWhatsNewTxt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(15).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(15).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(15).getStringCellValue());
		}
	}
	
	@Test(description = "Verify date text below what's new",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_19() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getDateTxt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(7).getCell(16).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getDate());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(16).getStringCellValue());
		}
	}
	
	@Test(description = "Verify point 1 from whats new list",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_20() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getListPoint1Txt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(17).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(17).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(17).getStringCellValue());
		}
	}
	
	@Test(description = "Verify point 2 from whats new list",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_21() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getListPoint2();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(18).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(18).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(18).getStringCellValue());
		}
	}
	
	@Test(description = "Verify point 3 from whats new list",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_22() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getListPoint3();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(19).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(19).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(19).getStringCellValue());
		}
	}
	
	@Test(description = "Verify point 4 from whats new list",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_23() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getListPoint4();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(20).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(20).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(20).getStringCellValue());
		}
	}
	
	@Test(description = "Verify point 5 from whats new list",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_24() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getListPoint5();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(24).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(24).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(24).getStringCellValue());
		}
	}
	
	@Test(description = "Verify point 4 from whats new list",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_25() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getListPoint6();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(25).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(8).getCell(25).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(25).getStringCellValue());
		}
	}
	
	@Test(description = "Verify vCenter server text from top right corner",  groups = { "done",	"GettingStartedTest" })
	public void GettingStartedTest_26() 
	{
		gs = new GettingStartedPage(getDriver());
		login();

		String actual = gs.getVcenterServerTxt();

		if(getBrowserLang().contains("eng"))
		{
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(21).getStringCellValue());
		}
		else if(getBrowserLang().contains("japanese"))
		{
			Assert.assertEquals(actual, getSheet().getRow(3).getCell(21).getStringCellValue());
		}
		else if(getBrowserLang().contains("chinese") || getEnvLang().contains("lenovo"))
		{
			Assert.assertEquals(actual, getSheet().getRow(2).getCell(21).getStringCellValue());
		}
	}
}
