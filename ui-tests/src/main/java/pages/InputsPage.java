package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class InputsPage {
    public SelenideElement inputField = $("input[type='number']");

    @Step("Вводим случайное число {number} в поле ввода")
    public void enterRandomNumber(int number) {
        inputField.clear();
        inputField.sendKeys(String.valueOf(number));
    }

    @Step("Вводим недопустимый ввод '{input}' в поле ввода")
    public void enterInvalidInput(String input) {
        inputField.clear();
        inputField.sendKeys(input);
    }
}
