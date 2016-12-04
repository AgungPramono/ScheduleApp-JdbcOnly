//
// Jadwal.java
// Jadwal-Materi 
//
// Created by Agung Pramono on 29/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.domain;

/**
 *
 */
public class Jadwal {
   private Integer id;
   private Integer jam;
   private String hari;
   private Materi pelajaran;
   private Ruang ruang;
   private Instructor instructor;

    public Integer getJam() {
        return jam;
    }

    public void setJam(Integer jam) {
        this.jam = jam;
    }
   
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Ruang getRuang() {
        return ruang;
    }

    public void setRuang(Ruang ruang) {
        this.ruang = ruang;
    }
   
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

    public Materi getPelajaran() {
        return pelajaran;
    }

    public void setPelajaran(Materi pelajaran) {
        this.pelajaran = pelajaran;
    }

    @Override
    public String toString() {
        return pelajaran.getMateri();
    }
   
    
}
