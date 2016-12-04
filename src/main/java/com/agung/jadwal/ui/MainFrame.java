//
// MainFrame.java
// Jadwal-Pelajaran 
//
// Created by Agung Pramono on 30/09/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.jadwal.ui;

import com.agung.jadwal.tblmodel.InstructorTableModel;
import com.agung.jadwal.Main;
import com.agung.jadwal.dao.InstructorDao;
import com.agung.jadwal.dao.JadwalDao;
import com.agung.jadwal.dao.PelajaranDao;
import com.agung.jadwal.dao.ReportService;
import com.agung.jadwal.dao.RuangDao;
import com.agung.jadwal.domain.Jadwal;
import com.agung.jadwal.domain.Materi;
import com.agung.jadwal.domain.Ruang;
import com.agung.jadwal.domain.Trainer;
import com.agung.jadwal.tblmodel.JadwalTableModel;
import com.agung.jadwal.tblmodel.MateriTableModel;
import com.agung.jadwal.tblmodel.RuangTableModel;
import com.agung.jadwal.util.TableUtil;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 */
public class MainFrame extends javax.swing.JFrame {

    private Materi materi;
    private Trainer trainer;
    private Ruang ruang;
    private Jadwal jadwal;

    private List<Materi> materis;
    private List<Trainer> trainers;
    private List<Ruang> ruangs;
    private List<Jadwal> jadwals;

    private final PelajaranDao pelajaranDao = new PelajaranDao();
    private final RuangDao ruangDao = new RuangDao();
    private final InstructorDao instructorDao = new InstructorDao();
    private final JadwalDao jadwalDao = new JadwalDao();

