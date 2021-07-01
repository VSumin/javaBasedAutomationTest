package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.EditOwnerPageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.OwnerPageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;

public class EditOwnerPageAbstractActions {
    private EditOwnerPageExactActions editOwnerPageExactActions;
    private OwnerPageExactActions ownerPageExactActions;

    public EditOwnerPageAbstractActions(PetClinicExactActions petClinicExactActions) {

        this.editOwnerPageExactActions = petClinicExactActions.editOwnerPageExactActions;
        this.ownerPageExactActions = petClinicExactActions.ownerPageExactActions;
    }


    public void NavigateToEditOwnerPage(int ownerId) {
        editOwnerPageExactActions.NavigateToAddOwnerPageByUrl(ownerId);
    }


}
