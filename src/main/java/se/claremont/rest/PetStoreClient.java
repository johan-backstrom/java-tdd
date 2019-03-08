package se.claremont.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PetStoreClient {

    String baseUrl = "http://petstore.swagger.io/v2";


    public void createPet(Pet petToAdd) {
        // Setup
        try {
            HttpResponse<String> response = Unirest
                    .post(baseUrl.concat("/pet"))
                    .body(petToAdd)
                    .asString();

            if (response.getStatus() != 200) {
                throw new RuntimeException("FAil: " + response.getStatus());
            }

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet getPetById(int id) {
        try {
            HttpResponse<Pet> response = Unirest
                    .get(baseUrl.concat("/pet/" + id))
                    .asObject(Pet.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("FAil: " + response.getStatus());
            }

            return response.getBody();

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
