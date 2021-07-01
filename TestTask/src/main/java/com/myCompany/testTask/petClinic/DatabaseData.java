package com.myCompany.testTask.petClinic;

import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Temporary storage of test data until persistence is implemented
 */
public class DatabaseData {
    @Getter
    @Setter
    private static List<OwnerWithId> owners;
}
