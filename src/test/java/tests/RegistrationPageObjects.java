package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageObjects {
    private Calendar calendar = new Calendar();
    private SelenideElement
            headerTitle = $(".main-header"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            emailAddress = $("#userEmail"),
            phoneNumber = $("#userNumber"),
            currentAddress = $("#currentAddress"),
            dayOfBirh = $("#dateOfBirthInput"),
            gender = $("#genterWrapper"),
            subjects = $("#subjectsInput"),
            hobby = $(".practice-form-wrapper"),
            photo = $("#uploadPicture"),
            state = $(byText("Select State")),
            city = $(byText("Select City")),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");


    public RegistrationPageObjects openPage() {
        open("/automation-practice-form");
        this.headerTitle.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPageObjects setFirstName (String firstName) {
        this.firstName.val(firstName);
        return this;
    }
    public RegistrationPageObjects setLastName (String lastName) {
        this.lastName.val(lastName);
        return this;
    }
    public RegistrationPageObjects setEmailAddress (String emailAddress) {
        this.emailAddress.val(emailAddress);
        return this;
    }

    public RegistrationPageObjects setPhoneNumber (String phoneNumber) {
        this.phoneNumber.val(phoneNumber);
        return this;
    }

    public RegistrationPageObjects setCurrentAddress (String currentAddress) {
        this.currentAddress.val(currentAddress);
        return this;
    }

    public RegistrationPageObjects setBirthDay(String day, String month, String year) {
        dayOfBirh.click();
        calendar.setDay(day, month, year);
        return this;
    }

    public RegistrationPageObjects setGender(String gender) {
        this.gender.$(byText(gender)).click();
        return this;
    }
    public RegistrationPageObjects setSubjects(String subjects) {
        this.subjects.val(subjects).pressEnter();
        return this;
    }
    public RegistrationPageObjects setHobbies(String hobby) {
        this.hobby.$(byText (hobby)).click();
        return this;
    }
    public RegistrationPageObjects downloadPhoto() {
        this.photo.uploadFile(new File("src/test/java/resources/lesta.jpg"));
        return this;
    }
    public RegistrationPageObjects setStates(String state) {
        $("#stateCity-label").scrollTo();
        this.state.click();
        $(byText(state)).click();
        return this;
    }
    public RegistrationPageObjects setCity(String city) {
        this.city.click();
        $(byText(city)).click();
        return this;
    }
    public RegistrationPageObjects setSubmitClick() {
        this.submitClick.click();
        return this;
    }

    public RegistrationPageObjects checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}
