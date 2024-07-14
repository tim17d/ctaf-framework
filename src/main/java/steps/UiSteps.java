package steps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

import io.qameta.allure.Step;
import lombok.Getter;
import ui.pages.Page;
import ui.resolvers.ElementResolver;
import ui.resolvers.PageResolver;

import java.time.Duration;

@Getter
public class UiSteps extends AbstractSteps {

    private final String baseUrl;
    private Page currentPage;

    public UiSteps(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Step("Open main page")
    public void open_main_page() {
        open(this.baseUrl);
        logStep("Open main page");
    }

    @Step("Current page is '{0}'")
    public void current_page_is(String pageName) {
        this.currentPage = PageResolver.resolve(pageName);
        logStep("Current page is '{}'", pageName);
    }

    @Step("Click on element '{0}'")
    public void click_on_element(String elementName) {
        ElementResolver.resolve(this.currentPage, elementName).click();
        logStep("Click on element '{}'", elementName);
    }

    @Step("Check if element '{0}' is visible in seconds: '{1}'")
    public void check_element_is_visible_in_seconds(String elementName, int seconds) {
        ElementResolver.resolve(this.currentPage, elementName).shouldBe(visible, Duration.ofSeconds(seconds));
        logStep("Wait for {} seconds for element '{}' to be visible", seconds, elementName);
    }
}
