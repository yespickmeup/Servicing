/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import servicing.inventory.Inventory;
import servicing.utils.DateType;
import servicing.utils.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Srpt_stock_take {

    public final List<field> fields;
    public final String category;
    public final String classification;
    public final String sub_classification;
    public final String brand;
    public final String model;
    public final String business_name;
    public final String date;
    public final String branch;
    public final String location;

    public Srpt_stock_take(String category, String classification, String sub_classification, String brand, String model, String business_name, String date, String branch, String location) {
        this.fields = new ArrayList();
        this.category = category;
        this.classification = classification;
        this.sub_classification = sub_classification;
        this.brand = brand;
        this.model = model;
        this.business_name = business_name;
        this.date = date;
        this.branch = branch;
        this.location = location;
    }

    public static class field {

        String item_code;
        String barcode;
        String description;
        double qty;
        double selling_price;
        double cost;
        String uom;
        String code;
        String location;
        String serial_no;
        public field() {
        }

        public field(String item_code, String barcode, String description, double qty, double selling_price, double cost, String uom, String code, String location,String serial_no) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.cost = cost;
            this.uom = uom;
            this.code = code;
            this.location = location;
            this.serial_no=serial_no;
        }

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

       
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

    }

    public static void main(String[] args) {

        List<Srpt_stock_take.field> datas = set(new ArrayList());
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";

        String category = "";
        String classification = "";
        String sub_classification = "";
        String brand = "";
        String model = "";

        Srpt_stock_take rpt = new Srpt_stock_take(category, classification, sub_classification, brand, model, business_name, date, "", "");
        rpt.fields.addAll(datas);
        String jrxml = "rpt_stock_take.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void generate(List<Srpt_stock_take.field> datas1) {

        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String category = "";
        String classification = "";
        String sub_classification = "";
        String brand = "";
        String model = "";

        Srpt_stock_take rpt = new Srpt_stock_take(category, classification, sub_classification, brand, model, business_name, date, "", "");
        rpt.fields.addAll(datas1);
        String jrxml = "rpt_stock_take.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_stock_take.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stock_take to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_stock_take.field> set(List<Inventory.to_inventory> datas) {

        List<Srpt_stock_take.field> fields = new ArrayList();

//        for (S1_inventory.to_inventory f : datas) {
//            String item_code = f.barcodes;
//            String barcode = f.barcode;
//            String description = f.description;
//            double qty = f.product_qty;
//            double selling_price = f.selling_price;
//            double cost = f.cost;
//            String uom = f.unit;
//            Srpt_stock_take.field field = new field(item_code, item_code, description, qty, selling_price, cost, uom, f.barcodes);
//            fields.add(field);
//        }
        return fields;
    }

    public static List<Srpt_stock_take.field> ret_data(String where) {
        List<Srpt_stock_take.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",sum(product_qty)"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + " from inventory_barcodes"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                int main_barcode = rs.getInt(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);
                String loc = branch + " - " + location;
                Srpt_stock_take.field field = new field("" + main_barcode, barcode, description, product_qty, selling_price, cost, unit, "" + main_barcode, loc,serial_no);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
