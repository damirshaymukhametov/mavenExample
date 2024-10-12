package tests;

import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextMenuTest extends BaseTest {

    @Test
    public void testContextMenu() {
        open("/context_menu");
        ContextMenuPage contextMenuPage = new ContextMenuPage();

        contextMenuPage.rightClickOnContextMenu();

        String alertText = contextMenuPage.getAlertText();
        assertEquals("You selected a context menu", alertText, "Текст alert не соответствует ожидаемому");
    }
}