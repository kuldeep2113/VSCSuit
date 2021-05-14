package suite.base;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import suite.init.SessionInit;
import suite.listener.WebDriverListener;
import suite.utils.ExcelUtil;
import  suite.utils.PropertyUtil;
import suite.utils.TestProp;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

/**
 * This is Test Base class for automation framework contains all the common test
 * prerequisites for automation
 * 
 * @author arth
 *
 */
public class TestBase extends EnvBase {

	private WebDriver driver;
	private WebDriverWait wait;
	private EventFiringWebDriver eventHandler;
	private WebDriverListener ecapture;
	private String browserLang;
	private String envLang;

	/**
	 * Initiate the enviroment url
	 * 
	 * @param env
	 */
	@Parameters({ "env" })
	@BeforeClass
	public void setUpEnv(@Optional("fujitsu") String env) {
		setEnv(env);
		this.envLang = env;
	}

	/**
	 * Setting the browser
	 * 
	 * @param browser
	 */
	@Parameters({ "browser" })
	@BeforeMethod
	public void setDriver(@Optional("chrome-eng") String browser) {

		SessionInit.getDriverSession().initiateBrowserSession(browser);
		this.driver = SessionInit.getDriverSession().getBrowserSession();

		this.eventHandler = new EventFiringWebDriver(driver);
		this.ecapture = new WebDriverListener();
		this.eventHandler.register(ecapture);
		this.browserLang = browser;
	}

	/**
	 * for closing the browser
	 */
	/*
	 * @AfterMethod public void tearDown()
	 *  {
	 *   this.eventHandler.unregister(ecapture);
	 * SessionInit.getDriverSession().terminateBrowserSession(driver); 
	 * }
	 */

	/**
	 * Loading browser instance
	 * 
	 * @return
	 */
	public EventFiringWebDriver getDriver() {
		return this.eventHandler;
	}

	@Override
	public String getEnv() {
		return super.getEnv();
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public String getBrowserLang() {
		return browserLang;
	}

	public String getEnvLang() {
		return envLang;
	}

	/**
	 * for getting the data from excel sheet 
	 * 	
	 * @return path of the sheet
	 */
	public XSSFWorkbook getTestData() {
		return new ExcelUtil().ExcelDataConfig("src/main/resources/UVATestData.xlsx");
	}

	/**
	 * for getting the Username from property file
	 * @return Username
	 */
	public String getUsername(){
		return  new  PropertyUtil().getPropertiesUsername();
	}
	
	/**
	 * for getting the Password from property file
	 * @return Password
	 */
	public String getPassword(){
		return  new  PropertyUtil().getPropertiesPassword();
	}
	
	public String getP(String key){
		return  new   PropertyUtil().getProperties(key);
	}
	

	
	/**
	 * for capturing the sceen
	 * @param pathWithScreenName
	 */
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution

	 public void screenShot(ITestResult result){

	 //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition

	 if(ITestResult.FAILURE==result.getStatus()){

	 try{

	 // To create reference of TakesScreenshot

	 TakesScreenshot screenshot=(TakesScreenshot)driver;

	 // Call method to capture screenshot

	 File src=screenshot.getScreenshotAs(OutputType.FILE);

	 // Copy files to specific location 

	 // result.getName() will return name of test case so that screenshot name will be same as test case name

	 FileUtils.copyFile(src, new File("Screenshots/"+result.getName()+".png"));

	 System.out.println("Successfully captured a screenshot");

	 }catch (Exception e){

	 System.out.println("Exception while taking screenshot "+e.getMessage());

	 } 

	 }

	 this.eventHandler.unregister(ecapture);
	  SessionInit.getDriverSession().terminateBrowserSession(driver);

	 }

	}

	
	
	/*@AfterMethod
	public void captureScreenshot(String pathWithScreenName){
		 try {
			new ScreenshotUtil().takeScreenshot(driver, pathWithScreenName, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

