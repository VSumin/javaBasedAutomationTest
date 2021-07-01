package com.myCompany.testTask.petClinic.pages.homePage;

import com.myCompany.testTask.petClinic.Elements.WebElement;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public WebElement logo = new WebElement(By.xpath("//img[contains(@src, 'pets.png')]"));
}
