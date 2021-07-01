package com.myCompany.testTask.petClinic;

import com.myCompany.testTask.petClinic.objects.Pet;
import com.myCompany.testTask.petClinic.objects.PetType;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class AddPetTest extends BaseTest {
    @AfterAll
    public static void tearDown() {
        //ideally we would like to clean the data we've created
    }

    @Test
    @DisplayName("As a user, I want to add a new pet for an existing owner.")
    @Tag("HappyPath")
    public void addNewPetTest() {
        petClinicAbstractActions.newPetPageAbstractActions.OpenPage(DatabaseData.getOwners().get(0));
        var newPetPageExactActions = petClinicExactActions.newPetPageExactActions;
        var petName = "test";
        newPetPageExactActions.fillName(petName);
        var petDateOfBirth = DateUtils.truncate(new Date(System.currentTimeMillis()), Calendar.DAY_OF_MONTH);
        newPetPageExactActions.fillDateOfBirth(petDateOfBirth);
        var petType = PetType.cat;
        newPetPageExactActions.fillType(petType);
        newPetPageExactActions.clickNewPetButton();

        var pet = new Pet(petName, petDateOfBirth, petType);
        petClinicAbstractActions.ownerPageAbstractActions.verifyPetInfo(pet);
    }
}
