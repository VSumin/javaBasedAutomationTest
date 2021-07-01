package com.myCompany.testTask.petClinic;

import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import com.myCompany.testTask.petClinic.objects.PetWithId;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class AddVisitTest extends BaseTest {
    @Test
    @DisplayName("As a user, I want to add a visit to the veterinarian for my pet.")
    @Tag("HappyPath")
    public void addVisitTest() {
        var testOwner = DatabaseData.getOwners().get(0);
        var pet = testOwner.getPets().get(0);
        petClinicAbstractActions.visitPageAbstractActions.NavigateToPage(testOwner, pet);
        Date dateOfVisit = DateUtils.truncate(new Date(System.currentTimeMillis()), Calendar.DAY_OF_MONTH);
        petClinicExactActions.visitPageExactActions.fillDate(dateOfVisit);
        var testDescription = "Test description";
        petClinicExactActions.visitPageExactActions.fillDescription(testDescription);
        petClinicExactActions.visitPageExactActions.clickAddVisit();

        var doesVisitExist = petClinicExactActions.ownerPageExactActions.doesVisitExist(pet.getName(), dateOfVisit, testDescription);
        Assertions.assertTrue(doesVisitExist);
    }
}
