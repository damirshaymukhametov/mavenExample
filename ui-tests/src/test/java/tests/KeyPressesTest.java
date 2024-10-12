package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;
import pages.KeyPressesPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;


public class KeyPressesTest extends BaseTest {
    private KeyPressesPage keyPressesPage = new KeyPressesPage();

    @ParameterizedTest
    @MethodSource("provideInputData")
    public void testKeyPresses(String inputText) {
        open("/key_presses");

        for (char c : inputText.toCharArray()) {
            keyPressesPage.enterText(String.valueOf(c));
            keyPressesPage.getResultMessageElement().shouldHave(Condition.text("You entered: " + c));
        }
    }

    private static Stream<String> provideInputData() {
        return Stream.of("abcdefghij");
    }

    @ParameterizedTest
    @MethodSource("provideKeyPresses")
    public void testKeyPressesWithKeys(Keys key) {
        open("/key_presses");

        keyPressesPage.pressKey(key);
        keyPressesPage.getResultMessageElement().shouldHave(Condition.text("You entered: " + key.name()));
    }

    private static Stream<Keys> provideKeyPresses() {
        return Stream.of(Keys.ENTER, Keys.ALT, Keys.CONTROL, Keys.TAB);
    }
}