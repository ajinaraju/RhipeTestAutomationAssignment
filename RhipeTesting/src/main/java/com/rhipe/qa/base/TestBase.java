/* Base class for Page Object Model. All page classes and test classes will be inheriting from this.  */

package com.rhipe.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.rhipe.qa.util.TestUtil;
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/rhipe/qa/config/config.properties");
			prop.load(inputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Base class initialization
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/ChromeDriver/chromedriver");	
			driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browserName.equals("FF")) {
			//nop - support for other browsers
		}		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