    public MainFrame() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        tblMateri.getSelectionModel()
                .addListSelectionListener(new TableMateriSelection());
        tblInstructor.getSelectionModel()
                .addListSelectionListener(new TableInstructorSelection());
        tblJadwal.getSelectionModel()
                .addListSelectionListener(new TableJadwalSelection());
        tblRuang.getSelectionModel()
                .addListSelectionListener(new TableRuangSelection());
        btnSimpanMateri.setEnabled(false);
        fetchFormJadwal();
    }

    /**
     * load and show panel based name of panel
     *
     * @param panelName name of panel
     */
    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) jPanel3.getLayout();
        cl.show(jPanel3, panelName);
    }
    // end

    /**
     * method for load data to table
     */
    private void fetchFormMateri() {
        materis = pelajaranDao.findAll();
        if (!materis.isEmpty() && materis != null) {
            tblMateri.setModel(new MateriTableModel(materis));
            TableUtil.initColumn(tblMateri);
        }
    }

    private void fetchFormRuang() {
        ruangs = ruangDao.cariSemuaRuang();
        if (!ruangs.isEmpty() && ruangs != null) {
            tblRuang.setModel(new RuangTableModel(ruangs));
        }
        TableUtil.initColumn(tblRuang);
    }

    private void fetchFormInstructor() {
        trainers = instructorDao.cariSemua();
        if (trainers != null && !trainers.isEmpty()) {
            tblInstructor.setModel(new InstructorTableModel(trainers));
        } else {
            showDialog("Data masih kosong");
        }
        TableUtil.initColumn(tblInstructor);
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(MainFrame.this, message, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

    private void fetchFormJadwal() {
        jadwals = jadwalDao.cariSemuaJadwals();
        if (jadwals != null && !jadwals.isEmpty()) {
            tblJadwal.setModel(new JadwalTableModel(jadwals));
        }
        TableUtil.initColumn(tblJadwal);
    }
    // end

    /**
     * Method for validate form
     */
    private Boolean validateFormMateri() {
        if (txtMateri.getText().trim().length() > 0
                && txKodeMateri.getText().trim().length() > 0) {
            return true;
        }
        return false;
    }

    private Boolean validateFormRuang() {
        if (txtKodeRuang.getText().trim().length() >0 
                && txtNamaRuang.getText().trim().length() >0) {
            return true;
        }
        return false;
    }

    private Boolean validateFormInstructor() {
        if (txtKodeInstructor.getText().trim().length() > 0
                && txtNamaInstructor.getText().trim().length() > 0) {
            return true;
        }
        return false;
    }
    //end

    /**
     * method clear form
     */
    private void clearFormMateri() {
        txtMateri.setText("");
        txKodeMateri.setText("");
    }
    // end
    
    private void loadFormMateriToDomain() {
        if (materi == null) {
            materi = new Materi();
        }
        materi.setKode(txKodeMateri.getText());
        materi.setMateri(txtMateri.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEdit = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        imagePanel1 = new com.agung.jadwal.ui.component.ImagePanel();
        btnInstructor = new javax.swing.JToggleButton();
        btnRuang = new javax.swing.JToggleButton();
        btnMateri = new javax.swing.JToggleButton();
        btnJadwal = new javax.swing.JToggleButton();
        btnKeluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlMateri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txKodeMateri = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMateri = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnAddMateri = new javax.swing.JButton();
        btnSimpanMateri = new javax.swing.JButton();
        btnRefreshMateri = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateri = new javax.swing.JTable();
        pnlRuang = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRuang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKodeRuang = new javax.swing.JTextField();
        txtNamaRuang = new javax.swing.JTextField();
        btnSmpnRuang = new javax.swing.JButton();
        btnRfrshRuang = new javax.swing.JButton();
        pnlInstructor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtKodeInstructor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNamaInstructor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInstructor = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnSimpanInstructor = new javax.swing.JButton();
        btnRefreshInstructor = new javax.swing.JButton();
        pnlJadwal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblJadwal = new javax.swing.JTable();
        btnTambahJadwal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        imagePanelTop1 = new com.agung.jadwal.ui.component.ImagePanelTop();
        jLabel7 = new javax.swing.JLabel();

        jPopupMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        menuEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/table_edit.png"))); // NOI18N
        menuEdit.setText("Edit");
        menuEdit.setToolTipText("");
        menuEdit.setPreferredSize(new java.awt.Dimension(120, 22));
        menuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEdit);

        menuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        menuDelete.setText("Hapus");
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi training Management");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(btnInstructor);
        btnInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/businessman.png"))); // NOI18N
        btnInstructor.setText("Instructor");
        btnInstructor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInstructor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstructorActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnRuang);
        btnRuang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/home_1.png"))); // NOI18N
        btnRuang.setText("Ruang");
        btnRuang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRuang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRuangActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnMateri);
        btnMateri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/book_open.png"))); // NOI18N
        btnMateri.setSelected(true);
        btnMateri.setText("Materi");
        btnMateri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMateri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMateri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnJadwal);
        btnJadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/calendar_clock.png"))); // NOI18N
        btnJadwal.setText("Jadwal");
        btnJadwal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJadwal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalActionPerformed(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/close.png"))); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanel1Layout = new javax.swing.GroupLayout(imagePanel1);
        imagePanel1.setLayout(imagePanel1Layout);
        imagePanel1Layout.setHorizontalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMateri, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstructor)
                    .addComponent(btnRuang)
                    .addComponent(btnJadwal)
                    .addComponent(btnKeluar))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        imagePanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnInstructor, btnJadwal, btnKeluar, btnMateri, btnRuang});

        imagePanel1Layout.setVerticalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMateri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInstructor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRuang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJadwal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKeluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        imagePanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnInstructor, btnJadwal, btnKeluar, btnMateri, btnRuang});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        pnlMateri.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Materi", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Kode Materi    *");

        jLabel2.setText("Nama Materi    *");

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnAddMateri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        btnAddMateri.setText("Add");
        btnAddMateri.setToolTipText("Tambah Materi");
        btnAddMateri.setFocusable(false);
        btnAddMateri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAddMateri.setMaximumSize(new java.awt.Dimension(70, 23));
        btnAddMateri.setPreferredSize(new java.awt.Dimension(70, 23));
        btnAddMateri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddMateri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMateriActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddMateri);

        btnSimpanMateri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/save_as.png"))); // NOI18N
        btnSimpanMateri.setText("Simpan");
        btnSimpanMateri.setFocusable(false);
        btnSimpanMateri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSimpanMateri.setMaximumSize(new java.awt.Dimension(70, 21));
        btnSimpanMateri.setPreferredSize(new java.awt.Dimension(70, 21));
        btnSimpanMateri.setVerifyInputWhenFocusTarget(false);
        btnSimpanMateri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanMateriActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSimpanMateri);

        btnRefreshMateri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/nav_refresh.png"))); // NOI18N
        btnRefreshMateri.setText("Refresh");
        btnRefreshMateri.setFocusable(false);
        btnRefreshMateri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRefreshMateri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefreshMateri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMateriActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRefreshMateri);

        tblMateri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Materi", "Nama Materi"
            }
        ));
        tblMateri.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMateri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMateriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMateri);

        javax.swing.GroupLayout pnlMateriLayout = new javax.swing.GroupLayout(pnlMateri);
        pnlMateri.setLayout(pnlMateriLayout);
        pnlMateriLayout.setHorizontalGroup(
            pnlMateriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMateriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMateriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(pnlMateriLayout.createSequentialGroup()
                        .addGroup(pnlMateriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMateriLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMateri, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMateriLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txKodeMateri, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlMateriLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        pnlMateriLayout.setVerticalGroup(
            pnlMateriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMateriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMateriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txKodeMateri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMateriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMateri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMateriLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, txKodeMateri, txtMateri});

        jPanel3.add(pnlMateri, "MATERI");

        pnlRuang.setBorder(javax.swing.BorderFactory.createTitledBorder("Ruang"));

        tblRuang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Ruang", "Nama Ruang"
            }
        ));
        tblRuang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tblRuang);

        jLabel8.setText("Kode Ruang");

        jLabel9.setText("Nama Ruang");

        btnSmpnRuang.setText("Simpan");
        btnSmpnRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmpnRuangActionPerformed(evt);
            }
        });

        btnRfrshRuang.setText("Refresh");
        btnRfrshRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRfrshRuangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRuangLayout = new javax.swing.GroupLayout(pnlRuang);
        pnlRuang.setLayout(pnlRuangLayout);
        pnlRuangLayout.setHorizontalGroup(
            pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRuangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRuangLayout.createSequentialGroup()
                        .addGroup(pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRuangLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKodeRuang, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRuangLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamaRuang, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(238, 238, 238))
                    .addGroup(pnlRuangLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(pnlRuangLayout.createSequentialGroup()
                        .addComponent(btnSmpnRuang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRfrshRuang)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pnlRuangLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, jLabel9});

        pnlRuangLayout.setVerticalGroup(
            pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRuangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodeRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNamaRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRuangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSmpnRuang)
                    .addComponent(btnRfrshRuang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
        );

        pnlRuangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, jLabel9});

        pnlRuangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtKodeRuang, txtNamaRuang});

        jPanel3.add(pnlRuang, "RUANG");

        pnlInstructor.setBorder(javax.swing.BorderFactory.createTitledBorder("Instructor"));

        jLabel3.setText("Kode Instructor  *");

        jLabel4.setText("Nama *");

        tblInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Instructor", "Nama Instructor", "Alamat", "Phone"
            }
        ));
        tblInstructor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tblInstructor);

        jLabel5.setText("Alamat   *");

        jLabel6.setText("Phone    *");

        jToolBar2.setFloatable(false);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdd);

        btnSimpanInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/save_as.png"))); // NOI18N
        btnSimpanInstructor.setText("Simpan");
        btnSimpanInstructor.setFocusable(false);
        btnSimpanInstructor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSimpanInstructor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSimpanInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanInstructorActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSimpanInstructor);

        btnRefreshInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/nav_refresh.png"))); // NOI18N
        btnRefreshInstructor.setText("Refresh");
        btnRefreshInstructor.setFocusable(false);
        btnRefreshInstructor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRefreshInstructor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefreshInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshInstructorActionPerformed(evt);
            }
        });
        jToolBar2.add(btnRefreshInstructor);

        javax.swing.GroupLayout pnlInstructorLayout = new javax.swing.GroupLayout(pnlInstructor);
        pnlInstructor.setLayout(pnlInstructorLayout);
        pnlInstructorLayout.setHorizontalGroup(
            pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInstructorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(pnlInstructorLayout.createSequentialGroup()
                        .addGroup(pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKodeInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtNamaInstructor))
                        .addGap(55, 55, 55)
                        .addGroup(pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInstructorLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInstructorLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlInstructorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4});

        pnlInstructorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtKodeInstructor, txtNamaInstructor, txtPhone});

        pnlInstructorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6});

        pnlInstructorLayout.setVerticalGroup(
            pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInstructorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodeInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlInstructorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, txtAlamat, txtKodeInstructor, txtNamaInstructor, txtPhone});

        jPanel3.add(pnlInstructor, "INSTRUCTOR");

        pnlJadwal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jadwal", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JAM", "HARI", "MATERI", "RUANG", "INSTRUKTUR"
            }
        ));
        tblJadwal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tblJadwal);

        btnTambahJadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add_2.png"))); // NOI18N
        btnTambahJadwal.setText("Add");
        btnTambahJadwal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTambahJadwal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTambahJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahJadwalActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/printer_1.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJadwalLayout = new javax.swing.GroupLayout(pnlJadwal);
        pnlJadwal.setLayout(pnlJadwalLayout);
        pnlJadwalLayout.setHorizontalGroup(
            pnlJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJadwalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(pnlJadwalLayout.createSequentialGroup()
                        .addComponent(btnTambahJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlJadwalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnTambahJadwal, jButton1});

        pnlJadwalLayout.setVerticalGroup(
            pnlJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJadwalLayout.createSequentialGroup()
                .addGroup(pnlJadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(btnTambahJadwal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );

        pnlJadwalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTambahJadwal, jButton1});

        jPanel3.add(pnlJadwal, "JADWAL");

        jLabel7.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 0));
        jLabel7.setText("Aplikasi Jadwal Training");

        javax.swing.GroupLayout imagePanelTop1Layout = new javax.swing.GroupLayout(imagePanelTop1);
        imagePanelTop1.setLayout(imagePanelTop1Layout);
        imagePanelTop1Layout.setHorizontalGroup(
            imagePanelTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelTop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagePanelTop1Layout.setVerticalGroup(
            imagePanelTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelTop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagePanelTop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagePanelTop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMateriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriActionPerformed
        // TODO add your handling code here:
        showPanel("MATERI");
        fetchFormMateri();
    }//GEN-LAST:event_btnMateriActionPerformed

    private void btnRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRuangActionPerformed
        showPanel("RUANG");
        fetchFormRuang();
    }//GEN-LAST:event_btnRuangActionPerformed

    private void btnInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstructorActionPerformed
        showPanel("INSTRUCTOR");
        fetchFormInstructor();
    }//GEN-LAST:event_btnInstructorActionPerformed

    private void btnJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJadwalActionPerformed
        showPanel("JADWAL");
        fetchFormJadwal();
    }//GEN-LAST:event_btnJadwalActionPerformed

    private void tblMateriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jPopupMenu1.show((Component) evt.getSource(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblMateriMouseClicked

    private void loadFormInstructorToDomain() {
        if (trainer == null) {
            trainer = new Trainer();
        }
        trainer.setKodeGuru(txtKodeInstructor.getText());
        trainer.setNamaGuru(txtNamaInstructor.getText());
    }

    private void clearFormInstructor() {
        txtKodeInstructor.setText("");
        txtNamaInstructor.setText("");
    }

    private void loadFormJadwalToDomain() {
    }

    private void clearFormRuang() {
        txtKodeRuang.setText("");
        txtNamaRuang.setText("");
    }

    private void loadFormRuangToDomain() {
        if (ruang == null) {
            ruang  = new Ruang();
        }
        ruang.setKodeRuang(txtKodeRuang.getText());
        ruang.setRuang(txtNamaRuang.getText());
    }

    class TableMateriSelection implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }

            if (tblMateri.getSelectedRow() >= 0) {
                materi = materis.get(tblMateri.getSelectedRow());
            }
        }
    }

    //buat listener untuk tabel ruang
    class TableRuangSelection implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            if(tblRuang.getSelectedRow() > 0){
                ruang = ruangs.get(tblRuang.getSelectedRow());
            }
        }
    }

    //buat listener untuk tabel instructor
    class TableInstructorSelection implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            if (tblInstructor.getSelectedColumn()>0) {
                trainer = trainers.get(tblInstructor.getSelectedRow());
            }
        }
    }

    //buat listener untuk table jadwal
    class TableJadwalSelection implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            if (tblJadwal.getSelectedRow() > 0) {
                jadwal = jadwals.get(tblJadwal.getSelectedRow());
            }
        }
    }

    private void menuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditActionPerformed
        if (tblMateri.getSelectedRow() > 0 && materi != null) {
            txtMateri.setText(materi.getMateri());
            txKodeMateri.setText(materi.getKode());
            btnSimpanMateri.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "<html><font color=\"red\"><b>Tidak ada data yang dipilih !</b></font></html>",
                    "Kesalahan !",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEditActionPerformed

    private void btnAddMateriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMateriActionPerformed
        clearFormMateri();
        txKodeMateri.requestFocus();
        btnSimpanMateri.setEnabled(true);
    }//GEN-LAST:event_btnAddMateriActionPerformed

    private void btnRefreshMateriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMateriActionPerformed
        fetchFormMateri();
        clearFormMateri();
        materi = null;
    }//GEN-LAST:event_btnRefreshMateriActionPerformed

    private void btnSimpanMateriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanMateriActionPerformed
        if (validateFormMateri()) {
            loadFormMateriToDomain();
            pelajaranDao.saveMateri(materi);
            fetchFormMateri();
            clearFormMateri();
            materi = null;
        } else {
            JOptionPane.showMessageDialog(this,
                    "<html>Kolom isian bertanda <font color=\"red\">*</font> harus diisi !</html>",
                    "Kesalahan !",
                    JOptionPane.ERROR_MESSAGE);
        }
        btnSimpanMateri.setEnabled(false);
    }//GEN-LAST:event_btnSimpanMateriActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed
        if (tblMateri.getSelectedRow() > 0 && materi.getId() != null) {
            pelajaranDao.deleteMateri(materi.getId());
            fetchFormMateri();
        } else {
            JOptionPane.showMessageDialog(this,
                    "<html><font color=\"red\"><b>Tidak ada data yang dipilih !</b></font></html>",
                    "Kesalahan !",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        fetchFormInstructor();
        clearFormInstructor();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSimpanInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanInstructorActionPerformed
        if (validateFormInstructor()) {
            loadFormInstructorToDomain();
            instructorDao.saveTrainer(trainer);
            fetchFormInstructor();
            clearFormInstructor();
        } else {
            showDialog("<html><font color=\"red\"><b>Semua field bertanda * harus diisi</b></font></html>");
        }
    }//GEN-LAST:event_btnSimpanInstructorActionPerformed

    private void btnRefreshInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshInstructorActionPerformed
        fetchFormInstructor();
        clearFormInstructor();
    }//GEN-LAST:event_btnRefreshInstructorActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnTambahJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahJadwalActionPerformed
        // TODO add your handling code here:
        jadwal = new FrameDialogJadwal().showDialog();
        if (jadwal != null) {
            jadwalDao.simpanJadwal(jadwal);
            fetchFormJadwal();
            jadwal = null;
        }
    }//GEN-LAST:event_btnTambahJadwalActionPerformed

    private void btnSmpnRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSmpnRuangActionPerformed
        if (validateFormRuang()) {
            loadFormRuangToDomain();
            if (ruang != null) {
                ruangDao.saveRuang(ruang);
                clearFormRuang();
                fetchFormRuang();
                ruang = null;
            }
        }else{
            showDialog("Data yang diinputkan tidak lengkap !!");
        }
    }//GEN-LAST:event_btnSmpnRuangActionPerformed

    private void btnRfrshRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRfrshRuangActionPerformed
        clearFormRuang();
        fetchFormRuang();
    }//GEN-LAST:event_btnRfrshRuangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialog dialog = new JDialog(MainFrame.this,true);
        dialog.setTitle("Cetak Jadwal");
        
        ReportService rs = new ReportService();
        JasperPrint jp = 
                rs.getJadwalReport();
        JRViewer viewer = new JRViewer(jp);
        dialog.add(viewer);
        dialog.add(viewer, BorderLayout.CENTER);

        dialog.pack();
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddMateri;
    private javax.swing.JToggleButton btnInstructor;
    private javax.swing.JToggleButton btnJadwal;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JToggleButton btnMateri;
    private javax.swing.JButton btnRefreshInstructor;
    private javax.swing.JButton btnRefreshMateri;
    private javax.swing.JButton btnRfrshRuang;
    private javax.swing.JToggleButton btnRuang;
    private javax.swing.JButton btnSimpanInstructor;
    private javax.swing.JButton btnSimpanMateri;
    private javax.swing.JButton btnSmpnRuang;
    private javax.swing.JButton btnTambahJadwal;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.agung.jadwal.ui.component.ImagePanel imagePanel1;
    private com.agung.jadwal.ui.component.ImagePanelTop imagePanelTop1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuEdit;
    private javax.swing.JPanel pnlInstructor;
    private javax.swing.JPanel pnlJadwal;
    private javax.swing.JPanel pnlMateri;
    private javax.swing.JPanel pnlRuang;
    private javax.swing.JTable tblInstructor;
    private javax.swing.JTable tblJadwal;
    private javax.swing.JTable tblMateri;
    private javax.swing.JTable tblRuang;
    private javax.swing.JTextField txKodeMateri;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtKodeInstructor;
    private javax.swing.JTextField txtKodeRuang;
    private javax.swing.JTextField txtMateri;
    private javax.swing.JTextField txtNamaInstructor;
    private javax.swing.JTextField txtNamaRuang;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

}
