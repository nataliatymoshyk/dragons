package com.dragons;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by natalia on 8/22/18.
 */
public class WebDriverFactory implements WebDriverProvider {

        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1280,720");
            return new ChromeDriver(options);
        }
}
