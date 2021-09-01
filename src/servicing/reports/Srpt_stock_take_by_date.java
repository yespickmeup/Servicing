/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import servicing.inventory_reports.MyLedger;
import servicing.inventory_reports.Srpt_item_ledger;
import servicing.utils.DateUtils1;
import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_stock_take_by_date {

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

    public Srpt_stock_take_by_date(String category, String classification, String sub_classification, String brand, String model, String business_name, String date, String branch, String location) {
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
        String location_id;
        String branch;
        String branch_id;

        public field() {
        }

        public field(String item_code, String barcode, String description, double qty, double selling_price, double cost, String uom, String code, String location, String location_id, String branch, String branch_id) {
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.cost = cost;
            this.uom = uom;
            this.code = code;
            this.location = location;
            this.location_id = location_id;
            this.branch = branch;
            this.branch_id = branch_id;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation_id() {
            return location_id;
        }

        public void setLocation_id(String location_id) {
            this.location_id = location_id;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

    }

    public static List<Srpt_stock_take_by_date.field> ret_where(String where, String year, int month, boolean is_month_selected, String search_date) {
        List<Srpt_stock_take_by_date.field> datas = new ArrayList();
        Date d = new Date();
        try {
            d = DateType.sf.parse(search_date);
        } catch (ParseException ex) {
            Logger.getLogger(Srpt_stock_take_by_date.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    + ",product_qty"
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
                    + " from inventory_barcodes "
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
                String main_barcode = rs.getString(27);
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
                String item_code = main_barcode;

                double qty = product_qty;

                String uom = unit;
                String code = item_code;

                String branch_id = branch_code;
                location = branch + " - " + location;
                String date_from="";
                String date_to="";
                Srpt_item_ledger rpt = MyLedger.get(item_code, barcode, description, location_id, year, month, branch, location, is_month_selected,1,0,0,date_from,date_to);
//                System.out.println("Item: " + item_code + " : " + description);
                double balance = 0;
                double cost1 = 0;
                int has_balance=0;
                for (Srpt_item_ledger.field r : rpt.fields) {
                    String sf = DateType.sf.format(r.getDate_added());
                    int count = DateUtils1.count_days(r.getDate_added(), d);
                    
                    if (count >= 0) {
                        if (r.getTransaction_type().equalsIgnoreCase("Receipts")|| r.getTransaction_type().equalsIgnoreCase("Inventory Count")) {
                            cost1 = FitIn.toDouble(r.getCost());
                        }
                    }
                    if (count == 0) {
                        balance = FitIn.toDouble(r.getBalance());
                        has_balance=1;
                    }
                    if (count < 0) {
                        break;
                    }
                }
                if(has_balance==0){
                    balance=rpt.running_balance;
                }
//                System.out.println("balance: " + balance);
                Srpt_stock_take_by_date.field field = new field(item_code, barcode, description, balance, selling_price, cost, uom, code, location, location_id, branch, branch_id);
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
