package com.myCompany.testTask.petClinic.Elements;

import org.openqa.selenium.By;

/**
 * The element, supposed to be filled with text
 */
public class WebTextField extends BaseWebControl {

    public WebTextField(By by) {
        super(by);
    }

    public void setValue(String text) {
        get().setValue(text);
    }

    public void sendKeys(String text) {
        get().sendKeys(text);
    }
}
