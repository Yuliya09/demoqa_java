package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBaseQA {
    @BeforeEach
     void before() {
    Configuration.baseUrl = "https://demoqa.com";
    //Configuration.browserSize = "1920x1080";
    }

    @AfterEach
     void after() {
        closeWebDriver();
    }
}
