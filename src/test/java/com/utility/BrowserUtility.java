package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver){
        super();
        this.driver.set(driver);//Initialize the Instance Variable Driver
    }

    public BrowserUtility(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
        }
        else  if(browserName.equalsIgnoreCase("edge")){
            driver.set(new EdgeDriver());
        }
        else {
            System.err.println("Invalid Browser Name.... Please Select Chrome or Edge Only");
        }
    }

    public BrowserUtility(Browser browserName){
        logger.info("Launching Browser for " + browserName);
        if(browserName == Browser.CHROME){
            driver.set(new ChromeDriver());
        }
        else  if(browserName == Browser.EDGE){
            driver.set(new EdgeDriver());
        }
        else  if(browserName == Browser.FIREFOX){
            driver.set(new FirefoxDriver());
        }
        else {
            System.err.println("Invalid Browser Name.... Please Select Chrome or Edge Only");
        }
    }

    public BrowserUtility(Browser browserName,boolean isHeadless){
        if(browserName == Browser.CHROME ){
            if(isHeadless){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");//Ensure driver launches in headless mode
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
            driver.set(new ChromeDriver(options));
            }
            else {
                driver.set(new ChromeDriver());
            }
        }
        else  if(browserName == Browser.EDGE){
            if(isHeadless){
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(options));
            }
            else {
                driver.set(new EdgeDriver());
            }
        }
        else  if(browserName == Browser.FIREFOX){
            if(isHeadless){
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");
                driver.set(new FirefoxDriver(options));
            }
            else {
                driver.set(new FirefoxDriver());
            }

        }
        else {
            System.err.println("Invalid Browser Name.... Please Select Chrome or Edge Only");
        }
    }

    public void goToWebsite(String url){
        logger.info("Visiting the Website " + url);
        driver.get().get(url);
    }

    public void maximizeWindow(){
        logger.info("Maximizing the Browser Window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator){
        logger.info("Element found with locator" + locator);
        WebElement element = driver.get().findElement(locator);//Finds The Element
        logger.info("Element found and now performing click " + locator);
        element.click();
    }

    public void enterText(By locator,String text){
        logger.info("Element found with locator" + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element found and now Entering text " + text);
        element.sendKeys(text);
    }



    public String getVisibleText(By locator){
        logger.info("Element found with locator" + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element found and now returning the visible text " + element.getText());
        return element.getText();
    }


    public String takeScreenShot(String name){
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " +"timeStamp" +".png";
        File screeshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData,screeshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;
    }

    public void quitDriver(){
        driver.get().quit();
    }

}
