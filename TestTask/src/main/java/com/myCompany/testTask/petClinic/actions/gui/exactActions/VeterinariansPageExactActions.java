package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.pages.veterinariansPage.VeterinariansPage;

public class VeterinariansPageExactActions {
    VeterinariansPage veterinariansPage = new VeterinariansPage();

    public void navigateToVeterinariansPageByUrl() {
        Selenide.open("/vets.html");
    }

    public long getVeterinariansCount() {
        return veterinariansPage.veterinariansTable.getVeterinariansCount();
    }
}
