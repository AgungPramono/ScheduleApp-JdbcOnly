//
// KoneksiHelper.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 29/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class untuk configurasi koneksi database
 */
public class KoneksiHelper {
    private static Connection con;
    
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_trainingapp";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    
    public static Connection getConnection(){

        try {
            
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            if (con != null) {
                return con;
            }
            return null;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void destroyConnection(Connection con){
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(KoneksiHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
