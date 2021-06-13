package com.example.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Data
@RedisHash("person")		// 이 값이 redis key의 prefix 로 사용됨. ex) key = person:<id> 조합
public class Person {


    public enum Gender {
        MALE, FEMALE
    }

    @Id
    private Integer id;

    private String name;
    private Integer age;
    private Gender gender;

    private Address address;

}
