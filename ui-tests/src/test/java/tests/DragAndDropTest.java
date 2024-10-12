package tests;

import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DragAndDropTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        open("/drag_and_drop");

        DragAndDropPage dragAndDropPage = new DragAndDropPage();

        dragAndDropPage.dragAndDropElementAtoB();

        assertTrue(dragAndDropPage.isElementAContainsTextB(), "Элемент A не содержит текст B");
        assertTrue(dragAndDropPage.isElementBContainsTextA(), "Элемент B не содержит текст A");
    }
}
