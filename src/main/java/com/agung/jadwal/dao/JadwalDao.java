//
// JadwalDao.java
// Jadwal-Materi
//
// Created by Agung Pramono on 29/09/2016
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.dao;

import static com.agung.jadwal.dao.KoneksiHelper.*;

import com.agung.jadwal.domain.Trainer;
import com.agung.jadwal.domain.Jadwal;
import com.agung.jadwal.domain.Materi;
import com.agung.jadwal.domain.Ruang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class JadwalDao {

    /**
     * Join 4 tabel : Jadwal,Materi,ruang, guru
     */
    private final StringBuilder sbQuery = new StringBuilder(
            " select j.*,p.kode_mapel,p.nama_mapel,"
            + " r.ruang as nama_ruang,r.kode_ruang,g.nama_guru "
            + " from jadwal j "
            + " join pelajaran p on j.id_mapel = p.id "
            + " join ruang r on j.id_ruang = r.id "
            + " join guru g on j.id_guru = g.id "
    );

    private static final String SQL_INSERT = "insert into jadwal (hari,jam,id_ruang,id_mapel,id_guru) values (?,?,?,?,?)";
    private static final String SQL_UPDATE = "update jadwal set hari=?,jam=?,id_ruang=?,id_mapel=?,id_guru=? where id=? ";
    private static final String SQL_DELETE = "delete from jadwal where id=?";

    /**
     * Simpan objek jadwal
     *
     * @param j Jadwal
     */
    public void simpanJadwal(Jadwal j) {
        try {
            saveProcess(j);
        } catch (SQLException ex) {
            Logger.getLogger(JadwalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveProcess(Jadwal j) throws SQLException{
        if (j.getId() == null) {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, j.getHari());
            ps.setInt(2, j.getJam());
            ps.setInt(3, j.getRuang().getId());
            ps.setInt(4, j.getPelajaran().getId());
            ps.setInt(5, j.getGuru().getId());
            ps.executeUpdate();
            destroyConnection(conn);
        } else {
            Connection con = getConnection();
            PreparedStatement ps = con
                    .prepareStatement(SQL_UPDATE);
            ps.setString(1, j.getHari());
            ps.setInt(2, j.getJam());
            ps.setInt(3, j.getRuang().getId());
            ps.setInt(4, j.getPelajaran().getId());
            ps.setInt(5, j.getGuru().getId());
            ps.setInt(6, j.getId());
            ps.executeUpdate();
            destroyConnection(con);
        }
    }

    /**
     *
     * @return List jadwal pelajaran
     */
    public List<Jadwal> cariSemuaJadwals() {
        try {
            return findAllJadwals();
        } catch (SQLException ex) {
            Logger.getLogger(JadwalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<Jadwal> findAllJadwals() throws SQLException{
        List<Jadwal> dataJadwals = new ArrayList<>();
        //sbQuery.append(" order by p.nama_mapel");

        Connection con = getConnection();
        ResultSet rs = con.prepareStatement(sbQuery.toString()).executeQuery();

        while (rs.next()) {
            Jadwal jadwal = jadwalResultSetConverter(rs);
            dataJadwals.add(jadwal);
        }

        destroyConnection(con);
        return dataJadwals;
    }

    /**
     * mencari jadwal berdasarkan nama mata pelajaran
     *
     * @param mapel nama mata pelajaran
     * @return List pelajaran
     */
    public List<Jadwal> cariJadwalByMapel(String mapel) {

        try {
            return findJadwalByMapel(mapel);
        } catch (SQLException ex) {
            Logger.getLogger(JadwalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<Jadwal> findJadwalByMapel(String mapel) throws SQLException{
        List<Jadwal> dataJadwals = new ArrayList<>();
        sbQuery.append(" where p.nama_mapel like ? order by p.nama_mapel");

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sbQuery.toString());
        ps.setString(1, "%" + mapel.toLowerCase() + "%");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Jadwal jadwal = jadwalResultSetConverter(rs);
            dataJadwals.add(jadwal);
        }

        destroyConnection(con);
        return dataJadwals;
    }

    private void deleteJadwalById(Integer id) throws SQLException{
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_DELETE);
        ps.setInt(1, id);
        ps.executeUpdate();
        destroyConnection(con);
    }

    public void deleteJadwal(Integer id) {
        try {
            deleteJadwalById(id);
        } catch (SQLException ex) {
            Logger.getLogger(JadwalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Konversi ResultSet ke Objek
     *
     * @param rs ResultSet
     * @return objek Jadwal
     * @throws SQLException
     */
    private Jadwal jadwalResultSetConverter(ResultSet rs) throws SQLException {
        Jadwal jd = new Jadwal();
        jd.setId(rs.getInt("id"));
        jd.setHari(rs.getString("hari"));
        jd.setJam(rs.getInt("jam"));

        Materi p = new Materi();
        p.setMateri(rs.getString("nama_mapel"));
        p.setKode(rs.getString("kode_mapel"));
        jd.setPelajaran(p);

        Ruang r = new Ruang();
        r.setRuang(rs.getString("nama_ruang"));
        r.setKodeRuang(rs.getString("kode_ruang"));
        jd.setRuang(r);

        Trainer g = new Trainer();
        g.setNamaGuru(rs.getString("nama_guru"));
        jd.setGuru(g);

        return jd;
    }
}
