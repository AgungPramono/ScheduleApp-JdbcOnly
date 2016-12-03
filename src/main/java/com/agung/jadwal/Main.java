//
// Main.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 29/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal;


import com.agung.jadwal.ui.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 */
public class Main {  
    public static void setLookAndFeel(){
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    } catch (ClassNotFoundException | 
                            InstantiationException | 
                            IllegalAccessException |
                            UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    }
   
    public static void main(String[] args) throws Exception{
        setLookAndFeel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
