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
public class S1_my_services_description {

    public static class to_my_services_description {

        public final int id;
        public final String description;
        public double amount;
        public String unit;
        public String barcode;

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public to_my_services_description(int id, String description, double amount, String unit,String barcode) {
            this.id = id;
            this.description = description;
            this.amount = amount;
            this.unit = unit;
            this.barcode=barcode;
        }
    }

    public static void add_my_services_description(to_my_services_description to_my_services_description) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_description("
                    + "description"
                    + ",amount"

                    + ")values("
                    + ":description"
                    + ",:amount"

                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_my_services_description.description)
                    .setNumber("amount", to_my_services_description.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_description.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_description(to_my_services_description to_my_services_description) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_description set "
                    + "description= :description"
                    + ",amount= :amount"
                    + " where "
                    + " id ='" + to_my_services_description.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("description", to_my_services_description.description)
                    .setNumber("amount", to_my_services_description.amount)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_description.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_description(to_my_services_description to_my_services_description) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_description where "
                    + " id ='" + to_my_services_description.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_description.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_description> ret_data(String where) {
        List<to_my_services_description> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",description"
                    + ",amount"
                    + " from my_services_description  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String description = rs.getString(2);
                double amount = rs.getDouble(3);
                String unit = "";
                String barcode="";
                to_my_services_description to = new to_my_services_description(id, description, amount, unit,barcode);
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
