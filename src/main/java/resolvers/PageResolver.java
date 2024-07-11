package resolvers;

import annotations.PageObject;
import exceptions.CTAFException;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import pages.Page;

public class PageResolver {
    @SneakyThrows
    public static Page resolve(String pageName) {
        var reflections = new Reflections("pages");
        var pageObjectClasses = reflections.getTypesAnnotatedWith(PageObject.class);
        var pageObjectClass = pageObjectClasses.stream()
                .filter(clazz -> clazz.getAnnotation(PageObject.class).value().equals(pageName))
                .findFirst()
                .orElseThrow(() -> new CTAFException("No pages with name '" + pageName + "' found"));
        var page = (Page) pageObjectClass.getDeclaredConstructor().newInstance();
        page.check();
        return page;
    }
}
