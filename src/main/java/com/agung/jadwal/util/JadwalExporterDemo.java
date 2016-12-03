//
// JadwalExporterDemo.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 24/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.util;

import com.agung.jadwal.dao.JadwalDao;
import com.agung.jadwal.domain.Jadwal;
import java.io.File;
import java.util.List;

/**
 *
 */
public class JadwalExporterDemo {
    public static void main(String[] args) {
        String pathFile = "D:/jadwal.csv";
        File tujuan = new File(pathFile);
        
        JadwalDao jd = new JadwalDao();
        List<Jadwal> data = jd.cariSemuaJadwals();
        
        JadwalExporter.exportToCsv(data, tujuan);
    }
}
