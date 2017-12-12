/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import servicing.my_services.My_services.to_my_services;

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
public class My_services_description_customers {

    public static class to_my_services_description_customers {

        public final int id;
        public String description;
        public double amount;
        public final String customer_id;
        public final String customer_name;
        public final String transaction_no;
        public final String date_added;
        public final String user_name;
        public String unit;
        public  String barcode;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        
        public to_my_services_description_customers(int id, String description, double amount, String customer_id, String customer_name, String transaction_no, String date_added, String user_name, String unit, String barcode, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.description = description;
            this.amount = amount;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.transaction_no = transaction_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.unit = unit;
            this.barcode = barcode;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }
        
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
        
    }

    public static void add_my_services_description_customers(to_my_services_description_customers to_my_services_description_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_description_customers("
                    + "description"
                    + ",amount"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",user_name"
                    + ",unit"
                    + ",barcode"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":description"
                    + ",:amount"
                    + ",:customer_id"
                    + ",:customer_name"
                    + ",:transaction_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:unit"
                    + ",:barcode"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_my_services_description_customers.description)
                    .setNumber("amount", to_my_services_description_customers.amount)
                    .setString("customer_id", to_my_services_description_customers.customer_id)
                    .setString("customer_name", to_my_services_description_customers.customer_name)
                    .setString("transaction_no", to_my_services_description_customers.transaction_no)
                    .setString("date_added", to_my_services_description_customers.date_added)
                    .setString("user_name", to_my_services_description_customers.user_name)
                    .setString("unit", to_my_services_description_customers.unit)
                    .setString("barcode", to_my_services_description_customers.barcode)
                    .setString("branch", to_my_services_description_customers.branch)
                    .setString("branch_id", to_my_services_description_customers.branch_id)
                    .setString("location", to_my_services_description_customers.location)
                    .setString("location_id", to_my_services_description_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_description_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_my_services_description_customers(List<to_my_services_description_customers> to_my_services_description_customers1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_my_services_description_customers to_my_services_description_customers : to_my_services_description_customers1) {
                String s0 = "insert into my_services_description_customers("
                        + "description"
                        + ",amount"
                        + ",customer_id"
                        + ",customer_name"
                        + ",transaction_no"
                        + ",date_added"
                        + ",user_name"
                        + ",unit"
                        + ",barcode"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":description"
                        + ",:amount"
                        + ",:customer_id"
                        + ",:customer_name"
                        + ",:transaction_no"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:unit"
                        + ",:barcode"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("description", to_my_services_description_customers.description)
                        .setNumber("amount", to_my_services_description_customers.amount)
                        .setString("customer_id", to_my_services_description_customers.customer_id)
                        .setString("customer_name", to_my_services_description_customers.customer_name)
                        .setString("transaction_no", to_my_services_description_customers.transaction_no)
                        .setString("date_added", to_my_services_description_customers.date_added)
                        .setString("user_name", to_my_services_description_customers.user_name)
                        .setString("unit", to_my_services_description_customers.unit)
                        .setString("barcode", to_my_services_description_customers.barcode)
                        .setString("branch", to_my_services_description_customers.branch)
                        .setString("branch_id", to_my_services_description_customers.branch_id)
                        .setString("location", to_my_services_description_customers.location)
                        .setString("location_id", to_my_services_description_customers.location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(My_services_description_customers.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_my_services_description_customers2(List<to_my_services_description_customers> to_my_services_description_customers1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_my_services_description_customers to_my_services_description_customers : to_my_services_description_customers1) {
                String s0 = "insert into my_services_description_customers("
                        + "description"
                        + ",amount"
                        + ",customer_id"
                        + ",customer_name"
                        + ",transaction_no"
                        + ",date_added"
                        + ",user_name"
                        + ",barcode"
                        + ",branch"
                        + ",branch_id"
                        + ",location"
                        + ",location_id"
                        + ")values("
                        + ":description"
                        + ",:amount"
                        + ",:customer_id"
                        + ",:customer_name"
                        + ",:transaction_no"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:barcode"
                        + ",:branch"
                        + ",:branch_id"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("description", to_my_services_description_customers.description)
                        .setNumber("amount", to_my_services_description_customers.amount)
                        .setString("customer_id", to_my_services_description_customers.customer_id)
                        .setString("customer_name", to_my_services_description_customers.customer_name)
                        .setString("transaction_no", to_my_services_description_customers.transaction_no)
                        .setString("date_added", to_my_services_description_customers.date_added)
                        .setString("user_name", to_my_services_description_customers.user_name)
                        .setString("barcode", to_my_services_description_customers.barcode)
                        .setString("branch", to_my_services_description_customers.branch)
                        .setString("branch_id", to_my_services_description_customers.branch_id)
                        .setString("location", to_my_services_description_customers.location)
                        .setString("location_id", to_my_services_description_customers.location_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(My_services_description_customers.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_description_customers(to_my_services_description_customers to_my_services_description_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_description_customers set "
                    + "description= :description"
                    + ",amount= :amount"
                    + ",customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",transaction_no= :transaction_no"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",barcode= :barcode"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where "
                    + " id ='" + to_my_services_description_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_my_services_description_customers.description)
                    .setNumber("amount", to_my_services_description_customers.amount)
                    .setString("customer_id", to_my_services_description_customers.customer_id)
                    .setString("customer_name", to_my_services_description_customers.customer_name)
                    .setString("transaction_no", to_my_services_description_customers.transaction_no)
                    .setString("date_added", to_my_services_description_customers.date_added)
                    .setString("user_name", to_my_services_description_customers.user_name)
                    .setString("barcode", to_my_services_description_customers.barcode)
                    .setString("branch", to_my_services_description_customers.branch)
                    .setString("branch_id", to_my_services_description_customers.branch_id)
                    .setString("location", to_my_services_description_customers.location)
                    .setString("location_id", to_my_services_description_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_description_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_description_customers(My_services_description_customers.to_my_services_description_customers to_my_services_description_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_description_customers where "
                    + " id ='" + to_my_services_description_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_description_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S1_my_services_description.to_my_services_description> ret_data(String where) {
        List<S1_my_services_description.to_my_services_description> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",description"
                    + ",amount"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",user_name"
                    + ",unit"
                    + ",barcode"
                    + " from my_services_description_customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String description = rs.getString(2);
                double amount = rs.getDouble(3);
                String customer_id = rs.getString(4);
                String customer_name = rs.getString(5);
                String transaction_no = rs.getString(6);
                String date_added = rs.getString(7);
                String user_name = rs.getString(8);
                String unit = rs.getString(9);
                String barcode = rs.getString(10);
                S1_my_services_description.to_my_services_description to = new S1_my_services_description.to_my_services_description(id, description, amount, unit, barcode);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services> ret_data2(String search) {
        List<to_my_services> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",transaction_no"
                    + ",service_slip_no"
                    + ",serviced_by"
                    + ",service_by_id"
                    + ",department_manager"
                    + ",department_manager_id"
                    + ",department"
                    + ",department_id"
                    + ",customer_name"
                    + ",customer_id"
                    + ",qty"
                    + ",unit"
                    + ",description"
                    + ",problem"
                    + ",date_received"
                    + ",date_assigned"
                    + ",date_released"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",service_type"
                    + ",service_type_id"
                    + ",amount"
                    + ",cashier"
                    + ",cashier_id"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",customer_contact_no"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services  "
                    + " group by customer_name order by customer_name asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String transaction_no = rs.getString(2);
                String service_slip_no = rs.getString(3);
                String serviced_by = rs.getString(4);
                String service_by_id = rs.getString(5);
                String department_manager = rs.getString(6);
                String department_manager_id = rs.getString(7);
                String department = rs.getString(8);
                String department_id = rs.getString(9);
                String customer_name = rs.getString(10);
                String customer_id = rs.getString(11);
                double qty = rs.getDouble(12);
                String unit = rs.getString(13);
                String description = rs.getString(14);
                String problem = rs.getString(15);
                String date_received = rs.getString(16);
                String date_assigned = rs.getString(17);
                String date_released = rs.getString(18);
                String added_by = rs.getString(19);
                String remarks = rs.getString(20);
                int status = rs.getInt(21);
                String service_type = rs.getString(22);
                String service_type_id = rs.getString(23);
                double amount = rs.getDouble(24);
                String cashier = rs.getString(25);
                String cashier_id = rs.getString(26);
                String user_id = rs.getString(27);
                String user_screen_name = rs.getString(28);
                String customer_contact_no = rs.getString(29);
                String branch = rs.getString(30);
                String branch_id = rs.getString(31);
                String location = rs.getString(32);
                String location_id = rs.getString(33);
                to_my_services to = new to_my_services(id, transaction_no, service_slip_no, serviced_by, service_by_id, department_manager, department_manager_id, department, department_id, customer_name, customer_id, qty, unit, description, problem, date_received, date_assigned, date_released, added_by, remarks, status, service_type, service_type_id, amount, cashier, cashier_id, false, user_id, user_screen_name, customer_contact_no, branch, branch_id, location, location_id);

                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_description_customers> ret_data3(String where) {
        List<to_my_services_description_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",description"
                    + ",amount"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",user_name"
                    + ",unit"
                    + ",barcode"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services_description_customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String description = rs.getString(2);
                double amount = rs.getDouble(3);
                String customer_id = rs.getString(4);
                String customer_name = rs.getString(5);
                String transaction_no = rs.getString(6);
                String date_added = rs.getString(7);
                String user_name = rs.getString(8);
                String unit = rs.getString(9);
                String barcode = rs.getString(10);
                String branch = rs.getString(11);
                String branch_id = rs.getString(12);
                String location = rs.getString(13);
                String location_id = rs.getString(14);
                to_my_services_description_customers to = new to_my_services_description_customers(id, description, amount, customer_id, customer_name, transaction_no, date_added, user_name, unit, barcode, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_my_services> datas = ret_data2("");
        for (to_my_services to : datas) {
            String customer_no = My_services_customers.increment_id("9");
            String customer_name = to.customer_name;
            String address = "";
            String contact_no = "";
            double balance = 0;

            My_services_customers.to_my_services_customers to1 = new My_services_customers.to_my_services_customers(-1, customer_no, customer_name, address, contact_no, balance, to.branch, to.branch_id, to.location, to.location_id);
            My_services_customers.add_my_services_customers(to1);
        }
    }
}
