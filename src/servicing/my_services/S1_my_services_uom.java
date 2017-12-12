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
public class S1_my_services_uom {

    public static class to_my_services_uom {

        public final int id;
        public final String uom;

        public to_my_services_uom(int id, String uom) {
            this.id = id;
            this.uom = uom;
        }
    }

    public static void add_my_services_uom(to_my_services_uom to_my_services_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_uom("
                    + "uom"
                    + ")values("
                    + ":uom"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("uom", to_my_services_uom.uom)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_uom.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_uom(to_my_services_uom to_my_services_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_uom set "
                    + "uom= :uom"
                    + " where "
                    + " id ='" + to_my_services_uom.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("uom", to_my_services_uom.uom)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_uom.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_uom(to_my_services_uom to_my_services_uom) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_uom where "
                    + " id ='" + to_my_services_uom.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_uom.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_uom> ret_data(String where) {
        List<to_my_services_uom> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",uom"
                    + " from my_services_uom  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String uom = rs.getString(2);

                to_my_services_uom to = new to_my_services_uom(id, uom);
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
