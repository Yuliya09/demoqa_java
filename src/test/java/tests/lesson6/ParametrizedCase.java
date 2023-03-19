package tests.lesson6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofMillis;

@DisplayName("добавление косметики в корзину")

public class ParametrizedCase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void precondition() {
        open("https://www.wildberries.ru");
    }

    @AfterEach
    void closedBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"the act скраб", "smorodina гидролат"})
    @ParameterizedTest(name ="Проверка выбора товара \"{0}\"")
    void wildberries(String testData) {
        //ввести в поле поиска товар
        sleep(3000);
        $(byId("searchInput"))
                .shouldBe(visible, ofMillis(1000))
                .sendKeys(testData);
        $(byId("applySearchBtn"))
                .shouldBe(enabled)
                .click();
        //навести курсор на товар для показа кнопки корзина
        $(".product-card__main.j-card-link")
                .hover();
        $(byText("В корзину"))
                .scrollIntoView(true)
                .shouldBe(visible)
                .click();
        }

        //провалиться в корзину, проверить, что товар добавлен

    @Disabled
        @ValueSource(strings = {"the act", "smorodina"})
        @ParameterizedTest(name ="Проверка добавления в корзину \"{0}\"")
        void add_plates (String testData) {
            $(".navbar-pc__icon--basket")
                    .shouldHave(text("Корзина"))
                    .click();
            $(".basket-section__header.active")
                    .shouldHave(text("Корзина"));
            $(".good-info__title.j-product-popup")
                    .shouldHave(text(testData))
                    .shouldBe(visible);
    }
    @Test
    @Disabled ("bug: https://trello.com/c/M5oDdHDP/6-bug-for-test-intellijidea")
    public void basket(){
    }
}
