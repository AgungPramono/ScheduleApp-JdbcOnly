//
// ImagePanel.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 24/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.ui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 */
public class ImagePanelTop extends JPanel {

    private final Image image;

    public ImagePanelTop() {
        image = new ImageIcon(getClass().getResource("/asset/image-top.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.drawImage(image,0,0,getWidth(),getHeight(),null);
        graphics.dispose();
    }

  

}
