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
public class My_services_problems_customers {

    public static class to_my_services_problems_customers {

        public final int id;
        public  String problem;
        public final String customer_id;
        public final String customer_name;
        public final String transaction_no;
        public final String date_added;
        public  double amount;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_services_problems_customers(int id, String problem, String customer_id, String customer_name, String transaction_no, String date_added, double amount, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.problem = problem;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.transaction_no = transaction_no;
            this.date_added = date_added;
            this.amount = amount;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
        
    }

    public static void add_my_services_problems_customers(to_my_services_problems_customers to_my_services_problems_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_problems_customers("
                    + "problem"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",amount"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":problem"
                    + ",:customer_id"
                    + ",:customer_name"
                    + ",:transaction_no"
                    + ",:date_added"
                    + ",:amount"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("problem", to_my_services_problems_customers.problem)
                    .setString("customer_id", to_my_services_problems_customers.customer_id)
                    .setString("customer_name", to_my_services_problems_customers.customer_name)
                    .setString("transaction_no", to_my_services_problems_customers.transaction_no)
                    .setString("date_added", to_my_services_problems_customers.date_added)
                    .setNumber("amount", to_my_services_problems_customers.amount)
                    .setString("branch", to_my_services_problems_customers.branch)
                    .setString("branch_id", to_my_services_problems_customers.branch_id)
                    .setString("location", to_my_services_problems_customers.location)
                    .setString("location_id", to_my_services_problems_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_problems_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_my_services_problems_customers(List<to_my_services_problems_customers> to_my_services_problems_customers1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_my_services_problems_customers to_my_services_problems_customers : to_my_services_problems_customers1) {
                String s0 = "insert into my_services_problems_customers("
                        + "problem"
                        + ",customer_id"
                        + ",customer_name"
                        + ",transaction_no"
                        + ",date_added"
                        + ",amount"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":problem"
                        + ",:customer_id"
                        + ",:customer_name"
                        + ",:transaction_no"
                        + ",:date_added"
                        + ",:amount"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("problem", to_my_services_problems_customers.problem)
                        .setString("customer_id", to_my_services_problems_customers.customer_id)
                        .setString("customer_name", to_my_services_problems_customers.customer_name)
                        .setString("transaction_no", to_my_services_problems_customers.transaction_no)
                        .setString("date_added", to_my_services_problems_customers.date_added)
                        .setNumber("amount", to_my_services_problems_customers.amount)
                        .setString("branch", to_my_services_problems_customers.branch)
                        .setString("branch_id", to_my_services_problems_customers.branch_id)
                        .setString("location", to_my_services_problems_customers.location)
                        .setString("location_id", to_my_services_problems_customers.location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(My_services_problems_customers.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_problems_customers(to_my_services_problems_customers to_my_services_problems_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_problems_customers set "
                    + "problem= :problem"
                    + ",customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",transaction_no= :transaction_no"
                    + ",date_added= :date_added"
                    + ",amount= :amount"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where "
                    + " id ='" + to_my_services_problems_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("problem", to_my_services_problems_customers.problem)
                    .setString("customer_id", to_my_services_problems_customers.customer_id)
                    .setString("customer_name", to_my_services_problems_customers.customer_name)
                    .setString("transaction_no", to_my_services_problems_customers.transaction_no)
                    .setString("date_added", to_my_services_problems_customers.date_added)
                    .setNumber("amount", to_my_services_problems_customers.amount)
                    .setString("branch", to_my_services_problems_customers.branch)
                    .setString("branch_id", to_my_services_problems_customers.branch_id)
                    .setString("location", to_my_services_problems_customers.location)
                    .setString("location_id", to_my_services_problems_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_problems_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_problems_customers(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_problems_customers where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_problems_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<My_services_problems_customers.to_my_services_problems_customers> ret_data(String where) {
        List<My_services_problems_customers.to_my_services_problems_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",problem"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",amount"
                    + " from my_services_problems_customers  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String problem = rs.getString(2);
                String customer_id = rs.getString(3);
                String customer_name = rs.getString(4);
                String transaction_no = rs.getString(5);
                String date_added = rs.getString(6);
                double amount = rs.getDouble(7);
                My_services_problems_customers.to_my_services_problems_customers to = new to_my_services_problems_customers(id, problem, customer_id, customer_name, transaction_no, date_added, amount, problem, customer_id, problem, transaction_no);
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
