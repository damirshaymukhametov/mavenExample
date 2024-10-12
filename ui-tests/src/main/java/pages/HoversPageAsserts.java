package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HoversPageAsserts {

    private final HoversPage hoversPage;

    public HoversPageAsserts(HoversPage hoversPage) {
        this.hoversPage = hoversPage;
    }

    public void assertImageTextIs(int index, String expectedText) {
        String actualText = hoversPage.getImageText(index);
        assertThat(actualText)
                .as("Текст изображения с индексом " + index + " должен совпадать с ожидаемым текстом")
                .isEqualTo(expectedText);
    }
}
