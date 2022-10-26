package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    private SelenideElement
            state = $("#state"),
            city = $("#city");

    public StateAndCityComponent setState(String value) {
        state.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public StateAndCityComponent setCity(String value) {
        city.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }
}

