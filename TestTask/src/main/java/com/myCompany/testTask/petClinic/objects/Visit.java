package com.myCompany.testTask.petClinic.objects;

import lombok.Getter;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {
    @Getter
    Date date;
    @Getter
    String description;

    @SneakyThrows
    public Visit(String date, String description) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date = dateFormat.parse(date);
        this.description = description;
    }
}
