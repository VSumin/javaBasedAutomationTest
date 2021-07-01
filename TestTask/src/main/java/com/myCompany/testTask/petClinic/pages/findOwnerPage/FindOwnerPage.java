package com.myCompany.testTask.petClinic.pages.findOwnerPage;

import com.myCompany.testTask.petClinic.elements.WebButton;
import com.myCompany.testTask.petClinic.elements.WebTextField;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

public class FindOwnerPage extends BasePage {
    public WebTextField lastName = new WebTextField(By.id("lastName"));
    public WebButton findOwner = new WebButton(By.xpath("//button[@type='submit']"));
}
