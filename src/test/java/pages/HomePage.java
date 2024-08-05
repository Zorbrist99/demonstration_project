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
            logInViaApple = $(".form-group .col-12", 1);


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
}
