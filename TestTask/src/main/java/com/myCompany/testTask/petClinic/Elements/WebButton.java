package com.myCompany.testTask.petClinic.Elements;

import org.openqa.selenium.By;

/**
 * Regular button
 */
public class WebButton extends BaseWebUiElement {
    public WebButton(By by) {
        super(by);
    }

    public void click() {
        get().click();
    }
}
