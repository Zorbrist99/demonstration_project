package web;


import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.HomePage;
import pages.ItemsPage;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Проверки раздела Инвентарь")
public class ItemsPageTests extends TestBase {

    AuthPage authPage = new AuthPage();
    HomePage homePage = new HomePage();
    ItemsPage itemsPage = new ItemsPage();

    @Test
    @DisplayName("Инвентарь/Предметы. Проверка работы фильтрации по типу")
    void inventoryFilterTypeTest() {


        step("Авторизуемся в сервисе", () -> {
            authPage.authorizations("beryozkinkonstantin@yandex.ru", "QAguru2024");
        });

        step("Переходим в Инвентарь", () -> {
            homePage.clickNavbar("Инвентарь");
        });

        step("Выбираем тип Квесты", () -> {
            itemsPage.chooseTypeOfQuest();
        });

        step("Проверяем что отобразилась правильная карточка", () -> {
            itemsPage.imageType();
        });
    }

    @Test
    @DisplayName("Инвентарь/Предметы. Проверка работы фильтра")
    void inventoryFilterTest() {

        step("Авторизуемся в сервисе", () -> {
            authPage.authorizations("beryozkinkonstantin@yandex.ru", "QAguru2024");
        });

        step("Переходим в Инвентарь", () -> {
            homePage.clickNavbar("Инвентарь");
            sleep(500);
        });

        step("", () -> {
            itemsPage.searchBox("Дикие пылевые зайцы");
        });

        step("Проверяем что отобразилась правильная карточка", () -> {
            itemsPage.imageFilter();
        });

    }

}
