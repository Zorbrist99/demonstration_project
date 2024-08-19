package api;


import io.qameta.allure.Feature;
import models.BadRequestLoginResponseModel;
import models.LoginRequestModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.TestBase;


import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.SpecRequest.userRequestSpec;
import static specs.SpecRequest.userResponseSpec;

@Tag("api")
@Feature("Проверка авторизации")
public class LoginTests extends TestBase {

    LoginRequestModel loginRequestModel = new LoginRequestModel();

    @Test
    @DisplayName("Выполнение успешного запроса на вход в систему")
    void successfulLoginTest() {
        loginRequestModel.setUsername("beryozkinkonstantin@yandex.ru");
        loginRequestModel.setPassword("QAguru2024");


        LoginResponseModel response = step("POST.Авторизация на ресурсе", () ->
                given(userRequestSpec)
                        .body(loginRequestModel)

                        .when()
                        .post("api/v4/user/auth/local/login")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(200)
                        .extract().as(LoginResponseModel.class));


        step("Пользователь авторизован", () -> {
            assertTrue(response.getSuccess());
            assertEquals("Sergey_01", response.getData().getUsername());
        });
    }


    @Test
    @DisplayName("Выполнение неудачного запроса на вход в систему с пустым паролем")
    void loginWithEmptyPasswordTest() {
        loginRequestModel.setUsername("beryozkinkonstantin@yandex.ru");

        BadRequestLoginResponseModel response = step("POST.Авторизация на ресурсе", () ->
                given(userRequestSpec)
                        .body(loginRequestModel)


                        .when()
                        .post("api/v4/user/auth/local/login")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(400)
                        .extract().as(BadRequestLoginResponseModel.class));

        step("Пользователь не авторизован. Введите пароль", () -> {
            assertEquals("Missing password.", response.getErrors().get(0).getMessage());
        });
    }


    @Test
    @DisplayName(" Выполнение запроса на вход в систему с пустым телом")
    void loginWithEmptyBody() {
        BadRequestLoginResponseModel response = step("POST.Авторизация на ресурсе", () ->
                given(userRequestSpec)
                        .body("")


                        .when()
                        .post("api/v4/user/auth/local/login")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(400)
                        .extract().as(BadRequestLoginResponseModel.class));

        step("Пользователь не авторизован. Введите логин и пароль", () -> {
            assertEquals("Missing password.", response.getErrors().get(1).getMessage());
            assertEquals("Missing username or email.", response.getErrors().get(0).getMessage());
        });
    }
}
