/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory_assembly;

import servicing.inventory.Inventory_barcodes;
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
 * @author Guinness
 */
public class Inventory_assembly {

    public static class to_inventory_assembly {

        public final int id;
        public final String main_item_code;
        public final String main_barcode;
        public final String item_code;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String supplier;
        public final int fixed_price;
        public final double cost;
        public final String supplier_id;
        public final int multi_level_pricing;
        public final int vatable;
        public final double reorder_level;
        public final double markup;
        public final String barcodes;
        public final String brand;
        public final String brand_id;
        public final String model;
        public final String model_id;
        public final int selling_type;
        public final String branch;
        public final String branch_code;
        public final String location;
        public final String location_id;
        public boolean selected;

        public to_inventory_assembly(int id, String main_item_code, String main_barcode, String item_code, String description, String generic_name, String category, String category_id, String classification, String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost, String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String barcodes, String brand, String brand_id, String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, boolean selected) {
            this.id = id;
            this.main_item_code = main_item_code;
            this.main_barcode = main_barcode;
            this.item_code = item_code;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.supplier = supplier;
            this.fixed_price = fixed_price;
            this.cost = cost;
            this.supplier_id = supplier_id;
            this.multi_level_pricing = multi_level_pricing;
            this.vatable = vatable;
            this.reorder_level = reorder_level;
            this.markup = markup;
            this.barcodes = barcodes;
            this.brand = brand;
            this.brand_id = brand_id;
            this.model = model;
            this.model_id = model_id;
            this.selling_type = selling_type;
            this.branch = branch;
            this.branch_code = branch_code;
            this.location = location;
            this.location_id = location_id;
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_data(to_inventory_assembly to_inventory_assembly) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "insert into inventory_assembly("
                    + " main_item_code"
                    + ",main_barcode"
                    + ",item_code"
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
                    + ")values("
                    + ":main_item_code"
                    + ",:main_barcode"
                    + ",:item_code"
                    + ",:description"
                    + ",:generic_name"
                    + ",:category"
                    + ",:category_id"
                    + ",:classification"
                    + ",:classification_id"
                    + ",:sub_classification"
                    + ",:sub_classification_id"
                    + ",:product_qty"
                    + ",:unit"
                    + ",:conversion"
                    + ",:selling_price"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:item_type"
                    + ",:status"
                    + ",:supplier"
                    + ",:fixed_price"
                    + ",:cost"
                    + ",:supplier_id"
                    + ",:multi_level_pricing"
                    + ",:vatable"
                    + ",:reorder_level"
                    + ",:markup"
                    + ",:barcodes"
                    + ",:brand"
                    + ",:brand_id"
                    + ",:model"
                    + ",:model_id"
                    + ",:selling_type"
                    + ",:branch"
                    + ",:branch_code"
                    + ",:location"
                    + ",:location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("main_item_code", to_inventory_assembly.main_item_code)
                    .setString("main_barcode", to_inventory_assembly.main_barcode)
                    .setString("item_code", to_inventory_assembly.item_code)
                    .setString("description", to_inventory_assembly.description)
                    .setString("generic_name", to_inventory_assembly.generic_name)
                    .setString("category", to_inventory_assembly.category)
                    .setString("category_id", to_inventory_assembly.category_id)
                    .setString("classification", to_inventory_assembly.classification)
                    .setString("classification_id", to_inventory_assembly.classification_id)
                    .setString("sub_classification", to_inventory_assembly.sub_classification)
                    .setString("sub_classification_id", to_inventory_assembly.sub_classification_id)
                    .setNumber("product_qty", to_inventory_assembly.product_qty)
                    .setString("unit", to_inventory_assembly.unit)
                    .setNumber("conversion", to_inventory_assembly.conversion)
                    .setNumber("selling_price", to_inventory_assembly.selling_price)
                    .setString("date_added", to_inventory_assembly.date_added)
                    .setString("user_name", to_inventory_assembly.user_name)
                    .setString("item_type", to_inventory_assembly.item_type)
                    .setNumber("status", to_inventory_assembly.status)
                    .setString("supplier", to_inventory_assembly.supplier)
                    .setNumber("fixed_price", to_inventory_assembly.fixed_price)
                    .setNumber("cost", to_inventory_assembly.cost)
                    .setString("supplier_id", to_inventory_assembly.supplier_id)
                    .setNumber("multi_level_pricing", to_inventory_assembly.multi_level_pricing)
                    .setNumber("vatable", to_inventory_assembly.vatable)
                    .setNumber("reorder_level", to_inventory_assembly.reorder_level)
                    .setNumber("markup", to_inventory_assembly.markup)
                    .setString("barcodes", to_inventory_assembly.barcodes)
                    .setString("brand", to_inventory_assembly.brand)
                    .setString("brand_id", to_inventory_assembly.brand_id)
                    .setString("model", to_inventory_assembly.model)
                    .setString("model_id", to_inventory_assembly.model_id)
                    .setNumber("selling_type", to_inventory_assembly.selling_type)
                    .setString("branch", to_inventory_assembly.branch)
                    .setString("branch_code", to_inventory_assembly.branch_code)
                    .setString("location", to_inventory_assembly.location)
                    .setString("location_id", to_inventory_assembly.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s1 = " update inventory set is_uploaded=2 where barcode='" + to_inventory_assembly.main_item_code + "' ";
            stmt.addBatch(s1);
            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_assembly.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void upload_assembly_to_cloud(List<to_inventory_assembly> to_inventory_assembly1, List<to_inventory_assembly> to_delete) {
        try {
            Connection conn = MyConnection.cloud_connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");

            for (to_inventory_assembly to_inventory_assembly : to_inventory_assembly1) {
                String s0 = "insert into inventory_assembly("
                        + " main_item_code"
                        + ",main_barcode"
                        + ",item_code"
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
                        + ")values("
                        + ":main_item_code"
                        + ",:main_barcode"
                        + ",:item_code"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:markup"
                        + ",:barcodes"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("main_item_code", to_inventory_assembly.main_item_code)
                        .setString("main_barcode", to_inventory_assembly.main_barcode)
                        .setString("item_code", to_inventory_assembly.item_code)
                        .setString("description", to_inventory_assembly.description)
                        .setString("generic_name", to_inventory_assembly.generic_name)
                        .setString("category", to_inventory_assembly.category)
                        .setString("category_id", to_inventory_assembly.category_id)
                        .setString("classification", to_inventory_assembly.classification)
                        .setString("classification_id", to_inventory_assembly.classification_id)
                        .setString("sub_classification", to_inventory_assembly.sub_classification)
                        .setString("sub_classification_id", to_inventory_assembly.sub_classification_id)
                        .setNumber("product_qty", to_inventory_assembly.product_qty)
                        .setString("unit", to_inventory_assembly.unit)
                        .setNumber("conversion", to_inventory_assembly.conversion)
                        .setNumber("selling_price", to_inventory_assembly.selling_price)
                        .setString("date_added", to_inventory_assembly.date_added)
                        .setString("user_name", to_inventory_assembly.user_name)
                        .setString("item_type", to_inventory_assembly.item_type)
                        .setNumber("status", to_inventory_assembly.status)
                        .setString("supplier", to_inventory_assembly.supplier)
                        .setNumber("fixed_price", to_inventory_assembly.fixed_price)
                        .setNumber("cost", to_inventory_assembly.cost)
                        .setString("supplier_id", to_inventory_assembly.supplier_id)
                        .setNumber("multi_level_pricing", to_inventory_assembly.multi_level_pricing)
                        .setNumber("vatable", to_inventory_assembly.vatable)
                        .setNumber("reorder_level", to_inventory_assembly.reorder_level)
                        .setNumber("markup", to_inventory_assembly.markup)
                        .setString("barcodes", to_inventory_assembly.barcodes)
                        .setString("brand", to_inventory_assembly.brand)
                        .setString("brand_id", to_inventory_assembly.brand_id)
                        .setString("model", to_inventory_assembly.model)
                        .setString("model_id", to_inventory_assembly.model_id)
                        .setNumber("selling_type", to_inventory_assembly.selling_type)
                        .setString("branch", to_inventory_assembly.branch)
                        .setString("branch_code", to_inventory_assembly.branch_code)
                        .setString("location", to_inventory_assembly.location)
                        .setString("location_id", to_inventory_assembly.location_id)
                        .ok();

                stmt.addBatch(s0);
            }

            for (to_inventory_assembly to_inventory_assembly : to_delete) {
                String s0 = "delete from inventory_assembly  "
                        + " where main_item_code='" + to_inventory_assembly.main_item_code + "' and item_code='" + to_inventory_assembly.item_code + "' "
                        + " ";
                stmt.addBatch(s0);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_assembly.class, "Successfully Added");

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void upload_assembly_to_local_from_cloud(List<to_inventory_assembly> to_inventory_assembly1, List<to_inventory_assembly> to_delete) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");

            for (to_inventory_assembly to_inventory_assembly : to_inventory_assembly1) {
                String s0 = "insert into inventory_assembly("
                        + " main_item_code"
                        + ",main_barcode"
                        + ",item_code"
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
                        + ")values("
                        + ":main_item_code"
                        + ",:main_barcode"
                        + ",:item_code"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:supplier"
                        + ",:fixed_price"
                        + ",:cost"
                        + ",:supplier_id"
                        + ",:multi_level_pricing"
                        + ",:vatable"
                        + ",:reorder_level"
                        + ",:markup"
                        + ",:barcodes"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("main_item_code", to_inventory_assembly.main_item_code)
                        .setString("main_barcode", to_inventory_assembly.main_barcode)
                        .setString("item_code", to_inventory_assembly.item_code)
                        .setString("description", to_inventory_assembly.description)
                        .setString("generic_name", to_inventory_assembly.generic_name)
                        .setString("category", to_inventory_assembly.category)
                        .setString("category_id", to_inventory_assembly.category_id)
                        .setString("classification", to_inventory_assembly.classification)
                        .setString("classification_id", to_inventory_assembly.classification_id)
                        .setString("sub_classification", to_inventory_assembly.sub_classification)
                        .setString("sub_classification_id", to_inventory_assembly.sub_classification_id)
                        .setNumber("product_qty", to_inventory_assembly.product_qty)
                        .setString("unit", to_inventory_assembly.unit)
                        .setNumber("conversion", to_inventory_assembly.conversion)
                        .setNumber("selling_price", to_inventory_assembly.selling_price)
                        .setString("date_added", to_inventory_assembly.date_added)
                        .setString("user_name", to_inventory_assembly.user_name)
                        .setString("item_type", to_inventory_assembly.item_type)
                        .setNumber("status", to_inventory_assembly.status)
                        .setString("supplier", to_inventory_assembly.supplier)
                        .setNumber("fixed_price", to_inventory_assembly.fixed_price)
                        .setNumber("cost", to_inventory_assembly.cost)
                        .setString("supplier_id", to_inventory_assembly.supplier_id)
                        .setNumber("multi_level_pricing", to_inventory_assembly.multi_level_pricing)
                        .setNumber("vatable", to_inventory_assembly.vatable)
                        .setNumber("reorder_level", to_inventory_assembly.reorder_level)
                        .setNumber("markup", to_inventory_assembly.markup)
                        .setString("barcodes", to_inventory_assembly.barcodes)
                        .setString("brand", to_inventory_assembly.brand)
                        .setString("brand_id", to_inventory_assembly.brand_id)
                        .setString("model", to_inventory_assembly.model)
                        .setString("model_id", to_inventory_assembly.model_id)
                        .setNumber("selling_type", to_inventory_assembly.selling_type)
                        .setString("branch", to_inventory_assembly.branch)
                        .setString("branch_code", to_inventory_assembly.branch_code)
                        .setString("location", to_inventory_assembly.location)
                        .setString("location_id", to_inventory_assembly.location_id)
                        .ok();

                stmt.addBatch(s0);
            }

            for (to_inventory_assembly to_inventory_assembly : to_delete) {
                String s0 = "delete from inventory_assembly  "
                        + " where main_item_code='" + to_inventory_assembly.main_item_code + "' and item_code='" + to_inventory_assembly.item_code + "' "
                        + " ";
                stmt.addBatch(s0);
            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_assembly.class, "Successfully Added");

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_inventory_assembly to_inventory_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory_assembly set "
                    + "main_item_code= :main_item_code "
                    + ",main_barcode= :main_barcode"
                    + ",item_code= :item_code "
                    + ",description= :description "
                    + ",generic_name= :generic_name "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",classification= :classification "
                    + ",classification_id= :classification_id "
                    + ",sub_classification= :sub_classification "
                    + ",sub_classification_id= :sub_classification_id "
                    + ",product_qty= :product_qty "
                    + ",unit= :unit "
                    + ",conversion= :conversion "
                    + ",selling_price= :selling_price "
                    + ",date_added= :date_added "
                    + ",user_name= :user_name "
                    + ",item_type= :item_type "
                    + ",status= :status "
                    + ",supplier= :supplier "
                    + ",fixed_price= :fixed_price "
                    + ",cost= :cost "
                    + ",supplier_id= :supplier_id "
                    + ",multi_level_pricing= :multi_level_pricing "
                    + ",vatable= :vatable "
                    + ",reorder_level= :reorder_level "
                    + ",markup= :markup "
                    + ",barcodes= :barcodes "
                    + ",brand= :brand "
                    + ",brand_id= :brand_id "
                    + ",model= :model "
                    + ",model_id= :model_id "
                    + ",selling_type= :selling_type "
                    + ",branch= :branch "
                    + ",branch_code= :branch_code "
                    + ",location= :location "
                    + ",location_id= :location_id "
                    + " where id='" + to_inventory_assembly.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("main_item_code", to_inventory_assembly.main_item_code)
                    .setString("main_barcode", to_inventory_assembly.main_barcode)
                    .setString("item_code", to_inventory_assembly.item_code)
                    .setString("description", to_inventory_assembly.description)
                    .setString("generic_name", to_inventory_assembly.generic_name)
                    .setString("category", to_inventory_assembly.category)
                    .setString("category_id", to_inventory_assembly.category_id)
                    .setString("classification", to_inventory_assembly.classification)
                    .setString("classification_id", to_inventory_assembly.classification_id)
                    .setString("sub_classification", to_inventory_assembly.sub_classification)
                    .setString("sub_classification_id", to_inventory_assembly.sub_classification_id)
                    .setNumber("product_qty", to_inventory_assembly.product_qty)
                    .setString("unit", to_inventory_assembly.unit)
                    .setNumber("conversion", to_inventory_assembly.conversion)
                    .setNumber("selling_price", to_inventory_assembly.selling_price)
                    .setString("date_added", to_inventory_assembly.date_added)
                    .setString("user_name", to_inventory_assembly.user_name)
                    .setString("item_type", to_inventory_assembly.item_type)
                    .setNumber("status", to_inventory_assembly.status)
                    .setString("supplier", to_inventory_assembly.supplier)
                    .setNumber("fixed_price", to_inventory_assembly.fixed_price)
                    .setNumber("cost", to_inventory_assembly.cost)
                    .setString("supplier_id", to_inventory_assembly.supplier_id)
                    .setNumber("multi_level_pricing", to_inventory_assembly.multi_level_pricing)
                    .setNumber("vatable", to_inventory_assembly.vatable)
                    .setNumber("reorder_level", to_inventory_assembly.reorder_level)
                    .setNumber("markup", to_inventory_assembly.markup)
                    .setString("barcodes", to_inventory_assembly.barcodes)
                    .setString("brand", to_inventory_assembly.brand)
                    .setString("brand_id", to_inventory_assembly.brand_id)
                    .setString("model", to_inventory_assembly.model)
                    .setString("model_id", to_inventory_assembly.model_id)
                    .setNumber("selling_type", to_inventory_assembly.selling_type)
                    .setString("branch", to_inventory_assembly.branch)
                    .setString("branch_code", to_inventory_assembly.branch_code)
                    .setString("location", to_inventory_assembly.location)
                    .setString("location_id", to_inventory_assembly.location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_assembly.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_inventory_assembly to_inventory_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inventory_assembly  "
                    + " where id='" + to_inventory_assembly.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_assembly.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_assembly> ret_data(String where) {
        List<to_inventory_assembly> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",main_item_code"
                    + ",main_barcode"
                    + ",item_code"
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
                    + " from inventory_assembly"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String main_item_code = rs.getString(2);
                String main_barcode = rs.getString(3);
                String item_code = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String category = rs.getString(7);
                String category_id = rs.getString(8);
                String classification = rs.getString(9);
                String classification_id = rs.getString(10);
                String sub_classification = rs.getString(11);
                String sub_classification_id = rs.getString(12);
                double product_qty = rs.getDouble(13);
                String unit = rs.getString(14);
                double conversion = rs.getDouble(15);
                double selling_price = rs.getDouble(16);
                String date_added = rs.getString(17);
                String user_name = rs.getString(18);
                String item_type = rs.getString(19);
                int status = rs.getInt(20);
                String supplier = rs.getString(21);
                int fixed_price = rs.getInt(22);
                double cost = rs.getDouble(23);
                String supplier_id = rs.getString(24);
                int multi_level_pricing = rs.getInt(25);
                int vatable = rs.getInt(26);
                double reorder_level = rs.getDouble(27);
                double markup = rs.getDouble(28);
                String barcodes = rs.getString(29);
                String brand = rs.getString(30);
                String brand_id = rs.getString(31);
                String model = rs.getString(32);
                String model_id = rs.getString(33);
                int selling_type = rs.getInt(34);
                String branch = rs.getString(35);
                String branch_code = rs.getString(36);
                String location = rs.getString(37);
                String location_id = rs.getString(38);
                to_inventory_assembly to = new to_inventory_assembly(id, main_item_code, main_barcode, item_code, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, true);

                datas.add(to);
            }

            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_assembly> ret_data_cloud(String where) {
        List<to_inventory_assembly> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
            String s0 = "select "
                    + "id"
                    + ",main_item_code"
                    + ",main_barcode"
                    + ",item_code"
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
                    + " from inventory_assembly"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String main_item_code = rs.getString(2);
                String main_barcode = rs.getString(3);
                String item_code = rs.getString(4);
                String description = rs.getString(5);
                String generic_name = rs.getString(6);
                String category = rs.getString(7);
                String category_id = rs.getString(8);
                String classification = rs.getString(9);
                String classification_id = rs.getString(10);
                String sub_classification = rs.getString(11);
                String sub_classification_id = rs.getString(12);
                double product_qty = rs.getDouble(13);
                String unit = rs.getString(14);
                double conversion = rs.getDouble(15);
                double selling_price = rs.getDouble(16);
                String date_added = rs.getString(17);
                String user_name = rs.getString(18);
                String item_type = rs.getString(19);
                int status = rs.getInt(20);
                String supplier = rs.getString(21);
                int fixed_price = rs.getInt(22);
                double cost = rs.getDouble(23);
                String supplier_id = rs.getString(24);
                int multi_level_pricing = rs.getInt(25);
                int vatable = rs.getInt(26);
                double reorder_level = rs.getDouble(27);
                double markup = rs.getDouble(28);
                String barcodes = rs.getString(29);
                String brand = rs.getString(30);
                String brand_id = rs.getString(31);
                String model = rs.getString(32);
                String model_id = rs.getString(33);
                int selling_type = rs.getInt(34);
                String branch = rs.getString(35);
                String branch_code = rs.getString(36);
                String location = rs.getString(37);
                String location_id = rs.getString(38);
                to_inventory_assembly to = new to_inventory_assembly(id, main_item_code, main_barcode, item_code, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, true);

                datas.add(to);
            }
            conn.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }
    }

    public static List<Inventory_barcodes.to_inventory_barcodes> convert_to_inventory_barcodes(List<to_inventory_assembly> datas, Inventory_barcodes.to_inventory_barcodes to3) {

        List<Inventory_barcodes.to_inventory_barcodes> orders = new ArrayList();

        for (to_inventory_assembly to : datas) {
            if (to.selected == true) {
                int id = to.id;
                String barcode = to.barcodes;
                String description = to.description;
                String generic_name = to.generic_name;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_classification = to.sub_classification;
                String sub_classification_id = to.sub_classification_id;
                double product_qty = to.product_qty;
                String unit = to.unit;
                double conversion = to.conversion;
                double selling_price = to.selling_price;
                String date_added = to.date_added;
                String user_name = to.user_name;
                String item_type = to.item_type;
                int status = to.status;
                String supplier = to.supplier;
                int fixed_price = to.fixed_price;
                double cost = to.cost;
                String supplier_id = to.supplier_id;
                int multi_level_pricing = to.multi_level_pricing;
                int vatable = to.vatable;
                double reorder_level = to.reorder_level;
                double markup = to.markup;
                String main_barcode = to.item_code;
                String brand = to.brand;
                String brand_id = to.brand_id;
                String model = to.model;
                String model_id = to.model_id;
                int selling_type = to.selling_type;
                String branch = to3.branch;
                String branch_code = to3.branch_code;
                String location = to3.location;
                String location_id = to3.location_id;
                String serial_no = "";
                String selected_serials = "";
                double discount = 0;
                double discount_amount = 0;
                String discount_name = "";
                String discount_customer_name = "";
                String discount_customer_id = "";
                double addtl_amount = 0;
                double wtax = 0;
                int allow_negative_inventory = 0;
                int auto_order = 1;
//                Inventory_barcodes.to_inventory_barcodes field = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, selected_serials, discount, discount_amount, discount_name, discount_customer_name, discount_customer_id, addtl_amount, wtax, allow_negative_inventory, auto_order,1);
//                orders.add(field);
            }
        }
        
        return orders;
    }
public static List<Inventory_barcodes.to_inventory_barcodes> convert_to_inventory_barcodes2(List<to_inventory_assembly> datas) {

        List<Inventory_barcodes.to_inventory_barcodes> orders = new ArrayList();

        for (to_inventory_assembly to : datas) {
            if (to.selected == true) {
                int id = to.id;
                String barcode = to.barcodes;
                String description = to.description;
                String generic_name = to.generic_name;
                String category = to.category;
                String category_id = to.category_id;
                String classification = to.classification;
                String classification_id = to.classification_id;
                String sub_classification = to.sub_classification;
                String sub_classification_id = to.sub_classification_id;
                double product_qty = to.product_qty;
                String unit = to.unit;
                double conversion = to.conversion;
                double selling_price = to.selling_price;
                String date_added = to.date_added;
                String user_name = to.user_name;
                String item_type = to.item_type;
                int status = to.status;
                String supplier = to.supplier;
                int fixed_price = to.fixed_price;
                double cost = to.cost;
                String supplier_id = to.supplier_id;
                int multi_level_pricing = to.multi_level_pricing;
                int vatable = to.vatable;
                double reorder_level = to.reorder_level;
                double markup = to.markup;
                String main_barcode = to.item_code;
                String brand = to.brand;
                String brand_id = to.brand_id;
                String model = to.model;
                String model_id = to.model_id;
                int selling_type = to.selling_type;
                String branch = to.branch;
                String branch_code = to.branch_code;
                String location = to.location;
                String location_id = to.location_id;
                String serial_no = "";
                String selected_serials = "";
                double discount = 0;
                double discount_amount = 0;
                String discount_name = "";
                String discount_customer_name = "";
                String discount_customer_id = "";
                double addtl_amount = 0;
                double wtax = 0;
                int allow_negative_inventory = 0;
                int auto_order = 1;
//                Inventory_barcodes.to_inventory_barcodes field = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, selected_serials, discount, discount_amount, discount_name, discount_customer_name, discount_customer_id, addtl_amount, wtax, allow_negative_inventory, auto_order,1);
//                orders.add(field);
            }
        }

        return orders;

    }

    public static void delete_assembly(List<to_inventory_assembly> to_inventory_assembly1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory_assembly to_inventory_assembly : to_inventory_assembly1) {
                String s0 = "delete from inventory_assembly  "
                        + " where id='" + to_inventory_assembly.id + "' "
                        + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory_assembly.class, "Successfully Deleted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
