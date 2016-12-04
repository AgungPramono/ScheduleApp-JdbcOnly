//
// ReportService.java
// ScheduleApp-JdbcOnly 
//
// Created by Agung Pramono on 03/12/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.jadwal.dao;

import com.agung.jadwal.domain.Jadwal;
import com.agung.jadwal.domain.Report;
import java.text.SimpleDateFormat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;

/**
 *
 */
public class ReportService {
    
    public List<Report> getData(){
        JadwalDao jd = new JadwalDao();
        List<Report> dataReport = new ArrayList<>();
        List<Jadwal> data = jd.cariSemuaJadwals();
        
        for (Jadwal j : data) {
            Report rp = new Report();
            rp.setId(j.getJam());
            rp.setHari(j.getHari());
            rp.setPelajaran(j.getPelajaran().getMateri());
            rp.setRuang(j.getRuang().getRuang());
            rp.setInstructor(j.getGuru().getNamaGuru());
            
            dataReport.add(rp);
        }
        return dataReport;
    }
    
    public JasperPrint getJadwalReport(){
        try {
            
            JRFileVirtualizer virtualizer = new JRFileVirtualizer(20, "/tmp");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            
            InputStream inputStream =
                    getClass().getResourceAsStream("/report/jadwal_pelajaran.jasper");
            List<Report> data = getData();
            
            Map<String,Object> parameter = new HashMap<>();
            parameter.put("tanggalCetak", sdf.format(new Date()));
            parameter.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
            
            JasperPrint jp =
                    JasperFillManager
                            .fillReport(inputStream, 
                                    parameter, new JRBeanCollectionDataSource(data));
            return jp;
        } catch (JRException ex) {
            Logger.getLogger(ReportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
