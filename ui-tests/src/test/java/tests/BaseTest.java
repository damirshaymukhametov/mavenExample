package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.AppConfig;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    private static final AppConfig config = ConfigFactory.create(AppConfig.class);

    @BeforeEach
    public void setUp() throws IOException {
        Configuration.remote = "http://selenoid:4444/wd/hub";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = config.baseUrl();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
