package steps;

import io.qameta.allure.Step;
import lombok.SneakyThrows;

public class CommonSteps extends AbstractSteps {
    @SneakyThrows
    @Step("Wait for {0} seconds")
    public void wait_for_seconds(int seconds) {
        Thread.sleep(seconds * 1000L);
        logStep("Wait for {} seconds", seconds);
    }
}
