package com.dragons;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.dragons.WebDriverFactory;
import org.junit.After;
import org.junit.BeforeClass;

/**
 * Created by natalia on 8/22/18.
 */
public class BaseTest {

    @BeforeClass
    public static void init() {
        Configuration.baseUrl = "https://en.wikipedia.org/wiki/";
        Configuration.timeout = 4000;
        Configuration.browser = WebDriverFactory.class.getName();

    }

    @After
    public void finish() {
        Selenide.close();
    }
}
