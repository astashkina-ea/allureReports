package homework.tests;

import homework.pages.MainPage;
import homework.pages.RepositoryPage;
import homework.pages.ResultSearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Feature("Issue в репозитории")
@Story("Отображение Issue во вкладке Issue")
@Owner("astashkina_ea")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "prod", url = "https://github.com")
public class IssueTests extends TestBase {

    private MainPage mainPage = new MainPage();
    private ResultSearchPage resultSearchPage = new ResultSearchPage();
    private RepositoryPage repositoryPage = new RepositoryPage();

    private static final String
            REPOSITORY = "astashkina-ea/junit",
            ISSUE_NUMBER = "1",
            ISSUE_NAME = "Test Issue";

    @BeforeEach
    public void beforeEach() {
        open("");
    }

    @DisplayName("Проверка имени " + ISSUE_NUMBER + " Issue")
    @Test
    public void verifyIssueNameTestWithClean() {
        $("[name = q]").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(String.format("#issue_%s_link", ISSUE_NUMBER)).shouldHave(text(ISSUE_NAME));
    }

    @DisplayName("Проверка имени " + ISSUE_NUMBER + " Issue")
    @Test
    public void verifyIssueNameTestWithLambdaSteps() {
        step("Найти репозиторий " + REPOSITORY, () ->
                $("[name = q]").setValue(REPOSITORY).pressEnter()
        );
        step("Открыть репозиторий " + REPOSITORY, () ->
                $(linkText(REPOSITORY)).click()
        );
        step("Выбрать вкладку Issue", () ->
                $("#issues-tab").click()
        );
        step("Проверить имя " + ISSUE_NUMBER + " Issue", () ->
                $(String.format("#issue_%s_link", ISSUE_NUMBER)).shouldHave(text(ISSUE_NAME))
        );
    }

    @DisplayName("Проверка имени " + ISSUE_NUMBER + " Issue")
    @Test
    public void verifyIssueNameTestWithAnnotatedSteps() {
        mainPage.searchRepository(REPOSITORY);
        resultSearchPage.selectRepository(REPOSITORY);
        repositoryPage.selectIssuesTab();
        repositoryPage.checkIssueName(ISSUE_NUMBER, ISSUE_NAME);
    }
}