package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Language;

import static com.codeborne.selenide.Selenide.*;

public class LanguageBindingsPage {

    private final ElementsCollection menuListGroups = $$("li.list-group-item");
    private final SelenideElement pageTitle = $("div.container article.markdown-body h1");
    private SelenideElement menu;

    public LanguageBindingsPage openPage() {
        String page = "/docs/language-bindings/";
        open(page);
        return this;
    }

    public LanguageBindingsPage selectMenuTitle(String item) {
        menu = menuListGroups.find(Condition.text(item));
        return this;
    }

    public LanguageBindingsPage selectLanguage(Language language) {
        String l = language.name().toLowerCase();
        menu.$$("ul.list-group a").find(Condition.text(l)).click();
        return this;
    }

    public LanguageBindingsPage checkPageTitle(Language title) {
        String t = title.getValue();
        pageTitle.shouldBe(Condition.text(t));
        return this;
    }
}
