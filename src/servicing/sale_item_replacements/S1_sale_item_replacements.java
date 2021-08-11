/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.sale_item_replacements;

//import servicing.inventory.Dlg_inventory_uom;
import servicing.inventory.Inventory;
import servicing.inventory.Inventory_barcodes;
import servicing.inventory.uom;
import servicing.my_sales.MySales;
import servicing.my_sales.MySales_Items;
import servicing.receipts.S1_receipt_items;
import servicing.users.MyUser;
import servicing.utils.DateType;
import servicing.utils.MyConnection;
import servicing.utils.Segregator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.inventory.Dlg_inventory_uom;

/**
 *
 * @author Guinness
 */
public class S1_sale_item_replacements {

    public static class to_sale_item_replacements {

        public final int id;
        public final String sales_no;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String item_type;
        public final String supplier_name;
        public final String supplier_id;
        public final String serial_no;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_id;
        public final String user_screen_name;
        public final int status;
        public final int is_vatable;
        public final int selling_type;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int is_replacement;
        public final String reason;

        public to_sale_item_replacements(int id, String sales_no, String item_code, String barcode, String description, String generic_name, String item_type, String supplier_name, String supplier_id, String serial_no, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_id, String user_screen_name, int status, int is_vatable, int selling_type, String discount_name, double discount_rate, double discount_amount, String discount_customer_name, String discount_customer_id, String branch, String branch_code, String location, String location_id, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, String brand, String brand_id, String model, String model_id, int is_replacement, String reason) {
            this.id = id;
            this.sales_no = sales_no;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.item_type = item_type;
            this.supplier_name = supplier_name;
            this.supplier_id = supplier_id;
            this.serial_no = serial_no;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.status = status;
            this.is_vatable = is_vatable;
            this.selling_type = selling_type;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.is_replacement = is_replacement;
            this.reason = reason;
        }
    }

