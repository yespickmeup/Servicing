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
public class My_services_crews {

    public static class to_my_services_crews {

        public final int id;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String address;
        public final String contact_no;
        public final String manager;
        public final String manager_id;
        public final String department;
        public final String department_id;
        public final int is_manager;
        public final int is_status;
        public final int account_created;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_services_crews(int id, String fname, String mi, String lname, String address, String contact_no, String manager, String manager_id, String department, String department_id, int is_manager, int is_status, int account_created, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.address = address;
            this.contact_no = contact_no;
            this.manager = manager;
            this.manager_id = manager_id;
            this.department = department;
            this.department_id = department_id;
            this.is_manager = is_manager;
            this.is_status = is_status;
            this.account_created = account_created;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_my_services_crews(to_my_services_crews to_my_services_crews) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_crews("
                    + "fname"
                    + ",mi"
                    + ",lname"
                    + ",address"
                    + ",contact_no"
                    + ",manager"
                    + ",manager_id"
                    + ",department"
                    + ",department_id"
                    + ",is_manager"
                    + ",is_status"
                    + ",account_created"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":fname"
                    + ",:mi"
                    + ",:lname"
                    + ",:address"
                    + ",:contact_no"
                    + ",:manager"
                    + ",:manager_id"
                    + ",:department"
                    + ",:department_id"
                    + ",:is_manager"
                    + ",:is_status"
                    + ",:account_created"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("fname", to_my_services_crews.fname)
                    .setString("mi", to_my_services_crews.mi)
                    .setString("lname", to_my_services_crews.lname)
                    .setString("address", to_my_services_crews.address)
                    .setString("contact_no", to_my_services_crews.contact_no)
                    .setString("manager", to_my_services_crews.manager)
                    .setString("manager_id", to_my_services_crews.manager_id)
                    .setString("department", to_my_services_crews.department)
                    .setString("department_id", to_my_services_crews.department_id)
                    .setNumber("is_manager", to_my_services_crews.is_manager)
                    .setNumber("is_status", to_my_services_crews.is_status)
                    .setNumber("account_created", to_my_services_crews.account_created)
                    .setString("branch", to_my_services_crews.branch)
                    .setString("branch_id", to_my_services_crews.branch_id)
                    .setString("location", to_my_services_crews.location)
                    .setString("location_id", to_my_services_crews.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_crews.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_crews(to_my_services_crews to_my_services_crews) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_crews set "
                    + "fname= :fname"
                    + ",mi= :mi"
                    + ",lname= :lname"
                    + ",address= :address"
                    + ",contact_no= :contact_no"
                    + ",manager= :manager"
                    + ",manager_id= :manager_id"
                    + ",department= :department"
                    + ",department_id= :department_id"
                    + ",is_manager= :is_manager"
                    + ",is_status= :is_status"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where "
                    + " id ='" + to_my_services_crews.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("fname", to_my_services_crews.fname)
                    .setString("mi", to_my_services_crews.mi)
                    .setString("lname", to_my_services_crews.lname)
                    .setString("address", to_my_services_crews.address)
                    .setString("contact_no", to_my_services_crews.contact_no)
                    .setString("manager", to_my_services_crews.manager)
                    .setString("manager_id", to_my_services_crews.manager_id)
                    .setString("department", to_my_services_crews.department)
                    .setString("department_id", to_my_services_crews.department_id)
                    .setNumber("is_manager", to_my_services_crews.is_manager)
                    .setNumber("is_status", to_my_services_crews.is_status)
                    .setString("branch", to_my_services_crews.branch)
                    .setString("branch_id", to_my_services_crews.branch_id)
                    .setString("location", to_my_services_crews.location)
                    .setString("location_id", to_my_services_crews.location_id)
                    //                    .setNumber("account_created", to_my_services_crews.account_created)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_crews.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_crews(to_my_services_crews to_my_services_crews) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_crews where "
                    + " id ='" + to_my_services_crews.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_crews.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_crews> ret_data(String where) {
        List<to_my_services_crews> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",fname"
                    + ",mi"
                    + ",lname"
                    + ",address"
                    + ",contact_no"
                    + ",manager"
                    + ",manager_id"
                    + ",department"
                    + ",department_id"
                    + ",is_manager"
                    + ",is_status"
                    + ",account_created"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services_crews  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String mi = rs.getString(3);
                String lname = rs.getString(4);
                String address = rs.getString(5);
                String contact_no = rs.getString(6);
                String manager = rs.getString(7);
                String manager_id = rs.getString(8);
                String department = rs.getString(9);
                String department_id = rs.getString(10);
                int is_manager = rs.getInt(11);
                int is_status = rs.getInt(12);
                int account_created = rs.getInt(13);
                String branch = rs.getString(14);
                String branch_id = rs.getString(15);
                String location = rs.getString(16);
                String location_id = rs.getString(17);
                to_my_services_crews to = new to_my_services_crews(id, fname, mi, lname, address, contact_no, manager, manager_id, department, department_id, is_manager, is_status, account_created, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_created(String id, int created) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_crews set "
                    + "account_created= :account_created"
                    + " where "
                    + " id ='" + id + "' "
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("account_created", created)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_crews.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_users(String screen_name, String user_name, String password) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into users("
                    + "screen_name"
                    + ",user_name"
                    + ",password"
                    + ")values("
                    + ":screen_name"
                    + ",:user_name"
                    + ",:password"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("screen_name", screen_name)
                    .setString("user_name", user_name)
                    .setString("password", password)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_crews.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_users2(String screen_name, String user_name, String password, String branch, String branch_id, String location, String location_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into users("
                    + "screen_name"
                    + ",user_name"
                    + ",password"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":screen_name"
                    + ",:user_name"
                    + ",:password"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("screen_name", screen_name)
                    .setString("user_name", user_name)
                    .setString("password", password)
                    .setString("branch", branch)
                    .setString("branch_id", branch_id)
                    .setString("location", location)
                    .setString("location_id", location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_crews.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String lastId() {
        String id = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);

            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
