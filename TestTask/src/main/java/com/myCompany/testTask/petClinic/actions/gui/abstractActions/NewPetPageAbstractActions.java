package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.NewPetPageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;
import com.myCompany.testTask.petClinic.objects.OwnerWithId;

public class NewPetPageAbstractActions {
    private final NewPetPageExactActions newPetPageExactActions;

    public NewPetPageAbstractActions(PetClinicExactActions petClinicExactActions) {
        newPetPageExactActions = petClinicExactActions.newPetPageExactActions;
    }

    public void OpenPage(OwnerWithId owner) {
        newPetPageExactActions.OpenPageByOwnerId(owner.getId());
    }
}
