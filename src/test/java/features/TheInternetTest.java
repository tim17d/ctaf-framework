package features;

import org.junit.jupiter.api.Test;
import steps.CommonSteps;
import steps.UiSteps;

public class TheInternetTest {
    CommonSteps common = new CommonSteps();
    UiSteps ui = new UiSteps("https://the-internet.herokuapp.com/");

    @Test
    public void testAddRemoveElements() {
        ui.open_main_page();
        ui.current_page_is("Welcome to the-internet");
        ui.click_on_element("Add/Remove Elements");
        ui.current_page_is("Add/Remove Elements");
        ui.click_on_element("Add Element");
        ui.click_on_element("Add Element");
        ui.check_element_is_visible_in_seconds("Delete", 10);
        ui.click_on_element("Delete");
        ui.check_element_is_visible_in_seconds("Delete", 10);
    }

    @Test
    public void testCheckboxes() {
        ui.open_main_page();
        ui.current_page_is("Welcome to the-internet");
        ui.click_on_element("Checkboxes");
    }
}
