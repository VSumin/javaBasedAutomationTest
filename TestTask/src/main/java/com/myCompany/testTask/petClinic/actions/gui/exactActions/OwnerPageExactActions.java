package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.objects.Visit;
import com.myCompany.testTask.petClinic.pages.ownerPage.OwnerPage;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedList;

public class OwnerPageExactActions {
    OwnerPage ownerPage = new OwnerPage();
    public PetsTableExactActions petsTableExactActions = new PetsTableExactActions(ownerPage.petsTableModule);

    public String getName() {
        return ownerPage.name.getText();
    }

    public String getAddress() {
        return ownerPage.address.getText();
    }

    public String getCity() {
        return ownerPage.city.getText();
    }

    public String getTelephone() {
        return ownerPage.telephone.getText();
    }


    public void navigateToPageByUrl(int ownerId) {
        Selenide.open(MessageFormat.format("/owners/{0}", ownerId));
    }

    public boolean doesVisitExist(String name, Date dateOfVisit, String description) {
        LinkedList<Visit> petVisitsByName = ownerPage.petsTableModule.getPetVisitsByName(name);
        for (int i = 0; i < petVisitsByName.size(); i++) {
            Visit visit = petVisitsByName.get(i);
            if (visit.getDate().equals(dateOfVisit) && visit.getDescription().equals(description)) {
                return true;
            }
        }
        return false;
    }
}
