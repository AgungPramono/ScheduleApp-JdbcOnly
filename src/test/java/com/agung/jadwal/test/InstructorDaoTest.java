//
// InstructorDaoTest.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 01/12/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.test;

import com.agung.jadwal.dao.InstructorDao;
import com.agung.jadwal.domain.Trainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class InstructorDaoTest {

    private Connection con;
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/db_trainingapp";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "root";
    
    private InstructorDao instructorDao = new InstructorDao();
    
    //@Before
    public void setUp()throws Exception{
        Class.forName(DB_DRIVER);
        con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    
    @Test
    public void testFindAllInstructor(){
        List<Trainer> resultAll = instructorDao.cariSemua();
        Assert.assertNotNull(resultAll);
        for (Trainer t : resultAll) {
            System.out.println("kode "+ t.getKodeGuru());
        }
    }
    
    //@After
    public void tearDown() throws SQLException{
        if (con != null) {
            con.close();
        }
    }
}
