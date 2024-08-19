package api.api;

import models.LoginRequestModel;
import models.LoginResponseModel;
import web.TestBase;

import static io.restassured.RestAssured.given;
import static specs.SpecRequest.userRequestSpec;
import static specs.SpecRequest.userResponseSpec;

public class AuthorizationApi extends TestBase {

    public LoginResponseModel login() {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setUsername("beryozkinkonstantin@yandex.ru");
        loginRequestModel.setPassword("QAguru2024");

        return given(userRequestSpec)
                .body(loginRequestModel)

                .when()
                .post("api/v4/user/auth/local/login")

                .then()
                .spec(userResponseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}
