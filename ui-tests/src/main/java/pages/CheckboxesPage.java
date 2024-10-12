package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$;

public class CheckboxesPage {
    private SelenideElement firstCheckbox = $("#checkboxes > input[type=checkbox]:nth-child(1)");
    private SelenideElement secondCheckbox = $("#checkboxes > input[type=checkbox]:nth-child(3)");

    @Step("Выбираем первый чекбокс")
    public void selectFirstCheckbox() {
        if (!firstCheckbox.isSelected()) {
            firstCheckbox.click();
            firstCheckbox.shouldBe(checked);
        }
    }

    @Step("Снимаем выбор со второго чекбокса")
    public void deselectSecondCheckbox() {
        if (secondCheckbox.isSelected()) {
            secondCheckbox.click();
            secondCheckbox.shouldNotBe(checked);
        }
    }

    @Step("Проверяем, что первый чекбокс выбран")
    public boolean isFirstCheckboxChecked() {
        return firstCheckbox.isSelected();
    }

    @Step("Проверить, что второй чекбокс выбран")
    public boolean isSecondCheckboxChecked() {
        return secondCheckbox.isSelected();
    }
}
