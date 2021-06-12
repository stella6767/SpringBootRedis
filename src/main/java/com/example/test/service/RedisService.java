package com.example.test.service;

public interface RedisService {

    String getData(String key);

    void setData(String key, String value);

    void setDataExpire(String key, String value, int duration);
}