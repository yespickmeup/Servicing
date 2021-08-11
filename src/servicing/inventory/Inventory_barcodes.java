/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;

import servicing.branch_locations.Branch_locations;
import servicing.inventory.Inventory.to_inventory;
import servicing.inventory_reports.Srpt_item_ledger;
import servicing.migrate.Migrate_asus_prices;
import servicing.utils.DateType;
import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.branch_locations.S1_branch_locations.to_branch_locations;

/**
 *
 * @author Ronald
 */
public class Inventory_barcodes {

    public static class to_inventory_barcodes {

        public final int id;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String supplier;
        public final int fixed_price;
        public final double cost;
        public final String supplier_id;
        public final int multi_level_pricing;
        public final int vatable;
        public final double reorder_level;
        public final double markup;
        public final String main_barcode;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int selling_type;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public String serial_no;
        public String selected_serials;
        public double discount;
        public double discount_amount;
        public String discount_name;
        public String discount_customer_name;
        public String discount_customer_id;
        public double addtl_amount;
        public double wtax;
        public final int allow_negative_inventory;
        public final int auto_order;
        public final int show_to_sales;

        public to_inventory_barcodes(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String serial_no, String selected_serials, double discount, double discount_amount, String discount_name, String discount_customer_name, String discount_customer_id, double addtl_amount, double wtax, int allow_negative_inventory, int auto_order, int show_to_sales) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.supplier = supplier;
            this.fixed_price = fixed_price;
            this.cost = cost;
            this.supplier_id = supplier_id;
            this.multi_level_pricing = multi_level_pricing;
            this.vatable = vatable;
            this.reorder_level = reorder_level;
            this.markup = markup;
            this.main_barcode = main_barcode;
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
            this.selected_serials = selected_serials;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.discount_name = discount_name;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.addtl_amount = addtl_amount;
            this.wtax = wtax;
            this.allow_negative_inventory = allow_negative_inventory;
            this.auto_order = auto_order;
            this.show_to_sales = show_to_sales;
        }

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

        public double getAddtl_amount() {
            return addtl_amount;
        }

        public void setAddtl_amount(double addtl_amount) {
            this.addtl_amount = addtl_amount;
        }

        public double getWtax() {
            return wtax;
        }

        public void setWtax(double wtax) {
            this.wtax = wtax;
        }

        public String getDiscount_customer_name() {
            return discount_customer_name;
        }

        public void setDiscount_customer_name(String discount_customer_name) {
            this.discount_customer_name = discount_customer_name;
        }

        public String getDiscount_customer_id() {
            return discount_customer_id;
        }

