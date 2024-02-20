package steps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Step;
import static log_colors.Colors.cyan;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pages.Page;
import resolvers.ElementResolver;
import resolvers.PageResolver;

import java.time.Duration;

@Slf4j
@Getter
public class UiSteps {
    private final String baseUrl;
    private Page currentPage;

    public UiSteps(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Step("Open main page")
    public void open_main_page() {
        open(this.baseUrl);
        log.info(cyan("Open main page"));
    }

    @Step("Current page is '{0}'")
    public void current_page_is(String pageName) {
        this.currentPage = PageResolver.resolve(pageName);
        log.info(cyan("Current page is '{}'"), pageName);
    }

    @Step("Click on element '{0}'")
    public void click_on_element(String elementName) {
        ElementResolver.resolve(this.currentPage, elementName).click();
        log.info(cyan("Click on element '{}'"), elementName);
    }

    @Step("Check if element '{0}' is visible in seconds: '{1}'")
    public void check_element_is_visible_in_seconds(String elementName, int seconds) {
        ElementResolver.resolve(this.currentPage, elementName).shouldBe(visible, Duration.ofSeconds(seconds));
        log.info(cyan("Wait for {} seconds for element '{}' to be visible"), seconds, elementName);
    }
}
