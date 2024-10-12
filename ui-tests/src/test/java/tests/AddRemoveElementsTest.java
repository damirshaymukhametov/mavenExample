package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pages.AddRemoveElementsPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;

public class AddRemoveElementsTest extends BaseTest {

    @TestFactory
    public List<DynamicTest> testAddRemoveElements() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        int[][] testCases = {
                {2, 1},
                {5, 2},
                {1, 3}
        };

        for (int[] testCase : testCases) {
            int addCount = testCase[0];
            int removeCount = testCase[1];

            dynamicTests.add(DynamicTest.dynamicTest("Тест: Добавить " + addCount + ", Удалить " + removeCount, () -> {
                open("/add_remove_elements/");

                AddRemoveElementsPage page = new AddRemoveElementsPage();

                for (int i = 0; i < addCount; i++) {
                    page.clickAddElement();
                    String newButtonText = page.getDeleteButtons().last().getText();
                    System.out.println("Добавлен элемент: " + newButtonText);
                    page.printRemainingDeleteButtons();

                    page.getDeleteButtons().shouldHave(size(i + 1));
                }

                for (int i = 0; i < removeCount; i++) {
                    SelenideElement buttonToDelete = page.getDeleteButtons().last();
                    buttonToDelete.click();
                    System.out.println("Удален элемент: " + page.getDeleteButtonText(buttonToDelete));
                    page.printRemainingDeleteButtons();

                    page.getDeleteButtons().shouldHave(size(addCount - (i + 1)));
                }
            }));
        }

        return dynamicTests;
    }
}