package com.dmg.automation.mobile.pages;

import com.dmg.utils.DriverManager;

import com.dmg.utils.GlobalParams;
import com.dmg.utils.TestUtils;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.*;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;

import static io.netty.util.internal.PlatformDependent.isAndroid;
import static java.time.Duration.ofMillis;

public class BasePage {

    public WebDriver driver;
    TestUtils utils = new TestUtils();
    GlobalParams params = new GlobalParams();
    public static final Duration TIME = Duration.ofSeconds(60);
    private static Duration SCROLL_DUR = Duration.ofMillis(800);


    public BasePage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForClickable(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TIME);
        wait.until(ExpectedConditions.elementToBeClickable(e));

    }

    public boolean invisibilityOFElement(WebElement e) {

        return new WebDriverWait(driver, TIME).until(ExpectedConditions.invisibilityOf(e));
    }

    public WebElement visibilityOfElement(WebElement e) {

        return new WebDriverWait(driver, TIME)
                .until(ExpectedConditions.visibilityOf(e));
    }


    public void click(WebElement e) {
        waitForClickable(e);
        Sleep(1);
        e.click();
    }

    public String getText(WebElement e){
        return visibilityOfElement(e).getText();
    }

    public void clear(WebElement e) {
        waitForClickable(e);
        e.clear();
    }

    public void sendKeys(WebElement e, String txt) {
        waitForClickable(e);
        e.sendKeys(txt);
    }

    public void Sleep(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollForMobile(WebElement element) {
        String previousPageSource = "";
        while (isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = driver.getPageSource();
            performScroll();
        }

    }

    public void moveToWebElement(WebElement e) {

        waitForClickable(e);
        Actions action = new Actions(driver);
        action.moveToElement(e);
    }

    private boolean isNotEndOfPage(String previousPageSource) {
        return !previousPageSource.equals(driver.getPageSource());
    }

    private static boolean isElementNotEnabled(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }


    private void performScroll() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int endX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.25);

        performScrollUsingSequence(startX, startY, endX, endY);
    }

    private void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) (driver)).perform(Collections.singletonList(sequence));
    }


    public void scrollForMobile1(WebElement element, ScrollDirection SCROLL_DIR, double scroll_ratio) {
        String previousPageSource = "";
        while (isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = driver.getPageSource();
            scroll(SCROLL_DIR, scroll_ratio);
        }
    }


    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }


    public void scroll(ScrollDirection dir, double scrollRatio) {
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = driver.manage().window().getSize();
        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));

        int top = midPoint.y - (int) ((size.height * scrollRatio) * 0.5);
        int bottom = midPoint.y + (int) ((size.height * scrollRatio) * 0.5);
        int left = midPoint.x - (int) ((size.height * scrollRatio) * 0.5);
        int right = midPoint.x + (int) ((size.height * scrollRatio) * 0.5);

        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }

    protected void swipe(Point start, Point end, Duration duration) {

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(input, 0)

                .addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y))
                .addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y))
                .addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) (driver)).perform(Collections.singletonList(sequence));
        ((AppiumDriver) (driver)).perform(ImmutableList.of(sequence));
    }


    ///////////////////////////////////////////////////////////

    public void tap(double xpoint, double ypoint) {
        /*

        value of xpoint and ypoint should be between 0 and 1  in decimal
         */
        Dimension size = driver.manage().window().getSize();

        int x = (int) ((size.width * xpoint));
        int y = (int) ((size.height * ypoint));

        tapAction(x, y);
    }

    public void doubleTap(double xpoint, double ypoint) {
        /*

        value of xpoint and ypoint should be between 0 and 1  in decimal
         */
        Dimension size = driver.manage().window().getSize();
        int x = (int) ((size.width * xpoint) * xpoint);
        int y = (int) ((size.height * ypoint) * ypoint);

        doubleTapAction(x, y);
    }

    private void tapAction(int x, int y) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 1);
        tap.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(100)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) (driver)).perform(Collections.singletonList(tap));
        // ((AppiumDriver)(driver)).perform(Arrays.asList(tap));
    }

    private void doubleTapAction(int x, int y) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 1);
        tap.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(100)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(100)));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(100)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) (driver)).perform(Collections.singletonList(tap));

        // ((AppiumDriver)(driver)).perform(Arrays.asList(tap));
    }


}
