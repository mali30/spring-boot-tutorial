package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// this is a service
@Service
public class PersonService {

    private final PersonDao personDao;

    // autoworing this interface
    @Autowired
    public PersonService(@Qualifier("postgress") PersonDao personDao){
        this.personDao = personDao;
    }


   public int addPerson(Person person){
        return personDao.insertPerson(person);
   }

   public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
   }

    public Optional<Person> getPersonById(UUID uuid){
        return personDao.getPersonById(uuid);
    }


   public int deletePersonById(UUID uuid){
        return personDao.deletePersonById(uuid);
   }


   public int updatePerson(UUID uuid, Person person){
        return personDao.updatePerson(uuid,person);
   }



}
