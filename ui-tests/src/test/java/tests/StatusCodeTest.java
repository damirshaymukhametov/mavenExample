package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.StatusCodesPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class StatusCodeTest extends BaseTest {
    private final StatusCodesPage statusCodesPage = new StatusCodesPage();

    @Test
    public void testStatusCode200() {
        open(baseUrl);
        statusCodesPage.open();

        statusCodesPage.getStatusLink(200).click();
        $("body").shouldHave(text("This page returned a 200 status code"));
    }

    @Test
    public void testStatusCode301() {
        open(baseUrl);
        statusCodesPage.open();

        statusCodesPage.getStatusLink(301).click();
        $("body").shouldHave(text("This page returned a 301 status code"));
    }

    @Test
    public void testStatusCode404() {
        open(baseUrl);
        statusCodesPage.open();

        statusCodesPage.getStatusLink(404).click();
        $("body").shouldHave(text("This page returned a 404 status code"));
    }

    @Test
    public void testStatusCode500() {
        open("baseUrl");
        statusCodesPage.open();

        statusCodesPage.getStatusLink(500).click();
        $("body").shouldHave(text("This page returned a 500 status code"));
    }
}