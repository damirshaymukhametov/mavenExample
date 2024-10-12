package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NotificationPage {
    private final SelenideElement clickHereButton = $(By.linkText("Click here"));
    public final SelenideElement notificationMessage = $(By.id("flash"));

    @Step("Нажимаем на кнопку 'Click here'")
    public void clickButton() {
        clickHereButton.click();
    }

    @Step("Получаем текст уведомления")
    public String getNotificationText() {
        notificationMessage.shouldBe(Condition.visible);
        return notificationMessage.getText();
    }

}