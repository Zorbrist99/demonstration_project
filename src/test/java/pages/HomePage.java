package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {


    private final SelenideElement mainBanner = $(".text-center"),
            allList = $("#intro-signup"),
            bannerAlert = $(".notification-holder"),
            navPanel = $(".navbar"),
            logInViaGoogle = $(".form-group .col-12", 0),
            logInViaApple = $(".form-group .col-12", 1),
            userMenu = $("#menu_collapse .item-user"),
            sectionInUserMenu = $(".user-dropdown", 1),
            addHabit = $("[placeholder='Добавить привычку']"),
            listOfHabits = $(".sortable-tasks"),
            habitSettingsButton = $(".task-dropdown"),
            fieldWithHabitsSettings = $(".task-dropdown .dropdown-menu");


    public HomePage logThroughServices() {
        logInViaGoogle.shouldHave(text("Войти с помощью Google")).shouldBe(visible);
        logInViaApple.shouldHave(text("Войти с помощью Apple")).shouldBe(visible);
        return this;
    }

    public HomePage registrationForm(String value) {
        mainBanner.shouldHave(text(value)).shouldBe(visible);
        return this;
    }


    public HomePage clickOnButton(String key) {
        allList.$(byText(key)).click();
        return this;
    }

    public HomePage checkingAlert(String value) {
        bannerAlert.shouldHave(text(value)).shouldBe(visible);
        return this;
    }

    public HomePage clickNavbar(String value) {
        navPanel.$(byText(value)).click();
        return this;
    }


    public HomePage showUserMenu() {
        userMenu.click();
        return this;
    }

    public HomePage selectSectionInUserMenu(String value) {
        sectionInUserMenu.$(byText(value)).click();
        return this;
    }

    public HomePage addHabit(String value) {
        addHabit.setValue(value).pressEnter();
        return this;
    }

    public HomePage checkingHabitsInList(String value) {
        listOfHabits.shouldHave(text(value)).shouldBe(visible);
        return this;
    }

    public HomePage habitSettings() {
        habitSettingsButton.click();
        return this;
    }

    public HomePage selectFieldFromHabitSettings (String value) {
        fieldWithHabitsSettings.$(byText(value)).click();
        return this;
    }

    public HomePage checkingForAbsenceOfHabitsInList (String value){
        listOfHabits.shouldNotHave(text(value));
        return this;
    }
}