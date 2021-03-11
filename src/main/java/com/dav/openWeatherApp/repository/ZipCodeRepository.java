package com.dav.openWeatherApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dav.openWeatherApp.model.Zips;

@Repository
public interface ZipCodeRepository
    extends CrudRepository<Zips, Long> {
  List<Zips> findAll();
  List<Zips> findAllByOrderByCreatedAtDesc();
}
