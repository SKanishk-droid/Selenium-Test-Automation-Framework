//package com.ui.tests;
//
//import static com.constants.Browser.*;
//import com.ui.pages.HomePage;
//import static org.testng.Assert.*;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class LoginTest3 {
//    /*
//    *Writing Good Tests
//    * 1.) Test Script Small!!
//    * 2.) You cannot have conditional statements,loops,try-catch in your test method
//    * TestScripts ----> Test Steps
//    * 3.) Reduce the use of Local Variables
//    * 4.) Atleast One Assertion!!!
//    * */
//
//    HomePage homePage;
//
//    @BeforeMethod(description = "Load the Homepage of the website")
//    public void setup(){
//        homePage = new HomePage(EDGE);
//    }
//
//    @Test(description = "Verifies if the valid user is able to log into the application",groups = {"e2e","sanity"})
//    public void loginTest() {
//        assertEquals(homePage.goToLoginPage().doLoginWith("javafo8487@noroasis.com", "password").getUserName(),"Kanishk Shukla");
//    }
//}
