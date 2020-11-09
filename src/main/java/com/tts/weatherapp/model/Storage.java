package com.tts.weatherapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zipid")
    private Long id;

    private String storeZipCode;


    public Storage() {
    }

    public Storage(String storeZipCode) {
        this.storeZipCode = storeZipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreZipCode() {
        return storeZipCode;
    }

    public void setStoreZipCode(String storeZipCode) {
        this.storeZipCode = storeZipCode;
    }

    @Override
    public String toString() {
        return "Storage [id=" + id + ", storeZipCode=" + storeZipCode + "]";
    }

    

    

    

    



}