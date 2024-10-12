package tests;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pages.InputsPage;
import pages.InputsPageAsserts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class InputsTest extends BaseTest {

    private InputsPage inputsPage = new InputsPage();
    private InputsPageAsserts inputsPageAsserts;

    @TestFactory
    public List<DynamicTest> testInputRandomNumber() {
        List<DynamicTest> dynamicTests = new ArrayList<>();
        Random random = new Random();
        inputsPageAsserts = new InputsPageAsserts(inputsPage);

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10000) + 1;
            dynamicTests.add(dynamicTest("Тест с числом: " + randomNumber, () -> {
                open("/inputs");
                inputsPage.enterRandomNumber(randomNumber);
                inputsPageAsserts.assertInputFieldValueIs(String.valueOf(randomNumber));
            }));
        }

        String[] negativeInputs = {"abc", "!@#$", " 123", "123 ", "12 34"};
        for (String input : negativeInputs) {
            dynamicTests.add(dynamicTest("Тест с недопустимым вводом: " + input, () -> {
                open("/inputs");
                inputsPage.enterInvalidInput(input);
                inputsPageAsserts.assertInputFieldIsEmpty();
            }));
        }

        return dynamicTests;
    }
}
