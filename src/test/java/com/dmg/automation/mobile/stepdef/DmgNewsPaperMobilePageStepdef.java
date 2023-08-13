package com.dmg.automation.mobile.stepdef;

import com.dmg.automation.mobile.pages.DmgNewsPaperPageMobile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DmgNewsPaperMobilePageStepdef {


    DmgNewsPaperPageMobile dmgnewspaperpage = new DmgNewsPaperPageMobile();


    @Given("Launch the app")
    public void launchTheApp() {

        dmgnewspaperpage.clickOnFailOverDeny();
        dmgnewspaperpage.clickOnContinueButton();

    }
    @Then("On Newspaper tab, scroll down to Recent issues and scroll right and tap on `See more` button")
    public void onNewspaperTabScrollDownToRecentIssuesAndScrollRightAndTapOnSeeMoreButton() {

        dmgnewspaperpage.scrollTORecentIssues();
        dmgnewspaperpage.swipeRightToSeeMore();
        dmgnewspaperpage.clickOnSeeMore();
    }
    @Then("On Archive tab, tap to download {string} edition")
    public void onArchiveTabTapToDownloadJuneEdition(String date) {

        dmgnewspaperpage.downloadNewspaper(date);
    }
    @Then("On the paywall carousel, sign with credential provided {string} and {string}")
    public void onThePaywallCarouselSignWithCredentialProvidedAnd(String uname, String password) {

        dmgnewspaperpage.verifyAndClickOnSignInButton();
        dmgnewspaperpage.enterUserNameAndPassword(uname, password);
        dmgnewspaperpage.clickOnSIGNIN();
    }
    @Then("Wait for the edition to download completed")
    public void waitForTheEditionToDownloadCompleted() {

        boolean invisibilityOfDownloadButton = dmgnewspaperpage.checkDownloadIsCompleted();
        Assert.assertEquals(true, invisibilityOfDownloadButton);
        System.out.println("Download complete");
    }



    @Given("User is On the downloaded {string} edition")
    public void userIsOnTheDownloadedJuneEdition(String date) {

        dmgnewspaperpage.clickOnDownloadedNewspaper();

    }
    @Then("Navigate to Page {int} on PDF view")
    public void navigateToPageOnPDFView(int page) {

        dmgnewspaperpage.scrollRightOnNewspaper(page);
    }

    @Then("Tap on the Image Gallery is displayed on top of the ALB page")
    public void tapOnTheImageGalleryIsDisplayedOnTopOfTheALBPage() {

        dmgnewspaperpage.tapOnImageGallaryOnALBPage();
    }
    @Then("Tap on camera icon to open full screen")
    public void tapOnCameraIconToOpenFullScreen() {

        dmgnewspaperpage.tapONCameraIconToOpenFullScreen();
    }
    @Then("Traverse through all gallery images")
    public void traverseThroughAllGalleryImages() {

        dmgnewspaperpage.traverseAllGallaryImage();

    }
    @Then("On last image close the image by clicking on Close button to return to ALB")
    public void onLastImageCloseTheImageByClickingOnCloseButtonToReturnToALB() {

        dmgnewspaperpage.clickOnCloseButton();

    }


}
