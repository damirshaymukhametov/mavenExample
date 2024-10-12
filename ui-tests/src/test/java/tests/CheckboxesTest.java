package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckboxesPage;
import pages.CheckboxesPageAsserts;

import static com.codeborne.selenide.Selenide.open;

public class CheckboxesTest extends BaseTest {

    private CheckboxesPage checkboxesPage;
    private CheckboxesPageAsserts checkboxesPageAsserts;

    @ParameterizedTest
    @ValueSource(strings = {"firstFirst", "secondFirst"})
    public void testCheckboxes(String order) {
        checkboxesPage = new CheckboxesPage();
        checkboxesPageAsserts = new CheckboxesPageAsserts(checkboxesPage);
        open("/checkboxes");

        if ("firstFirst".equals(order)) {
            checkboxesPage.selectFirstCheckbox();
            checkboxesPage.deselectSecondCheckbox();
        } else {
            checkboxesPage.deselectSecondCheckbox();
            checkboxesPage.selectFirstCheckbox();
        }

        if ("firstFirst".equals(order)) {
            checkboxesPageAsserts.assertFirstCheckboxIsChecked();
            checkboxesPageAsserts.assertSecondCheckboxIsNotChecked();
        } else {
            checkboxesPageAsserts.assertFirstCheckboxIsNotChecked();
            checkboxesPageAsserts.assertSecondCheckboxIsChecked();
        }
    }
}