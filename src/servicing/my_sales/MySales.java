package servicing.my_sales;

//import servicing.accounts_receivable.S1_accounts_receivable;
//import servicing.accounts_receivable.S1_accounts_receivable_payments;
//import servicing.accounts_receivable.S1_accounts_receivable_payments.to_accounts_receivable_payments;
//import servicing.accounts_receivable.S1_sales_on_account;
//import servicing.cash_drawer.CashDrawer;
//import servicing.cash_drawer.CashDrawer_remittances;
//import servicing.customers.Customers;
//import servicing.disbursements.S1_disbursements.to_disbursements;
//import servicing.inventory.Dlg_inventory_uom;
import servicing.inventory.Inventory;
import servicing.inventory.Inventory_barcodes;
//import servicing.inventory.uom;
//import POS.prepaid_payments.Prepaid_payments.to_prepaid_payments;
//import POS.receipts.Warranties;
//import servicing.sales.Sales;

//import POS.touchscreen_reports.Srpt_sales_summary;
import servicing.users.MyUser;
import servicing.utils.MyConnection;
import servicing.utils.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.PoolConnection;

import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import synsoftech.util.DateType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guinness
 */
public class MySales {

    public static class tip {

        public double tip;
        public String prepaid_customer_name;
        public String prepaid_customer_id;
        public double prepaid_amount;
        public String charge_reference_no;
        public String charge_ar_no;
        public String charge_type;
        public String charge_customer_name;
        public String charge_customer_id;
        public double charge_amount;
        public int charge_days;

        public tip(double tip, String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, String charge_reference_no, String charge_ar_no, String charge_type, String charge_customer_name, String charge_customer_id, double charge_amount, int charge_days) {
            this.tip = tip;
            this.prepaid_customer_name = prepaid_customer_name;
            this.prepaid_customer_id = prepaid_customer_id;
            this.prepaid_amount = prepaid_amount;
            this.charge_reference_no = charge_reference_no;
            this.charge_ar_no = charge_ar_no;
            this.charge_type = charge_type;
            this.charge_customer_name = charge_customer_name;
            this.charge_customer_id = charge_customer_id;
            this.charge_amount = charge_amount;
            this.charge_days = charge_days;
        }

        public double getTip() {
            return tip;
        }

        public void setTip(double tip) {
            this.tip = tip;
        }

        public String getPrepaid_customer_name() {
            return prepaid_customer_name;
        }

        public void setPrepaid_customer_name(String prepaid_customer_name) {
            this.prepaid_customer_name = prepaid_customer_name;
        }

        public String getPrepaid_customer_id() {
            return prepaid_customer_id;
        }

        public void setPrepaid_customer_id(String prepaid_customer_id) {
            this.prepaid_customer_id = prepaid_customer_id;
        }

        public double getPrepaid_amount() {
            return prepaid_amount;
        }

        public void setPrepaid_amount(double prepaid_amount) {
            this.prepaid_amount = prepaid_amount;
        }

        public String getCharge_reference_no() {
            return charge_reference_no;
        }

        public void setCharge_reference_no(String charge_reference_no) {
            this.charge_reference_no = charge_reference_no;
        }

        public String getCharge_ar_no() {
            return charge_ar_no;
        }

        public void setCharge_ar_no(String charge_ar_no) {
            this.charge_ar_no = charge_ar_no;
        }

        public String getCharge_type() {
            return charge_type;
        }

        public void setCharge_type(String charge_type) {
            this.charge_type = charge_type;
        }

        public String getCharge_customer_name() {
            return charge_customer_name;
        }

        public void setCharge_customer_name(String charge_customer_name) {
            this.charge_customer_name = charge_customer_name;
        }

        public String getCharge_customer_id() {
            return charge_customer_id;
        }

        public void setCharge_customer_id(String charge_customer_id) {
            this.charge_customer_id = charge_customer_id;
        }

        public double getCharge_amount() {
            return charge_amount;
        }

        public void setCharge_amount(double charge_amount) {
            this.charge_amount = charge_amount;
        }

        public int getCharge_days() {
            return charge_days;
        }

        public void setCharge_days(int charge_days) {
            this.charge_days = charge_days;
        }

    }

