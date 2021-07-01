package com.myCompany.testTask.petClinic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class VeterinariansListTest extends BaseTest {
    @Test
    @DisplayName("As a user, I want to view the list of veterinarians.")
    @Tag("HappyPath")
    public void viewVeterinariansListTest() {
        var veterinariansPageAbstractActions = petClinicAbstractActions.veterinariansPageAbstractActions;
        veterinariansPageAbstractActions.NavigateToVeterinariansPage();

        Assertions.assertTrue(petClinicExactActions.veterinariansPageExactActions.getVeterinariansCount() > 5);
    }
}
