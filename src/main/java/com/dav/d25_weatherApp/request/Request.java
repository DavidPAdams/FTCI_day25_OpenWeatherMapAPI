package com.dav.d25_weatherApp.request;

public class Request {
  private String zipCode;

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "Request [zipCode=" + zipCode + "]";
  }

  public Request(String zipCode) {
    this.zipCode = zipCode;
  }

  public Request() {}
  
}
