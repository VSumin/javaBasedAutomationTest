package com.myCompany.testTask.petClinic.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


/**
 * Base action element to handle basic operations and handle the hierarchy
 */
public abstract class BaseWebControl {
    By locator;
    //   Frame frame;
    BaseWebControl container;
    public BaseWebControl(By by) {
        locator = by;
    }

    public String getText() {
        return get().getText();
    }

    SelenideElement getContainer() {
        if (container != null) {
            return container.get();
        }

        if (locator instanceof By.ByXPath) { //to avoid Selenide exception of not having '.' for relative elements
            String locatorString = locator.toString();
            if (locatorString.startsWith("By.xpath: count") || locatorString.startsWith("By.xpath: (")) {
                return $(new By.ByXPath("//html"));
            }
            if (!locatorString.startsWith("By.xpath: .")) {
                locator = new By.ByXPath(locatorString.replace("By.xpath: ", "."));
            }
        }
//        switchFrame(); //there are no frames, but the frames should be handled here
        return $(new By.ByXPath("//html"));
    }

    SelenideElement get() {
        SelenideElement searchContext = getContainer();
        return searchContext.$(locator);
    }


}
