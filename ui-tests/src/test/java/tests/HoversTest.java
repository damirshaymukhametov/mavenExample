package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HoversPage;
import pages.HoversPageAsserts;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class HoversTest extends BaseTest {

    private final HoversPage hoversPage = new HoversPage();
    private HoversPageAsserts hoversPageAsserts;

    private static Stream<HoversPage.HoverTestData> hoverDataProvider() {
        return Stream.of(
                new HoversPage.HoverTestData(1, "name: user1"),
                new HoversPage.HoverTestData(2, "name: user2"),
                new HoversPage.HoverTestData(3, "name: user3")
        );
    }

    @ParameterizedTest
    @MethodSource("hoverDataProvider")
    public void testHovers(HoversPage.HoverTestData data) {
        open("/hovers");

        switch (data.getImageIndex()) {
            case 1:
                hoversPage.hoverOverFirstImage();
                break;
            case 2:
                hoversPage.hoverOverSecondImage();
                break;
            case 3:
                hoversPage.hoverOverThirdImage();
                break;
            default:
                throw new IllegalArgumentException("Invalid image index: " + data.getImageIndex());
        }

        hoversPageAsserts = new HoversPageAsserts(hoversPage);
        hoversPageAsserts.assertImageTextIs(data.getImageIndex(), data.getExpectedText());
    }
}