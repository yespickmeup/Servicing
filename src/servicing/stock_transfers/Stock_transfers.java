/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.receipts.Stock_transfers_items;
import servicing.receipts.Stock_transfers_items.to_stock_transfers_items;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.utils.MyConnection;

/**
 *
 * @author Guinness
 */
public class Stock_transfers {

    public static class to_stock_transfers implements Serializable {

        public final int id;
        public final String transaction_no;
        public final String user_name;
        public final String date_added;
        public final String remarks;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public int status;
        public boolean selected;
        public final String at_branch;
        public final String at_branch_id;
        public final String at_location;
        public final String at_location_id;
        public final int is_uploaded;
        public final String finalized_by_id;
        public final String finalized_by;

        public to_stock_transfers(int id, String transaction_no, String user_name, String date_added, String remarks, String to_branch, String to_branch_id, String to_location, String to_location_id, String from_branch, String from_branch_id, String from_location, String from_location_id, int status, boolean selected, String at_branch, String at_branch_id, String at_location, String at_location_id, int is_uploaded, String finalized_by_id, String finalized_by) {
            this.id = id;
            this.transaction_no = transaction_no;
            this.user_name = user_name;
            this.date_added = date_added;
            this.remarks = remarks;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.status = status;
            this.selected = selected;
            this.at_branch = at_branch;
            this.at_branch_id = at_branch_id;
            this.at_location = at_location;
            this.at_location_id = at_location_id;
            this.is_uploaded = is_uploaded;
            this.finalized_by_id = finalized_by_id;
            this.finalized_by = finalized_by;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_stock_transfers(to_stock_transfers to_stock_transfers, List<Stock_transfers_items.to_stock_transfers_items> to_stock_transfers_items1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into stock_transfers("
                    + "transaction_no"
                    + ",user_name"
                    + ",date_added"
                    + ",remarks"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",status"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ")values("
                    + ":transaction_no"
                    + ",:user_name"
                    + ",:date_added"
                    + ",:remarks"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:status"
                    + ",:at_branch"
                    + ",:at_branch_id"
                    + ",:at_location"
                    + ",:at_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_stock_transfers.transaction_no)
                    .setString("user_name", to_stock_transfers.user_name)
                    .setString("date_added", to_stock_transfers.date_added)
                    .setString("remarks", to_stock_transfers.remarks)
                    .setString("to_branch", to_stock_transfers.to_branch)
                    .setString("to_branch_id", to_stock_transfers.to_branch_id)
                    .setString("to_location", to_stock_transfers.to_location)
                    .setString("to_location_id", to_stock_transfers.to_location_id)
                    .setString("from_branch", to_stock_transfers.from_branch)
                    .setString("from_branch_id", to_stock_transfers.from_branch_id)
                    .setString("from_location", to_stock_transfers.from_location)
                    .setString("from_location_id", to_stock_transfers.from_location_id)
                    .setNumber("status", to_stock_transfers.status)
                    .setString("at_branch", to_stock_transfers.at_branch)
                    .setString("at_branch_id", to_stock_transfers.at_branch_id)
                    .setString("at_location", to_stock_transfers.at_location)
                    .setString("at_location_id", to_stock_transfers.at_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (to_stock_transfers_items to_stock_transfers_items : to_stock_transfers_items1) {
                String s2 = "insert into stock_transfers_items("
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
                        + ",is_uploaded"
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
                        + ",:is_uploaded"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
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
                        .setString("date_added", to_stock_transfers.date_added)
                        .setString("user_name", to_stock_transfers_items.user_name)
                        .setString("item_type", to_stock_transfers_items.item_type)
                        .setNumber("status", to_stock_transfers.status)
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
                        .setString("stock_transfer_id", to_stock_transfers.transaction_no)
                        .setString("serial_no", to_stock_transfers_items.serial_no)
                        .setString("to_branch", to_stock_transfers.to_branch)
                        .setString("to_branch_id", to_stock_transfers.to_branch_id)
                        .setString("to_location", to_stock_transfers.to_location)
                        .setString("to_location_id", to_stock_transfers.to_location_id)
                        .setString("at_branch", to_stock_transfers_items.at_branch)
                        .setString("at_branch_id", to_stock_transfers_items.at_branch_id)
                        .setString("at_location", to_stock_transfers_items.at_location)
                        .setString("at_location_id", to_stock_transfers_items.at_location_id)
                        .setNumber("is_uploaded", to_stock_transfers.is_uploaded)
                        .ok();
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_transfers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_stock_transfers(to_stock_transfers to_stock_transfers) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "update stock_transfers set "
                    + " transaction_no= :transaction_no "
                    + ",user_name= :user_name "
                    + ",date_added= :date_added "
                    + ",remarks= :remarks "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",status= :status "
                    + ",is_uploaded= :is_uploaded"
                    + " where id='" + to_stock_transfers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("transaction_no", to_stock_transfers.transaction_no)
                    .setString("user_name", to_stock_transfers.user_name)
                    .setString("date_added", to_stock_transfers.date_added)
                    .setString("remarks", to_stock_transfers.remarks)
                    .setString("to_branch", to_stock_transfers.to_branch)
                    .setString("to_branch_id", to_stock_transfers.to_branch_id)
                    .setString("to_location", to_stock_transfers.to_location)
                    .setString("to_location_id", to_stock_transfers.to_location_id)
                    .setString("from_branch", to_stock_transfers.from_branch)
                    .setString("from_branch_id", to_stock_transfers.from_branch_id)
                    .setString("from_location", to_stock_transfers.from_location)
                    .setString("from_location_id", to_stock_transfers.from_location_id)
                    .setNumber("status", to_stock_transfers.status)
                    .setNumber("is_uploaded", 2)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update stock_transfers_items set "
                    + " branch= :branch"
                    + ",branch_code= :branch_code"
                    + ",location= :location"
                    + ",location_id= :location_id"
                    + ",to_branch= :branch"
                    + ",to_branch_id= :to_branch_id"
                    + ",to_location= :to_location"
                    + ",to_location_id= :to_location_id"
                    + ",is_uploaded= :is_uploaded"
                    + " where "
                    + " stock_transfer_id ='" + to_stock_transfers.transaction_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("branch", to_stock_transfers.from_branch)
                    .setString("branch_code", to_stock_transfers.from_branch_id)
                    .setString("location", to_stock_transfers.from_location)
                    .setString("location_id", to_stock_transfers.from_location_id)
                    .setString("to_branch", to_stock_transfers.to_branch)
                    .setString("to_branch_id", to_stock_transfers.to_branch_id)
                    .setString("to_location", to_stock_transfers.to_location)
                    .setString("to_location_id", to_stock_transfers.to_location_id)
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

    public static void edit_stock_transfers2(to_stock_transfers to_stock_transfers) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "update stock_transfers set "
                    + " remarks= :remarks "
                    + " ,date_added= :date_added "
                    + " ,is_uploaded= :is_uploaded "
                    + " where id='" + to_stock_transfers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("remarks", to_stock_transfers.remarks)
                    .setString("date_added", to_stock_transfers.date_added)
                    .setNumber("is_uploaded", 2)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update stock_transfers_items set "
                    + " date_added= :date_added"
                    + " where "
                    + " stock_transfer_id ='" + to_stock_transfers.transaction_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("date_added", to_stock_transfers.date_added)
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

    public static void delete_stock_transfers(to_stock_transfers to_stock_transfers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfers set status=2 where "
                    + " id='" + to_stock_transfers.id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfers.class, "Successfully Deleted");

            String s2 = "update  stock_transfers_items set status=2 where "
                    + " stock_transfer_id ='" + to_stock_transfers.transaction_no + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Stock_transfers_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_stock_transfers2(to_stock_transfers to_stock_transfers, List<Stock_transfers_items.to_stock_transfers_items> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update stock_transfers set status=2 where "
                    + " id='" + to_stock_transfers.id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update stock_transfers_items set status=2 where "
                    + " stock_transfer_id ='" + to_stock_transfers.transaction_no + "' "
                    + " ";
            stmt.addBatch(s2);

            for (Stock_transfers_items.to_stock_transfers_items to : items) {
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to.barcode + "' and location_id='" + to_stock_transfers.to_location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                double conversion2 = 0;
                String serial_no2 = "";
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                    conversion2 = rs11.getDouble(2);
                    serial_no2 = rs11.getString(3);
                }

                double new_qty = product_qty2 - (to.conversion * to.product_qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + to.barcode + "' and location_id='" + to_stock_transfers.to_location_id + "' "
                        + "";

                stmt.addBatch(s4);

//                Inventory_barcodes.to_inventory_barcodes tt1 = Inventory_barcodes.ret_to(to.barcode, to.barcodes, to_stock_transfers.from_location_id);
                String s10 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to.barcode + "' and location_id='" + to_stock_transfers.from_location_id + "'"
                        + " ";
                Statement stmt10 = conn.createStatement();
                ResultSet rs10 = stmt10.executeQuery(s10);
                double product_qty = 0;
                double conversion = 0;
                String serial_no = "";
                while (rs10.next()) {
                    product_qty = rs10.getDouble(1);
                    conversion = rs10.getDouble(2);
                    serial_no = rs10.getString(3);
                }

                double new_qty1 = product_qty + (to.conversion * to.product_qty);
                String s41 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty1 + "' "
                        + " where  main_barcode= '" + to.barcode + "' and location_id='" + to_stock_transfers.from_location_id + "' "
                        + "";

                stmt.addBatch(s41);

            }
            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_transfers_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers> ret_data(String where) {
        List<to_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",user_name"
                    + ",date_added"
                    + ",remarks"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",status"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ",is_uploaded"
                    + ",finalized_by_id"
                    + ",finalized_by"
                    + " from stock_transfers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String user_name = rs.getString(3);
                String date_added = rs.getString(4);
                String remarks = rs.getString(5);
                String to_branch = rs.getString(6);
                String to_branch_id = rs.getString(7);
                String to_location = rs.getString(8);
                String to_location_id = rs.getString(9);
                String from_branch = rs.getString(10);
                String from_branch_id = rs.getString(11);
                String from_location = rs.getString(12);
                String from_location_id = rs.getString(13);
                int status = rs.getInt(14);
                String at_branch = rs.getString(15);
                String at_branch_id = rs.getString(16);
                String at_location = rs.getString(17);
                String at_location_id = rs.getString(18);
                int is_uploaded = rs.getInt(19);
                String finalized_by_id = rs.getString(20);
                String finalized_by = rs.getString(21);
                to_stock_transfers to = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, status, false, at_branch, at_branch_id, at_location, at_location_id, is_uploaded, finalized_by_id, finalized_by);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers> ret_data_cloud(String where) {
        List<to_stock_transfers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",user_name"
                    + ",date_added"
                    + ",remarks"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",status"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ",is_uploaded"
                    + ",finalized_by_id"
                    + ",finalized_by"
                    + " from stock_transfers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String user_name = rs.getString(3);
                String date_added = rs.getString(4);
                String remarks = rs.getString(5);
//                System.out.println("get: " + remarks);
                String to_branch = rs.getString(6);
                String to_branch_id = rs.getString(7);
                String to_location = rs.getString(8);
                String to_location_id = rs.getString(9);
                String from_branch = rs.getString(10);
                String from_branch_id = rs.getString(11);
                String from_location = rs.getString(12);
                String from_location_id = rs.getString(13);
                int status = rs.getInt(14);
                String at_branch = rs.getString(15);
                String at_branch_id = rs.getString(16);
                String at_location = rs.getString(17);
                String at_location_id = rs.getString(18);
                int is_uploaded = rs.getInt(19);
                String finalized_by_id = rs.getString(20);
                String finalized_by = rs.getString(21);
                to_stock_transfers to = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, status, false, at_branch, at_branch_id, at_location, at_location_id, is_uploaded, finalized_by_id, finalized_by);
                datas.add(to);
            }
            conn.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void main(String[] args) {
        System.out.println(increment_id("18"));
    }

    public static String increment_id(String branch_id) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from stock_transfers where at_branch_id='" + branch_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select transaction_no from stock_transfers where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = branch_id + "|0000";
            }
            id = ReceiptIncrementor.increment(id);
            conn.close();
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static List<String> finalize(to_stock_transfers to_stock_transfers, List<Stock_transfers_items.to_stock_transfers_items> datas, String finalized_by_id, String finalized_by) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<String> query = new ArrayList();
//            Gson gson = new Gson();
            System.out.println("Adding record....");

            String s0 = "update stock_transfers set "
                    + " status= :status"
                    + " ,finalized_by_id= :finalized_by_id"
                    + " ,finalized_by= :finalized_by"
                    + " where "
                    + " transaction_no ='" + to_stock_transfers.transaction_no + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .setString("finalized_by_id", finalized_by_id)
                    .setString("finalized_by", finalized_by)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.addBatch(s0);

            String s2 = "update stock_transfers_items set "
                    + " status= :status"
                    + " ,finalized_by_id= :finalized_by_id"
                    + " ,finalized_by= :finalized_by"
                    + " where "
                    + " stock_transfer_id ='" + to_stock_transfers.transaction_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 1)
                    .setString("finalized_by_id", finalized_by_id)
                    .setString("finalized_by", finalized_by)
                    .ok();

            stmt.addBatch(s2);

//          
//          
            for (Stock_transfers_items.to_stock_transfers_items to : datas) {
//                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to.barcode, to.barcodes, to_stock_transfers.to_location_id);
                String s11 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to.barcode + "' and location_id='" + to_stock_transfers.to_location_id + "'"
                        + " ";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                double product_qty2 = 0;
                double conversion2 = 0;
                String serial_no2 = "";
                while (rs11.next()) {
                    product_qty2 = rs11.getDouble(1);
                    conversion2 = rs11.getDouble(2);
                    serial_no2 = rs11.getString(3);
                }

                double new_qty = product_qty2 + (to.conversion * to.product_qty);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "' "
                        + " where main_barcode= '" + to.barcode + "' and location_id='" + to_stock_transfers.to_location_id + "' "
                        + "";
                if (to_stock_transfers.status == 0) {
                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                }

                String s5 = "update inventory set "
                        + " cost= :cost"
                        + " where "
                        + " barcode ='" + to.barcode + "' and location_id='" + to_stock_transfers.to_location_id + "' "
                        + " ";
                s5 = SqlStringUtil.parse(s5).
                        setNumber("cost", to.cost).
                        ok();

                stmt.addBatch(s5);

//                Inventory_barcodes.to_inventory_barcodes tt1 = Inventory_barcodes.ret_to(to.barcode, to.barcodes, to_stock_transfers.from_location_id);
                String s10 = "select "
                        + " product_qty"
                        + ",conversion"
                        + ",serial_no"
                        + " from inventory_barcodes where "
                        + " main_barcode='" + to.barcode + "' and location_id='" + to_stock_transfers.from_location_id + "'"
                        + " ";
                Statement stmt10 = conn.createStatement();
                ResultSet rs10 = stmt10.executeQuery(s10);
                double product_qty = 0;
                double conversion = 0;
                String serial_no = "";
                while (rs10.next()) {
                    product_qty = rs10.getDouble(1);
                    conversion = rs10.getDouble(2);
                    serial_no = rs10.getString(3);
                }

                double new_qty1 = product_qty - (to.conversion * to.product_qty);
                String s41 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty1 + "' "
                        + " where  main_barcode= '" + to.barcode + "' and location_id='" + to_stock_transfers.from_location_id + "' "
                        + "";

                PreparedStatement stmt41 = conn.prepareStatement(s41);
                stmt41.execute();
            }

            stmt.executeBatch();
            conn.commit();

            Lg.s(Stock_transfers.class, "Successfully Updated");

            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_stock_transfers to(String where) {
        to_stock_transfers to = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",user_name"
                    + ",date_added"
                    + ",remarks"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",status"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + ",is_uploaded"
                    + ",finalized_by_id"
                    + ",finalized_by"
                    + " from stock_transfers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String user_name = rs.getString(3);
                String date_added = rs.getString(4);
                String remarks = rs.getString(5);
                String to_branch = rs.getString(6);
                String to_branch_id = rs.getString(7);
                String to_location = rs.getString(8);
                String to_location_id = rs.getString(9);
                String from_branch = rs.getString(10);
                String from_branch_id = rs.getString(11);
                String from_location = rs.getString(12);
                String from_location_id = rs.getString(13);
                int status = rs.getInt(14);
                String at_branch = rs.getString(15);
                String at_branch_id = rs.getString(16);
                String at_location = rs.getString(17);
                String at_location_id = rs.getString(18);
                int is_uploaded = rs.getInt(19);
                String finalized_by_id = rs.getString(20);
                String finalized_by = rs.getString(21);
                to = new to_stock_transfers(id, transaction_no, user_name, date_added, remarks, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, status, false, at_branch, at_branch_id, at_location, at_location_id, is_uploaded, finalized_by_id, finalized_by);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
