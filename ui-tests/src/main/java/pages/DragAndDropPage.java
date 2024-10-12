package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class DragAndDropPage {
    private SelenideElement elementA = $("#column-a");
    private SelenideElement elementB = $("#column-b");

    @Step("Перетаскиваем элемент A на элемент B")
    public void dragAndDropElementAtoB() {
        int elementALocationX = elementA.getLocation().getX();
        int elementALocationY = elementA.getLocation().getY();

        int elementBLocationX = elementB.getLocation().getX();
        int elementBLocationY = elementB.getLocation().getY();

        int offsetX = elementBLocationX - elementALocationX;
        int offsetY = elementBLocationY - elementALocationY;

        new Actions(WebDriverRunner.getWebDriver())
                .moveToElement(elementA)
                .clickAndHold()
                .moveByOffset(offsetX, offsetY)
                .release()
                .perform();

        sleep(500);
    }

    @Step("Проверяем, что элемент A теперь содержит текст B")
    public boolean isElementAContainsTextB() {
        return elementA.getText().trim().equals("B");
    }

    @Step("Проверяем, что элемент B теперь содержит текст A")
    public boolean isElementBContainsTextA() {
        return elementB.getText().trim().equals("A");
    }
    /*@Step("Перетаскиваем элемент A на элемент B")  // точно работающий метод
    public void dragAndDropElementAtoB() {
        elementA.dragAndDropTo(elementB);
    }*/
}