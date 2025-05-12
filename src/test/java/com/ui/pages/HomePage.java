package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.constants.Env.QA;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public HomePage(Browser browserName,boolean isHeadless) {
        super(browserName,isHeadless);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public LoginPage goToLoginPage(){ //Page Functions ------> Void return type cannot be used
        logger.info("Trying to perform click to go to sign In page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
