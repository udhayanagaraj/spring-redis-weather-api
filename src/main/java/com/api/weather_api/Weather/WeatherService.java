package com.api.weather_api.Weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

    @Value("${weatherapi.base-url}")
    private String baseURL;

    @Value("${weatherapi.api-key}")
    private String key;

    @Autowired
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String location){
        String url_format = String.format("%s/current.json?key=%s&q=%s",baseURL,key,location);
        return restTemplate.getForObject(url_format,WeatherResponse.class);
    }
}
