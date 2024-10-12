package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ContextMenuPage {
    private SelenideElement contextMenuArea = $("#hot-spot");

    @Step("Нажимаем правой кнопкой мыши на области контекстного меню")
    public void rightClickOnContextMenu() {
        new Actions(WebDriverRunner.getWebDriver())
                .contextClick(contextMenuArea)
                .perform();
    }

    @Step("Получаем текст JS Alert")
    public String getAlertText() {
        Alert alert = switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
