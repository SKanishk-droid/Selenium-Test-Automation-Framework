//package com.ui.tests;
//
//import com.utility.BrowserUtility;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LoginTest {
//
//    public static void main(String[] args) {
//
//        WebDriver wd = new ChromeDriver();//Launch a Browser Window. Browser Session is Created
////        BrowserUtility browserUtility = new BrowserUtility(wd);
//        browserUtility.goToWebsite("http://www.automationpractice.pl/index.php?");
//        browserUtility.maximizeWindow(); //Maximize the Browser Window
//
//        By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");//Informs the Locator
//        WebElement signInLinkWebElement = wd.findElement(signInLinkLocator);//Finds The Element
//        signInLinkWebElement.click();
//
//        By emailTextBoxLocator = By.id("email");
//        browserUtility.enterText(emailTextBoxLocator,"bakckoenfc@gmail.com");
//
//        By passwordTextBoxLocator = By.id("passwd");
//        browserUtility.enterText(passwordTextBoxLocator,"password") ;
//
//        By signInButtonLocator = By.id("SubmitLogin");
//        browserUtility.clickOn(signInButtonLocator);
//
//    }
//}
