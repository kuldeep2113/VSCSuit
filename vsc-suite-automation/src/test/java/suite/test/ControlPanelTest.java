package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.ControlPanelPage;
import suite.testdata.ControlPanelTestData;

public class ControlPanelTest extends TestBase{

	
	/**
	 * create excel filel
	 * 
	 * @return excel file path
	 */
	private XSSFSheet getSheet() {
		return getTestData().getSheet("ControlPanel");
	}
	
	private ControlPanelPage cp;


	@Test(description = "Verify  the page title of the page",  groups = { "done",	"ControlPanelTest" })
	public void cp_1()
	{
		cp = new ControlPanelPage(getDriver());

		String actual =  cp.getCotrolPanelPage(getSheet().getRow(7).getCell(2).getStringCellValue())
									.getLoginPgeTxt();
		Assert.assertEquals(actual, getSheet().getRow(7).getCell(7).getStringCellValue());

	}

	@Test(description = "Verify that successfully login with valid credentials",  groups = { "done",	"ControlPanelTest" })
	public void cp_2()
	{
		cp = new ControlPanelPage(getDriver());

		cp.getCotrolPanelPage(getSheet().getRow(7).getCell(2).getStringCellValue())
		.enterUserName(getSheet().getRow(1).getCell(3).getStringCellValue())
		.enterPassword(getSheet().getRow(1).getCell(4).getStringCellValue())
		.clickLoginBtn();
	}
	
	@Test(description = "Verify  the control panel home page  heading message",  groups = { "done",	"ControlPanelTest" })
	public void cp_3()
	{
		cp = new ControlPanelPage(getDriver());

		String actual =  cp.getCotrolPanelPage(getSheet().getRow(7).getCell(2).getStringCellValue())
				.enterUserName(getSheet().getRow(1).getCell(3).getStringCellValue())
				.enterPassword(getSheet().getRow(1).getCell(4).getStringCellValue())
				.clickLoginBtn()
				.getControlPanelHeading();

		Assert.assertEquals(actual, getSheet().getRow(7).getCell(6).getStringCellValue());

	}


}

