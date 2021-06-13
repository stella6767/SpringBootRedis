package com.example.test;

import com.example.test.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Arrays;

@EnableCaching
@SpringBootApplication
public class TestApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

    }


    @Bean
    public CommandLineRunner datainit(StringRedisTemplate stringRedisTemplate) {
        return (args) -> {
            // 데이터 초기화하기
            ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
            valueOperations.set("1","test");
        };
    }


}
