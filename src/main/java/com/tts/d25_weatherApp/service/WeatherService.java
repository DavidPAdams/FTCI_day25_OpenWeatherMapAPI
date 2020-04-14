package com.tts.d25_weatherApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.d25_weatherApp.model.Zips;
import com.tts.d25_weatherApp.repository.ZipCodeRepository;
import com.tts.d25_weatherApp.response.Response;

@Service
public class WeatherService {
  
  @Autowired
  private ZipCodeRepository zipCodeRepository;
  
  @Value("${api_key}")
  private String apiKey;

  public Response getForcast(String zipCode) {
    String url = "http://api.openweathermap.org/data/2.5/weather?zip="
        + zipCode + "&units=imperial&appid=" + apiKey;
    RestTemplate restTemplate = new RestTemplate();
    Response response = new Response();
    List<Zips> zipCodeList = zipCodeRepository.findAll();
    try {
      response = restTemplate.getForObject(url, Response.class);
      Zips zip = new Zips();
      zip.setZipCode(zipCode);
      zipCodeList.add(zip);
    } 
    catch(HttpClientErrorException ex) {
      response.setName("error");
    }
    return response;
  }
  
  
  
}
