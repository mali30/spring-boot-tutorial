package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


// tells it that we use HTTP methods
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // post request
    // the requestbody says we take the data we get and put that into a Person
    // cant be blank or null
    @PostMapping
    public void addPerson(@RequestBody @NotBlank @NonNull Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPeople();
    }

    @DeleteMapping
    public int deletePerson(UUID uuid){
        return personService.deletePersonById(uuid);
    }


    // grabs by id from the path
    @GetMapping(path= "/{id}")
    public Person getPersonByID(@PathVariable("id")UUID uuid){
        return personService.getPersonById(uuid).orElse
                (null);
    }

    @DeleteMapping(path="/{id}")
    public void deletePersonById(@PathVariable("id") UUID uuid){
        personService.deletePersonById(uuid);
    }

    @PutMapping(path = "/{id}")
    public void updatePerson(@PathVariable("id") UUID uuid , @Valid @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(uuid, personToUpdate);
    }


}
