package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private  Driver(){

    }
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null) {
            String browser=ConfigurationReader.getProperty("browser");

            switch (browser){  // in cucumber strings doesnt accept lower language so ı should plug higher level
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\TOSHIBA\\IdeaProjects\\cybertek18-cucumber-junit\\webdriver.chrome.driver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\TOSHIBA\\IdeaProjects\\cybertek18-cucumber-junit\\webdriver.geckodriver.driver.exe");
                    driver = new FirefoxDriver();

                case "chrome-headless":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver.exe");
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\TOSHIBA\\IdeaProjects\\cybertek18-cucumber-junit\\webdriver.geckodriver.driver.exe");
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
            }
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}
