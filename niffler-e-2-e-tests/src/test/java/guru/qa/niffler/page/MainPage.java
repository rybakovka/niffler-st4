package guru.qa.niffler.page;

import guru.qa.niffler.model.SpendJson;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage selectSpending(SpendJson spending) {
        $(".spendings-table tbody")
                .$$("tr")
                .find(text(spending.description()))
                .$$("td")
                .first()
                .scrollIntoView(true)
                .click();
        return this;
    }
    public MainPage pressDeleteSelected() {
        $(byText("Delete selected"))
                .click();
        return this;
    }

    public MainPage spendingsShouldHaveSize(int shouldSize) {
         $(".spendings-table tbody")
                .$$("tr")
                .shouldHave(size(shouldSize));
         return this;
    }
}
