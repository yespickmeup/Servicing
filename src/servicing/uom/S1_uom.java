/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.uom;


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
 * @author i1
 */
public class S1_uom {

    public static class to_uom {

        public final int id;
        public final String unit;

        public to_uom(int id, String unit) {
            this.id = id;
            this.unit = unit;
        }
    }

    public static void add_uom(to_uom to_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  uom("
                    + "unit"
                    + ")values("
                    + ":unit"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("unit", to_uom.unit).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_uom(to_uom to_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  uom set "
                    + "unit= '" + to_uom.unit + "'"
                    + "where "
                    + " id ='" + to_uom.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_uom.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_uom(to_uom to_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  uom where "
                    + " id ='" + to_uom.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_uom.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_uom> ret_data(String search) {
        List<to_uom> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",unit"
                    + " from  uom "
                    + " where "
                    + " unit like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String unit = rs.getString(2);

                to_uom to = new to_uom(id, unit);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select unit from  uom";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data2() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select unit from  uom where unit <>'" + "PC" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
