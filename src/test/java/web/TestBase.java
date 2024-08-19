package web;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class TestBase {

    @BeforeAll
    static void beforeAll (){
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://habitica.com/";
        Configuration.browserSize= "1920x1080";
        RestAssured.baseURI="https://habitica.com/";

    }
}
