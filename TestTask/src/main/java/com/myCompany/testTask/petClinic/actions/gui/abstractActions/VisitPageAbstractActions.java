package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.VisitPageExactActions;
import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import com.myCompany.testTask.petClinic.objects.PetWithId;

public class VisitPageAbstractActions {
    private VisitPageExactActions visitPageExactActions;

    public VisitPageAbstractActions(PetClinicExactActions petClinicExactActions) {

        this.visitPageExactActions = petClinicExactActions.visitPageExactActions;
    }

    public void NavigateToPage(OwnerWithId owner, PetWithId pet) {
        visitPageExactActions.navigateToPageByUrl(owner.getId(), pet.getId());
    }
}
