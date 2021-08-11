/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

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
public class Stock_transfer_privileges {

    public static class to_stock_transfer_privileges {

        public final int id;
        public final String user_id;
        public final String user_screen_name;
        public final String from_branch;
        public final String from_branch_id;
        public final String from_location;
        public final String from_location_id;
        public final String to_branch;
        public final String to_branch_id;
        public final String to_location;
        public final String to_location_id;
        public final int add_transfer;
        public final int edit_transfer;
        public final int delete_transfer;
        public final int finalize_transfer;
        public final int report_transfer;
        public to_stock_transfer_privileges(int id, String user_id, String user_screen_name, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id, int add_transfer, int edit_transfer, int delete_transfer, int finalize_transfer,int report_transfer) {
            this.id = id;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.add_transfer = add_transfer;
            this.edit_transfer = edit_transfer;
            this.delete_transfer = delete_transfer;
            this.finalize_transfer = finalize_transfer;
            this.report_transfer=report_transfer;
        }
    }

    public static void add_data(to_stock_transfer_privileges to_stock_transfer_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into stock_transfer_privileges("
                    + "user_id"
                    + ",user_screen_name"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",add_transfer"
                    + ",edit_transfer"
                    + ",delete_transfer"
                    + ",finalize_transfer"
                    + ",report_transfer"
                    + ")values("
                    + ":user_id"
                    + ",:user_screen_name"
                    + ",:from_branch"
                    + ",:from_branch_id"
                    + ",:from_location"
                    + ",:from_location_id"
                    + ",:to_branch"
                    + ",:to_branch_id"
                    + ",:to_location"
                    + ",:to_location_id"
                    + ",:add_transfer"
                    + ",:edit_transfer"
                    + ",:delete_transfer"
                    + ",:finalize_transfer"
                    + ",:report_transfer"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_stock_transfer_privileges.user_id)
                    .setString("user_screen_name", to_stock_transfer_privileges.user_screen_name)
                    .setString("from_branch", to_stock_transfer_privileges.from_branch)
                    .setString("from_branch_id", to_stock_transfer_privileges.from_branch_id)
                    .setString("from_location", to_stock_transfer_privileges.from_location)
                    .setString("from_location_id", to_stock_transfer_privileges.from_location_id)
                    .setString("to_branch", to_stock_transfer_privileges.to_branch)
                    .setString("to_branch_id", to_stock_transfer_privileges.to_branch_id)
                    .setString("to_location", to_stock_transfer_privileges.to_location)
                    .setString("to_location_id", to_stock_transfer_privileges.to_location_id)
                    .setNumber("add_transfer", to_stock_transfer_privileges.add_transfer)
                    .setNumber("edit_transfer", to_stock_transfer_privileges.edit_transfer)
                    .setNumber("delete_transfer", to_stock_transfer_privileges.delete_transfer)
                    .setNumber("finalize_transfer", to_stock_transfer_privileges.finalize_transfer)
                    .setNumber("report_transfer",to_stock_transfer_privileges.report_transfer)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_privileges.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_stock_transfer_privileges to_stock_transfer_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfer_privileges set "
                    + "user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",from_branch= :from_branch "
                    + ",from_branch_id= :from_branch_id "
                    + ",from_location= :from_location "
                    + ",from_location_id= :from_location_id "
                    + ",to_branch= :to_branch "
                    + ",to_branch_id= :to_branch_id "
                    + ",to_location= :to_location "
                    + ",to_location_id= :to_location_id "
                    + ",add_transfer= :add_transfer "
                    + ",edit_transfer= :edit_transfer "
                    + ",delete_transfer= :delete_transfer "
                    + ",finalize_transfer= :finalize_transfer "
                    + ",report_transfer= :report_transfer"
                    + " where id='" + to_stock_transfer_privileges.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_stock_transfer_privileges.user_id)
                    .setString("user_screen_name", to_stock_transfer_privileges.user_screen_name)
                    .setString("from_branch", to_stock_transfer_privileges.from_branch)
                    .setString("from_branch_id", to_stock_transfer_privileges.from_branch_id)
                    .setString("from_location", to_stock_transfer_privileges.from_location)
                    .setString("from_location_id", to_stock_transfer_privileges.from_location_id)
                    .setString("to_branch", to_stock_transfer_privileges.to_branch)
                    .setString("to_branch_id", to_stock_transfer_privileges.to_branch_id)
                    .setString("to_location", to_stock_transfer_privileges.to_location)
                    .setString("to_location_id", to_stock_transfer_privileges.to_location_id)
                    .setNumber("add_transfer", to_stock_transfer_privileges.add_transfer)
                    .setNumber("edit_transfer", to_stock_transfer_privileges.edit_transfer)
                    .setNumber("delete_transfer", to_stock_transfer_privileges.delete_transfer)
                    .setNumber("finalize_transfer", to_stock_transfer_privileges.finalize_transfer)
                    .setNumber("report_transfer",to_stock_transfer_privileges.report_transfer)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_privileges.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_stock_transfer_privileges to_stock_transfer_privileges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_transfer_privileges  "
                    + " where id='" + to_stock_transfer_privileges.id + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_transfer_privileges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfer_privileges> ret_data(String where) {
        List<to_stock_transfer_privileges> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",add_transfer"
                    + ",edit_transfer"
                    + ",delete_transfer"
                    + ",finalize_transfer"
                    + ",report_transfer"
                    + " from stock_transfer_privileges"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String from_branch = rs.getString(4);
                String from_branch_id = rs.getString(5);
                String from_location = rs.getString(6);
                String from_location_id = rs.getString(7);
                String to_branch = rs.getString(8);
                String to_branch_id = rs.getString(9);
                String to_location = rs.getString(10);
                String to_location_id = rs.getString(11);
                int add_transfer = rs.getInt(12);
                int edit_transfer = rs.getInt(13);
                int delete_transfer = rs.getInt(14);
                int finalize_transfer = rs.getInt(15);
                int report_transfer=rs.getInt(16);
                to_stock_transfer_privileges to = new to_stock_transfer_privileges(id, user_id, user_screen_name, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, add_transfer, edit_transfer, delete_transfer, finalize_transfer,report_transfer);
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
