//
// Report.java
// ScheduleApp-JdbcOnly 
//
// Created by Agung Pramono on 03/12/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.domain;

/**
 *
 */
public class Report {

    private Integer id;
    private String hari;
    private String pelajaran;
    private String ruang;
    private String instructor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getPelajaran() {
        return pelajaran;
    }

    public void setPelajaran(String pelajaran) {
        this.pelajaran = pelajaran;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
