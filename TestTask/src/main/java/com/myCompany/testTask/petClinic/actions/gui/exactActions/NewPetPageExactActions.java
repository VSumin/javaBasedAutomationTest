package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.objects.PetType;
import com.myCompany.testTask.petClinic.pages.newPetPage.NewPetPage;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewPetPageExactActions {
    NewPetPage newPetPage = new NewPetPage();

    public void OpenPageByOwnerId(int ownerId) {
        Selenide.open(MessageFormat.format("/owners/{0}/pets/new", ownerId));
    }

    public void fillName(String name) {
        newPetPage.name.sendKeys(name);
    }

    public void fillDateOfBirth(Date dateOfBirth) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String strDate = dateFormat.format(dateOfBirth);
        newPetPage.birthDate.sendKeys(strDate);
    }

    public void fillType(PetType type) {
        newPetPage.type.select(type.toString());
    }

    public void clickNewPetButton() {
        newPetPage.newPet.click();
    }
}
