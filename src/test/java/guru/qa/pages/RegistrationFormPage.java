package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.ResultTableComponent;
import guru.qa.pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultsModal = new ResultTableComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            number = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            submitButton = $("#submit");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        number.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        picture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateAndCityComponent
                .setState(state)
                .setCity(city);

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }
}
