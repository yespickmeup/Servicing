/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.utils.DateType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
public class Srpt_stock_transfer {

    public final List<Srpt_stock_transfer.field> fields;

    public final String transaction_no;
    public final String from_branch;
    public final String from_location;
    public final String to_branch;
    public final String to_location;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String status;
    public final String remarks;
    public Srpt_stock_transfer(String transaction_no, String from_branch, String from_location, String to_branch, String to_location, String business_name, String address, String contact_no, String date,String status,String remarks) {
        this.fields = new ArrayList();
        this.transaction_no = transaction_no;
        this.from_branch = from_branch;
        this.from_location = from_location;
        this.to_branch = to_branch;
        this.to_location = to_location;
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.status=status;
        this.remarks=remarks;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        double qty;
        String unit;
        String serial_no;
        double price;
        double amount;

        public field() {
        }

        public field(String item_code, String barcode, String description, double qty, String unit, String serial_no, double price, double amount) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.unit = unit;
            this.serial_no = serial_no;
            this.price = price;
            this.amount = amount;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
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

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static void main(String[] args) {
        
        List<Srpt_stock_transfer.field> datas = new ArrayList();
        for (int i = 0; i < 15; i++) {
            String item_code = "990";
            String barcode = "990";
            String description = "CDR-TITANIUM,GENERIC,GENERIC,,,COMPUTERS,ACCESSORIES";
            double qty = 100;
            String unit = "PC";
            String serial_no = "";
            double price = 0;
            double amount = 0;
            Srpt_stock_transfer.field rpt = new field(item_code, barcode, description, qty, unit, serial_no, price, amount);
            datas.add(rpt);
        }
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Dumaguete");
        String contact_no = System.getProperty("contact_no", "2342342");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String transaction_no = "3598";
        String from_branch = "DGT-Algorithm Computer Services";
        String from_location = "SEL-ALGO Selling Area";
        String to_branch = "DGT-Algorithm Computer Services";
        String to_location = "ZKA-ALGO Selling Area";
        String remarks="";
        Srpt_stock_transfer rpt = new Srpt_stock_transfer(transaction_no, from_branch, from_location, to_branch, to_location, business_name, address, contact_no, date,"",remarks);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_stock_transfer.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_stock_transfer.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stock_transfer to, String jrxml) {
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
