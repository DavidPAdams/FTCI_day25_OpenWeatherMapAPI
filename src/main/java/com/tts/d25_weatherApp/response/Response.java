package com.tts.d25_weatherApp.response;

import java.util.List;
import java.util.Map;

public class Response {
  private Map<String, String> coord;
  private List<Map<String, String>> weather;
  private String base;
  private Map<String, String> main;
  private Map<String, String> wind;
  private Map<String, String> clouds;
  private String dt;
  private Map<String, String> sys;
  private String id;
  private String name;
  private String cod;
  public Map<String, String> getCoord() {
    return coord;
  }
  public List<Map<String, String>> getWeather() {
    return weather;
  }
  public String getBase() {
    return base;
  }
  public Map<String, String> getMain() {
    return main;
  }
  public Map<String, String> getWind() {
    return wind;
  }
  public Map<String, String> getClouds() {
    return clouds;
  }
  public String getDt() {
    return dt;
  }
  public Map<String, String> getSys() {
    return sys;
  }
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getCod() {
    return cod;
  }
  public void setCoord(Map<String, String> coord) {
    this.coord = coord;
  }
  public void setWeather(List<Map<String, String>> weather) {
    this.weather = weather;
  }
  public void setBase(String base) {
    this.base = base;
  }
  public void setMain(Map<String, String> main) {
    this.main = main;
  }
  public void setWind(Map<String, String> wind) {
    this.wind = wind;
  }
  public void setClouds(Map<String, String> clouds) {
    this.clouds = clouds;
  }
  public void setDt(String dt) {
    this.dt = dt;
  }
  public void setSys(Map<String, String> sys) {
    this.sys = sys;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setCod(String cod) {
    this.cod = cod;
  }
  @Override
  public String toString() {
    return "Response [base=" + base + ", dt=" + dt + ", id="
        + id + ", name=" + name + ", cod=" + cod + "]";
  }
  public Response(Map<String, String> coord,
      List<Map<String, String>> weather, String base,
      Map<String, String> main, Map<String, String> wind,
      Map<String, String> clouds, String dt,
      Map<String, String> sys, String id, String name,
      String cod) {
    this.coord = coord;
    this.weather = weather;
    this.base = base;
    this.main = main;
    this.wind = wind;
    this.clouds = clouds;
    this.dt = dt;
    this.sys = sys;
    this.id = id;
    this.name = name;
    this.cod = cod;
  }
  
  public Response() {}
  
}
