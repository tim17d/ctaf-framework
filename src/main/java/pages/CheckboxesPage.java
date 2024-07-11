package pages;

import annotations.Element;
import annotations.PageObject;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

@PageObject("Checkboxes")
public class CheckboxesPage implements Page {
    @Element("Title")
    private SelenideElement title = $x("//h3");

    @Element("checkbox 1")
    private SelenideElement checkbox1 = $x("//input[1]");

    @Element("checkbox 2")
    private SelenideElement checkbox2 = $x("//input[2]");

    @Override
    public void check() {
        this.title.shouldBe(visible, Duration.ofSeconds(10));
    }
}
