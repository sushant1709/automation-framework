package com.dmg.utils;

import com.vimalselvam.cucumber.listener.ExtentProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {


    public  static  void reportSetup(){


            ExtentProperties extentProperties = ExtentProperties.INSTANCE;
            String reportPath = "./Target/TestResult/MyOwnReport_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date())+".html";
            extentProperties.setReportPath(reportPath);

    }

}
