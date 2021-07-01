package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.pages.addNewUserPage.AddNewOwnerPage;

public class AddNewOwnerPageExactActions {
    AddNewOwnerPage addNewOwnerPage = new AddNewOwnerPage();

    public void NavigateToAddOwnerPageByUrl() {
        Selenide.open("/owners/new");
    }

    public void fillFirstName(String firstName) {
        addNewOwnerPage.firstNameField.setValue(firstName);
    }

    public void fillLastName(String lastName) {
        addNewOwnerPage.lastNameField.setValue(lastName);
    }

    public void fillAddress(String address) {
        addNewOwnerPage.addressField.setValue(address);
    }

    public void fillCity(String city) {
        addNewOwnerPage.cityField.setValue(city);
    }

    public void fillTelephone(String telephone) {
        addNewOwnerPage.telephoneField.setValue(telephone);
    }

    public void clickAddOwner() {
        addNewOwnerPage.addOwnerButton.click();
    }
}
