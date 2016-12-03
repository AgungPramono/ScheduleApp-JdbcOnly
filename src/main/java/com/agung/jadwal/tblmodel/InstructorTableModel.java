//
// InstructorTableModel.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 27/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.tblmodel;

import com.agung.jadwal.domain.Trainer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 */
public class InstructorTableModel extends AbstractTableModel{

    private List<Trainer> listTrainers = new ArrayList<>();
    private final String[] header = {"kode Trainer","Nama Trainer"};

    public InstructorTableModel(List<Trainer> trainers) {
        this.listTrainers = trainers;
    }

    @Override
    public int getRowCount() {
        return listTrainers.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trainer t = listTrainers.get(rowIndex);
        switch(columnIndex){
            case 0:
                return t.getKodeGuru();
            case 1:
                return t.getNamaGuru();
            default:return new Object();
        }
    }
}
