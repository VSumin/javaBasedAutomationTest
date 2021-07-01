package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.VeterinariansPageExactActions;

public class VeterinariansPageAbstractActions {
    private final VeterinariansPageExactActions veterinariansPageExactActions;

    public VeterinariansPageAbstractActions(PetClinicExactActions petClinicExactActions) {
        veterinariansPageExactActions = petClinicExactActions.veterinariansPageExactActions;
    }

    public void NavigateToVeterinariansPage() {
        veterinariansPageExactActions.navigateToVeterinariansPageByUrl();
    }
}
