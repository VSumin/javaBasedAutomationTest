package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.pages.editOwnerPage.EditOwnerPage;

import java.text.MessageFormat;

public class EditOwnerPageExactActions {
    EditOwnerPage editOwnerPage = new EditOwnerPage();

    public void NavigateToAddOwnerPageByUrl(int ownerId) {
        Selenide.open(MessageFormat.format("/owners/{0}/edit", ownerId));
    }

    public void changeFirstName(String firstName) {
        editOwnerPage.firstName.setValue(firstName);
    }

    public void changeLastName(String lastName) {
        editOwnerPage.lastName.setValue(lastName);
    }

    public void changeAddress(String address) {
        editOwnerPage.address.setValue(address);
    }

    public void changeTelephone(String telephone) {
        editOwnerPage.telephone.setValue(telephone);
    }

    public void changeCity(String city) {
        editOwnerPage.city.setValue(city);
    }

    public void clickUpdateButton() {
        editOwnerPage.updateOwner.click();
    }
}
