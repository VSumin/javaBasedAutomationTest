package com.myCompany.testTask.petClinic;

import com.myCompany.testTask.petClinic.actions.gui.abstractActions.PetClinicAbstractActions;
import com.myCompany.testTask.petClinic.actions.gui.exactActions.PetClinicExactActions;
import com.myCompany.testTask.petClinic.objects.OwnerWithId;
import com.myCompany.testTask.petClinic.objects.PetWithId;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.junit.jupiter.api.BeforeAll;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class BaseTest {
    PetClinicExactActions petClinicExactActions;
    PetClinicAbstractActions petClinicAbstractActions;

    public BaseTest() {
        petClinicExactActions = new PetClinicExactActions();
        petClinicAbstractActions = new PetClinicAbstractActions();
    }

    /**
     * The general configuration of tests should be loaded here.
     */
    @BeforeAll
    public static void oneTimeSetup() {
        loadDriver();
        List<OwnerWithId> owners = GetDefaultDatabaseData();
        DatabaseData.setOwners(owners);
    }

    /**
     * Workaround until database access received
     *
     * @return list of owners currently stored in the database
     */
    @SneakyThrows
    private static List<OwnerWithId> GetDefaultDatabaseData() {
        List<OwnerWithId> owners = new LinkedList<OwnerWithId>();
        Response response = null;
        int i = 1;
        while (true) {
            String editOwnerApiAddress = MessageFormat.format("/owners/{0}/edit", i);
            response = RestAssured.get(editOwnerApiAddress);
            if (response.getStatusCode() != 200) {
                break;
            }
            String responseBody = response.getBody().asString();

            HtmlCleaner cleaner = new HtmlCleaner();
            TagNode clean = cleaner.clean(responseBody);
            Document document = new DomSerializer(new CleanerProperties()).createDOM(clean);
            XPath xpath = XPathFactory.newInstance().newXPath();
            String firstName = (String) xpath
                    .evaluate("//input[@id='firstName']/@value", document, XPathConstants.STRING);
            String lastName = (String) xpath
                    .evaluate("//input[@id='lastName']/@value", document, XPathConstants.STRING);
            String address = (String) xpath
                    .evaluate("//input[@id='address']/@value", document, XPathConstants.STRING);
            String city = (String) xpath
                    .evaluate("//input[@id='city']/@value", document, XPathConstants.STRING);
            String telephone = (String) xpath
                    .evaluate("//input[@id='telephone']/@value", document, XPathConstants.STRING);

            String ownerInfoApiAddress = MessageFormat.format("/owners/{0}", i);
            var ownerInfoResponse = RestAssured.get(ownerInfoApiAddress);
            if (ownerInfoResponse.getStatusCode() != 200) {
                break;
            }
            String ownerInfoResponseBody = ownerInfoResponse.getBody().asString();

            TagNode ownerInfoResponseBodyClean = cleaner.clean(ownerInfoResponseBody);
            Document ownerInfoResponseBodyDocument = new DomSerializer(new CleanerProperties()).createDOM(ownerInfoResponseBodyClean);

            int petsCount = Integer.parseInt((String) xpath
                    .evaluate("count((//tbody)[2]/tr)", ownerInfoResponseBodyDocument, XPathConstants.STRING));

            List<PetWithId> pets = new LinkedList<PetWithId>();
            for (int j = 0; j < petsCount; j++) {
                String name = (String) xpath
                        .evaluate(MessageFormat.format("(//tr//dt[text()=''Name'']/following-sibling::dd[1])[{0}]", (j + 1)), ownerInfoResponseBodyDocument, XPathConstants.STRING);
                String birthDate = (String) xpath
                        .evaluate(MessageFormat.format("(//tr//dt[text()=''Birth Date'']/following-sibling::dd[1])[{0}]", (j + 1)), ownerInfoResponseBodyDocument, XPathConstants.STRING);
                String type = (String) xpath
                        .evaluate(MessageFormat.format("(//tr//dt[text()=''Type'']/following-sibling::dd[1])[{0}]", (j + 1)), ownerInfoResponseBodyDocument, XPathConstants.STRING);
                int id = Integer.parseInt(xpath
                        .evaluate(MessageFormat.format("(//tr[{0}]//a)[1]/@href", (j + 1)), ownerInfoResponseBodyDocument, XPathConstants.STRING).toString().split("/")[2]);

                pets.add(new PetWithId(id, name, birthDate, type));
            }

            owners.add(new OwnerWithId(i, firstName, lastName, city, address, Long.parseLong(telephone), pets));

            i++;
        }
        return owners;
    }

    /**
     * Default driver configuration. Can be replaced with GRID if required.
     */
    private static void loadDriver() {
    }
}
