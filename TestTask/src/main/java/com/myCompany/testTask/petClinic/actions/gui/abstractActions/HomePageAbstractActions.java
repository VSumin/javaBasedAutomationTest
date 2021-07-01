package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.HomePageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;

public class HomePageAbstractActions {
    private final HomePageExactActions homePageExactActions;

    public HomePageAbstractActions(PetClinicExactActions petClinicExactActions) {
        homePageExactActions = petClinicExactActions.homePageExactActions;
    }

    public void NavigateToHomePage() {
        homePageExactActions.NavigateToPage();
    }
}
