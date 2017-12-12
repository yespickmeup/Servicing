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
public class My_services_departments {

    public static class to_my_services_departments {

        public final int id;
        public final String department;
        public final String manager;
        public final String manager_id;
        public final int status;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_services_departments(int id, String department, String manager, String manager_id, int status, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.department = department;
            this.manager = manager;
            this.manager_id = manager_id;
            this.status = status;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_my_services_departments(to_my_services_departments to_my_services_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_departments("
                    + "department"
                    + ",manager"
                    + ",manager_id"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":department"
                    + ",:manager"
                    + ",:manager_id"
                    + ",:status"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("department", to_my_services_departments.department)
                    .setString("manager", to_my_services_departments.manager)
                    .setString("manager_id", to_my_services_departments.manager_id)
                    .setNumber("status", to_my_services_departments.status)
                    .setString("branch", to_my_services_departments.branch)
                    .setString("branch_id", to_my_services_departments.branch_id)
                    .setString("location", to_my_services_departments.location)
                    .setString("location_id", to_my_services_departments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_departments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_departments(to_my_services_departments to_my_services_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_departments set "
                    + "department= :department"
                    + ",manager= :manager"
                    + ",manager_id= :manager_id"
                    + ",status= :status"
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where "
                    + " id ='" + to_my_services_departments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("department", to_my_services_departments.department)
                    .setString("manager", to_my_services_departments.manager)
                    .setString("manager_id", to_my_services_departments.manager_id)
                    .setNumber("status", to_my_services_departments.status)
                    .setString("branch", to_my_services_departments.branch)
                    .setString("branch_id", to_my_services_departments.branch_id)
                    .setString("location", to_my_services_departments.location)
                    .setString("location_id", to_my_services_departments.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_departments.class, "Successfully Updated");
            String s2 = "update my_services_crews set "
                    + "manager= :manager"
                    + ",manager_id= :manager_id"
                    + " where "
                    + " department_id ='" + to_my_services_departments.id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setString("manager", to_my_services_departments.manager)
                    .setString("manager_id", to_my_services_departments.manager_id)
                    .ok();
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(My_services_crews.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_departments(to_my_services_departments to_my_services_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_departments where "
                    + " id ='" + to_my_services_departments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(My_services_departments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_departments> ret_data(String where) {
        List<to_my_services_departments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",department"
                    + ",manager"
                    + ",manager_id"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_services_departments  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String department = rs.getString(2);
                String manager = rs.getString(3);
                String manager_id = rs.getString(4);
                int status = rs.getInt(5);
                String branch = rs.getString(6);
                String branch_id = rs.getString(7);
                String location = rs.getString(8);
                String location_id = rs.getString(9);
                to_my_services_departments to = new to_my_services_departments(id, department, manager, manager_id, status, branch, branch_id, location, location_id);
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
