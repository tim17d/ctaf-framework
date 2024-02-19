package steps;

import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Step;

public class UiSteps {
    private final String baseUrl;

    public UiSteps(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Step("Open main page")
    public void openMainPage() {
        open(this.baseUrl);
    }
}
