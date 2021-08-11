/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import servicing.inventory_replenishment.Inventory_replenishment_items;
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
 * @author Ronald
 */
public class Srpt_inventory_over_short {

    public final List<Srpt_inventory_over_short.field> fields;
    public final String business_name;
    public final String date;
    public final String printed_by;
    public final String branch;
    public final String location;
    public final String counted_by;

    public Srpt_inventory_over_short(String business_name, String date, String printed_by, String branch, String location, String counted_by) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.printed_by = printed_by;
        this.branch = branch;
        this.location = location;
        this.counted_by = counted_by;
    }

    public static class field {

        String date_added;
        double qty;
        String item_code;
        String barcode;
        String description;
        String sheet_no;
        String counted_by;
        double system_qty;
        double over_short;
        double selling_price;

        public field() {
        }

        public field(String date_added, double qty, String item_code, String barcode, String description, String sheet_no, String counted_by, double system_qty, double over_short, double selling_price) {
            this.date_added = date_added;
            this.qty = qty;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.sheet_no = sheet_no;
            this.counted_by = counted_by;
            this.system_qty = system_qty;
            this.over_short = over_short;
            this.selling_price = selling_price;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getSystem_qty() {
            return system_qty;
        }

        public void setSystem_qty(double system_qty) {
            this.system_qty = system_qty;
        }

        public double getOver_short() {
            return over_short;
        }

        public void setOver_short(double over_short) {
            this.over_short = over_short;
        }

        public String getCounted_by() {
            return counted_by;
        }

        public void setCounted_by(String counted_by) {
            this.counted_by = counted_by;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
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

        public String getSheet_no() {
            return sheet_no;
        }

        public void setSheet_no(String sheet_no) {
            this.sheet_no = sheet_no;
        }

    }

    public static void main(String[] args) {
        String where = " ";
        List<Srpt_inventory_over_short.field> datas = new ArrayList();// ret_data(where);
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String date = DateType.month_date.format(new Date());
        String printed_by = "Administrator";
        String sheet_no = "";
        String branch = "";
        String location = "";
        String counted_by = "";
        Srpt_inventory_over_short rpt = new Srpt_inventory_over_short(business_name, date, printed_by, branch, location, counted_by);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_inventory_over_or_short.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_inventory_over_short.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_inventory_over_short to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_inventory_over_short.field> ret_data(String where, List<Inventory_replenishment_items.to_inventory_replenishment_items> replenishments) {
        List<Srpt_inventory_over_short.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            for (Inventory_replenishment_items.to_inventory_replenishment_items rep : replenishments) {

                String s0 = "select "
                        + " sum(qty)"
                        + ",selling_price"
                        + " from encoding_inventory "
                        + " " + where + " and item_code='" + rep.item_code + "'"
                        + " ";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                double qty = 0;
                double price = 0;
                if (rs.next()) {
                    qty = rs.getDouble(1);
                    price = rs.getDouble(2);
                }
                double system_qty = rep.product_qty;
                double over_short = qty - system_qty;
                Srpt_inventory_over_short.field field = new field(rep.date_added, qty, rep.item_code, rep.barcode, rep.description, "", "", system_qty, over_short, price);
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
