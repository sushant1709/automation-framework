package com.dmg;

import com.dmg.utils.DriverManager;
import com.dmg.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {



        @Before
        public void initialize() throws Exception {

        new VideoManager().startRecording();
    }

        @After
        public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)new DriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        new VideoManager().stopRecording(scenario.getName());

}
}