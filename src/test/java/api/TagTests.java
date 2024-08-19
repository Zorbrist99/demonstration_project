package api;

import api.api.AuthorizationApi;
import io.qameta.allure.Feature;
import models.AddTagRequestModel;
import models.GetTagsResponseModel;
import models.LoginResponseModel;
import models.TagResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.TestBase;

import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.SpecRequest.userRequestSpec;
import static specs.SpecRequest.userResponseSpec;

@Tag("api")
@Feature("Проверка авторизации")
public class TagTests extends TestBase {

    AuthorizationApi authorizationApi = new AuthorizationApi();
    LoginResponseModel loginResponse = authorizationApi.login();
    AddTagRequestModel addTagRequestModel = new AddTagRequestModel();

    @Test
    @DisplayName("Запрос текущего списка тегов")
    void checkCurrentTagsListTest() {

        GetTagsResponseModel response = step("GET.Получить список тегов", () ->
                given(userRequestSpec)
                        .header("X-Api-User", loginResponse.getData().getId())
                        .header("X-Api-Key", loginResponse.getData().getApiToken())

                        .when()
                        .get("api/v3/tags")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(200)
                        .extract().as(GetTagsResponseModel.class));

        step("Проверить, в списке присутствует ", () -> {
            assertTrue(response.getSuccess());
            assertEquals("Работа", response.getData().get(0).getName());
        });
    }


    @Test
    @DisplayName("Выполнение запроса на удаление тега")
    void deleteExistingTag() {
        addTagRequestModel.setName("Пробный");

        TagResponseModel postResponse = step("POST.Создание нового тега", () ->
                given(userRequestSpec)
                        .body(addTagRequestModel)
                        .contentType("application/json")
                        .header("X-Api-User", loginResponse.getData().getId())
                        .header("X-Api-Key", loginResponse.getData().getApiToken())

                        .when()
                        .post("api/v3/tags")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(201)
                        .extract().as(TagResponseModel.class));


        step("Проверка, новый тег создался", () -> {
            assertTrue(postResponse.getSuccess());
            assertEquals("Пробный", postResponse.getData().getName());
        });

        TagResponseModel deleteResponse = step("DELETE.Удаление созданного тега", () ->
                given(userRequestSpec)
                        .header("X-Api-User", loginResponse.getData().getId())
                        .header("X-Api-Key", loginResponse.getData().getApiToken())


                        .when()
                        .delete("api/v3/tags/" + postResponse.getData().getId())

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(200)
                        .extract().as(TagResponseModel.class));

        step("Проверка, тег удален", () -> {
            assertTrue(deleteResponse.getSuccess());
        });
    }
}