    public static class sales {

//        public final int id;
//        public String sales_no;
//        public final String date_added;
//        public final String user_screen_name;
//        public final String user_id;
//        public final String session_no;
//        public final String remarks;
//        public double gross_amount;
//        public double amount_due;
//        public final int status;
//        public final int sales_type;
//        public double line_discount;
//        public final String customer_id;
//        public final String customer_name;
//        public final String discount_name;
//        public final double discount_rate;
//        public final double discount_amount;
//        public final String discount_customer_name;
//        public final String discount_customer_id;
//        public final String charge_type;
//        public final String charge_type_id;
//        public final String charge_reference_no;
//        public final String charge_customer_name;
//        public final String charge_customer_id;
//        public final double charge_amount;
//        public final String charge_date_applied;
//        public final String check_bank;
//        public final String check_no;
//        public final double check_amount;
//        public final String check_holder;
//        public final String check_date;
//        public final String credit_card_type;
//        public final double credit_card_rate;
//        public final double credit_card_amount;
//        public final String credit_card_no;
//        public final String credit_card_holder;
//        public final String credit_card_approval_code;
//        public final String gift_certificate_from;
//        public final String gift_certificate_description;
//        public final String gift_certificate_no;
//        public final double gift_certificate_amount;
//        public final String prepaid_customer_name;
//        public final String prepaid_customer_id;
//        public final double prepaid_amount;
//        public final double addtl_amount;
//        public final double wtax;
//        public final String branch;
//        public final String branch_id;
//        public final String location;
//        public final String location_id;
//        public final List<MySales_Items.items> items;
//        public final int charge_days;
//        public final String online_bank;
//        public final String online_reference_no;
//        public final double online_amount;
//        public final String online_holder;
//        public final String online_date;
//        public final String ref_or_no;
//        public final String ref_si_no;
//        public final String ref_cr_no;

//        public sales(int id, String sales_no, String date_added, String user_screen_name, String user_id, String session_no, String remarks, double gross_amount,
//                double amount_due, int status, int sales_type, double line_discount, String customer_id, String customer_name, String discount_name, double discount_rate,
//                double discount_amount, String discount_customer_name, String discount_customer_id, String charge_type, String charge_type_id, String charge_reference_no,
//                String charge_customer_name, String charge_customer_id, double charge_amount, String charge_date_applied, String check_bank, String check_no, double check_amount, String check_holder,
//                String check_date, String credit_card_type, double credit_card_rate, double credit_card_amount, String credit_card_no, String credit_card_holder,
//                String credit_card_approval_code, String gift_certificate_from, String gift_certificate_description, String gift_certificate_no, double gift_certificate_amount,
//                String prepaid_customer_name, String prepaid_customer_id, double prepaid_amount, double addtl_amount, double wtax, String branch, String branch_id,
//                String location, String location_id, List<MySales_Items.items> items, int charge_days,
//                String online_bank, String online_reference_no, double online_amount, String online_holder, String online_date, String ref_or_no, String ref_si_no, String ref_cr_no) {
//            this.id = id;
//            this.sales_no = sales_no;
//            this.date_added = date_added;
//            this.user_screen_name = user_screen_name;
//            this.user_id = user_id;
//            this.session_no = session_no;
//            this.remarks = remarks;
//            this.gross_amount = gross_amount;
//            this.amount_due = amount_due;
//            this.status = status;
//            this.sales_type = sales_type;
//            this.line_discount = line_discount;
//            this.customer_id = customer_id;
//            this.customer_name = customer_name;
//            this.discount_name = discount_name;
//            this.discount_rate = discount_rate;
//            this.discount_amount = discount_amount;
//            this.discount_customer_name = discount_customer_name;
//            this.discount_customer_id = discount_customer_id;
//            this.charge_type = charge_type;
//            this.charge_type_id = charge_type_id;
//            this.charge_reference_no = charge_reference_no;
//            this.charge_customer_name = charge_customer_name;
//            this.charge_customer_id = charge_customer_id;
//            this.charge_amount = charge_amount;
//            this.charge_date_applied = charge_date_applied;
//            this.check_bank = check_bank;
//            this.check_no = check_no;
//            this.check_amount = check_amount;
//            this.check_holder = check_holder;
//            this.check_date = check_date;
//            this.credit_card_type = credit_card_type;
//            this.credit_card_rate = credit_card_rate;
//            this.credit_card_amount = credit_card_amount;
//            this.credit_card_no = credit_card_no;
//            this.credit_card_holder = credit_card_holder;
//            this.credit_card_approval_code = credit_card_approval_code;
//            this.gift_certificate_from = gift_certificate_from;
//            this.gift_certificate_description = gift_certificate_description;
//            this.gift_certificate_no = gift_certificate_no;
//            this.gift_certificate_amount = gift_certificate_amount;
//            this.prepaid_customer_name = prepaid_customer_name;
//            this.prepaid_customer_id = prepaid_customer_id;
//            this.prepaid_amount = prepaid_amount;
//            this.addtl_amount = addtl_amount;
//            this.wtax = wtax;
//            this.branch = branch;
//            this.branch_id = branch_id;
//            this.location = location;
//            this.location_id = location_id;
//            this.items = items;
//            this.charge_days = charge_days;
//            this.online_bank = online_bank;
//            this.online_reference_no = online_reference_no;
//            this.online_amount = online_amount;
//            this.online_holder = online_holder;
//            this.online_date = online_date;
//            this.ref_or_no = ref_or_no;
//            this.ref_si_no = ref_si_no;
//            this.ref_cr_no = ref_cr_no;
//        }

//        public String getSales_no() {
//            return sales_no;
//        }
//
//        public void setSales_no(String sales_no) {
//            this.sales_no = sales_no;
//        }
//
//        public double getGross_amount() {
//            return gross_amount;
//        }
//
//        public void setGross_amount(double gross_amount) {
//            this.gross_amount = gross_amount;
//        }
//
//        public double getAmount_due() {
//            return amount_due;
//        }
//
//        public void setAmount_due(double amount_due) {
//            this.amount_due = amount_due;
//        }
//
//        public double getLine_discount() {
//            return line_discount;
//        }
//
//        public void setLine_discount(double line_discount) {
//            this.line_discount = line_discount;
//        }

    }

//    public static String add_sales(sales to_sales, List<MySales_Items.items> items, String location_ids, List<Warranties.to_warranties> slip_nos) throws SQLException {
//        try {
//            Connection conn = MyConnection.connect();
//            String c_date = DateType.sf.format(new Date());
//            if (!to_sales.check_date.isEmpty()) {
//                c_date = to_sales.check_date;
//            }
//
//            conn.setAutoCommit(false);
//
//            String sales_no = "000000000000";
//            String s100 = "select max(id) from sales where location_id ='" + location_ids + "' ";
//            Statement stmt100 = conn.createStatement();
//            ResultSet rs100 = stmt100.executeQuery(s100);
//            if (rs100.next()) {
//                sales_no = rs100.getString(1);
//                String s200 = "select sales_no from sales where id='" + sales_no + "' ";
//                Statement stmt200 = conn.createStatement();
//                ResultSet rs200 = stmt200.executeQuery(s200);
//                if (rs200.next()) {
//                    sales_no = rs200.getString(1);
//                }
//            }
//
//            if (sales_no == null) {
//                sales_no = location_ids + "|" + "000000000001";
//
//            } else {
//                sales_no = ReceiptIncrementor.increment(sales_no);
//            }
//
//            String s0 = "insert into sales("
//                    + " sales_no"
//                    + ",date_added"
//                    + ",user_screen_name"
//                    + ",user_id"
//                    + ",session_no"
//                    + ",remarks"
//                    + ",gross_amount"
//                    + ",amount_due"
//                    + ",status"
//                    + ",sales_type"
//                    + ",line_discount"
//                    + ",customer_id"
//                    + ",customer_name"
//                    + ",discount_name"
//                    + ",discount_rate"
//                    + ",discount_amount"
//                    + ",discount_customer_name"
//                    + ",discount_customer_id"
//                    + ",charge_type"
//                    + ",charge_type_id"
//                    + ",charge_reference_no"
//                    + ",charge_customer_name"
//                    + ",charge_customer_id"
//                    + ",charge_amount"
//                    + ",check_bank"
//                    + ",check_no"
//                    + ",check_amount"
//                    + ",check_holder"
//                    + ",check_date"
//                    + ",credit_card_type"
//                    + ",credit_card_rate"
//                    + ",credit_card_amount"
//                    + ",credit_card_no"
//                    + ",credit_card_holder"
//                    + ",credit_card_approval_code"
//                    + ",gift_certificate_from"
//                    + ",gift_certificate_description"
//                    + ",gift_certificate_no"
//                    + ",gift_certificate_amount"
//                    + ",prepaid_customer_name"
//                    + ",prepaid_customer_id"
//                    + ",prepaid_amount"
//                    + ",addtl_amount"
//                    + ",wtax"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + ",online_bank"
//                    + ",online_reference_no"
//                    + ",online_amount"
//                    + ",online_holder"
//                    + ",online_date"
//                    + ",ref_or_no"
//                    + ",ref_si_no"
//                    + ",ref_cr_no"
//                    + ")values("
//                    + ":sales_no"
//                    + ",:date_added"
//                    + ",:user_screen_name"
//                    + ",:user_id"
//                    + ",:session_no"
//                    + ",:remarks"
//                    + ",:gross_amount"
//                    + ",:amount_due"
//                    + ",:status"
//                    + ",:sales_type"
//                    + ",:line_discount"
//                    + ",:customer_id"
//                    + ",:customer_name"
//                    + ",:discount_name"
//                    + ",:discount_rate"
//                    + ",:discount_amount"
//                    + ",:discount_customer_name"
//                    + ",:discount_customer_id"
//                    + ",:charge_type"
//                    + ",:charge_type_id"
//                    + ",:charge_reference_no"
//                    + ",:charge_customer_name"
//                    + ",:charge_customer_id"
//                    + ",:charge_amount"
//                    + ",:check_bank"
//                    + ",:check_no"
//                    + ",:check_amount"
//                    + ",:check_holder"
//                    + ",:check_date"
//                    + ",:credit_card_type"
//                    + ",:credit_card_rate"
//                    + ",:credit_card_amount"
//                    + ",:credit_card_no"
//                    + ",:credit_card_holder"
//                    + ",:credit_card_approval_code"
//                    + ",:gift_certificate_from"
//                    + ",:gift_certificate_description"
//                    + ",:gift_certificate_no"
//                    + ",:gift_certificate_amount"
//                    + ",:prepaid_customer_name"
//                    + ",:prepaid_customer_id"
//                    + ",:prepaid_amount"
//                    + ",:addtl_amount"
//                    + ",:wtax"
//                    + ",:branch"
//                    + ",:branch_id"
//                    + ",:location"
//                    + ",:location_id"
//                    + ",:online_bank"
//                    + ",:online_reference_no"
//                    + ",:online_amount"
//                    + ",:online_holder"
//                    + ",:online_date"
//                    + ",:ref_or_no"
//                    + ",:ref_si_no"
//                    + ",:ref_cr_no"
//                    + ")";
//
//            s0 = SqlStringUtil.parse(s0)
//                    .setString("sales_no", sales_no)
//                    .setString("date_added", to_sales.date_added)
//                    .setString("user_screen_name", to_sales.user_screen_name)
//                    .setString("user_id", to_sales.user_id)
//                    .setString("session_no", to_sales.session_no)
//                    .setString("remarks", to_sales.remarks)
//                    .setNumber("gross_amount", to_sales.gross_amount)
//                    .setNumber("amount_due", to_sales.amount_due)
//                    .setNumber("status", to_sales.status)
//                    .setNumber("sales_type", to_sales.sales_type)
//                    .setNumber("line_discount", to_sales.line_discount)
//                    .setString("customer_id", to_sales.customer_id)
//                    .setString("customer_name", to_sales.customer_name)
//                    .setString("discount_name", to_sales.discount_name)
//                    .setNumber("discount_rate", to_sales.discount_rate)
//                    .setNumber("discount_amount", to_sales.discount_amount)
//                    .setString("discount_customer_name", to_sales.discount_customer_name)
//                    .setString("discount_customer_id", to_sales.discount_customer_id)
//                    .setString("charge_type", to_sales.charge_type)
//                    .setString("charge_type_id", to_sales.charge_type_id)
//                    .setString("charge_reference_no", to_sales.charge_reference_no)
//                    .setString("charge_customer_name", to_sales.charge_customer_name)
//                    .setString("charge_customer_id", to_sales.charge_customer_id)
//                    .setNumber("charge_amount", to_sales.charge_amount)
//                    .setString("check_bank", to_sales.check_bank)
//                    .setString("check_no", to_sales.check_no)
//                    .setNumber("check_amount", to_sales.check_amount)
//                    .setString("check_holder", to_sales.check_holder)
//                    .setString("check_date", c_date)
//                    .setString("credit_card_type", to_sales.credit_card_type)
//                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
//                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
//                    .setString("credit_card_no", to_sales.credit_card_no)
//                    .setString("credit_card_holder", to_sales.credit_card_holder)
//                    .setString("credit_card_approval_code", to_sales.credit_card_approval_code)
//                    .setString("gift_certificate_from", to_sales.gift_certificate_from)
//                    .setString("gift_certificate_description", to_sales.gift_certificate_description)
//                    .setString("gift_certificate_no", to_sales.gift_certificate_no)
//                    .setNumber("gift_certificate_amount", to_sales.gift_certificate_amount)
//                    .setString("prepaid_customer_name", to_sales.prepaid_customer_name)
//                    .setString("prepaid_customer_id", to_sales.prepaid_customer_id)
//                    .setNumber("prepaid_amount", to_sales.prepaid_amount)
//                    .setNumber("addtl_amount", to_sales.addtl_amount)
//                    .setNumber("wtax", to_sales.wtax)
//                    .setString("branch", to_sales.branch)
//                    .setString("branch_id", to_sales.branch_id)
//                    .setString("location", to_sales.location)
//                    .setString("location_id", to_sales.location_id)
//                    .setString("online_bank", to_sales.online_bank)
//                    .setString("online_reference_no", to_sales.online_reference_no)
//                    .setNumber("online_amount", to_sales.online_amount)
//                    .setString("online_holder", to_sales.online_holder)
//                    .setString("online_date", to_sales.online_date)
//                    .setString("ref_or_no", to_sales.ref_or_no)
//                    .setString("ref_si_no", to_sales.ref_si_no)
//                    .setString("ref_cr_no", to_sales.ref_cr_no)
//                    .ok();
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.addBatch(s0);
//
//            if (!to_sales.session_no.equalsIgnoreCase("000000000000")) {
//                String s3 = " update orders set status='" + 1 + "' where sales_no='" + to_sales.session_no + "'";
//                stmt.addBatch(s3);
//                String s4 = " update order_items set status='" + 1 + "' where sales_no='" + to_sales.session_no + "'";
//                stmt.addBatch(s4);
//            }
//
//            if (to_sales.prepaid_amount > 0) {
//                String prep = "select "
//                        + "id"
//                        + ",customer_name"
//                        + ",customer_no"
//                        + ",contact_no"
//                        + ",credit_limit"
//                        + ",address"
//                        + ",term"
//                        + ",location"
//                        + ",balance"
//                        + ",discount"
//                        + ",prepaid"
//                        + " from customers "
//                        + " where id='" + to_sales.prepaid_customer_id + "' ";
//
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs = stmt2.executeQuery(prep);
//                double prepaid = 0;
//                if (rs.next()) {
//                    prepaid = rs.getDouble(11);
//                }
//                prepaid = prepaid - to_sales.prepaid_amount;
//                String s3 = "update customers set prepaid='" + prepaid + "' "
//                        + " where id='" + to_sales.prepaid_customer_id + "' "
//                        + " ";
//
//                s3 = SqlStringUtil.parse(s3)
//                        .ok();
//                stmt.addBatch(s3);
//            }
//
//            if (to_sales.charge_amount > 0) {
//
//                int id = -1;
//                String soa_type = to_sales.charge_type;
//                String soa_type_id = to_sales.charge_type_id;
//                String soa_date = DateType.sf.format(new Date());
//
//                String date_added = to_sales.date_added;
//                String added_by = Users.user_name;
//                String reference_no = to_sales.charge_reference_no;
//                String client_name = to_sales.charge_customer_name;
//                String client_id = to_sales.charge_customer_id;
//                double amount = to_sales.charge_amount;
//                S1_sales_on_account.to_sales_on_account to = new S1_sales_on_account.to_sales_on_account(id, soa_type, soa_type_id, soa_date, date_added, added_by, reference_no, client_name, client_id, amount);
//
//                String s10 = "insert into sales_on_account("
//                        + "soa_type"
//                        + ",soa_type_id"
//                        + ",soa_date"
//                        + ",date_added"
//                        + ",added_by"
//                        + ",reference_no"
//                        + ",client_name"
//                        + ",client_id"
//                        + ",amount"
//                        + ")values("
//                        + ":soa_type"
//                        + ",:soa_type_id"
//                        + ",:soa_date"
//                        + ",:date_added"
//                        + ",:added_by"
//                        + ",:reference_no"
//                        + ",:client_name"
//                        + ",:client_id"
//                        + ",:amount"
//                        + ")";
//
//                s10 = SqlStringUtil.parse(s10)
//                        .setString("soa_type", to.soa_type)
//                        .setString("soa_type_id", to.soa_type_id)
//                        .setString("soa_date", to.soa_date)
//                        .setString("date_added", to_sales.date_added)
//                        .setString("added_by", to.added_by)
//                        .setString("reference_no", to.reference_no)
//                        .setString("client_name", to.client_name)
//                        .setString("client_id", to.client_id)
//                        .setNumber("amount", to.amount)
//                        .ok();
//                stmt.addBatch(s10);
//
//                //soa 
//                String customer_id = to_sales.charge_customer_id;
//                String customer_name = to_sales.charge_customer_name;
//                String ar_no = S1_accounts_receivable.increment_id_conn(to_sales.branch_id, conn);
//                String user_name = "";
//                if (Users.user_name == null) {
//                    user_name = "";
//                }
//                double discount_amount = 0;
//                double discount_rate = 0;
//                String discount = "";
//                int status = 0;
//                double term = to_sales.charge_days;
//                String date_applied = to_sales.charge_date_applied;
//                double paid = 0;
//                String date_paid = date_applied;
//                String remarks = "";
//                String type = "AR";
//                String or_no = "";
//                String ci_no = to_sales.charge_reference_no;
//                String trust_receipt = "";
//                String soa_id = S1_sales_on_account.increment_id_conn(conn);
//                String user_id = MyUser.getUser_id();
//                String user_screen_name = MyUser.getUser_screen_name();
//                String branch = to_sales.branch;
//                String branch_id = to_sales.branch_id;
//                String location = to_sales.location;
//                String location_id = to_sales.location_id;
//
//                S1_accounts_receivable.to_accounts_receivable to2 = new S1_accounts_receivable.to_accounts_receivable(true, -1, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, 0, 0, 0, ci_no, trust_receipt, soa_id, soa_type, soa_type_id, reference_no, user_id, user_screen_name, branch, branch_id, location, location_id);
//
//                String s11 = "insert into  accounts_receivable("
//                        + "customer_id"
//                        + ",customer_name"
//                        + ",ar_no"
//                        + ",date_added"
//                        + ",user_name"
//                        + ",amount"
//                        + ",discount_amount"
//                        + ",discount_rate"
//                        + ",discount"
//                        + ",status"
//                        + ",term"
//                        + ",date_applied"
//                        + ",paid"
//                        + ",date_paid"
//                        + ",remarks"
//                        + ",type"
//                        + ",or_no"
//                        + ",ci_no"
//                        + ",trust_receipt"
//                        + ",soa_id"
//                        + ",soa_type"
//                        + ",soa_type_id"
//                        + ",reference_no"
//                        + ",user_id"
//                        + ",user_screen_name"
//                        + ",branch"
//                        + ",branch_id"
//                        + ",location"
//                        + ",location_id"
//                        + ")values("
//                        + ":customer_id"
//                        + ",:customer_name"
//                        + ",:ar_no"
//                        + ",:date_added"
//                        + ",:user_name"
//                        + ",:amount"
//                        + ",:discount_amount"
//                        + ",:discount_rate"
//                        + ",:discount"
//                        + ",:status"
//                        + ",:term"
//                        + ",:date_applied"
//                        + ",:paid"
//                        + ",:date_paid"
//                        + ",:remarks"
//                        + ",:type"
//                        + ",:or_no"
//                        + ",:ci_no"
//                        + ",:trust_receipt"
//                        + ",:soa_id"
//                        + ",:soa_type"
//                        + ",:soa_type_id"
//                        + ",:reference_no"
//                        + ",:user_id"
//                        + ",:user_screen_name"
//                        + ",:branch"
//                        + ",:branch_id"
//                        + ",:location"
//                        + ",:location_id"
//                        + ")";
//
//                s11 = SqlStringUtil.parse(s11).
//                        setString("customer_id", to2.customer_id).
//                        setString("customer_name", to2.customer_name).
//                        setString("ar_no", to2.ar_no).
//                        setString("date_added", to_sales.date_added).
//                        setString("user_name", to2.user_name).
//                        setNumber("amount", to2.amount).
//                        setNumber("discount_amount", to2.discount_amount).
//                        setNumber("discount_rate", to2.discount_rate).
//                        setString("discount", to2.discount).
//                        setNumber("status", to2.status).
//                        setNumber("term", to2.term).
//                        setString("date_applied", to2.date_applied).
//                        setNumber("paid", to2.paid).
//                        setString("date_paid", to2.date_paid).
//                        setString("remarks", to2.remarks).
//                        setString("type", to2.type).
//                        setString("or_no", to2.or_no).
//                        setString("ci_no", to2.ci_no).
//                        setString("trust_receipt", to2.trust_receipt).
//                        setString("soa_id", to2.soa_id).
//                        setString("soa_type", to2.soa_type).
//                        setString("soa_type_id", to2.soa_type_id).
//                        setString("reference_no", to2.reference_no).
//                        setString("user_id", to2.user_id).
//                        setString("user_screen_name", to2.user_screen_name).
//                        setString("branch", to2.branch).
//                        setString("branch_id", to2.branch_id).
//                        setString("location", to2.location).
//                        setString("location_id", to2.location_id).
//                        ok();
//
//                stmt.addBatch(s11);
//
//                double cus_balance = 0;
//                try {
//                    Customers.to_customers cus = S1_accounts_receivable.ret_customer_balance_conn(to2.customer_id, conn);
//                    cus_balance = cus.balance;
//                } catch (Exception e) {
//                    cus_balance = 0;
//                }
//                double new_balance = cus_balance + to2.amount;
//                String s12 = "update  customers set "
//                        + "balance= :balance"
//                        + " where "
//                        + " customer_no ='" + to2.customer_id + "' "
//                        + " ";
//                s12 = SqlStringUtil.parse(s12).
//                        setNumber("balance", new_balance).
//                        ok();
//                stmt.addBatch(s12);
//
//            }
//            for (MySales_Items.items to_sale_items : items) {
//                String s2 = "insert into sale_items("
//                        + "sales_no"
//                        + ",item_code"
//                        + ",barcode"
//                        + ",description"
//                        + ",generic_name"
//                        + ",item_type"
//                        + ",supplier_name"
//                        + ",supplier_id"
//                        + ",serial_no"
//                        + ",product_qty"
//                        + ",unit"
//                        + ",conversion"
//                        + ",selling_price"
//                        + ",date_added"
//                        + ",user_id"
//                        + ",user_screen_name"
//                        + ",status"
//                        + ",is_vatable"
//                        + ",selling_type"
//                        + ",discount_name"
//                        + ",discount_rate"
//                        + ",discount_amount"
//                        + ",discount_customer_name"
//                        + ",discount_customer_id"
//                        + ",branch"
//                        + ",branch_code"
//                        + ",location"
//                        + ",location_id"
//                        + ",category"
//                        + ",category_id"
//                        + ",classification"
//                        + ",classification_id"
//                        + ",sub_classification"
//                        + ",sub_classification_id"
//                        + ",brand"
//                        + ",brand_id"
//                        + ",model"
//                        + ",model_id"
//                        + ",addtl_amount"
//                        + ",wtax"
//                        + ",cost"
//                        + ")values("
//                        + ":sales_no"
//                        + ",:item_code"
//                        + ",:barcode"
//                        + ",:description"
//                        + ",:generic_name"
//                        + ",:item_type"
//                        + ",:supplier_name"
//                        + ",:supplier_id"
//                        + ",:serial_no"
//                        + ",:product_qty"
//                        + ",:unit"
//                        + ",:conversion"
//                        + ",:selling_price"
//                        + ",:date_added"
//                        + ",:user_id"
//                        + ",:user_screen_name"
//                        + ",:status"
//                        + ",:is_vatable"
//                        + ",:selling_type"
//                        + ",:discount_name"
//                        + ",:discount_rate"
//                        + ",:discount_amount"
//                        + ",:discount_customer_name"
//                        + ",:discount_customer_id"
//                        + ",:branch"
//                        + ",:branch_code"
//                        + ",:location"
//                        + ",:location_id"
//                        + ",:category"
//                        + ",:category_id"
//                        + ",:classification"
//                        + ",:classification_id"
//                        + ",:sub_classification"
//                        + ",:sub_classification_id"
//                        + ",:brand"
//                        + ",:brand_id"
//                        + ",:model"
//                        + ",:model_id"
//                        + ",:addtl_amount"
//                        + ",:wtax"
//                        + ",:cost"
//                        + ")";
//
//                s2 = SqlStringUtil.parse(s2)
//                        .setString("sales_no", sales_no)
//                        .setString("item_code", to_sale_items.item_code)
//                        .setString("barcode", to_sale_items.barcode)
//                        .setString("description", to_sale_items.description)
//                        .setString("generic_name", to_sale_items.generic_name)
//                        .setString("item_type", to_sale_items.item_type)
//                        .setString("supplier_name", to_sale_items.supplier_name)
//                        .setString("supplier_id", to_sale_items.supplier_id)
//                        .setString("serial_no", to_sale_items.serial_no)
//                        .setNumber("product_qty", to_sale_items.product_qty * to_sale_items.conversion)
//                        .setString("unit", to_sale_items.unit)
//                        .setNumber("conversion", to_sale_items.conversion)
//                        .setNumber("selling_price", to_sale_items.selling_price)
//                        .setString("date_added", to_sales.date_added)
//                        .setString("user_id", to_sales.user_id)
//                        .setString("user_screen_name", to_sales.user_screen_name)
//                        .setNumber("status", 0)
//                        .setNumber("is_vatable", to_sale_items.is_vatable)
//                        .setNumber("selling_type", to_sale_items.selling_type)
//                        .setString("discount_name", to_sale_items.discount_name)
//                        .setNumber("discount_rate", to_sale_items.discount_rate)
//                        .setNumber("discount_amount", to_sale_items.discount_amount)
//                        .setString("discount_customer_name", to_sale_items.discount_customer_name)
//                        .setString("discount_customer_id", to_sale_items.discount_customer_id)
//                        .setString("branch", to_sale_items.branch)
//                        .setString("branch_code", to_sale_items.branch_code)
//                        .setString("location", to_sale_items.location)
//                        .setString("location_id", to_sale_items.location_id)
//                        .setString("category", to_sale_items.category)
//                        .setString("category_id", to_sale_items.category_id)
//                        .setString("classification", to_sale_items.classification)
//                        .setString("classification_id", to_sale_items.classification_id)
//                        .setString("sub_classification", to_sale_items.sub_classification)
//                        .setString("sub_classification_id", to_sale_items.sub_classification_id)
//                        .setString("brand", to_sale_items.brand)
//                        .setString("brand_id", to_sale_items.brand_id)
//                        .setString("model", to_sale_items.model)
//                        .setString("model_id", to_sale_items.model_id)
//                        .setNumber("addtl_amount", to_sale_items.addtl_amount)
//                        .setNumber("wtax", to_sale_items.wtax)
//                        .setNumber("cost", to_sale_items.cost)
//                        .ok();
//
//                PreparedStatement stmt5 = conn.prepareStatement(s2);
//                stmt5.execute();
//
//                double tt_qty = 0;
//                try {
////                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to_conn(to_sale_items.item_code, to_sale_items.barcode, to_sale_items.location_id, conn);
//                    String s20 = "select "
//                            + " product_qty"
//                            + " from inventory_barcodes where "
//                            + " main_barcode='" + to_sale_items.item_code + "' and location_id='" + to_sale_items.location_id + "'"
//                            + " ";
////                    System.out.println(s20);
//                    Statement stmt20 = conn.createStatement();
//                    ResultSet rs20 = stmt20.executeQuery(s20);
//                    while (rs20.next()) {
//                        tt_qty = rs20.getDouble(1);
//                    }
//
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//
//                double new_qty = tt_qty - (to_sale_items.conversion * to_sale_items.product_qty);
////                System.out.println("Item: " + to_sale_items.item_code + " = " + to_sale_items.description + " : " + tt_qty);
////                System.out.println("    New Qty: " + tt_qty + " Conversion: " + to_sale_items.conversion + " , product_qty: " + to_sale_items.product_qty);
////                String serial_no = Segregator.this_shit(tt.serial_no, to_sale_items.serial_no);
//                String s4 = " update inventory_barcodes set "
//                        + " product_qty='" + new_qty + "'"
//                        + " where  main_barcode= '" + to_sale_items.item_code + "' and location_id='" + to_sale_items.location_id + "' "
//                        + "";
//                PreparedStatement stmt4 = conn.prepareStatement(s4);
//                stmt4.execute();
////                stmt.addBatch(s4);
////                Lg.s(Inventory.class, "Successfully Updated");
//
//            }
//
//            if (!slip_nos.isEmpty()) {
//                for (Warranties.to_warranties to_sale_slip_nos : slip_nos) {
//
////                    Insert to Sale Slip Nos
//                    String s13 = "insert into sale_slip_nos("
//                            + "sales_no"
//                            + ",transaction_no"
//                            + ",slip_no"
//                            + ",no_of_items"
//                            + ",created_at"
//                            + ",created_by"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + ")values("
//                            + ":sales_no"
//                            + ",:transaction_no"
//                            + ",:slip_no"
//                            + ",:no_of_items"
//                            + ",:created_at"
//                            + ",:created_by"
//                            + ",:branch"
//                            + ",:branch_id"
//                            + ",:location"
//                            + ",:location_id"
//                            + ")";
//
//                    s13 = SqlStringUtil.parse(s13)
//                            .setString("sales_no", to_sales.sales_no)
//                            .setString("transaction_no", to_sale_slip_nos.transaction_no)
//                            .setString("slip_no", to_sale_slip_nos.slip_no)
//                            .setString("no_of_items", to_sale_slip_nos.created_by)
//                            .setString("created_at", to_sale_slip_nos.created_at)
//                            .setString("created_by", to_sales.user_id)
//                            .setString("branch", to_sale_slip_nos.branch)
//                            .setString("branch_id", to_sale_slip_nos.branch_id)
//                            .setString("location", to_sale_slip_nos.location)
//                            .setString("location_id", to_sale_slip_nos.location_id)
//                            .ok();
//                    stmt.addBatch(s13);
//
////                    Update warranty to zero
//                    String s14 = "update warranties set "
//                            + " status= :status "
//                            + " where id='" + to_sale_slip_nos.id + "' "
//                            + " ";
//
//                    s14 = SqlStringUtil.parse(s14)
//                            .setNumber("status", 1)
//                            .ok();
//
//                    stmt.addBatch(s14);
//
////                  Select warranty items
//                    String s20 = "select "
//                            + "id"
//                            + ",qty"
//                            + ",main_barcode"
//                            + ",branch"
//                            + ",branch_id"
//                            + ",location"
//                            + ",location_id"
//                            + " from warranty_items"
//                            + " where transaction_no='" + to_sale_slip_nos.transaction_no + "'";
//
//                    Statement stmt20 = conn.createStatement();
//                    ResultSet rs20 = stmt20.executeQuery(s20);
//                    while (rs20.next()) {
//                        int ids = rs20.getInt(1);
//                        double qty = rs20.getDouble(2);
//                        String main_barcode = rs20.getString(3);
//                        String branch = rs20.getString(4);
//                        String branch_id = rs20.getString(5);
//                        String location = rs20.getString(6);
//                        String location_id = rs20.getString(7);
//
////                    Update warranty items                        
//                        String s15 = "update warranty_items set "
//                                + " status= :status "
//                                + " where id='" + ids + "' "
//                                + " ";
//
//                        s15 = SqlStringUtil.parse(s15)
//                                .setNumber("status", 1)
//                                .ok();
//                        stmt.addBatch(s15);
//
////                        Search qty items
//                        String s10 = "select "
//                                + " product_qty"
//                                + ",conversion"
//                                + " from inventory_barcodes where "
//                                + " main_barcode='" + main_barcode + "' and location_id='" + location_id + "'"
//                                + " ";
//                        Statement stmt10 = conn.createStatement();
//                        ResultSet rs10 = stmt10.executeQuery(s10);
//                        double product_qty = 0;
//                        double conversion = 0;
//                        while (rs10.next()) {
//                            product_qty = rs10.getDouble(1);
//                            conversion = rs10.getDouble(2);
//                        }
//
//                        double new_qty = product_qty - (conversion * qty);
//
//                        String s4 = "update inventory_barcodes set "
//                                + " product_qty='" + new_qty + "'"
//                                + " where  main_barcode= '" + main_barcode + "' and location_id='" + location_id + "' "
//                                + "";
//
//                        PreparedStatement stmt2 = conn.prepareStatement(s4);
//                        stmt2.execute();
//
//                    }
//                }
//
//            }
//
//            stmt.executeBatch();
//            conn.commit();
//            Lg.s(MySales.class, "Item Committed");
//            Lg.s(MySales.class, "Successfully Added");
//
//            return sales_no;
//        } catch (SQLException e) {
//            throw new SQLException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static void edit_sales(sales to_sales) {
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "update sales set "
//                    + "sales_no= :sales_no"
//                    + ",date_added= :date_added"
//                    + ",user_screen_name= :user_screen_name"
//                    + ",user_id= :user_id"
//                    + ",session_no= :session_no"
//                    + ",remarks= :remarks"
//                    + ",gross_amount= :gross_amount"
//                    + ",amount_due= :amount_due"
//                    + ",status= :status"
//                    + ",sales_type= :sales_type"
//                    + ",line_discount= :line_discount"
//                    + ",customer_id= :customer_id"
//                    + ",customer_name= :customer_name"
//                    + ",discount_name= :discount_name"
//                    + ",discount_rate= :discount_rate"
//                    + ",discount_amount= :discount_amount"
//                    + ",discount_customer_name= :discount_customer_name"
//                    + ",discount_customer_id= :discount_customer_id"
//                    + ",charge_type= :charge_type"
//                    + ",charge_type_id= :charge_type_id"
//                    + ",charge_reference_no= :charge_reference_no"
//                    + ",charge_customer_name= :charge_customer_name"
//                    + ",charge_customer_id= :charge_customer_id"
//                    + ",charge_amount= :charge_amount"
//                    + ",check_bank= :check_bank"
//                    + ",check_no= :check_no"
//                    + ",check_amount= :check_amount"
//                    + ",check_holder= :check_holder"
//                    + ",check_date= :check_date"
//                    + ",credit_card_type= :credit_card_type"
//                    + ",credit_card_rate= :credit_card_rate"
//                    + ",credit_card_amount= :credit_card_amount"
//                    + ",credit_card_no= :credit_card_no"
//                    + ",credit_card_holder= :credit_card_holder"
//                    + ",credit_card_approval_code= :credit_card_approval_code"
//                    + ",gift_certificate_from= :gift_certificate_from"
//                    + ",gift_certificate_description= :gift_certificate_description"
//                    + ",gift_certificate_no= :gift_certificate_no"
//                    + ",gift_certificate_amount= :gift_certificate_amount"
//                    + ",prepaid_customer_name= :prepaid_customer_name"
//                    + ",prepaid_customer_id= :prepaid_customer_id"
//                    + ",prepaid_amount= :prepaid_amount"
//                    + ",addtl_amount= :addtl_amount"
//                    + ",wtax= :wtax"
//                    + ",branch= :branch"
//                    + ",branch_id= :branch_id"
//                    + ",location= :location"
//                    + ",location_id= :location_id"
//                    + " where "
//                    + " id ='" + to_sales.id + "' "
//                    + " ";
//
//            s0 = SqlStringUtil.parse(s0)
//                    .setString("sales_no", to_sales.sales_no)
//                    .setString("date_added", to_sales.date_added)
//                    .setString("user_screen_name", to_sales.user_screen_name)
//                    .setString("user_id", to_sales.user_id)
//                    .setString("session_no", to_sales.session_no)
//                    .setString("remarks", to_sales.remarks)
//                    .setNumber("gross_amount", to_sales.gross_amount)
//                    .setNumber("amount_due", to_sales.amount_due)
//                    .setNumber("status", to_sales.status)
//                    .setNumber("sales_type", to_sales.sales_type)
//                    .setNumber("line_discount", to_sales.line_discount)
//                    .setString("customer_id", to_sales.customer_id)
//                    .setString("customer_name", to_sales.customer_name)
//                    .setString("discount_name", to_sales.discount_name)
//                    .setNumber("discount_rate", to_sales.discount_rate)
//                    .setNumber("discount_amount", to_sales.discount_amount)
//                    .setString("discount_customer_name", to_sales.discount_customer_name)
//                    .setString("discount_customer_id", to_sales.discount_customer_id)
//                    .setString("charge_type", to_sales.charge_type)
//                    .setString("charge_type_id", to_sales.charge_type_id)
//                    .setString("charge_reference_no", to_sales.charge_reference_no)
//                    .setString("charge_customer_name", to_sales.charge_customer_name)
//                    .setString("charge_customer_id", to_sales.charge_customer_id)
//                    .setNumber("charge_amount", to_sales.charge_amount)
//                    .setString("check_bank", to_sales.check_bank)
//                    .setString("check_no", to_sales.check_no)
//                    .setNumber("check_amount", to_sales.check_amount)
//                    .setString("check_holder", to_sales.check_holder)
//                    .setString("check_date", to_sales.check_date)
//                    .setString("credit_card_type", to_sales.credit_card_type)
//                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
//                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
//                    .setString("credit_card_no", to_sales.credit_card_no)
//                    .setString("credit_card_holder", to_sales.credit_card_holder)
//                    .setString("credit_card_approval_code", to_sales.credit_card_approval_code)
//                    .setString("gift_certificate_from", to_sales.gift_certificate_from)
//                    .setString("gift_certificate_description", to_sales.gift_certificate_description)
//                    .setString("gift_certificate_no", to_sales.gift_certificate_no)
//                    .setNumber("gift_certificate_amount", to_sales.gift_certificate_amount)
//                    .setString("prepaid_customer_name", to_sales.prepaid_customer_name)
//                    .setString("prepaid_customer_id", to_sales.prepaid_customer_id)
//                    .setNumber("prepaid_amount", to_sales.prepaid_amount)
//                    .setNumber("addtl_amount", to_sales.addtl_amount)
//                    .setNumber("wtax", to_sales.wtax)
//                    .setString("branch", to_sales.branch)
//                    .setString("branch_id", to_sales.branch_id)
//                    .setString("location", to_sales.location)
//                    .setString("location_id", to_sales.location_id)
//                    .ok();
//
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.execute();
//            Lg.s(Sales.class, "Successfully Updated");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static void delete_sales(sales to_sales) {
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "delete from sales where "
//                    + " id='" + to_sales.id + "'";
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.execute();
//            Lg.s(Sales.class, "Successfully Deleted");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static List<MySales.sales> ret_data(String where) {
//        List<MySales.sales> datas = new ArrayList();
//        List<MySales_Items.items> items = new ArrayList();
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",sales_no"
//                    + ",date_added"
//                    + ",user_screen_name"
//                    + ",user_id"
//                    + ",session_no"
//                    + ",remarks"
//                    + ",gross_amount"
//                    + ",amount_due"
//                    + ",status"
//                    + ",sales_type"
//                    + ",line_discount"
//                    + ",customer_id"
//                    + ",customer_name"
//                    + ",discount_name"
//                    + ",discount_rate"
//                    + ",discount_amount"
//                    + ",discount_customer_name"
//                    + ",discount_customer_id"
//                    + ",charge_type"
//                    + ",charge_type_id"
//                    + ",charge_reference_no"
//                    + ",charge_customer_name"
//                    + ",charge_customer_id"
//                    + ",charge_amount"
//                    + ",check_bank"
//                    + ",check_no"
//                    + ",check_amount"
//                    + ",check_holder"
//                    + ",check_date"
//                    + ",credit_card_type"
//                    + ",credit_card_rate"
//                    + ",credit_card_amount"
//                    + ",credit_card_no"
//                    + ",credit_card_holder"
//                    + ",credit_card_approval_code"
//                    + ",gift_certificate_from"
//                    + ",gift_certificate_description"
//                    + ",gift_certificate_no"
//                    + ",gift_certificate_amount"
//                    + ",prepaid_customer_name"
//                    + ",prepaid_customer_id"
//                    + ",prepaid_amount"
//                    + ",addtl_amount"
//                    + ",wtax"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + ",online_bank"
//                    + ",online_reference_no"
//                    + ",online_amount"
//                    + ",online_holder"
//                    + ",online_date"
//                    + ",ref_or_no"
//                    + ",ref_si_no"
//                    + ",ref_cr_no"
//                    + " from sales"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String sales_no = rs.getString(2);
//                String date_added = rs.getString(3);
//                String user_screen_name = rs.getString(4);
//                String user_id = rs.getString(5);
//                String session_no = rs.getString(6);
//                String remarks = rs.getString(7);
//                double gross_amount = rs.getDouble(8);
//                double amount_due = rs.getDouble(9);
//                int status = rs.getInt(10);
//                int sales_type = rs.getInt(11);
//                double line_discount = rs.getDouble(12);
//                String customer_id = rs.getString(13);
//                String customer_name = rs.getString(14);
//                String discount_name = rs.getString(15);
//                double discount_rate = rs.getDouble(16);
//                double discount_amount = rs.getDouble(17);
//                String discount_customer_name = rs.getString(18);
//                String discount_customer_id = rs.getString(19);
//                String charge_type = rs.getString(20);
//                String charge_type_id = rs.getString(21);
//                String charge_reference_no = rs.getString(22);
//                String charge_customer_name = rs.getString(23);
//                String charge_customer_id = rs.getString(24);
//                double charge_amount = rs.getDouble(25);
//                String check_bank = rs.getString(26);
//                String check_no = rs.getString(27);
//                double check_amount = rs.getDouble(28);
//                String check_holder = rs.getString(29);
//                String check_date = rs.getString(30);
//                String credit_card_type = rs.getString(31);
//                double credit_card_rate = rs.getDouble(32);
//                double credit_card_amount = rs.getDouble(33);
//                String credit_card_no = rs.getString(34);
//                String credit_card_holder = rs.getString(35);
//                String credit_card_approval_code = rs.getString(36);
//                String gift_certificate_from = rs.getString(37);
//                String gift_certificate_description = rs.getString(38);
//                String gift_certificate_no = rs.getString(39);
//                double gift_certificate_amount = rs.getDouble(40);
//                String prepaid_customer_name = rs.getString(41);
//                String prepaid_customer_id = rs.getString(42);
//                double prepaid_amount = rs.getDouble(43);
//                double addtl_amount = rs.getDouble(44);
//                double wtax = rs.getDouble(45);
//                String branch = rs.getString(46);
//                String branch_id = rs.getString(47);
//                String location = rs.getString(48);
//                String location_id = rs.getString(49);
//                int charge_days = 0;
//                String online_bank = rs.getString(50);
//                String online_reference_no = rs.getString(51);
//                double online_amount = rs.getDouble(52);
//                String online_holder = rs.getString(53);
//                String online_date = rs.getString(54);
//                String ref_or_no = rs.getString(55);
//                String ref_si_no = rs.getString(56);
//                String ref_cr_no = rs.getString(57);
//                MySales.sales to = new MySales.sales(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, "", check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch, branch_id, location, location_id, items,
//                                                     charge_days, online_bank, online_reference_no, online_amount, online_holder, online_date, ref_or_no, ref_si_no, ref_cr_no);
//                datas.add(to);
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static List<MySales.sales> ret_data_cloud(String where) {
//        List<MySales.sales> datas = new ArrayList();
//        List<MySales_Items.items> items = new ArrayList();
//        try {
//            Connection conn = MyConnection.cloud_connect();
//            String s0 = "select "
//                    + "id"
//                    + ",sales_no"
//                    + ",date_added"
//                    + ",user_screen_name"
//                    + ",user_id"
//                    + ",session_no"
//                    + ",remarks"
//                    + ",gross_amount"
//                    + ",amount_due"
//                    + ",status"
//                    + ",sales_type"
//                    + ",line_discount"
//                    + ",customer_id"
//                    + ",customer_name"
//                    + ",discount_name"
//                    + ",discount_rate"
//                    + ",discount_amount"
//                    + ",discount_customer_name"
//                    + ",discount_customer_id"
//                    + ",charge_type"
//                    + ",charge_type_id"
//                    + ",charge_reference_no"
//                    + ",charge_customer_name"
//                    + ",charge_customer_id"
//                    + ",charge_amount"
//                    + ",check_bank"
//                    + ",check_no"
//                    + ",check_amount"
//                    + ",check_holder"
//                    + ",check_date"
//                    + ",credit_card_type"
//                    + ",credit_card_rate"
//                    + ",credit_card_amount"
//                    + ",credit_card_no"
//                    + ",credit_card_holder"
//                    + ",credit_card_approval_code"
//                    + ",gift_certificate_from"
//                    + ",gift_certificate_description"
//                    + ",gift_certificate_no"
//                    + ",gift_certificate_amount"
//                    + ",prepaid_customer_name"
//                    + ",prepaid_customer_id"
//                    + ",prepaid_amount"
//                    + ",addtl_amount"
//                    + ",wtax"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + ",online_bank"
//                    + ",online_reference_no"
//                    + ",online_amount"
//                    + ",online_holder"
//                    + ",online_date"
//                    + ",ref_or_no"
//                    + ",ref_si_no"
//                    + ",ref_cr_no"
//                    + " from sales"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String sales_no = rs.getString(2);
//                String date_added = rs.getString(3);
//                String user_screen_name = rs.getString(4);
//                String user_id = rs.getString(5);
//                String session_no = rs.getString(6);
//                String remarks = rs.getString(7);
//                double gross_amount = rs.getDouble(8);
//                double amount_due = rs.getDouble(9);
//                int status = rs.getInt(10);
//                int sales_type = rs.getInt(11);
//                double line_discount = rs.getDouble(12);
//                String customer_id = rs.getString(13);
//                String customer_name = rs.getString(14);
//                String discount_name = rs.getString(15);
//                double discount_rate = rs.getDouble(16);
//                double discount_amount = rs.getDouble(17);
//                String discount_customer_name = rs.getString(18);
//                String discount_customer_id = rs.getString(19);
//                String charge_type = rs.getString(20);
//                String charge_type_id = rs.getString(21);
//                String charge_reference_no = rs.getString(22);
//                String charge_customer_name = rs.getString(23);
//                String charge_customer_id = rs.getString(24);
//                double charge_amount = rs.getDouble(25);
//                String check_bank = rs.getString(26);
//                String check_no = rs.getString(27);
//                double check_amount = rs.getDouble(28);
//                String check_holder = rs.getString(29);
//                String check_date = rs.getString(30);
//                String credit_card_type = rs.getString(31);
//                double credit_card_rate = rs.getDouble(32);
//                double credit_card_amount = rs.getDouble(33);
//                String credit_card_no = rs.getString(34);
//                String credit_card_holder = rs.getString(35);
//                String credit_card_approval_code = rs.getString(36);
//                String gift_certificate_from = rs.getString(37);
//                String gift_certificate_description = rs.getString(38);
//                String gift_certificate_no = rs.getString(39);
//                double gift_certificate_amount = rs.getDouble(40);
//                String prepaid_customer_name = rs.getString(41);
//                String prepaid_customer_id = rs.getString(42);
//                double prepaid_amount = rs.getDouble(43);
//                double addtl_amount = rs.getDouble(44);
//                double wtax = rs.getDouble(45);
//                String branch = rs.getString(46);
//                String branch_id = rs.getString(47);
//                String location = rs.getString(48);
//                String location_id = rs.getString(49);
//                int charge_days = 0;
//                String online_bank = rs.getString(50);
//                String online_reference_no = rs.getString(51);
//                double online_amount = rs.getDouble(52);
//                String online_holder = rs.getString(53);
//                String online_date = rs.getString(54);
//                String ref_or_no = rs.getString(55);
//                String ref_si_no = rs.getString(56);
//                String ref_cr_no = rs.getString(57);
//                MySales.sales to = new MySales.sales(id, sales_no, date_added, user_screen_name, user_id, session_no, remarks, gross_amount, amount_due, status, sales_type, line_discount, customer_id, customer_name, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, charge_type, charge_type_id, charge_reference_no, charge_customer_name, charge_customer_id, charge_amount, "", check_bank, check_no, check_amount, check_holder, check_date, credit_card_type, credit_card_rate, credit_card_amount, credit_card_no, credit_card_holder, credit_card_approval_code, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, prepaid_customer_name, prepaid_customer_id, prepaid_amount, addtl_amount, wtax, branch, branch_id, location, location_id, items,
//                                                     charge_days, online_bank, online_reference_no, online_amount, online_holder, online_date, ref_or_no, ref_si_no, ref_cr_no);
//                datas.add(to);
//            }
//            conn.close();
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(increment_id("17"));
//    }
//
//    public static String increment_id(String location_id) {
//        String id = "000000000000";
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select max(id) from sales where location_id ='" + location_id + "' ";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            if (rs.next()) {
//                id = rs.getString(1);
//                String s2 = "select sales_no from sales where id='" + id + "' ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    id = rs2.getString(1);
//                }
//            }
//            if (id == null) {
//                id = "000000000000";
//            }
//            id = ReceiptIncrementor.increment(id);
//
//            return id;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static String increment_id_reference_no(String location_id, String charge_type) {
//        String id = "000000";
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select max(id) from sales where location_id ='" + location_id + "' and charge_type like '%" + charge_type + "%' ";
//            Statement stmt = conn.createStatement();
////            System.out.println(s0);
//            ResultSet rs = stmt.executeQuery(s0);
//            if (rs.next()) {
//                id = rs.getString(1);
//                String s2 = "select charge_reference_no from sales where id='" + id + "' ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    id = rs2.getString(1);
//                }
//            }
//            if (id == null) {
//                id = "000000";
//            }
//            id = ReceiptIncrementor.increment(id);
//
//            return id;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static String increment_id_ref_or_no(String location_id) {
//        String id = "000000";
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select max(id) from sales where location_id ='" + location_id + "' and ref_or_no !='' ";
//            Statement stmt = conn.createStatement();
////            System.out.println(s0);
//            ResultSet rs = stmt.executeQuery(s0);
//            if (rs.next()) {
//                id = rs.getString(1);
//                String s2 = "select ref_or_no from sales where id='" + id + "' ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    id = rs2.getString(1);
//                }
//            }
//            if (id == null) {
//                id = "000000";
//            }
//            id = ReceiptIncrementor.increment(id);
//
//            return id;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static String increment_id_ref_si_no(String location_id) {
//        String id = "000000";
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select max(id) from sales where location_id ='" + location_id + "' and ref_si_no !='' ";
//            Statement stmt = conn.createStatement();
////            System.out.println(s0);
//            ResultSet rs = stmt.executeQuery(s0);
//            if (rs.next()) {
//                id = rs.getString(1);
//                String s2 = "select ref_si_no from sales where id='" + id + "' ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    id = rs2.getString(1);
//                }
//            }
//            if (id == null) {
//                id = "000000";
//            }
//            id = ReceiptIncrementor.increment(id);
//
//            return id;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static String increment_id_ref_cr_no(String location_id) {
//        String id = "000000";
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select max(id) from sales where location_id ='" + location_id + "' and ref_cr_no !='' ";
//            Statement stmt = conn.createStatement();
////            System.out.println(s0);
//            ResultSet rs = stmt.executeQuery(s0);
//            if (rs.next()) {
//                id = rs.getString(1);
//                String s2 = "select ref_cr_no from sales where id='" + id + "' ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                if (rs2.next()) {
//                    id = rs2.getString(1);
//                }
//            }
//            if (id == null) {
//                id = "000000";
//            }
//            id = ReceiptIncrementor.increment(id);
//
//            return id;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static void void_sale(String sales_no, int status, List<MySales_Items.items> to_receipt_items1, MySales.sales sale) {
//        try {
//            Connection conn = MyConnection.connect();
//            conn.setAutoCommit(false);
//
//            String s0 = "update sales set "
//                    + " status= :status"
//                    + " where "
//                    + " sales_no ='" + sales_no + "' "
//                    + " ";
//            s0 = SqlStringUtil.parse(s0)
//                    .setNumber("status", 1)
//                    .ok();
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.addBatch(s0);
//
//            String s2 = "update sale_items set "
//                    + " status= :status"
//                    + " where "
//                    + " sales_no ='" + sales_no + "' "
//                    + " ";
//            s2 = SqlStringUtil.parse(s2)
//                    .setNumber("status", 1)
//                    .ok();
//
//            stmt.addBatch(s2);
//
//            if (sale.prepaid_amount > 0) {
//                Customers.to_customers cus = S1_accounts_receivable_payments.ret_customer_balance2(sale.prepaid_customer_id);
//                double new_balance = cus.prepaid + sale.prepaid_amount;
//                System.out.println("Amount: " + cus.prepaid + " + " + sale.prepaid_amount);
//                System.out.println("Balance: " + new_balance);
//
//                String s3 = "update  customers set "
//                        + " prepaid= :prepaid"
//                        + " where "
//                        + " id ='" + sale.prepaid_customer_id + "' "
//                        + " ";
//                s3 = SqlStringUtil.parse(s3).
//                        setNumber("prepaid", new_balance).
//                        ok();
//                stmt.addBatch(s3);
//            }
//
//            if (sale.charge_amount > 0) {
//                Customers.to_customers cus = S1_accounts_receivable_payments.ret_customer_balance3(sale.charge_customer_id);
//                double new_balance = cus.balance - sale.charge_amount;
//                System.out.println("Amount: " + cus.balance + " - " + sale.charge_amount);
//                System.out.println("Balance: " + new_balance);
//
//                String s5 = "update  customers set "
//                        + " balance= :balance"
//                        + " where "
//                        + " customer_no ='" + sale.charge_customer_id + "' "
//                        + " ";
//                s5 = SqlStringUtil.parse(s5).
//                        setNumber("balance", new_balance).
//                        ok();
//                stmt.addBatch(s5);
//
//                String s6 = " update accounts_receivable set status=1 where customer_id='" + sale.charge_customer_id + "' and reference_no='" + sale.charge_reference_no + "'  ";
//                stmt.addBatch(s6);
////                System.out.println("s6: " + s6);
//                String s7 = " update accounts_receivable_payments set status=2 where customer_id='" + sale.charge_customer_id + "' and reference_no='" + sale.charge_reference_no + "'  ";
//                stmt.addBatch(s7);
////                System.out.println("s7: " + s7);
//
//            }
//
//            for (MySales_Items.items to_receipt_items : to_receipt_items1) {
//                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_receipt_items.item_code, to_receipt_items.barcode, to_receipt_items.location_id);
//                double new_qty = 0;
//
//                Dlg_inventory_uom.to_uom uomss = uom.default_uom(to_receipt_items.unit);
//
//                if (status == 0) {
//                    new_qty = (tt.product_qty + (to_receipt_items.conversion * (to_receipt_items.product_qty / uomss.conversion)));
//                }
//
//                if (status == 1) {
//                    new_qty = (tt.product_qty - (to_receipt_items.conversion * (to_receipt_items.product_qty / uomss.conversion)));
//                }
//                String new_serial = tt.serial_no + "\n" + to_receipt_items.serial_no;
//                if (tt.serial_no.isEmpty()) {
//                    new_serial = to_receipt_items.serial_no;
//                }
//                String s4 = "update inventory_barcodes set "
//                        + " product_qty='" + new_qty + "'"
//                        + " where main_barcode= '" + to_receipt_items.item_code + "' and location_id='" + to_receipt_items.location_id + "' "
//                        + "";
//
//                stmt.addBatch(s4);
//
//            }
//            stmt.executeBatch();
//            conn.commit();
//            Lg.s(Inventory.class, "Successfully Updated");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static void void_sale_2(String sales_no, int status, List<MySales_Items.items> to_receipt_items1, MySales.sales sale, int all_items, int selected) {
//        try {
//            Connection conn = MyConnection.connect();
//            conn.setAutoCommit(false);
//            PreparedStatement stmt = conn.prepareStatement("");
//            if (all_items == selected) {
//                String s0 = "update sales set "
//                        + " status= :status"
//                        + " where "
//                        + " sales_no ='" + sales_no + "' "
//                        + " ";
//                s0 = SqlStringUtil.parse(s0)
//                        .setNumber("status", 1)
//                        .ok();
//                stmt.addBatch(s0);
//                String s2 = "update sale_items set "
//                        + " status= :status"
//                        + " where "
//                        + " sales_no ='" + sales_no + "' "
//                        + " ";
//                s2 = SqlStringUtil.parse(s2)
//                        .setNumber("status", 1)
//                        .ok();
//
//                stmt.addBatch(s2);
//                for (MySales_Items.items to_receipt_items : to_receipt_items1) {
//
//                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_receipt_items.item_code, to_receipt_items.barcode, to_receipt_items.location_id);
//                    double new_qty = 0;
//                    Dlg_inventory_uom.to_uom uomss = uom.default_uom(to_receipt_items.unit);
//
//                    new_qty = (tt.product_qty + (to_receipt_items.conversion * (to_receipt_items.product_qty / uomss.conversion)));
//                    System.out.println("tt.product_qty : " + tt.product_qty + ", new_qty: " + new_qty);
//                    String s4 = "update inventory_barcodes set "
//                            + " product_qty='" + new_qty + "'"
//                            + " where main_barcode= '" + to_receipt_items.item_code + "' and location_id='" + to_receipt_items.location_id + "' "
//                            + "";
//                    stmt.addBatch(s4);
//                }
//
//            } else {
//                double total_cancelled_orders = 0;
//                for (MySales_Items.items order : to_receipt_items1) {
//                    if (order.selected == true) {
//                        total_cancelled_orders += ((order.product_qty * order.selling_price) + order.discount_amount + order.addtl_amount);
//                        String s2 = "update sale_items set "
//                                + " status= :status"
//                                + " where "
//                                + " id ='" + order.id + "' "
//                                + " ";
//                        s2 = SqlStringUtil.parse(s2)
//                                .setNumber("status", 1)
//                                .ok();
//                        stmt.addBatch(s2);
//
//                        Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(order.item_code, order.barcode, order.location_id);
//                        double new_qty = 0;
//
//                        Dlg_inventory_uom.to_uom uomss = uom.default_uom(order.unit);
//                        new_qty = (tt.product_qty + (order.conversion * (order.product_qty / uomss.conversion)));
//
//                        String s4 = "update inventory_barcodes set "
//                                + " product_qty='" + new_qty + "'"
//                                + " where main_barcode= '" + order.item_code + "' and location_id='" + order.location_id + "' "
//                                + "";
//
//                        stmt.addBatch(s4);
//                    }
//                }
//                double new_amount_due = sale.amount_due - total_cancelled_orders;
////                System.out.println("sale.amount_due: " + sale.amount_due + "-" + total_cancelled_orders + "=" + new_amount_due);
//                String s0 = "update sales set "
//                        + " amount_due= :amount_due"
//                        + " ,gross_amount= :gross_amount"
//                        + " where "
//                        + " sales_no ='" + sales_no + "' "
//                        + " ";
//                s0 = SqlStringUtil.parse(s0)
//                        .setNumber("amount_due", new_amount_due)
//                        .setNumber("gross_amount", new_amount_due)
//                        .ok();
//
//                stmt.addBatch(s0);
//            }
//
//            stmt.executeBatch();
//            conn.commit();
//            Lg.s(Inventory.class, "Successfully Updated");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//
//    public static List<Srpt_sales_summary.field> summary(String where, int is_all, String date_from, String date_to, String user_ids, String name, String location_id) {
//        List<Srpt_sales_summary.field> datas = new ArrayList();
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",sales_no"
//                    + ",date_added"
//                    + ",user_screen_name"
//                    + ",user_id"
//                    + ",session_no"
//                    + ",remarks"
//                    + ",sum(gross_amount)"
//                    + ",sum(amount_due)"
//                    + ",status"
//                    + ",sales_type"
//                    + ",sum(line_discount)"
//                    + ",customer_id"
//                    + ",customer_name"
//                    + ",discount_name"
//                    + ",discount_rate"
//                    + ",sum(discount_amount)"
//                    + ",discount_customer_name"
//                    + ",discount_customer_id"
//                    + ",charge_type"
//                    + ",charge_type_id"
//                    + ",charge_reference_no"
//                    + ",charge_customer_name"
//                    + ",charge_customer_id"
//                    + ",sum(charge_amount)"
//                    + ",check_bank"
//                    + ",check_no"
//                    + ",sum(check_amount)"
//                    + ",credit_card_type"
//                    + ",credit_card_rate"
//                    + ",sum(credit_card_amount)"
//                    + ",credit_card_no"
//                    + ",credit_card_holder"
//                    + ",credit_card_approval_code"
//                    + ",gift_certificate_from"
//                    + ",gift_certificate_description"
//                    + ",gift_certificate_no"
//                    + ",sum(gift_certificate_amount)"
//                    + ",prepaid_customer_name"
//                    + ",prepaid_customer_id"
//                    + ",sum(prepaid_amount)"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + " from sales"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String sales_no = rs.getString(2);
//                String date_added = rs.getString(3);
//                String user_screen_name = rs.getString(4);
//                String user_screen_name1 = user_screen_name;//
//                String user_id = rs.getString(5);
//                if (is_all == 1) {
//                    user_screen_name1 = "All";
//                    user_id = "0";
//                } else {
//                    user_screen_name1 = name;
//                }
//                String session_no = rs.getString(6);
//                String remarks = rs.getString(7);
//                double gross_amount = rs.getDouble(8);
//                double amount_due = rs.getDouble(9);
//                int status = rs.getInt(10);
//                int sales_type = rs.getInt(11);
//                double line_discount = rs.getDouble(12);
//                String customer_id = rs.getString(13);
//                String customer_name = rs.getString(14);
//                String discount_name = rs.getString(15);
//                double discount_rate = rs.getDouble(16);
//                double discount_amount = rs.getDouble(17);
//                String discount_customer_name = rs.getString(18);
//                String discount_customer_id = rs.getString(19);
//                String charge_type = rs.getString(20);
//                String charge_type_id = rs.getString(21);
//                String charge_reference_no = rs.getString(22);
//                String charge_customer_name = rs.getString(23);
//                String charge_customer_id = rs.getString(24);
//                double charge_amount = rs.getDouble(25);
//                String check_bank = rs.getString(26);
//                String check_no = rs.getString(27);
//                double check_amount = rs.getDouble(28);
//                String credit_card_type = rs.getString(29);
//                double credit_card_rate = rs.getDouble(30);
//                double credit_card_amount = rs.getDouble(31);
//                String credit_card_no = rs.getString(32);
//                String credit_card_holder = rs.getString(33);
//                String credit_card_approval_code = rs.getString(34);
//                String gift_certificate_from = rs.getString(35);
//                String gift_certificate_description = rs.getString(36);
//                String gift_certificate_no = rs.getString(37);
//                double gift_certificate_amount = rs.getDouble(38);
//                String prepaid_customer_name = rs.getString(39);
//                String prepaid_customer_id = rs.getString(40);
//                double prepaid_amount = rs.getDouble(41);
//
//                double gross_total = gross_amount;
//
//                double line_discount1 = line_discount;//
//                double sale_discount = discount_amount;
//                double balance_due = amount_due;
//
//                double cash = amount_due - (credit_card_amount + gift_certificate_amount + prepaid_amount + check_amount + charge_amount);
//                double cash_no = 1;
//                double credit_card = credit_card_amount;
//                double credit_card_no1 = 1;
//                double gift_certificate = gift_certificate_amount;
//                double gift_certificate_no1 = 1;
//                double prepaid = prepaid_amount;
//                double prepaid_no = 1;
//                double cheque = check_amount;
//                double cheque_no = 1;
//                double charge = charge_amount;
//                double charge_no = 1;
//                double disbursement = 0;
//
//                String where2 = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
//                        + " and location_id='" + location_id + "' ";
//                if (is_all == 0) {
//                    where2 = " where Date(date_added) between '" + date_from + "' and '" + date_to + "' "
//                            + " and user_id='" + user_ids + "' "
//                            + " and location_id='" + location_id + "' ";
//                }
//                List<to_disbursements> disbursements = MySales.summary_disbursement(where2);
//                for (to_disbursements to : disbursements) {
//                    disbursement += to.amount;
//                }
//
//                double prepaid_cash = 0;
//                double prepaid_cheque = 0;
//
//                List<to_prepaid_payments> prepaids = MySales.summary_prepaid(where2);
//                for (to_prepaid_payments to : prepaids) {
//                    prepaid_cash += to.cash;
//                    prepaid_cheque += to.check_amount;
//                }
//
//                double ar_cash = 0;
//                double ar_cheque = 0;
//
//                List<to_accounts_receivable_payments> ars = MySales.summary_ar(where2);
//                for (to_accounts_receivable_payments to : ars) {
//                    if (to.check_amount > 0) {
//                        ar_cheque += to.tax_amount;
//                    } else {
//                        ar_cash += to.tax_amount;
//                    }
//
//                }
//
//                String where4 = " where session_no='" + user_ids + "' "
//                        + " and Date(time_in) between '" + date_from + "' and '" + date_to + "' "
//                        + " and location_id='" + location_id + "'";
//
//                if (user_ids == null || is_all == 1) {
//                    where4 = " where  Date(time_in) between '" + date_from + "' and '" + date_to + "' "
//                            + " and location_id='" + location_id + "'";
//                }
//
//                CashDrawer.to_cash_drawer cashins = CashDrawer.ret_to(where4);
//                double cashin = 0;
//                if (cashins != null) {
//                    cashin = cashins.amount;
//                }
//                double remit_cash = 0;
//                double remit_cheque = 0;
//                List<CashDrawer_remittances.to_cash_drawer_remittances> remits = CashDrawer_remittances.ret_data(where2);
//                for (CashDrawer_remittances.to_cash_drawer_remittances to : remits) {
//                    if (to.cash_amount > 0) {
//                        remit_cash += to.cash_amount;
//                    } else {
//                        remit_cheque += to.cheque_amount;
//                    }
//                }
//                double net_cash = (cash + prepaid_cash + ar_cash + cashin) - (disbursement + remit_cash);
//                Srpt_sales_summary.field ff = new Srpt_sales_summary.field(
//                        user_id, user_screen_name1, gross_total, line_discount1, sale_discount, balance_due, cash, cash_no, credit_card, credit_card_no1, gift_certificate, gift_certificate_no1, prepaid, prepaid_no, cheque, cheque_no, charge, charge_no, disbursement, net_cash, prepaid_cash, prepaid_cheque, ar_cash, ar_cheque, cashin, remit_cash, remit_cheque);
//                datas.add(ff);
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            PoolConnection.close();
//        }
//    }

//    public static List<to_disbursements> summary_disbursement(String where) {
//        List<to_disbursements> datas = new ArrayList();
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",user_id"
//                    + ",user_screen_name"
//                    + ",date_added"
//                    + ",purpose"
//                    + ",category_id"
//                    + ",category_name"
//                    + ",sum(amount)"
//                    + ",is_vat"
//                    + ",disbursement_date"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + " from disbursements"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String user_id = rs.getString(2);
//                String user_screen_name = rs.getString(3);
//                String date_added = rs.getString(4);
//                String purpose = rs.getString(5);
//                String category_id = rs.getString(6);
//                String category_name = rs.getString(7);
//                double amount = rs.getDouble(8);
//                int is_vat = rs.getInt(9);
//                String disbursement_date = rs.getString(10);
//                String branch = rs.getString(11);
//                String branch_id = rs.getString(12);
//                String location = rs.getString(13);
//                String location_id = rs.getString(14);
////                to_disbursements to = new to_disbursements(id, user_id, user_screen_name, date_added, purpose, category_id, category_name, amount, is_vat, disbursement_date, branch, branch_id, location, location_id);
////                datas.add(to);
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }

//    public static List<to_prepaid_payments> summary_prepaid(String where) {
//        List<to_prepaid_payments> datas = new ArrayList();
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",sum(cash)"
//                    + ",check_bank"
//                    + ",check_no"
//                    + ",sum(check_amount)"
//                    + ",added_by"
//                    + ",date_added"
//                    + ",customer_name"
//                    + ",customer_id"
//                    + ",status"
//                    + ",cheque_holder"
//                    + ",cheque_date"
//                    + ",user_id"
//                    + ",user_screen_name"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + ",remarks"
//                    + ",refund"
//                    + ",credit_card_type"
//                    + ",credit_card_rate"
//                    + ",credit_card_no"
//                    + ",credit_card_holder"
//                    + ",credit_card_amount"
//                    + ",gift_certificate_from"
//                    + ",gift_certificate_description"
//                    + ",gift_certificate_no"
//                    + ",gift_certificate_amount"
//                    + ",online_bank"
//                    + ",online_reference_no"
//                    + ",online_holder"
//                    + ",online_date"
//                    + ",online_amount"
//                    + " from prepaid_payments"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                double cash = rs.getDouble(2);
//                String check_bank = rs.getString(3);
//                String check_no = rs.getString(4);
//                double check_amount = rs.getDouble(5);
//                String added_by = rs.getString(6);
//                String date_added = rs.getString(7);
//                String customer_name = rs.getString(8);
//                String customer_id = rs.getString(9);
//                int status = rs.getInt(10);
//                String cheque_holder = rs.getString(11);
//                String cheque_date = rs.getString(12);
//                String user_id = rs.getString(13);
//                String user_screen_name = rs.getString(14);
//                String branch = rs.getString(15);
//                String branch_id = rs.getString(16);
//                String location = rs.getString(17);
//                String location_id = rs.getString(18);
//                String remarks = rs.getString(19);
//                int refund = rs.getInt(20);
//                String credit_card_type = rs.getString(21);
//                double credit_card_rate = rs.getDouble(22);
//                String credit_card_no = rs.getString(23);
//                String credit_card_holder = rs.getString(24);
//                double credit_card_amount = rs.getDouble(25);
//                String gift_certificate_from = rs.getString(26);
//                String gift_certificate_description = rs.getString(27);
//                String gift_certificate_no = rs.getString(28);
//                double gift_certificate_amount = rs.getDouble(29);
//                String online_bank = rs.getString(30);
//                String online_reference_no = rs.getString(31);
//                String online_holder = rs.getString(32);
//                String online_date = rs.getString(32);
//                double online_amount = rs.getDouble(34);
////                to_prepaid_payments to = new to_prepaid_payments(id, cash, check_bank, check_no, check_amount, added_by, date_added, customer_name, customer_id,
////                                                                 status, false, cheque_holder, cheque_date, user_id, user_screen_name, branch, branch_id, location, location_id, remarks,
////                                                                 refund, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder, online_date, online_amount);
////                datas.add(to);
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }

