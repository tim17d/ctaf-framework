package steps;

import io.qameta.allure.Step;
import static log_colors.Colors.cyan;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonSteps {
    @SneakyThrows
    @Step("Wait for {0} seconds")
    public void wait_for_seconds(int seconds) {
        Thread.sleep(seconds * 1000L);
        log.info(cyan("Waiting for {} seconds"), seconds);
    }
}
