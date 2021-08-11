/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.receipts;

import servicing.inventory.Inventory;
import servicing.inventory.Inventory_barcodes;
import servicing.inventory.Inventory_barcodes.to_inventory_barcodes;
import servicing.inventory.S1_items2;
import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_receipt_items {

    public static class to_receipt_items {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;
        public final String barcode;
        public final String description;
        public double qty;
        public double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;
        public final double conversion;
        public final String unit;
        public final String date_delivered;
        public final String date_received;
        public final String barcodes;
        public final String serial_no;
        public final String batch_no;
        public final String main_barcode;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int status;
        public final double previous_cost;
        public final String receipt_type_id;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_receipt_items(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier,
                String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category,
                String category_id, String classification, String classification_id, String sub_class, String sub_class_id,
                double conversion, String unit, String date_delivered, String date_received, String barcodes, String serial_no,
                String batch_no, String main_barcode, String brand, String brand_id, String model, String model_id, int status,
                double previous_cost, String receipt_type_id, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_class = sub_class;
            this.sub_class_id = sub_class_id;
            this.conversion = conversion;
            this.unit = unit;
            this.date_delivered = date_delivered;
            this.date_received = date_received;
            this.barcodes = barcodes;
            this.serial_no = serial_no;
            this.batch_no = batch_no;
            this.main_barcode = main_barcode;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.status = status;
            this.previous_cost = previous_cost;
            this.receipt_type_id = receipt_type_id;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

    }

    public static void add_receipt_items(List<to_receipt_items> to_receipt_items1, String receipt_nos) {
        try {
            Connection conn = MyConnection.connect();
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s0 = "insert into  receipt_items("
                        + "receipt_no"
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
                        + ",serial_no"
                        + ",batch_no"
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
                        + ")values("
                        + ":receipt_no"
                        + ",:user_name"
                        + ",:session_no"
                        + ",:date_added"
                        + ",:supplier"
                        + ",:supllier_id"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:qty"
                        + ",:cost"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ",:conversion"
                        + ",:unit"
                        + ",:date_delivered"
                        + ",:date_received"
                        + ",:barcodes"
                        + ",:serial_no"
                        + ",:batch_no"
                        + ",:main_barcode"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:status"
                        + ",:previous_cost"
                        + ",:receipt_type_id"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("receipt_no", receipt_nos).
                        setString("user_name", to_receipt_items.user_name).
                        setString("session_no", to_receipt_items.session_no).
                        setString("date_added", to_receipt_items.date_added).
                        setString("supplier", to_receipt_items.supplier).
                        setString("supllier_id", to_receipt_items.supllier_id).
                        setString("remarks", to_receipt_items.remarks).
                        setString("barcode", to_receipt_items.barcode).
                        setString("description", to_receipt_items.description).
                        setNumber("qty", to_receipt_items.qty).
                        setNumber("cost", to_receipt_items.cost).
                        setString("category", to_receipt_items.category).
                        setString("category_id", to_receipt_items.category_id).
                        setString("classification", to_receipt_items.classification).
                        setString("classification_id", to_receipt_items.classification_id).
                        setString("sub_class", to_receipt_items.sub_class).
                        setString("sub_class_id", to_receipt_items.sub_class_id).
                        setNumber("conversion", to_receipt_items.conversion).
                        setString("unit", to_receipt_items.unit).
                        setString("date_delivered", to_receipt_items.date_delivered).
                        setString("date_received", to_receipt_items.date_received).
                        setString("barcodes", to_receipt_items.barcodes).
                        setString("serial_no", to_receipt_items.serial_no).
                        setString("batch_no", to_receipt_items.batch_no).
                        setString("main_barcode", to_receipt_items.main_barcode).
                        setString("brand", to_receipt_items.brand).
                        setString("brand_id", to_receipt_items.brand_id).
                        setString("model", to_receipt_items.model).
                        setString("model_id", to_receipt_items.model_id).
                        setNumber("status", to_receipt_items.status).
                        setNumber("previous_cost", to_receipt_items.previous_cost).
                        setString("receipt_type_id", to_receipt_items.receipt_type_id).
                        setString("branch", to_receipt_items.branch).
                        setString("branch_id", to_receipt_items.branch_id).
                        setString("location", to_receipt_items.location).
                        setString("location_id", to_receipt_items.location_id).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_receipt_items.class, "Successfully Added");

//                String where2 = " where main_barcode='" + to_receipt_items.main_barcode + "' and barcode='" + to_receipt_items.barcode + "'"
//                        + " and location_id='" + to_receipt_items.location_id + "'";
//                to_inventory_barcodes to = ret_qty(where2);
//
//                double qty = to.product_qty + to_receipt_items.qty;
//
//                String s2 = "update  inventory_barcodes set "
//                        + " product_qty='" + qty + "' "
//                        + " where main_barcode='" + to_receipt_items.main_barcode + "' and barcode='" + to_receipt_items.barcode + "'"
//                        + " and location_id='" + to_receipt_items.location_id + "'";
//                PreparedStatement stmt2 = conn.prepareStatement(s2);
//                stmt2.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_receipt_items_cloud(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);

            String s0 = "insert into  receipt_items("
                    + "receipt_no"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + ")values("
                    + ":receipt_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supllier_id"
                    + ",:remarks"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:cost"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_class"
                    + ",:sub_class_id"
                    + ",:conversion"
                    + ",:unit"
                    + ",:date_delivered"
                    + ",:date_received"
                    + ",:barcodes"
                    + ",:serial_no"
                    + ",:batch_no"
                    + ",:main_barcode"
                    + ",:brand"
                    + ",:brand_id"
                    + ",:model"
                    + ",:model_id"
                    + ",:status"
                    + ",:previous_cost"
                    + ",:receipt_type_id"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_no", to_receipt_items.receipt_no).
                    setString("user_name", to_receipt_items.user_name).
                    setString("session_no", to_receipt_items.session_no).
                    setString("date_added", to_receipt_items.date_added).
                    setString("supplier", to_receipt_items.supplier).
                    setString("supllier_id", to_receipt_items.supllier_id).
                    setString("remarks", to_receipt_items.remarks).
                    setString("barcode", to_receipt_items.barcode).
                    setString("description", to_receipt_items.description).
                    setNumber("qty", to_receipt_items.qty).
                    setNumber("cost", to_receipt_items.cost).
                    setString("category", to_receipt_items.category).
                    setString("category_id", to_receipt_items.category_id).
                    setString("classification", to_receipt_items.classification).
                    setString("classification_id", to_receipt_items.classification_id).
                    setString("sub_class", to_receipt_items.sub_class).
                    setString("sub_class_id", to_receipt_items.sub_class_id).
                    setNumber("conversion", to_receipt_items.conversion).
                    setString("unit", to_receipt_items.unit).
                    setString("date_delivered", to_receipt_items.date_delivered).
                    setString("date_received", to_receipt_items.date_received).
                    setString("barcodes", to_receipt_items.barcodes).
                    setString("serial_no", to_receipt_items.serial_no).
                    setString("batch_no", to_receipt_items.batch_no).
                    setString("main_barcode", to_receipt_items.main_barcode).
                    setString("brand", to_receipt_items.brand).
                    setString("brand_id", to_receipt_items.brand_id).
                    setString("model", to_receipt_items.model).
                    setString("model_id", to_receipt_items.model_id).
                    setNumber("status", to_receipt_items.status).
                    setNumber("previous_cost", to_receipt_items.previous_cost).
                    setString("receipt_type_id", to_receipt_items.receipt_type_id).
                    setString("branch", to_receipt_items.branch).
                    setString("branch_id", to_receipt_items.branch_id).
                    setString("location", to_receipt_items.location).
                    setString("location_id", to_receipt_items.location_id).
                    ok();
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update receipt_items set is_uploaded=1 where id='" + to_receipt_items.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(S1_receipt_items.class, "Successfully Added");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_inventory_barcodes ret_qty(String where) {
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
                    + " from inventory_barcodes  "
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
                int show_to_sales=rs.getInt(40);
//                to1 = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0,allow_negative_inventory,auto_order,show_to_sales);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_receipt_items(to_receipt_items to, double tendered_qty) {
        try {
            Connection conn = MyConnection.connect();
            S1_items2.to_items tt = S1_items2.ret_data2(to.barcode);
            double new_qty = (to.qty) - tendered_qty;
            new_qty = to.conversion * new_qty;
            new_qty = tt.product_qty - new_qty;
            String s2 = "update  items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to.barcode + "'"
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
            String s3 = "update  receipt_items set "
                    + "qty='" + tendered_qty + "' "
                    + " where id = '" + to.id + "'"
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items(to_receipt_items to, double tendered_qty) {
        try {
            Connection conn = MyConnection.connect();
            S1_items2.to_items tt = S1_items2.ret_data2(to.barcode);
            double new_qty = (to.qty) * to.conversion;
//            new_qty = to.conversion * new_qty;
            new_qty = tt.product_qty - new_qty;
            String s2 = "update  items set "
                    + "product_qty='" + new_qty + "' "
                    + " where barcode = '" + to.barcode + "'"
                    + "";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
            String s3 = "delete from  receipt_items "
                    + " where id = '" + to.id + "'"
                    + "";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  receipt_items set "
                    + "receipt_no= '" + to_receipt_items.receipt_no + "'"
                    + ",user_name= '" + to_receipt_items.user_name + "'"
                    + ",session_no= '" + to_receipt_items.session_no + "'"
                    + ",date_added= '" + to_receipt_items.date_added + "'"
                    + ",supplier= '" + to_receipt_items.supplier + "'"
                    + ",supllier_id= '" + to_receipt_items.supllier_id + "'"
                    + ",remarks= '" + to_receipt_items.remarks + "'"
                    + ",barcode= '" + to_receipt_items.barcode + "'"
                    + ",description= '" + to_receipt_items.description + "'"
                    + ",qty= '" + to_receipt_items.qty + "'"
                    + ",cost= '" + to_receipt_items.cost + "'"
                    + ",category= '" + to_receipt_items.category + "'"
                    + ",category_id= '" + to_receipt_items.category_id + "'"
                    + ",classification= '" + to_receipt_items.classification + "'"
                    + ",classification_id= '" + to_receipt_items.classification_id + "'"
                    + ",sub_class= '" + to_receipt_items.sub_class + "'"
                    + ",sub_class_id= '" + to_receipt_items.sub_class_id + "'"
                    + ",unit= '" + to_receipt_items.unit + "'"
                    + ",previous_cost= '" + to_receipt_items.previous_cost + "'"
                    + " where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  receipt_items where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipt_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items4(String receipt_no) {
        try {
            Connection conn = MyConnection.connect();

//            Lg.s(Receipts.class, "Successfully Deleted");

            String s2 = "delete from  receipt_items where "
                    + " id ='" + receipt_no + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_receipt_items.class, "Successfully Deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items2(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  receipt_items where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipt_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data(String search) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + " from  receipt_items where "
                    + " receipt_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String serial_no = rs.getString(24);
                String batch_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id,
                                                           remarks, barcode, description, qty, cost, category, category_id, classification, classification_id,
                                                           sub_class, sub_class_id, conversion, unit, date_delivered, date_received, barcodes, serial_no, batch_no,
                                                           main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id, location,
                                                           location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data2(String barcodes1, String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + " from  receipt_items where "
                    + " barcode ='" + barcodes1 + "' "
                    + " and date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String serial_no = rs.getString(24);
                String batch_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id,
                                                           remarks, barcode, description, qty, cost, category, category_id, classification, classification_id,
                                                           sub_class, sub_class_id, conversion, unit, date_delivered, date_received, barcodes, serial_no,
                                                           batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id,
                                                           location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data2_supplier(String barcodes1, String date_from, String date_to, String supplier1) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + " from  receipt_items where "
                    + " barcode ='" + barcodes1 + "' and date(date_added) between '" + date_from + "' and '" + date_to + "' and supplier like '%" + supplier1 + "%' "
                    + " or description like '%" + barcodes1 + "%' and date(date_added) between '" + date_from + "' and '" + date_to + "' and supplier like '%" + supplier1 + "%' "
                    + " "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String serial_no = rs.getString(24);
                String batch_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id,
                                                           remarks, barcode, description, qty, cost, category, category_id, classification, classification_id,
                                                           sub_class, sub_class_id, conversion, unit, date_delivered, date_received, barcodes, serial_no,
                                                           batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id,
                                                           location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void finalize_receipt_items(List<to_receipt_items> to_receipt_items1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s0 = "update receipt_items set "
                        + "qty= :qty"
                        + ",cost= :cost"
                        + ",status= :status"
                        + " where "
                        + " id ='" + to_receipt_items.id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0).
                        setNumber("qty", to_receipt_items.qty).
                        setNumber("cost", to_receipt_items.cost).
                        setNumber("status", 1).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                if (to_receipt_items.status == 0) {
                    stmt.execute();
                    Lg.s(S1_receipt_items.class, "Successfully Updated");
                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_receipt_items.main_barcode, to_receipt_items.barcode, to_receipt_items.location_id);

                    double new_qty = tt.product_qty + (to_receipt_items.conversion * to_receipt_items.qty);
                    String s2 = "update inventory_barcodes set "
                            + " product_qty='" + new_qty + "',cost='" + to_receipt_items.cost + "' "
                            + " where barcode = '" + to_receipt_items.barcode + "' and main_barcode= '" + to_receipt_items.main_barcode + "'"
                            + "";
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();

                    String s3 = "update inventory set "
                            + " cost= :cost"
                            + " where "
                            + " barcode ='" + to_receipt_items.main_barcode + "' "
                            + " ";
                    s3 = SqlStringUtil.parse(s3).
                            setNumber("cost", to_receipt_items.cost).
                            ok();

                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();
                    Lg.s(Inventory.class, "Successfully Updated");
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data4(String search, String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + " from  receipt_items where "
                    + " main_barcode ='" + search + "'"
                    + " and date(date_delivered) between '" + date_from + "' and '" + date_to + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String serial_no = rs.getString(24);
                String batch_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id,
                                                           remarks, barcode, description, qty, cost, category, category_id, classification, classification_id,
                                                           sub_class, sub_class_id, conversion, unit, date_delivered, date_received, barcodes, serial_no, batch_no,
                                                           main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data_ledger(String main_barcode1, String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + " from  receipt_items where "
                    + " main_barcode = '" + main_barcode1 + "'"
                    //                    + " and date(date_added) between '" + date_from + "' and '" + date_to + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String serial_no = rs.getString(24);
                String batch_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id,
                                                           remarks, barcode, description, qty, cost, category, category_id, classification, classification_id,
                                                           sub_class, sub_class_id, conversion, unit, date_delivered, date_received, barcodes, serial_no,
                                                           batch_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id, location, location_id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_data5(String where) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
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
                    + ",serial_no"
                    + ",batch_no"
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
                    + " from  receipt_items  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String serial_no = rs.getString(24);
                String batch_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id,
                                                           remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class,
                                                           sub_class_id, conversion, unit, date_delivered, date_received, barcodes, serial_no, batch_no, main_barcode,
                                                           brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipt_items2(String id, double qty, double cost, String serial_no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update receipt_items set "
                    + "qty= :qty"
                    + ",cost= :cost"
                    + ",serial_no= :serial_no"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("qty", qty)
                    .setNumber("cost", cost)
                    .setString("serial_no", serial_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_receipt_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
