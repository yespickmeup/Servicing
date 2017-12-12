/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.utils.MyConnection;

/**
 *
 * @author Guinness
 */
public class Users {

    public static class to_users {

        public final int id;
        public final String user_name;
        public final String user_screen_name;
        public final String password;
        public final int status;
        public final String date_added;

        public to_users(int id, String user_name, String user_screen_name, String password, int status, String date_added) {
            this.id = id;
            this.user_name = user_name;
            this.user_screen_name = user_screen_name;
            this.password = password;
            this.status = status;
            this.date_added = date_added;
        }
    }

    public static void add_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into users("
                    + "user_name"
                    + ",user_screen_name"
                    + ",password"
                    + ",status"
                    + ",date_added"
                    + ")values("
                    + ":user_name"
                    + ",:user_screen_name"
                    + ",:password"
                    + ",:status"
                    + ",:date_added"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_name", to_users.user_name)
                    .setString("user_screen_name", to_users.user_screen_name)
                    .setString("password", to_users.password)
                    .setNumber("status", to_users.status)
                    .setString("date_added", to_users.date_added)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update users set "
                    + "user_name= :user_name "
                    + ",user_screen_name= :user_screen_name "
                    + ",password= :password "
                    + ",status= :status "
                    + ",date_added= :date_added "
                    + " where id='" + to_users.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_name", to_users.user_name)
                    .setString("user_screen_name", to_users.user_screen_name)
                    .setString("password", to_users.password)
                    .setNumber("status", to_users.status)
                    .setString("date_added", to_users.date_added)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from users  "
                    + " where id='" + to_users.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_data(String where) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",user_screen_name"
                    + ",password"
                    + ",status"
                    + ",date_added"
                    + " from users"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String password = rs.getString(4);
                int status = rs.getInt(5);
                String date_added = rs.getString(6);

                to_users to = new to_users(id, user_name, user_screen_name, password, status, date_added);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_users ret_data_autho(String where) {
        to_users to = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_name"
                    + ",screen_name"
                    + ",password"
                    + ",password"
                    + ",date_added"
                    + " from users"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_screen_name = rs.getString(3);
                String password = rs.getString(4);
                String status = rs.getString(5);
                String date_added = rs.getString(6);
                to = new to_users(id, user_name, user_screen_name, password, 1, date_added);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
