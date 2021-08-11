/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.receipts;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.stock_transfers.Stock_transfers;
import servicing.utils.MyConnection;

/**
 *
 * @author Guinness
 */
public class Stock_transfers_items {

    public static class to_stock_transfers_items implements Serializable{

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
        public final String barcodes;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int selling_type;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public final String stock_transfer_id;
        public String serial_no;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final String at_branch;
        public final String at_branch_id;
        public final String at_location;
        public final String at_location_id;

        public to_stock_transfers_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String barcodes, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String stock_transfer_id, String serial_no, String to_branch, String to_branch_id, String to_location, String to_location_id, String at_branch, String at_branch_id, String at_location, String at_location_id) {
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
            this.barcodes = barcodes;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selling_type = selling_type;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.stock_transfer_id = stock_transfer_id;
            this.serial_no = serial_no;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.at_branch = at_branch;
            this.at_branch_id = at_branch_id;
            this.at_location = at_location;
            this.at_location_id = at_location_id;

        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

    }

    public static void add_stock_transfers_items(List<to_stock_transfers_items> to_stock_transfers_items1, String stock_transfer_id, Stock_transfers.to_stock_transfers transfer) {
        try {
            Connection conn = MyConnection.connect();
            for (to_stock_transfers_items to_stock_transfers_items : to_stock_transfers_items1) {
                String s0 = "insert into stock_transfers_items("
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
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
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
                        + ",:barcodes"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:stock_transfer_id"
                        + ",:serial_no"
                        + ",:to_branch"
                        + ",:to_branch_id"
                        + ",:to_location"
                        + ",:to_location_id"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("barcode", to_stock_transfers_items.barcode)
                        .setString("description", to_stock_transfers_items.description)
                        .setString("generic_name", to_stock_transfers_items.generic_name)
                        .setString("category", to_stock_transfers_items.category)
                        .setString("category_id", to_stock_transfers_items.category_id)
                        .setString("classification", to_stock_transfers_items.classification)
                        .setString("classification_id", to_stock_transfers_items.classification_id)
                        .setString("sub_classification", to_stock_transfers_items.sub_classification)
                        .setString("sub_classification_id", to_stock_transfers_items.sub_classification_id)
                        .setNumber("product_qty", to_stock_transfers_items.product_qty)
                        .setString("unit", to_stock_transfers_items.unit)
                        .setNumber("conversion", to_stock_transfers_items.conversion)
                        .setNumber("selling_price", to_stock_transfers_items.selling_price)
                        .setString("date_added", to_stock_transfers_items.date_added)
                        .setString("user_name", to_stock_transfers_items.user_name)
                        .setString("item_type", to_stock_transfers_items.item_type)
                        .setNumber("status", to_stock_transfers_items.status)
                        .setString("supplier", to_stock_transfers_items.supplier)
                        .setNumber("fixed_price", to_stock_transfers_items.fixed_price)
                        .setNumber("cost", to_stock_transfers_items.cost)
                        .setString("supplier_id", to_stock_transfers_items.supplier_id)
                        .setNumber("multi_level_pricing", to_stock_transfers_items.multi_level_pricing)
                        .setNumber("vatable", to_stock_transfers_items.vatable)
                        .setNumber("reorder_level", to_stock_transfers_items.reorder_level)
                        .setNumber("markup", to_stock_transfers_items.markup)
                        .setString("barcodes", to_stock_transfers_items.barcodes)
                        .setString("brand", to_stock_transfers_items.brand)
                        .setString("brand_id", to_stock_transfers_items.brand_id)
                        .setString("model", to_stock_transfers_items.model)
                        .setString("model_id", to_stock_transfers_items.model_id)
                        .setNumber("selling_type", to_stock_transfers_items.selling_type)
                        .setString("branch", to_stock_transfers_items.branch)
                        .setString("branch_code", to_stock_transfers_items.branch_code)
                        .setString("location", to_stock_transfers_items.location)
                        .setString("location_id", to_stock_transfers_items.location_id)
                        .setString("stock_transfer_id", stock_transfer_id)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .setString("to_branch", transfer.to_branch)
                        .setString("to_branch_id", transfer.to_branch_id)
                        .setString("to_location", transfer.to_location)
                        .setString("to_location_id", transfer.to_location_id)
                        .setString("at_branch", to_stock_transfers_items.at_branch)
                        .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                        .setString("at_location", to_stock_transfers_items.at_location)
                        .setString("at_location_id", to_stock_transfers_items.at_location_id)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Stock_transfers_items.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_stock_transfers_items2(List<to_stock_transfers_items> to_stock_transfers_items1, String stock_transfer_id, Stock_transfers.to_stock_transfers transfer) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            String s2 = "update stock_transfers set "
                    + " is_uploaded= :is_uploaded "
                    + " where transaction_no='" + transfer.transaction_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("is_uploaded", 2)
                    .ok();
            stmt.addBatch(s2);
            for (to_stock_transfers_items to_stock_transfers_items : to_stock_transfers_items1) {
                String s0 = "insert into stock_transfers_items("
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
                        + ",at_branch"
                        + ",at_branch_id"
                        + ",at_location"
                        + ",at_location_id"
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
                        + ",:barcodes"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:stock_transfer_id"
                        + ",:serial_no"
                        + ",:to_branch"
                        + ",:to_branch_id"
                        + ",:to_location"
                        + ",:to_location_id"
                        + ",:at_branch"
                        + ",:at_branch_id"
                        + ",:at_location"
                        + ",:at_location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("barcode", to_stock_transfers_items.barcode)
                        .setString("description", to_stock_transfers_items.description)
                        .setString("generic_name", to_stock_transfers_items.generic_name)
                        .setString("category", to_stock_transfers_items.category)
                        .setString("category_id", to_stock_transfers_items.category_id)
                        .setString("classification", to_stock_transfers_items.classification)
                        .setString("classification_id", to_stock_transfers_items.classification_id)
                        .setString("sub_classification", to_stock_transfers_items.sub_classification)
                        .setString("sub_classification_id", to_stock_transfers_items.sub_classification_id)
                        .setNumber("product_qty", to_stock_transfers_items.product_qty)
                        .setString("unit", to_stock_transfers_items.unit)
                        .setNumber("conversion", to_stock_transfers_items.conversion)
                        .setNumber("selling_price", to_stock_transfers_items.selling_price)
                        .setString("date_added", to_stock_transfers_items.date_added)
                        .setString("user_name", to_stock_transfers_items.user_name)
                        .setString("item_type", to_stock_transfers_items.item_type)
                        .setNumber("status", to_stock_transfers_items.status)
                        .setString("supplier", to_stock_transfers_items.supplier)
                        .setNumber("fixed_price", to_stock_transfers_items.fixed_price)
                        .setNumber("cost", to_stock_transfers_items.cost)
                        .setString("supplier_id", to_stock_transfers_items.supplier_id)
                        .setNumber("multi_level_pricing", to_stock_transfers_items.multi_level_pricing)
                        .setNumber("vatable", to_stock_transfers_items.vatable)
                        .setNumber("reorder_level", to_stock_transfers_items.reorder_level)
                        .setNumber("markup", to_stock_transfers_items.markup)
                        .setString("barcodes", to_stock_transfers_items.barcodes)
                        .setString("brand", to_stock_transfers_items.brand)
                        .setString("brand_id", to_stock_transfers_items.brand_id)
                        .setString("model", to_stock_transfers_items.model)
                        .setString("model_id", to_stock_transfers_items.model_id)
                        .setNumber("selling_type", to_stock_transfers_items.selling_type)
                        .setString("branch", to_stock_transfers_items.branch)
                        .setString("branch_code", to_stock_transfers_items.branch_code)
                        .setString("location", to_stock_transfers_items.location)
                        .setString("location_id", to_stock_transfers_items.location_id)
                        .setString("stock_transfer_id", stock_transfer_id)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .setString("to_branch", transfer.to_branch)
                        .setString("to_branch_id", transfer.to_branch_id)
                        .setString("to_location", transfer.to_location)
                        .setString("to_location_id", transfer.to_location_id)
                        .setString("at_branch", to_stock_transfers_items.at_branch)
                        .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                        .setString("at_location", to_stock_transfers_items.at_location)
                        .setString("at_location_id", to_stock_transfers_items.at_location_id)
                        .ok();

                stmt.addBatch(s0);

            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_transfers_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_stock_transfers_items(to_stock_transfers_items to_stock_transfers_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfers_items set "
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
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",branch= :branch"
                    + ",branch_code= :branch_code"
                    + ",location= :location"
                    + ",location_id= :location_id"
                    + ",stock_transfer_id= :stock_transfer_id"
                    + ",serial_no= :serial_no"
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",at_branch= :at_branch "
                    + ",at_branch_id= :at_branch_id "
                    + ",at_location= :at_location "
                    + ",at_location_id= :at_location_id "
                    + " where "
                    + " id ='" + to_stock_transfers_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("barcode", to_stock_transfers_items.barcode)
                    .setString("description", to_stock_transfers_items.description)
                    .setString("generic_name", to_stock_transfers_items.generic_name)
                    .setString("category", to_stock_transfers_items.category)
                    .setString("category_id", to_stock_transfers_items.category_id)
                    .setString("classification", to_stock_transfers_items.classification)
                    .setString("classification_id", to_stock_transfers_items.classification_id)
                    .setString("sub_classification", to_stock_transfers_items.sub_classification)
                    .setString("sub_classification_id", to_stock_transfers_items.sub_classification_id)
                    .setNumber("product_qty", to_stock_transfers_items.product_qty)
                    .setString("unit", to_stock_transfers_items.unit)
                    .setNumber("conversion", to_stock_transfers_items.conversion)
                    .setNumber("selling_price", to_stock_transfers_items.selling_price)
                    .setString("date_added", to_stock_transfers_items.date_added)
                    .setString("user_name", to_stock_transfers_items.user_name)
                    .setString("item_type", to_stock_transfers_items.item_type)
                    .setNumber("status", to_stock_transfers_items.status)
                    .setString("supplier", to_stock_transfers_items.supplier)
                    .setNumber("fixed_price", to_stock_transfers_items.fixed_price)
                    .setNumber("cost", to_stock_transfers_items.cost)
                    .setString("supplier_id", to_stock_transfers_items.supplier_id)
                    .setNumber("multi_level_pricing", to_stock_transfers_items.multi_level_pricing)
                    .setNumber("vatable", to_stock_transfers_items.vatable)
                    .setNumber("reorder_level", to_stock_transfers_items.reorder_level)
                    .setNumber("markup", to_stock_transfers_items.markup)
                    .setString("barcodes", to_stock_transfers_items.barcodes)
                    .setString("brand", to_stock_transfers_items.brand)
                    .setString("brand_id", to_stock_transfers_items.brand_id)
                    .setString("model", to_stock_transfers_items.model)
                    .setString("model_id", to_stock_transfers_items.model_id)
                    .setNumber("selling_type", to_stock_transfers_items.selling_type)
                    .setString("branch", to_stock_transfers_items.branch)
                    .setString("branch_code", to_stock_transfers_items.branch_code)
                    .setString("location", to_stock_transfers_items.location)
                    .setString("location_id", to_stock_transfers_items.location_id)
                    .setString("stock_transfer_id", to_stock_transfers_items.stock_transfer_id)
                    .setString("serial_no", to_stock_transfers_items.serial_no)
                    .setString("to_branch", to_stock_transfers_items.to_branch)
                    .setString("to_branch_id", to_stock_transfers_items.to_branch_id)
                    .setString("to_location", to_stock_transfers_items.to_location)
                    .setString("to_location_id", to_stock_transfers_items.to_location_id)
                    .setString("at_branch", to_stock_transfers_items.at_branch)
                    .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                    .setString("at_location", to_stock_transfers_items.at_location)
                    .setString("at_location_id", to_stock_transfers_items.at_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfers_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_stock_transfers_items(to_stock_transfers_items to_stock_transfers_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_transfers_items where "
                    + " id ='" + to_stock_transfers_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfers_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_stock_transfers_items2(String id, String stock_transfer_no) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from stock_transfers_items where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = "update stock_transfers set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " transaction_no ='" + stock_transfer_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("is_uploaded", 2)
                    .ok();
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_transfers_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers_items> ret_data(String where) {
        List<to_stock_transfers_items> datas = new ArrayList();

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
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + " from stock_transfers_items  "
                    + " " + where;
//            System.out.println(s0);
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

                to_stock_transfers_items to = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification,
                        classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name,
                        item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes,
                        brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, stock_transfer_id, serial_no,
                        to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers_items> ret_data_cloud(String where) {
        List<to_stock_transfers_items> datas = new ArrayList();
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
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + " from stock_transfers_items  "
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

                to_stock_transfers_items to = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification,
                        classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name,
                        item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes,
                        brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, stock_transfer_id, serial_no,
                        to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id);
                datas.add(to);
            }
            conn.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void edit_stock_transfers_items2(String id, double qty, String serial_no, String stock_transfer_no) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement("");

            String s0 = "update stock_transfers_items set "
                    + " product_qty= :product_qty"
                    + ",serial_no= :serial_no"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("product_qty", qty)
                    .setString("serial_no", serial_no)
                    .ok();
            stmt.addBatch(s0);

            String s2 = "update stock_transfers set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " transaction_no ='" + stock_transfer_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("is_uploaded", 2)
                    .ok();
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_transfers_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
