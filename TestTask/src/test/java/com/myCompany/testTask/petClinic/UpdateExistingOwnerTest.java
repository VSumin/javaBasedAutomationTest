package com.myCompany.testTask.petClinic;

import com.codeborne.selenide.Selenide;
import com.myCompany.testTask.petClinic.actions.api.abstarct.ApiAbstractActions;
import com.myCompany.testTask.petClinic.actions.gui.abstractActions.PetClinicAbstractActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;
import com.myCompany.testTask.petClinic.objects.Owner;
import com.myCompany.testTask.petClinic.objects.PetWithId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.LinkedList;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UpdateExistingOwnerTest extends BaseTest {
    int ownerId = 1;

    @Test
    @DisplayName("As a user, I want to update an existing owner.")
    @Tag("HappyPath")
    public void updateExistingOwnerTest() {
        var petClinicAbstractActions = new PetClinicAbstractActions();
        petClinicAbstractActions.editOwnerPageAbstractActions.NavigateToEditOwnerPage(1);

        var petClinicExactActions = new PetClinicExactActions();
        var expectedFirstName = "TestFirstName";
        petClinicExactActions.editOwnerPageExactActions.changeFirstName(expectedFirstName);
        var expectedLastName = "TestLastName";
        petClinicExactActions.editOwnerPageExactActions.changeLastName(expectedLastName);
        var expectedAddress = "TestAddress";
        petClinicExactActions.editOwnerPageExactActions.changeAddress(expectedAddress);
        var expectedCity = "TestCity";
        petClinicExactActions.editOwnerPageExactActions.changeCity(expectedCity);
        Long expectedTelephone = 6546549L;
        petClinicExactActions.editOwnerPageExactActions.changeTelephone(expectedTelephone.toString());

        petClinicExactActions.editOwnerPageExactActions.clickUpdateButton();

        Selenide.Wait().until(x -> getWebDriver().getCurrentUrl().endsWith(MessageFormat.format("/owners/{0}", ownerId)));

        petClinicAbstractActions.ownerPageAbstractActions.verifyOwnerData(new Owner(expectedFirstName, expectedLastName, expectedCity, expectedAddress, expectedTelephone, new LinkedList<PetWithId>()));
    }

    @AfterEach
    public void tearDown() {
        ApiAbstractActions apiAbstractActions = new ApiAbstractActions();
        apiAbstractActions.rollbackExistingOwnerById(ownerId);
    }
}
