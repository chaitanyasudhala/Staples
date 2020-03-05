package com.staples.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.staples.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseUrl = rc.getPageUrl();
	public String userName = rc.getUserName();
	public String password = rc.getPassword();
	public String chromePath = rc.getChromePath();
	public String fireFoxPath = rc.getFireFoxPath();
	public static WebDriver driver;
	public Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws InterruptedException {

		logger = Logger.getLogger("Staples");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}

		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Sign InMenuFlyout']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();

	}

	/*
	 * @AfterClass public void tearDown() {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

}
