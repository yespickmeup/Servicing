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
 * @author Guinness
 */
public class My_services_barcodes_customers {

    public static class to_my_services_barcodes_customers {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String transaction_no;
        public final String date_added;
        public final String barcode;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public  boolean selected;
        public to_my_services_barcodes_customers(int id, String customer_id, String customer_name, String transaction_no, String date_added, String barcode, String branch, String branch_id, String location, String location_id,boolean selected) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.transaction_no = transaction_no;
            this.date_added = date_added;
            this.barcode = barcode;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.selected=selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
        
    }

    public static void add_data(to_my_services_barcodes_customers to_my_services_barcodes_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_barcodes_customers("
                    + "customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",barcode"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:transaction_no"
                    + ",:date_added"
                    + ",:barcode"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_my_services_barcodes_customers.customer_id)
                    .setString("customer_name", to_my_services_barcodes_customers.customer_name)
                    .setString("transaction_no", to_my_services_barcodes_customers.transaction_no)
                    .setString("date_added", to_my_services_barcodes_customers.date_added)
                    .setString("barcode", to_my_services_barcodes_customers.barcode)
                    .setString("branch", to_my_services_barcodes_customers.branch)
                    .setString("branch_id", to_my_services_barcodes_customers.branch_id)
                    .setString("location", to_my_services_barcodes_customers.location)
                    .setString("location_id", to_my_services_barcodes_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_barcodes_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_my_services_barcodes_customers to_my_services_barcodes_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_barcodes_customers set "
                    + "customer_id= :customer_id "
                    + ",customer_name= :customer_name "
                    + ",transaction_no= :transaction_no "
                    + ",date_added= :date_added "
                    + ",barcode= :barcode "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_my_services_barcodes_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_my_services_barcodes_customers.customer_id)
                    .setString("customer_name", to_my_services_barcodes_customers.customer_name)
                    .setString("transaction_no", to_my_services_barcodes_customers.transaction_no)
                    .setString("date_added", to_my_services_barcodes_customers.date_added)
                    .setString("barcode", to_my_services_barcodes_customers.barcode)
                    .setString("branch", to_my_services_barcodes_customers.branch)
                    .setString("branch_id", to_my_services_barcodes_customers.branch_id)
                    .setString("location", to_my_services_barcodes_customers.location)
                    .setString("location_id", to_my_services_barcodes_customers.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_barcodes_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_my_services_barcodes_customers to_my_services_barcodes_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_barcodes_customers  "
                    + " where id='" + to_my_services_barcodes_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_barcodes_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_barcodes_customers> ret_data(String where) {
        List<to_my_services_barcodes_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",transaction_no"
                    + ",date_added"
                    + ",barcode"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services_barcodes_customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String transaction_no = rs.getString(4);
                String date_added = rs.getString(5);
                String barcode = rs.getString(6);
                String branch = rs.getString(7);
                String branch_id = rs.getString(8);
                String location = rs.getString(9);
                String location_id = rs.getString(10);

                to_my_services_barcodes_customers to = new to_my_services_barcodes_customers(id, customer_id, customer_name, transaction_no, date_added, barcode, branch, branch_id, location, location_id,true);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "000000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from my_services_barcodes_customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select barcode from my_services_barcodes_customers where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
