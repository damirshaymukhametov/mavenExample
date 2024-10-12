package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DropdownPageAsserts {

    private DropdownPage dropdownPage;

    public DropdownPageAsserts(DropdownPage dropdownPage) {
        this.dropdownPage = dropdownPage;
    }

    public void assertSelectedOptionIs(String expectedText) {
        String actualText = dropdownPage.getSelectedOptionText().getText();
        assertThat(actualText)
                .as("Ожидаемая опция: " + expectedText + ", фактическая опция: " + actualText)
                .isEqualTo(expectedText);
    }
}
