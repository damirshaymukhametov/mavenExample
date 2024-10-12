package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DropdownPage {
    private SelenideElement dropdown = $("#dropdown");

    @Step("Выбираем опцию по индексу {index}")
    public void selectOptionByIndex(int index) {
        dropdown.selectOption(index);
    }

    @Step("Получаем текст выбранной опции")
    public SelenideElement getSelectedOptionText() {
        return dropdown.$("option:checked");
    }
}
