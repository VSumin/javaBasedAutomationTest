package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.pages.visitPage.VisitPage;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitPageExactActions {
    VisitPage visitPage = new VisitPage();

    public void navigateToPageByUrl(int ownerId, int petId) {
        Selenide.open(MessageFormat.format("/owners/{0}/pets/{1}/visits/new", ownerId, petId));
    }

    public void fillDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String strDate = dateFormat.format(date);
        visitPage.date.setValue(strDate);
    }

    public void fillDescription(String description) {
        visitPage.description.sendKeys(description);
    }

    public void clickAddVisit() {
        visitPage.addVisit.click();
    }
}