        public void setDiscount_customer_id(String discount_customer_id) {
            this.discount_customer_id = discount_customer_id;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public String getSelected_serials() {
            return selected_serials;
        }

        public void setSelected_serials(String selected_serials) {
            this.selected_serials = selected_serials;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getDiscount_name() {
            return discount_name;
        }

        public void setDiscount_name(String discount_name) {
            this.discount_name = discount_name;
        }

    }

    public static void add_inventory_barcodes(to_inventory_barcodes to_inventory_barcodes) {
        try {

            Connection conn = MyConnection.connect();
            List<to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (to_branch_locations to : datas) {
                String s0 = "insert into inventory_barcodes("
                        + "barcode"
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
                        + ",allow_negative_inventory"
                        + ",auto_order"
                        + ",show_to_sales"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:markup"
                        + ",:main_barcode"
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
                        + ",:allow_negative_inventory"
                        + ",:auto_order"
                        + ",:show_to_sales"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("barcode", to_inventory_barcodes.barcode).
                        setString("description", to_inventory_barcodes.description).
                        setString("generic_name", to_inventory_barcodes.generic_name).
                        setString("category", to_inventory_barcodes.category).
                        setString("category_id", to_inventory_barcodes.category_id).
                        setString("classification", to_inventory_barcodes.classification).
                        setString("classification_id", to_inventory_barcodes.classification_id).
                        setString("sub_classification", to_inventory_barcodes.sub_classification).
                        setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                        setNumber("product_qty", to_inventory_barcodes.product_qty).
                        setString("unit", to_inventory_barcodes.unit).
                        setNumber("conversion", to_inventory_barcodes.conversion).
                        setNumber("selling_price", to_inventory_barcodes.selling_price).
                        setString("date_added", to_inventory_barcodes.date_added).
                        setString("user_name", to_inventory_barcodes.user_name).
                        setString("item_type", to_inventory_barcodes.item_type).
                        setNumber("status", 1).
                        setString("supplier", to_inventory_barcodes.supplier).
                        setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                        setNumber("cost", to_inventory_barcodes.cost).
                        setString("supplier_id", to_inventory_barcodes.supplier_id).
                        setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                        setNumber("vatable", to_inventory_barcodes.vatable).
                        setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                        setNumber("markup", to_inventory_barcodes.markup).
                        setString("main_barcode", to_inventory_barcodes.main_barcode).
                        setString("brand", to_inventory_barcodes.brand).
                        setString("brand_id", to_inventory_barcodes.brand_id).
                        setString("model", to_inventory_barcodes.model).
                        setString("model_id", to_inventory_barcodes.model_id).
                        setNumber("selling_type", to_inventory_barcodes.selling_type).
                        setString("branch", to.branch).
                        setString("branch_code", to.branch_id).
                        setString("location", to.location).
                        setString("location_id", "" + to.id).
                        setString("serial_no", to_inventory_barcodes.serial_no).
                        setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                        setNumber("auto_order", to_inventory_barcodes.auto_order).
                        setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory_barcodes.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to.location);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_barcodes(to_inventory_barcodes to_inventory_barcodes) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_barcodes set "
                    + "barcode= :barcode"
                    + ",description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",product_qty= :product_qty"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",main_barcode= :main_barcode"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",branch= :branch"
                    + ",branch_code= :branch_code"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",serial_no=:serial_no"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " id ='" + to_inventory_barcodes.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setNumber("product_qty", to_inventory_barcodes.product_qty).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory_barcodes.selling_price).
                    setString("date_added", to_inventory_barcodes.date_added).
                    setString("user_name", to_inventory_barcodes.user_name).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setNumber("status", to_inventory_barcodes.status).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier_id", to_inventory_barcodes.supplier_id).
                    setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("main_barcode", to_inventory_barcodes.main_barcode).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("branch", to_inventory_barcodes.branch).
                    setString("branch_code", to_inventory_barcodes.branch_code).
                    setString("location", to_inventory_barcodes.location).
                    setString("location_id", to_inventory_barcodes.location_id).
                    setString("serial_no", to_inventory_barcodes.serial_no).
                    setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                    setNumber("auto_order", to_inventory_barcodes.auto_order).
                    setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_barcodes_price(int id, String unit, double selling_price) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_barcodes set "
                    + " unit= :unit"
                    + ",selling_price= :selling_price"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("unit", unit).
                    setNumber("selling_price", selling_price).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_barcodes_price(List<Migrate_asus_prices.asus> asus) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement("");
            for (Migrate_asus_prices.asus as : asus) {
                String s0 = "update inventory_barcodes set "
                        + " unit= :unit"
                        + ",cost= :cost"
                        + ",selling_price= :selling_price"
                        + " where "
                        + " main_barcode like '" + as.pn_rule + "' "
                        + " and location_id=32 "
                        + " ";
                double price = as.price * 1.20;
                String unit = "[pc" + ":" + price + "/1.0^1]";
                s0 = SqlStringUtil.parse(s0).
                        setString("unit", unit).
                        setNumber("cost", as.cost).
                        setNumber("selling_price", price).
                        ok();
                stmt.addBatch(s0);

                String s2 = "update inventory set "
                        + " unit= :unit"
                        + ",cost= :cost"
                        + ",selling_price= :selling_price"
                        + " where "
                        + " barcode like '" + as.pn_rule + "' "
                        + " and location_id=32 "
                        + " ";

                s2 = SqlStringUtil.parse(s2).
                        setString("unit", unit).
                        setNumber("cost", as.cost).
                        setNumber("selling_price", price).
                        ok();
                stmt.addBatch(s0);
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_barcodes_2(to_inventory_barcodes to_inventory_barcodes, to_inventory old_item) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",cost= :cost"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " main_barcode ='" + to_inventory_barcodes.main_barcode + "'  "
                    + " "
                    + " ";
            s0 = SqlStringUtil.parse(s0).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory_barcodes.selling_price).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                    setNumber("auto_order", to_inventory_barcodes.auto_order).
                    setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");

            String s2 = "update inventory_barcodes set "
                    + " barcode= :barcode"
                    + " where "
                    + " main_barcode ='" + to_inventory_barcodes.main_barcode + "'  "
                    + " and barcode ='" + old_item.barcodes + "'"
                    + " ";
            s2 = SqlStringUtil.parse(s2).
                    setString("barcode", to_inventory_barcodes.barcode).
                    ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_barcodes(to_inventory_barcodes to_inventory_barcodes) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_barcodes where "
                    + " id ='" + to_inventory_barcodes.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_barcodes.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_data2(String search) {
        List<to_inventory_barcodes> datas = new ArrayList();

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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes where "
                    + " barcode like '%" + search + "%' "
                    + " or description like '%" + search + "%'"
                    + " or main_barcode like '%" + search + "%' ";

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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_data(String search) {
        List<to_inventory_barcodes> datas = new ArrayList();
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes where "
                    + " main_barcode = '" + search + "' "
                    + " ";

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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                                                     sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier,
                                                                     fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type,
                                                                     branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_data_branch_location(String search, String branch_ids, String location_ids) {
        List<to_inventory_barcodes> datas = new ArrayList();
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes where "
                    + " main_barcode = '" + search + "' "
                    + " and "
                    + " branch_code like '%" + branch_ids + "%' "
                    + " and "
                    + " location_id like '%" + location_ids + "%'"
                    //                    + " group by location_id,barcode"
                    //                    + " order by location_id asc"
                    + "";

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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                                                     sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier,
                                                                     fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type,
                                                                     branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_data3(String search) {
        List<to_inventory_barcodes> datas = new ArrayList();

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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes "
                    + "where "
                    + " main_barcode like '%" + search + "%'"
                    + " or barcode like '%" + search + "%' "
                    + " or description like '%" + search + "%' ";

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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                                                     sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier,
                                                                     fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id,
                                                                     selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_where(String where) {
        List<to_inventory_barcodes> datas = new ArrayList();
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);

                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                                                     sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier,
                                                                     fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type,
                                                                     branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_where_cloud(String where) {
        List<to_inventory_barcodes> datas = new ArrayList();
        try {
            Connection conn = MyConnection.cloud_connect();
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                                                     sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier,
                                                                     fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type,
                                                                     branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_inventory_barcodes ret_to(String m_barcode, String bar, String location_ids) {
        to_inventory_barcodes to1 = null;

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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes where "
                    + " main_barcode='" + m_barcode + "' and location_id='" + location_ids + "'"
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
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

                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to1 = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);

            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_inventory_barcodes ret_to_conn(String m_barcode, String bar, String location_ids, Connection conn) {
        to_inventory_barcodes to1 = null;

        try {
//            Connection conn = MyConnection.connect();
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes where "
                    + " main_barcode='" + m_barcode + "' and location_id='" + location_ids + "'"
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
//            System.out.println("s0: " + s0);
            if (rs.next()) {
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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to1 = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);

            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_inventory_barcodes> datas = ret_data2("");
        System.out.println("aw");
    }

    public static List<to_inventory_barcodes> ret_where_barcode(String where22, String location_ids) {
        List<to_inventory_barcodes> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s02 = "select "
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes "
                    + " " + where22;

            Statement stmt22 = conn.createStatement();
            ResultSet rs22 = stmt22.executeQuery(s02);

            to_inventory_barcodes to = null;

            if (rs22.next()) {
                int id2 = rs22.getInt(1);
                String barcode2 = rs22.getString(2);
                String description2 = rs22.getString(3);
                String generic_name2 = rs22.getString(4);
                String category2 = rs22.getString(5);
                String category_id2 = rs22.getString(6);
                String classification2 = rs22.getString(7);
                String classification_id2 = rs22.getString(8);
                String sub_classification2 = rs22.getString(9);
                String sub_classification_id2 = rs22.getString(10);
                double product_qty2 = rs22.getDouble(11);
                String unit2 = rs22.getString(12);
                double conversion2 = rs22.getDouble(13);
                double selling_price2 = rs22.getDouble(14);
                String date_added2 = rs22.getString(15);
                String user_name2 = rs22.getString(16);
                String item_type2 = rs22.getString(17);
                int status2 = rs22.getInt(18);
                String supplier2 = rs22.getString(19);
                int fixed_price2 = rs22.getInt(20);
                double cost2 = rs22.getDouble(21);
                String supplier_id2 = rs22.getString(22);
                int multi_level_pricing2 = rs22.getInt(23);
                int vatable2 = rs22.getInt(24);
                double reorder_level2 = rs22.getDouble(25);
                double markup2 = rs22.getDouble(26);
                String main_barcode2 = rs22.getString(27);
                String brand2 = rs22.getString(28);
                String brand_id2 = rs22.getString(29);
                String model2 = rs22.getString(30);
                String model_id2 = rs22.getString(31);
                int selling_type2 = rs22.getInt(32);
                String branch2 = rs22.getString(33);
                String branch_code2 = rs22.getString(34);

                String location2 = rs22.getString(35);
                String location_id2 = rs22.getString(36);
                String serial_no2 = rs22.getString(37);
                int allow_negative_inventory = rs22.getInt(38);
                int auto_order = rs22.getInt(39);
                int show_to_sales = rs22.getInt(40);
                to = new to_inventory_barcodes(id2, barcode2, description2, generic_name2, category2, category_id2, classification2, classification_id2,
                                               sub_classification2, sub_classification_id2, product_qty2, unit2, conversion2, selling_price2, date_added2, user_name2, item_type2,
                                               status2, supplier2, fixed_price2, cost2, supplier_id2, multi_level_pricing2, vatable2, reorder_level2, markup2, main_barcode2,
                                               brand2, brand_id2, model2, model_id2, selling_type2, branch2, branch_code2, location2, location_id2, serial_no2, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                String year = "" + DateType.y.format(new Date());
                List<Srpt_item_ledger.field> field3 = new ArrayList();
                List<Srpt_item_ledger.field> fields = new ArrayList();

                String where = " where item_code ='" + main_barcode2 + "'    "
                        + "   ";
                String where2 = " where main_barcode ='" + main_barcode2 + "'   "
                        + "  ";
                String where3 = " where barcode ='" + main_barcode2 + "'    "
                        + "  ";
                String wheree = " where item_code ='" + main_barcode2 + "'   and status=1 ";

                List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
                List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
                List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
                List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
                List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
                List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
                List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
                List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
                List<Srpt_item_ledger.field> replenishments = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);

                //<editor-fold defaultstate="collapsed" desc=" sales ">
                String s0 = "select "
                        + "id"
                        + ",sales_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + " from sale_items"
                        + " " + where;

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String sales_no = rs.getString(2);
                    String item_code = rs.getString(3);
                    String barcode = rs.getString(4);
                    String description = rs.getString(5);
                    String generic_name = rs.getString(6);
                    String item_type = rs.getString(7);
                    String supplier_name = rs.getString(8);
                    String supplier_id = rs.getString(9);
                    String serial_no = rs.getString(10);
                    double product_qty = rs.getDouble(11);
                    String unit = rs.getString(12);
                    double conversion = rs.getDouble(13);
                    double selling_price = rs.getDouble(14);
                    String date_added = rs.getString(15);
                    String user_id = rs.getString(16);
                    String user_screen_name = rs.getString(17);
                    int status = rs.getInt(18);
                    int is_vatable = rs.getInt(19);
                    int selling_type = rs.getInt(20);
                    String discount_name = rs.getString(21);
                    double discount_rate = rs.getDouble(22);
                    double discount_amount = rs.getDouble(23);
                    String discount_customer_name = rs.getString(24);
                    String discount_customer_id = rs.getString(25);
                    String branch = rs.getString(26);
                    String branch_code = rs.getString(27);
                    String location = rs.getString(28);
                    String location_id = rs.getString(29);
                    String category = rs.getString(30);
                    String category_id = rs.getString(31);
                    String classification = rs.getString(32);
                    String classification_id = rs.getString(33);
                    String sub_classification = rs.getString(34);
                    String sub_classification_id = rs.getString(35);
                    String brand = rs.getString(36);
                    String brand_id = rs.getString(37);
                    String model = rs.getString(38);
                    String model_id = rs.getString(39);
                    double addtl_amount = rs.getDouble(40);
                    double wtax = rs.getDouble(41);

                    String transaction_type = "Sales";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + sales_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);

                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    sales.add(field);

                    if (status == 1) {
                        Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Sales - X", date, FitIn.fmt_woc(product_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        sales.add(field2);
                    }

                }

                //</editor-fold>                    
                //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
                String s2 = "select "
                        + "id"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",qty"
                        + ",date_added"
                        + ",user_name"
                        + ",screen_name"
                        + ",sheet_no"
                        + ",status"
                        + ",counted_by"
                        + ",checked_by"
                        + ",cost"
                        + ",selling_price"
                        + ",user_id"
                        + ",user_screen_name"
                        + " from encoding_inventory"
                        + " " + where;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int id = rs2.getInt(1);
                    String item_code = rs2.getString(2);
                    String barcode = rs2.getString(3);
                    String description = rs2.getString(4);
                    String branch = rs2.getString(5);
                    String branch_id = rs2.getString(6);
                    String location = rs2.getString(7);
                    String location_id = rs2.getString(8);
                    double qty = rs2.getDouble(9);
                    String date_added = rs2.getString(10);
                    String user_name = rs2.getString(11);
                    String screen_name = rs2.getString(12);
                    String sheet_no = rs2.getString(13);
                    int status = rs2.getInt(14);
                    String counted_by = rs2.getString(15);
                    String checked_by = rs2.getString(16);
                    double cost = rs2.getDouble(17);
                    double selling_price = rs2.getDouble(18);
                    String user_id = rs2.getString(19);
                    String user_screen_name = rs2.getString(20);

                    String transaction_type = "Inventory Count";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + sheet_no;
                    String cost1 = FitIn.fmt_wc_0(cost);
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                    inventory_count.add(field);
                }
                //</editor-fold>                   
                //<editor-fold defaultstate="collapsed" desc=" Receipts ">
                String s3 = "select "
                        + " id"
                        + ",receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",conversion"
                        + ",unit"
                        + ",date_delivered"
                        + ",date_received"
                        + ",barcodes"
                        + ",batch_no"
                        + ",serial_no"
                        + ",main_barcode"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",status"
                        + ",previous_cost"
                        + ",receipt_type_id"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from receipt_items"
                        + " " + where2;

                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                while (rs3.next()) {
                    int id = rs3.getInt(1);
                    String receipt_no = rs3.getString(2);
                    String user_name = rs3.getString(3);
                    String session_no = rs3.getString(4);
                    String date_added = rs3.getString(5);
                    String supplier = rs3.getString(6);
                    String supllier_id = rs3.getString(7);
                    String remarks = rs3.getString(8);
                    String barcode = rs3.getString(9);
                    String description = rs3.getString(10);
                    double qty = rs3.getDouble(11);
                    double cost = rs3.getDouble(12);
                    String category = rs3.getString(13);
                    String category_id = rs3.getString(14);
                    String classification = rs3.getString(15);
                    String classification_id = rs3.getString(16);
                    String sub_class = rs3.getString(17);
                    String sub_class_id = rs3.getString(18);
                    double conversion = rs3.getDouble(19);
                    String unit = rs3.getString(20);
                    String date_delivered = rs3.getString(21);
                    String date_received = rs3.getString(22);
                    String barcodes = rs3.getString(23);
                    String batch_no = rs3.getString(24);
                    String serial_no = rs3.getString(25);
                    String main_barcode = rs3.getString(26);
                    String brand = rs3.getString(27);
                    String brand_id = rs3.getString(28);
                    String model = rs3.getString(29);
                    String model_id = rs3.getString(30);
                    int status = rs3.getInt(31);
                    double previous_cost = rs3.getDouble(32);
                    String receipt_type_id = rs3.getString(33);
                    String branch = rs3.getString(34);
                    String branch_id = rs3.getString(35);
                    String location = rs3.getString(36);
                    String location_id = rs3.getString(37);

                    String transaction_type = "Receipts";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + receipt_no;
                    String cost1 = FitIn.fmt_wc_0(cost);
                    String price1 = "";
                    String months = DateType.convert_datetime_to_month(date_added);

                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_branch, from_branch_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    if (status == 1) {
                        receipts.add(field);
                    }

                }

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Transfers ">
                List<Srpt_item_ledger.field> transfer_in = new ArrayList();
                List<Srpt_item_ledger.field> transfer_out = new ArrayList();
                String s4 = "select "
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
                        + ",barcodes"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",selling_type"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",stock_transfer_id"
                        + ",serial_no"
                        + ",to_branch"
                        + ",to_branch_id"
                        + ",to_location"
                        + ",to_location_id"
                        + " from stock_transfers_items"
                        + " " + where3;

                Statement stmt4 = conn.createStatement();
                ResultSet rs4 = stmt4.executeQuery(s4);
                while (rs4.next()) {
                    int id = rs4.getInt(1);
                    String barcode = rs4.getString(2);
                    String description = rs4.getString(3);
                    String generic_name = rs4.getString(4);
                    String category = rs4.getString(5);
                    String category_id = rs4.getString(6);
                    String classification = rs4.getString(7);
                    String classification_id = rs4.getString(8);
                    String sub_classification = rs4.getString(9);
                    String sub_classification_id = rs4.getString(10);
                    double product_qty = rs4.getDouble(11);
                    String unit = rs4.getString(12);
                    double conversion = rs4.getDouble(13);
                    double selling_price = rs4.getDouble(14);
                    String date_added = rs4.getString(15);
                    String user_name = rs4.getString(16);
                    String item_type = rs4.getString(17);
                    int status = rs4.getInt(18);
                    String supplier = rs4.getString(19);
                    int fixed_price = rs4.getInt(20);
                    double cost = rs4.getDouble(21);
                    String supplier_id = rs4.getString(22);
                    int multi_level_pricing = rs4.getInt(23);
                    int vatable = rs4.getInt(24);
                    double reorder_level = rs4.getDouble(25);
                    double markup = rs4.getDouble(26);
                    String barcodes = rs4.getString(27);
                    String brand = rs4.getString(28);
                    String brand_id = rs4.getString(29);
                    String model = rs4.getString(30);
                    String model_id = rs4.getString(31);
                    int selling_type = rs4.getInt(32);
                    String branch = rs4.getString(33);
                    String branch_code = rs4.getString(34);
                    String location = rs4.getString(35);
                    String location_id = rs4.getString(36);
                    String stock_transfer_id = rs4.getString(37);
                    String serial_no = rs4.getString(38);
                    String to_branch = rs4.getString(39);
                    String to_branch_id = rs4.getString(40);
                    String to_location = rs4.getString(41);
                    String to_location_id = rs4.getString(42);

                    String transaction_type = "Transfer";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(product_qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch1 = "";
                    String to_branch_id1 = "";
                    String to_location1 = "";
                    String to_location_id1 = "";
                    String created_by = user_name;
                    String customer_name = "";
                    Date created = new Date();

                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String transaction_no = "" + stock_transfer_id;
                    String cost1 = FitIn.fmt_wc_0(cost);
                    String price1 = "";
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                    Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                    if (status == 1) {
                        transfer_in.add(field_out);
                        transfer_out.add(field_in);
                    }
                }

                transfers.addAll(transfer_in);
                transfers.addAll(transfer_out);
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
                List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
                List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
                String s5 = "select "
                        + "id"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",new_qty"
                        + ",is_add"
                        + ",date_added"
                        + ",status"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from adjustments"
                        + " " + where;

                Statement stmt5 = conn.createStatement();
                ResultSet rs5 = stmt5.executeQuery(s5);
                while (rs5.next()) {
                    int id = rs5.getInt(1);
                    String item_code = rs5.getString(2);
                    String barcode = rs5.getString(3);
                    String description = rs5.getString(4);
                    double qty = rs5.getDouble(5);
                    double new_qty = rs5.getDouble(6);
                    int is_add = rs5.getInt(7);
                    String date_added = rs5.getString(8);
                    int status = rs5.getInt(9);
                    String user_id = rs5.getString(10);
                    String user_screen_name = rs5.getString(11);
                    String branch = rs5.getString(12);
                    String branch_id = rs5.getString(13);
                    String location = rs5.getString(14);
                    String location_id = rs5.getString(15);

                    String transaction_type = "Adjustment";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(new_qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + id;
                    String cost1 = "";
                    String price1 = "";
                    String months = DateType.convert_datetime_to_month(date_added);
                    if (is_add == 1) {
                        Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        adjustment_add.add(add);
                    } else {
                        Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        adjustment_deduct.add(deduct);
                    }

                }
                adjustments.addAll(adjustment_add);
                adjustments.addAll(adjustment_deduct);

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
                String s6 = "select "
                        + "id"
                        + ",sales_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + " from sale_item_replacements"
                        + " " + where;
                Statement stmt6 = conn.createStatement();
                ResultSet rs6 = stmt6.executeQuery(s6);
                while (rs6.next()) {
                    int id = rs6.getInt(1);
                    String sales_no = rs6.getString(2);
                    String item_code = rs6.getString(3);
                    String barcode = rs6.getString(4);
                    String description = rs6.getString(5);
                    String generic_name = rs6.getString(6);
                    String item_type = rs6.getString(7);
                    String supplier_name = rs6.getString(8);
                    String supplier_id = rs6.getString(9);
                    String serial_no = rs6.getString(10);
                    double product_qty = rs6.getDouble(11);
                    String unit = rs6.getString(12);
                    double conversion = rs6.getDouble(13);
                    double selling_price = rs6.getDouble(14);
                    String date_added = rs6.getString(15);
                    String user_id = rs6.getString(16);
                    String user_screen_name = rs6.getString(17);
                    int status = rs6.getInt(18);
                    int is_vatable = rs6.getInt(19);
                    int selling_type = rs6.getInt(20);
                    String discount_name = rs6.getString(21);
                    double discount_rate = rs6.getDouble(22);
                    double discount_amount = rs6.getDouble(23);
                    String discount_customer_name = rs6.getString(24);
                    String discount_customer_id = rs6.getString(25);
                    String branch = rs6.getString(26);
                    String branch_code = rs6.getString(27);
                    String location = rs6.getString(28);
                    String location_id = rs6.getString(29);
                    String category = rs6.getString(30);
                    String category_id = rs6.getString(31);
                    String classification = rs6.getString(32);
                    String classification_id = rs6.getString(33);
                    String sub_classification = rs6.getString(34);
                    String sub_classification_id = rs6.getString(35);
                    String brand = rs6.getString(36);
                    String brand_id = rs6.getString(37);
                    String model = rs6.getString(38);
                    String model_id = rs6.getString(39);
                    int is_replacement = rs6.getInt(40);

                    String transaction_type = "Exc-Replacement";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + sales_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    if (is_replacement == 0) {
                        transaction_type = "Exc-Returned";
                        in = FitIn.fmt_woc(product_qty);
                        out = "";
                        String months = DateType.convert_datetime_to_month(date_added);
                        Srpt_item_ledger.field field1 = new Srpt_item_ledger.field("Sales", date, "", in, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        return_exchange.add(field1);

                        String months1 = DateType.convert_datetime_to_month(date_added);
                        Srpt_item_ledger.field field11 = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        return_exchange.add(field11);
                    }

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
                String s7 = "select "
                        + "id"
                        + ",customer_id"
                        + ",customer_name"
                        + ",ar_id"
                        + ",ar_no"
                        + ",date_applied"
                        + ",reference_no"
                        + ",soa_type"
                        + ",soa_type_id"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",remarks"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + " from charge_in_advance_items"
                        + " " + where;

                Statement stmt7 = conn.createStatement();
                ResultSet rs7 = stmt7.executeQuery(s7);
                while (rs7.next()) {
                    int id = rs7.getInt(1);
                    String customer_id = rs7.getString(2);
                    String customer_name = rs7.getString(3);
                    String ar_id = rs7.getString(4);
                    String ar_no = rs7.getString(5);
                    String date_applied = rs7.getString(6);
                    String reference_no = rs7.getString(7);
                    String soa_type = rs7.getString(8);
                    String soa_type_id = rs7.getString(9);
                    String user_screen_name = rs7.getString(10);
                    String user_id = rs7.getString(11);
                    String remarks = rs7.getString(12);
                    String item_code = rs7.getString(13);
                    String barcode = rs7.getString(14);
                    String description = rs7.getString(15);
                    String generic_name = rs7.getString(16);
                    String item_type = rs7.getString(17);
                    String supplier_name = rs7.getString(18);
                    String supplier_id = rs7.getString(19);
                    String serial_no = rs7.getString(20);
                    double product_qty = rs7.getDouble(21);
                    String unit = rs7.getString(22);
                    double conversion = rs7.getDouble(23);
                    double selling_price = rs7.getDouble(24);
                    String date_added = rs7.getString(25);
                    int status = rs7.getInt(26);
                    int is_vatable = rs7.getInt(27);
                    int selling_type = rs7.getInt(28);
                    String discount_name = rs7.getString(29);
                    double discount_rate = rs7.getDouble(30);
                    double discount_amount = rs7.getDouble(31);
                    String discount_customer_name = rs7.getString(32);
                    String discount_customer_id = rs7.getString(33);
                    String branch = rs7.getString(34);
                    String branch_code = rs7.getString(35);
                    String location = rs7.getString(36);
                    String location_id = rs7.getString(37);
                    String category = rs7.getString(38);
                    String category_id = rs7.getString(39);
                    String classification = rs7.getString(40);
                    String classification_id = rs7.getString(41);
                    String sub_classification = rs7.getString(42);
                    String sub_classification_id = rs7.getString(43);
                    String brand = rs7.getString(44);
                    String brand_id = rs7.getString(45);
                    String model = rs7.getString(46);
                    String model_id = rs7.getString(47);
                    double addtl_amount = rs7.getDouble(48);
                    double wtax = rs7.getDouble(49);

                    String transaction_type = "Charge in Advance[-]";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + ar_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);

                    if (status == 0) {
                        Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        charge_in_advance.add(field);
                    } else {
                        Srpt_item_ledger.field field = new Srpt_item_ledger.field("Charge in Advance[+]", date, out, "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        charge_in_advance.add(field);
                    }

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Replenishment ">
                String s9 = "select "
                        + "id"
                        + ",inventory_replenishment_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from inventory_replenishment_items"
                        + " " + wheree;

                Statement stmt9 = conn.createStatement();
                ResultSet rs9 = stmt9.executeQuery(s9);
                while (rs9.next()) {
                    int id = rs9.getInt(1);
                    String inventory_replenishment_no = rs9.getString(2);
                    String item_code = rs9.getString(3);
                    String barcode = rs9.getString(4);
                    String description = rs9.getString(5);
                    double product_qty = rs9.getDouble(6);
                    String unit = rs9.getString(7);
                    double conversion = rs9.getDouble(8);
                    double selling_price = rs9.getDouble(9);
                    String date_added = rs9.getString(10);
                    String user_id = rs9.getString(11);
                    String user_screen_name = rs9.getString(12);
                    int status = rs9.getInt(13);
                    String branch = rs9.getString(14);
                    String branch_id = rs9.getString(15);
                    String location = rs9.getString(16);
                    String location_id = rs9.getString(17);

                    String transaction_type = "Replenishment";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);

                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + inventory_replenishment_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, user_screen_name, created, transaction_no, cost1, price1, months, "");
                    replenishments.add(field);
                }
                //</editor-fold>

                fields.addAll(inventory_count);
                fields.addAll(sales);
                fields.addAll(receipts);
                fields.addAll(transfers);
                fields.addAll(adjustments);
                fields.addAll(return_exchange);
                fields.addAll(charge_in_advance);
                fields.addAll(charge_in_advance_cancelled);
                fields.addAll(replenishments);

                Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
                             @Override
                             public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
                                 return o1.getDate_added().compareTo(o2.getDate_added());
                             }
                         });

                double qty = 0;
                for (Srpt_item_ledger.field f : fields) {
                    if (f.getFrom_location_id().equalsIgnoreCase("" + location_ids)) {
                        if (FitIn.toDouble(f.getIn()) > 0) {
                            qty += FitIn.toDouble(f.getIn());
                        } else {
                            qty -= FitIn.toDouble(f.getOut());
                        }
                        if (f.getTransaction_type().equalsIgnoreCase("Replenishment")) {
                            qty = 0;
                        }
                    }
                }

                to.setProduct_qty(qty);
                datas.add(to);
            }

            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_where_list(String where22, String location_ids) {
        List<to_inventory_barcodes> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s22 = "select "
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes "
                    + " " + where22;

            Statement stmt22 = conn.createStatement();
            ResultSet rs22 = stmt22.executeQuery(s22);
            while (rs22.next()) {
                int id2 = rs22.getInt(1);
                String barcode2 = rs22.getString(2);
                String description2 = rs22.getString(3);
                String generic_name2 = rs22.getString(4);
                String category2 = rs22.getString(5);
                String category_id2 = rs22.getString(6);
                String classification2 = rs22.getString(7);
                String classification_id2 = rs22.getString(8);
                String sub_classification2 = rs22.getString(9);
                String sub_classification_id2 = rs22.getString(10);
                double product_qty2 = rs22.getDouble(11);
                String unit2 = rs22.getString(12);
                double conversion2 = rs22.getDouble(13);
                double selling_price2 = rs22.getDouble(14);
                String date_added2 = rs22.getString(15);
                String user_name2 = rs22.getString(16);
                String item_type2 = rs22.getString(17);
                int status2 = rs22.getInt(18);
                String supplier2 = rs22.getString(19);
                int fixed_price2 = rs22.getInt(20);
                double cost2 = rs22.getDouble(21);
                String supplier_id2 = rs22.getString(22);
                int multi_level_pricing2 = rs22.getInt(23);
                int vatable2 = rs22.getInt(24);
                double reorder_level2 = rs22.getDouble(25);
                double markup2 = rs22.getDouble(26);
                String main_barcode2 = rs22.getString(27);
                String brand2 = rs22.getString(28);
                String brand_id2 = rs22.getString(29);
                String model2 = rs22.getString(30);
                String model_id2 = rs22.getString(31);
                int selling_type2 = rs22.getInt(32);
                String branch2 = rs22.getString(33);
                String branch_code2 = rs22.getString(34);

                String location2 = rs22.getString(35);
                String location_id2 = rs22.getString(36);
                String serial_no2 = rs22.getString(37);
                int allow_negative_inventory = rs22.getInt(38);
                int auto_order = rs22.getInt(39);
                int show_to_sales = rs22.getInt(40);
                to_inventory_barcodes to = new to_inventory_barcodes(id2, barcode2, description2, generic_name2, category2, category_id2, classification2, classification_id2, sub_classification2, sub_classification_id2, product_qty2, unit2, conversion2, selling_price2, date_added2, user_name2, item_type2, status2, supplier2, fixed_price2, cost2, supplier_id2, multi_level_pricing2, vatable2, reorder_level2, markup2, main_barcode2, brand2, brand_id2, model2, model_id2, selling_type2, branch2, branch_code2, location2, location_id2, serial_no2, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);

                String year = "" + DateType.y.format(new Date());
                List<Srpt_item_ledger.field> field3 = new ArrayList();
                List<Srpt_item_ledger.field> fields = new ArrayList();

                String where = " where item_code ='" + to.main_barcode + "'  and YEAR(date_added)='" + year + "'  "
                        + "   ";
                String where2 = " where main_barcode ='" + to.main_barcode + "'  and YEAR(date_added)='" + year + "' "
                        + "  ";
                String where3 = " where barcode ='" + to.main_barcode + "'   and YEAR(date_added)='" + year + "' "
                        + "  ";
                String wheree = " where item_code ='" + to.main_barcode + "'  and YEAR(date_added)='" + year + "'  and status=1 "
                        + "   ";

                List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
                List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
                List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
                List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
                List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
                List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
                List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
                List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
                List<Srpt_item_ledger.field> replenishments = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);

                //<editor-fold defaultstate="collapsed" desc=" sales ">
                String s0 = "select "
                        + "id"
                        + ",sales_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + " from sale_items"
                        + " " + where;

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String sales_no = rs.getString(2);
                    String item_code = rs.getString(3);
                    String barcode = rs.getString(4);
                    String description = rs.getString(5);
                    String generic_name = rs.getString(6);
                    String item_type = rs.getString(7);
                    String supplier_name = rs.getString(8);
                    String supplier_id = rs.getString(9);
                    String serial_no = rs.getString(10);
                    double product_qty = rs.getDouble(11);
                    String unit = rs.getString(12);
                    double conversion = rs.getDouble(13);
                    double selling_price = rs.getDouble(14);
                    String date_added = rs.getString(15);
                    String user_id = rs.getString(16);
                    String user_screen_name = rs.getString(17);
                    int status = rs.getInt(18);
                    int is_vatable = rs.getInt(19);
                    int selling_type = rs.getInt(20);
                    String discount_name = rs.getString(21);
                    double discount_rate = rs.getDouble(22);
                    double discount_amount = rs.getDouble(23);
                    String discount_customer_name = rs.getString(24);
                    String discount_customer_id = rs.getString(25);
                    String branch = rs.getString(26);
                    String branch_code = rs.getString(27);
                    String location = rs.getString(28);
                    String location_id = rs.getString(29);
                    String category = rs.getString(30);
                    String category_id = rs.getString(31);
                    String classification = rs.getString(32);
                    String classification_id = rs.getString(33);
                    String sub_classification = rs.getString(34);
                    String sub_classification_id = rs.getString(35);
                    String brand = rs.getString(36);
                    String brand_id = rs.getString(37);
                    String model = rs.getString(38);
                    String model_id = rs.getString(39);
                    double addtl_amount = rs.getDouble(40);
                    double wtax = rs.getDouble(41);

                    String transaction_type = "Sales";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + sales_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);

                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    sales.add(field);
                    if (status == 1) {
                        Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Sales - X", date, FitIn.fmt_woc(product_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        sales.add(field2);
                    }
                }

                //</editor-fold>                    
                //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
                String s2 = "select "
                        + "id"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ",qty"
                        + ",date_added"
                        + ",user_name"
                        + ",screen_name"
                        + ",sheet_no"
                        + ",status"
                        + ",counted_by"
                        + ",checked_by"
                        + ",cost"
                        + ",selling_price"
                        + ",user_id"
                        + ",user_screen_name"
                        + " from encoding_inventory"
                        + " " + where;

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int id = rs2.getInt(1);
                    String item_code = rs2.getString(2);
                    String barcode = rs2.getString(3);
                    String description = rs2.getString(4);
                    String branch = rs2.getString(5);
                    String branch_id = rs2.getString(6);
                    String location = rs2.getString(7);
                    String location_id = rs2.getString(8);
                    double qty = rs2.getDouble(9);
                    String date_added = rs2.getString(10);
                    String user_name = rs2.getString(11);
                    String screen_name = rs2.getString(12);
                    String sheet_no = rs2.getString(13);
                    int status = rs2.getInt(14);
                    String counted_by = rs2.getString(15);
                    String checked_by = rs2.getString(16);
                    double cost = rs2.getDouble(17);
                    double selling_price = rs2.getDouble(18);
                    String user_id = rs2.getString(19);
                    String user_screen_name = rs2.getString(20);

                    String transaction_type = "Inventory Count";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + sheet_no;
                    String cost1 = FitIn.fmt_wc_0(cost);
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                    inventory_count.add(field);
                }
                //</editor-fold>                   
                //<editor-fold defaultstate="collapsed" desc=" Receipts ">
                String s3 = "select "
                        + " id"
                        + ",receipt_no"
                        + ",user_name"
                        + ",session_no"
                        + ",date_added"
                        + ",supplier"
                        + ",supllier_id"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",cost"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",conversion"
                        + ",unit"
                        + ",date_delivered"
                        + ",date_received"
                        + ",barcodes"
                        + ",batch_no"
                        + ",serial_no"
                        + ",main_barcode"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",status"
                        + ",previous_cost"
                        + ",receipt_type_id"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from receipt_items"
                        + " " + where2;

                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                while (rs3.next()) {
                    int id = rs3.getInt(1);
                    String receipt_no = rs3.getString(2);
                    String user_name = rs3.getString(3);
                    String session_no = rs3.getString(4);
                    String date_added = rs3.getString(5);
                    String supplier = rs3.getString(6);
                    String supllier_id = rs3.getString(7);
                    String remarks = rs3.getString(8);
                    String barcode = rs3.getString(9);
                    String description = rs3.getString(10);
                    double qty = rs3.getDouble(11);
                    double cost = rs3.getDouble(12);
                    String category = rs3.getString(13);
                    String category_id = rs3.getString(14);
                    String classification = rs3.getString(15);
                    String classification_id = rs3.getString(16);
                    String sub_class = rs3.getString(17);
                    String sub_class_id = rs3.getString(18);
                    double conversion = rs3.getDouble(19);
                    String unit = rs3.getString(20);
                    String date_delivered = rs3.getString(21);
                    String date_received = rs3.getString(22);
                    String barcodes = rs3.getString(23);
                    String batch_no = rs3.getString(24);
                    String serial_no = rs3.getString(25);
                    String main_barcode = rs3.getString(26);
                    String brand = rs3.getString(27);
                    String brand_id = rs3.getString(28);
                    String model = rs3.getString(29);
                    String model_id = rs3.getString(30);
                    int status = rs3.getInt(31);
                    double previous_cost = rs3.getDouble(32);
                    String receipt_type_id = rs3.getString(33);
                    String branch = rs3.getString(34);
                    String branch_id = rs3.getString(35);
                    String location = rs3.getString(36);
                    String location_id = rs3.getString(37);

                    String transaction_type = "Receipts";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + receipt_no;
                    String cost1 = FitIn.fmt_wc_0(cost);
                    String price1 = "";
                    String months = DateType.convert_datetime_to_month(date_added);

                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    if (status == 1) {
                        receipts.add(field);
                    }

                }

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Transfers ">
                List<Srpt_item_ledger.field> transfer_in = new ArrayList();
                List<Srpt_item_ledger.field> transfer_out = new ArrayList();
                String s4 = "select "
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
                        + ",barcodes"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",selling_type"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",stock_transfer_id"
                        + ",serial_no"
                        + ",to_branch"
                        + ",to_branch_id"
                        + ",to_location"
                        + ",to_location_id"
                        + " from stock_transfers_items"
                        + " " + where3;

                Statement stmt4 = conn.createStatement();
                ResultSet rs4 = stmt4.executeQuery(s4);
                while (rs4.next()) {
                    int id = rs4.getInt(1);
                    String barcode = rs4.getString(2);
                    String description = rs4.getString(3);
                    String generic_name = rs4.getString(4);
                    String category = rs4.getString(5);
                    String category_id = rs4.getString(6);
                    String classification = rs4.getString(7);
                    String classification_id = rs4.getString(8);
                    String sub_classification = rs4.getString(9);
                    String sub_classification_id = rs4.getString(10);
                    double product_qty = rs4.getDouble(11);
                    String unit = rs4.getString(12);
                    double conversion = rs4.getDouble(13);
                    double selling_price = rs4.getDouble(14);
                    String date_added = rs4.getString(15);
                    String user_name = rs4.getString(16);
                    String item_type = rs4.getString(17);
                    int status = rs4.getInt(18);
                    String supplier = rs4.getString(19);
                    int fixed_price = rs4.getInt(20);
                    double cost = rs4.getDouble(21);
                    String supplier_id = rs4.getString(22);
                    int multi_level_pricing = rs4.getInt(23);
                    int vatable = rs4.getInt(24);
                    double reorder_level = rs4.getDouble(25);
                    double markup = rs4.getDouble(26);
                    String barcodes = rs4.getString(27);
                    String brand = rs4.getString(28);
                    String brand_id = rs4.getString(29);
                    String model = rs4.getString(30);
                    String model_id = rs4.getString(31);
                    int selling_type = rs4.getInt(32);
                    String branch = rs4.getString(33);
                    String branch_code = rs4.getString(34);
                    String location = rs4.getString(35);
                    String location_id = rs4.getString(36);
                    String stock_transfer_id = rs4.getString(37);
                    String serial_no = rs4.getString(38);
                    String to_branch = rs4.getString(39);
                    String to_branch_id = rs4.getString(40);
                    String to_location = rs4.getString(41);
                    String to_location_id = rs4.getString(42);

                    String transaction_type = "Transfer";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(product_qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch1 = "";
                    String to_branch_id1 = "";
                    String to_location1 = "";
                    String to_location_id1 = "";
                    String created_by = user_name;
                    String customer_name = "";
                    Date created = new Date();

                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String transaction_no = "" + stock_transfer_id;
                    String cost1 = FitIn.fmt_wc_0(cost);
                    String price1 = "";
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                    Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                    if (status == 1) {
                        transfer_in.add(field_out);
                        transfer_out.add(field_in);
                    }
                }

                transfers.addAll(transfer_in);
                transfers.addAll(transfer_out);
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
                List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
                List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
                String s5 = "select "
                        + "id"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",qty"
                        + ",new_qty"
                        + ",is_add"
                        + ",date_added"
                        + ",status"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from adjustments"
                        + " " + where;

                Statement stmt5 = conn.createStatement();
                ResultSet rs5 = stmt5.executeQuery(s5);
                while (rs5.next()) {
                    int id = rs5.getInt(1);
                    String item_code = rs5.getString(2);
                    String barcode = rs5.getString(3);
                    String description = rs5.getString(4);
                    double qty = rs5.getDouble(5);
                    double new_qty = rs5.getDouble(6);
                    int is_add = rs5.getInt(7);
                    String date_added = rs5.getString(8);
                    int status = rs5.getInt(9);
                    String user_id = rs5.getString(10);
                    String user_screen_name = rs5.getString(11);
                    String branch = rs5.getString(12);
                    String branch_id = rs5.getString(13);
                    String location = rs5.getString(14);
                    String location_id = rs5.getString(15);

                    String transaction_type = "Adjustment";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(new_qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + id;
                    String cost1 = "";
                    String price1 = "";
                    String months = DateType.convert_datetime_to_month(date_added);
                    if (is_add == 1) {
                        Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        adjustment_add.add(add);
                    } else {
                        Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                        adjustment_deduct.add(deduct);
                    }

                }
                adjustments.addAll(adjustment_add);
                adjustments.addAll(adjustment_deduct);

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
                String s6 = "select "
                        + "id"
                        + ",sales_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",is_replacement"
                        + " from sale_item_replacements"
                        + " " + where;
                Statement stmt6 = conn.createStatement();
                ResultSet rs6 = stmt6.executeQuery(s6);
                while (rs6.next()) {
                    int id = rs6.getInt(1);
                    String sales_no = rs6.getString(2);
                    String item_code = rs6.getString(3);
                    String barcode = rs6.getString(4);
                    String description = rs6.getString(5);
                    String generic_name = rs6.getString(6);
                    String item_type = rs6.getString(7);
                    String supplier_name = rs6.getString(8);
                    String supplier_id = rs6.getString(9);
                    String serial_no = rs6.getString(10);
                    double product_qty = rs6.getDouble(11);
                    String unit = rs6.getString(12);
                    double conversion = rs6.getDouble(13);
                    double selling_price = rs6.getDouble(14);
                    String date_added = rs6.getString(15);
                    String user_id = rs6.getString(16);
                    String user_screen_name = rs6.getString(17);
                    int status = rs6.getInt(18);
                    int is_vatable = rs6.getInt(19);
                    int selling_type = rs6.getInt(20);
                    String discount_name = rs6.getString(21);
                    double discount_rate = rs6.getDouble(22);
                    double discount_amount = rs6.getDouble(23);
                    String discount_customer_name = rs6.getString(24);
                    String discount_customer_id = rs6.getString(25);
                    String branch = rs6.getString(26);
                    String branch_code = rs6.getString(27);
                    String location = rs6.getString(28);
                    String location_id = rs6.getString(29);
                    String category = rs6.getString(30);
                    String category_id = rs6.getString(31);
                    String classification = rs6.getString(32);
                    String classification_id = rs6.getString(33);
                    String sub_classification = rs6.getString(34);
                    String sub_classification_id = rs6.getString(35);
                    String brand = rs6.getString(36);
                    String brand_id = rs6.getString(37);
                    String model = rs6.getString(38);
                    String model_id = rs6.getString(39);
                    int is_replacement = rs6.getInt(40);

                    String transaction_type = "Exc-Replacement";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    String customer_name = "";
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + sales_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    if (is_replacement == 0) {
                        transaction_type = "Exc-Returned";
                        in = FitIn.fmt_woc(product_qty);
                        out = "";
                    }
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    return_exchange.add(field);

                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
                String s7 = "select "
                        + "id"
                        + ",customer_id"
                        + ",customer_name"
                        + ",ar_id"
                        + ",ar_no"
                        + ",date_applied"
                        + ",reference_no"
                        + ",soa_type"
                        + ",soa_type_id"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",remarks"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + " from charge_in_advance_items"
                        + " " + where;

                Statement stmt7 = conn.createStatement();
                ResultSet rs7 = stmt7.executeQuery(s7);
                while (rs7.next()) {
                    int id = rs7.getInt(1);
                    String customer_id = rs7.getString(2);
                    String customer_name = rs7.getString(3);
                    String ar_id = rs7.getString(4);
                    String ar_no = rs7.getString(5);
                    String date_applied = rs7.getString(6);
                    String reference_no = rs7.getString(7);
                    String soa_type = rs7.getString(8);
                    String soa_type_id = rs7.getString(9);
                    String user_screen_name = rs7.getString(10);
                    String user_id = rs7.getString(11);
                    String remarks = rs7.getString(12);
                    String item_code = rs7.getString(13);
                    String barcode = rs7.getString(14);
                    String description = rs7.getString(15);
                    String generic_name = rs7.getString(16);
                    String item_type = rs7.getString(17);
                    String supplier_name = rs7.getString(18);
                    String supplier_id = rs7.getString(19);
                    String serial_no = rs7.getString(20);
                    double product_qty = rs7.getDouble(21);
                    String unit = rs7.getString(22);
                    double conversion = rs7.getDouble(23);
                    double selling_price = rs7.getDouble(24);
                    String date_added = rs7.getString(25);
                    int status = rs7.getInt(26);
                    int is_vatable = rs7.getInt(27);
                    int selling_type = rs7.getInt(28);
                    String discount_name = rs7.getString(29);
                    double discount_rate = rs7.getDouble(30);
                    double discount_amount = rs7.getDouble(31);
                    String discount_customer_name = rs7.getString(32);
                    String discount_customer_id = rs7.getString(33);
                    String branch = rs7.getString(34);
                    String branch_code = rs7.getString(35);
                    String location = rs7.getString(36);
                    String location_id = rs7.getString(37);
                    String category = rs7.getString(38);
                    String category_id = rs7.getString(39);
                    String classification = rs7.getString(40);
                    String classification_id = rs7.getString(41);
                    String sub_classification = rs7.getString(42);
                    String sub_classification_id = rs7.getString(43);
                    String brand = rs7.getString(44);
                    String brand_id = rs7.getString(45);
                    String model = rs7.getString(46);
                    String model_id = rs7.getString(47);
                    double addtl_amount = rs7.getDouble(48);
                    double wtax = rs7.getDouble(49);

                    String transaction_type = "Charge in Advance";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + ar_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    charge_in_advance.add(field);
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Charge in advance[-] ">
                String s8 = "select "
                        + "id"
                        + ",customer_id"
                        + ",customer_name"
                        + ",ar_id"
                        + ",ar_no"
                        + ",date_applied"
                        + ",reference_no"
                        + ",soa_type"
                        + ",soa_type_id"
                        + ",user_screen_name"
                        + ",user_id"
                        + ",remarks"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",generic_name"
                        + ",item_type"
                        + ",supplier_name"
                        + ",supplier_id"
                        + ",serial_no"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",status"
                        + ",is_vatable"
                        + ",selling_type"
                        + ",discount_name"
                        + ",discount_rate"
                        + ",discount_amount"
                        + ",discount_customer_name"
                        + ",discount_customer_id"
                        + ",branch"
                        + ",branch_code"
                        + ",location"
                        + ",location_id"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",addtl_amount"
                        + ",wtax"
                        + " from charge_in_advance_cancelled_items"
                        + " " + where;

                Statement stmt8 = conn.createStatement();
                ResultSet rs8 = stmt8.executeQuery(s8);
                while (rs8.next()) {
                    int id = rs8.getInt(1);
                    String customer_id = rs8.getString(2);
                    String customer_name = rs8.getString(3);
                    String ar_id = rs8.getString(4);
                    String ar_no = rs8.getString(5);
                    String date_applied = rs8.getString(6);
                    String reference_no = rs8.getString(7);
                    String soa_type = rs8.getString(8);
                    String soa_type_id = rs8.getString(9);
                    String user_screen_name = rs8.getString(10);
                    String user_id = rs8.getString(11);
                    String remarks = rs8.getString(12);
                    String item_code = rs8.getString(13);
                    String barcode = rs8.getString(14);
                    String description = rs8.getString(15);
                    String generic_name = rs8.getString(16);
                    String item_type = rs8.getString(17);
                    String supplier_name = rs8.getString(18);
                    String supplier_id = rs8.getString(19);
                    String serial_no = rs8.getString(20);
                    double product_qty = rs8.getDouble(21);
                    String unit = rs8.getString(22);
                    double conversion = rs8.getDouble(23);
                    double selling_price = rs8.getDouble(24);
                    String date_added = rs8.getString(25);
                    int status = rs8.getInt(26);
                    int is_vatable = rs8.getInt(27);
                    int selling_type = rs8.getInt(28);
                    String discount_name = rs8.getString(29);
                    double discount_rate = rs8.getDouble(30);
                    double discount_amount = rs8.getDouble(31);
                    String discount_customer_name = rs8.getString(32);
                    String discount_customer_id = rs8.getString(33);
                    String branch = rs8.getString(34);
                    String branch_code = rs8.getString(35);
                    String location = rs8.getString(36);
                    String location_id = rs8.getString(37);
                    String category = rs8.getString(38);
                    String category_id = rs8.getString(39);
                    String classification = rs8.getString(40);
                    String classification_id = rs8.getString(41);
                    String sub_classification = rs8.getString(42);
                    String sub_classification_id = rs8.getString(43);
                    String brand = rs8.getString(44);
                    String brand_id = rs8.getString(45);
                    String model = rs8.getString(46);
                    String model_id = rs8.getString(47);
                    double addtl_amount = rs8.getDouble(48);
                    double wtax = rs8.getDouble(49);

                    String transaction_type = "Charge in Adv. [X]";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = FitIn.fmt_woc(product_qty);
                    String out = "";
                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_code;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + ar_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    charge_in_advance_cancelled.add(field);
                }

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Replenishment ">
                String s9 = "select "
                        + "id"
                        + ",inventory_replenishment_no"
                        + ",item_code"
                        + ",barcode"
                        + ",description"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",status"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + " from inventory_replenishment_items"
                        + " " + wheree;

                Statement stmt9 = conn.createStatement();
                ResultSet rs9 = stmt9.executeQuery(s9);
                while (rs9.next()) {
                    int id = rs9.getInt(1);
                    String inventory_replenishment_no = rs9.getString(2);
                    String item_code = rs9.getString(3);
                    String barcode = rs9.getString(4);
                    String description = rs9.getString(5);
                    double product_qty = rs9.getDouble(6);
                    String unit = rs9.getString(7);
                    double conversion = rs9.getDouble(8);
                    double selling_price = rs9.getDouble(9);
                    String date_added = rs9.getString(10);
                    String user_id = rs9.getString(11);
                    String user_screen_name = rs9.getString(12);
                    int status = rs9.getInt(13);
                    String branch = rs9.getString(14);
                    String branch_id = rs9.getString(15);
                    String location = rs9.getString(16);
                    String location_id = rs9.getString(17);

                    String transaction_type = "Replenishment";
                    String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                    String in = "";
                    String out = FitIn.fmt_woc(product_qty);

                    String balance = "";
                    String from_branch = branch;
                    String from_branch_id = branch_id;
                    String from_location = location;
                    String from_location_id = location_id;
                    String to_branch = "";
                    String to_branch_id = "";
                    String to_location = "";
                    String to_location_id = "";
                    String created_by = user_screen_name;
                    Date created = new Date();
                    try {
                        created = servicing.utils.DateType.datetime.parse(date_added);
                    } catch (ParseException ex) {
                        Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String transaction_no = "" + inventory_replenishment_no;
                    String cost1 = "";
                    String price1 = FitIn.fmt_wc_0(selling_price);
                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, user_screen_name, created, transaction_no, cost1, price1, months, "");
                    replenishments.add(field);
                }
                //</editor-fold>

                fields.addAll(inventory_count);
                fields.addAll(sales);
                fields.addAll(receipts);
                fields.addAll(transfers);
                fields.addAll(adjustments);
                fields.addAll(return_exchange);
                fields.addAll(charge_in_advance);
                fields.addAll(charge_in_advance_cancelled);
                fields.addAll(replenishments);

                Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
                             @Override
                             public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
                                 return o1.getDate_added().compareTo(o2.getDate_added());
                             }
                         });

                double qty = 0;
                for (Srpt_item_ledger.field f : fields) {
                    if (f.getFrom_location_id().equalsIgnoreCase("" + location_id2)) {
                        if (FitIn.toDouble(f.getIn()) > 0) {
                            qty += FitIn.toDouble(f.getIn());
                        } else {
                            qty -= FitIn.toDouble(f.getOut());
                        }
                        if (f.getTransaction_type().equalsIgnoreCase("Replenishment")) {
                            qty = 0;
                        }
                    }
                }
                to.setProduct_qty(product_qty2);
                datas.add(to);
            }

            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_capture_where(String where) {
        List<to_inventory_barcodes> datas = new ArrayList();
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
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
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
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
//                String s2 = "select "
//                        + " conversion"
//                        + " from receipt_items where main_barcode='" + main_barcode + "' and location_id='" + location_id + "' "
//                        + " and cost='" + cost + "' order by id desc limit 1"
//                        + " ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    conversion = rs2.getDouble(1);
//                }
//
//                cost = cost / conversion;
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id,
                                                                     sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier,
                                                                     fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id,
                                                                     selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
