/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.inventory.S1_items2;
import servicing.utils.MyConnection;
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

/**
 *
 * @author Maytopacka
 */
public class Stock_transfer_items {

    public static class to_stock_transfers_items {

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
        public final double product_qty;
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
        public final String serial_no;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final String at_branch;
        public final String at_branch_id;
        public final String at_location;
        public final String at_location_id;
        public final int is_uploaded;
        public final String finalized_by_id;
        public final String finalized_by;

        public to_stock_transfers_items(int id, String barcode, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String barcodes, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, String stock_transfer_id, String serial_no, String to_branch, String to_branch_id, String to_location, String to_location_id, String at_branch, String at_branch_id, String at_location, String at_location_id, int is_uploaded, String finalized_by_id, String finalized_by) {
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
            this.is_uploaded = is_uploaded;
            this.finalized_by_id = finalized_by_id;
            this.finalized_by = finalized_by;
        }
    }

    public static class to_receipt_items implements Serializable {

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
        public final double qty;
        public final double cost;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_class;
        public final String sub_class_id;

        public to_receipt_items(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks, String barcode, String description, double qty, double cost, String category, String category_id, String classification, String classification_id, String sub_class, String sub_class_id) {
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
        }
    }

    public static void add_receipt_items(List<Stock_transfer_items.to_receipt_items> to_receipt_items1, String receipt_nos) {
        try {
            Connection conn = MyConnection.connect();
            for (to_receipt_items to_receipt_items : to_receipt_items1) {
                String s0 = "insert into  stock_transfer_items("
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
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Stock_transfer_items.class, "Successfully Added");
                S1_items2.to_items tt = S1_items2.ret_data2(to_receipt_items.barcode);
                double new_qty = tt.product_qty - to_receipt_items.qty;
                String s2 = "update  items set "
                        + "product_qty='" + new_qty + "' "
                        + " where barcode = '" + to_receipt_items.barcode + "'"
                        + "";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  stock_transfer_items set "
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
                    + "where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  stock_transfer_items where "
                    + " id ='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipt_items2(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  stock_transfer_items where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_items.class, "Successfully Deleted");
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
                    + " from  stock_transfer_items where "
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

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers_items> ret_data2(String where) {
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
                    + ",is_uploaded"
                    + ",finalized_by_id"
                    + ",finalized_by"
                    + " from stock_transfers_items"
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
                int is_uploaded = rs.getInt(47);
                String finalized_by_id = rs.getString(48);
                String finalized_by = rs.getString(49);

                to_stock_transfers_items to = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, stock_transfer_id, serial_no, to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id, is_uploaded, finalized_by_id, finalized_by);
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
