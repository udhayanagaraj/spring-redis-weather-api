package com.api.weather_api.Redis;


import com.api.weather_api.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, WeatherResponse> redisTemplate;

    public void saveData(String key,WeatherResponse value,long timeoutInSeconds){
        redisTemplate.opsForValue().set(key,value,timeoutInSeconds, TimeUnit.SECONDS);
    }

    public WeatherResponse getData(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean deleteData(String key){
       return redisTemplate.delete(key);
    }
}
