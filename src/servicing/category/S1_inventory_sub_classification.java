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
public class S1_inventory_sub_classification {

    public static class to_inventory_sub_classification {

        public final int id;
        public final String category_code;
        public final String category;
        public final String classification_code;
        public final String classification;
        public final String code;
        public final String name;
        public final double markup;

        public to_inventory_sub_classification(int id, String category_code, String category, String classification_code, String classification, String code, String name, double markup) {
            this.id = id;
            this.category_code = category_code;
            this.category = category;
            this.classification_code = classification_code;
            this.classification = classification;
            this.code = code;
            this.name = name;
            this.markup = markup;
        }
    }

    public static List<to_inventory_sub_classification> ret_data(String where) {
        List<to_inventory_sub_classification> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_code"
                    + ",category"
                    + ",classification_code"
                    + ",classification"
                    + ",code"
                    + ",name"
                    + ",markup"
                    + " from inventory_sub_classification  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_code = rs.getString(2);
                String category = rs.getString(3);
                String classification_code = rs.getString(4);
                String classification = rs.getString(5);
                String code = rs.getString(6);
                String name = rs.getString(7);
                double markup = rs.getDouble(8);

                to_inventory_sub_classification to = new to_inventory_sub_classification(id, category_code, category, classification_code, classification, code, name, markup);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_sub_classification> ret_data2(String where) {
        List<to_inventory_sub_classification> datas = new ArrayList();
//        to_inventory_sub_classification to2 = new to_inventory_sub_classification(0, "", "", "", "", "", "All",0);
//        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_code"
                    + ",category"
                    + ",classification_code"
                    + ",classification"
                    + ",code"
                    + ",name"
                    + ",markup"
                    + " from inventory_sub_classification  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_code = rs.getString(2);
                String category = rs.getString(3);
                String classification_code = rs.getString(4);
                String classification = rs.getString(5);
                String code = rs.getString(6);
                String name = rs.getString(7);
                double markup = rs.getDouble(8);

                to_inventory_sub_classification to = new to_inventory_sub_classification(id, category_code, category, classification_code, classification, code, name, markup);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_inventory_sub_classification(to_inventory_sub_classification to_inventory_sub_classification) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_sub_classification("
                    + "category_code"
                    + ",category"
                    + ",classification_code"
                    + ",classification"
                    + ",code"
                    + ",name"
                    + ",markup"
                    + ")values("
                    + ":category_code"
                    + ",:category"
                    + ",:classification_code"
                    + ",:classification"
                    + ",:code"
                    + ",:name"
                    + ",:markup"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category_code", to_inventory_sub_classification.category_code)
                    .setString("category", to_inventory_sub_classification.category)
                    .setString("classification_code", to_inventory_sub_classification.classification_code)
                    .setString("classification", to_inventory_sub_classification.classification)
                    .setString("code", to_inventory_sub_classification.code)
                    .setString("name", to_inventory_sub_classification.name)
                    .setNumber("markup", to_inventory_sub_classification.markup)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_sub_classification.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_inventory_sub_classification2(List<to_inventory_sub_classification> to_inventory_sub_classification1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory_sub_classification to_inventory_sub_classification : to_inventory_sub_classification1) {
                String s0 = "insert into inventory_sub_classification("
                        + "category_code"
                        + ",category"
                        + ",classification_code"
                        + ",classification"
                        + ",code"
                        + ",name"
                        + ",markup"
                        + ")values("
                        + ":category_code"
                        + ",:category"
                        + ",:classification_code"
                        + ",:classification"
                        + ",:code"
                        + ",:name"
                        + ",:markup"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("category_code", to_inventory_sub_classification.category_code)
                        .setString("category", to_inventory_sub_classification.category)
                        .setString("classification_code", to_inventory_sub_classification.classification_code)
                        .setString("classification", to_inventory_sub_classification.classification)
                        .setString("code", to_inventory_sub_classification.code)
                        .setString("name", to_inventory_sub_classification.name)
                        .setNumber("markup", to_inventory_sub_classification.markup)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_inventory_sub_classification.class, "Successfully Added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_sub_classification(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_sub_classification where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_sub_classification.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
