/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;

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
 * @author Ronald
 */
public class S1_inventory_uom {

    public static class to_inventory_uom {

        public final int id;
        public final String code;
        public final String name;

        public to_inventory_uom(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }
    }

    public static void add_inventory_uom(to_inventory_uom to_inventory_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_uom("
                    + "code"
                    + ",name"
                    + ")values("
                    + ":code"
                    + ",:name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_inventory_uom.code).
                    setString("name", to_inventory_uom.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_uom.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_uom(to_inventory_uom to_inventory_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_uom set "
                    + "code= :code"
                    + ",name= :name"
                    + " where "
                    + " id ='" + to_inventory_uom.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_inventory_uom.code).
                    setString("name", to_inventory_uom.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_uom.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_uom(to_inventory_uom to_inventory_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_uom where "
                    + " id ='" + to_inventory_uom.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_uom.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_uom> ret_data(String search) {
        List<to_inventory_uom> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",name"
                    + " from inventory_uom where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);

                to_inventory_uom to = new to_inventory_uom(id, code, name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_uom> ret_where(String where) {
        List<to_inventory_uom> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",name"
                    + " from inventory_uom  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);

                to_inventory_uom to = new to_inventory_uom(id, code, name);
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

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "code"
                    + ",name"
                    + " from pisps_dbo.uom where "
                    + " name like'%" + "" + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                to_inventory_uom to = new to_inventory_uom(1, code, name);
                add_inventory_uom(to);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
