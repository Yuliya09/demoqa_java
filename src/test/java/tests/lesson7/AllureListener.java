package tests.lesson7;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureListener {
    @Test
    void test_allure_listener(){

        SelenideLogger.addListener("allur", new AllureSelenide());
        //open github
        open("https://github.com/");
        //introduce in the search
        $(byAttribute("data-unscoped-placeholder","Search GitHub"))
                .val("javafaker")
                .pressEnter();
        //find Sinturik/PageObject
        $(".repo-list")
                .should(text("Sinturik/PageObject"));
        //click on the link
        $(byLinkText("Sinturik/PageObject"))
                .click();
        //check for a folder src/test
        $(".js-navigation-open.Link--primary")
                .shouldHave(text("src/test"))
                .shouldBe(visible);
    }
}
