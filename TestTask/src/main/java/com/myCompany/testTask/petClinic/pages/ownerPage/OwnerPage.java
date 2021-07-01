package com.myCompany.testTask.petClinic.pages.ownerPage;

import com.myCompany.testTask.petClinic.elements.WebLabel;
import com.myCompany.testTask.petClinic.pages.common.BasePage;
import org.openqa.selenium.By;

public class OwnerPage extends BasePage {
    public WebLabel name = new WebLabel(By.xpath("//tr[th[text() = 'Name']]//b"));
    public WebLabel address = new WebLabel(By.xpath("//tr[th[text() = 'Address']]/td"));
    public WebLabel city = new WebLabel(By.xpath("//tr[th[text() = 'City']]/td"));
    public WebLabel telephone = new WebLabel(By.xpath("//tr[th[text() = 'Telephone']]/td"));
    public PetsTableModule petsTableModule = new PetsTableModule();
}
