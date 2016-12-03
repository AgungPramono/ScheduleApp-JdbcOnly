//
// Trainer.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 30/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.domain;

/**
 *
 */
public class Trainer {

    private Integer id;
    private String kodeGuru;
    private String namaGuru;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKodeGuru() {
        return kodeGuru;
    }

    public void setKodeGuru(String kodeGuru) {
        this.kodeGuru = kodeGuru;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }
}
