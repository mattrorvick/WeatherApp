package com.tts.weatherapp.service;

import com.tts.weatherapp.model.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    

    @Value("${api_key}")
    private String apiKey;


    //make a call to openweather API, with dynamic zipcode and apikey
    public Response getForecast(String zipCode) {

        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        //shove the response in a response "object"
        try {
            return restTemplate.getForObject(url, Response.class);
        } catch(HttpClientErrorException exception) {
            Response response = new Response();
            response.setName("ERROR");
            return response;
        }
    }


}