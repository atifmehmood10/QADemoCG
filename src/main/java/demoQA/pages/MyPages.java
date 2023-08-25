package demoQA.pages;

import demoQA.DemoQABasePage;
import demoQA.pages.bookStoreApp.*;
import demoQA.pages.borwserInteractionsPage.BrowserInteractionsSubMenu;
import demoQA.pages.borwserInteractionsPage.BrowserWindowsPage;

public class MyPages extends DemoQABasePage{

    public static DemoQAHomePage demoQAHomePage;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static UserHomePage userHomePage;
    public static BookStorePage bookStorePage;
    public static BookDetailsPage bookDetailsPage;
    public static UserBookCollectionPage userBookCollectionPage;
    public static UserProfilePage userProfilePage;
    public static BrowserInteractionsSubMenu browserInteractionsSubMenu;
    public static BrowserWindowsPage browserWindowsPage;


    public static void initializeAllPages(){
        demoQAHomePage = new DemoQAHomePage(getWebDriver());
        homePage = new HomePage(getWebDriver());
        loginPage = new LoginPage(getWebDriver());
        userHomePage = new UserHomePage(getWebDriver());
        bookStorePage = new BookStorePage(getWebDriver());
        bookDetailsPage = new BookDetailsPage(getWebDriver());
        userBookCollectionPage = new UserBookCollectionPage(getWebDriver());
        userProfilePage = new UserProfilePage(getWebDriver());
        browserInteractionsSubMenu = new BrowserInteractionsSubMenu(getWebDriver());
        browserWindowsPage = new BrowserWindowsPage(getWebDriver());
    }

}
