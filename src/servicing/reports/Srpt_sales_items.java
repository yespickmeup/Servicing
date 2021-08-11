/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_sales_items {

    public final List<field> fields;
    
    public Srpt_sales_items() {
        this.fields = new ArrayList();
    }
    public static class field {
        String barcode;
        String description;
        double qty;
        double price;
        String category;
        double total;

        public field() {
        }

        public field(String barcode, String description, double qty, double price, String category, double total) {
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.price = price;
            this.category = category;
            this.total = total;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }
    }

    public static void main(String[] args) {

        List<Srpt_sales_items.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            String barcode = " b" + i;
            String description = " desc" + i;
            double qty = i;
            double price = 100 + i;
            String category = "cat " + i;
            double total = 200 * i;
            Srpt_sales_items.field s = new Srpt_sales_items.field(barcode, description, qty, price, category, total);
            fields.add(s);
        }


        Srpt_sales_items rpt = new Srpt_sales_items();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_sales_items.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_sales_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_items to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
