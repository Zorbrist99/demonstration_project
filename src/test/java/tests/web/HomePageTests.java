package tests.web;


import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.pages.HomePage;

import static com.codeborne.selenide.Selenide.*;


@Tag("web")
@Feature("Проверки страницы авторизации")
public class HomePageTests extends TestBase {


    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка страницы регистрации")
    void checkHomePageTitleTest() {
        open("");
        homePage.registrationForm("Sign Up For Free");
    }

    @Test
    @DisplayName("Проверка алерта при регистрации с пустыми полями")
    void checkingAlertWhenRegisteringWithEmptyFieldsTest() {
        open("");
        homePage.clickOnButton("Sign Up")
                .checkingAlert("Missing username. Missing email. Missing password.");
    }


    @Test
    @DisplayName("Проверка редиректа на страницу авторизации при нажатии на кнопку Вход")
    void checkingRedirectTheRegistrationPageWhenYouClickLoginTest() {
        open("");
        homePage.clickNavbar("Login")
                .logThroughServices();
    }
}
