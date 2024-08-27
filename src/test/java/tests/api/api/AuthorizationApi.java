package tests.api.api;

import tests.api.TestBaseApi;
import tests.api.models.LoginRequestModel;
import tests.api.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.SpecRequest.userRequestSpec;
import static tests.api.specs.SpecRequest.userResponseSpec;

public class AuthorizationApi extends TestBaseApi {

    public LoginResponseModel login() {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setUsername("beryozkinkonstantin@yandex.ru");
        loginRequestModel.setPassword("QAguru2024");

        return given(userRequestSpec)
                .body(loginRequestModel)

                .when()
                .post("v4/user/auth/local/login")

                .then()
                .spec(userResponseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}
