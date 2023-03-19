package tests.lesson7;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestAllure {
   /* @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.vogue.com/";
    }*/
    @Test
    void test_allure(){

            /*open vogue
            open("https://www.vogue.com/");
            //select menu
            $(byText("Culture"))
                    .shouldBe(visible)
                    .click();
            //select News
            $$(".SectionTitleHed-hYUwsC.iaODud.fYnLST.hweCum")
                    .findBy(text("News"))
                    .scrollIntoView(true)
                    .shouldBe(visible);
            //select first news
            $(".AspectRatioContainer-dhongk.jbfciB")
                    .shouldBe(visible)
                    .click();*/
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
