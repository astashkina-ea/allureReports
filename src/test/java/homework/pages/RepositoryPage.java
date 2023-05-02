package homework.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {

    private SelenideElement issuesTab = $("#issues-tab");

    @Step("Выбрать вкладку Issue")
    public RepositoryPage selectIssuesTab() {
        issuesTab.click();
        return this;
    }

    @Step("Проверить имя {numberIssue} Issue")
    public RepositoryPage checkIssueName(String numberIssue, String nameIssue) {
        $(String.format("#issue_%s_link", numberIssue)).shouldHave(text(nameIssue));
        return this;
    }
}