/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_my_services_barcodes {

    public final List<Srpt_my_services_barcodes.field> fields;

    public Srpt_my_services_barcodes() {
        this.fields = new ArrayList();
    }

    public static class field {

        String transaction_no;

        public field() {
        }

        public field(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

    }

    public static void main(String[] args) {

        List<Srpt_my_services_barcodes.field> fields = new ArrayList();
        for (int i = 0; i < 50; i++) {
            String transaction_no = "0000000" + i;

            Srpt_my_services_barcodes.field field = new Srpt_my_services_barcodes.field(transaction_no);
            fields.add(field);
        }
        Srpt_my_services_barcodes rpt = new Srpt_my_services_barcodes();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_my_services_barcodes.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_my_services_barcodes.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_my_services_barcodes to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    
}
