package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.LoginPage;
import suite.page.RCPage;
import suite.page.SCPPage;

public class SCPTest extends TestBase{
	
	private RCPage rc;
	private SCPPage scp;
	
	/**
	 * create excel file
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("SCP");
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
	
	
	
	@Test(description = "Verify scp text",  groups = { "done","SCP" })
	public void SCP_1() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin();
				
				scp = new SCPPage(getDriver());
				String actual = scp.getSCPTxt();

				if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(7).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(8).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("lenovo") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
				}

			}
	
	
	@Test(description = "Verify SCP page heading,after clicking on SCP tab",  groups = { "done",	"SCP" })
	public void SCP_2() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual = scp.getSCPHeadingTxt();

				if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(7).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(8).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("lenovo") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
				}

			}
	
	
	@Test(description = "Verify SCP page heading,after clicking on SCP tab",  groups = { "done", "SCP" })
	public void SCP_3() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual = scp.getCreateBtnTxt();

				if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(7).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(8).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("lenovo") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
				}

			}
	
	@Test(description = "Verify SCP page heading,after clicking on SCP tab",  groups = { "done","SCP" })
	public void SCP_4() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual = scp.clickOnCreateBtn()
						.getCreateSCPPopUpHeading();

				if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(7).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(8).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("lenovo") ) 
				{
					Assert.assertEquals(actual, getSheet().getRow(5).getCell(7).getStringCellValue());
				}

			}
	
	
	@Test(description = "Verify SCP page heading,after clicking on SCP tab",  groups = { "wip","SCP" })
	public void SCP_5() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual1 = scp.clickOnCreateBtn()
						.getCreateSCPPopUpHeading();
						
						String actual2 = scp.clickOnCreateBtn()
						.getname();

				if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
				{
					Assert.assertEquals(actual1, getSheet().getRow(7).getCell(2).getStringCellValue());
					Assert.assertEquals(actual2, getSheet().getRow(7).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
				{
					Assert.assertEquals(actual2, getSheet().getRow(8).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("lenovo") ) 
				{
					Assert.assertEquals(actual2, getSheet().getRow(5).getCell(7).getStringCellValue());
				}

			}
	
	public void SCP_6() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual1 = scp.clickOnCreateBtn()
						.getCreateSCPPopUpHeading();
						
						String actual2 = scp.clickOnCreateBtn()
						.getname();

				if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("eng") ) 
				{
					Assert.assertEquals(actual1, getSheet().getRow(7).getCell(2).getStringCellValue());
					Assert.assertEquals(actual2, getSheet().getRow(7).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("fujitsu")&&getBrowserLang().contains("japanese") ) 
				{
					Assert.assertEquals(actual2, getSheet().getRow(8).getCell(2).getStringCellValue());
				}
				else if( getEnvLang().contains("lenovo") ) 
				{
					Assert.assertEquals(actual2, getSheet().getRow(5).getCell(7).getStringCellValue());
				}

			}

	
	@Test(description = "Verify SCP page heading,after clicking on SCP tab",  groups = { "done","SCP" })
	public void SCP_7() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual = scp.clickOnCreateBtn()
						
						.enterScpName("test1")
						.enterDescription("desc")
						.clickOnNxtBtn()
						.clickOnNxtBtn()
						.clickOnNxtBtn()
						.clickOnNxtBtn()
						.clickOnFinishBtn()
						.getSuccessMsg();
						
				Assert.assertEquals(actual, getSheet().getRow(1).getCell(4).getStringCellValue());

			}
	
	@Test(description = "Verify SCP page heading,after clicking on SCP tab",  groups = { "broken","SCP" })
	public void SCP_8() 
	{
		login();
		rc = new RCPage(getDriver());
				rc.clickOnMenu()
				.clickOnPlugin()
				.clickOnScp();
				
				scp = new SCPPage(getDriver());
				String actual = scp.clickOnCreateBtn()
						
						.enterScpName("test1")
						.enterDescription("desc")
						.clickOnNxtBtn()
						.getErrorMsg();
						
				Assert.assertEquals(actual, getSheet().getRow(1).getCell(5).getStringCellValue());

			}

}
