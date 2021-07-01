package com.myCompany.testTask.petClinic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogoTest extends BaseTest {
    @Test
    @DisplayName("As a user, I should see a pet clinic logo image on home page below the welcome text.")
    @Tag("HappyPath")
    public void logoTest() {
        petClinicAbstractActions.homePageAbstractActions.NavigateToHomePage();
        Assertions.assertTrue(petClinicExactActions.homePageExactActions.isLogoVisible());
    }
}
