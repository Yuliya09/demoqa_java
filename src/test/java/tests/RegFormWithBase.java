package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegFormWithBase extends TestBaseQA {
    @Test
    void successFullTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").val("Dmitriy");
        $("#lastName").val("Muromec");
        $("#userEmail").val("mitya_muromec@zarechye.ru");
        //$(".gender-radio-1").shouldHave(value("Male")).click();
        $(byText("Male")).click();
        $("#userNumber").val("9991891500");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("May");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").val("history").pressEnter();
        $("#subjectsInput").val("biology").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/lesta.jpg"));
        $("#currentAddress").val("Zarechye");
        $("#stateCity-label").scrollTo();
        $(byText("Select State")).click();
        $(byText("Haryana")).scrollTo().click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").pressEnter();

        $(byText("Thanks for submitting the form")).shouldBe(visible);
        $(".table-responsive").shouldHave(text("Dmitriy Muromec"));
        $(".table-responsive").shouldHave(text("mitya_muromec@zarechye.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9991891500"));
        $(".table-responsive").shouldHave(text("17 May,1990"));
        $(".table-responsive").shouldHave(text("History, Biology"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("lesta.jpg"));
        $(".table-responsive").shouldHave(text("Zarechye"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }
}
