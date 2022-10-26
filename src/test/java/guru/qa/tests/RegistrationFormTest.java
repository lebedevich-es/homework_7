package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class RegistrationFormTest extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker();

    String firstName,
            lastName,
            userEmail,
            gender,
            number,
            day,
            month,
            year,
            subjects,
            hobbies,
            picture,
            currentAddress,
            state,
            city;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        gender = "Male";
        number = faker.phoneNumber().subscriberNumber(10);
        day = format("%02d", faker.number().numberBetween(1, 31)) + "";
        month = "December";
        year = faker.number().numberBetween(1900, 2022) + "";
        subjects = "Maths";
        hobbies = "Music";
        picture = "img.png";
        currentAddress = faker.address().fullAddress();
        state = "NCR";
        city = "Noida";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", format("%s %s", firstName, lastName))
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", format("%s %s,%s", day, month, year))
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", format("%s %s", state, city));
    }
}
