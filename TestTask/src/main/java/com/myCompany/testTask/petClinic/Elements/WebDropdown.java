package com.myCompany.testTask.petClinic.elements;

import org.openqa.selenium.By;

/**
 * Select element presented as dropdown
 */
public class WebDropdown extends BaseWebUiElement {
    public WebDropdown(By by) {
        super(by);
    }

    public void select(String option) {
        get().selectOptionByValue(option);
    }
}
