package com.dmg.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.IOException;
import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver2) {
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        WebDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();
        ChromeOptions options = new ChromeOptions();



        if (driver == null) {
            try {
                utils.log().info("initializing  driver");
                switch (params.getPlatformName()) {
                    case "Android":
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        utils.log().info("initializing Appium  driver");
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        utils.log().info("initializing  Ios driver");
                        break;

                    case "Web":
                        options.addArguments("--incognito");
                        options.setAcceptInsecureCerts(true);
                        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                        DesiredCapabilities caps = new DesiredCapabilities();
                        caps.setCapability(ChromeOptions.CAPABILITY, options);
                        options.merge(caps);
                        driver = new ChromeDriver(options);
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                }
                if (driver == null) {
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }

}
