package com.myCompany.testTask.petClinic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class SearchForExistingOwnerTest extends BaseTest {
    @Test
    @DisplayName("As a user, I want to search for an existing owner by his/her lastname.")
    @Tag("HappyPath")
    @Tag("HappyPath")
    public void searchForExistingOwnerTest() {
        var findOwnerPageAbstractActions = petClinicAbstractActions.findOwnerPageAbstractActions;
        findOwnerPageAbstractActions.navigateToFindOwnersPage();

        var ownerInDatabase = DatabaseData.getOwners().stream().filter(x -> x.getId() == 1).collect(Collectors.toList()).get(0);

        var findOwnerPageExactActions = petClinicExactActions.findOwnerPageExactActions;
        findOwnerPageExactActions.fillLastName(ownerInDatabase.getLastName());
        findOwnerPageExactActions.clickFindOwnerButton();

        petClinicAbstractActions.ownerPageAbstractActions.verifyOwnerData(ownerInDatabase);
    }
}
