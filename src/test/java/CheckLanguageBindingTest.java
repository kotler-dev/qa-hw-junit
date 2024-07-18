import data.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LanguageBindingsPage;

import java.util.stream.Stream;

public class CheckLanguageBindingTest extends BaseConfiguration {

    @Test
    @DisplayName("Проверяем наличие станицы языковой привязки Vala к Gtk")
    void checkLanguageBindingInTitlePageTest() {
        LanguageBindingsPage languageBindings = new LanguageBindingsPage();
        languageBindings
                .openPage()
                .selectMenuTitle("Language Bindings")
                .selectLanguage(Language.VALA)
                .checkPageTitle(Language.VALA);
    }

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Проверяем наличие станицы языковой привязки {0} к Gtk")
    void checkLanguageBindingInTitlePageWithEnumSourceTest(Language language) {
        LanguageBindingsPage languageBindings = new LanguageBindingsPage();
        languageBindings
                .openPage()
                .selectMenuTitle("Language Bindings")
                .selectLanguage(language)
                .checkPageTitle(language);
    }

    @ValueSource(strings = {"Vala", "Python"})
    @ParameterizedTest(name = "Проверяем наличие станицы языковой привязки {0} к Gtk")
    void checkLanguageBindingInTitlePageWithValueSourceTest(String source) {
        Language language = Language.valueOf(source.toUpperCase());
        LanguageBindingsPage languageBindings = new LanguageBindingsPage();
        languageBindings
                .openPage()
                .selectMenuTitle("Language Bindings")
                .selectLanguage(language)
                .checkPageTitle(language);
    }

    private static Stream<Arguments> checkLanguageBindingInTitlePageWithArgumentsSourceTest() {
        return Stream.of(
                Arguments.of("Javascript"),
                Arguments.of("Rust")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверяем наличие станицы языковой привязки {0} к Gtk")
    void checkLanguageBindingInTitlePageWithArgumentsSourceTest(String source) {
        Language language = Language.valueOf(source.toUpperCase());
        LanguageBindingsPage languageBindings = new LanguageBindingsPage();
        languageBindings
                .openPage()
                .selectMenuTitle("Language Bindings")
                .selectLanguage(language)
                .checkPageTitle(language);
    }
}
