package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputsPageAsserts {

    private InputsPage inputsPage;

    public InputsPageAsserts(InputsPage inputsPage) {
        this.inputsPage = inputsPage;
    }

    public void assertInputFieldValueIs(String expectedValue) {
        String actualValue = inputsPage.inputField.getValue();
        assertThat(actualValue)
                .as("Ожидаемое значение в поле ввода: " + expectedValue + ", фактическое значение: " + actualValue)
                .isEqualTo(expectedValue);
    }

    public void assertInputFieldIsEmpty() {
        String actualValue = inputsPage.inputField.getValue();
        assertThat(actualValue)
                .as("Поле ввода должно быть пустым")
                .isEmpty();
    }
}
