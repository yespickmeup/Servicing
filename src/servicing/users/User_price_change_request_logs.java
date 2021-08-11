/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.users;

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
 * @author Ronescape
 */
public class User_price_change_request_logs {

    public static class to_user_price_change_request_logs {

        public final int id;
        public final String user_id;
        public final String user_name;
        public final String created_at;
        public final String updated_at;
        public final String item_code;
        public final String description;
        public final String old_unit;
        public final String new_unit;
        public final double old_price;
        public final double new_price;
        public final int status;

        public to_user_price_change_request_logs(int id, String user_id, String user_name, String created_at, String updated_at, String item_code, String description, String old_unit, String new_unit, double old_price, double new_price, int status) {
            this.id = id;
            this.user_id = user_id;
            this.user_name = user_name;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.item_code = item_code;
            this.description = description;
            this.old_unit = old_unit;
            this.new_unit = new_unit;
            this.old_price = old_price;
            this.new_price = new_price;
            this.status = status;
        }
    }

    public static void add_data(to_user_price_change_request_logs to_user_price_change_request_logs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into user_price_change_request_logs("
                    + "user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",item_code"
                    + ",description"
                    + ",old_unit"
                    + ",new_unit"
                    + ",old_price"
                    + ",new_price"
                    + ",status"
                    + ")values("
                    + ":user_id"
                    + ",:user_name"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:item_code"
                    + ",:description"
                    + ",:old_unit"
                    + ",:new_unit"
                    + ",:old_price"
                    + ",:new_price"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_user_price_change_request_logs.user_id)
                    .setString("user_name", to_user_price_change_request_logs.user_name)
                    .setString("created_at", to_user_price_change_request_logs.created_at)
                    .setString("updated_at", to_user_price_change_request_logs.updated_at)
                    .setString("item_code", to_user_price_change_request_logs.item_code)
                    .setString("description", to_user_price_change_request_logs.description)
                    .setString("old_unit", to_user_price_change_request_logs.old_unit)
                    .setString("new_unit", to_user_price_change_request_logs.new_unit)
                    .setNumber("old_price", to_user_price_change_request_logs.old_price)
                    .setNumber("new_price", to_user_price_change_request_logs.new_price)
                    .setNumber("status", to_user_price_change_request_logs.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_price_change_request_logs.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_user_price_change_request_logs to_user_price_change_request_logs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update user_price_change_request_logs set "
                    + "user_id= :user_id "
                    + ",user_name= :user_name "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",item_code= :item_code "
                    + ",description= :description "
                    + ",old_unit= :old_unit "
                    + ",new_unit= :new_unit "
                    + ",old_price= :old_price "
                    + ",new_price= :new_price "
                    + ",status= :status "
                    + " where id='" + to_user_price_change_request_logs.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_user_price_change_request_logs.user_id)
                    .setString("user_name", to_user_price_change_request_logs.user_name)
                    .setString("created_at", to_user_price_change_request_logs.created_at)
                    .setString("updated_at", to_user_price_change_request_logs.updated_at)
                    .setString("item_code", to_user_price_change_request_logs.item_code)
                    .setString("description", to_user_price_change_request_logs.description)
                    .setString("old_unit", to_user_price_change_request_logs.old_unit)
                    .setString("new_unit", to_user_price_change_request_logs.new_unit)
                    .setNumber("old_price", to_user_price_change_request_logs.old_price)
                    .setNumber("new_price", to_user_price_change_request_logs.new_price)
                    .setNumber("status", to_user_price_change_request_logs.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_price_change_request_logs.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_user_price_change_request_logs to_user_price_change_request_logs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_price_change_request_logs  "
                    + " where id='" + to_user_price_change_request_logs.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_price_change_request_logs.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_user_price_change_request_logs> ret_data(String where) {
        List<to_user_price_change_request_logs> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",item_code"
                    + ",description"
                    + ",old_unit"
                    + ",new_unit"
                    + ",old_price"
                    + ",new_price"
                    + ",status"
                    + " from user_price_change_request_logs"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String created_at = rs.getString(4);
                String updated_at = rs.getString(5);
                String item_code = rs.getString(6);
                String description = rs.getString(7);
                String old_unit = rs.getString(8);
                String new_unit = rs.getString(9);
                double old_price = rs.getDouble(10);
                double new_price = rs.getDouble(11);
                int status = rs.getInt(12);

                to_user_price_change_request_logs to = new to_user_price_change_request_logs(id, user_id, user_name, created_at, updated_at, item_code, description, old_unit, new_unit, old_price, new_price, status);
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
