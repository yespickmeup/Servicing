/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.inventory.Dlg_inventory_uom;
import servicing.inventory.uom;
import servicing.utils.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.util.DateType;

/**
 *
 * @author Maytopacka
 */
public class Srpt_transferred_items {

    public final List<field> fields;
    public final String business_name;
    public final String address;
    public final String date;
    public final String from_branch;
    public final String from_location;
    public final String to_branch;
    public final String to_location;
    public final String status;
    public final String am;
    public Srpt_transferred_items(String business_name, String address, String date, String from_branch, String from_location, String to_branch, String to_location,String status,String am) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.date = date;
        this.from_branch = from_branch;
        this.from_location = from_location;
        this.to_branch = to_branch;
        this.to_location = to_location;
        this.status=status;
        this.am=am;
    }

    public static class field {

        String transaction_no;
        String date;
        String item_code;
        String barcode;
        String description;
        String unit;
        double qty;
        double selling_price;
        double cost;
        String f_branch;
        String f_branch_id;
        String f_location;
        String f_location_id;
        String t_branch;
        String t_branch_id;
        String t_location;
        String t_location_id;
        double amount;
        String group_id;

        public field() {
        }

        public field(String transaction_no, String date, String item_code, String barcode, String description, String unit, double qty, double selling_price, double cost, String f_branch, String f_branch_id, String f_location, String f_location_id, String t_branch, String t_branch_id, String t_location, String t_location_id, double amount, String group_id) {
            this.transaction_no = transaction_no;
            this.date = date;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.unit = unit;
            this.qty = qty;
            this.selling_price = selling_price;
            this.cost = cost;
            this.f_branch = f_branch;
            this.f_branch_id = f_branch_id;
            this.f_location = f_location;
            this.f_location_id = f_location_id;
            this.t_branch = t_branch;
            this.t_branch_id = t_branch_id;
            this.t_location = t_location;
            this.t_location_id = t_location_id;
            this.amount = amount;
            this.group_id = group_id;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
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

        public String getF_branch() {
            return f_branch;
        }

        public void setF_branch(String f_branch) {
            this.f_branch = f_branch;
        }

        public String getF_branch_id() {
            return f_branch_id;
        }

        public void setF_branch_id(String f_branch_id) {
            this.f_branch_id = f_branch_id;
        }

        public String getF_location() {
            return f_location;
        }

        public void setF_location(String f_location) {
            this.f_location = f_location;
        }

        public String getF_location_id() {
            return f_location_id;
        }

        public void setF_location_id(String f_location_id) {
            this.f_location_id = f_location_id;
        }

        public String getT_branch() {
            return t_branch;
        }

        public void setT_branch(String t_branch) {
            this.t_branch = t_branch;
        }

        public String getT_branch_id() {
            return t_branch_id;
        }

        public void setT_branch_id(String t_branch_id) {
            this.t_branch_id = t_branch_id;
        }

        public String getT_location() {
            return t_location;
        }

        public void setT_location(String t_location) {
            this.t_location = t_location;
        }

        public String getT_location_id() {
            return t_location_id;
        }

        public void setT_location_id(String t_location_id) {
            this.t_location_id = t_location_id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

        List<Srpt_transferred_items.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String transaction_no = "0000001";
            String date = "04/17/2017";
            String item_code = "1000";
            String barcode = "asdasd23sad";
            String description = "Item Description";
            String unit = "pc";
            double qty = 5;
            double selling_price = 15;
            double cost = 10;
            String f_branch = "Dumaguete City";
            String f_branch_id = "1";
            String f_location = "Selling Area";
            String f_location_id = "1";
            String t_branch = "Dumaguete City";
            String t_branch_id = "1";
            String t_location = "RMA";
            String t_location_id = "2";
            double amount = 75;
            String group_id = f_location_id + "&" + t_location_id;
            Srpt_transferred_items.field field = new field(transaction_no, date, item_code, barcode, description, unit, qty, selling_price, cost, f_branch, f_branch_id, f_location, f_location_id, t_branch, t_branch_id, t_location, t_location_id, amount, group_id);
            fields.add(field);
        }
        String business_name = System.getProperty("business_name", "Algorithm Computer Services");
        String address = System.getProperty("address", "Daro, Dumaguete City Negros Oriental");
        String date = "04/16/2017";
        String from_branch = "Dumaguete City";
        String from_location = "Selling Area";
        String to_branch = "Dumaguete City";
        String to_location = "RMA";
        String am="Sel";
        Srpt_transferred_items rpt = new Srpt_transferred_items(business_name, address, date, from_branch, from_location, to_branch, to_location,"",am);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_transferred_items.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_transferred_items.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_transferred_items to, String jrxml) {
        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_transferred_items.field> ret_data(String where, int is_price) {
        List<Srpt_transferred_items.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "st.id"
                    + ",st.barcode"
                    + ",st.description"
                    + ",st.generic_name"
                    + ",st.category"
                    + ",st.category_id"
                    + ",st.classification"
                    + ",st.classification_id"
                    + ",st.sub_classification"
                    + ",st.sub_classification_id"
                    + ",sum(st.product_qty)"
                    + ",st.unit"
                    + ",st.conversion"
                    + ",st.selling_price"
                    + ",st.date_added"
                    + ",st.user_name"
                    + ",st.item_type"
                    + ",st.status"
                    + ",st.supplier"
                    + ",st.fixed_price"
                    + ",st.cost"
                    + ",st.supplier_id"
                    + ",st.multi_level_pricing"
                    + ",st.vatable"
                    + ",st.reorder_level"
                    + ",st.markup"
                    + ",st.barcodes"
                    + ",st.brand"
                    + ",st.brand_id"
                    + ",st.model"
                    + ",st.model_id"
                    + ",st.selling_type"
                    + ",st.branch"
                    + ",st.branch_code"
                    + ",st.location"
                    + ",st.location_id"
                    + ",st.stock_transfer_id"
                    + ",st.serial_no"
                    + ",st.to_branch"
                    + ",st.to_branch_id"
                    + ",st.to_location"
                    + ",st.to_location_id"
                    + ",st.at_branch"
                    + ",st.at_branch_id"
                    + ",st.at_location"
                    + ",st.at_location_id"
                    + " from stock_transfers_items as st"
                    + " " + where;
            System.out.println(s0);
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
                String barcodes = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String stock_transfer_id = rs.getString(37);
                String serial_no = rs.getString(38);
                String to_branch = rs.getString(39);
                String to_branch_id = rs.getString(40);
                String to_location = rs.getString(41);
                String to_location_id = rs.getString(42);
                String at_branch = rs.getString(43);
                String at_branch_id = rs.getString(44);
                String at_location = rs.getString(45);
                String at_location_id = rs.getString(46);

                String transaction_no = stock_transfer_id;
                String date = DateType.convert_slash_datetime(date_added);
                String item_code = barcode;

                Dlg_inventory_uom.to_uom uoms = uom.default_uom(unit);
                if (uoms != null) {
                    unit = uoms.uom;
                }

                double qty = product_qty;
                String f_branch = branch;
                String f_branch_id = branch_code;
                String f_location = location;
                String f_location_id = location_id;
                String t_branch = to_branch;
                String t_branch_id = to_branch_id;
                String t_location = to_location;
                String t_location_id = to_location_id;
                double amount = qty * cost;
                String group_id = f_location_id + "&" + t_location_id;
                double am=cost;
                if(is_price==1){
                    am=selling_price;
                    amount=qty*selling_price;
                }
                
                Srpt_transferred_items.field field = new Srpt_transferred_items.field(transaction_no, date, item_code, barcode, description, unit, qty, selling_price, am, f_branch, f_branch_id, f_location, f_location_id, t_branch, t_branch_id, t_location, t_location_id, amount, group_id);
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
