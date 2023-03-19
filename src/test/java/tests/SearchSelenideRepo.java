package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {
    @Test
    void shouldFindSelenideInGithub() {
        // open github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и press Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // check: selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
    }

}
