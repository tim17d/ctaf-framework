package features;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import steps.UiSteps;

public class FirstTest {

    UiSteps ui = new UiSteps("https://the-internet.herokuapp.com/");

    @Test
    @SneakyThrows
    public void simpleTest() {
        ui.openMainPage();
        Thread.sleep(3000);
    }
}
