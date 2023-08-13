package com.dmg.automation.web.pages;

import com.dmg.automation.mobile.pages.BasePage;
import com.dmg.utils.PropertyManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Properties;

public class DmgNewsPaperPageWeb extends BasePage {


    @FindBy(xpath = "//button[text()='Got it']")
    WebElement button_AcceptCookies;

    @FindBy(xpath = "//div[contains(@class,'video-ad-label') and (text()='Advertisement')]")
    WebElement label_VideoAd;

    @FindBy(xpath = "//div[@class='vjs-title-text']/div")
    WebElement button_getVideoTitle;

    @FindBy(xpath = "//div[@class='vjs-big-play-button']")
    WebElement button_bigVideoPlay;

    @FindBy(xpath = "//div[contains(@class,'vjs-play-control') and contains(@class,'paused')]")
    WebElement button_VideoPlay;

    @FindBy(xpath = "//div[contains(@class,'vjs-play-control') and contains(@class,'playing')]")
    WebElement button_VideoPause;

    @FindBy(xpath = "//div[@class='vjs-control-bar']/*[contains(@class,'mol-skip')]")
    WebElement button_NextVideo;

    @FindBy(xpath = "(//div[contains(@class,'mol-previous-control')])[1]")
    WebElement button_PreviousVideo;

    @FindBy(xpath = "//div[@class='vjs-control-bar']/*[contains(@class,'vjs-volume-menu')]")
    WebElement button_Speaker;

    @FindBy(xpath = "//div[@class='vjs-control-bar']/*[contains(@class,'vjs-volume-menu') and (@aria-pressed='true')]")
    WebElement button_SpeakerMute;

    @FindBy(xpath = "//div[@class='vjs-control-bar']/*[contains(@class,'vjs-volume-menu') and (@aria-pressed='false')]")
    WebElement button_SpeakerUnMute;

    @FindBy(xpath = "//div[@class='vjs-control-bar']//div[contains(@class,'vjs-time-controls ')]/div[@class='vjs-duration-display']")
    WebElement label_TimeDuration;

    @FindBy(xpath= "(//div[text()='Skip Ad'])[1]")
    WebElement button_addSkip;


    @FindBy(xpath = "//div[contains(@class ,'page-header')]/ul/li[@class='sport']//a")
    WebElement link_SportTab;

    @FindBy(xpath = "//div[text()='Premier League']")
    WebElement label_PremierLeague;

    @FindBy(id ="closeButton")
    WebElement button_AdClose;


    public WebElement labelTeamPos(String teamName) {

        return driver.findElement(By.xpath("//td[text()='" + teamName + "']/../td[1]"));
    }

    public WebElement labelTeamPoints(String teamName) {

        return driver.findElement(By.xpath("//td[text()='" + teamName + "']/following-sibling::td[contains(@class,'pts')]"));
    }


    Properties props = new PropertyManager().getProps();


    public void openMailOnlinePage() {
        driver.get(props.getProperty("appURL"));

    }

    public boolean checkVideoPlaying() {

        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(button_VideoPlay)).isDisplayed();
    }

    public void acceptCookies() {
        click(button_AcceptCookies);
        Sleep(10);
        click(button_AdClose);
    }

    public void clickOnPlayVideoButton() {

        click(button_bigVideoPlay);
        Sleep(10);
        visibilityOfElement(button_VideoPause).isEnabled();
        System.out.println("video play");
        Sleep(2);

    }

    public void clickOnPausedButton() {

        click(button_VideoPause);
        Sleep(2);
        System.out.println("Video paused");
        visibilityOfElement(button_VideoPlay).isEnabled();
        click(button_VideoPlay);


    }

    public void clickOnForwardArrow() {
        Sleep(2);
        click(button_NextVideo);
     //   waitForAdToComplete();
        System.out.println("video next");

    }


    public String getVideoTitle() {

        return getText(button_getVideoTitle);
    }

    public void clickOnBackArrow() {

        Sleep(5);
        click(button_PreviousVideo);
        click(button_PreviousVideo);
        Sleep(5);
        waitForAdToComplete();
        Sleep(2);
        System.out.println("video previous");


    }

    public void clickOnSpeakerToMute() {

        click(button_Speaker);
        visibilityOfElement(button_SpeakerMute).isEnabled();
        Sleep(5);

    }

    public void clickOnSpeakerMuteButton() {

        click(button_Speaker);
        visibilityOfElement(button_SpeakerUnMute).isEnabled();
        Sleep(5);

    }

    public int getTotalPlayTimeInSec() {

        String second = getText(label_TimeDuration);
        System.out.println("Second :" + second);
        String timeSplit[] = second.split("Duration Time")[1].split(":");
        int total_sec = Integer.parseInt(timeSplit[0].trim()) * 60 + Integer.parseInt(timeSplit[1].trim());

        System.out.println("totalSec :" + total_sec);

        return total_sec;

    }


    public void waitForAdToComplete(){

        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(60));
      wait.until(ExpectedConditions.invisibilityOf(label_VideoAd));

    }


    public void verifyNExtVideoAutoplay() {

        String currentVideoTitle = null;
        String currentvideoTitle2 = null;
        if (invisibilityOFElement(label_VideoAd)) {
            currentVideoTitle = getVideoTitle();
            System.out.println(currentVideoTitle);
            Sleep(getTotalPlayTimeInSec());
            Sleep(2);
            currentvideoTitle2 = getVideoTitle();
            System.out.println(currentvideoTitle2);
        }
        Assert.assertNotEquals(currentVideoTitle, currentvideoTitle2);


    }


    public void clickOnSportsTabAnsScrollToPremierLeagueTable() {

        click(link_SportTab);
        Sleep(5);
        moveToWebElement(label_PremierLeague);
        click(label_PremierLeague);


    }


    public String retrievePointForTeam(String teamName) {

        return getText(labelTeamPoints(teamName));

    }

    public String retrievePositionForTeam(String teamName) {

        return getText(labelTeamPos(teamName));

    }


}
