//
// MateriTableModel.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 24/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.tblmodel;

import com.agung.jadwal.domain.Materi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 */
public class MateriTableModel extends AbstractTableModel{

    private List<Materi> materis = new ArrayList<>();
    private final String[]header = {"Kode Materi","Materi"};
    
    public MateriTableModel(List<Materi> materis) {
        this.materis = materis;
    }
    
    @Override
    public int getRowCount() {
        return materis.size();
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
        Materi m = materis.get(rowIndex);
        switch(columnIndex){
            case 0:return m.getKode();
            case 1:return m.getMateri().toUpperCase();
            default:return new Object();
        }
    }

}
