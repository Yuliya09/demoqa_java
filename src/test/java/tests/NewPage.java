package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NewPage {
    RegistrationPageObjects registrationPageObjects = new RegistrationPageObjects();
    String firstName = "Dmitriy";
    String lastName = "Muromec";
    String emailAddress = "mitya_muromec@zarechye.ru";
    String phoneNumber = "9991891500";
    String currentAddress = "Zarechye";
    String gender = "Male";
    String state = "Haryana";
    String city = "Karnal";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void simpleTest() {
        registrationPageObjects.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(emailAddress)
                .setCurrentAddress(currentAddress)
                .setGender(gender)
                .setBirthDay("17", "May", "1990")
                .setSubjects("history")
                .setSubjects("biology")
                .setHobbies("Sports")
                .setHobbies("Music")
                .downloadPhoto()
                .setStates(state)
                .setCity(city)
                .setSubmitClick();

        registrationPageObjects.checkForm("Student Name",  firstName + " "+lastName)
                .checkForm("Student Email", emailAddress)
                .checkForm("Gender", "Other")
                .checkForm("Mobile", phoneNumber)
                .checkForm("Date of Birth", "17 May,1990")
                .checkForm("Subjects", "History, Biology")
                .checkForm("Hobbies", "Music, Sports")
                .checkForm("Picture", "lesta.jpg")
                .checkForm("Address", currentAddress)
                .checkForm("State and City", "Haryana Karnal");
    }
}
