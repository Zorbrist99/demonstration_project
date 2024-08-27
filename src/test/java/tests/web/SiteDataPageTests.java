package tests.web;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;
import tests.web.pages.AuthPage;
import tests.web.pages.HomePage;
import tests.web.pages.SiteDataPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Tag("web")
@Feature("Проверки раздела Настройки")
public class SiteDataPageTests extends TestBase {

    AuthPage authPage = new AuthPage();
    HomePage homePage = new HomePage();
    SiteDataPage siteDataPage = new SiteDataPage();

    @Test
    @DisplayName("Проверка текста всплывающей подсказки с идентификатором пользователя")
    void verifyUserIdTooltipTextTest() {

        String hintText = "The User ID is a unique number that Habitica automatically generates when a player joins, " +
                "similar to a Username. However, unlike the Username, a User ID can not be changed.";

        step("Авторизуемся в сервисе", () -> {
            authPage.authorizations("beryozkinkonstantin@yandex.ru", "QAguru2024");
        });

        step("Меню пользователя", () -> {
            homePage.showUserMenu();
        });

        step("Перейти в раздел Настройки", () -> {
            homePage.selectSectionInUserMenu("Settings");
        });

        step("Перейти в раздел Данные сайта", () -> {
            siteDataPage.selectingDataSection("Site Data");
        });

        step("Нажать на иконку с подсказкой", () -> {
            siteDataPage.clickOnHintIcon();
        });

        step("Проверяем правильность подсказки", () -> {
            siteDataPage.checkingHint(hintText);
        });
    }
}
