/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory_reports;

import servicing.utils.DateType;
import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class MyLedger {

    public static Srpt_item_ledger get(String my_item_code, String my_barcode, String my_description, String loc_id, String year, int month, String my_branch, String my_location, boolean is_month_selected, int show_cost, int hide_price, int all_year, String date_from, String date_to) {

        List<Srpt_item_ledger.field> field3 = new ArrayList();
        List<Srpt_item_ledger.field> fields = new ArrayList();

        String where = " where item_code ='" + my_item_code + "'  and location_id = '" + loc_id + "' "
                + "   ";

        String where2 = " where main_barcode ='" + my_item_code + "'  and location_id = '" + loc_id + "' and status=1 "
                + "  ";
        String where4 = " where main_barcode ='" + my_item_code + "'  and branch_id = '" + loc_id + "' "
                + "  ";
        String where3 = " where barcode ='" + my_item_code + "'    "
                + "  ";
        String wheree = " where item_code ='" + my_item_code + "'  and location_id = '" + loc_id + "' and status=1 "
                + "   ";
        String where5 = " where main_barcode ='" + my_item_code + "'  and from_location_id = '" + loc_id + "' and status=1 "
                + "  or main_barcode ='" + my_item_code + "'  and to_location_id = '" + loc_id + "' and status=1";
        if (!date_from.isEmpty()) {
            where = " where item_code ='" + my_item_code + "'  and location_id = '" + loc_id + "' and Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + "   ";
            where2 = " where main_barcode ='" + my_item_code + "'  and location_id = '" + loc_id + "' and status=1 and Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + "  ";
            where3 = " where barcode ='" + my_item_code + "'  and Date(date_added) between '" + date_from + "' and '" + date_to + "'  "
                    + "  ";
            where4 = " where main_barcode ='" + my_item_code + "'  and branch_id = '" + loc_id + "' and Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + "  ";

            wheree = " where item_code ='" + my_item_code + "'  and location_id = '" + loc_id + "' and status=1  and Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + "   ";

            where5 = " where main_barcode ='" + my_item_code + "'  and from_location_id = '" + loc_id + "' and status=1 and Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + "  or main_barcode ='" + my_item_code + "'  and to_location_id = '" + loc_id + "' and status=1 and Date(date_added) between '" + date_from + "' and '" + date_to + "'";
        }
//        System.out.println(where);
        List<Srpt_item_ledger.field> sales = new ArrayList();//Srpt_item_ledger.sales(where);
        List<Srpt_item_ledger.field> inventory_count = new ArrayList();// Srpt_item_ledger.inventory_encoding(where);
        List<Srpt_item_ledger.field> receipts = new ArrayList(); //Srpt_item_ledger.receipts(where2);
        List<Srpt_item_ledger.field> transfers = new ArrayList(); //Srpt_item_ledger.transfer(where3);
        List<Srpt_item_ledger.field> adjustments = new ArrayList(); //Srpt_item_ledger.adjustments(where);
        List<Srpt_item_ledger.field> return_exchange = new ArrayList(); //Srpt_item_ledger.item_replacements(where);
        List<Srpt_item_ledger.field> charge_in_advance = new ArrayList(); //Srpt_item_ledger.charge_items(where);
        List<Srpt_item_ledger.field> charge_in_advance_cancelled = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
        List<Srpt_item_ledger.field> replenishments = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
        List<Srpt_item_ledger.field> requistion_slips = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
        List<Srpt_item_ledger.field> return_from_customer = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
        List<Srpt_item_ledger.field> conversions = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
        List<Srpt_item_ledger.field> other_adjustments = new ArrayList();
        List<Srpt_item_ledger.field> return_to_supplier = new ArrayList(); // Srpt_item_ledger.charge_in_advance_cancelled(where);
        List<Srpt_item_ledger.field> returns_exchange2 = new ArrayList();
//                    System.out.println(where);
        try {
            Connection conn = MyConnection.connect();

            //<editor-fold defaultstate="collapsed" desc=" sales ">
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
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + sales_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String months = DateType.convert_datetime_to_month(date_added);

                Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                sales.add(field);

                if (status == 1) {
                    Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Sales - X", date, FitIn.fmt_woc(product_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    sales.add(field2);
                }

            }

            //</editor-fold>                    
            //<editor-fold defaultstate="collapsed" desc=" Inventory Count ">
            String s2 = "select "
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
                    + " from encoding_inventory"
                    + " " + wheree;

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                int id = rs2.getInt(1);
                String item_code = rs2.getString(2);
                String barcode = rs2.getString(3);
                String description = rs2.getString(4);
                String branch = rs2.getString(5);
                String branch_id = rs2.getString(6);
                String location = rs2.getString(7);
                String location_id = rs2.getString(8);
                double qty = rs2.getDouble(9);
                String date_added = rs2.getString(10);
                String user_name = rs2.getString(11);
                String screen_name = rs2.getString(12);
                String sheet_no = rs2.getString(13);
                int status = rs2.getInt(14);
                String counted_by = rs2.getString(15);
                String checked_by = rs2.getString(16);
                double cost = rs2.getDouble(17);
                double selling_price = rs2.getDouble(18);
                String user_id = rs2.getString(19);
                String user_screen_name = rs2.getString(20);

                String transaction_type = "Inventory Count";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + sheet_no;
                String cost1 = FitIn.fmt_wc_0(cost);
                String price1 = FitIn.fmt_wc_0(selling_price);
                String months = DateType.convert_datetime_to_month(date_added);
                Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");

                inventory_count.add(field);
            }
            //</editor-fold>                   
            //<editor-fold defaultstate="collapsed" desc=" Receipts ">
            String s3 = "select "
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
                    + " " + where4;
//                        System.out.println(where4);
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            while (rs3.next()) {
                int id = rs3.getInt(1);
                String receipt_no = rs3.getString(2);
                String user_name = rs3.getString(3);
                String session_no = rs3.getString(4);
                String date_added = rs3.getString(5);
                String supplier = rs3.getString(6);
                String supllier_id = rs3.getString(7);
                String remarks = rs3.getString(8);
                String barcode = rs3.getString(9);
                String description = rs3.getString(10);
                double qty = rs3.getDouble(11);
                double cost = rs3.getDouble(12);
                String category = rs3.getString(13);
                String category_id = rs3.getString(14);
                String classification = rs3.getString(15);
                String classification_id = rs3.getString(16);
                String sub_class = rs3.getString(17);
                String sub_class_id = rs3.getString(18);
                double conversion = rs3.getDouble(19);
                String unit = rs3.getString(20);
                String date_delivered = rs3.getString(21);
                String date_received = rs3.getString(22);
                String barcodes = rs3.getString(23);
                String batch_no = rs3.getString(24);
                String serial_no = rs3.getString(25);
                String main_barcode = rs3.getString(26);
                String brand = rs3.getString(27);
                String brand_id = rs3.getString(28);
                String model = rs3.getString(29);
                String model_id = rs3.getString(30);
                int status = rs3.getInt(31);
                double previous_cost = rs3.getDouble(32);
                String receipt_type_id = rs3.getString(33);
                String branch = rs3.getString(34);
                String branch_id = rs3.getString(35);
                String location = rs3.getString(36);
                String location_id = rs3.getString(37);

                String transaction_type = "Receipts";

                String time = date_added.substring(10, date_added.length());
                String sf_time = date_received + " " + time;

                String date = servicing.utils.DateType.convert_slash_datetime3(sf_time);
                qty = qty * conversion;
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
                    created = servicing.utils.DateType.datetime.parse(sf_time);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + receipt_no;
                String cost1 = FitIn.fmt_wc_0(cost);
                String price1 = "";
                String months = DateType.convert_datetime_to_month(sf_time);

                Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_branch, from_branch_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                if (status == 1) {
                    receipts.add(field);
                }
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Transfers ">
            List<Srpt_item_ledger.field> transfer_in = new ArrayList();
            List<Srpt_item_ledger.field> transfer_out = new ArrayList();
            String s4 = "select "
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
                    + " " + where3;

            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                int id = rs4.getInt(1);
                String barcode = rs4.getString(2);
                String description = rs4.getString(3);
                String generic_name = rs4.getString(4);
                String category = rs4.getString(5);
                String category_id = rs4.getString(6);
                String classification = rs4.getString(7);
                String classification_id = rs4.getString(8);
                String sub_classification = rs4.getString(9);
                String sub_classification_id = rs4.getString(10);
                double product_qty = rs4.getDouble(11);

                String unit = rs4.getString(12);
                double conversion = rs4.getDouble(13);
                product_qty = product_qty * conversion;

                double selling_price = rs4.getDouble(14);
                String date_added = rs4.getString(15);
                String user_name = rs4.getString(16);
                String item_type = rs4.getString(17);
                int status = rs4.getInt(18);
                String supplier = rs4.getString(19);
                int fixed_price = rs4.getInt(20);
                double cost = rs4.getDouble(21);
                String supplier_id = rs4.getString(22);
                int multi_level_pricing = rs4.getInt(23);
                int vatable = rs4.getInt(24);
                double reorder_level = rs4.getDouble(25);
                double markup = rs4.getDouble(26);
                String barcodes = rs4.getString(27);
                String brand = rs4.getString(28);
                String brand_id = rs4.getString(29);
                String model = rs4.getString(30);
                String model_id = rs4.getString(31);
                int selling_type = rs4.getInt(32);
                String branch = rs4.getString(33);
                String branch_code = rs4.getString(34);
                String location = rs4.getString(35);
                String location_id = rs4.getString(36);
                String stock_transfer_id = rs4.getString(37);
                String serial_no = rs4.getString(38);
                String to_branch = rs4.getString(39);
                String to_branch_id = rs4.getString(40);
                String to_location = rs4.getString(41);
                String to_location_id = rs4.getString(42);

                String transaction_type = "Transfer";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }

                String transaction_no = "" + stock_transfer_id;
                String cost1 = FitIn.fmt_wc_0(cost);
                String price1 = "";
                String months = DateType.convert_datetime_to_month(date_added);
                String remarks1 = "To: " + to_branch + " - " + to_location;
                String remarks2 = "Fr: " + from_branch + " - " + from_location;
                Srpt_item_ledger.field field_out = new Srpt_item_ledger.field("Transfer-Out", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, remarks1);

                Srpt_item_ledger.field field_in = new Srpt_item_ledger.field("Transfer-In", date, FitIn.fmt_woc(product_qty), "", balance, to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, remarks2);

                if (status == 1) {

                    if (loc_id.equalsIgnoreCase(to_location_id)) {
                        transfer_in.add(field_in);
                    }

                    if (loc_id.equalsIgnoreCase(location_id)) {
                        transfer_out.add(field_out);
                    }

                }
            }

            transfers.addAll(transfer_in);
            transfers.addAll(transfer_out);

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Adjustments ">
            List<Srpt_item_ledger.field> adjustment_add = new ArrayList();
            List<Srpt_item_ledger.field> adjustment_deduct = new ArrayList();
            String s5 = "select "
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
                    + " from adjustments"
                    + " " + where;

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                int id = rs5.getInt(1);
                String item_code = rs5.getString(2);
                String barcode = rs5.getString(3);
                String description = rs5.getString(4);
                double qty = rs5.getDouble(5);
                double new_qty = rs5.getDouble(6);
                int is_add = rs5.getInt(7);
                String date_added = rs5.getString(8);
                int status = rs5.getInt(9);
                String user_id = rs5.getString(10);
                String user_screen_name = rs5.getString(11);
                String branch = rs5.getString(12);
                String branch_id = rs5.getString(13);
                String location = rs5.getString(14);
                String location_id = rs5.getString(15);
                String remarks = rs5.getString(16);
                String transaction_type = "Adjustment";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + id;
                String cost1 = "";
                String price1 = "";
                String months = DateType.convert_datetime_to_month(date_added);
                if (is_add == 1) {
                    Srpt_item_ledger.field add = new Srpt_item_ledger.field("Adjustment-Add", date, FitIn.fmt_woc(new_qty), "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, remarks, created, transaction_no, cost1, price1, months, "");
                    adjustment_add.add(add);
                } else {
                    Srpt_item_ledger.field deduct = new Srpt_item_ledger.field("Adjustment-Deduct", date, "", FitIn.fmt_woc(new_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, remarks, created, transaction_no, cost1, price1, months, "");
                    adjustment_deduct.add(deduct);
                }

            }
            adjustments.addAll(adjustment_add);
            adjustments.addAll(adjustment_deduct);

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Return Exchange ">
            String s6 = "select "
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
            Statement stmt6 = conn.createStatement();
            ResultSet rs6 = stmt6.executeQuery(s6);
            while (rs6.next()) {
                int id = rs6.getInt(1);
                String sales_no = rs6.getString(2);
                String item_code = rs6.getString(3);
                String barcode = rs6.getString(4);
                String description = rs6.getString(5);
                String generic_name = rs6.getString(6);
                String item_type = rs6.getString(7);
                String supplier_name = rs6.getString(8);
                String supplier_id = rs6.getString(9);
                String serial_no = rs6.getString(10);
                double product_qty = rs6.getDouble(11);
                String unit = rs6.getString(12);
                double conversion = rs6.getDouble(13);
                double selling_price = rs6.getDouble(14);
                String date_added = rs6.getString(15);
                String user_id = rs6.getString(16);
                String user_screen_name = rs6.getString(17);
                int status = rs6.getInt(18);
                int is_vatable = rs6.getInt(19);
                int selling_type = rs6.getInt(20);
                String discount_name = rs6.getString(21);
                double discount_rate = rs6.getDouble(22);
                double discount_amount = rs6.getDouble(23);
                String discount_customer_name = rs6.getString(24);
                String discount_customer_id = rs6.getString(25);
                String branch = rs6.getString(26);
                String branch_code = rs6.getString(27);
                String location = rs6.getString(28);
                String location_id = rs6.getString(29);
                String category = rs6.getString(30);
                String category_id = rs6.getString(31);
                String classification = rs6.getString(32);
                String classification_id = rs6.getString(33);
                String sub_classification = rs6.getString(34);
                String sub_classification_id = rs6.getString(35);
                String brand = rs6.getString(36);
                String brand_id = rs6.getString(37);
                String model = rs6.getString(38);
                String model_id = rs6.getString(39);
                int is_replacement = rs6.getInt(40);

                String transaction_type = "Exc-Replacement";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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
                    created = servicing.utils.DateType.datetime.parse(date_added);
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

                    String s100 = "select "
                            + " date_added "
                            + " from sales "
                            + " where sales_no='" + sales_no + "' ";

                    Statement stmt100 = conn.createStatement();
                    ResultSet rs100 = stmt100.executeQuery(s100);
                    String date_added1 = "";
                    if (rs100.next()) {
                        date_added1 = rs100.getString(1);
                    }
                    String months1 = servicing.utils.DateType.convert_slash_datetime3(date_added1);

                    String months = DateType.convert_datetime_to_month(date_added);
                    Srpt_item_ledger.field field1 = new Srpt_item_ledger.field("Sales", months1, "", in, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    return_exchange.add(field1);

                    Srpt_item_ledger.field field11 = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, "" + id, cost1, price1, months, "");
                    return_exchange.add(field11);
                }

            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Charge in Advance ">
            String s7 = "select "
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

            Statement stmt7 = conn.createStatement();
            ResultSet rs7 = stmt7.executeQuery(s7);
            while (rs7.next()) {
                int id = rs7.getInt(1);
                String customer_id = rs7.getString(2);
                String customer_name = rs7.getString(3);
                String ar_id = rs7.getString(4);
                String ar_no = rs7.getString(5);
                String date_applied = rs7.getString(6);
                String reference_no = rs7.getString(7);
                String soa_type = rs7.getString(8);
                String soa_type_id = rs7.getString(9);
                String user_screen_name = rs7.getString(10);
                String user_id = rs7.getString(11);
                String remarks = rs7.getString(12);
                String item_code = rs7.getString(13);
                String barcode = rs7.getString(14);
                String description = rs7.getString(15);
                String generic_name = rs7.getString(16);
                String item_type = rs7.getString(17);
                String supplier_name = rs7.getString(18);
                String supplier_id = rs7.getString(19);
                String serial_no = rs7.getString(20);
                double product_qty = rs7.getDouble(21);
                String unit = rs7.getString(22);
                double conversion = rs7.getDouble(23);
                double selling_price = rs7.getDouble(24);
                String date_added = rs7.getString(25);
                int status = rs7.getInt(26);
                int is_vatable = rs7.getInt(27);
                int selling_type = rs7.getInt(28);
                String discount_name = rs7.getString(29);
                double discount_rate = rs7.getDouble(30);
                double discount_amount = rs7.getDouble(31);
                String discount_customer_name = rs7.getString(32);
                String discount_customer_id = rs7.getString(33);
                String branch = rs7.getString(34);
                String branch_code = rs7.getString(35);
                String location = rs7.getString(36);
                String location_id = rs7.getString(37);
                String category = rs7.getString(38);
                String category_id = rs7.getString(39);
                String classification = rs7.getString(40);
                String classification_id = rs7.getString(41);
                String sub_classification = rs7.getString(42);
                String sub_classification_id = rs7.getString(43);
                String brand = rs7.getString(44);
                String brand_id = rs7.getString(45);
                String model = rs7.getString(46);
                String model_id = rs7.getString(47);
                double addtl_amount = rs7.getDouble(48);
                double wtax = rs7.getDouble(49);

                String transaction_type = "Charge in Advance[-]";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + ar_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String months = DateType.convert_datetime_to_month(date_added);

                if (status == 0) {
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    charge_in_advance.add(field);
                } else {
                    Srpt_item_ledger.field field = new Srpt_item_ledger.field("Charge in Advance[+]", date, out, "", balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    charge_in_advance.add(field);
                }

            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Replenishment ">
            String s9 = "select "
                    + "id"
                    + ",inventory_replenishment_no"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_id"
                    + ",user_screen_name"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from inventory_replenishment_items"
                    + " " + wheree;

            Statement stmt9 = conn.createStatement();
            ResultSet rs9 = stmt9.executeQuery(s9);
            while (rs9.next()) {
                int id = rs9.getInt(1);
                String inventory_replenishment_no = rs9.getString(2);
                String item_code = rs9.getString(3);
                String barcode = rs9.getString(4);
                String description = rs9.getString(5);
                double product_qty = rs9.getDouble(6);
                String unit = rs9.getString(7);
                double conversion = rs9.getDouble(8);
                double selling_price = rs9.getDouble(9);
                String date_added = rs9.getString(10);
                String user_id = rs9.getString(11);
                String user_screen_name = rs9.getString(12);
                int status = rs9.getInt(13);
                String branch = rs9.getString(14);
                String branch_id = rs9.getString(15);
                String location = rs9.getString(16);
                String location_id = rs9.getString(17);

                String transaction_type = "Replenishment";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                String in = "";
                String out = FitIn.fmt_woc(product_qty);

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
                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + inventory_replenishment_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String months = DateType.convert_datetime_to_month(date_added);
                Srpt_item_ledger.field field = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, user_screen_name, created, transaction_no, cost1, price1, months, "");
                replenishments.add(field);
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Requisition Slip ">
            String s10 = "select "
                    + "id"
                    + ",requisition_slip_no"
                    + ",requisition_date"
                    + ",requisition_type"
                    + ",requisition_department"
                    + ",requisition_department_id"
                    + ",requested_by"
                    + ",item_code"
                    + ",barcode"
                    + ",description"
                    + ",product_qty"
                    + ",unit"
                    + ",cost"
                    + ",selling_price"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",date_added"
                    + ",status"
                    + " from requisition_slip_items"
                    + " " + wheree;

            Statement stmt10 = conn.createStatement();
            ResultSet rs10 = stmt10.executeQuery(s10);
            while (rs10.next()) {
                int id = rs10.getInt(1);
                String requisition_slip_no = rs10.getString(2);
                String requisition_date = rs10.getString(3);
                String requisition_type = rs10.getString(4);
                String requisition_department = rs10.getString(5);
                String requisition_department_id = rs10.getString(6);
                String requested_by = rs10.getString(7);
                String item_code = rs10.getString(8);
                String barcode = rs10.getString(9);
                String description = rs10.getString(10);
                double product_qty = rs10.getDouble(11);

                String unit = rs10.getString(12);
                String uom = unit;
                String[] list = uom.split(",");
                String unit1 = "";
                double conversion = 1;
                int o = 0;
                for (String s : list) {
                    int i = s.indexOf(":");
                    int ii = s.indexOf("/");
                    conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                    unit1 = s.substring(1, i);
                    o++;
                }
                product_qty = product_qty * conversion;
                double cost = rs10.getDouble(13);
                double selling_price = rs10.getDouble(14);
                String branch = rs10.getString(15);
                String branch_id = rs10.getString(16);
                String location = rs10.getString(17);
                String location_id = rs10.getString(18);
                String date_added = rs10.getString(19);
                int status = rs10.getInt(20);

                String transaction_type = "Sales";
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                String in = "";
                String out = FitIn.fmt_woc(product_qty);
                String balance = "";
                String from_branch = branch;
                String from_branch_id = branch_id;
                String from_location = location;
                String from_location_id = location_id;
                String to_branch = "";
                String to_branch_id = "";
                String to_location = "";
                String to_location_id = "";
                String created_by = requested_by;
                String customer_name = "";
                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + requisition_slip_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String months = DateType.convert_datetime_to_month(date_added);
                if (status == 1) {
                    Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Requisition Slip", date, "", FitIn.fmt_woc(product_qty), balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, transaction_no, cost1, price1, months, "");
                    requistion_slips.add(field2);
                }
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Return from Customer ">
            String s12 = "select "
                    + "id"
                    + ",return_from_customer_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from return_from_customer_items"
                    + " " + where2;

            Statement stmt12 = conn.createStatement();
            ResultSet rs12 = stmt12.executeQuery(s12);
            while (rs12.next()) {
                int id = rs12.getInt(1);
                String user_name = rs12.getString(3);
                String date_added = rs12.getString(5);
                String reference_no = rs12.getString(8);
                double qty = rs12.getDouble(28);
                double cost = rs12.getDouble(29);

                String branch = rs12.getString(31);
                String branch_id = rs12.getString(32);
                String location = rs12.getString(33);
                String location_id = rs12.getString(34);
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                String months = DateType.convert_datetime_to_month(date_added);
                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Customer Return/s", date, FitIn.fmt_woc(qty), "", "", branch, branch_id, location, location_id, branch, branch_id, location, location_id, user_name, "", created, "" + id, FitIn.fmt_wc_0(cost), "" + FitIn.fmt_wc_0(cost), months, "");
                return_from_customer.add(field2);
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" conversions ">
            String s13 = "select "
                    + "id"
                    + ",conversion_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",reference_no"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",status"
                    + ",from_branch"
                    + ",from_branch_id"
                    + ",from_location"
                    + ",from_location_id"
                    + ",to_branch"
                    + ",to_branch_id"
                    + ",to_location"
                    + ",to_location_id"
                    + ",is_converted_from"
                    + " from conversion_items"
                    + " " + where5;

            Statement stmt13 = conn.createStatement();
            ResultSet rs13 = stmt13.executeQuery(s13);
            while (rs13.next()) {
                int id = rs13.getInt(1);
                String conversion_no = rs13.getString(2);
                String user_name = rs13.getString(3);
                String session_no = rs13.getString(4);
                String date_added = rs13.getString(5);
                String reference_no = rs13.getString(6);
                String remarks = rs13.getString(7);
                String barcode = rs13.getString(8);
                String description = rs13.getString(9);
                String category = rs13.getString(10);
                String category_id = rs13.getString(11);
                String classification = rs13.getString(12);
                String classification_id = rs13.getString(13);
                String sub_class = rs13.getString(14);
                String sub_class_id = rs13.getString(15);
                String brand = rs13.getString(16);
                String brand_id = rs13.getString(17);
                String model = rs13.getString(18);
                String model_id = rs13.getString(19);
                double conversion = rs13.getDouble(20);
                String unit = rs13.getString(21);
                String barcodes = rs13.getString(22);
                String batch_no = rs13.getString(23);
                String serial_no = rs13.getString(24);
                String main_barcode = rs13.getString(25);
                double qty = rs13.getDouble(26);
                qty = qty * conversion;
                double cost = rs13.getDouble(27);
                int status = rs13.getInt(28);
                String from_branch = rs13.getString(29);
                String from_branch_id = rs13.getString(30);
                String from_location = rs13.getString(31);
                String from_location_id = rs13.getString(32);
                String to_branch = rs13.getString(33);
                String to_branch_id = rs13.getString(34);
                String to_location = rs13.getString(35);
                String to_location_id = rs13.getString(36);
                int is_converted_from = rs13.getInt(37);

                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                String months = DateType.convert_datetime_to_month(date_added);
                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (is_converted_from == 1) {
                    Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Conversion - From", date, "", FitIn.fmt_woc(qty), "", from_branch, from_branch_id, from_location, from_location_id, "", "", "", "", user_name, "", created, "" + id, FitIn.fmt_wc_0(cost), "" + FitIn.fmt_wc_0(cost), months, "");
                    conversions.add(field2);
                } else {
                    Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Conversion - To", date, FitIn.fmt_woc(qty), "", "", to_branch, to_branch_id, to_location, to_location_id, "", "", "", "", user_name, "", created, "" + id, FitIn.fmt_wc_0(cost), "" + FitIn.fmt_wc_0(cost), months, "");
                    conversions.add(field2);
                }

            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Other Adjustments ">

            String s30 = "select "
                    + " adjustment_date"
                    + ",adjustment_type"
                    + ",status"
                    + ",description"
                    + ",conversion"
                    + ",unit"
                    + ",main_barcode"
                    + ",qty"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + ",user_screen_name"
                    + ",selling_price"
                    + ",id"
                    + " from other_adjustments"
                    + " " + where2;

            Statement stmt30 = conn.createStatement();
            ResultSet rs30 = stmt30.executeQuery(s30);
            while (rs30.next()) {
                String adjustment_date = rs30.getString(1);
                int adjustment_type = rs30.getInt(2);
                int status = rs30.getInt(3);
                String description = rs30.getString(4);
                double convers30ion = rs30.getDouble(5);
                String unit = rs30.getString(6);
                String main_barcode = rs30.getString(7);
                double qty = rs30.getDouble(8);
                String branch = rs30.getString(9);
                String branch_id = rs30.getString(10);
                String location = rs30.getString(11);
                String location_id = rs30.getString(12);
                String user_screen_name = rs30.getString(13);
                double selling_price = rs30.getDouble(14);
                int id = rs30.getInt(15);
                String type = "";
                if (adjustment_type == 0) {
                    type = "Damage";
                }
                if (adjustment_type == 1) {
                    type = "Leftover";
                }
                if (adjustment_type == 2) {
                    type = "Voucher";
                }
                if (adjustment_type == 3) {
                    type = "Short";
                }
                if (adjustment_type == 4) {
                    type = "Over";
                }
                if (adjustment_type == 5) {
                    type = "Pull Out";
                }
                String date = servicing.utils.DateType.convert_slash_datetime3(adjustment_date);
                String months = DateType.convert_datetime_to_month(adjustment_date);
                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(adjustment_date);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (status == 1) {
                    if (adjustment_type == 4) {
                        Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Adjustment-" + type, date, FitIn.fmt_woc(qty), "", "", branch, branch_id, location, location_id, "", "", "", "", user_screen_name, "", created, "" + id, FitIn.fmt_wc_0(selling_price), "" + FitIn.fmt_wc_0(selling_price), months, "");
                        other_adjustments.add(field2);
                    } else {
                        Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Adjustment-" + type, date, "", FitIn.fmt_woc(qty), "", branch, branch_id, location, location_id, "", "", "", "", user_screen_name, "", created, "" + id, FitIn.fmt_wc_0(selling_price), "" + FitIn.fmt_wc_0(selling_price), months, "");
                        other_adjustments.add(field2);
                    }
                }
            }

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Return to Customer ">
            String s15 = "select "
                    + "id"
                    + ",return_to_supplier_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supplier_id"
                    + ",reference_no"
                    + ",remarks"
                    + ",barcode"
                    + ",description"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_class"
                    + ",sub_class_id"
                    + ",brand"
                    + ",brand_id"
                    + ",model"
                    + ",model_id"
                    + ",conversion"
                    + ",unit"
                    + ",barcodes"
                    + ",batch_no"
                    + ",serial_no"
                    + ",main_barcode"
                    + ",qty"
                    + ",cost"
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from return_to_supplier_items"
                    + " " + where2;

            Statement stmt15 = conn.createStatement();
            ResultSet rs15 = stmt15.executeQuery(s15);
            while (rs15.next()) {
                int id = rs15.getInt(1);
                String user_name = rs15.getString(3);
                String date_added = rs15.getString(5);
                String reference_no = rs15.getString(8);
                double qty = rs15.getDouble(28);
                double cost = rs15.getDouble(29);

                String branch = rs15.getString(31);
                String branch_id = rs15.getString(32);
                String location = rs15.getString(33);
                String location_id = rs15.getString(34);
                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
                String months = DateType.convert_datetime_to_month(date_added);
                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                Srpt_item_ledger.field field2 = new Srpt_item_ledger.field("Return to Supplier", date, "", FitIn.fmt_woc(qty), "", branch, branch_id, location, location_id, branch, branch_id, location, location_id, user_name, "", created, "" + id, FitIn.fmt_wc_0(cost), "" + FitIn.fmt_wc_0(cost), months, "");
                return_to_supplier.add(field2);
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" Return Exchange2 ">
            String s20 = "select "
                    + "id"
                    + ",item_replacement_no"
                    + ",sales_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",date_added"
                    + ",user_screen_name"
                    + ",user_id"
                    + ",item_code"
                    + ",barcode"
                    + ",generic_name"
                    + ",description"
                    + ",item_type"
                    + ",serial_no"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",is_vatable"
                    + ",selling_type"
                    + ",discount_name"
                    + ",discount_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
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
                    + ",status"
                    + ",branch"
                    + ",branch_id"
                    + ",location"
                    + ",location_id"
                    + " from item_replacement_details"
                    + " " + wheree;

            Statement stmt20 = conn.createStatement();
            ResultSet rs20 = stmt20.executeQuery(s20);
            while (rs20.next()) {
                int id = rs20.getInt(1);
                String item_replacement_no = rs20.getString(2);
                String sales_no = rs20.getString(3);
                String customer_name = rs20.getString(4);
                String customer_id = rs20.getString(5);
                String date_added = rs20.getString(6);
                String user_screen_name = rs20.getString(7);
                String user_id = rs20.getString(8);
                String item_code = rs20.getString(9);
                String barcode = rs20.getString(10);
                String generic_name = rs20.getString(11);
                String description = rs20.getString(12);
                String item_type = rs20.getString(13);
                String serial_no = rs20.getString(14);
                double product_qty = rs20.getDouble(15);
                String unit = rs20.getString(16);
                double convers20ion = rs20.getDouble(17);
                double selling_price = rs20.getDouble(18);
                int is_vatable = rs20.getInt(19);
                int selling_type = rs20.getInt(20);
                String discount_name = rs20.getString(21);
                double discount_amount = rs20.getDouble(22);
                String discount_customer_name = rs20.getString(23);
                String discount_customer_id = rs20.getString(24);
                String category = rs20.getString(25);
                String category_id = rs20.getString(26);
                String classification = rs20.getString(27);
                String classification_id = rs20.getString(28);
                String sub_classification = rs20.getString(29);
                String sub_classification_id = rs20.getString(30);
                String brand = rs20.getString(31);
                String brand_id = rs20.getString(32);
                String model = rs20.getString(33);
                String model_id = rs20.getString(34);
                int is_replacement = rs20.getInt(35);
                String reason = rs20.getString(36);
                int status = rs20.getInt(37);
                String branch = rs20.getString(38);
                String branch_id = rs20.getString(39);
                String location = rs20.getString(40);
                String location_id = rs20.getString(41);

                String date = servicing.utils.DateType.convert_slash_datetime3(date_added);
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

                Date created = new Date();
                try {
                    created = servicing.utils.DateType.datetime.parse(date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_item_ledger.class.getName()).log(Level.SEVERE, null, ex);
                }
                String transaction_no = "" + sales_no;
                String cost1 = "";
                String price1 = FitIn.fmt_wc_0(selling_price);
                String transaction_type = "Exc-Returned";
                String in = FitIn.fmt_woc(product_qty);
                String out = "";

                if (is_replacement == 1) {
                    transaction_type = "Exc-Replacement";
                    in = "";
                    out = FitIn.fmt_woc(product_qty);
                }

                String months = DateType.convert_datetime_to_month(date_added);

                Srpt_item_ledger.field field11 = new Srpt_item_ledger.field(transaction_type, date, in, out, balance, from_branch, from_branch_id, from_location, from_location_id, to_branch, to_branch_id, to_location, to_location_id, created_by, customer_name, created, item_replacement_no, cost1, price1, months, "");
                returns_exchange2.add(field11);

            }
            //</editor-fold>
            fields.addAll(inventory_count);
            fields.addAll(sales);
            fields.addAll(receipts);
            fields.addAll(transfers);
            fields.addAll(adjustments);
            fields.addAll(return_exchange);
            fields.addAll(charge_in_advance);
            fields.addAll(charge_in_advance_cancelled);
            fields.addAll(replenishments);
            fields.addAll(requistion_slips);
            fields.addAll(return_from_customer);
            fields.addAll(conversions);
            fields.addAll(other_adjustments);
            fields.addAll(return_to_supplier);
            fields.addAll(returns_exchange2);
            List<Srpt_item_ledger.field> f_field = new ArrayList();

            Collections.sort(fields, new Comparator<Srpt_item_ledger.field>() {
                         @Override
                         public int compare(Srpt_item_ledger.field o1, Srpt_item_ledger.field o2) {
                             return o1.getDate_added().compareTo(o2.getDate_added());
                         }
                     });

            double running_balance = 0;
            double qty = 0;
            for (Srpt_item_ledger.field f : fields) {
                if (FitIn.toDouble(f.getIn()) > 0) {
                    qty += FitIn.toDouble(f.getIn());
                } else {
                    qty -= FitIn.toDouble(f.getOut());
                }
                if (f.transaction_type.equalsIgnoreCase("Replenishment")) {
                    qty = 0;
                }
                f.setFrom_branch(my_branch);
                f.setFrom_location(my_location);
                f.setBalance(FitIn.fmt_woc(qty));
                if (show_cost == 0) {
                    f.setCost("");
                }
                field3.add(f);
            }

            List<Srpt_item_ledger.field> fields2 = new ArrayList();

            for (Srpt_item_ledger.field to2 : field3) {
                String m = DateType.m1.format(to2.date_added);
                String y = DateType.y.format(to2.date_added);
                if (all_year == 1) {
                    fields2.add(to2);
                    running_balance = FitIn.toDouble(to2.getBalance());
                } else {
                    if (year.equals(y) && is_month_selected == true) {
                        fields2.add(to2);
                        running_balance = FitIn.toDouble(to2.getBalance());
                    }
                    if (year.equals(y) && is_month_selected == false) {
                        if (month == FitIn.toInt(m)) {
                            fields2.add(to2);
                            running_balance = FitIn.toDouble(to2.getBalance());
                        }
                    }
                }

            }

            String business_name = System.getProperty("business_name", "Algorithm Computer Services");
            String contact_no = System.getProperty("telephone_number", "");
            String address = System.getProperty("address", "Dumaguete City");
            String date = year;
            String item_code = my_item_code;
            String barcode = my_barcode;
            String description = my_description;
            String branch = my_branch;
            String location = my_location;

            int m = month - 1;
//            System.out.println("m: "+m);
            String[] mm = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

            Srpt_item_ledger rpt = new Srpt_item_ledger(business_name, address, contact_no, date, item_code, barcode, description, branch, location, mm[m], running_balance);
            rpt.fields.addAll(fields2);

            return rpt;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

//                
    }

}
