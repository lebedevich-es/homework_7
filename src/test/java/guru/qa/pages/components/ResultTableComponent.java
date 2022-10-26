package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    private SelenideElement
            modalDialog = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            tableResult = $(".table-responsive table");

    public ResultTableComponent checkVisible() {
        modalDialog.should(appear);
        modalTitle.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultTableComponent checkResult(String key, String value) {
        tableResult.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
