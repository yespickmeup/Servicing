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
 * @author Ronald
 */
public class User_default_previleges {

    public static class to_user_default_previleges {

        public final int id;
        public final String account;
        public final String name;

        public to_user_default_previleges(int id, String account, String name) {
            this.id = id;
            this.account = account;
            this.name = name;
        }
    }

    public static void add_user_default_previleges(to_user_default_previleges to_user_default_previleges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into user_default_previleges("
                    + "account"
                    + ",name"
                    + ")values("
                    + ":account"
                    + ",:name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account", to_user_default_previleges.account)
                    .setString("name", to_user_default_previleges.name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_default_previleges.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_user_default_previleges(to_user_default_previleges to_user_default_previleges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update user_default_previleges set "
                    + "account= :account"
                    + ",name= :name"
                    + " where "
                    + " id ='" + to_user_default_previleges.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account", to_user_default_previleges.account)
                    .setString("name", to_user_default_previleges.name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_default_previleges.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_user_default_previleges(to_user_default_previleges to_user_default_previleges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_default_previleges where "
                    + " id ='" + to_user_default_previleges.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_default_previleges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_user_default_previleges> ret_data(String where) {
        List<to_user_default_previleges> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",account"
                    + ",name"
                    + " from user_default_previleges  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String name = rs.getString(3);

                to_user_default_previleges to = new to_user_default_previleges(id, account, name);
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
