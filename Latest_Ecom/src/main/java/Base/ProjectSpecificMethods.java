package Base;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	@BeforeSuite
	public void loadUserData() throws IOException {
		loadData("data");
	}

	@BeforeClass
	public void setUp() {
		eachNode = test.createNode(testCaseName);
		startApplication(prop.getProperty("browser"), prop.getProperty("url"));

		/*
		 * WebElement email = locateElement("id", "userEmail"); clearAndType(email,
		 * prop.getProperty("username")); WebElement password = locateElement("id",
		 * "userPassword"); clearAndType(password, prop.getProperty("password"));
		 * WebElement submit = locateElement("id", "login");
		 * click(submit,"Signin button"); verifyIsDisplayed(locateElement("css",
		 * "[class*='toast-title']"), "Login Successfully");
		 */

	}

	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName, sheetName);
	}

	@AfterSuite
	public void unloadUserData() {
		unloadData();
	}
}