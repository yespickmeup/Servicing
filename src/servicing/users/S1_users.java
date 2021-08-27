/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.users;

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
 * @author i1
 */
public class S1_users {

    public static class to_users {

        public final int id;
        public final String screen_name;
        public final String user_name;
        public final String password;
        public final int user_level;
        public final String date_added;
        public final int is_active;
        public final String t_sales;
        public final String t_receipts;
        public final String t_stock_transfer;
        public final String m_items;
        public final String m_category;
        public final String m_users;
        public final String m_uom;
        public final String m_suppliers;
        public final String r_sales;
        public final String r_cash_count;
        public final String r_receipts;
        public final String r_stock_transferred;
        public final String r_stock_take;
        public final String m_customers;
        public final String m_discount;
        public final String m_banks;
        public final String r_stock_left_supplier;
        public final String t_inventory_adjuster;
        public final String t_salesman;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;

        public to_users(int id, String screen_name, String user_name, String password, int user_level, String date_added,
                int is_active, String t_sales, String t_receipts, String t_stock_transfer, String m_items, String m_category, String m_users, String m_uom, String m_suppliers, String r_sales, String r_cash_count, String r_receipts, String r_stock_transferred, String r_stock_take, String m_customers, String m_discount, String m_banks, String r_stock_left_supplier, String t_inventory_adjuster, String t_salesman, String branch, String branch_id, String location, String location_id) {
            this.id = id;
            this.screen_name = screen_name;
            this.user_name = user_name;
            this.password = password;
            this.user_level = user_level;
            this.date_added = date_added;
            this.is_active = is_active;
            this.t_sales = t_sales;
            this.t_receipts = t_receipts;
            this.t_stock_transfer = t_stock_transfer;
            this.m_items = m_items;
            this.m_category = m_category;
            this.m_users = m_users;
            this.m_uom = m_uom;
            this.m_suppliers = m_suppliers;
            this.r_sales = r_sales;
            this.r_cash_count = r_cash_count;
            this.r_receipts = r_receipts;
            this.r_stock_transferred = r_stock_transferred;
            this.r_stock_take = r_stock_take;
            this.m_customers = m_customers;
            this.m_discount = m_discount;
            this.m_banks = m_banks;
            this.r_stock_left_supplier = r_stock_left_supplier;
            this.t_inventory_adjuster = t_inventory_adjuster;
            this.t_salesman = t_salesman;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
        }
    }

