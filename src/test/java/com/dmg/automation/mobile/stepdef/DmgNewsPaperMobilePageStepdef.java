package com.dmg.automation.mobile.stepdef;

import com.dmg.automation.mobile.pages.DmgNewsPaperPageMobile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DmgNewsPaperMobilePageStepdef {


    DmgNewsPaperPageMobile dmgnewspaperpage = new DmgNewsPaperPageMobile();

    @Given("user navigate to main page")
    public void userNavigateToMainPage() {

        //    dmgnewspaperpage.clickONDenyNotification();

        dmgnewspaperpage.clickOnFailOverDeny();
        dmgnewspaperpage.clickOnContinueButton();


    }


    @Then("user click on newspaper Tab")
    public void userClickOnNewspaperTab() {

    }

    @Then("user scroll down to recent issues")
    public void userScrollDownToRecentIssues() {

        dmgnewspaperpage.scrollTORecentIssues();
    }

    @Then("user scroll right to see more")
    public void userScrollRightToSeeMore() {

        dmgnewspaperpage.swipeRightToSeeMore();
    }

    @Then("user click on see more link")
    public void userClickOnSeeMoreLink() {

        dmgnewspaperpage.clickOnSeeMore();
    }

    @Then("user click on {string} newspaper download button")
    public void userClickOnNewspaperDownloadButton(String date) {

        dmgnewspaperpage.downloadNewspaper(date);
    }

    @Then("user verifies sign in page opened")
    public void userVerifiesSignInPageOpened() {

        dmgnewspaperpage.verifyAndClickOnSignInButton();

    }

    @Then("user click on sign in button")
    public void userClickOnSignInButton() {

        dmgnewspaperpage.verifyAndClickOnSignInButton();

    }

    @Then("user enter {string} and {string} and click sign in")
    public void userEnterAndAndClickSignIn(String uname, String password) {

        dmgnewspaperpage.enterUserNameAndPassword(uname, password);
        dmgnewspaperpage.clickOnSIGNIN();

    }


    @Then("user wait for newspaper to download")
    public void userWaitForNewspaperToDownload() {

        boolean invisibilityOfDownloadButton = dmgnewspaperpage.checkDownloadIsCompleted();

        Assert.assertEquals(true, invisibilityOfDownloadButton);

        System.out.println("Download complete");

    }

    @Then("this is second Test")
    public void thisIsSecondTest() {

    dmgnewspaperpage.clickOnDownloadedNewspaper();

    }


}
