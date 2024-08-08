package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SiteDataPage {

    private final SelenideElement navigationBar = $(".col"),
            hintIcon = $("#tooltip_userId"),
            windowWithHint = $(".tooltip-inner");


    public SiteDataPage selectingDataSection(String value) {
        navigationBar.$(byText(value)).click();
        return this;
    }

    public SiteDataPage clickOnHintIcon() {
        hintIcon.click();
        return this;
    }

    public SiteDataPage checkingHint(String value) {
        windowWithHint.shouldHave(text(value)).shouldBe(visible);
        return this;
    }
}