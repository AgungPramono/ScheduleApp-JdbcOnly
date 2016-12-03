//
// Ruang.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 29/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.domain;

/**
 *
 */
public class Ruang {
    private Integer id;
    private String kodeRuang;
    private String ruang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode_ruang() {
        return kodeRuang;
    }

    public void setKodeRuang(String kode_ruang) {
        this.kodeRuang = kode_ruang;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }
    
}
