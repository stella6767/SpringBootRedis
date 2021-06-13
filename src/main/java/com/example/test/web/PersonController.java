package com.example.test.web;


import com.example.test.domain.Address;
import com.example.test.domain.Person;
import com.example.test.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public Person save(){
        Address address = new Address("부산시");
        Person person = new Person(null, "kang", 28, Person.Gender.MALE, address);

        Person personEntity = personService.save(person);

        log.info(personEntity + " 이 저장되었습니다.");

        return personEntity;
    }


    @GetMapping("/person")
    public List<Person> getAll(){

        List<Person> personList = personService.findAll();

        log.info(personList+" 들이 있습니다.");

        return personList;
    }

    @GetMapping("/person/{id}")
    public void getById(@PathVariable Integer id){
        //@id는 해시값으로 무작위하게 들어가는 듯..
        Person person = personService.findOne(id);


        log.info(id+"인 사람 " + person + "을 찾았습니다.");

    }

}
