//
// PelajaranDaoTesting.java
// Jadwal-Materi 
//
// Created by Agung Pramono on 11/10/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.test;

import com.agung.jadwal.dao.PelajaranDao;
import com.agung.jadwal.domain.Materi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class PelajaranDaoTesting {

    private Connection con;
    private PelajaranDao pd;

    @Before
    public void setup() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/db_trainingapp";
        String dbUser = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        pd = new PelajaranDao();
    }
    
    @Test
    public void testSave() throws SQLException{
        Materi p = new Materi();
        p.setId(6);
        p.setKode("test-007");
        p.setMateri("Software Testing Foundation");
        
        pd.saveMateri(p);
        
        String sql = "select * from pelajaran where kode_mapel='test-007'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        while (rs.next()) {            
            Assert.assertEquals("test-007", rs.getString("kode_mapel"));
            Assert.assertEquals("Software Testing Foundation",rs.getString("nama_mapel"));
        }
    }
    
    @After
    public void deleteDataTest() throws SQLException{
        String sql = "delete from pelajaran where kode_mapel like '%test%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        
        con.close();
    }
    
}
