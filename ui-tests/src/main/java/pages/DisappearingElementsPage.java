package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DisappearingElementsPage {
    public SelenideElement element1 = $("ul > li:nth-child(1)");
    public SelenideElement element2 = $("ul > li:nth-child(2)");
    public SelenideElement element3 = $("ul > li:nth-child(3)");
    public SelenideElement element4 = $("ul > li:nth-child(4)");
    public SelenideElement element5 = $("ul > li:nth-child(5)");


    @Step("Проверяем, виден ли элемент 1")
    public void checkElement1Visibility() {
        element1.shouldBe(Condition.visible);
    }

    @Step("Проверяем, виден ли элемент 2")
    public void checkElement2Visibility() {
        element2.shouldBe(Condition.visible);
    }

    @Step("Проверяем, виден ли элемент 3")
    public void checkElement3Visibility() {
        element3.shouldBe(Condition.visible);
    }

    @Step("Проверяем, виден ли элемент 4")
    public void checkElement4Visibility() {
        element4.shouldBe(Condition.visible);
    }

    @Step("Проверяем, виден ли элемент 5")
    public void checkElement5Visibility() {
        element5.shouldBe(Condition.visible);
    }
}

