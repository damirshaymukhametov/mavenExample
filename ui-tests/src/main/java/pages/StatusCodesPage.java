package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StatusCodesPage {
    private final SelenideElement statusCodesLink = $(By.linkText("Status Codes"));

    @Step("Открываем страницу со статусами кодов")
    public void open() {
        statusCodesLink.click();
    }

    @Step("Получаем ссылку на статус код {statusCode}")
    public SelenideElement getStatusLink(int statusCode) {
        SelenideElement link = $(By.linkText(String.valueOf(statusCode)));
        link.shouldBe(visible);
        return link;
    }
}
