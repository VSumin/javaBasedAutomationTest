package com.myCompany.testTask.petClinic.objects;

import lombok.Getter;

import java.util.List;

public class OwnerWithId extends Owner {
    @Getter
    private int id;

    public OwnerWithId(int id, String firstName, String lastName, String city, String address, Long telephone, List<PetWithId> pets) {
        super(firstName, lastName, city, address, telephone, pets);
        this.id = id;
    }
}
