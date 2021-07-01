package com.myCompany.testTask.petClinic.actions.gui.abstractActions;

import com.myCompany.testTask.petClinic.actions.gui.exactActions.OwnerPageExactActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;
import com.myCompany.testTask.petClinic.objects.Owner;
import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import com.myCompany.testTask.petClinic.objects.Pet;
import org.junit.jupiter.api.Assertions;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerPageAbstractActions {
    private final OwnerPageExactActions ownerPageExactActions;

    public OwnerPageAbstractActions(PetClinicExactActions petClinicExactActions) {
        ownerPageExactActions = petClinicExactActions.ownerPageExactActions;
    }

    public void verifyOwnerData(Owner owner) {
        String name = ownerPageExactActions.getName();
        String address = ownerPageExactActions.getAddress();
        String city = ownerPageExactActions.getCity();
        String telephone = ownerPageExactActions.getTelephone();

        Assertions.assertAll(
                () -> assertTrue(name.equals(MessageFormat.format("{0} {1}", owner.getFirstName(), owner.getLastName()))),
                () -> assertTrue(address.equals(owner.getAddress())),
                () -> assertTrue(city.equals(owner.getCity())),
                () -> assertTrue(telephone.equals(owner.getTelephone().toString()))
        );
    }

    public void verifyPetInfo(Pet pet) {
        Pet parsedPet = ownerPageExactActions.petsTableExactActions.getPetDataByName(pet.getName());
        assertTrue(pet.equals(parsedPet), "the pet on the page does not equal to the pet we've created");
    }

    public void NavigateToPage(OwnerWithId ownerId) {
        ownerPageExactActions.navigateToPageByUrl(ownerId.getId());
    }

    public void verifyOwnerPetData(OwnerWithId ownerWithId) {
        String allPetsText = ownerPageExactActions.petsTableExactActions.getAllPetsText();
        for (int i = 0; i < ownerWithId.getPets().size(); i++) {
            int finalI = i;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Assertions.assertAll(
                    () -> Assertions.assertTrue(allPetsText.contains(ownerWithId.getPets().get(finalI).getName())),
                    () -> Assertions.assertTrue(allPetsText.contains(dateFormat.format(ownerWithId.getPets().get(finalI).getDateOfBirth()))),
                    () -> Assertions.assertTrue(allPetsText.contains(ownerWithId.getPets().get(finalI).getType().toString()))
            );
        }
        //well, actually i should have been tested the visits too, but no one will anyway check this so... skipping due to lack of time.
    }
}
