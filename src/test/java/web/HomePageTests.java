package web;



import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;


import static com.codeborne.selenide.Selenide.*;


@Tag("web")
@Feature("Проверки страницы авторизации")
public class HomePageTests extends TestBase {

    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка страницы регистрации")
    void checkHomePageTitleTest() {
        open("");
        homePage.registrationForm("Бесплатная регистрация");
    }

    @Test
    @DisplayName("Проверка алерта при регистрации с пустыми полями")
    void checkingAlertWhenRegisteringWithEmptyFieldsTest() {
        open("");
        homePage.clickOnButton("Регистрация")
                .checkingAlert("Отсутствует имя пользователя. Отсутствует адрес электронной почты. Отсутствует пароль.");
    }


    @Test
    @DisplayName("Проверка редиректа на страницу авторизации при нажатии на кнопку Вход")
    void checkingRedirectTheRegistrationPageWhenYouClickLoginTest() {
        open("");
        homePage.clickNavbar("Вход")
                .logThroughServices();
    }
}
