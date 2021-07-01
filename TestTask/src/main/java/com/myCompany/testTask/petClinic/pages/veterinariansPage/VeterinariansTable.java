package com.myCompany.testTask.petClinic.pages.veterinariansPage;

import com.myCompany.testTask.petClinic.Elements.WebElement;
import org.openqa.selenium.By;

public class VeterinariansTable {
    public long getVeterinariansCount() {
        return new WebElement(By.xpath("//tbody")).GetChildrenCount("./tr");
    }
}
