package pages;

import annotations.Element;
import annotations.PageObject;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

@PageObject("Welcome to the-internet")
public class TheInternetMainPage implements Page {
    @Element("Title")
    private SelenideElement title = $x("//h1");

    @Element("Add/Remove Elements")
    private SelenideElement addRemoveElements = $x("//a[text()='Add/Remove Elements']");

    @Element("Checkboxes")
    private SelenideElement checkboxes = $x("//a[text()='Checkboxes']");

    @Element("Inputs")
    private SelenideElement inputs = $x("//a[text()='Inputs']");

    @Override
    public void check() {
        this.title.shouldBe(visible, Duration.ofSeconds(10));
    }
}
