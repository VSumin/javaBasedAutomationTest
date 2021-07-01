package com.myCompany.testTask.petClinic.actions.api.exact;

import com.myCompany.testTask.petClinic.Configuration;
import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.text.MessageFormat;

/**
 * Actions with API where the result is as important as the actions sequence and actions itself.
 * We can't replace these actions without detailed check of any tests which are using these actions.
 */
public class ApiExactActions {
    public void rollbackExistingOwner(OwnerWithId owner) {
        String apiAddress = MessageFormat.format("/owners/{0}/edit", owner.getId());
        RequestSpecification request = RestAssured.given()
                .contentType("multipart/form-data")
                .baseUri(MessageFormat.format("http://{0}:{1}", Configuration.getApiAddress(), String.format("%d", Configuration.getApiPort())));
        request.multiPart("address", owner.getAddress());
        request.multiPart("city", owner.getCity());
        request.multiPart("firstName", owner.getFirstName());
        request.multiPart("lastName", owner.getLastName());
        request.multiPart("telephone", owner.getTelephone());
        Response response = request.post(apiAddress);
    }
}