    public static void add_data(to_sale_item_replacements to_sale_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sale_item_replacements("
                    + "sales_no"
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
                    + ")values("
                    + ":sales_no"
                    + ",:item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:generic_name"
                    + ",:item_type"
                    + ",:supplier_name"
                    + ",:supplier_id"
                    + ",:serial_no"
                    + ",:product_qty"
                    + ",:unit"
                    + ",:conversion"
                    + ",:selling_price"
                    + ",:date_added"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:status"
                    + ",:is_vatable"
                    + ",:selling_type"
                    + ",:discount_name"
                    + ",:discount_rate"
                    + ",:discount_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:branch"
                    + ",:branch_code"
                    + ",:location"
                    + ",:location_id"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_classification"
                    + ",:sub_classification_id"
                    + ",:brand"
                    + ",:brand_id"
                    + ",:model"
                    + ",:model_id"
                    + ",:is_replacement"
                    + ",:reason"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_item_replacements.sales_no)
                    .setString("item_code", to_sale_item_replacements.item_code)
                    .setString("barcode", to_sale_item_replacements.barcode)
                    .setString("description", to_sale_item_replacements.description)
                    .setString("generic_name", to_sale_item_replacements.generic_name)
                    .setString("item_type", to_sale_item_replacements.item_type)
                    .setString("supplier_name", to_sale_item_replacements.supplier_name)
                    .setString("supplier_id", to_sale_item_replacements.supplier_id)
                    .setString("serial_no", to_sale_item_replacements.serial_no)
                    .setNumber("product_qty", to_sale_item_replacements.product_qty)
                    .setString("unit", to_sale_item_replacements.unit)
                    .setNumber("conversion", to_sale_item_replacements.conversion)
                    .setNumber("selling_price", to_sale_item_replacements.selling_price)
                    .setString("date_added", to_sale_item_replacements.date_added)
                    .setString("user_id", to_sale_item_replacements.user_id)
                    .setString("user_screen_name", to_sale_item_replacements.user_screen_name)
                    .setNumber("status", to_sale_item_replacements.status)
                    .setNumber("is_vatable", to_sale_item_replacements.is_vatable)
                    .setNumber("selling_type", to_sale_item_replacements.selling_type)
                    .setString("discount_name", to_sale_item_replacements.discount_name)
                    .setNumber("discount_rate", to_sale_item_replacements.discount_rate)
                    .setNumber("discount_amount", to_sale_item_replacements.discount_amount)
                    .setString("discount_customer_name", to_sale_item_replacements.discount_customer_name)
                    .setString("discount_customer_id", to_sale_item_replacements.discount_customer_id)
                    .setString("branch", to_sale_item_replacements.branch)
                    .setString("branch_code", to_sale_item_replacements.branch_code)
                    .setString("location", to_sale_item_replacements.location)
                    .setString("location_id", to_sale_item_replacements.location_id)
                    .setString("category", to_sale_item_replacements.category)
                    .setString("category_id", to_sale_item_replacements.category_id)
                    .setString("classification", to_sale_item_replacements.classification)
                    .setString("classification_id", to_sale_item_replacements.classification_id)
                    .setString("sub_classification", to_sale_item_replacements.sub_classification)
                    .setString("sub_classification_id", to_sale_item_replacements.sub_classification_id)
                    .setString("brand", to_sale_item_replacements.brand)
                    .setString("brand_id", to_sale_item_replacements.brand_id)
                    .setString("model", to_sale_item_replacements.model)
                    .setString("model_id", to_sale_item_replacements.model_id)
                    .setNumber("is_replacement", to_sale_item_replacements.is_replacement)
                    .setString("reason", to_sale_item_replacements.reason)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sale_item_replacements.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_sale_item_replacements to_sale_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sale_item_replacements set "
                    + "sales_no= :sales_no "
                    + ",item_code= :item_code "
                    + ",barcode= :barcode "
                    + ",description= :description "
                    + ",generic_name= :generic_name "
                    + ",item_type= :item_type "
                    + ",supplier_name= :supplier_name "
                    + ",supplier_id= :supplier_id "
                    + ",serial_no= :serial_no "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",date_added= :date_added "
                    + ",user_id= :user_id "
                    + ",user_screen_name= :user_screen_name "
                    + ",status= :status "
                    + ",is_vatable= :is_vatable "
                    + ",selling_type= :selling_type "
                    + ",discount_name= :discount_name "
                    + ",discount_rate= :discount_rate "
                    + ",discount_amount= :discount_amount "
                    + ",discount_customer_name= :discount_customer_name "
                    + ",discount_customer_id= :discount_customer_id "
                    + ",branch= :branch "
                    + ",branch_code= :branch_code "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",is_replacement= :is_replacement "
                    + ",reason= :reason"
                    + " where id='" + to_sale_item_replacements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sale_item_replacements.sales_no)
                    .setString("item_code", to_sale_item_replacements.item_code)
                    .setString("barcode", to_sale_item_replacements.barcode)
                    .setString("description", to_sale_item_replacements.description)
                    .setString("generic_name", to_sale_item_replacements.generic_name)
                    .setString("item_type", to_sale_item_replacements.item_type)
                    .setString("supplier_name", to_sale_item_replacements.supplier_name)
                    .setString("supplier_id", to_sale_item_replacements.supplier_id)
                    .setString("serial_no", to_sale_item_replacements.serial_no)
                    .setNumber("product_qty", to_sale_item_replacements.product_qty)
                    .setString("unit", to_sale_item_replacements.unit)
                    .setNumber("conversion", to_sale_item_replacements.conversion)
                    .setNumber("selling_price", to_sale_item_replacements.selling_price)
                    .setString("date_added", to_sale_item_replacements.date_added)
                    .setString("user_id", to_sale_item_replacements.user_id)
                    .setString("user_screen_name", to_sale_item_replacements.user_screen_name)
                    .setNumber("status", to_sale_item_replacements.status)
                    .setNumber("is_vatable", to_sale_item_replacements.is_vatable)
                    .setNumber("selling_type", to_sale_item_replacements.selling_type)
                    .setString("discount_name", to_sale_item_replacements.discount_name)
                    .setNumber("discount_rate", to_sale_item_replacements.discount_rate)
                    .setNumber("discount_amount", to_sale_item_replacements.discount_amount)
                    .setString("discount_customer_name", to_sale_item_replacements.discount_customer_name)
                    .setString("discount_customer_id", to_sale_item_replacements.discount_customer_id)
                    .setString("branch", to_sale_item_replacements.branch)
                    .setString("branch_code", to_sale_item_replacements.branch_code)
                    .setString("location", to_sale_item_replacements.location)
                    .setString("location_id", to_sale_item_replacements.location_id)
                    .setString("category", to_sale_item_replacements.category)
                    .setString("category_id", to_sale_item_replacements.category_id)
                    .setString("classification", to_sale_item_replacements.classification)
                    .setString("classification_id", to_sale_item_replacements.classification_id)
                    .setString("sub_classification", to_sale_item_replacements.sub_classification)
                    .setString("sub_classification_id", to_sale_item_replacements.sub_classification_id)
                    .setString("brand", to_sale_item_replacements.brand)
                    .setString("brand_id", to_sale_item_replacements.brand_id)
                    .setString("model", to_sale_item_replacements.model)
                    .setString("model_id", to_sale_item_replacements.model_id)
                    .setNumber("is_replacement", to_sale_item_replacements.is_replacement)
                    .setString("reason", to_sale_item_replacements.reason)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sale_item_replacements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_sale_item_replacements to_sale_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sale_item_replacements  "
                    + " where id='" + to_sale_item_replacements.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sale_item_replacements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sale_item_replacements> ret_data(String where) {
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

    public static void item_replacement(MySales.sales sale, List<MySales_Items.items> datas, List<to_sale_item_replacements> replacements) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
//            String s0 = "update sales set "
//                    + " gross_amount= :gross_amount "
//                    + ",amount_due= :amount_due "
//                    + ",line_discount= :line_discount "
//                    + " where id='" + sale.id + "' "
//                    + " ";
//            s0 = SqlStringUtil.parse(s0)
//                    .setNumber("gross_amount", sale.gross_amount)
//                    .setNumber("amount_due", sale.amount_due)
//                    .setNumber("line_discount", sale.line_discount)
//                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.execute();

            for (MySales_Items.items to_receipt_items : datas) {
                if (to_receipt_items.selected == true) {

                    Lg.s(S1_receipt_items.class, "Successfully Updated");
                    Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_receipt_items.item_code, to_receipt_items.barcode, to_receipt_items.location_id);

                    Dlg_inventory_uom.to_uom uomss = uom.default_uom(to_receipt_items.unit);
                    System.out.println("Qty: " + tt.product_qty);
                    System.out.println("Sale Qty: " + to_receipt_items.product_qty);
                    System.out.println("Sale Conversion: " + uomss.conversion);
                    double new_qty = tt.product_qty + (to_receipt_items.product_qty);

                    String s1 = "update inventory_barcodes set "
                            + " product_qty='" + new_qty + "'"
                            + " where  main_barcode= '" + to_receipt_items.item_code + "' and location_id='" + to_receipt_items.location_id + "' "
                            + "";
                    stmt.addBatch(s1);
                    String s2 = "delete from sale_items where id='" + to_receipt_items.id + "' ";
                    stmt.addBatch(s2);

                    String s6 = "insert into sale_item_replacements("
                            + "sales_no"
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
                            + ")values("
                            + ":sales_no"
                            + ",:item_code"
                            + ",:barcode"
                            + ",:description"
                            + ",:generic_name"
                            + ",:item_type"
                            + ",:supplier_name"
                            + ",:supplier_id"
                            + ",:serial_no"
                            + ",:product_qty"
                            + ",:unit"
                            + ",:conversion"
                            + ",:selling_price"
                            + ",:date_added"
                            + ",:user_id"
                            + ",:user_screen_name"
                            + ",:status"
                            + ",:is_vatable"
                            + ",:selling_type"
                            + ",:discount_name"
                            + ",:discount_rate"
                            + ",:discount_amount"
                            + ",:discount_customer_name"
                            + ",:discount_customer_id"
                            + ",:branch"
                            + ",:branch_code"
                            + ",:location"
                            + ",:location_id"
                            + ",:category"
                            + ",:category_id"
                            + ",:classification"
                            + ",:classification_id"
                            + ",:sub_classification"
                            + ",:sub_classification_id"
                            + ",:brand"
                            + ",:brand_id"
                            + ",:model"
                            + ",:model_id"
                            + ",:is_replacement"
                            + ")";

                    s6 = SqlStringUtil.parse(s6)
                            .setString("sales_no", to_receipt_items.sales_no)
                            .setString("item_code", to_receipt_items.item_code)
                            .setString("barcode", to_receipt_items.barcode)
                            .setString("description", to_receipt_items.description)
                            .setString("generic_name", to_receipt_items.generic_name)
                            .setString("item_type", to_receipt_items.item_type)
                            .setString("supplier_name", to_receipt_items.supplier_name)
                            .setString("supplier_id", to_receipt_items.supplier_id)
                            .setString("serial_no", to_receipt_items.serial_no)
                            .setNumber("product_qty", to_receipt_items.product_qty)
                            .setString("unit", to_receipt_items.unit)
                            .setNumber("conversion", to_receipt_items.conversion)
                            .setNumber("selling_price", to_receipt_items.selling_price)
                            .setString("date_added", DateType.now())
                            .setString("user_id", to_receipt_items.user_id)
                            .setString("user_screen_name", to_receipt_items.user_screen_name)
                            .setNumber("status", to_receipt_items.status)
                            .setNumber("is_vatable", to_receipt_items.is_vatable)
                            .setNumber("selling_type", to_receipt_items.selling_type)
                            .setString("discount_name", to_receipt_items.discount_name)
                            .setNumber("discount_rate", to_receipt_items.discount_rate)
                            .setNumber("discount_amount", to_receipt_items.discount_amount)
                            .setString("discount_customer_name", to_receipt_items.discount_customer_name)
                            .setString("discount_customer_id", to_receipt_items.discount_customer_id)
                            .setString("branch", to_receipt_items.branch)
                            .setString("branch_code", to_receipt_items.branch_code)
                            .setString("location", to_receipt_items.location)
                            .setString("location_id", to_receipt_items.location_id)
                            .setString("category", to_receipt_items.category)
                            .setString("category_id", to_receipt_items.category_id)
                            .setString("classification", to_receipt_items.classification)
                            .setString("classification_id", to_receipt_items.classification_id)
                            .setString("sub_classification", to_receipt_items.sub_classification)
                            .setString("sub_classification_id", to_receipt_items.sub_classification_id)
                            .setString("brand", to_receipt_items.brand)
                            .setString("brand_id", to_receipt_items.brand_id)
                            .setString("model", to_receipt_items.model)
                            .setString("model_id", to_receipt_items.model_id)
                            .setNumber("is_replacement", 0)
                            .ok();
                    stmt.addBatch(s6);

                }

            }

