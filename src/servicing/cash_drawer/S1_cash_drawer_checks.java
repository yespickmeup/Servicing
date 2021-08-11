/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.cash_drawer;


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
 * @author Maytopacka
 */
public class S1_cash_drawer_checks {

    public static class to_cash_drawer_checks {

        public final int id;
        public final String session_no;
        public final String user_name;
        public final String screen_name;
        public final String time_in;
        public final String time_out;
        public final String bank;
        public final String check_no;
        public final String check_holder;
        public final double amount;

        public to_cash_drawer_checks(int id, String session_no, String user_name, String screen_name, String time_in, String time_out, String bank, String check_no, String check_holder, double amount) {
            this.id = id;
            this.session_no = session_no;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.time_in = time_in;
            this.time_out = time_out;
            this.bank = bank;
            this.check_no = check_no;
            this.check_holder = check_holder;
            this.amount = amount;
        }
    }

    public static void add_cash_drawer_checks(List<to_cash_drawer_checks> to_cash_drawer_checks1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_cash_drawer_checks to_cash_drawer_checks : to_cash_drawer_checks1) {

                String s0 = "insert into  cash_drawer_checks("
                        + "session_no"
                        + ",user_name"
                        + ",screen_name"
                        + ",time_in"
                        + ",time_out"
                        + ",bank"
                        + ",check_no"
                        + ",check_holder"
                        + ",amount"
                        + ")values("
                        + ":session_no"
                        + ",:user_name"
                        + ",:screen_name"
                        + ",:time_in"
                        + ",:time_out"
                        + ",:bank"
                        + ",:check_no"
                        + ",:check_holder"
                        + ",:amount"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("session_no", to_cash_drawer_checks.session_no).
                        setString("user_name", to_cash_drawer_checks.user_name).
                        setString("screen_name", to_cash_drawer_checks.screen_name).
                        setString("time_in", to_cash_drawer_checks.time_in).
                        setString("time_out", to_cash_drawer_checks.time_out).
                        setString("bank", to_cash_drawer_checks.bank).
                        setString("check_no", to_cash_drawer_checks.check_no).
                        setString("check_holder", to_cash_drawer_checks.check_holder).
                        setNumber("amount", to_cash_drawer_checks.amount).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_cash_drawer_checks.class, "Successfully Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_cash_drawer_checks(to_cash_drawer_checks to_cash_drawer_checks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  cash_drawer_checks set "
                    + "session_no= '" + to_cash_drawer_checks.session_no + "'"
                    + ",user_name= '" + to_cash_drawer_checks.user_name + "'"
                    + ",screen_name= '" + to_cash_drawer_checks.screen_name + "'"
                    + ",time_in= '" + to_cash_drawer_checks.time_in + "'"
                    + ",time_out= '" + to_cash_drawer_checks.time_out + "'"
                    + ",bank= '" + to_cash_drawer_checks.bank + "'"
                    + ",check_no= '" + to_cash_drawer_checks.check_no + "'"
                    + ",check_holder= '" + to_cash_drawer_checks.check_holder + "'"
                    + ",amount= '" + to_cash_drawer_checks.amount + "'"
                    + "where "
                    + " id ='" + to_cash_drawer_checks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_checks.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_cash_drawer_checks(to_cash_drawer_checks to_cash_drawer_checks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  cash_drawer_checks where "
                    + " id ='" + to_cash_drawer_checks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_checks.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_cash_drawer_checks2(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  cash_drawer_checks where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_checks.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_checks> ret_data(String session_no1) {
        List<to_cash_drawer_checks> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + " from  cash_drawer_checks where "
                    + " session_no ='" + session_no1 + "' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                to_cash_drawer_checks to = new to_cash_drawer_checks(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_checks> ret_data2(String where) {
        List<to_cash_drawer_checks> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + " from  cash_drawer_checks  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                to_cash_drawer_checks to = new to_cash_drawer_checks(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount);
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
