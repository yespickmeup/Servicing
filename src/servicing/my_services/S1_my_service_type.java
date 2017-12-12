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
public class S1_my_service_type {

    public static class to_my_service_type {

        public final int id;
        public final String service;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_my_service_type(int id, String service, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.service = service;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_my_service_type(to_my_service_type to_my_service_type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_service_type("
                    + "service"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":service"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("service", to_my_service_type.service)
                    .setString("branch", to_my_service_type.branch)
                    .setString("branch_id", to_my_service_type.branch_id)
                    .setString("location", to_my_service_type.location)
                    .setString("location_id", to_my_service_type.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_service_type.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_service_type(to_my_service_type to_my_service_type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_service_type set "
                    + "service= :service "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_my_service_type.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("service", to_my_service_type.service)
                    .setString("branch", to_my_service_type.branch)
                    .setString("branch_id", to_my_service_type.branch_id)
                    .setString("location", to_my_service_type.location)
                    .setString("location_id", to_my_service_type.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_service_type.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_service_type(to_my_service_type to_my_service_type) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_service_type where "
                    + " id ='" + to_my_service_type.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_service_type.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_service_type> ret_data(String where) {
        List<to_my_service_type> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",service"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from my_service_type"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String service = rs.getString(2);
                String branch = rs.getString(3);
                String branch_id = rs.getString(4);
                String location = rs.getString(5);
                String location_id = rs.getString(6);

                to_my_service_type to = new to_my_service_type(id, service, branch, branch_id, location, location_id);
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
