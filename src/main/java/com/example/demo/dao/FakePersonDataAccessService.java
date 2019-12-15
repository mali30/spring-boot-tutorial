package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


// this class is served as a repository
// the fakeDao lets you have multiple implementations.
// based on what kind of implemenation you have you give it the name
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> personList = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personList.add(new Person(id, person.getName()));
        return 1;
    }



    @Override
    public List<Person> selectAllPeople() {
        return personList;
    }
    // stream processes a collection of objects

    @Override
    public Optional<Person> getPersonById(UUID uuid) {
        return personList.stream().filter(person ->
                person.getUuid().equals(uuid)).findFirst();
    }


    @Override
    public int deletePersonById(UUID uuid) {
        Optional<Person> personToDelete = getPersonById(uuid);
        if(personToDelete.isEmpty()){
            return 0;
        }
        personList.remove(personToDelete.get());

        return 1;
        }



    /* here we update the person we want to delete to the person
     we are updating to.
     we ran into a bug wit the updating.
     What was happening was we were getting the wrong index so we always got -1
     and also we needed a new Person since the person we pass in does not have an uuid
     because the uuid are generated
    */
    @Override
    public int updatePerson(UUID uuid, Person person) {
        return getPersonById(uuid).map(p ->{
            int indexOfPersonToDelete = personList.indexOf(p);
            if(indexOfPersonToDelete >= 0){
                personList.set(indexOfPersonToDelete,new Person(uuid , person.getName()));
                return 1;
            }
                return 0;

        }).orElse(0);
    }



}
