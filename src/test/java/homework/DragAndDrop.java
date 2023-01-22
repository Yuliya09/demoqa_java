package homework;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @Test
    void dragAndDropForms() {
        //open
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // drag and drop
        $("#column-a").dragAndDropTo($("#column-b"));

        //check
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        sleep(4000);
    }
}
