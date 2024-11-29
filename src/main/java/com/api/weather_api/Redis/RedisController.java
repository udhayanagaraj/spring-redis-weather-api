package com.api.weather_api.Redis;


import com.api.weather_api.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/save")
    public ResponseEntity<String> getData(@RequestParam String key,@RequestBody WeatherResponse value,@RequestParam long timeout){
        try{
            redisService.saveData(key,value,timeout);
            return new ResponseEntity<>("Created",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get")
    public ResponseEntity<?> getData(@RequestParam String key){
        try{
            Object response = redisService.getData(key);
            if( response == null) {
                return new ResponseEntity<>("key not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteData(@RequestParam String key){
        try {
            if(!redisService.deleteData(key)){
                return new ResponseEntity<>("Key not found",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
