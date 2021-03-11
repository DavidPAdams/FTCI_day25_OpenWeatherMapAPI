package com.dav.openWeatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dav.openWeatherApp.request.Request;
import com.dav.openWeatherApp.response.Response;
import com.dav.openWeatherApp.service.WeatherService;

@Controller
public class WeatherController {
  @Autowired
  private WeatherService weatherService;
  
  @GetMapping
  public String getIndex(Model model) {
    model.addAttribute("request", new Request());
    model.addAttribute("zips", weatherService.getLastTenZips());
    return "index";
  }
  
  @PostMapping
  public String postIndex(Request request, Model model) {
    Response response = weatherService.getForcast(request.getZipCode());
    model.addAttribute("zips", weatherService.getLastTenZips());
    model.addAttribute("data", response);
    return "index";
  }
  
}
