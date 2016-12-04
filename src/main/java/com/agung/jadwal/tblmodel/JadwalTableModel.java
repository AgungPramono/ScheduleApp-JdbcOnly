//
// JadwalTableModel.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 30/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.tblmodel;

import com.agung.jadwal.domain.Jadwal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 */
public class JadwalTableModel extends AbstractTableModel {

    private final List<Jadwal> ListJadwal;
    private final String[] header = {"JAM KE","HARI","PELAJARAN","RUANG","INSTRUCTOR"};

    public JadwalTableModel(List<Jadwal> list) {
        this.ListJadwal = list;
    }

    @Override
    public int getRowCount() {
        return ListJadwal.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jadwal j = ListJadwal.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return j.getJam();
            case 1:
                return j.getHari().toUpperCase();
            case 2:
                return j.getPelajaran().getMateri();
            case 3:
                return j.getRuang().getRuang();
            case 4:
                return j.getInstructor().getNamaGuru();
            default:
                return new Object();
        }
    }
}
