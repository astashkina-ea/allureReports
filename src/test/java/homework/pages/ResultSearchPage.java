package homework.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class ResultSearchPage {

    @Step("Открыть репозиторий {repository}")
    public ResultSearchPage selectRepository(String repository) {
        $(linkText(repository)).click();
        return this;
    }
}
