//
// JadwalDaoTest.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 01/10/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.test;

import com.agung.jadwal.dao.JadwalDao;
import com.agung.jadwal.domain.Jadwal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */

public class JadwalDaoTest {

    private Connection con;
    private JadwalDao jd;
    
    @Before
    public void setup() throws SQLException, ClassNotFoundException{
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/db_trainingapp";
        String dbUser = "root";
        String dbPassword = "root";
        
        Class.forName(dbDriver);
        con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        
        jd = new JadwalDao();
    }
    
    @After
    public void disconnect() throws SQLException{
        if (con != null) {
            con.close();
        }
    }
    
    @Test
    public void testFindAll(){
        List<Jadwal> resultJadwals = new ArrayList<>();
        
        resultJadwals = jd.cariSemuaJadwals();
        
        Assert.assertNotNull(resultJadwals);
        Assert.assertFalse(resultJadwals.isEmpty());
        
    }
    
    //@Test
    public void testFindByName(){
        List<Jadwal> j = jd.cariJadwalByMapel("Android");
        Assert.assertNotNull(j);
    }
}
