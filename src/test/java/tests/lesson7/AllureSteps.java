package tests.lesson7;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureSteps {
    private static final String Repo = "Sinturik/PageObject";

    @Test
    void allureSteps(){
        step("open github", () -> {
            open("https://github.com/");
        });
        step("introduce in the search" + Repo, () -> {
                $(byAttribute("data-unscoped-placeholder","Search GitHub"))
                .val(Repo)
                .pressEnter();
        });
        step("find repo" + Repo, () -> {
                $(".repo-list")
                .should(text(Repo));
        });
        step("click on the link" + Repo, () ->{
            $(byLinkText(Repo))
                    .click();
        });
        step("check for a folder src/test", () ->{
            $(".js-navigation-open.Link--primary")
                    .shouldHave(text("src/test"))
                    .shouldBe(visible);
        });
    }
}
