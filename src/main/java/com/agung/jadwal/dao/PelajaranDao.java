//
// PelajaranDao.java
// Jadwal-Materi 
//
// Created by Agung Pramono on 29/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.dao;

import com.agung.jadwal.domain.Materi;
import static com.agung.jadwal.dao.KoneksiHelper.*;
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
public class PelajaranDao {

    private static final String SQL_SAVE = "insert into pelajaran (kode_mapel,nama_mapel) values (?,?)";
    private static final String SQL_UPDATE = "update pelajaran set kode_mapel=?, nama_mapel=? where id=?";
    private static final String SQL_DELETE = "delete from pelajaran where id=?";
    private static final String SQL_SELECT_ALL = "select * from pelajaran";

    /**
     * Simpan data pelajaran
     *
     * @param p objek pelajaran
     */
    public void saveMateri(Materi p) {
        try {
            saveProcess(p);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PelajaranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMateri(Integer id) {
        try {
            deleteProcess(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PelajaranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveProcess(Materi m) throws SQLException, ClassNotFoundException {
        if (m.getId() == null) {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_SAVE);
            ps.setString(1, m.getKode());
            ps.setString(2, m.getMateri());
            ps.executeUpdate();
            destroyConnection(conn);
        } else {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, m.getKode());
            ps.setString(2, m.getMateri());
            ps.setInt(3, m.getId());
            ps.executeUpdate();
            destroyConnection(conn);
        }
    }

    private void deleteProcess(Integer id) throws SQLException, 
            ClassNotFoundException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setInt(1, id);
        ps.executeUpdate();
        destroyConnection(con);
    }

    private List<Materi> findAllMateriProcess() throws SQLException, 
            ClassNotFoundException {
        List<Materi> dataList = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Materi p = pelajaranResultSetConverter(rs);
            dataList.add(p);
        }
        destroyConnection(con);
        return dataList;
    }

    /**
     * Cari semua daftar mata pelajaran
     *
     * @return
     */
    public List<Materi> findAll() {
        try {
            return findAllMateriProcess();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PelajaranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Konversi setiap Result set ke tiap2 property Objek pelajaran
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Materi pelajaranResultSetConverter(ResultSet rs) throws SQLException {
        Materi p = new Materi();

        p.setId(rs.getInt("id"));
        p.setKode(rs.getString("kode_mapel"));
        p.setMateri(rs.getString("nama_mapel"));

        return p;
    }

}
