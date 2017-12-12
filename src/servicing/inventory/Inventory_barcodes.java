/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;


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
import servicing.branch_locations.Branch_locations;
import servicing.utils.DateType;
import servicing.utils.MyConnection;

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

        public to_inventory_barcodes(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String main_barcode, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String serial_no, String selected_serials, double discount, double discount_amount, String discount_name, String discount_customer_name, String discount_customer_id, double addtl_amount, double wtax) {
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
            List<Branch_locations.to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (Branch_locations.to_branch_locations to : datas) {
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

    public static void edit_inventory_barcodes_2(to_inventory_barcodes to_inventory_barcodes, Inventory.to_inventory old_item) {
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
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
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
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
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
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
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
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
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
                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);
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
                to1 = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0);

            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_inventory_barcodes> datas = ret_data2("");
        System.out.println("aw");
    }

    
}
