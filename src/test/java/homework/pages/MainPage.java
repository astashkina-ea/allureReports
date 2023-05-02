package homework.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement searchField = $("[name=q]");

    @Step("Найти репозиторий {repository}")
    public MainPage searchRepository(String repository) {
        searchField.setValue(repository).pressEnter();
        return this;
    }
}