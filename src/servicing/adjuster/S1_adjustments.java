/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.adjuster;

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
public class S1_adjustments {

    public static class to_adjustments {

        public final int id;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double new_qty;
        public final int is_add;
        public final String date_added;
        public final int status;
        public final String user_id;
        public final String user_screen_name;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final String remarks;
        public final String transaction_no;

        public to_adjustments(int id, String item_code, String barcode, String description, double qty, double new_qty, int is_add, String date_added, int status, String user_id, String user_screen_name, String branch, String branch_id, String location, String location_id, String remarks, String transaction_no) {
            this.id = id;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.new_qty = new_qty;
            this.is_add = is_add;
            this.date_added = date_added;
            this.status = status;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.remarks = remarks;
            this.transaction_no = transaction_no;
        }
    }

    public static void add_data(to_adjustments to_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into adjustments("
                    + "item_code"
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
                    + ",remarks"
                    + ",transaction_no"
                    + ")values("
                    + ":item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:new_qty"
                    + ",:is_add"
                    + ",:date_added"
                    + ",:status"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:remarks"
                    + ",:transaction_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_code", to_adjustments.item_code)
                    .setString("barcode", to_adjustments.barcode)
                    .setString("description", to_adjustments.description)
                    .setNumber("qty", to_adjustments.qty)
                    .setNumber("new_qty", to_adjustments.new_qty)
                    .setNumber("is_add", to_adjustments.is_add)
                    .setString("date_added", to_adjustments.date_added)
                    .setNumber("status", to_adjustments.status)
                    .setString("user_id", to_adjustments.user_id)
                    .setString("user_screen_name", to_adjustments.user_screen_name)
                    .setString("branch", to_adjustments.branch)
                    .setString("branch_id", to_adjustments.branch_id)
                    .setString("location", to_adjustments.location)
                    .setString("location_id", to_adjustments.location_id)
                    .setString("remarks", to_adjustments.remarks)
                    .setString("transaction_no", to_adjustments.transaction_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_adjustments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data_cloud(to_adjustments to_adjustments) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into adjustments("
                    + "item_code"
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
                    + ",remarks"
                    + ",transaction_no"
                    + ")values("
                    + ":item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:qty"
                    + ",:new_qty"
                    + ",:is_add"
                    + ",:date_added"
                    + ",:status"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:remarks"
                    + ",:transaction_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_code", to_adjustments.item_code)
                    .setString("barcode", to_adjustments.barcode)
                    .setString("description", to_adjustments.description)
                    .setNumber("qty", to_adjustments.qty)
                    .setNumber("new_qty", to_adjustments.new_qty)
                    .setNumber("is_add", to_adjustments.is_add)
                    .setString("date_added", to_adjustments.date_added)
                    .setNumber("status", to_adjustments.status)
                    .setString("user_id", to_adjustments.user_id)
                    .setString("user_screen_name", to_adjustments.user_screen_name)
                    .setString("branch", to_adjustments.branch)
                    .setString("branch_id", to_adjustments.branch_id)
                    .setString("location", to_adjustments.location)
                    .setString("location_id", to_adjustments.location_id)
                    .setString("remarks", to_adjustments.remarks)
                    .setString("transaction_no", to_adjustments.transaction_no)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update adjustments set is_uploaded=1 where id='" + to_adjustments.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(S1_adjustments.class, "Successfully Added: " + to_adjustments.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_adjustments to_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update adjustments set "
                    + "item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",qty= :qty "
                    + ",new_qty= :new_qty "
                    + ",is_add= :is_add "
                    + ",date_added= :date_added "
                    + ",status= :status "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",remarks= :remarks"
                    + ",transaction_no= :transaction_no"
                    + " where id='" + to_adjustments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("item_code", to_adjustments.item_code)
                    .setString("barcode", to_adjustments.barcode)
                    .setString("description", to_adjustments.description)
                    .setNumber("qty", to_adjustments.qty)
                    .setNumber("new_qty", to_adjustments.new_qty)
                    .setNumber("is_add", to_adjustments.is_add)
                    .setString("date_added", to_adjustments.date_added)
                    .setNumber("status", to_adjustments.status)
                    .setString("user_id", to_adjustments.user_id)
                    .setString("user_screen_name", to_adjustments.user_screen_name)
                    .setString("branch", to_adjustments.branch)
                    .setString("branch_id", to_adjustments.branch_id)
                    .setString("location", to_adjustments.location)
                    .setString("location_id", to_adjustments.location_id)
                    .setString("remarks", to_adjustments.remarks)
                    .setString("transaction_no", to_adjustments.transaction_no)
                    .ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_adjustments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_adjustments to_adjustments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from adjustments  "
                    + " where id='" + to_adjustments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_adjustments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_adjustments> ret_data(String where) {
        List<to_adjustments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
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
                    + ",remarks"
                    + ",transaction_no"
                    + " from adjustments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                double qty = rs.getDouble(5);
                double new_qty = rs.getDouble(6);
                int is_add = rs.getInt(7);
                String date_added = rs.getString(8);
                int status = rs.getInt(9);
                String user_id = rs.getString(10);
                String user_screen_name = rs.getString(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);
                String remarks = rs.getString(16);
                String transaction_no = rs.getString(17);
                to_adjustments to = new to_adjustments(id, item_code, barcode, description, qty, new_qty, is_add, date_added, status,
                        user_id, user_screen_name, branch, branch_id, location, location_id, remarks, transaction_no);
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
