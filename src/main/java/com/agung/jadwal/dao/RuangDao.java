//
// RuangDao.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 22/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.dao;

import com.agung.jadwal.domain.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class RuangDao {

    private static final String SQL_SAVE_RUANG = "insert into ruang (kode_ruang,ruang) values (?,?)";
    private static final String SQL_SELECT_ALL = "select * from ruang"; 

    public void saveRuang(Ruang ruang) {
        try {
            saveRuangProcess(ruang);
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ruang> cariSemuaRuang() {
        try {
            return loadRuang();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<Ruang> loadRuang() throws SQLException,
            ClassNotFoundException {
        List<Ruang> result = new ArrayList<>();
        Connection con = KoneksiHelper.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ruang r = converResutSetToRuang(rs);
            result.add(r);
        }
        KoneksiHelper.destroyConnection(con);
        return result;
    }

    private void saveRuangProcess(Ruang ruang) throws SQLException{
        Connection conn = KoneksiHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_SAVE_RUANG);
        ps.setString(1, ruang.getKode_ruang());
        ps.setString(2, ruang.getRuang());
        ps.executeUpdate();
        KoneksiHelper.destroyConnection(conn);
    }

    private Ruang converResutSetToRuang(ResultSet rs) throws SQLException {
        Ruang ruang = new Ruang();
        ruang.setId(rs.getInt("id"));
        ruang.setKodeRuang(rs.getString("kode_ruang"));
        ruang.setRuang(rs.getString("ruang"));
        return ruang;
    }
}
