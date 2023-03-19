package tests.lesson7;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureWebSteps {

    @Step("Open homepage")
    public void openPage() {
        open("https://github.com/");
    }

    @Step("Looking for a repo {repo}")
    public void searchForRepo(String repo) {
        $(byAttribute("data-unscoped-placeholder", "Search GitHub"))
                .val(repo)
                .pressEnter();
    }

    @Step("Check if the repo is found {repo}")
    public void checkRepo(String repo) {
        $(".repo-list")
                .should(text("Sinturik/PageObject"));
    }

    @Step("Open the repo {repo}")
    public void openRepo(String repo) {
        $(byLinkText("Sinturik/PageObject"))
                .click();
    }

    @Step("Checking for link src/test")
    public void checkingLink() {
        //check for a folder src/test
        $(".js-navigation-open.Link--primary")
                .shouldHave(text("src/test"))
                .shouldBe(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
