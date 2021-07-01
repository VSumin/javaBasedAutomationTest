package com.myCompany.testTask.petClinic.elements;

import org.openqa.selenium.By;


/**
 * Base abstract web element to unite all common elements
 */
public abstract class BaseWebUiElement extends BaseWebControl {
    public BaseWebUiElement(By by) {
        super(by);
    }

    public long GetChildrenCount(String xpathSelector) {
        return get().$$x(xpathSelector).size();
    }

    public boolean isVisible() {
        return get().isDisplayed();
    }
}
