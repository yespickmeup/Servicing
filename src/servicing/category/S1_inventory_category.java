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
public class S1_inventory_category {

    public static class to_inventory_category {

        public final int id;
        public final String name;
        public final String code;

        public to_inventory_category(int id, String name, String code) {
            this.id = id;
            this.name = name;
            this.code = code;
        }
    }

    public static List<to_inventory_category> ret_data(String where) {
        List<to_inventory_category> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",code"
                    + " from inventory_category  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);

                to_inventory_category to = new to_inventory_category(id, name, code);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_category> ret_data2(String where) {
        List<to_inventory_category> datas = new ArrayList();
//        to_inventory_category to2 = new to_inventory_category(0, "All", "");
//        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",name"
                    + ",code"
                    + " from inventory_category  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);

                to_inventory_category to = new to_inventory_category(id, name, code);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_inventory_category(to_inventory_category to_inventory_category) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_category("
                    + "name"
                    + ",code"
                    + ")values("
                    + ":name"
                    + ",:code"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", to_inventory_category.name)
                    .setString("code", to_inventory_category.code)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_category.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_category(String id, String new_category) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = " update inventory_category set "
                    + " name= :name"
                    + ",code= :code"
                    + " where id='" + id + "'";

            s0 = SqlStringUtil.parse(s0)
                    .setString("name", new_category)
                    .setString("code", "")
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);
            
            String s2 = " update inventory set "
                    + " category= :category "
                    + " where category_id='" + id + "'";
            
            
            s2 = SqlStringUtil.parse(s2)
                    .setString("category", new_category)
                    .ok();

            stmt.addBatch(s2);

            String s3 = " update inventory_barcodes set "
                    + " category= :category "
                    + " where category_id='" + id + "'";

            s3 = SqlStringUtil.parse(s3)
                    .setString("category", new_category)
                    .ok();

            stmt.addBatch(s3);

            stmt.executeBatch();
            conn.commit();
            Lg.s(S1_inventory_category.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_category(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_category where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_category.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
