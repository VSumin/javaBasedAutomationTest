package com.myCompany.testTask.petClinic.actions.gui.exactActions;

import com.myCompany.testTask.petClinic.objects.Pet;
import com.myCompany.testTask.petClinic.objects.PetType;
import com.myCompany.testTask.petClinic.pages.ownerPage.PetsTableModule;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class PetsTableExactActions {
    private PetsTableModule petsTableModule;

    public PetsTableExactActions(PetsTableModule petsTableModule) {

        this.petsTableModule = petsTableModule;
    }

    @SneakyThrows
    public Pet getPetDataByName(String name) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = dateFormat.parse(petsTableModule.getPetBirthdateByName(name));
        PetType type = PetType.valueOf(petsTableModule.getPetTypeByName(name));

        Pet pet = new Pet(name, birthdate, type);

        return pet;
    }

    public String getAllPetsText() {
        var pets = new LinkedList<Pet>();
        String allPetsText = petsTableModule.allPetsElement.getText();
        return allPetsText;
    }
}
