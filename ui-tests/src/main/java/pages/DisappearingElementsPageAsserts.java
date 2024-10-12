package pages;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DisappearingElementsPageAsserts {

    private DisappearingElementsPage disappearingElementsPage;

    public DisappearingElementsPageAsserts(DisappearingElementsPage disappearingElementsPage) {
        this.disappearingElementsPage = disappearingElementsPage;
    }

    public void assertElement1IsVisible() {
        assertThat(disappearingElementsPage.element1.is(visible))
                .as("Элемент 1 должен быть видим")
                .isTrue();
    }

    public void assertElement2IsVisible() {
        assertThat(disappearingElementsPage.element2.is(visible))
                .as("Элемент 2 должен быть видим")
                .isTrue();
    }

    public void assertElement3IsVisible() {
        assertThat(disappearingElementsPage.element3.is(visible))
                .as("Элемент 3 должен быть видим")
                .isTrue();
    }

    public void assertElement4IsVisible() {
        assertThat(disappearingElementsPage.element4.is(visible))
                .as("Элемент 4 должен быть видим")
                .isTrue();
    }

    public void assertElement5IsVisible() {
        assertThat(disappearingElementsPage.element5.is(visible))
                .as("Элемент 5 должен быть видим")
                .isTrue();
    }
}
