package com.example.test;


import com.example.test.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    void setData(){
        redisService.setDataExpire("test","test",20);
    }
}
