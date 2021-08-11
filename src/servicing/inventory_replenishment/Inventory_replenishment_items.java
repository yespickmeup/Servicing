/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory_replenishment;

import servicing.reports.Srpt_inventory_over_short;
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
 * @author Guinness
 */
public class Inventory_replenishment_items {

    public static class to_inventory_replenishment_items {

        public final int id;
        public final String inventory_replenishment_no;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_inventory_replenishment_items(int id, String inventory_replenishment_no, String item_code, String barcode, String description, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_id, String user_screen_name, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.inventory_replenishment_no = inventory_replenishment_no;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_data(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_replenishment_items("
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

            s0 = SqlStringUtil.parse(s0)
                    .setString("inventory_replenishment_no", to_inventory_replenishment_items.inventory_replenishment_no)
                    .setString("item_code", to_inventory_replenishment_items.item_code)
                    .setString("barcode", to_inventory_replenishment_items.barcode)
                    .setString("description", to_inventory_replenishment_items.description)
                    .setNumber("product_qty", to_inventory_replenishment_items.product_qty)
                    .setString("unit", to_inventory_replenishment_items.unit)
                    .setNumber("conversion", to_inventory_replenishment_items.conversion)
                    .setNumber("selling_price", to_inventory_replenishment_items.selling_price)
                    .setString("date_added", to_inventory_replenishment_items.date_added)
                    .setString("user_id", to_inventory_replenishment_items.user_id)
                    .setString("user_screen_name", to_inventory_replenishment_items.user_screen_name)
                    .setNumber("status", to_inventory_replenishment_items.status)
                    .setString("branch", to_inventory_replenishment_items.branch)
                    .setString("branch_id", to_inventory_replenishment_items.branch_id)
                    .setString("location", to_inventory_replenishment_items.location)
                    .setString("location_id", to_inventory_replenishment_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishment_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into inventory_replenishment_items("
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

            s0 = SqlStringUtil.parse(s0)
                    .setString("inventory_replenishment_no", to_inventory_replenishment_items.inventory_replenishment_no)
                    .setString("item_code", to_inventory_replenishment_items.item_code)
                    .setString("barcode", to_inventory_replenishment_items.barcode)
                    .setString("description", to_inventory_replenishment_items.description)
                    .setNumber("product_qty", to_inventory_replenishment_items.product_qty)
                    .setString("unit", to_inventory_replenishment_items.unit)
                    .setNumber("conversion", to_inventory_replenishment_items.conversion)
                    .setNumber("selling_price", to_inventory_replenishment_items.selling_price)
                    .setString("date_added", to_inventory_replenishment_items.date_added)
                    .setString("user_id", to_inventory_replenishment_items.user_id)
                    .setString("user_screen_name", to_inventory_replenishment_items.user_screen_name)
                    .setNumber("status", to_inventory_replenishment_items.status)
                    .setString("branch", to_inventory_replenishment_items.branch)
                    .setString("branch_id", to_inventory_replenishment_items.branch_id)
                    .setString("location", to_inventory_replenishment_items.location)
                    .setString("location_id", to_inventory_replenishment_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update inventory_replenishment_items set is_uploaded=1 where id='" + to_inventory_replenishment_items.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Inventory_replenishment_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void update_data(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_replenishment_items set "
                    + "inventory_replenishment_no= :inventory_replenishment_no "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",status= :status "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_inventory_replenishment_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("inventory_replenishment_no", to_inventory_replenishment_items.inventory_replenishment_no)
                    .setString("item_code", to_inventory_replenishment_items.item_code)
                    .setString("barcode", to_inventory_replenishment_items.barcode)
                    .setString("description", to_inventory_replenishment_items.description)
                    .setNumber("product_qty", to_inventory_replenishment_items.product_qty)
                    .setString("unit", to_inventory_replenishment_items.unit)
                    .setNumber("conversion", to_inventory_replenishment_items.conversion)
                    .setNumber("selling_price", to_inventory_replenishment_items.selling_price)
                    .setString("date_added", to_inventory_replenishment_items.date_added)
                    .setString("user_id", to_inventory_replenishment_items.user_id)
                    .setString("user_screen_name", to_inventory_replenishment_items.user_screen_name)
                    .setNumber("status", to_inventory_replenishment_items.status)
                    .setString("branch", to_inventory_replenishment_items.branch)
                    .setString("branch_id", to_inventory_replenishment_items.branch_id)
                    .setString("location", to_inventory_replenishment_items.location)
                    .setString("location_id", to_inventory_replenishment_items.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishment_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_replenishment_items  "
                    + " where id='" + to_inventory_replenishment_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishment_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_replenishment_items> ret_data(String where) {
        List<to_inventory_replenishment_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
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
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String inventory_replenishment_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                double product_qty = rs.getDouble(6);
                String unit = rs.getString(7);
                double conversion = rs.getDouble(8);
                double selling_price = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_id = rs.getString(11);
                String user_screen_name = rs.getString(12);
                int status = rs.getInt(13);
                String branch = rs.getString(14);
                String branch_id = rs.getString(15);
                String location = rs.getString(16);
                String location_id = rs.getString(17);

                to_inventory_replenishment_items to = new to_inventory_replenishment_items(id, inventory_replenishment_no, item_code, barcode, description, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, branch, branch_id, location, location_id);
                datas.add(to);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_inventory_over_short.field> ret_data2(String where, String where2) {
        List<Srpt_inventory_over_short.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
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
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String inventory_replenishment_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                double product_qty = rs.getDouble(6);
                String unit = rs.getString(7);
                double conversion = rs.getDouble(8);
                double selling_price = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_id = rs.getString(11);
                String user_screen_name = rs.getString(12);
                int status = rs.getInt(13);
                String branch = rs.getString(14);
                String branch_id = rs.getString(15);
                String location = rs.getString(16);
                String location_id = rs.getString(17);

                String s2 = "select "
                        + " sum(qty)"
                        + ",selling_price"
                        + " from encoding_inventory "
                        + " " + where2 + " and item_code='" + item_code + "'"
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                double qty = 0;
                double price = 0;
                if (rs2.next()) {
                    qty = rs2.getDouble(1);

                }
                
                String s3 = "select "
                        + " selling_price"
                        + " from inventory "
                        + " where  barcode='" + item_code + "'"
                        + " ";
                Statement stmt3 = conn.createStatement();
                
                ResultSet rs3 = stmt3.executeQuery(s3);

                if (rs3.next()) {

                    price = rs3.getDouble(1);
                }

                double system_qty = product_qty;
                double over_short = qty - system_qty;

                if (system_qty != qty) {
                    Srpt_inventory_over_short.field field = new Srpt_inventory_over_short.field(date_added, qty, item_code, barcode, description, "", "", system_qty, over_short, price);
                    datas.add(field);
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Item: " + item_code + " - " + description + " [" + system_qty + " | " + qty + "]");
                }

            }
            System.out.println("Total Added! = " + datas.size());
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
