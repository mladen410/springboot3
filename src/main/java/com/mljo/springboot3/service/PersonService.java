package com.mljo.springboot3.service;

import com.mljo.springboot3.entity.Person;
import com.mljo.springboot3.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        return repository.saveAll(persons);
    }

    public List<Person> getPersons() {
        return repository.findAll();
    }

    public Person getPersonById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Person getPersonByName(String name) {
        return repository.findByName(name);
    }

    public String deletePerson(int id) {
        repository.deleteById(id);
        return "person removed !! " + id;
    }

    public Person updatePerson(Person product) {
        Person person = repository.findById(product.getId()).orElse(null);
        person.setName(product.getName());
        return repository.save(person);
    }

}
