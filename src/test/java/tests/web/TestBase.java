package tests.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.Attach.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.browser = webConfig.getBrowserName();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.remote = webConfig.getRemoteUrl();

        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://habitica.com/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");
        capabilities.merge(options);

        Configuration.browserCapabilities = capabilities;
    }


    @AfterEach
    public void configurationAfter() {
        screenshotAs("Скрин");
        pageSource();
        browserConsoleLogs();
        addVideo();

        Selenide.closeWebDriver();
    }
}
