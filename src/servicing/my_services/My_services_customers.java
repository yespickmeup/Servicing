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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronald
 */
public class My_services_customers {

    public static class to_my_services_customers {

        public final int id;
        public final String customer_no;
        public final String customer_name;
        public final String address;
        public final String contact_no;
        public final double balance;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_services_customers(int id, String customer_no, String customer_name, String address, String contact_no, double balance, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.customer_no = customer_no;
            this.customer_name = customer_name;
            this.address = address;
            this.contact_no = contact_no;
            this.balance = balance;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_my_services_customers(to_my_services_customers to_my_services_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_customers("
                    + "customer_no"
                    + ",customer_name"
                    + ",address"
                    + ",contact_no"
                    + ",balance"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_no"
                    + ",:customer_name"
                    + ",:address"
                    + ",:contact_no"
                    + ",:balance"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_no", to_my_services_customers.customer_no)
                    .setString("customer_name", to_my_services_customers.customer_name)
                    .setString("address", to_my_services_customers.address)
                    .setString("contact_no", to_my_services_customers.contact_no)
                    .setNumber("balance", to_my_services_customers.balance)
                    .setString("branch", to_my_services_customers.branch)
                    .setString("branch_id", to_my_services_customers.branch_id)
                    .setString("location", to_my_services_customers.location)
                    .setString("location_id", to_my_services_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_customers(to_my_services_customers to_my_services_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_customers set "
                    + "customer_no= :customer_no"
                    + ",customer_name= :customer_name"
                    + ",address= :address"
                    + ",contact_no= :contact_no"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    //                    + ",balance= :balance"
                    + " where "
                    + " id ='" + to_my_services_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_no", to_my_services_customers.customer_no)
                    .setString("customer_name", to_my_services_customers.customer_name)
                    .setString("address", to_my_services_customers.address)
                    .setString("contact_no", to_my_services_customers.contact_no)
                    .setString("branch", to_my_services_customers.branch)
                    .setString("branch_id", to_my_services_customers.branch_id)
                    .setString("location", to_my_services_customers.location)
                    .setString("location_id", to_my_services_customers.location_id)
                    //                    .setNumber("balance", to_my_services_customers.balance)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_customers(to_my_services_customers to_my_services_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_customers where "
                    + " id ='" + to_my_services_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_customers> ret_data(String where) {
        List<to_my_services_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_no"
                    + ",customer_name"
                    + ",address"
                    + ",contact_no"
                    + ",balance"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services_customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_no = rs.getString(2);
                String customer_name = rs.getString(3);
                String address = rs.getString(4);
                String contact_no = rs.getString(5);
                double balance = rs.getDouble(6);
                String branch = rs.getString(7);
                String branch_id = rs.getString(8);
                String location = rs.getString(9);
                String location_id = rs.getString(10);

                to_my_services_customers to = new to_my_services_customers(id, customer_no, customer_name, address, contact_no, balance, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id(String branch_id) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from my_services_customers where branch_id='" + branch_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select customer_no from my_services_customers where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = branch_id + "|" + "00000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static void main(String[] args) {
        System.out.println(increment_id("10"));
    }
}
