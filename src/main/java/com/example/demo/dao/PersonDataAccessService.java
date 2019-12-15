package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


// he we are saying we have postgres db and we want to use it.
 // this is where dependency injectin comes into play.
// now in our person service, we change the qualifer annotation
@Repository("postgress")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    // dependcy injection here
    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person(UUID.randomUUID() , "from postgresql db" ));
    }

    @Override
    public int deletePersonById(UUID uuid) {
        return 0;
    }

    @Override
    public int updatePerson(UUID uuid, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> getPersonById(UUID uuid) {
        return Optional.empty();
    }
}
