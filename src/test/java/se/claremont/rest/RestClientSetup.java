package se.claremont.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import java.io.IOException;

public class RestClientSetup {

    public static void setupUnirest() {
        Unirest.setDefaultHeader("Content-Type", "application/json");
        Unirest.setObjectMapper(
                new ObjectMapper() {
                    @Override
                    public <T> T readValue(String s, Class<T> aClass) {
                        try {
                            return new com.fasterxml.jackson.databind.ObjectMapper().readValue(s, aClass);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public String writeValue(Object o) {
                        try {
                            return new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(o);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

}
