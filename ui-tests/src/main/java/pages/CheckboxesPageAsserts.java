package pages;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesPageAsserts {

    private CheckboxesPage checkboxesPage;

    public CheckboxesPageAsserts(CheckboxesPage checkboxesPage) {
        this.checkboxesPage = checkboxesPage;
    }

    public void assertFirstCheckboxIsChecked() {
        assertThat(checkboxesPage.isFirstCheckboxChecked())
                .as("Первый чекбокс должен быть выбран")
                .isTrue();
    }

    public void assertSecondCheckboxIsNotChecked() {
        assertThat(checkboxesPage.isSecondCheckboxChecked())
                .as("Второй чекбокс не должен быть выбран")
                .isFalse();
    }

    public void assertSecondCheckboxIsChecked() {
        assertThat(checkboxesPage.isSecondCheckboxChecked())
                .as("Второй чекбокс должен быть выбран")
                .isTrue();
    }

    public void assertFirstCheckboxIsNotChecked() {
        assertThat(checkboxesPage.isFirstCheckboxChecked())
                .as("Первый чекбокс не должен быть выбран")
                .isFalse();
    }
}
