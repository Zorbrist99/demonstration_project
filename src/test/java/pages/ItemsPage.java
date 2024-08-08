package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ItemsPage {

    private final SelenideElement checkboxQuests = $("[for='quests']"),
            imageFilter = $(".pixel-art", 1),
            informationAboutQuest = $(".quest-combined-content"),
            imageType = $(".item-wrapper"),
            inputSearch = $(".input-search");


    public ItemsPage chooseTypeOfQuest() {
        checkboxQuests.click();
        return this;
    }

    public ItemsPage imageFilter() {
        imageFilter.click();
        informationAboutQuest.shouldHave(text("Дикие пылевые зайцы")).shouldBe(visible);
        return this;
    }

    public ItemsPage imageType() {
        imageType.click();
        informationAboutQuest.shouldHave(text("Дикие пылевые зайцы")).shouldBe(visible);
        return this;
    }

    public ItemsPage searchBox(String value) {
        inputSearch.setValue(value);
        return this;
    }

}
