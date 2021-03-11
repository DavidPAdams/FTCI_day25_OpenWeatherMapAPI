package com.dav.d25_weatherApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Zips {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "zip_id")
  private Long id;
  
  private String zipCode;

  @CreationTimestamp
  private Date createdAt;

  public Long getId() {
    return id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Zips() {
  }

  public Zips(Long id, String zipCode, Date createdAt) {
    this.id = id;
    this.zipCode = zipCode;
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Zips [id=" + id + ", zipCode=" + zipCode
        + ", createdAt=" + createdAt + "]";
  }

}
