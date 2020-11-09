package com.tts.weatherapp.repositories;

import com.tts.weatherapp.model.Storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository<Storage, String> {
    

    



}