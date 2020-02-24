package core;

import InspiredTesting.AppiumDriver;

import InspiredTesting.SeleniumDriver;

public class BaseClass {

    public static SeleniumDriver SeleniumDriverInstance;
    public static AppiumDriver AppiumDriverInstance;
    private static String _reportDirectory;

    public static void setReportDirectory(String dir) {_reportDirectory = dir;}
    public static String getReportDirectory(){return _reportDirectory;}

    public static String TestName;


}