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
public class User_previlege_others {

    public static class to_user_previlege_others {

        public final int id;
        public final String account;
        public final String account_name;
        public final String name;
        public final String user_id;
        public final String user_name;

        public to_user_previlege_others(int id, String account, String account_name, String name, String user_id, String user_name) {
            this.id = id;
            this.account = account;
            this.account_name = account_name;
            this.name = name;
            this.user_id = user_id;
            this.user_name = user_name;
        }
    }

    public static void add_data(to_user_previlege_others to_user_previlege_others) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into user_previlege_others("
                    + "account"
                    + ",account_name"
                    + ",name"
                    + ",user_id"
                    + ",user_name"
                    + ")values("
                    + ":account"
                    + ",:account_name"
                    + ",:name"
                    + ",:user_id"
                    + ",:user_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account", to_user_previlege_others.account)
                    .setString("account_name", to_user_previlege_others.account_name)
                    .setString("name", to_user_previlege_others.name)
                    .setString("user_id", to_user_previlege_others.user_id)
                    .setString("user_name", to_user_previlege_others.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_previlege_others.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_user_previlege_others to_user_previlege_others) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update user_previlege_others set "
                    + "account= :account "
                    + ",account_name= :account_name "
                    + ",name= :name "
                    + ",user_id= :user_id "
                    + ",user_name= :user_name "
                    + " where id='" + to_user_previlege_others.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account", to_user_previlege_others.account)
                    .setString("account_name", to_user_previlege_others.account_name)
                    .setString("name", to_user_previlege_others.name)
                    .setString("user_id", to_user_previlege_others.user_id)
                    .setString("user_name", to_user_previlege_others.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_previlege_others.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_user_previlege_others to_user_previlege_others) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_previlege_others  "
                    + " where id='" + to_user_previlege_others.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_previlege_others.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_user_previlege_others> ret_data(String where) {
        List<to_user_previlege_others> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",account"
                    + ",account_name"
                    + ",name"
                    + ",user_id"
                    + ",user_name"
                    + " from user_previlege_others"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String account_name = rs.getString(3);
                String name = rs.getString(4);
                String user_id = rs.getString(5);
                String user_name = rs.getString(6);

                to_user_previlege_others to = new to_user_previlege_others(id, account, account_name, name, user_id, user_name);
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
