package tests;

import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.DropdownPageAsserts;

import static com.codeborne.selenide.Selenide.open;

public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;
    private DropdownPageAsserts dropdownPageAsserts;

    @Test
    public void testDropdownOptions() {
        dropdownPage = new DropdownPage();
        dropdownPageAsserts = new DropdownPageAsserts(dropdownPage);
        open("/dropdown");

        dropdownPage.selectOptionByIndex(1);
        dropdownPageAsserts.assertSelectedOptionIs("Option 1");

        dropdownPage.selectOptionByIndex(2);
        dropdownPageAsserts.assertSelectedOptionIs("Option 2");
    }
}
