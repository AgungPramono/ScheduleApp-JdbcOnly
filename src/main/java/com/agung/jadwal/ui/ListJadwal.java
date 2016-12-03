//
// ListJadwal.java
// Jadwal-Materi 
//
// Created by Agung Pramono on 29/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.ui;

import com.agung.jadwal.Main;
import com.agung.jadwal.dao.JadwalDao;
import com.agung.jadwal.domain.Jadwal;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 */
public class ListJadwal extends javax.swing.JFrame {

    private Jadwal jadwal;
    private List<Jadwal> listJadwal;
    private JadwalDao jadwalDao;

    public ListJadwal() {
        initComponents();
        loadDataToTable();
        setLocationRelativeTo(null);
        setTitle(".: Jadwal Pelajaran :."); //NOI18N

        tblJadwal.getSelectionModel().addListSelectionListener(new TableSelection());
    }

    private void loadDataToTable() {
        listJadwal = new ArrayList<>();

        jadwalDao = new JadwalDao();
        String keyword = txtKeyword.getText();

        if (keyword != null && !keyword.isEmpty()) {
         //   listJadwal = Main.getJadwalDao().cariJadwalByMapel(keyword);
        } else {
           // listJadwal = Main.getJadwalDao().cariSemuaJadwals();
        }

        //txtKeyword.setText("");
        tblJadwal.setModel(new JadwalTableModel(listJadwal));
        initColumn(tblJadwal);
    }

    private class JadwalTableModel extends AbstractTableModel {

        private final List<Jadwal> ListJadwal;
        private final String[] header = {java.util.ResourceBundle.getBundle("eng").getString("JAM KE"), java.util.ResourceBundle.getBundle("eng").getString("HARI"), java.util.ResourceBundle.getBundle("eng").getString("PELAJARAN"), java.util.ResourceBundle.getBundle("eng").getString("RUANG"), java.util.ResourceBundle.getBundle("eng").getString("INSTRUCTOR")};

        public JadwalTableModel(List<Jadwal> list) {
            this.ListJadwal = list;
        }

        @Override
        public int getRowCount() {
            return ListJadwal.size();
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public String getColumnName(int column) {
            return header[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Jadwal j = ListJadwal.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return j.getJam();
                case 1:
                    return j.getHari().toUpperCase();
                case 2:
                    return j.getPelajaran().getMateri();
                case 3:
                    return j.getRuang().getRuang();
                case 4:
                    return j.getGuru().getNamaGuru();
                default:
                    return new Object();
            }
        }
    }

    private class TableSelection implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }

            if (tblJadwal.getSelectedRow() >= 0) {
                jadwal = listJadwal.get(tblJadwal.getSelectedRow());
            }
        }

    }

    public static void initColumn(JTable jTable1) {
        JTableHeader header = jTable1.getTableHeader();
        int rowCount = jTable1.getRowCount();

        Enumeration columns = jTable1.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) jTable1.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(jTable1, column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize()
                    .getWidth();

            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) jTable1.getCellRenderer(row, col).getTableCellRendererComponent(jTable1,
                        jTable1.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            width += 50;
            column.setWidth(width + jTable1.getIntercellSpacing().width);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpMenu = new javax.swing.JPopupMenu();
        menuEdit = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJadwal = new javax.swing.JTable();
        txtKeyword = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        popUpMenu.setPreferredSize(new java.awt.Dimension(70, 70));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("eng"); // NOI18N
        menuEdit.setText(bundle.getString("EDIT")); // NOI18N
        menuEdit.setToolTipText(bundle.getString("HAPUS DATA DIPILIH")); // NOI18N
        menuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditActionPerformed(evt);
            }
        });
        popUpMenu.add(menuEdit);

        menuDelete.setText(bundle.getString("DELETE")); // NOI18N
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        popUpMenu.add(menuDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblJadwal.setAutoCreateRowSorter(true);
        tblJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblJadwal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJadwal);

        txtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeywordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeywordKeyReleased(evt);
            }
        });

        btnCari.setText(bundle.getString("CARI")); // NOI18N
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtKeyword, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCari, txtKeyword});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        loadDataToTable();
        txtKeyword.requestFocus();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtKeywordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeywordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loadDataToTable();
        }
    }//GEN-LAST:event_txtKeywordKeyPressed

    private void txtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeywordKeyReleased
        // TODO add your handling code here:
        loadDataToTable();
    }//GEN-LAST:event_txtKeywordKeyReleased

    private void menuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditActionPerformed
        if (tblJadwal.getSelectedRow() >=0 && jadwal != null) {
            jadwal = new FrameDialogJadwal().showEditDialog(jadwal);
            if (jadwal != null) {
//               Main.getJadwalDao().simpanJadwal(jadwal);
               loadDataToTable();
            }else{
                JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("eng").getString("DATA YANG DIMASUKKAN BELUM LENGKAP !!"),
                        java.util.ResourceBundle.getBundle("eng").getString("PERHATIAN"),JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuEditActionPerformed

    private void tblJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJadwalMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            popUpMenu.show((Component) evt.getSource(),
                    evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblJadwalMouseClicked

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed
        if (tblJadwal.getSelectedRow() >= 0 && jadwal != null) {
            JadwalDao jd = new JadwalDao();

            jd.deleteJadwal(jadwal.getId());
            loadDataToTable();
            JOptionPane.showMessageDialog(ListJadwal.this, java.util.ResourceBundle.getBundle("eng").getString("DATA BERHASIL DIHAPUS !!"));
        }
    }//GEN-LAST:event_menuDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuEdit;
    private javax.swing.JPopupMenu popUpMenu;
    private javax.swing.JTable tblJadwal;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables

}
