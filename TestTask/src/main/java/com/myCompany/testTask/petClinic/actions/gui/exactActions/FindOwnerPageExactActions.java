package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.pages.findOwnerPage.FindOwnerPage;

public class FindOwnerPageExactActions {
    FindOwnerPage findOwnerPage = new FindOwnerPage();

    public void fillLastName(String lastName) {
        findOwnerPage.lastName.sendKeys(lastName);
    }

    public void navigateToFindOwnersPageByUrl() {
        Selenide.open("/owners/find");
    }

    public void clickFindOwnerButton() {
        findOwnerPage.findOwner.click();
    }
}
