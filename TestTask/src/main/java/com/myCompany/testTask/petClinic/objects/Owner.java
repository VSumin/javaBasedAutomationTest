package com.myCompany.testTask.petClinic.objects;

import lombok.Getter;

import java.util.List;

public class Owner {

    @Getter
    private final String firstName;
    @Getter
    private final String lastName;
    @Getter
    private final String city;
    @Getter
    private final String address;
    @Getter
    private final Long telephone;
    @Getter
    List<PetWithId> pets;
    public Owner(String firstName, String lastName, String city, String address, Long telephone, List<PetWithId> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.pets = pets;
    }

}