//    public static List<to_accounts_receivable_payments> summary_ar(String where) {
//        List<to_accounts_receivable_payments> datas = new ArrayList();
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select "
//                    + "id"
//                    + ",customer_id"
//                    + ",customer_name"
//                    + ",ar_no"
//                    + ",date_added"
//                    + ",user_name"
//                    + ",sum(amount)"
//                    + ",discount_amount"
//                    + ",discount_rate"
//                    + ",discount"
//                    + ",status"
//                    + ",term"
//                    + ",date_applied"
//                    + ",paid"
//                    + ",date_paid"
//                    + ",remarks"
//                    + ",type"
//                    + ",or_no"
//                    + ",prev_balance"
//                    + ",sum(check_amount)"
//                    + ",check_holder"
//                    + ",check_bank"
//                    + ",check_no"
//                    + ",ci_no"
//                    + ",trust_receipt"
//                    + ",or_payment_no"
//                    + ",soa_id"
//                    + ",soa_type"
//                    + ",soa_type_id"
//                    + ",reference_no"
//                    + ",check_date"
//                    + ",user_id"
//                    + ",user_screen_name"
//                    + ",tax_rate"
//                    + ",tax_amount"
//                    + ",branch"
//                    + ",branch_id"
//                    + ",location"
//                    + ",location_id"
//                    + ",prepaid_customer_name"
//                    + ",prepaid_customer_id"
//                    + ",prepaid_amount"
//                    + ",credit_card_type"
//                    + ",credit_card_rate"
//                    + ",credit_card_no"
//                    + ",credit_card_holder"
//                    + ",credit_card_amount"
//                    + ",gift_certificate_from"
//                    + ",gift_certificate_description"
//                    + ",gift_certificate_no"
//                    + ",gift_certificate_amount"
//                    + ",online_bank"
//                    + ",online_reference_no"
//                    + ",online_holder"
//                    + ",online_date"
//                    + ",online_amount"
//                    + ",actual_amount"
//                    + ",retention"
//                    + ",business_tax"
//                    + ",salary_deduction"
//                    + " from accounts_receivable_payments"
//                    + " " + where;
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String customer_id = rs.getString(2);
//                String customer_name = rs.getString(3);
//                String ar_no = rs.getString(4);
//                String date_added = rs.getString(5);
//                String user_name = rs.getString(6);
//                double amount = rs.getDouble(7);
//                double discount_amount = rs.getDouble(8);
//                double discount_rate = rs.getDouble(9);
//                String discount = rs.getString(10);
//                int status = rs.getInt(11);
//                double term = rs.getDouble(12);
//                String date_applied = rs.getString(13);
//                double paid = rs.getDouble(14);
//                String date_paid = rs.getString(15);
//                String remarks = rs.getString(16);
//                String type = rs.getString(17);
//                String or_no = rs.getString(18);
//                double prev_balance = rs.getDouble(19);
//                double check_amount = rs.getDouble(20);
//                String check_holder = rs.getString(21);
//                String check_bank = rs.getString(22);
//                String check_no = rs.getString(23);
//                String ci_no = rs.getString(24);
//                String trust_receipt = rs.getString(25);
//                String or_payment_no = rs.getString(26);
//                String soa_id = rs.getString(27);
//                String soa_type = rs.getString(28);
//                String soa_type_id = rs.getString(29);
//                String reference_no = rs.getString(30);
//                String check_date = rs.getString(31);
//                String user_id = rs.getString(32);
//                String user_screen_name = rs.getString(33);
//                double tax_rate = rs.getDouble(34);
//                double tax_amount = rs.getDouble(35);
//                String branch = rs.getString(36);
//                String branch_id = rs.getString(37);
//                String location = rs.getString(38);
//                String location_id = rs.getString(39);
//                String prepaid_customer_name = rs.getString(40);
//                String prepaid_customer_id = rs.getString(41);
//                double prepaid_amount = rs.getDouble(42);
//                String credit_card_type = rs.getString(43);
//                double credit_card_rate = rs.getDouble(44);
//                String credit_card_no = rs.getString(45);
//                String credit_card_holder = rs.getString(46);
//                double credit_card_amount = rs.getDouble(47);
//                String gift_certificate_from = rs.getString(48);
//                String gift_certificate_description = rs.getString(49);
//                String gift_certificate_no = rs.getString(50);
//                double gift_certificate_amount = rs.getDouble(51);
//                String online_bank = rs.getString(52);
//                String online_reference_no = rs.getString(53);
//                String online_holder = rs.getString(54);
//                String online_date = rs.getString(55);
//                double online_amount = rs.getDouble(56);
//                double actual_amount = rs.getDouble(57);
//                double retention = rs.getDouble(58);
//                double business_tax = rs.getDouble(59);
//                double salary_deduction = rs.getDouble(60);
//                to_accounts_receivable_payments to = new to_accounts_receivable_payments(id, customer_id, customer_name, ar_no, date_added, user_name, amount, discount_amount, discount_rate, discount, status, term, date_applied, paid, date_paid, remarks, type, or_no, prev_balance, check_amount, check_holder, check_bank, check_no, ci_no, trust_receipt, or_payment_no, soa_id, soa_type, soa_type_id, reference_no, false, check_date, user_id, user_screen_name, tax_rate, tax_amount, branch, branch_id, location, location_id, prepaid_customer_name, prepaid_customer_id, prepaid_amount, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_amount, gift_certificate_from, gift_certificate_description, gift_certificate_no, gift_certificate_amount, online_bank, online_reference_no, online_holder, online_date, online_amount, actual_amount, retention, business_tax, salary_deduction);
//                datas.add(to);
//            }
//            return datas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }

}
