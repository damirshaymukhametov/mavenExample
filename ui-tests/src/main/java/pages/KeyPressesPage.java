package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPage {
    private SelenideElement inputField = $("#target");
    private SelenideElement resultMessage = $("#result");

    @Step("Вводим текст")
    public void enterText(String text) {
        inputField.setValue(text);
    }

    @Step("Нажимаем клавиши")
    public void pressKey(Keys key) {
        inputField.sendKeys(key);
    }

    @Step("Получаем сообщение о результатах")
    public SelenideElement getResultMessageElement() {
        return resultMessage;
    }
}