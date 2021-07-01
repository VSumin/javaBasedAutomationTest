package com.myCompany.testTask.petClinic.pages.addNewUserPage;

import com.myCompany.testTask.petClinic.Elements.WebButton;
import com.myCompany.testTask.petClinic.Elements.WebTextField;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

public class AddNewOwnerPage extends BasePage {
    public WebTextField firstNameField = new WebTextField(By.id("firstName"));
    public WebTextField lastNameField = new WebTextField(By.id("lastName"));
    public WebTextField addressField = new WebTextField(By.id("address"));
    public WebTextField cityField = new WebTextField(By.id("city"));
    public WebTextField telephoneField = new WebTextField(By.id("telephone"));
    public WebButton addOwnerButton = new WebButton(By.xpath("//button[@type='submit']"));

}
