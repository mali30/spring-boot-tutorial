package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    private final UUID uuid;

    // cant be blank
    @NotBlank
    private final String name;

    // mapping the id and name as json values.
    // using postman to send data over
    public Person(@JsonProperty("id") UUID uuid,
                  @JsonProperty("name") String name){
        this.uuid = uuid;
        this.name = name;

    }

    public UUID getUuid(){
        return this.uuid;
    }

    public String getName(){
        return this.name;
    }


}
