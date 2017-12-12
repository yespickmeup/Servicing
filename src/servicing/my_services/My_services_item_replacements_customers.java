/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.inventory.Inventory_barcodes;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronald
 */
public class My_services_item_replacements_customers {

    public static class to_my_services_item_replacements_customers {

        public final int id;
        public final String transaction_no;
        public final String customer_id;
        public final String customer_name;
        public String item_code;
        public String barcode;
        public String description;
        public double qty;
        public double selling_price;
        public final String date_added;
        public final String user_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final String unit;
        public final double conversion;
        public final String item_type;
        public final int status;
        public final String supplier;
        public final int fixed_price;
        public final String supplier_id;
        public final int multi_level_pricing;
        public final int vatable;
        public final double reorder_level;
        public final double markup;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final String selling_type;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public final String serial_no;
        public final String user_id;
        public final String user_screen_name;

        public to_my_services_item_replacements_customers(int id, String transaction_no, String customer_id, String customer_name, String item_code, String barcode, String description, double qty, double selling_price, String date_added, String user_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, String unit, double conversion, String item_type, int status, String supplier, int fixed_price, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String brand, String brand_id, String model, String model_id, String selling_type, String branch, String branch_code, String location, String location_id, String serial_no, String user_id, String user_screen_name) {
            this.id = id;
            this.transaction_no = transaction_no;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.unit = unit;
            this.conversion = conversion;
            this.item_type = item_type;
            this.status = status;
            this.supplier = supplier;
            this.fixed_price = fixed_price;
            this.supplier_id = supplier_id;
            this.multi_level_pricing = multi_level_pricing;
            this.vatable = vatable;
            this.reorder_level = reorder_level;
            this.markup = markup;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selling_type = selling_type;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.serial_no = serial_no;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
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
        
    }

