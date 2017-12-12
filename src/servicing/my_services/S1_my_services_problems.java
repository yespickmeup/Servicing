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
public class S1_my_services_problems {

    public static class to_my_services_problems {

        public final int id;
        public String problem;
        public double amount;

        public to_my_services_problems(int id, String problem, double amount) {
            this.id = id;
            this.problem = problem;
            this.amount = amount;
        }

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void add_my_services_problems(to_my_services_problems to_my_services_problems) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_problems("
                    + "problem"
                    + ")values("
                    + ":problem"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("problem", to_my_services_problems.problem)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_problems.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_problems(to_my_services_problems to_my_services_problems) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_problems set "
                    + "problem= :problem"
                    + " where "
                    + " id ='" + to_my_services_problems.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("problem", to_my_services_problems.problem)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_problems.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_problems(to_my_services_problems to_my_services_problems) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_problems where "
                    + " id ='" + to_my_services_problems.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_problems.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_my_services_problems> ret_data(String where) {
        List<to_my_services_problems> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id,"
                    + "problem"
                    + " from my_services_problems  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String problem = rs.getString(2);
                to_my_services_problems to = new to_my_services_problems(0, problem, 0);
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
