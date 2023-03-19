package homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchInfoInGitHub {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }
        @Test
    void searchSelenideWikiSoftAssertions(){
        //open github
        open("/selenide/selenide");
        // check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide/selenide"));
        //select wiki and click
        $("[data-selected-links=\"repo_wiki /selenide/selenide/wiki\"]")
                .shouldBe(text("Wiki")).click();
        //find Soft assertions and click
        $(byText("Soft assertions")).click();
        //find unit5 code
        $ ("#user-content-3-using-junit5-extend-test-class")
                .scrollIntoView(true)
                .parent()
                .shouldHave(text("Using JUnit5 extend test class:"));

    }
}
