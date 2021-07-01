package com.myCompany.testTask.petClinic.pages.findOwnerPage;

import com.myCompany.testTask.petClinic.Elements.WebButton;
import com.myCompany.testTask.petClinic.Elements.WebTextField;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

public class FindOwnerPage extends BasePage {
    public WebTextField lastName = new WebTextField(By.id("lastName"));
    public WebButton findOwner = new WebButton(By.xpath("//button[@type='submit']"));
}
