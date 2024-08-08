package web;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.HomePage;
import pages.SiteDataPage;

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

        String hintText = "ID Пользователя это уникальный номер, который генерирует Habitica, " +
                "когда игрок присоединяется, подобно Имени Пользователя. " +
                "Однако, в отличие от Имени Пользователя, ID Пользователя нельзя изменить.";

        step("Авторизуемся в сервисе", () -> {
            authPage.authorizations("beryozkinkonstantin@yandex.ru", "QAguru2024");
        });

        step("Меню пользователя", () -> {
            homePage.showUserMenu();
        });

        step("Перейти в раздел Настройки", () -> {
            homePage.selectSectionInUserMenu("Настройки");
        });

        step("Перейти в раздел Данные сайта", () -> {
            siteDataPage.selectingDataSection("Данные Сайта");
        });

        step("Нажать на иконку с подсказкой", () -> {
            siteDataPage.clickOnHintIcon();
        });

        step("Проверяем правильность подсказки", () -> {
            siteDataPage.checkingHint(hintText);
        });
    }
}
