package com.myCompany.testTask.petClinic.pages.visitPage;

import com.codeborne.selenide.SelenideElement;
import com.myCompany.testTask.petClinic.elements.WebTextField;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VisitPage extends BasePage {
    public WebTextField date = new WebTextField(By.id("date"));
    public WebTextField description = new WebTextField(By.id("description"));
    public SelenideElement addVisit = $(By.xpath("//button[@type='submit']"));

}
