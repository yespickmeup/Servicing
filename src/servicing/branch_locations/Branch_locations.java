/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.branch_locations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import servicing.branch_locations.S1_branch_locations.to_branch_locations;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronald
 */
public class Branch_locations {

    public static List<to_branch_locations> ret_all_locations() {
        List<to_branch_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);

                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
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
        List<to_branch_locations> datas = ret_all_locations();
        for (to_branch_locations to : datas) {
            System.out.println(to.location);
        }
    }

    public static List<to_branch_locations> ret_all_locations2(String date) {
        List<to_branch_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);

                String s3 = "select "
                        + " date_added"
                        + " from inventory_replenishments"
                        + " where  location_id='" + id + "' order by id desc limit 1";
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                String last_zero = "";
                if (rs3.next()) {
                    last_zero = rs3.getString(1);
                }

                String s2 = "select "
                        + "id"
                        + " from inventory_replenishments"
                        + " where Date(date_added)='" + date + "' and location_id='" + id + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                int stat = 0;
                if (rs2.next()) {
                    stat = 1;
                }

                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, last_zero, stat);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_all_locations_stock_take(String date) {
        List<to_branch_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);

                String s3 = "select "
                        + " date_added"
                        + " from stock_takes"
                        + " where  location_id='" + id + "' order by id desc limit 1";
                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                String last_zero = "";
                if (rs3.next()) {
                    last_zero = rs3.getString(1);
                }

                String s2 = "select "
                        + "id"
                        + " from stock_takes"
                        + " where Date(date_added)='" + date + "' and location_id='" + id + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                int stat = 0;
                if (rs2.next()) {
                    stat = 1;
                }

                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, last_zero, stat);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            return new ArrayList();
//            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
