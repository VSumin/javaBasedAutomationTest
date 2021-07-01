package com.myCompany.testTask.petClinic.pages.ownerPage;

import com.myCompany.testTask.petClinic.Elements.WebElement;
import com.myCompany.testTask.petClinic.Elements.WebLabel;
import com.myCompany.testTask.petClinic.objects.Visit;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.util.LinkedList;

public class PetsTableModule {
    public WebElement allPetsElement = new WebElement(By.xpath("//table[2]/tbody"));

    public String getPetBirthdateByName(String name) {
        return new WebLabel(By.xpath(MessageFormat.format("//tr[.//dd[text()=''{0}'']]//dt[text()=''Birth Date'']/following-sibling::dd[1]", name))).getText();
    }

    public String getPetTypeByName(String name) {
        return new WebLabel(By.xpath(MessageFormat.format("//tr[.//dd[text()=''{0}'']]//dt[text()=''Type'']/following-sibling::dd[1]", name))).getText();
    }

    public LinkedList<Visit> getPetVisitsByName(String name) {
        var visits = new LinkedList<Visit>();

        long iterations = new WebElement(By.xpath(MessageFormat.format("//tr[.//dd[text()=''{0}'']]//table", name))).GetChildrenCount(".//tr//td[not(./a)]");

        for (int i = 0; i < iterations / 2; i = i + 2) {
            String date = new WebLabel(By.xpath(MessageFormat.format("(//tr[.//dd[text()=''{0}'']]//table//tr//td[not(./a)])[{1}]", name, i + 1))).getText();
            String description = new WebLabel(By.xpath(MessageFormat.format("(//tr[.//dd[text()=''{0}'']]//table//tr//td[not(./a)])[{1}]", name, i + 2))).getText();
            visits.add(new Visit(date, description));
        }

        return visits;
    }
}
