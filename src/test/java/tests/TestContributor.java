package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestContributor {
    @Test
    void andreiSolntsevShouldBeTheMainContributor() {
        // открыть страничку репозитория Селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому элементу в области Contributors
        $(".Layout-sidebar").$(withText("Contributors"))
                .closest(".BorderGrid-row").$("ul li").hover();

        // check: в появившемся окошке (оверлей) текст Andrei Solntsev
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    }
}
