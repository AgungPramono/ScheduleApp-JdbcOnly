//
// JadwalExporter.java
// Jadwal-Materi 
//
// Created by Agung Pramono on 24/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.util;

import com.agung.jadwal.domain.Jadwal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class untuk melakukan export data yang di query dari database
 * kemudian data di tulis kedalam file dengan format csv
 */
public class JadwalExporter {

    public static void exportToCsv(List<Jadwal> data, File destination) {
        try (PrintWriter output = new PrintWriter(destination)) {

            output.println("id,hari,jam,materi,ruang,instructor");
            for (Jadwal jadwal : data) {
                System.out.println("Proses Export");
                output.print(jadwal.getId());
                output.print(",");
                output.print(jadwal.getHari());
                output.print(",");
                output.print(jadwal.getJam());
                output.print(",");
                output.print(jadwal.getPelajaran().getMateri());
                output.print(",");
                output.print(jadwal.getRuang().getRuang());
                output.print(",");
                output.print(jadwal.getGuru().getNamaGuru());
                output.println();
                output.flush();
            }
            System.out.println("Selesai");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JadwalExporter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
