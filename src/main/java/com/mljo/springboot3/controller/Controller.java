package com.mljo.springboot3.controller;

import com.mljo.springboot3.entity.Person;
import com.mljo.springboot3.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    static final Logger logger = LogManager.getLogger(Controller.class.getName());

    @Autowired
    private PersonService service;

    @PostMapping("/addPerson")
    public Person addUser(@RequestBody Person user) {
        logger.info("Add new Person to DB");
        return service.savePerson(user);
    }

    @PostMapping("/addPersons")
    public List<Person> addUsers(@RequestBody List<Person> users) {
        return service.savePersons(users);
    }

    @GetMapping("/persons")
    public List<Person> findAllUsers() {
        return service.getPersons();
    }

    @GetMapping("/userById/{id}")
    public Person findUserById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping("/person/{name}")
    public Person findPersonByName(@PathVariable String name) {
        return service.getPersonByName(name);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person User) {
        return service.updatePerson(User);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        return service.deletePerson(id);
    }
}
