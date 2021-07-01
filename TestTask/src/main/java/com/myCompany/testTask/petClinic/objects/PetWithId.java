package com.myCompany.testTask.petClinic.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@EqualsAndHashCode
public class PetWithId extends Pet {

    @Getter
    @EqualsAndHashCode.Exclude
    private int id;

    public PetWithId(int id, String name, Date birthdate, PetType type) {
        super(name, birthdate, type);
        this.id = id;
    }

    public PetWithId(int id, String name, String birthDate, String type) {
        super(name, birthDate, type);
        this.id = id;
    }
}
