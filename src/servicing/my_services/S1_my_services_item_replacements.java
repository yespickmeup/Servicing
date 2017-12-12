/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronald
 */
public class S1_my_services_item_replacements {

    public static class to_my_services_item_replacements {

        public final int id;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double price;
        public final String item_code;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final String unit;
        public final double conversion;
        public final String item_type;
        public final int status;
        public final String supplier;
        public final int fixed_price;
        public final String supplier_id;
        public final int multi_level_pricing;
        public final int vatable;
        public final double reorder_level;
        public final double markup;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final String selling_type;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public final String serial_no;
        public final String user_id;
        public final String user_screen_name;

        public to_my_services_item_replacements(int id, String barcode, String description, double qty, double price, String item_code, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, String unit, double conversion, String item_type, int status, String supplier, int fixed_price, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String brand, String brand_id, String model, String model_id, String selling_type, String branch, String branch_code, String location, String location_id, String serial_no, String user_id, String user_screen_name) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.price = price;
            this.item_code = item_code;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.unit = unit;
            this.conversion = conversion;
            this.item_type = item_type;
            this.status = status;
            this.supplier = supplier;
            this.fixed_price = fixed_price;
            this.supplier_id = supplier_id;
            this.multi_level_pricing = multi_level_pricing;
            this.vatable = vatable;
            this.reorder_level = reorder_level;
            this.markup = markup;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selling_type = selling_type;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.serial_no = serial_no;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
        }
    }

    public static void add_my_services_item_replacements(to_my_services_item_replacements to_my_services_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into my_services_item_replacements("
                    + "barcode"
                    + ",description"
                    + ",qty"
                    + ")values("
                    + ":barcode"
                    + ",:description"
                    + ",:qty"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("barcode", to_my_services_item_replacements.barcode)
                    .setString("description", to_my_services_item_replacements.description)
                    .setNumber("qty", to_my_services_item_replacements.qty)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_item_replacements.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_my_services_item_replacements(to_my_services_item_replacements to_my_services_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update my_services_item_replacements set "
                    + "barcode= :barcode"
                    + ",description= :description"
                    + ",qty= :qty"
                    + " where "
                    + " id ='" + to_my_services_item_replacements.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("barcode", to_my_services_item_replacements.barcode)
                    .setString("description", to_my_services_item_replacements.description)
                    .setNumber("qty", to_my_services_item_replacements.qty)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_item_replacements.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_my_services_item_replacements(to_my_services_item_replacements to_my_services_item_replacements) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from my_services_item_replacements where "
                    + " id ='" + to_my_services_item_replacements.id + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_my_services_item_replacements.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
