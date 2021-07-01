package com.myCompany.testTask.petClinic;

import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OwnerDataTest extends BaseTest {
    @Test
    @DisplayName("As a user, I want to view my pets & visits details.")
    @Tag("HappyPath")
    public void ownerDataTest() {
        OwnerWithId ownerWithId = DatabaseData.getOwners().get(0);
        petClinicAbstractActions.ownerPageAbstractActions.NavigateToPage(ownerWithId);
        petClinicAbstractActions.ownerPageAbstractActions.verifyOwnerData(ownerWithId);
        petClinicAbstractActions.ownerPageAbstractActions.verifyOwnerPetData(ownerWithId);
    }
}
