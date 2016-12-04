//
// InstructorDao.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 22/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.dao;

import com.agung.jadwal.domain.Instructor;
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
public class InstructorDao {
    
    private final ch.qos.logback.classic.Logger LOGGER = new ch.qos.logback.classic.LoggerContext()
            .getLogger(InstructorDao.class);

    private static final String SQl_SELECT_ALL = "select * from guru";
    private static final String SQL_SAVE = "insert into guru (kode_guru,nama_guru) values (?,?)";

    public void saveTrainer(Instructor t){
        try {
            trainerSaveProcess(t);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDao.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER.debug(ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstructorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void trainerSaveProcess(Instructor t) throws SQLException, ClassNotFoundException{
        Connection con = KoneksiHelper.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_SAVE);
        ps.setString(1, t.getKodeGuru());
        ps.setString(2, t.getNamaGuru());
        ps.executeUpdate();
        KoneksiHelper.destroyConnection(con);
    }
    
    //cari semua data guru
    public List<Instructor> cariSemua() {
        try {
            return findAllProcess();
        } catch (SQLException | ClassNotFoundException ex) {
            LOGGER.warn(ex.getMessage());
        }
        return null;
    }
    
    private List<Instructor> findAllProcess() throws SQLException, ClassNotFoundException{
        List<Instructor> result = new ArrayList<>();
        Connection con = KoneksiHelper.getConnection();
        PreparedStatement ps = con.prepareStatement(SQl_SELECT_ALL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Instructor t = resultSetConverter(rs);
            result.add(t);
        }
        KoneksiHelper.destroyConnection(con);
        return result;
    }

    private Instructor resultSetConverter(ResultSet rs) throws SQLException {
        Instructor g = new Instructor();
        g.setId(rs.getInt("id"));
        g.setKodeGuru(rs.getString("kode_guru"));
        g.setNamaGuru(rs.getString("nama_guru"));
        return g;
    }

}
