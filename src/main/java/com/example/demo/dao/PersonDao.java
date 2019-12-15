package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    // method to insert a person with an id and person
    int insertPerson(UUID id , Person person);

    // method to insert person with random id generated
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> selectAllPeople();

    int deletePersonById(UUID uuid);

    int updatePerson(UUID uuid, Person person);

    Optional<Person> getPersonById(UUID uuid);

}
