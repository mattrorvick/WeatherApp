package com.tts.weatherapp.service;

import java.util.List;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.Storage;
import com.tts.weatherapp.repositories.ZipCodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    
    @Autowired
    private ZipCodeRepository zipCodeRepository;

    // public List<Storage> findZipCode() {
    
    //     return zipCodeRepository.findZipCode();
    // }

    @Value("${api_key}")
    private String apiKey;


    //make a call to openweather API, with dynamic zipcode and apikey
    public Response getForecast(String zipCode) {

        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();


        Storage storage = new Storage();
        storage.setStoreZipCode(zipCode);
        zipCodeRepository.save(storage);

        //shove the response in a response "object"
        try {
            return restTemplate.getForObject(url, Response.class);
        } catch(HttpClientErrorException exception) {
            Response response = new Response();
            response.setName("ERROR");
            return response;
        }

        
    }

    public Iterable<Storage> getRecentSearch() {

        return zipCodeRepository.findAll();
    }

    
}