            for (to_sale_item_replacements to_sale_items : replacements) {
                String s3 = "insert into sale_items("
                        + "sales_no"
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
                        + ")values("
                        + ":sales_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:item_type"
                        + ",:supplier_name"
                        + ",:supplier_id"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ")";

                s3 = SqlStringUtil.parse(s3)
//                        .setString("sales_no", sale.sales_no)
                        .setString("item_code", to_sale_items.item_code)
                        .setString("barcode", to_sale_items.barcode)
                        .setString("description", to_sale_items.description)
                        .setString("generic_name", to_sale_items.generic_name)
                        .setString("item_type", to_sale_items.item_type)
                        .setString("supplier_name", to_sale_items.supplier_name)
                        .setString("supplier_id", to_sale_items.supplier_id)
                        .setString("serial_no", to_sale_items.serial_no)
                        .setNumber("product_qty", to_sale_items.product_qty)
                        .setString("unit", to_sale_items.unit)
                        .setNumber("conversion", to_sale_items.conversion)
                        .setNumber("selling_price", to_sale_items.selling_price)
//                        .setString("date_added", sale.date_added)
                        .setString("user_id", MyUser.getUser_id())
                        .setString("user_screen_name", MyUser.getUser_screen_name())
                        .setNumber("status", to_sale_items.status)
                        .setNumber("is_vatable", to_sale_items.is_vatable)
                        .setNumber("selling_type", to_sale_items.selling_type)
                        .setString("discount_name", to_sale_items.discount_name)
                        .setNumber("discount_rate", to_sale_items.discount_rate)
                        .setNumber("discount_amount", to_sale_items.discount_amount)
                        .setString("discount_customer_name", to_sale_items.discount_customer_name)
                        .setString("discount_customer_id", to_sale_items.discount_customer_id)
                        .setString("branch", to_sale_items.branch)
                        .setString("branch_code", to_sale_items.branch_code)
                        .setString("location", to_sale_items.location)
                        .setString("location_id", to_sale_items.location_id)
                        .setString("category", to_sale_items.category)
                        .setString("category_id", to_sale_items.category_id)
                        .setString("classification", to_sale_items.classification)
                        .setString("classification_id", to_sale_items.classification_id)
                        .setString("sub_classification", to_sale_items.sub_classification)
                        .setString("sub_classification_id", to_sale_items.sub_classification_id)
                        .setString("brand", to_sale_items.brand)
                        .setString("brand_id", to_sale_items.brand_id)
                        .setString("model", to_sale_items.model)
                        .setString("model_id", to_sale_items.model_id)
                        .ok();

                stmt.addBatch(s3);
                Lg.s(MySales.class, "Item Committed");

                Inventory_barcodes.to_inventory_barcodes tt = Inventory_barcodes.ret_to(to_sale_items.item_code, to_sale_items.barcode, to_sale_items.location_id);

                double new_qty = tt.product_qty - (to_sale_items.conversion * to_sale_items.product_qty);

                String serial_no = Segregator.this_shit(tt.serial_no, to_sale_items.serial_no);
                String s4 = "update inventory_barcodes set "
                        + " product_qty='" + new_qty + "'"
                        + " where  main_barcode= '" + to_sale_items.item_code + "' and location_id='" + to_sale_items.location_id + "' "
                        + "";

                stmt.addBatch(s4);
                Lg.s(Inventory.class, "Successfully Updated");

                String s5 = "insert into sale_item_replacements("
                        + "sales_no"
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
                        + ")values("
                        + ":sales_no"
                        + ",:item_code"
                        + ",:barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:item_type"
                        + ",:supplier_name"
                        + ",:supplier_id"
                        + ",:serial_no"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_id"
                        + ",:user_screen_name"
                        + ",:status"
                        + ",:is_vatable"
                        + ",:selling_type"
                        + ",:discount_name"
                        + ",:discount_rate"
                        + ",:discount_amount"
                        + ",:discount_customer_name"
                        + ",:discount_customer_id"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:is_replacement"
                        + ")";

                s5 = SqlStringUtil.parse(s5)
//                        .setString("sales_no", sale.sales_no)
                        .setString("item_code", to_sale_items.item_code)
                        .setString("barcode", to_sale_items.barcode)
                        .setString("description", to_sale_items.description)
                        .setString("generic_name", to_sale_items.generic_name)
                        .setString("item_type", to_sale_items.item_type)
                        .setString("supplier_name", to_sale_items.supplier_name)
                        .setString("supplier_id", to_sale_items.supplier_id)
                        .setString("serial_no", to_sale_items.serial_no)
                        .setNumber("product_qty", to_sale_items.product_qty)
                        .setString("unit", to_sale_items.unit)
                        .setNumber("conversion", to_sale_items.conversion)
                        .setNumber("selling_price", to_sale_items.selling_price)
                        .setString("date_added", DateType.now())
                        .setString("user_id", to_sale_items.user_id)
                        .setString("user_screen_name", to_sale_items.user_screen_name)
                        .setNumber("status", to_sale_items.status)
                        .setNumber("is_vatable", to_sale_items.is_vatable)
                        .setNumber("selling_type", to_sale_items.selling_type)
                        .setString("discount_name", to_sale_items.discount_name)
                        .setNumber("discount_rate", to_sale_items.discount_rate)
                        .setNumber("discount_amount", to_sale_items.discount_amount)
                        .setString("discount_customer_name", to_sale_items.discount_customer_name)
                        .setString("discount_customer_id", to_sale_items.discount_customer_id)
                        .setString("branch", to_sale_items.branch)
                        .setString("branch_code", to_sale_items.branch_code)
                        .setString("location", to_sale_items.location)
                        .setString("location_id", to_sale_items.location_id)
                        .setString("category", to_sale_items.category)
                        .setString("category_id", to_sale_items.category_id)
                        .setString("classification", to_sale_items.classification)
                        .setString("classification_id", to_sale_items.classification_id)
                        .setString("sub_classification", to_sale_items.sub_classification)
                        .setString("sub_classification_id", to_sale_items.sub_classification_id)
                        .setString("brand", to_sale_items.brand)
                        .setString("brand_id", to_sale_items.brand_id)
                        .setString("model", to_sale_items.model)
                        .setString("model_id", to_sale_items.model_id)
                        .setNumber("is_replacement", to_sale_items.is_replacement)
                        .ok();

                stmt.addBatch(s5);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(MySales.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
