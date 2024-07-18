import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseConfiguration {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true;
        Configuration.baseUrl = "https://gtk.org";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
