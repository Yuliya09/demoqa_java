package tests.lesson6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class Base {
    @BeforeAll
    static void before() {
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.browserSize = "1920x1080";
        zoom(0.8);
    }

    @AfterAll
    static void after() {
        closeWebDriver();
    }
}
