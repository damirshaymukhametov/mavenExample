package tests;

import org.junit.jupiter.api.Test;
import pages.InfiniteScrollPage;

import static com.codeborne.selenide.Selenide.open;

public class InfiniteScrollTest extends BaseTest {

    @Test
    public void testInfiniteScroll() {
        open("/infinite_scroll");

        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage();
        infiniteScrollPage.scrollToElementWithText("Eius");
    }
}