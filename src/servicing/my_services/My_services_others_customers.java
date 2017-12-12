/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import servicing.my_services.S1_my_services_others.to_my_services_others;

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
public class My_services_others_customers {

    public static class to_my_services_others_customers {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String transaction_no;
        public final String date_added;
        public String name;
        public double amount;
        public double qty;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_services_others_customers(int id, String customer_id, String customer_name, String transaction_no, String date_added, String name, double amount, double qty, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.transaction_no = transaction_no;
            this.date_added = date_added;
            this.name = name;
            this.amount = amount;
            this.qty = qty;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
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

    public static void add_my_services_others_customers(to_my_services_others_customers to_my_services_others_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_others_customers("
                    + "customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",name"
                    + ",amount"
                    + ",qty"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:transaction_no"
                    + ",:date_added"
                    + ",:name"
                    + ",:amount"
                    + ",:qty"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_my_services_others_customers.customer_id)
                    .setString("customer_name", to_my_services_others_customers.customer_name)
                    .setString("transaction_no", to_my_services_others_customers.transaction_no)
                    .setString("date_added", to_my_services_others_customers.date_added)
                    .setString("name", to_my_services_others_customers.name)
                    .setNumber("amount", to_my_services_others_customers.amount)
                    .setNumber("qty", to_my_services_others_customers.qty)
                    .setString("branch", to_my_services_others_customers.branch)
                    .setString("branch_id", to_my_services_others_customers.branch_id)
                    .setString("location", to_my_services_others_customers.location)
                    .setString("location_id", to_my_services_others_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_others_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_my_services_others_customers(List<to_my_services_others_customers> to_my_services_others_customers1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_my_services_others_customers to_my_services_others_customers : to_my_services_others_customers1) {
                String s0 = "insert into my_services_others_customers("
                        + "customer_id"
                        + ",customer_name"
                        + ",transaction_no"
                        + ",date_added"
                        + ",name"
                        + ",amount"
                        + ",qty"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":customer_id"
                        + ",:customer_name"
                        + ",:transaction_no"
                        + ",:date_added"
                        + ",:name"
                        + ",:amount"
                        + ",:qty"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("customer_id", to_my_services_others_customers.customer_id)
                        .setString("customer_name", to_my_services_others_customers.customer_name)
                        .setString("transaction_no", to_my_services_others_customers.transaction_no)
                        .setString("date_added", to_my_services_others_customers.date_added)
                        .setString("name", to_my_services_others_customers.name)
                        .setNumber("amount", to_my_services_others_customers.amount)
                        .setNumber("qty", to_my_services_others_customers.qty)
                        .setString("branch", to_my_services_others_customers.branch)
                        .setString("branch_id", to_my_services_others_customers.branch_id)
                        .setString("location", to_my_services_others_customers.location)
                        .setString("location_id", to_my_services_others_customers.location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(My_services_others_customers.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_others_customers(to_my_services_others_customers to_my_services_others_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_others_customers set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",transaction_no= :transaction_no"
                    + ",date_added= :date_added"
                    + ",name= :name"
                    + ",amount= :amount"
                    + ",qty= :qty"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where "
                    + " id ='" + to_my_services_others_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_my_services_others_customers.customer_id)
                    .setString("customer_name", to_my_services_others_customers.customer_name)
                    .setString("transaction_no", to_my_services_others_customers.transaction_no)
                    .setString("date_added", to_my_services_others_customers.date_added)
                    .setString("name", to_my_services_others_customers.name)
                    .setNumber("amount", to_my_services_others_customers.amount)
                    .setNumber("qty", to_my_services_others_customers.qty)
                    .setString("branch", to_my_services_others_customers.branch)
                    .setString("branch_id", to_my_services_others_customers.branch_id)
                    .setString("location", to_my_services_others_customers.location)
                    .setString("location_id", to_my_services_others_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_others_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_others_customers(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_others_customers where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_others_customers.class, "Successfully Deleted");
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
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",name"
                    + ",amount"
                    + ",qty"
                    + " from my_services_others_customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String transaction_no = rs.getString(4);
                String date_added = rs.getString(5);
                String name = rs.getString(6);
                double amount = rs.getDouble(7);
                double qty = rs.getDouble(8);

                to_my_services_others to = new to_my_services_others(id, name, amount, qty);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_others_customers> ret_data2(String where) {
        List<to_my_services_others_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",name"
                    + ",amount"
                    + ",qty"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services_others_customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String transaction_no = rs.getString(4);
                String date_added = rs.getString(5);
                String name = rs.getString(6);
                double amount = rs.getDouble(7);
                double qty = rs.getDouble(8);
                String branch = rs.getString(9);
                String branch_id = rs.getString(10);
                String location = rs.getString(11);
                String location_id = rs.getString(12);

                to_my_services_others_customers to = new to_my_services_others_customers(id, customer_id, customer_name, transaction_no, date_added, name, amount, qty, branch, branch_id, location, location_id);
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
