package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HoversPage {
    private final SelenideElement firstImage = $(By.xpath("//div[@class='figure'][1]"));
    private final SelenideElement secondImage = $(By.xpath("//div[@class='figure'][2]"));
    private final SelenideElement thirdImage = $(By.xpath("//div[@class='figure'][3]"));

    @Step("Наводим курсор на первое изображение")
    public void hoverOverFirstImage() {
        firstImage.hover();
    }

    @Step("Наводим курсор на второе изображение")
    public void hoverOverSecondImage() {
        secondImage.hover();
    }

    @Step("Наводим курсор на третье изображение")
    public void hoverOverThirdImage() {
        thirdImage.hover();
    }

    @Step("Получаем текст из изображения по индексу")
    public String getImageText(int index) {
        switch (index) {
            case 1:
                return firstImage.$(By.tagName("h5")).shouldBe(Condition.visible).getText();
            case 2:
                return secondImage.$(By.tagName("h5")).shouldBe(Condition.visible).getText();
            case 3:
                return thirdImage.$(By.tagName("h5")).shouldBe(Condition.visible).getText();
            default:
                throw new IllegalArgumentException("Invalid image index: " + index);
        }
    }

    public static class HoverTestData {
        private final int imageIndex;
        private final String expectedText;

        public HoverTestData(int imageIndex, String expectedText) {
            this.imageIndex = imageIndex;
            this.expectedText = expectedText;
        }

        public int getImageIndex() {
            return imageIndex;
        }

        public String getExpectedText() {
            return expectedText;
        }
    }
}
