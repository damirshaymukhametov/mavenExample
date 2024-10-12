package tests;

import org.junit.jupiter.api.RepeatedTest;
import pages.NotificationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationTest extends BaseTest {
    NotificationPage notificationPage = new NotificationPage();

    @RepeatedTest(10)
    public void testNotificationMessage() {
        open("/notification_message_rendered");
        String expectedMessage = "Action successful";

        notificationPage.clickButton();

        notificationPage.notificationMessage.shouldHave(text(expectedMessage));

        assertTrue(notificationPage.getNotificationText().contains(expectedMessage),
                "Test failed: Expected notification message was not received.");
    }
}
