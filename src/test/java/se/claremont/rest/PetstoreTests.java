package se.claremont.rest;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

public class PetstoreTests {

    @BeforeClass
    public static void setup(){
        RestClientSetup.setupUnirest();
    }

    PetStoreClient client = new PetStoreClient();

    @Test
    public void getPetFromPetstore() throws UnirestException {

        Pet fido = new Pet(
                343409984,
                "Fido",
                Collections.singletonList("www.google.se"),
                "available"
        );

        client.createPet(fido);
        Pet fidoAgain = client.getPetById(343409984);

        Assert.assertEquals(
                "Fido",
                fidoAgain.getName()
        );
    }
}
