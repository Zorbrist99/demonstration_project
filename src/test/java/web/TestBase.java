package web;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class TestBase {

    @BeforeAll
    static void beforeAll (){
//        Configuration.holdBrowserOpen=true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://habitica.com/";
        Configuration.browserSize= "1920x1080";

    }
}
