package com.dmg.runner;


import com.dmg.utils.DriverManager;
import com.dmg.utils.ExtentReport;
import com.dmg.utils.GlobalParams;
import com.dmg.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"
                ,"com.cucumber.listener.ExtentCucumberFormatter:"}
        ,features = {"src/test/resources"}
        ,glue = {"com.dmg.automation"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true
        ,strict=true
        ,tags = "@dmgWeb2"

)


public class RunnerTest {


        @BeforeClass
        public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ExtentReport.reportSetup();
      //  ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"+ params.getDeviceName());

     //   new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

        @AfterClass
        public static void quit(){
        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
          //  driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
    }



}
