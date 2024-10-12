package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class InfiniteScrollPage {
    private SelenideElement textElement = $$("body").find(text("Eius"));

    @Step("Скроллим до элемента")
    public void scrollToElementWithText(String text) {

        while (!textElement.has(text(text))) {
            new Actions(getWebDriver())
                    .sendKeys(Keys.PAGE_DOWN)
                    .perform();
            sleep(500);
            textElement = $$("body").find(text("Eius"));
        }

        textElement.shouldHave(text(text)).shouldBe(Condition.visible);
    }
}