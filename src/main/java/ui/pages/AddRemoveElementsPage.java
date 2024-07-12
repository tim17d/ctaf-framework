package ui.pages;

import ui.annotations.Element;
import ui.annotations.PageObject;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

@PageObject("Add/Remove Elements")
public class AddRemoveElementsPage implements Page {
    @Element("Title")
    private SelenideElement title = $x("//h3");

    @Element("Add Element")
    private SelenideElement addElement = $x("//button[text()='Add Element']");

    @Element("Delete")
    private SelenideElement delete = $x("//button[text()='Delete'][1]");

    @Override
    public void check() {
        this.title.shouldBe(visible, Duration.ofSeconds(10));
    }
}
