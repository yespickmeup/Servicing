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
public class S1_inventory_brand {

    public static class to_inventory_brand {

        public final int id;
        public final String code;
        public final String name;

        public to_inventory_brand(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }
    }

    public static void add_inventory_brand(to_inventory_brand to_inventory_brand) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inventory_brand("
                    + "code"
                    + ",name"
                    + ")values("
                    + ":code"
                    + ",:name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_inventory_brand.code).
                    setString("name", to_inventory_brand.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_brand.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inventory_brand(to_inventory_brand to_inventory_brand) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_brand set "
                    + "code= :code"
                    + ",name= :name"
                    + " where "
                    + " id ='" + to_inventory_brand.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_inventory_brand.code).
                    setString("name", to_inventory_brand.name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_brand.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inventory_brand(to_inventory_brand to_inventory_brand) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_brand where "
                    + " id ='" + to_inventory_brand.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inventory_brand.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_brand> ret_data(String search) {
        List<to_inventory_brand> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",name"
                    + " from inventory_brand where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);

                to_inventory_brand to = new to_inventory_brand(id, code, name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
   public static List<to_inventory_brand> ret_data3(String search) {
        List<to_inventory_brand> datas = new ArrayList();
         to_inventory_brand to2 = new to_inventory_brand(0, "", "");
                datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",name"
                    + " from inventory_brand where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);

                to_inventory_brand to = new to_inventory_brand(id, code, name);
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
                    + "name"
                    + " from pisps_dbo.brand where "
                    + " name like'%" + "" + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);

              to_inventory_brand to=new to_inventory_brand(1, name, name);
                add_inventory_brand(to);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
