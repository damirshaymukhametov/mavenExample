package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRemoveElementsPage {

    private final SelenideElement addElementButton = $("#content > div > button");
    private final ElementsCollection deleteButtons = $$("button[onclick='deleteElement()']");

    @Step("Нажимаем кнопку 'Add Element'")
    public void clickAddElement() {
        addElementButton.click();
    }

    @Step("Получаем список кнопок 'Delete'")
    public ElementsCollection getDeleteButtons() {
        return deleteButtons;
    }

    @Step("Получаем текст кнопки 'Delete'")
    public String getDeleteButtonText(SelenideElement button) {
        return button.getText();
    }

    @Step("Выводим текущее количество и текст оставшихся кнопок 'Delete'")
    public void printRemainingDeleteButtons() {
        ElementsCollection remainingButtons = getDeleteButtons();
        System.out.println("Оставшиеся кнопки Delete: " + remainingButtons.size());
        remainingButtons.forEach(button -> System.out.println("Кнопка: " + button.getText()));
    }
}