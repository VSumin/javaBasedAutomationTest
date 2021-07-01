package com.myCompany.testTask.petClinic.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@EqualsAndHashCode
public class Pet {
    @Getter
    private String name;
    @Getter
    private Date dateOfBirth;
    @Getter
    private PetType type;

    public Pet(String name, Date birthdate, PetType type) {

        this.name = name;
        this.dateOfBirth = birthdate;
        this.type = type;
    }

    @SneakyThrows
    public Pet(String name, String birthdate, String type) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.name = name;
        this.dateOfBirth = dateFormat.parse(birthdate);
        this.type = PetType.valueOf(type);
    }
}
