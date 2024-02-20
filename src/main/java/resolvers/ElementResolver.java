package resolvers;

import annotations.Element;
import com.codeborne.selenide.SelenideElement;
import exceptions.STAFException;
import lombok.SneakyThrows;
import pages.Page;

import java.util.Arrays;

public class ElementResolver {
    @SneakyThrows
    public static SelenideElement resolve(Page page, String elementName) {
        var elementField = Arrays.stream(page.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(Element.class).value().equals(elementName))
                .findFirst()
                .orElseThrow(() -> new STAFException("No elements with name '" + elementName
                        + "' found on current page"));
        elementField.setAccessible(true);
        return (SelenideElement) elementField.get(page);
    }
}
