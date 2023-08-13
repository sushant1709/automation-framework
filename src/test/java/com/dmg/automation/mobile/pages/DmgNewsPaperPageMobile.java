package com.dmg.automation.mobile.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class DmgNewsPaperPageMobile extends BasePage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    @iOSXCUITFindBy(id = "")
    private WebElement button_DenyNotification;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@package='com.anmedia.dailymail.kindlefire.uat'][@index='1'][@clickable='true']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_FailoverDeny;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_Continue;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Newspaper']/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private WebElement tab_Newspaper;

    @AndroidFindBy(xpath = "//*[@text='Recent Specials']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement label_RecentIssues;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SEE MORE']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement link_SeeMore;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='7 August 2023']/following-sibling::android.view.ViewGroup/android.view.ViewGroup)[1]")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_downloadNewsPaper;

    @AndroidFindBy(xpath = "//*[@text='Sign in']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_SignIn;

    @AndroidFindBy(xpath = "//*[@resource-id='login.email']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement input_EmailId;

    @AndroidFindBy(xpath = "//*[@resource-id='login.password']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement input_Password;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=' SIGN IN']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_App_SignIN;

    @AndroidFindBy(xpath = "//*[@content-desc='Tap me to get out of the reader']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_OutOFReader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7 August 2023']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement label_downloadedNewspaper;


    @AndroidFindBy(xpath = "//*[@text='Close']/../preceding-sibling::android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private WebElement label_PhotoCount;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_Close;




    public void clickONDenyNotification() {

        click(button_DenyNotification);
        //   Sleep(5);


    }

    public void clickOnFailOverDeny() {

        click(button_FailoverDeny);
        Sleep(3);
    }

    public void clickOnContinueButton() {

        click(button_Continue);
        Sleep(2);
        click(button_Continue);
        Sleep(2);
        click(button_Continue);
        Sleep(2);
        click(button_Continue);
        Sleep(2);
        click(button_Continue);
        Sleep(5);


    }

    public void scrollTORecentIssues() {

        scrollForMobile1(label_RecentIssues, ScrollDirection.DOWN,0.8);
        Sleep(5);

    }

    public void swipeRightToSeeMore() {

        scrollForMobile1(link_SeeMore, ScrollDirection.RIGHT,0.2);
        Sleep(2);
    }

    public void clickOnSeeMore() {
        click(link_SeeMore);
        Sleep(5);
    }

    public void downloadNewspaper(String date) {

        click(button_downloadNewsPaper);
        Sleep(5);

    }

    public void verifyAndClickOnSignInButton() {
        click(button_SignIn);
        Sleep(10);
    }

    public void enterUserNameAndPassword(String username, String password) {

        clear(input_EmailId);
        Sleep(2);
        sendKeys(input_EmailId, username);
        Sleep(2);
        sendKeys(input_Password, password);
        Sleep(2);
    }


    public void clickOnSIGNIN() {

        click(button_App_SignIN);
        Sleep(5);
    }

    public boolean checkDownloadIsCompleted(){

        click(button_OutOFReader);
        Sleep(30);
        return invisibilityOFElement(button_downloadNewsPaper);
    }

    public void clickOnDownloadedNewspaper(){

        click(label_downloadedNewspaper);
        Sleep(5);
        scroll(ScrollDirection.RIGHT,0.15);
        utils.log().info("Scrolled right 1");
        Sleep(5);
        scroll(ScrollDirection.RIGHT,0.15);
        utils.log().info("Scrolled right 2");

        Sleep(10);
        utils.log().info("waiting for tap");
        tap(0.85,0.5);
      //  tap(0.90,0.5);
        Sleep(10);

        utils.log().info("waiting for photo to open");
        tap(0.5,0.2);

        utils.log().info("Scrolled right 1");

        Sleep(5);

        int NoOfPhoto = Integer.parseInt(label_PhotoCount.getText().split(" of ")[1]);


        for(int i=1; i<NoOfPhoto-1;i++){

            scroll(ScrollDirection.RIGHT,0.1);
            Sleep(1);
        }

        Sleep(5);
        click(button_Close);





    }
}
