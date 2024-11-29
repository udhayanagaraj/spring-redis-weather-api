package com.api.weather_api.Weather;

import com.api.weather_api.Redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/get")
    public ResponseEntity<?> getWeather(@RequestParam String location){
        try{
            WeatherResponse redisResponse = redisService.getData(location);
            if(redisResponse != null) {
                return new ResponseEntity<>(redisResponse, HttpStatus.OK);
            }

            WeatherResponse response = weatherService.getWeather(location);

            if (response == null) {
                return new ResponseEntity<>("Invalid location", HttpStatus.NOT_FOUND);
            }
            redisService.saveData(location,response,3600);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
