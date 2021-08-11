/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory_reports;

import servicing.adjuster.S1_adjustments.to_adjustments;
import servicing.encoding_inventory.Encoding_inventory.to_encoding_inventory;
import servicing.inventory.Inventory_barcodes.to_inventory_barcodes;
import servicing.my_sales.MySales_Items;
import servicing.receipts.S1_receipt_items.to_receipt_items;
import servicing.receipts.Stock_transfers_items.to_stock_transfers_items;
import servicing.sale_item_replacements.S1_sale_item_replacements.to_sale_item_replacements;
import servicing.utils.DateType;
import servicing.utils.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_item_ledger {

    public final List<Srpt_item_ledger.field> fields;
    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String item_code;
    public final String barcode;
    public final String description;
    public final String branch;
    public final String location;
    public final String month;
    public final double running_balance;

    public Srpt_item_ledger(String business_name, String address, String contact_no, String date, String item_code, String barcode, String description, String branch, String location, String month, double running_balance) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.item_code = item_code;
        this.barcode = barcode;
        this.description = description;
        this.branch = branch;
        this.location = location;
        this.month = month;
        this.running_balance = running_balance;
    }

    public static class field implements Comparable<field> {

        String transaction_type;
        String date;
        String in;
        String out;
        String balance;
        String from_branch;
        String from_branch_id;
        String from_location;
        String from_location_id;
        String to_branch;
        String to_branch_id;
        String to_location;
        String to_location_id;
        String created_by;
        String customer_name;
        Date date_added;
        String transaction_no;
        String cost;
        String price;
        String month;
        String remarks;

        public field() {
        }

        public field(String transaction_type, String date, String in, String out, String balance, String from_branch, String from_branch_id, String from_location, String from_location_id, String to_branch, String to_branch_id, String to_location, String to_location_id, String created_by, String customer_name, Date date_added, String transaction_no, String cost, String price, String month, String remarks) {
            this.transaction_type = transaction_type;
            this.date = date;
            this.in = in;
            this.out = out;
            this.balance = balance;
            this.from_branch = from_branch;
            this.from_branch_id = from_branch_id;
            this.from_location = from_location;
            this.from_location_id = from_location_id;
            this.to_branch = to_branch;
            this.to_branch_id = to_branch_id;
            this.to_location = to_location;
            this.to_location_id = to_location_id;
            this.created_by = created_by;
            this.customer_name = customer_name;
            this.date_added = date_added;
            this.transaction_no = transaction_no;
            this.cost = cost;
            this.price = price;
            this.month = month;
            this.remarks = remarks;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getIn() {
            return in;
        }

        public void setIn(String in) {
            this.in = in;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getFrom_branch() {
            return from_branch;
        }

        public void setFrom_branch(String from_branch) {
            this.from_branch = from_branch;
        }

        public String getFrom_branch_id() {
            return from_branch_id;
        }

        public void setFrom_branch_id(String from_branch_id) {
            this.from_branch_id = from_branch_id;
        }

        public String getFrom_location() {
            return from_location;
        }

        public void setFrom_location(String from_location) {
            this.from_location = from_location;
        }

        public String getFrom_location_id() {
            return from_location_id;
        }

        public void setFrom_location_id(String from_location_id) {
            this.from_location_id = from_location_id;
        }

        public String getTo_branch() {
            return to_branch;
        }

        public void setTo_branch(String to_branch) {
            this.to_branch = to_branch;
        }

        public String getTo_branch_id() {
            return to_branch_id;
        }

        public void setTo_branch_id(String to_branch_id) {
            this.to_branch_id = to_branch_id;
        }

        public String getTo_location() {
            return to_location;
        }

        public void setTo_location(String to_location) {
            this.to_location = to_location;
        }

        public String getTo_location_id() {
            return to_location_id;
        }

        public void setTo_location_id(String to_location_id) {
            this.to_location_id = to_location_id;
        }

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        @Override
        public int compareTo(field o) {
            if (getDate_added() == null || o.getDate_added() == null) {
                return 0;
            }
            return getDate_added().
                    compareTo(o.getDate_added());
        }
    }

    public static void main(String[] args) {
        List<Srpt_item_ledger.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            String transaction_type = "Receipt";
            String date = "01/01/2015";
            String in = "" + i * 2;
            String out = "";
            String balance = "" + i * 2;
            String from_branch = "";
            String from_location = "";
            String to_branch = "";
            String to_location = "";
            String created_by = "Administrator";
            String customer_name = "";
//            Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_location, to_branch, to_location, created_by, customer_name, new Date(), "", "", "", "", "");
//            fields.add(field);
        }

        String business_name = "";
        String address = "";
        String contact_no = "";
        String date = "02/02/2015";
        String item_code = "4486";
        String barcode = "";
        String description = "LAPTOP-LENOVO G4030 CELERON N2830 WIN8.1";
        String branch = "Dumaguete";
        String location = "Selling Area";
        String month = "";
        double running_balance = 0;
        Srpt_item_ledger rpt = new Srpt_item_ledger(business_name, address, contact_no, date, item_code, barcode, description, branch, location, month, running_balance);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_item_ledger.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_item_ledger.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_item_ledger to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_item_ledger.field> inventory_encoding(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",qty"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",cost"
                    + ",selling_price"
                    + ",user_id"
                    + ",user_screen_name"
                    + " from encoding_inventory "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = rs.getString(7);
                String location_id = rs.getString(8);
                double qty = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String screen_name = rs.getString(12);
                String sheet_no = rs.getString(13);
                int status = rs.getInt(14);
                String counted_by = rs.getString(15);
                String checked_by = rs.getString(16);
                double cost = rs.getDouble(17);
                double selling_price = rs.getDouble(18);
                String user_id = rs.getString(19);
                String user_screen_name = rs.getString(20);

                String transaction_type = "Inventory Count";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = FitIn.fmt_woc(qty);
                String out = "";
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_id;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = screen_name;
                String customer_name = "";
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + sheet_no;
                String cost1 = FitIn.fmt_wc_0(cost);
                String price1 = FitIn.fmt_wc_0(selling_price);
                String month = DateType.convert_datetime_to_month(date_added);
                String remarks = "";
                Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);

                datas.add(field);
            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<Srpt_item_ledger.field> receipts(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",previous_cost"
                    + ",receipt_type_id"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from receipt_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String batch_no = rs.getString(24);
                String serial_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                String transaction_type = "Receipts";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = FitIn.fmt_woc(qty);
                String out = "";
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_id;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = user_name;
                String customer_name = "";
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + receipt_no;
                String cost1 = FitIn.fmt_wc_0(cost);
                String price1 = "";
                String month = DateType.convert_datetime_to_month(date_added);

                Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);

                datas.add(field);
            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_item_ledger.field> transfer(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();
        List<Srpt_item_ledger.field> transfer_in = new ArrayList();
        List<Srpt_item_ledger.field> transfer_out = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",barcodes"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",stock_transfer_id"
                    + ",serial_no"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + " from stock_transfers_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                String barcodes = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String stock_transfer_id = rs.getString(37);
                String serial_no = rs.getString(38);
                String to_branch = rs.getString(39);
                String to_branch_id = rs.getString(40);
                String to_location = rs.getString(41);
                String to_location_id = rs.getString(42);

                String transaction_type = "Transfer";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = FitIn.fmt_woc(product_qty);
                String out = "";
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_code;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch1 = "";
                String to_branch_id1 = "";
                String to_location1 = "";
                String to_location_id1 = "";
                String created_by = user_name;
                String customer_name = "";
                Date created = new Date();

                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }

                String transaction_no = "" + stock_transfer_id;
                String cost1 = FitIn.fmt_wc_0(cost);
                String price1 = "";
                String month = DateType.convert_datetime_to_month(date_added);
                String remarks = "";
                Srpt_item_ledger.field field_out = new field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                transfer_in.add(field_out);

                Srpt_item_ledger.field field_in = new field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                transfer_out.add(field_in);

            }
            datas.addAll(transfer_in);
            datas.addAll(transfer_out);

            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_item_ledger.field> sales(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from sale_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                double addtl_amount = rs.getDouble(40);
                double wtax = rs.getDouble(41);

                String transaction_type = "Sales";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = "";
                String out = FitIn.fmt_woc(product_qty);
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_code;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = user_screen_name;
                String customer_name = "";
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + sales_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String month = DateType.convert_datetime_to_month(date_added);
                String remarks = "";
                Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                datas.add(field);

            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_item_ledger.field> adjustments(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
        List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",new_qty"
                    + ",is_add"
                    + ",date_added"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from adjustments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                double qty = rs.getDouble(5);
                double new_qty = rs.getDouble(6);
                int is_add = rs.getInt(7);
                String date_added = rs.getString(8);
                int status = rs.getInt(9);
                String user_id = rs.getString(10);
                String user_screen_name = rs.getString(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);

                String transaction_type = "Adjustment";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = FitIn.fmt_woc(new_qty);
                String out = "";
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_id;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = user_screen_name;
                String customer_name = "";
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + id;
                String cost1 = "";
                String price1 = "";
                String month = DateType.convert_datetime_to_month(date_added);
                String remarks = "";
                if (is_add == 1) {
                    Srpt_item_ledger.field add = new field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                    adjustment_add.add(add);
                } else {
                    Srpt_item_ledger.field deduct = new field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                    adjustment_deduct.add(deduct);
                }

            }
            datas.addAll(adjustment_add);
            datas.addAll(adjustment_deduct);

            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_item_ledger.field> item_replacements(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",is_replacement"
                    + " from sale_item_replacements"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                int is_replacement = rs.getInt(40);

                String transaction_type = "Exc-Replacement";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = "";
                String out = FitIn.fmt_woc(product_qty);
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_code;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = user_screen_name;
                String customer_name = "";
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + sales_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                if (is_replacement == 0) {
                    transaction_type = "Exc-Returned";
                    in = FitIn.fmt_woc(product_qty);
                    out = "";
                }
                String month = DateType.convert_datetime_to_month(date_added);
                String remarks = "";
                Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                datas.add(field);

            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_qty(String where) {
        double qty = 0;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + " from inventory_barcodes"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                int main_barcode = rs.getInt(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);

            }
            return qty;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> get_qty(String where) {
        List<to_inventory_barcodes> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",serial_no"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                int main_barcode = rs.getInt(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String serial_no = rs.getString(37);

                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales=rs.getInt(40);
//                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, "" + main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0,allow_negative_inventory,auto_order,show_to_sales);
//                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_encoding_inventory> trans_inv_count(String where) {
        List<to_encoding_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",qty"
                    + ",date_added"
                    + ",user_name"
                    + ",screen_name"
                    + ",sheet_no"
                    + ",status"
                    + ",counted_by"
                    + ",checked_by"
                    + ",cost"
                    + ",selling_price"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",remarks"
                    + " from encoding_inventory"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = rs.getString(7);
                String location_id = rs.getString(8);
                double qty = rs.getDouble(9);
                String date_added = rs.getString(10);
                String user_name = rs.getString(11);
                String screen_name = rs.getString(12);
                String sheet_no = rs.getString(13);
                int status = rs.getInt(14);
                String counted_by = rs.getString(15);
                String checked_by = rs.getString(16);
                double cost = rs.getDouble(17);
                double selling_price = rs.getDouble(18);
                String user_id = rs.getString(19);
                String user_screen_name = rs.getString(20);
                String remarks = rs.getString(21);
                to_encoding_inventory to = new to_encoding_inventory(id, item_code, barcode, description, branch, branch_id, location, location_id, qty, date_added, user_name, screen_name, sheet_no, status, counted_by, checked_by, cost, selling_price, user_id, user_screen_name, remarks);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> trans_receipts(String where) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",conversion"
                    + ",unit"
                    + ",date_delivered"
                    + ",date_received"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",status"
                    + ",previous_cost"
                    + ",receipt_type_id"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from receipt_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);
                String barcode = rs.getString(9);
                String description = rs.getString(10);
                double qty = rs.getDouble(11);
                double cost = rs.getDouble(12);
                String category = rs.getString(13);
                String category_id = rs.getString(14);
                String classification = rs.getString(15);
                String classification_id = rs.getString(16);
                String sub_class = rs.getString(17);
                String sub_class_id = rs.getString(18);
                double conversion = rs.getDouble(19);
                String unit = rs.getString(20);
                String date_delivered = rs.getString(21);
                String date_received = rs.getString(22);
                String barcodes = rs.getString(23);
                String batch_no = rs.getString(24);
                String serial_no = rs.getString(25);
                String main_barcode = rs.getString(26);
                String brand = rs.getString(27);
                String brand_id = rs.getString(28);
                String model = rs.getString(29);
                String model_id = rs.getString(30);
                int status = rs.getInt(31);
                double previous_cost = rs.getDouble(32);
                String receipt_type_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_id = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);

                to_receipt_items to = new to_receipt_items(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks, barcode, description, qty, cost, category, category_id, classification, classification_id, sub_class, sub_class_id, conversion, unit, date_delivered, date_received, barcodes, batch_no, serial_no, main_barcode, brand, brand_id, model, model_id, status, previous_cost, receipt_type_id, receipt_type_id, branch, branch_id, location);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<MySales_Items.items> trans_sales(String where) {
        List<MySales_Items.items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",wtax"
                    + ",cost"
                    + " from sale_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                double addtl_amount = rs.getDouble(40);
                double wtax = rs.getDouble(41);
                double cost=rs.getDouble(42);
                MySales_Items.items to = new MySales_Items.items(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, true, addtl_amount, wtax,cost);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_stock_transfers_items> trans_transfers(String where) {
        List<to_stock_transfers_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",supplier"
                    + ",fixed_price"
                    + ",cost"
                    + ",supplier_id"
                    + ",multi_level_pricing"
                    + ",vatable"
                    + ",reorder_level"
                    + ",markup"
                    + ",barcodes"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",selling_type"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",stock_transfer_id"
                    + ",serial_no"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",at_branch"
                    + ",at_branch_id"
                    + ",at_location"
                    + ",at_location_id"
                    + " from stock_transfers_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String supplier = rs.getString(19);
                int fixed_price = rs.getInt(20);
                double cost = rs.getDouble(21);
                String supplier_id = rs.getString(22);
                int multi_level_pricing = rs.getInt(23);
                int vatable = rs.getInt(24);
                double reorder_level = rs.getDouble(25);
                double markup = rs.getDouble(26);
                String barcodes = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                String stock_transfer_id = rs.getString(37);
                String serial_no = rs.getString(38);
                String to_branch = rs.getString(39);
                String to_branch_id = rs.getString(40);
                String to_location = rs.getString(41);
                String to_location_id = rs.getString(42);
                String at_branch = rs.getString(43);
                String at_branch_id = rs.getString(44);
                String at_location = rs.getString(45);
                String at_location_id = rs.getString(46);

                to_stock_transfers_items to = new to_stock_transfers_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, stock_transfer_id, serial_no, to_branch, to_branch_id, to_location, to_location_id, at_branch, at_branch_id, at_location, at_location_id);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_adjustments> trans_adjustments(String where) {
        List<to_adjustments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",new_qty"
                    + ",is_add"
                    + ",date_added"
                    + ",status"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",remarks"
                    + ",transaction_no"
                    + " from adjustments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                double qty = rs.getDouble(5);
                double new_qty = rs.getDouble(6);
                int is_add = rs.getInt(7);
                String date_added = rs.getString(8);
                int status = rs.getInt(9);
                String user_id = rs.getString(10);
                String user_screen_name = rs.getString(11);
                String branch = rs.getString(12);
                String branch_id = rs.getString(13);
                String location = rs.getString(14);
                String location_id = rs.getString(15);
                String remarks = rs.getString(16);
                String transaction_no = rs.getString(17);

                to_adjustments to = new to_adjustments(id, item_code, barcode, description, qty, new_qty, is_add, date_added, status, user_id, user_screen_name, branch, branch_id, location, location_id, remarks, transaction_no);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sale_item_replacements> trans_replacements(String where) {
        List<to_sale_item_replacements> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",is_replacement"
                    + ",reason"
                    + " from sale_item_replacements"
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String item_code = rs.getString(3);
                String barcode = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String item_type = rs.getString(7);
                String supplier_name = rs.getString(8);
                String supplier_id = rs.getString(9);
                String serial_no = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_id = rs.getString(16);
                String user_screen_name = rs.getString(17);
                int status = rs.getInt(18);
                int is_vatable = rs.getInt(19);
                int selling_type = rs.getInt(20);
                String discount_name = rs.getString(21);
                double discount_rate = rs.getDouble(22);
                double discount_amount = rs.getDouble(23);
                String discount_customer_name = rs.getString(24);
                String discount_customer_id = rs.getString(25);
                String branch = rs.getString(26);
                String branch_code = rs.getString(27);
                String location = rs.getString(28);
                String location_id = rs.getString(29);
                String category = rs.getString(30);
                String category_id = rs.getString(31);
                String classification = rs.getString(32);
                String classification_id = rs.getString(33);
                String sub_classification = rs.getString(34);
                String sub_classification_id = rs.getString(35);
                String brand = rs.getString(36);
                String brand_id = rs.getString(37);
                String model = rs.getString(38);
                String model_id = rs.getString(39);
                int is_replacement = rs.getInt(40);
                String reason = rs.getString(41);
                to_sale_item_replacements to = new to_sale_item_replacements(id, sales_no, item_code, barcode, description, generic_name, item_type, supplier_name, supplier_id, serial_no, product_qty, unit, conversion, selling_price, date_added, user_id, user_screen_name, status, is_vatable, selling_type, discount_name, discount_rate, discount_amount, discount_customer_name, discount_customer_id, branch, branch_code, location, location_id, category, category_id, classification, classification_id, sub_classification, sub_classification_id, brand, brand_id, model, model_id, is_replacement, reason);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_item_ledger.field> charge_items(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_id"
                    + ",ar_no"
                    + ",date_applied"
                    + ",reference_no"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",remarks"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from charge_in_advance_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_id = rs.getString(4);
                String ar_no = rs.getString(5);
                String date_applied = rs.getString(6);
                String reference_no = rs.getString(7);
                String soa_type = rs.getString(8);
                String soa_type_id = rs.getString(9);
                String user_screen_name = rs.getString(10);
                String user_id = rs.getString(11);
                String remarks = rs.getString(12);
                String item_code = rs.getString(13);
                String barcode = rs.getString(14);
                String description = rs.getString(15);
                String generic_name = rs.getString(16);
                String item_type = rs.getString(17);
                String supplier_name = rs.getString(18);
                String supplier_id = rs.getString(19);
                String serial_no = rs.getString(20);
                double product_qty = rs.getDouble(21);
                String unit = rs.getString(22);
                double conversion = rs.getDouble(23);
                double selling_price = rs.getDouble(24);
                String date_added = rs.getString(25);
                int status = rs.getInt(26);
                int is_vatable = rs.getInt(27);
                int selling_type = rs.getInt(28);
                String discount_name = rs.getString(29);
                double discount_rate = rs.getDouble(30);
                double discount_amount = rs.getDouble(31);
                String discount_customer_name = rs.getString(32);
                String discount_customer_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_code = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);
                String category = rs.getString(38);
                String category_id = rs.getString(39);
                String classification = rs.getString(40);
                String classification_id = rs.getString(41);
                String sub_classification = rs.getString(42);
                String sub_classification_id = rs.getString(43);
                String brand = rs.getString(44);
                String brand_id = rs.getString(45);
                String model = rs.getString(46);
                String model_id = rs.getString(47);
                double addtl_amount = rs.getDouble(48);
                double wtax = rs.getDouble(49);

                String transaction_type = "Charge in Advance";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = "";
                String out = FitIn.fmt_woc(product_qty);
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_code;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = user_screen_name;
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + ar_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String month = DateType.convert_datetime_to_month(date_added);

                Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                datas.add(field);
            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_item_ledger.field> charge_in_advance_cancelled(String where) {
        List<Srpt_item_ledger.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",ar_id"
                    + ",ar_no"
                    + ",date_applied"
                    + ",reference_no"
                    + ",soa_type"
                    + ",soa_type_id"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",remarks"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",item_type"
                    + ",supplier_name"
                    + ",supplier_id"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",status"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",branch"
                    + ",branch_code"
                    + ",location"
                    + ",location_id"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",addtl_amount"
                    + ",wtax"
                    + " from charge_in_advance_cancelled_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String ar_id = rs.getString(4);
                String ar_no = rs.getString(5);
                String date_applied = rs.getString(6);
                String reference_no = rs.getString(7);
                String soa_type = rs.getString(8);
                String soa_type_id = rs.getString(9);
                String user_screen_name = rs.getString(10);
                String user_id = rs.getString(11);
                String remarks = rs.getString(12);
                String item_code = rs.getString(13);
                String barcode = rs.getString(14);
                String description = rs.getString(15);
                String generic_name = rs.getString(16);
                String item_type = rs.getString(17);
                String supplier_name = rs.getString(18);
                String supplier_id = rs.getString(19);
                String serial_no = rs.getString(20);
                double product_qty = rs.getDouble(21);
                String unit = rs.getString(22);
                double conversion = rs.getDouble(23);
                double selling_price = rs.getDouble(24);
                String date_added = rs.getString(25);
                int status = rs.getInt(26);
                int is_vatable = rs.getInt(27);
                int selling_type = rs.getInt(28);
                String discount_name = rs.getString(29);
                double discount_rate = rs.getDouble(30);
                double discount_amount = rs.getDouble(31);
                String discount_customer_name = rs.getString(32);
                String discount_customer_id = rs.getString(33);
                String branch = rs.getString(34);
                String branch_code = rs.getString(35);
                String location = rs.getString(36);
                String location_id = rs.getString(37);
                String category = rs.getString(38);
                String category_id = rs.getString(39);
                String classification = rs.getString(40);
                String classification_id = rs.getString(41);
                String sub_classification = rs.getString(42);
                String sub_classification_id = rs.getString(43);
                String brand = rs.getString(44);
                String brand_id = rs.getString(45);
                String model = rs.getString(46);
                String model_id = rs.getString(47);
                double addtl_amount = rs.getDouble(48);
                double wtax = rs.getDouble(49);

                String transaction_type = "Charge in Adv. [X]";
                String date = DateType.convert_slash_datetime3(date_added);
                String in = FitIn.fmt_woc(product_qty);
                String out = "";
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_code;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = user_screen_name;
                Date created = new Date();
                try {
                    created = DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + ar_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String month = DateType.convert_datetime_to_month(date_added);

                Srpt_item_ledger.field field = new field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, month, remarks);
                datas.add(field);
            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
