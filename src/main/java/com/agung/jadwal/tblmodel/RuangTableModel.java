//
// RuangTableModel.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 25/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.tblmodel;

import com.agung.jadwal.domain.Ruang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 */
public class RuangTableModel extends AbstractTableModel{

    private List<Ruang> listRuangs = new ArrayList<>();
    private final String[]header = {"Kode Ruang","Nama Ruang"};

    public RuangTableModel(List<Ruang> listRuangs) {
        this.listRuangs = listRuangs;
    }
    
    @Override
    public int getRowCount() {
        return listRuangs.size();
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
        Ruang r = listRuangs.get(rowIndex);
        switch(columnIndex){
            case 0:
                return r.getKode_ruang();
            case 1:
                return r.getRuang().toUpperCase();
            default:
                return new Object();
        }
    }

}
