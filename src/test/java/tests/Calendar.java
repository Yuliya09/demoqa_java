package tests;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDay(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__day--017").click();
    }
}
