package com.example.test.domain;


import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    //RedisRepository


}
