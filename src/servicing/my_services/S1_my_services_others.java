/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;


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
public class S1_my_services_others {

    public static class to_my_services_others {

        public final int id;
        public String name;
        public double amount;
        public double qty;

        public to_my_services_others(int id, String name, double amount, double qty) {
            this.id = id;
            this.name = name;
            this.amount = amount;
            this.qty = qty;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

    }

    public static void add_my_services_others(to_my_services_others to_my_services_others) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_others("
                    + "name"
                    + ",amount"
                    + ")values("
                    + ":name"
                    + ",:amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_my_services_others.name)
                    .setNumber("amount", to_my_services_others.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_others.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_others(to_my_services_others to_my_services_others) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_others set "
                    + "name= :name"
                    + ",amount= :amount"
                    + " where "
                    + " id ='" + to_my_services_others.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_my_services_others.name)
                    .setNumber("amount", to_my_services_others.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_others.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_others(to_my_services_others to_my_services_others) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_others where "
                    + " id ='" + to_my_services_others.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_others.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_others> ret_data(String where) {
        List<to_my_services_others> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",amount"
                    + " from my_services_others  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double amount = rs.getDouble(3);

                to_my_services_others to = new to_my_services_others(id, name, amount, 0);
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
