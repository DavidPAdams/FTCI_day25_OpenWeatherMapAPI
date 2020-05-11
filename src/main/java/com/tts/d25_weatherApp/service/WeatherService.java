package com.tts.d25_weatherApp.service;

import java.util.ArrayList;
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
  
  public List<Zips> findAllByDate(){
    return zipCodeRepository.findAllByOrderByCreatedAtDesc();
  }

  public Response getForcast(String zipCode) {
    String url = "http://api.openweathermap.org/data/2.5/weather?zip="
        + zipCode + "&units=imperial&appid=" + apiKey;
    RestTemplate restTemplate = new RestTemplate();
    Response response = new Response();
    List<Zips> zipCodeList = findAll();
    try {
      response = restTemplate.getForObject(url, Response.class);
      Zips zip = new Zips();
      zip.setZipCode(zipCode);
      zipCodeList.add(zip);
      save(zip);
    } 
    catch(HttpClientErrorException ex) {
      response.setName("error");
    }
    return response;
  }
  
  public List<Zips> findAll() {
    return zipCodeRepository.findAll();
  }

  public void save(Zips zip) {
    zipCodeRepository.save(zip);
  }
  
  public List<Zips> getLastTenZips() {
    List<Zips> zipCodeList = findAllByDate();
    List<Zips> zipLastTen = new ArrayList<>();
    zipLoop:
      for(Zips zip : zipCodeList) {
        if (zipLastTen.size() <= 10) {
          zipLastTen.add(zip);
        } else {
          break zipLoop;
        }
      }
    return zipLastTen;
  }
  
}
