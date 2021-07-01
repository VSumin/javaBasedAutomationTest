package com.myCompany.testTask.petClinic.pages.editOwnerPage;

import com.codeborne.selenide.SelenideElement;
import com.myCompany.testTask.petClinic.Elements.WebTextField;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EditOwnerPage extends BasePage {
    public WebTextField firstName = new WebTextField(By.id("firstName"));
    public SelenideElement lastName = $(By.id("lastName"));
    public SelenideElement address = $(By.id("address"));
    public SelenideElement city = $(By.id("city"));
    public SelenideElement telephone = $(By.id("telephone"));
    public SelenideElement updateOwner = $(By.xpath("//button[@type='submit']"));
}
