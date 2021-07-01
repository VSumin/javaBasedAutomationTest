package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.AddNewOwnerPageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;

public class AddNewOwnerPageAbstractActions {
    private AddNewOwnerPageExactActions addNewOwnerExactActions;

    public AddNewOwnerPageAbstractActions(PetClinicExactActions petClinicExactActions) {
        this.addNewOwnerExactActions = petClinicExactActions.addNewOwnerExactActions;
    }

    public void NavigateToAddOwnerPage() {
        addNewOwnerExactActions.NavigateToAddOwnerPageByUrl();
    }
}
