package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthPage {

    private final SelenideElement usernameInput = $("#usernameInput"),
            passwordInput = $("#passwordInput"),
            enterButton = $(".btn-info");


    public AuthPage authorizations(String mail, String password) {
        open("login");
        usernameInput.setValue(mail);
        passwordInput.setValue(password);
        enterButton.click();
        return this;
    }

}
