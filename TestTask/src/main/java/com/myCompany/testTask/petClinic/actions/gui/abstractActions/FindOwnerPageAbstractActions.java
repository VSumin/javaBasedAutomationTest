package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.FindOwnerPageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;

public class FindOwnerPageAbstractActions {
    private final FindOwnerPageExactActions findOwnerPageExactActions;

    public FindOwnerPageAbstractActions(PetClinicExactActions petClinicExactActions) {

        this.findOwnerPageExactActions = petClinicExactActions.findOwnerPageExactActions;
    }

    public void navigateToFindOwnersPage() {
        findOwnerPageExactActions.navigateToFindOwnersPageByUrl();
    }
}
