package com.example.test;


import com.example.test.domain.Address;
import com.example.test.domain.Person;
import com.example.test.domain.PersonRepository;
import com.example.test.service.RedisService;
import com.example.test.service.impl.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisServiceTest {


    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void setDataExpire(){
        //redisServiceImpl.setDataExpire("test","test",20);
        redisService.setDataExpire("test","test",20);
        //redisService.setData("test","test");
    }


    @Test
    void redisConnectionTest() {
        final String key = "a";
        final String data = "1";

        final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, data);

        final String result = valueOperations.get(key);
        assertEquals(data, result);
    }


    @Test
    public void personSaveTest() {
        // given
        Address address = new Address("서울특별시 서울시청");
        Person person = new Person(null, "kangmingyu", 28, Person.Gender.MALE, address);

        // when
        Person personEntity = personRepository.save(person);

        // then
        Optional<Person> findPerson = personRepository.findById(personEntity.getId());

        assertThat(findPerson.isPresent()).isEqualTo(Boolean.TRUE);
        assertThat(findPerson.get().getAge()).isEqualTo(person.getAge());
    }



}
