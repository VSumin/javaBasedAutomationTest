package com.myCompany.testTask.petClinic;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import java.text.MessageFormat;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NewOwnerTest extends BaseTest {

    @Test
    @DisplayName("As a user, I want to add a new owner.")
    @Tag("HappyPath")
    public void addNewOwnerTest() {
        petClinicAbstractActions.addNewOwnerPageAbstractActions.NavigateToAddOwnerPage();
        var addNewOwnerExactActions = petClinicExactActions.addNewOwnerExactActions;

        var firstNameExpected = "firstNameExpected";
        addNewOwnerExactActions.fillFirstName(firstNameExpected);
        var lastNameExpected = "lastNameExpected";
        addNewOwnerExactActions.fillLastName(lastNameExpected);
        var addressExpected = "address";
        addNewOwnerExactActions.fillAddress(addressExpected);
        var cityExpected = "city";
        addNewOwnerExactActions.fillCity(cityExpected);
        Long telephoneExpected = 55599999L;
        addNewOwnerExactActions.fillTelephone(telephoneExpected.toString());

        addNewOwnerExactActions.clickAddOwner();

        Selenide.Wait().until(x -> getWebDriver().getCurrentUrl().contains("/owners/"));

        var ownerPageExactActions = petClinicExactActions.ownerPageExactActions;
        var name = ownerPageExactActions.getName();
        var address = ownerPageExactActions.getAddress();
        var city = ownerPageExactActions.getCity();
        var telephone = ownerPageExactActions.getTelephone();

        Assertions.assertAll(
                () -> assertTrue(name.equals(MessageFormat.format("{0} {1}", firstNameExpected, lastNameExpected))),
                () -> assertTrue(address.equals(addressExpected)),
                () -> assertTrue(city.equals(cityExpected)),
                () -> assertTrue(telephone.equals(telephoneExpected.toString()))
        );
    }

    @AfterEach
    public void tearDown() {
        //remove added owner
    }
}
