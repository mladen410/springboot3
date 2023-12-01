package com.mljo.springboot3.service;

import com.mljo.springboot3.entity.Person;
import com.mljo.springboot3.repo.PersonRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


import static io.restassured.RestAssured.when;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;
import static org.hamcrest.Matchers.hasItems;

@Testcontainers
@SpringBootTest(webEnvironment = DEFINED_PORT)
class PersonServiceTest{

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:15.2-alpine");

    @Autowired
    private PersonRepository personRepository;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }


    @Test
    void savePerson() {

        personRepository.save(new Person(1,"A"));
        personRepository.save(new Person(2,"B"));

        when().get("/persons")
                .then().statusCode(200)
                .and().body("name", hasItems("A", "B"));
    }

    @Test
    void savePersons() {
    }

    @Test
    void getPersons() {
    }

    @Test
    void getPersonById() {
    }

    @Test
    void getPersonByName() {
    }

    @Test
    void deletePerson() {
    }

    @Test
    void updatePerson() {
    }
}