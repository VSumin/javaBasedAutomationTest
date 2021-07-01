package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;

public class PetClinicAbstractActions {
    private PetClinicExactActions petClinicExactActions = new PetClinicExactActions();

    public AddNewOwnerPageAbstractActions addNewOwnerPageAbstractActions = new AddNewOwnerPageAbstractActions(petClinicExactActions);
    public EditOwnerPageAbstractActions editOwnerPageAbstractActions = new EditOwnerPageAbstractActions(petClinicExactActions);
    public FindOwnerPageAbstractActions findOwnerPageAbstractActions = new FindOwnerPageAbstractActions(petClinicExactActions);
    public OwnerPageAbstractActions ownerPageAbstractActions = new OwnerPageAbstractActions(petClinicExactActions);
    public VeterinariansPageAbstractActions veterinariansPageAbstractActions = new VeterinariansPageAbstractActions(petClinicExactActions);
    public NewPetPageAbstractActions newPetPageAbstractActions = new NewPetPageAbstractActions(petClinicExactActions);
    public VisitPageAbstractActions visitPageAbstractActions = new VisitPageAbstractActions(petClinicExactActions);
    public HomePageAbstractActions homePageAbstractActions = new HomePageAbstractActions(petClinicExactActions);


}
