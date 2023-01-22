package tests;

import com.codeborne.selenide.Configuration;

public class TestBaseQA {
    static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    //Configuration.browserSize = "1920x1080";
    }
}
