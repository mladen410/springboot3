package com.mljo.springboot3.repo;

import com.mljo.springboot3.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findByName(String name);
}
