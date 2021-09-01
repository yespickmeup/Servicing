/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.category;

import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class S1_inventory_model {

    public static class to_inventory_model {

        public final int id;
        public final String brand_code;
        public final String brand;
        public final String code;
        public final String name;

        public to_inventory_model(int id, String brand_code, String brand, String code, String name) {
            this.id = id;
            this.brand_code = brand_code;
            this.brand = brand;
            this.code = code;
            this.name = name;
        }
    }

    public static List<to_inventory_model> ret_data(String where) {
        List<to_inventory_model> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",brand_code"
                    + ",brand"
                    + ",code"
                    + ",name"
                    + " from inventory_model  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String brand_code = rs.getString(2);
                String brand = rs.getString(3);
                String code = rs.getString(4);
                String name = rs.getString(5);

                to_inventory_model to = new to_inventory_model(id, brand_code, brand, code, name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_model> ret_data2(String where) {
        List<to_inventory_model> datas = new ArrayList();
//        to_inventory_model to2 = new to_inventory_model(0, "", "", "", "All");
//        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",brand_code"
                    + ",brand"
                    + ",code"
                    + ",name"
                    + " from inventory_model  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String brand_code = rs.getString(2);
                String brand = rs.getString(3);
                String code = rs.getString(4);
                String name = rs.getString(5);

                to_inventory_model to = new to_inventory_model(id, brand_code, brand, code, name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_inventory_model(to_inventory_model to_inventory_model) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_model("
                    + "brand_code"
                    + ",brand"
                    + ",code"
                    + ",name"
                    + ")values("
                    + ":brand_code"
                    + ",:brand"
                    + ",:code"
                    + ",:name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("brand_code", to_inventory_model.brand_code)
                    .setString("brand", to_inventory_model.brand)
                    .setString("code", to_inventory_model.code)
                    .setString("name", to_inventory_model.name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_model.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_model(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_model where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_model.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
