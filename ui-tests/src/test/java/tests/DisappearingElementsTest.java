package tests;

import org.junit.jupiter.api.RepeatedTest;
import pages.DisappearingElementsPage;
import pages.DisappearingElementsPageAsserts;

import static com.codeborne.selenide.Selenide.open;

public class DisappearingElementsTest extends BaseTest {

    private DisappearingElementsPage disappearingElementsPage;
    private DisappearingElementsPageAsserts disappearingElementsPageAsserts;

    @RepeatedTest(10)
    public void testDisappearingElements() {
        disappearingElementsPage = new DisappearingElementsPage();
        disappearingElementsPageAsserts = new DisappearingElementsPageAsserts(disappearingElementsPage);
        open("/disappearing_elements");

        disappearingElementsPageAsserts.assertElement1IsVisible();
        disappearingElementsPageAsserts.assertElement2IsVisible();
        disappearingElementsPageAsserts.assertElement3IsVisible();
        disappearingElementsPageAsserts.assertElement4IsVisible();
        disappearingElementsPageAsserts.assertElement5IsVisible();
    }
}
