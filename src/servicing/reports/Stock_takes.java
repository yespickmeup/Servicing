/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import servicing.inventory.Inventory_barcodes;
import servicing.utils.MyConnection;
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

/**
 *
 * @author Guinness
 */
public class Stock_takes {

    public static class to_stock_takes {

        public final int id;
        public final String stock_take_no;
        public final String user_id;
        public final String user_screen_name;
        public final String date_added;
        public final String remarks;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_stock_takes(int id, String stock_take_no, String user_id, String user_screen_name, String date_added, String remarks, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.stock_take_no = stock_take_no;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.date_added = date_added;
            this.remarks = remarks;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_stock_takes to_stock_takes, List<Inventory_barcodes.to_inventory_barcodes> items) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into stock_takes("
                    + "stock_take_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":stock_take_no"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:date_added"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("stock_take_no", to_stock_takes.stock_take_no)
                    .setString("user_id", to_stock_takes.user_id)
                    .setString("user_screen_name", to_stock_takes.user_screen_name)
                    .setString("date_added", to_stock_takes.date_added)
                    .setString("remarks", to_stock_takes.remarks)
                    .setNumber("status", to_stock_takes.status)
                    .setString("branch", to_stock_takes.branch)
                    .setString("branch_id", to_stock_takes.branch_id)
                    .setString("location", to_stock_takes.location)
                    .setString("location_id", to_stock_takes.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Inventory_barcodes.to_inventory_barcodes to_stock_take_items : items) {
                String s2 = "insert into stock_take_items("
                        + "stock_take_no"
                        + ",user_id"
                        + ",user_screen_name"
                        + ",date_added"
                        + ",remarks"
                        + ",barcode"
                        + ",description"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_class"
                        + ",sub_class_id"
                        + ",brand"
                        + ",brand_id"
                        + ",model"
                        + ",model_id"
                        + ",conversion"
                        + ",unit"
                        + ",barcodes"
                        + ",main_barcode"
                        + ",qty"
                        + ",cost"
                        + ",selling_price"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":stock_take_no"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:date_added"
                        + ",:remarks"
                        + ",:barcode"
                        + ",:description"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_class"
                        + ",:sub_class_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:conversion"
                        + ",:unit"
                        + ",:barcodes"
                        + ",:main_barcode"
                        + ",:qty"
                        + ",:cost"
                        + ",:selling_price"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("stock_take_no", to_stock_takes.stock_take_no)
                        .setString("user_id", to_stock_takes.user_id)
                        .setString("user_screen_name", to_stock_takes.user_screen_name)
                        .setString("date_added", to_stock_takes.date_added)
                        .setString("remarks", to_stock_takes.remarks)
                        .setString("barcode", to_stock_take_items.barcode)
                        .setString("description", to_stock_take_items.description)
                        .setString("category", to_stock_take_items.category)
                        .setString("category_id", to_stock_take_items.category_id)
                        .setString("classification", to_stock_take_items.classification)
                        .setString("classification_id", to_stock_take_items.classification_id)
                        .setString("sub_class", to_stock_take_items.sub_classification)
                        .setString("sub_class_id", to_stock_take_items.sub_classification_id)
                        .setString("brand", to_stock_take_items.brand)
                        .setString("brand_id", to_stock_take_items.brand_id)
                        .setString("model", to_stock_take_items.model)
                        .setString("model_id", to_stock_take_items.model_id)
                        .setNumber("conversion", to_stock_take_items.conversion)
                        .setString("unit", to_stock_take_items.unit)
                        .setString("barcodes", to_stock_take_items.barcode)
                        .setString("main_barcode", to_stock_take_items.main_barcode)
                        .setNumber("qty", to_stock_take_items.product_qty)
                        .setNumber("cost", to_stock_take_items.cost)
                        .setNumber("selling_price", to_stock_take_items.selling_price)
                        .setString("branch", to_stock_take_items.branch)
                        .setString("branch_id", to_stock_take_items.branch_code)
                        .setString("location", to_stock_take_items.location)
                        .setString("location_id", to_stock_take_items.location_id)
                        .ok();
                stmt.addBatch(s2);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_takes.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_stock_takes to_stock_takes) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_takes  "
                    + " where id='" + to_stock_takes.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_takes.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_takes> ret_data(String where) {
        List<to_stock_takes> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",stock_take_no"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",date_added"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from stock_takes"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String stock_take_no = rs.getString(2);
                String user_id = rs.getString(3);
                String user_screen_name = rs.getString(4);
                String date_added = rs.getString(5);
                String remarks = rs.getString(6);
                int status = rs.getInt(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);

                to_stock_takes to = new to_stock_takes(id, stock_take_no, user_id, user_screen_name, date_added, remarks, status, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String location_id) {
        String id = "0000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from stock_takes where location_id='" + location_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select stock_take_no from stock_takes where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = location_id + "|" + "0000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
