package com.example.test;


import com.example.test.service.RedisService;
import com.example.test.service.impl.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

//    @Autowired
//    private RedisServiceImpl redisServiceImpl;

    @Test
    void contextLoads() {
    }

    @Test
    void setDataExpire(){
        //redisServiceImpl.setDataExpire("test","test",20);
        redisService.setDataExpire("test","test",20);
        //redisService.setData("test","test");
    }
}
