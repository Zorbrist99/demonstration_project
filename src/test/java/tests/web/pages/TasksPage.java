package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TasksPage {

    private final SelenideElement nameField = $("[placeholder='Add a title']"),
            theHabitEditingWindow = $("#task-modal___BV_modal_header_");


    public TasksPage clearNameField() {
        nameField.clear();
        return this;
    }

    public TasksPage registerNewNameForHabit(String value) {
        nameField.setValue(value);
        return this;
    }

    public TasksPage clickOnSaveButton(String value) {
        theHabitEditingWindow.$(byText(value)).click();
        return this;
    }
}
