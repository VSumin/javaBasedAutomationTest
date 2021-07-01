package com.myCompany.testTask.petClinic.actions.api.abstarct;

import com.myCompany.testTask.petClinic.DatabaseData;
import com.myCompany.testTask.petClinic.actions.api.exact.ApiExactActions;
import com.myCompany.testTask.petClinic.objects.OwnerWithId;

import java.util.stream.Collectors;

/**
 * Actions with api, where only the result is important.
 * For example: we can receive the name of the owner by id using request to 'view' or 'edit' pages. The
 * result will be the same, but the way of receiving the result differs.
 * If the 'view' request is blocked by the bug, then we simply replace it with 'edit' with no risk breaking tests using this method.
 */
public class ApiAbstractActions {
    ApiExactActions apiExactActions = new ApiExactActions();

    public void rollbackExistingOwnerById(int ownerId) {
        OwnerWithId owner = DatabaseData.getOwners().stream().sequential().filter(x -> x.getId() == ownerId).collect(Collectors.toList()).get(0);
        apiExactActions.rollbackExistingOwner(owner);
    }
}
