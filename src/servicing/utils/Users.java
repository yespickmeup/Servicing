/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.utils;


import java.util.List;
import servicing.cash_drawer.S1_cash_drawer;
import servicing.cash_drawer.S1_cash_drawer.to_cash_drawer;
import servicing.cash_drawer.S1_cash_drawer_checks;
import servicing.cash_drawer.S1_cash_drawer_checks.to_cash_drawer_checks;
import servicing.cash_drawer.S1_cash_drawer_expenses;
import servicing.cash_drawer.S1_cash_drawer_expenses.to_cash_drawer_expenses;

/**
 *
 * @author i1
 */
public class Users {

    public int id;
    public static String screen_name;
    public static String user_name;
    public static String password;
    public static int user_level;
    public static String date_added;
    public static int is_active;
    public static String session_no;
    public static String t_sales;
    public static String t_receipts;
    public static String t_stock_transfer;
    public static String m_items;
    public static String m_category;
    public static String m_users;
    public static String m_uom;
    public static String m_suppliers;
    public static String r_sales;
    public static String r_cash_count;
    public static String r_receipts;
    public static String r_stock_transferred;
    public static String r_stock_take;
    public static String m_customers;
    public static String m_discount;
    public static String m_banks;
    public static List<S1_cash_drawer_checks.to_cash_drawer_checks> checks;
    public static S1_cash_drawer.to_cash_drawer drawer;
    public static String r_stock_left_supplier;
    public static String time_in;
    public static String time_out;
    public static String t_inventory_adjuster;
    public static List<S1_cash_drawer_expenses.to_cash_drawer_expenses> expenses;
    public static String t_salesman;

    public static String getT_salesman() {
        return t_salesman;
    }

    public static void setT_salesman(String t_salesman) {
        Users.t_salesman = t_salesman;
    }

    public static List<to_cash_drawer_expenses> getExpenses() {
        return expenses;
    }

    public static void setExpenses(List<to_cash_drawer_expenses> expenses) {
        Users.expenses = expenses;
    }

    public static String getT_inventory_adjuster() {
        return t_inventory_adjuster;
    }

    public static void setT_inventory_adjuster(String t_inventory_adjuster) {
        Users.t_inventory_adjuster = t_inventory_adjuster;
    }

    public static String getTime_in() {
        return time_in;
    }

    public static void setTime_in(String time_in) {
        Users.time_in = time_in;
    }

    public static String getTime_out() {
        return time_out;
    }

    public static void setTime_out(String time_out) {
        Users.time_out = time_out;
    }

    public static String getR_stock_left_supplier() {
        return r_stock_left_supplier;
    }

    public static void setR_stock_left_supplier(String r_stock_left_supplier) {
        Users.r_stock_left_supplier = r_stock_left_supplier;
    }

    public static to_cash_drawer getDrawer() {
        return drawer;
    }

    public static void setDrawer(to_cash_drawer drawer) {
        Users.drawer = drawer;
    }

    public static List<to_cash_drawer_checks> getChecks() {
        return checks;
    }

    public static void setChecks(List<to_cash_drawer_checks> checks) {
        Users.checks = checks;
    }

    public static String getM_banks() {
        return m_banks;
    }

    public static void setM_banks(String m_banks) {
        Users.m_banks = m_banks;
    }

    public static String getM_discount() {
        return m_discount;
    }

    public static void setM_discount(String m_discount) {
        Users.m_discount = m_discount;
    }

    public static String getM_customers() {
        return m_customers;
    }

    public static void setM_customers(String m_customers) {
        Users.m_customers = m_customers;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        Users.date_added = date_added;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIs_active() {
        return is_active;
    }

    public static void setIs_active(int is_active) {
        Users.is_active = is_active;
    }

    public static String getPassword() {
        try {
            if (password == null) {
                return "";
            } else {
                return password;
            }

        } catch (Exception e) {
            return "";
        }

    }

    public static void setPassword(String password) {
        Users.password = password;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public static void setScreen_name(String screen_name) {
        Users.screen_name = screen_name;
    }

    public int getUser_level() {
        return user_level;
    }

    public static void setUser_level(int user_level) {
        Users.user_level = user_level;
    }

    public String getUser_name() {
        return user_name;
    }

    public static void setUser_name(String user_name) {
        Users.user_name = user_name;
    }

    public static String getSession_no() {
        try {
            if (session_no == null) {
                return "";
            } else {
                return session_no;
            }

        } catch (Exception e) {
            return "";
        }
    }

    public static void setSession_no(String session_no) {
        Users.session_no = session_no;
    }

    public static String getM_category() {
        return m_category;
    }

    public static void setM_category(String m_category) {
        Users.m_category = m_category;
    }

    public static String getM_items() {
        return m_items;
    }

    public static void setM_items(String m_items) {
        Users.m_items = m_items;
    }

    public static String getM_suppliers() {
        return m_suppliers;
    }

    public static void setM_suppliers(String m_suppliers) {
        Users.m_suppliers = m_suppliers;
    }

    public static String getM_uom() {
        return m_uom;
    }

    public static void setM_uom(String m_uom) {
        Users.m_uom = m_uom;
    }

    public static String getM_users() {
        return m_users;
    }

    public static void setM_users(String m_users) {
        Users.m_users = m_users;
    }

    public static String getR_cash_count() {
        return r_cash_count;
    }

    public static void setR_cash_count(String r_cash_count) {
        Users.r_cash_count = r_cash_count;
    }

    public static String getR_receipts() {
        return r_receipts;
    }

    public static void setR_receipts(String r_receipts) {
        Users.r_receipts = r_receipts;
    }

    public static String getR_sales() {
        return r_sales;
    }

    public static void setR_sales(String r_sales) {
        Users.r_sales = r_sales;
    }

    public static String getR_stock_take() {
        return r_stock_take;
    }

    public static void setR_stock_take(String r_stock_take) {
        Users.r_stock_take = r_stock_take;
    }

    public static String getR_stock_transferred() {
        return r_stock_transferred;
    }

    public static void setR_stock_transferred(String r_stock_transferred) {
        Users.r_stock_transferred = r_stock_transferred;
    }

    public static String getT_receipts() {
        return t_receipts;
    }

    public static void setT_receipts(String t_receipts) {
        Users.t_receipts = t_receipts;
    }

    public static String getT_sales() {
        return t_sales;
    }

    public static void setT_sales(String t_sales) {
        Users.t_sales = t_sales;
    }

    public static String getT_stock_transfer() {
        return t_stock_transfer;
    }

    public static void setT_stock_transfer(String t_stock_transfer) {
        Users.t_stock_transfer = t_stock_transfer;
    }

    public static String get_ScreenName() {
        try {
            if (screen_name == null) {
                return "";
            } else {
                return screen_name;
            }

        } catch (Exception e) {
            return "";
        }
    }

    public static String get_UserName() {
        try {
            if (user_name == null) {
                return "";
            } else {
                return user_name;
            }

        } catch (Exception e) {
            return "";
        }
    }
}
