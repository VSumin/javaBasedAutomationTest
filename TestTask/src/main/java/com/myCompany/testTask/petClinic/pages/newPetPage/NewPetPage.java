package com.myCompany.testTask.petClinic.pages.newPetPage;

import com.myCompany.testTask.petClinic.elements.WebButton;
import com.myCompany.testTask.petClinic.elements.WebDropdown;
import com.myCompany.testTask.petClinic.elements.WebTextField;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

public class NewPetPage extends BasePage {
    public WebTextField name = new WebTextField(By.id("name"));
    public WebTextField birthDate = new WebTextField(By.id("birthDate"));
    public WebDropdown type = new WebDropdown(By.id("type"));
    public WebButton newPet = new WebButton(By.xpath("//button[@type='submit']"));
}
