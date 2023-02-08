package com.tech.framework;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/* Working Framework */
public class TestClass {
	public WebDriver driver;
	Logger logger;
	ExtentReports extent = new ExtentReports();;
	
	@BeforeMethod
	public void setUp() {
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		logger = LogManager.getLogger("TestClass");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://portfolio.rediff.com/portfolio-login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@Test
	public void LoginAndCheckWatchlist() throws InterruptedException {
		ExtentTest checklistTest = extent.createTest("Login to Rediff Money and Validate Watchlist");
		driver.findElement(By.xpath("//*[@for='useremail']/following-sibling::input[@id='useremail']"))
		.sendKeys("mdazeem5790@yahoo.com");
		driver.findElement(By.xpath("//*[@for='userpass']/following-sibling::input[@id='userpass']"))
		.sendKeys("Nirvana1$");
		driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'My Watchlist')]")).click();
		boolean stocksTable = driver.findElement(By.xpath("//*[@id='stocks']")).isDisplayed();
		Assert.assertEquals(stocksTable, true);
		int rowNum = driver.findElements(By.xpath("//*[@id='stocks']/tbody/child::tr")).size();
		Assert.assertEquals(rowNum, 14);
		logger.info("Clicked on My Watchlist link");
		checklistTest.log(Status.PASS, "Watchlist validated successfully");
	}
	
	@Test
	public void LoginAndCheckPortfolio() throws InterruptedException {
		ExtentTest portfolioTest = extent.createTest("Login to Rediff Money and Validate Portfolio");
		driver.findElement(By.xpath("//*[@for='useremail']/following-sibling::input[@id='useremail']"))
		.sendKeys("mdazeem5790@yahoo.com");
		driver.findElement(By.xpath("//*[@for='userpass']/following-sibling::input[@id='userpass']"))
		.sendKeys("Nirvana1$");
		driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
		Thread.sleep(5000);
		WebElement StockEl = driver.findElement(By.xpath("//*[@title='Portfolio']"));
		boolean isPortfolioStockVisible = StockEl.isDisplayed();
		Assert.assertEquals(isPortfolioStockVisible, true);
		logger.info("Clicked on My Portfolio link");
		portfolioTest.log(Status.PASS, "Portfolio validated successfully");
	}
	
	@AfterMethod
	public void tearDown() {
		extent.flush();
		driver.close();
	}
}