    public static void add_data(List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> to_my_services_item_replacements_customers1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_my_services_item_replacements_customers to_my_services_item_replacements_customers : to_my_services_item_replacements_customers1) {
                String s0 = "insert into my_services_item_replacements_customers("
                        + "transaction_no"
                        + ",customer_id"
                        + ",customer_name"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",unit"
                        + ",conversion"
                        + ",item_type"
                        + ",status"
                        + ",supplier"
                        + ",fixed_price"
                        + ",supplier_id"
                        + ",multi_level_pricing"
                        + ",vatable"
                        + ",reorder_level"
                        + ",markup"
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
                        + ",user_id"
                        + ",user_screen_name"
                        + ")values("
                        + ":transaction_no"
                        + ",:customer_id"
                        + ",:customer_name"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:unit"
                        + ",:conversion"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:markup"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:serial_no"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("transaction_no", to_my_services_item_replacements_customers.transaction_no)
                        .setString("customer_id", to_my_services_item_replacements_customers.customer_id)
                        .setString("customer_name", to_my_services_item_replacements_customers.customer_name)
                        .setString("item_code", to_my_services_item_replacements_customers.item_code)
                        .setString("barcode", to_my_services_item_replacements_customers.barcode)
                        .setString("description", to_my_services_item_replacements_customers.description)
                        .setNumber("qty", to_my_services_item_replacements_customers.qty)
                        .setNumber("selling_price", to_my_services_item_replacements_customers.selling_price)
                        .setString("date_added", to_my_services_item_replacements_customers.date_added)
                        .setString("user_name", to_my_services_item_replacements_customers.user_name)
                        .setString("category", to_my_services_item_replacements_customers.category)
                        .setString("category_id", to_my_services_item_replacements_customers.category_id)
                        .setString("classification", to_my_services_item_replacements_customers.classification)
                        .setString("classification_id", to_my_services_item_replacements_customers.classification_id)
                        .setString("sub_classification", to_my_services_item_replacements_customers.sub_classification)
                        .setString("sub_classification_id", to_my_services_item_replacements_customers.sub_classification_id)
                        .setString("unit", to_my_services_item_replacements_customers.unit)
                        .setNumber("conversion", to_my_services_item_replacements_customers.conversion)
                        .setString("item_type", to_my_services_item_replacements_customers.item_type)
                        .setNumber("status", to_my_services_item_replacements_customers.status)
                        .setString("supplier", to_my_services_item_replacements_customers.supplier)
                        .setNumber("fixed_price", to_my_services_item_replacements_customers.fixed_price)
                        .setString("supplier_id", to_my_services_item_replacements_customers.supplier_id)
                        .setNumber("multi_level_pricing", to_my_services_item_replacements_customers.multi_level_pricing)
                        .setNumber("vatable", to_my_services_item_replacements_customers.vatable)
                        .setNumber("reorder_level", to_my_services_item_replacements_customers.reorder_level)
                        .setNumber("markup", to_my_services_item_replacements_customers.markup)
                        .setString("brand", to_my_services_item_replacements_customers.brand)
                        .setString("brand_id", to_my_services_item_replacements_customers.brand_id)
                        .setString("model", to_my_services_item_replacements_customers.model)
                        .setString("model_id", to_my_services_item_replacements_customers.model_id)
                        .setString("selling_type", to_my_services_item_replacements_customers.selling_type)
                        .setString("branch", to_my_services_item_replacements_customers.branch)
                        .setString("branch_code", to_my_services_item_replacements_customers.branch_code)
                        .setString("location", to_my_services_item_replacements_customers.location)
                        .setString("location_id", to_my_services_item_replacements_customers.location_id)
                        .setString("serial_no", to_my_services_item_replacements_customers.serial_no)
                        .setString("user_id", to_my_services_item_replacements_customers.user_id)
                        .setString("user_screen_name", to_my_services_item_replacements_customers.user_screen_name)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(My_services_item_replacements_customers.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_my_services_item_replacements_customers to_my_services_item_replacements_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_item_replacements_customers set "
                    + "transaction_no= :transaction_no "
                    + ",customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",qty= :qty "
                    + ",selling_price= :selling_price "
                    + ",date_added= :date_added "
                    + ",user_name= :user_name "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",item_type= :item_type "
                    + ",status= :status "
                    + ",supplier= :supplier "
                    + ",fixed_price= :fixed_price "
                    + ",supplier_id= :supplier_id "
                    + ",multi_level_pricing= :multi_level_pricing "
                    + ",vatable= :vatable "
                    + ",reorder_level= :reorder_level "
                    + ",markup= :markup "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",selling_type= :selling_type "
                    + ",branch= :branch "
                    + ",branch_code= :branch_code "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",serial_no= :serial_no "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + " where id='" + to_my_services_item_replacements_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_my_services_item_replacements_customers.transaction_no)
                    .setString("customer_id", to_my_services_item_replacements_customers.customer_id)
                    .setString("customer_name", to_my_services_item_replacements_customers.customer_name)
                    .setString("item_code", to_my_services_item_replacements_customers.item_code)
                    .setString("barcode", to_my_services_item_replacements_customers.barcode)
                    .setString("description", to_my_services_item_replacements_customers.description)
                    .setNumber("qty", to_my_services_item_replacements_customers.qty)
                    .setNumber("selling_price", to_my_services_item_replacements_customers.selling_price)
                    .setString("date_added", to_my_services_item_replacements_customers.date_added)
                    .setString("user_name", to_my_services_item_replacements_customers.user_name)
                    .setString("category", to_my_services_item_replacements_customers.category)
                    .setString("category_id", to_my_services_item_replacements_customers.category_id)
                    .setString("classification", to_my_services_item_replacements_customers.classification)
                    .setString("classification_id", to_my_services_item_replacements_customers.classification_id)
                    .setString("sub_classification", to_my_services_item_replacements_customers.sub_classification)
                    .setString("sub_classification_id", to_my_services_item_replacements_customers.sub_classification_id)
                    .setString("unit", to_my_services_item_replacements_customers.unit)
                    .setNumber("conversion", to_my_services_item_replacements_customers.conversion)
                    .setString("item_type", to_my_services_item_replacements_customers.item_type)
                    .setNumber("status", to_my_services_item_replacements_customers.status)
                    .setString("supplier", to_my_services_item_replacements_customers.supplier)
                    .setNumber("fixed_price", to_my_services_item_replacements_customers.fixed_price)
                    .setString("supplier_id", to_my_services_item_replacements_customers.supplier_id)
                    .setNumber("multi_level_pricing", to_my_services_item_replacements_customers.multi_level_pricing)
                    .setNumber("vatable", to_my_services_item_replacements_customers.vatable)
                    .setNumber("reorder_level", to_my_services_item_replacements_customers.reorder_level)
                    .setNumber("markup", to_my_services_item_replacements_customers.markup)
                    .setString("brand", to_my_services_item_replacements_customers.brand)
                    .setString("brand_id", to_my_services_item_replacements_customers.brand_id)
                    .setString("model", to_my_services_item_replacements_customers.model)
                    .setString("model_id", to_my_services_item_replacements_customers.model_id)
                    .setString("selling_type", to_my_services_item_replacements_customers.selling_type)
                    .setString("branch", to_my_services_item_replacements_customers.branch)
                    .setString("branch_code", to_my_services_item_replacements_customers.branch_code)
                    .setString("location", to_my_services_item_replacements_customers.location)
                    .setString("location_id", to_my_services_item_replacements_customers.location_id)
                    .setString("serial_no", to_my_services_item_replacements_customers.serial_no)
                    .setString("user_id", to_my_services_item_replacements_customers.user_id)
                    .setString("user_screen_name", to_my_services_item_replacements_customers.user_screen_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_item_replacements_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_item_replacements_customers(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_item_replacements_customers where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_item_replacements_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_item_replacements_customers> ret_data(String where) {
        List<to_my_services_item_replacements_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",customer_id"
                    + ",customer_name"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",unit"
                    + ",conversion"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
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
                    + ",user_id"
                    + ",user_screen_name"
                    + " from my_services_item_replacements_customers"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String customer_id = rs.getString(3);
                String customer_name = rs.getString(4);
                String item_code = rs.getString(5);
                String barcode = rs.getString(6);
                String description = rs.getString(7);
                double qty = rs.getDouble(8);
                double selling_price = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String category = rs.getString(12);
                String category_id = rs.getString(13);
                String classification = rs.getString(14);
                String classification_id = rs.getString(15);
                String sub_classification = rs.getString(16);
                String sub_classification_id = rs.getString(17);
                String unit = rs.getString(18);
                double conversion = rs.getDouble(19);
                String item_type = rs.getString(20);
                int status = rs.getInt(21);
                String supplier = rs.getString(22);
                int fixed_price = rs.getInt(23);
                String supplier_id = rs.getString(24);
                int multi_level_pricing = rs.getInt(25);
                int vatable = rs.getInt(26);
                double reorder_level = rs.getDouble(27);
                double markup = rs.getDouble(28);
                String brand = rs.getString(29);
                String brand_id = rs.getString(30);
                String model = rs.getString(31);
                String model_id = rs.getString(32);
                String selling_type = rs.getString(33);
                String branch = rs.getString(34);
                String branch_code = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);
                String serial_no = rs.getString(38);
                String user_id = rs.getString(39);
                String user_screen_name = rs.getString(40);
                to_my_services_item_replacements_customers to = new to_my_services_item_replacements_customers(id, transaction_no, customer_id, customer_name, item_code, barcode, description, qty, selling_price, date_added, user_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S1_my_services_item_replacements.to_my_services_item_replacements> ret_data2(List<to_my_services_item_replacements_customers> datas) {
        List<S1_my_services_item_replacements.to_my_services_item_replacements> datas2 = new ArrayList();
        for (to_my_services_item_replacements_customers to : datas) {
            int id = to.id;
            String barcode = to.barcode;
            String description = to.description;
            double qty = to.qty;
            double price = to.selling_price;
            String item_code = to.item_code;
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            String unit = to.unit;
            double conversion = to.conversion;
            String item_type = to.item_type;
            int status = to.status;
            String supplier = to.supplier;
            int fixed_price = to.fixed_price;
            String supplier_id = to.supplier_id;
            int multi_level_pricing = to.multi_level_pricing;
            int vatable = to.vatable;
            double reorder_level = to.reorder_level;
            double markup = to.markup;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            String selling_type = to.selling_type;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String serial_no = to.serial_no;
            String user_id = to.user_id;
            String user_screen_name = to.user_screen_name;
            S1_my_services_item_replacements.to_my_services_item_replacements to1 = new S1_my_services_item_replacements.to_my_services_item_replacements(id, barcode, description, qty, price, item_code, category, category_id, classification, classification_id, sub_classification, sub_classification_id, unit, conversion, item_type, status, supplier, fixed_price, supplier_id, multi_level_pricing, vatable, reorder_level, markup, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, user_id, user_screen_name);
            datas2.add(to1);
        }
        return datas2;

    }

    public static List<Inventory_barcodes.to_inventory_barcodes> convert_to_inv_barcodes(List<My_services_item_replacements_customers.to_my_services_item_replacements_customers> datas) {
        List<Inventory_barcodes.to_inventory_barcodes> items = new ArrayList();
        for (My_services_item_replacements_customers.to_my_services_item_replacements_customers to : datas) {
            int id = to.id;
            String barcode = to.barcode;
            String description = to.description;
            String generic_name = "";
            String category = to.category;
            String category_id = to.category_id;
            String classification = to.classification;
            String classification_id = to.classification_id;
            String sub_classification = to.sub_classification;
            String sub_classification_id = to.sub_classification_id;
            double product_qty = to.qty;
            String unit = to.unit;
            double conversion = to.conversion;
            double selling_price = to.selling_price;
            String date_added = to.date_added;
            String user_name = to.user_name;
            String item_type = to.item_type;
            int status = to.status;
            String supplier = to.supplier;
            int fixed_price = to.fixed_price;
            double cost = to.selling_price;
            String supplier_id = to.supplier_id;
            int multi_level_pricing = to.multi_level_pricing;
            int vatable = to.vatable;
            double reorder_level = to.reorder_level;
            double markup = to.markup;
            String main_barcode = to.item_code;
            String brand = to.brand;
            String brand_id = to.brand_id;
            String model = to.model;
            String model_id = to.model_id;
            int selling_type = 1;
            String branch = to.branch;
            String branch_code = to.branch_code;
            String location = to.location;
            String location_id = to.location_id;
            String serial_no = to.serial_no;
            String selected_serials = to.serial_no;
            double discount = 0;
            double discount_amount = 0;
            String discount_name = "";
            String discount_customer_name = "";
            String discount_customer_id = "";

            Inventory_barcodes.to_inventory_barcodes to1 = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, selected_serials, discount, discount_amount, discount_name, discount_customer_name, discount_customer_id, 0, 0);
            items.add(to1);

        }
        return items;
    }
}