    public static void add_users(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into  users("
                    + "screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ")values("
                    + ":screen_name"
                    + ",:user_name"
                    + ",:password"
                    + ",:user_level"
                    + ",:date_added"
                    + ",:is_active"
                    + ",:t_sales"
                    + ",:t_receipts"
                    + ",:t_stock_transfer"
                    + ",:m_items"
                    + ",:m_category"
                    + ",:m_users"
                    + ",:m_uom"
                    + ",:m_suppliers"
                    + ",:r_sales"
                    + ",:r_cash_count"
                    + ",:r_receipts"
                    + ",:r_stock_transferred"
                    + ",:r_stock_take"
                    + ",:m_customers"
                    + ",:m_discount"
                    + ",:m_banks"
                    + ",:r_stock_left_supplier"
                    + ",:t_inventory_adjuster"
                    + ",:t_salesman"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("screen_name", to_users.screen_name).
                    setString("user_name", to_users.user_name).
                    setString("password", to_users.password).
                    setNumber("user_level", to_users.user_level).
                    setString("date_added", to_users.date_added).
                    setNumber("is_active", to_users.is_active).
                    setString("t_sales", to_users.t_sales).
                    setString("t_receipts", to_users.t_receipts).
                    setString("t_stock_transfer", to_users.t_stock_transfer).
                    setString("m_items", to_users.m_items).
                    setString("m_category", to_users.m_category).
                    setString("m_users", to_users.m_users).
                    setString("m_uom", to_users.m_uom).
                    setString("m_suppliers", to_users.m_suppliers).
                    setString("r_sales", to_users.r_sales).
                    setString("r_cash_count", to_users.r_cash_count).
                    setString("r_receipts", to_users.r_receipts).
                    setString("r_stock_transferred", to_users.r_stock_transferred).
                    setString("r_stock_take", to_users.r_stock_take).
                    setString("m_customers", to_users.m_customers).
                    setString("m_discount", to_users.m_discount).
                    setString("m_banks", to_users.m_banks).
                    setString("r_stock_left_supplier", to_users.r_stock_left_supplier).
                    setString("t_inventory_adjuster", to_users.t_inventory_adjuster).
                    setString("t_salesman", to_users.t_salesman).
                    setString("branch", to_users.branch).
                    setString("branch_id", to_users.branch_id).
                    setString("location", to_users.location).
                    setString("location_id", to_users.location_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_users.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_users(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update  users set "
                    + "screen_name= '" + to_users.screen_name + "'"
                    + ",user_name= '" + to_users.user_name + "'"
                    + ",password= '" + to_users.password + "'"
                    + ",user_level= '" + to_users.user_level + "'"
                    + ",date_added= '" + to_users.date_added + "'"
                    + ",is_active= '" + to_users.is_active + "'"
                    + ",t_sales= '" + to_users.t_sales + "'"
                    + ",t_receipts= '" + to_users.t_receipts + "'"
                    + ",t_stock_transfer= '" + to_users.t_stock_transfer + "'"
                    + ",m_items= '" + to_users.m_items + "'"
                    + ",m_category= '" + to_users.m_category + "'"
                    + ",m_users= '" + to_users.m_users + "'"
                    + ",m_uom= '" + to_users.m_uom + "'"
                    + ",m_suppliers= '" + to_users.m_suppliers + "'"
                    + ",r_sales= '" + to_users.r_sales + "'"
                    + ",r_cash_count= '" + to_users.r_cash_count + "'"
                    + ",r_receipts= '" + to_users.r_receipts + "'"
                    + ",r_stock_transferred= '" + to_users.r_stock_transferred + "'"
                    + ",r_stock_take= '" + to_users.r_stock_take + "'"
                    + ",m_customers= '" + to_users.m_customers + "'"
                    + ",m_discount= '" + to_users.m_discount + "'"
                    + ",m_banks= '" + to_users.m_banks + "'"
                    + ",r_stock_left_supplier= '" + to_users.r_stock_left_supplier + "'"
                    + ",t_inventory_adjuster= '" + to_users.t_inventory_adjuster + "'"
                    + ",t_salesman= '" + to_users.t_salesman + "'"
                    + ",branch= '" + to_users.branch + "'"
                    + ",branch_id= '" + to_users.branch_id + "'"
                    + ",location= '" + to_users.location + "'"
                    + ",location_id= '" + to_users.location_id + "'"
                    + "where "
                    + " id ='" + to_users.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_users.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_users(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  users where "
                    + " id ='" + to_users.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_users.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_data(String search) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  users where "
                    + " screen_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_where(String where) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  users  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to_users to = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_users ret_data_w_screen_name(String search) {
        to_users to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  users where "
                    + " screen_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to1 = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
//                datas.add(to);
//                datas.add(to);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_users ret_data_w_user_name(String search) {
        to_users to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  users where "
                    + " user_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to1 = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales,
                                   r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
//                datas.add(to);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data_screen_names(String user_names) {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select screen_name from  users where  user_name like '%" + user_names + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cashier_names_w_admin() {
        List<String> datas = new ArrayList();
        datas.add("ALL");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select screen_name from  users where user_level='" + "1" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_users ret_data_autho(String user_names, String passwords) {
        to_users to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + ",t_salesman"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from  users where "
                    + " user_name ='" + user_names + "'  and password ='" + passwords + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);
                String t_salesman = rs.getString(26);
                String branch = rs.getString(27);
                String branch_id = rs.getString(28);
                String location = rs.getString(29);
                String location_id = rs.getString(30);
                to1 = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster, t_salesman, branch, branch_id, location, location_id);
//                datas.add(to);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
