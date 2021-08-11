/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory_replenishment;

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
public class Inventory_replenishments {

    public static class to_inventory_replenishments {

        public final int id;
        public final String inventory_replenishment_no;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final String remarks;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_inventory_replenishments(int id, String inventory_replenishment_no, String date_added, String user_id, String user_screen_name, String remarks, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.inventory_replenishment_no = inventory_replenishment_no;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.remarks = remarks;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_inventory_replenishments to_inventory_replenishments, List<Inventory_barcodes.to_inventory_barcodes> datas,String location_id) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into inventory_replenishments("
                    + "inventory_replenishment_no"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":inventory_replenishment_no"
                    + ",:date_added"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                    .setString("date_added", to_inventory_replenishments.date_added)
                    .setString("user_id", to_inventory_replenishments.user_id)
                    .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                    .setString("remarks", to_inventory_replenishments.remarks)
                    .setNumber("status", to_inventory_replenishments.status)
                    .setString("branch", to_inventory_replenishments.branch)
                    .setString("branch_id", to_inventory_replenishments.branch_id)
                    .setString("location", to_inventory_replenishments.location)
                    .setString("location_id", to_inventory_replenishments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Inventory_barcodes.to_inventory_barcodes to_inventory_replenishment_items : datas) {

                String s2 = "insert into inventory_replenishment_items("
                        + "inventory_replenishment_no"
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
                        + ")values("
                        + ":inventory_replenishment_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                double qty = to_inventory_replenishment_items.product_qty;
                if (qty == 0) {
                    qty = 0;
                } else if (qty > 0) {

                } else {

                }
                s2 = SqlStringUtil.parse(s2)
                        .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                        .setString("item_code", to_inventory_replenishment_items.main_barcode)
                        .setString("barcode", to_inventory_replenishment_items.barcode)
                        .setString("description", to_inventory_replenishment_items.description)
                        .setNumber("product_qty", qty)
                        .setString("unit", to_inventory_replenishment_items.unit)
                        .setNumber("conversion", to_inventory_replenishment_items.conversion)
                        .setNumber("selling_price", to_inventory_replenishment_items.selling_price)
                        .setString("date_added", to_inventory_replenishments.date_added)
                        .setString("user_id", to_inventory_replenishments.user_id)
                        .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                        .setNumber("status", 1)
                        .setString("branch", to_inventory_replenishment_items.branch)
                        .setString("branch_id", to_inventory_replenishment_items.branch_code)
                        .setString("location", to_inventory_replenishment_items.location)
                        .setString("location_id", to_inventory_replenishment_items.location_id)
                        .ok();

                stmt.addBatch(s2);

            }
            String s4 = "update inventory_barcodes set "
                    + " product_qty='" + 0 + "'"
                    + " where   location_id='" + location_id + "' "
                    + "";

            stmt.addBatch(s4);
            stmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_inventory_replenishments to_inventory_replenishments) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into inventory_replenishments("
                    + "inventory_replenishment_no"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":inventory_replenishment_no"
                    + ",:date_added"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:remarks"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                    .setString("date_added", to_inventory_replenishments.date_added)
                    .setString("user_id", to_inventory_replenishments.user_id)
                    .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                    .setString("remarks", to_inventory_replenishments.remarks)
                    .setNumber("status", to_inventory_replenishments.status)
                    .setString("branch", to_inventory_replenishments.branch)
                    .setString("branch_id", to_inventory_replenishments.branch_id)
                    .setString("location", to_inventory_replenishments.location)
                    .setString("location_id", to_inventory_replenishments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update inventory_replenishments set is_uploaded=1 where id='" + to_inventory_replenishments.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Inventory_replenishments.class, "Successfully Added: " + to_inventory_replenishments.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_data(to_inventory_replenishments to_inventory_replenishments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_replenishments set "
                    + "inventory_replenishment_no= :inventory_replenishment_no "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_inventory_replenishments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("inventory_replenishment_no", to_inventory_replenishments.inventory_replenishment_no)
                    .setString("date_added", to_inventory_replenishments.date_added)
                    .setString("user_id", to_inventory_replenishments.user_id)
                    .setString("user_screen_name", to_inventory_replenishments.user_screen_name)
                    .setString("remarks", to_inventory_replenishments.remarks)
                    .setNumber("status", to_inventory_replenishments.status)
                    .setString("branch", to_inventory_replenishments.branch)
                    .setString("branch_id", to_inventory_replenishments.branch_id)
                    .setString("location", to_inventory_replenishments.location)
                    .setString("location_id", to_inventory_replenishments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_inventory_replenishments to_inventory_replenishments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_replenishments  "
                    + " where id='" + to_inventory_replenishments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_replenishments> ret_data(String where) {
        List<to_inventory_replenishments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",inventory_replenishment_no"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",remarks"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from inventory_replenishments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String inventory_replenishment_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_id = rs.getString(4);
                String user_screen_name = rs.getString(5);
                String remarks = rs.getString(6);
                int status = rs.getInt(7);
                String branch = rs.getString(8);
                String branch_id = rs.getString(9);
                String location = rs.getString(10);
                String location_id = rs.getString(11);

                to_inventory_replenishments to = new to_inventory_replenishments(id, inventory_replenishment_no, date_added, user_id, user_screen_name, remarks, status, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(increment_id("9"));
    }

    public static String increment_id(String location_id) {

        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from inventory_replenishments where location_id='" + location_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select inventory_replenishment_no from inventory_replenishments where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = location_id + "|000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void rollback(to_inventory_replenishments to_inventory_replenishments, List<Inventory_replenishment_items.to_inventory_replenishment_items> datas) {

        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update inventory_replenishments set "
                    + " status= :status "
                    + " where id='" + to_inventory_replenishments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 0)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "update inventory_replenishment_items set "
                    + " status= :status "
                    + " where inventory_replenishment_no='" + to_inventory_replenishments.inventory_replenishment_no + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 0)
                    .ok();

            stmt.addBatch(s2);

            for (Inventory_replenishment_items.to_inventory_replenishment_items to_inventory_replenishment_items : datas) {
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + to_inventory_replenishment_items.product_qty + "'"
                        + " where  main_barcode= '" + to_inventory_replenishment_items.item_code + "' and location_id='" + to_inventory_replenishment_items.location_id + "' "
                        + "";
                stmt.addBatch(s4);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_replenishments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
