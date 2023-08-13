package com.dmg.automation.web.stepdef;

import com.dmg.automation.web.pages.DmgNewsPaperPageWeb;
import com.dmg.utils.PropertyManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;

public class DmgNewspaperWebPageStepdef {




    DmgNewsPaperPageWeb dmgWebPage = new DmgNewsPaperPageWeb();

    @Given("User navigate to Daily mail Video Page")
    public void userNavigateToDailyMailVideoPage() {

      dmgWebPage.openMailOnlinePage();
    }
    @Then("User accepts cookies")
    public void userAcceptsCookies() {
        dmgWebPage.acceptCookies();
    }
    @Then("User Click on Video in page to begin playback")
    public void userClickOnVideoInPageToBeginPlayback() {
        dmgWebPage.clickOnPlayVideoButton();
        System.out.println(dmgWebPage.getVideoTitle());
    }
    @Then("Click the video again to pause playback")
    public void clickTheVideoAgainToPausePlayback() {
        dmgWebPage.clickOnPausedButton();
        System.out.println(dmgWebPage.getVideoTitle());

    }
    @Then("Click on the forward arrow to change to the next video")
    public void clickOnTheForwardArrowToChangeToTheNextVideo() {

        String currentVideoTitle = dmgWebPage.getVideoTitle();
        dmgWebPage.clickOnForwardArrow();
        String nextVideoTitle = dmgWebPage.getVideoTitle();

        Assert.assertNotEquals(currentVideoTitle,nextVideoTitle);

    }
    @Then("Click on the back arrow to navigate to the previous video")
    public void clickOnTheBackArrowToNavigateToThePreviousVideo() {

        String currentVideoTitle = dmgWebPage.getVideoTitle();
        dmgWebPage.clickOnBackArrow();
        String nextVideoTitle = dmgWebPage.getVideoTitle();
        Assert.assertNotEquals(currentVideoTitle,nextVideoTitle);

    }
    @Then("Click on the speaker icon to mute the video")
    public void clickOnTheSpeakerIconToMuteTheVideo() {

        dmgWebPage.clickOnSpeakerToMute();
    }
    @Then("Click on the speaker icon again to unmute the video")
    public void clickOnTheSpeakerIconAgainToUnmuteTheVideo() {

        dmgWebPage.clickOnSpeakerMuteButton();

    }
    @Then("When video is finished, next video should autoplay")
    public void whenVideoIsFinishedNextVideoShouldAutoplay() {

        dmgWebPage.verifyNExtVideoAutoplay();

    }


// **********************************************************************************



    @Then("Click on Sport menu and scroll down to the Premier League table")
    public void clickOnSportMenuAndScrollDownToThePremierLeagueTable() {

        dmgWebPage.clickOnSportsTabAnsScrollToPremierLeagueTable();
    }
    @Then("Click on the View all tables")
    public void clickOnTheViewAllTables() {

    }
    @Then("Retrieve the Pos, PTS for the given team {string}")
    public void retrieveThePosPTSForTheGivenTeam(String teamName) {

        String point =dmgWebPage.retrievePointForTeam(teamName);
        System.out.println("Point for "+teamName+ " : "+ point);
        String position = dmgWebPage.retrievePositionForTeam(teamName);
        System.out.println("Position for team "+teamName +" : "+position);
    }

}
