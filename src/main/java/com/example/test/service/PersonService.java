package com.example.test.service;

import com.example.test.domain.Person;
import com.example.test.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;


    public Person save(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return (List<Person>) personRepository.findAll();
    }

    public Person findOne(Integer id){
        return personRepository.findById(id).get();
    }


}
