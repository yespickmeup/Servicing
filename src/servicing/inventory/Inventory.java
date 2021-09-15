/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.branch_locations.Branch_locations;
import servicing.branch_locations.S1_branch_locations.to_branch_locations;
import servicing.users.User_price_change_request_logs;
import servicing.utils.DateType;
import servicing.utils.MyConnection;

/**
 *
 * @author i1
 */
public class Inventory {

    public static class to_inventory implements Serializable {

        public final int id;
        public final String barcode;
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
        public final int is_uploaded;
        public final int allow_negative_inventory;
        public final int auto_order;
        public final int show_to_sales;

        public to_inventory(int id, String barcode, String description, String generic_name, String category, String category_id, String classification,
                String classification_id, String sub_classification, String sub_classification_id, double product_qty, String unit, double conversion,
                double selling_price, String date_added, String user_name, String item_type, int status, String supplier, int fixed_price, double cost,
                String supplier_id, int multi_level_pricing, int vatable, double reorder_level, double markup, String barcodes, String brand, String brand_id,
                String model, String model_id, int selling_type, String branch, String branch_code, String location, String location_id, boolean selected,
                int is_uploaded, int allow_negative_inventory, int auto_order, int show_to_sales) {
            this.id = id;
            this.barcode = barcode;
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
            this.is_uploaded = is_uploaded;
            this.allow_negative_inventory = allow_negative_inventory;
            this.auto_order = auto_order;
            this.show_to_sales = show_to_sales;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static List<String> add_inventory(to_inventory to_inventory) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<String> query = new ArrayList();

            System.out.println("Preparing to add item......");
            String s0 = "insert into inventory("
                    + "barcode"
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
                    + ",location"
                    + ",location_id"
                    + ",updated_at"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + ")values("
                    + ":barcode"
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
                    + ",:location"
                    + ",:location_id"
                    + ",:updated_at"
                    + ",:allow_negative_inventory"
                    + ",:auto_order"
                    + ",:show_to_sales"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setNumber("product_qty", to_inventory.product_qty).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", 1).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setString("updated_at", to_inventory.date_added).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);
            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description,
                                                                                                                          to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id,
                                                                                                                          to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion,
                                                                                                                          to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier,
                                                                                                                          to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable,
                                                                                                                          to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model,
                                                                                                                          to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location,
                                                                                                                          to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);
            query.add(s0);

            List<to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (to_branch_locations to : datas) {
                String s2 = "insert into inventory_barcodes("
                        + "barcode"
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
                        + ",updated_at"
                        + ",allow_negative_inventory"
                        + ",auto_order"
                        + ",show_to_sales"
                        + ")values("
                        + ":barcode"
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
                        + ",:main_barcode"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:serial_no"
                        + ",:updated_at"
                        + ",:allow_negative_inventory"
                        + ",:auto_order"
                        + ",:show_to_sales"
                        + ")";

                s2 = SqlStringUtil.parse(s2).
                        setString("barcode", to_inventory_barcodes.barcode).
                        setString("description", to_inventory_barcodes.description).
                        setString("generic_name", to_inventory_barcodes.generic_name).
                        setString("category", to_inventory_barcodes.category).
                        setString("category_id", to_inventory_barcodes.category_id).
                        setString("classification", to_inventory_barcodes.classification).
                        setString("classification_id", to_inventory_barcodes.classification_id).
                        setString("sub_classification", to_inventory_barcodes.sub_classification).
                        setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                        setNumber("product_qty", to_inventory_barcodes.product_qty).
                        setString("unit", to_inventory_barcodes.unit).
                        setNumber("conversion", to_inventory_barcodes.conversion).
                        setNumber("selling_price", to_inventory_barcodes.selling_price).
                        setString("date_added", to_inventory_barcodes.date_added).
                        setString("user_name", to_inventory_barcodes.user_name).
                        setString("item_type", to_inventory_barcodes.item_type).
                        setNumber("status", 1).
                        setString("supplier", to_inventory_barcodes.supplier).
                        setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                        setNumber("cost", to_inventory_barcodes.cost).
                        setString("supplier_id", to_inventory_barcodes.supplier_id).
                        setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                        setNumber("vatable", to_inventory_barcodes.vatable).
                        setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                        setNumber("markup", to_inventory_barcodes.markup).
                        setString("main_barcode", to_inventory_barcodes.main_barcode).
                        setString("brand", to_inventory_barcodes.brand).
                        setString("brand_id", to_inventory_barcodes.brand_id).
                        setString("model", to_inventory_barcodes.model).
                        setString("model_id", to_inventory_barcodes.model_id).
                        setNumber("selling_type", to_inventory_barcodes.selling_type).
                        setString("branch", to.branch).
                        setString("branch_code", to.branch_id).
                        setString("location", to.location).
                        setString("location_id", "" + to.id).
                        setString("serial_no", to_inventory_barcodes.serial_no).
                        setString("updated_at", to_inventory_barcodes.date_added).
                        setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                        setNumber("auto_order", to_inventory_barcodes.auto_order).
                        setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                        ok();
                stmt.addBatch(s2);

                query.add(s2);
                Lg.s(Inventory.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to.location);
            }

            stmt.executeBatch();
            conn.commit();
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> add_inventory_list(List<to_inventory> to_inventory1) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<String> query = new ArrayList();

            System.out.println("Preparing to add item......");
            PreparedStatement stmt = conn.prepareStatement("");
            List<to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (to_inventory to_inventory : to_inventory1) {
                String s0 = "insert into inventory("
                        + "barcode"
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
                        + ",updated_at"
                        + ",allow_negative_inventory"
                        + ",auto_order"
                        + ",show_to_sales"
                        + ")values("
                        + ":barcode"
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
                        + ",:updated_at"
                        + ",:allow_negative_inventory"
                        + ",:auto_order"
                        + ",:show_to_sales"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("barcode", to_inventory.barcode).
                        setString("description", to_inventory.description).
                        setString("generic_name", to_inventory.generic_name).
                        setString("category", to_inventory.category).
                        setString("category_id", to_inventory.category_id).
                        setString("classification", to_inventory.classification).
                        setString("classification_id", to_inventory.classification_id).
                        setString("sub_classification", to_inventory.sub_classification).
                        setString("sub_classification_id", to_inventory.sub_classification_id).
                        setNumber("product_qty", to_inventory.product_qty).
                        setString("unit", to_inventory.unit).
                        setNumber("conversion", to_inventory.conversion).
                        setNumber("selling_price", to_inventory.selling_price).
                        setString("date_added", to_inventory.date_added).
                        setString("user_name", to_inventory.user_name).
                        setString("item_type", to_inventory.item_type).
                        setNumber("status", 1).
                        setString("supplier", to_inventory.supplier).
                        setNumber("fixed_price", to_inventory.fixed_price).
                        setNumber("cost", to_inventory.cost).
                        setString("supplier_id", to_inventory.supplier_id).
                        setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                        setNumber("vatable", to_inventory.vatable).
                        setNumber("reorder_level", to_inventory.reorder_level).
                        setNumber("markup", to_inventory.markup).
                        setString("barcodes", to_inventory.barcodes).
                        setString("brand", to_inventory.brand).
                        setString("brand_id", to_inventory.brand_id).
                        setString("model", to_inventory.model).
                        setString("model_id", to_inventory.model_id).
                        setNumber("selling_type", to_inventory.selling_type).
                        setString("branch", to_inventory.branch).
                        setString("branch_code", to_inventory.branch_code).
                        setString("location", to_inventory.location).
                        setString("location_id", to_inventory.location_id).
                        setString("updated_at", to_inventory.date_added).
                        setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                        setNumber("auto_order", to_inventory.auto_order).
                        setNumber("show_to_sales", to_inventory.show_to_sales).
                        ok();

                stmt.addBatch(s0);
                Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description,
                                                                                                                              to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id,
                                                                                                                              to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion,
                                                                                                                              to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier,
                                                                                                                              to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable,
                                                                                                                              to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model,
                                                                                                                              to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location,
                                                                                                                              to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);
                for (to_branch_locations to : datas) {
                    String s2 = "insert into inventory_barcodes("
                            + "barcode"
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
                            + ",updated_at"
                            + ",allow_negative_inventory"
                            + ",auto_order"
                            + ",show_to_sales"
                            + ")values("
                            + ":barcode"
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
                            + ",:main_barcode"
                            + ",:brand"
                            + ",:brand_id"
                            + ",:model"
                            + ",:model_id"
                            + ",:selling_type"
                            + ",:branch"
                            + ",:branch_code"
                            + ",:location"
                            + ",:location_id"
                            + ",:serial_no"
                            + ",:updated_at"
                            + ",:allow_negative_inventory"
                            + ",:auto_order"
                            + ",:show_to_sales"
                            + ")";

                    s2 = SqlStringUtil.parse(s2).
                            setString("barcode", to_inventory_barcodes.barcode).
                            setString("description", to_inventory_barcodes.description).
                            setString("generic_name", to_inventory_barcodes.generic_name).
                            setString("category", to_inventory_barcodes.category).
                            setString("category_id", to_inventory_barcodes.category_id).
                            setString("classification", to_inventory_barcodes.classification).
                            setString("classification_id", to_inventory_barcodes.classification_id).
                            setString("sub_classification", to_inventory_barcodes.sub_classification).
                            setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                            setNumber("product_qty", to_inventory_barcodes.product_qty).
                            setString("unit", to_inventory_barcodes.unit).
                            setNumber("conversion", to_inventory_barcodes.conversion).
                            setNumber("selling_price", to_inventory_barcodes.selling_price).
                            setString("date_added", to_inventory_barcodes.date_added).
                            setString("user_name", to_inventory_barcodes.user_name).
                            setString("item_type", to_inventory_barcodes.item_type).
                            setNumber("status", 1).
                            setString("supplier", to_inventory_barcodes.supplier).
                            setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                            setNumber("cost", to_inventory_barcodes.cost).
                            setString("supplier_id", to_inventory_barcodes.supplier_id).
                            setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                            setNumber("vatable", to_inventory_barcodes.vatable).
                            setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                            setNumber("markup", to_inventory_barcodes.markup).
                            setString("main_barcode", to_inventory_barcodes.main_barcode).
                            setString("brand", to_inventory_barcodes.brand).
                            setString("brand_id", to_inventory_barcodes.brand_id).
                            setString("model", to_inventory_barcodes.model).
                            setString("model_id", to_inventory_barcodes.model_id).
                            setNumber("selling_type", to_inventory_barcodes.selling_type).
                            setString("branch", to.branch).
                            setString("branch_code", to.branch_id).
                            setString("location", to.location).
                            setString("location_id", "" + to.id).
                            setString("serial_no", to_inventory_barcodes.serial_no).
                            setString("updated_at", to_inventory_barcodes.date_added).
                            setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                            setNumber("auto_order", to_inventory_barcodes.auto_order).
                            setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                            ok();
                    stmt.addBatch(s2);

                    Lg.s(Inventory.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to.location);
                }
            }

            stmt.executeBatch();
            conn.commit();
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> add_inventory_cloud(to_inventory to_inventory) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            List<String> query = new ArrayList();

            System.out.println("Preparing to add item......");
            String s0 = "insert into inventory("
                    + "barcode"
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
                    + ",location"
                    + ",location_id"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + ")values("
                    + ":barcode"
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
                    + ",:location"
                    + ",:location_id"
                    + ",:allow_negative_inventory"
                    + ",:auto_order"
                    + ",:show_to_sales"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setNumber("product_qty", to_inventory.product_qty).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", 1).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();
            PreparedStatement stmt = conn.prepareStatement("");

            stmt.addBatch(s0);
            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description,
                                                                                                                          to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id,
                                                                                                                          to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion,
                                                                                                                          to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier,
                                                                                                                          to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable,
                                                                                                                          to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model,
                                                                                                                          to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id,
                                                                                                                          "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);
            query.add(s0);

            List<to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (to_branch_locations to : datas) {
                String s2 = "insert into inventory_barcodes("
                        + "barcode"
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
                        + ")values("
                        + ":barcode"
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
                        + ",:main_barcode"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:serial_no"
                        + ",:allow_negative_inventory"
                        + ",:auto_order"
                        + ",:show_to_sales"
                        + ")";

                s2 = SqlStringUtil.parse(s2).
                        setString("barcode", to_inventory_barcodes.barcode).
                        setString("description", to_inventory_barcodes.description).
                        setString("generic_name", to_inventory_barcodes.generic_name).
                        setString("category", to_inventory_barcodes.category).
                        setString("category_id", to_inventory_barcodes.category_id).
                        setString("classification", to_inventory_barcodes.classification).
                        setString("classification_id", to_inventory_barcodes.classification_id).
                        setString("sub_classification", to_inventory_barcodes.sub_classification).
                        setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                        setNumber("product_qty", to_inventory_barcodes.product_qty).
                        setString("unit", to_inventory_barcodes.unit).
                        setNumber("conversion", to_inventory_barcodes.conversion).
                        setNumber("selling_price", to_inventory_barcodes.selling_price).
                        setString("date_added", to_inventory_barcodes.date_added).
                        setString("user_name", to_inventory_barcodes.user_name).
                        setString("item_type", to_inventory_barcodes.item_type).
                        setNumber("status", 1).
                        setString("supplier", to_inventory_barcodes.supplier).
                        setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                        setNumber("cost", to_inventory_barcodes.cost).
                        setString("supplier_id", to_inventory_barcodes.supplier_id).
                        setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                        setNumber("vatable", to_inventory_barcodes.vatable).
                        setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                        setNumber("markup", to_inventory_barcodes.markup).
                        setString("main_barcode", to_inventory_barcodes.main_barcode).
                        setString("brand", to_inventory_barcodes.brand).
                        setString("brand_id", to_inventory_barcodes.brand_id).
                        setString("model", to_inventory_barcodes.model).
                        setString("model_id", to_inventory_barcodes.model_id).
                        setNumber("selling_type", to_inventory_barcodes.selling_type).
                        setString("branch", to.branch).
                        setString("branch_code", to.branch_id).
                        setString("location", to.location).
                        setString("location_id", "" + to.id).
                        setString("serial_no", to_inventory_barcodes.serial_no).
                        setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                        setNumber("auto_order", to_inventory.auto_order).
                        setNumber("show_to_sales", to_inventory.show_to_sales).
                        ok();
                stmt.addBatch(s2);

                query.add(s2);
                Lg.s(Inventory.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to.location);
            }

            if (to_inventory.selling_type == 1) {

            }

            PreparedStatement stmt2 = conn2.prepareStatement("");
            String s4 = "update inventory set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("is_uploaded", 1)
                    .ok();
            stmt2.addBatch(s4);
            String s5 = "update inventory_barcodes set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " main_barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s5 = SqlStringUtil.parse(s5)
                    .setNumber("is_uploaded", 1)
                    .ok();
            stmt2.addBatch(s5);

            stmt.executeBatch();
            stmt2.executeBatch();
            conn.commit();
            conn2.commit();
            conn.close();
            conn2.close();
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static List<String> add_inventory_to_console(to_inventory to_inventory) {
        try {
            Connection conn = MyConnection.connect();
            List<String> query = new ArrayList();

            String s0 = "insert into inventory("
                    + "barcode"
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
                    + ",location"
                    + ",location_id"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + ")values("
                    + ":barcode"
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
                    + ",:location"
                    + ",:location_id"
                    + ",:allow_negative_inventory"
                    + ",:auto_order"
                    + ",:show_to_sales"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setNumber("product_qty", to_inventory.product_qty).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", 1).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description,
                                                                                                                          to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id,
                                                                                                                          to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion,
                                                                                                                          to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier,
                                                                                                                          to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable,
                                                                                                                          to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model,
                                                                                                                          to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id,
                                                                                                                          "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);
            s0 = s0 + ";";
            query.add(s0);

            List<to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (to_branch_locations to : datas) {
                String s2 = "insert into inventory_barcodes("
                        + "barcode"
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
                        + ")values("
                        + ":barcode"
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
                        + ",:main_barcode"
                        + ",:brand"
                        + ",:brand_id"
                        + ",:model"
                        + ",:model_id"
                        + ",:selling_type"
                        + ",:branch"
                        + ",:branch_code"
                        + ",:location"
                        + ",:location_id"
                        + ",:serial_no"
                        + ",:allow_negative_inventory"
                        + ",:auto_order"
                        + ",:show_to_sales"
                        + ")";

                s2 = SqlStringUtil.parse(s2).
                        setString("barcode", to_inventory_barcodes.barcode).
                        setString("description", to_inventory_barcodes.description).
                        setString("generic_name", to_inventory_barcodes.generic_name).
                        setString("category", to_inventory_barcodes.category).
                        setString("category_id", to_inventory_barcodes.category_id).
                        setString("classification", to_inventory_barcodes.classification).
                        setString("classification_id", to_inventory_barcodes.classification_id).
                        setString("sub_classification", to_inventory_barcodes.sub_classification).
                        setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                        setNumber("product_qty", to_inventory_barcodes.product_qty).
                        setString("unit", to_inventory_barcodes.unit).
                        setNumber("conversion", to_inventory_barcodes.conversion).
                        setNumber("selling_price", to_inventory_barcodes.selling_price).
                        setString("date_added", to_inventory_barcodes.date_added).
                        setString("user_name", to_inventory_barcodes.user_name).
                        setString("item_type", to_inventory_barcodes.item_type).
                        setNumber("status", 1).
                        setString("supplier", to_inventory_barcodes.supplier).
                        setNumber("fixed_price", to_inventory_barcodes.fixed_price).
                        setNumber("cost", to_inventory_barcodes.cost).
                        setString("supplier_id", to_inventory_barcodes.supplier_id).
                        setNumber("multi_level_pricing", to_inventory_barcodes.multi_level_pricing).
                        setNumber("vatable", to_inventory_barcodes.vatable).
                        setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                        setNumber("markup", to_inventory_barcodes.markup).
                        setString("main_barcode", to_inventory_barcodes.main_barcode).
                        setString("brand", to_inventory_barcodes.brand).
                        setString("brand_id", to_inventory_barcodes.brand_id).
                        setString("model", to_inventory_barcodes.model).
                        setString("model_id", to_inventory_barcodes.model_id).
                        setNumber("selling_type", to_inventory_barcodes.selling_type).
                        setString("branch", to.branch).
                        setString("branch_code", to.branch_id).
                        setString("location", to.location).
                        setString("location_id", "" + to.id).
                        setString("serial_no", to_inventory_barcodes.serial_no).
                        setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                        setNumber("auto_order", to_inventory_barcodes.auto_order).
                        setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                        ok();
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                s2 = s2 + ";";
                query.add(s2);
                Lg.s(Inventory.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to.location);
            }
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> edit_inventory(to_inventory to_inventory, to_inventory old_inventory, String where) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<String> query = new ArrayList();

            String s0 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();
            String s01 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s01 = SqlStringUtil.parse(s01).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);
            Lg.s(Inventory.class, "Successfully Updated");
            query.add(s01);

            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description, to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id, to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion, to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier, to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable, to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model, to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);

            String s2 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",cost= :cost"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s2 = SqlStringUtil.parse(s2).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory_barcodes.selling_price).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                    setNumber("auto_order", to_inventory_barcodes.auto_order).
                    setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                    ok();

            String s21 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s21 = SqlStringUtil.parse(s21).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                    setNumber("auto_order", to_inventory_barcodes.auto_order).
                    setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                    ok();

            stmt.addBatch(s2);
            stmt.executeBatch();

            conn.commit();

            Lg.s(Inventory_barcodes.class, "Successfully Updated");
            query.add(s21);

            return query;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> edit_inventory_no_price(to_inventory to_inventory, to_inventory old_inventory, String where) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<String> query = new ArrayList();

            String s0 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory=:allow_negative_inventory"
                    + ",auto_order=:auto_order"
                    + ",show_to_sales=:show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();
            String s01 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s01 = SqlStringUtil.parse(s01).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);
            Lg.s(Inventory.class, "Successfully Updated");
            query.add(s01);

            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description, to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id, to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion, to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier, to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable, to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model, to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);

            String s2 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    //                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",cost= :cost"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s2 = SqlStringUtil.parse(s2).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    //                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                    setNumber("auto_order", to_inventory_barcodes.auto_order).
                    setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                    ok();

            String s21 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    //                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s21 = SqlStringUtil.parse(s21).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    //                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            stmt.addBatch(s2);
            stmt.executeBatch();

            conn.commit();

            Lg.s(Inventory_barcodes.class, "Successfully Updated");
            query.add(s21);

            MyConnection.close();
            return query;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static List<String> edit_inventory_with_price(to_inventory to_inventory, to_inventory old_inventory, String where) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            List<String> query = new ArrayList();

            String s0 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();
            String s01 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s01 = SqlStringUtil.parse(s01).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);
            Lg.s(Inventory.class, "Successfully Updated");
            query.add(s01);

            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description, to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id, to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion, to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier, to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable, to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model, to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales
            );

            String s2 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",cost= :cost"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s2 = SqlStringUtil.parse(s2).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            String s21 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s21 = SqlStringUtil.parse(s21).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            stmt.addBatch(s2);
            stmt.executeBatch();

            conn.commit();

            Lg.s(Inventory_barcodes.class, "Successfully Updated");
            query.add(s21);

            MyConnection.close();
            return query;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void edit_inventory_cloud(to_inventory to_inventory) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);

            String s0 = "update inventory set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",item_type= :item_type"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",is_uploaded = 2"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("item_type", to_inventory.item_type).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);
            Lg.s(Inventory.class, "Successfully Updated");

            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description, to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id, to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion, to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier, to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable, to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model, to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0,
                                                                                                                          to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales);

            String s2 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",cost= :cost"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",is_uploaded =:is_uploaded"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where main_barcode= '" + to_inventory.barcode + "' ";
            s2 = SqlStringUtil.parse(s2).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory_barcodes.selling_price).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("is_uploaded", 2).
                    setNumber("allow_negative_inventory", to_inventory_barcodes.allow_negative_inventory).
                    setNumber("auto_order", to_inventory_barcodes.auto_order).
                    setNumber("show_to_sales", to_inventory_barcodes.show_to_sales).
                    ok();

            stmt.addBatch(s2);

            PreparedStatement stmt2 = conn2.prepareStatement("");
            String s4 = "update inventory set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setNumber("is_uploaded", 1)
                    .ok();
            stmt2.addBatch(s4);
//            System.out.println(s4);
            String s5 = "update inventory_barcodes set "
                    + " is_uploaded= :is_uploaded"
                    + " where "
                    + " main_barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s5 = SqlStringUtil.parse(s5)
                    .setNumber("is_uploaded", 1)
                    .ok();
            stmt2.addBatch(s5);

            stmt.executeBatch();
            stmt2.executeBatch();
            conn.commit();
            conn2.commit();

            Lg.s(Inventory_barcodes.class, "Successfully Updated");
            MyConnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static List<String> edit_inventory_to_console(to_inventory to_inventory, to_inventory old_inventory, String where) {
        try {
            Connection conn = MyConnection.connect();
            List<String> query = new ArrayList();

            String s0 = "update inventory set "
                    + "description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",product_qty= :product_qty"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",supplier= :supplier"
                    + ",fixed_price= :fixed_price"
                    + ",cost= :cost"
                    + ",supplier_id= :supplier_id"
                    + ",multi_level_pricing= :multi_level_pricing"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",barcodes= :barcodes"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",location=:location"
                    + ",location_id=:location_id"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("barcode", to_inventory.barcode).
                    setString("description", to_inventory.description).
                    setString("generic_name", to_inventory.generic_name).
                    setString("category", to_inventory.category).
                    setString("category_id", to_inventory.category_id).
                    setString("classification", to_inventory.classification).
                    setString("classification_id", to_inventory.classification_id).
                    setString("sub_classification", to_inventory.sub_classification).
                    setString("sub_classification_id", to_inventory.sub_classification_id).
                    setNumber("product_qty", to_inventory.product_qty).
                    setString("unit", to_inventory.unit).
                    setNumber("conversion", to_inventory.conversion).
                    setNumber("selling_price", to_inventory.selling_price).
                    setString("date_added", to_inventory.date_added).
                    setString("user_name", to_inventory.user_name).
                    setString("item_type", to_inventory.item_type).
                    setNumber("status", to_inventory.status).
                    setString("supplier", to_inventory.supplier).
                    setNumber("fixed_price", to_inventory.fixed_price).
                    setNumber("cost", to_inventory.cost).
                    setString("supplier_id", to_inventory.supplier_id).
                    setNumber("multi_level_pricing", to_inventory.multi_level_pricing).
                    setNumber("vatable", to_inventory.vatable).
                    setNumber("reorder_level", to_inventory.reorder_level).
                    setNumber("markup", to_inventory.markup).
                    setString("barcodes", to_inventory.barcodes).
                    setString("brand", to_inventory.brand).
                    setString("brand_id", to_inventory.brand_id).
                    setString("model", to_inventory.model).
                    setString("model_id", to_inventory.model_id).
                    setNumber("selling_type", to_inventory.selling_type).
                    setString("location", to_inventory.location).
                    setString("location_id", to_inventory.location_id).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            s0 = s0 + ";";
            query.add(s0);

            Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, to_inventory.barcodes, to_inventory.description, to_inventory.generic_name, to_inventory.category, to_inventory.category_id, to_inventory.classification, to_inventory.classification_id, to_inventory.sub_classification, to_inventory.sub_classification_id, to_inventory.product_qty, to_inventory.unit, to_inventory.conversion, to_inventory.selling_price, to_inventory.date_added, to_inventory.user_name, to_inventory.item_type, to_inventory.status, to_inventory.supplier, to_inventory.fixed_price, to_inventory.cost, to_inventory.supplier_id, to_inventory.multi_level_pricing, to_inventory.vatable, to_inventory.reorder_level, to_inventory.markup, to_inventory.barcode, to_inventory.brand, to_inventory.brand_id, to_inventory.model, to_inventory.model_id, to_inventory.selling_type, to_inventory.branch, to_inventory.branch_code, to_inventory.location, to_inventory.location_id, "", "", 0, 0, "", "", "", 0, 0, to_inventory.allow_negative_inventory, to_inventory.auto_order, to_inventory.show_to_sales
            );

            String s2 = "update inventory_barcodes set "
                    + " description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",cost= :cost"
                    + ",supplier= :supplier"
                    + ",vatable= :vatable"
                    + ",reorder_level= :reorder_level"
                    + ",markup= :markup"
                    + ",brand= :brand"
                    + ",brand_id= :brand_id"
                    + ",model= :model"
                    + ",model_id= :model_id"
                    + ",selling_type= :selling_type"
                    + ",item_type= :item_type"
                    + ",barcode= :barcode"
                    + ",allow_negative_inventory= :allow_negative_inventory"
                    + ",auto_order= :auto_order"
                    + ",show_to_sales= :show_to_sales"
                    + " " + where;
            s2 = SqlStringUtil.parse(s2).
                    setString("description", to_inventory_barcodes.description).
                    setString("generic_name", to_inventory_barcodes.generic_name).
                    setString("category", to_inventory_barcodes.category).
                    setString("category_id", to_inventory_barcodes.category_id).
                    setString("classification", to_inventory_barcodes.classification).
                    setString("classification_id", to_inventory_barcodes.classification_id).
                    setString("sub_classification", to_inventory_barcodes.sub_classification).
                    setString("sub_classification_id", to_inventory_barcodes.sub_classification_id).
                    setString("unit", to_inventory_barcodes.unit).
                    setNumber("conversion", to_inventory_barcodes.conversion).
                    setNumber("selling_price", to_inventory_barcodes.selling_price).
                    setNumber("cost", to_inventory_barcodes.cost).
                    setString("supplier", to_inventory_barcodes.supplier).
                    setNumber("vatable", to_inventory_barcodes.vatable).
                    setNumber("reorder_level", to_inventory_barcodes.reorder_level).
                    setNumber("markup", to_inventory_barcodes.markup).
                    setString("brand", to_inventory_barcodes.brand).
                    setString("brand_id", to_inventory_barcodes.brand_id).
                    setString("model", to_inventory_barcodes.model).
                    setString("model_id", to_inventory_barcodes.model_id).
                    setNumber("selling_type", to_inventory_barcodes.selling_type).
                    setString("item_type", to_inventory_barcodes.item_type).
                    setString("barcode", to_inventory_barcodes.barcode).
                    setNumber("allow_negative_inventory", to_inventory.allow_negative_inventory).
                    setNumber("auto_order", to_inventory.auto_order).
                    setNumber("show_to_sales", to_inventory.show_to_sales).
                    ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            s2 = s2 + ";";
            query.add(s2);

            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> delete_inventory(to_inventory to_inventory) {
        try {
            List<String> query = new ArrayList();
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from inventory where "
                    + " barcode ='" + to_inventory.barcode + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);
            query.add(s0);
            String s2 = "delete from inventory_barcodes where "
                    + " main_barcode ='" + to_inventory.barcode + "' "
                    + " ";

            stmt.addBatch(s2);

            String s3 = "delete from inventory_assembly where "
                    + " main_item_code ='" + to_inventory.barcode + "' "
                    + " ";

            stmt.addBatch(s3);

            query.add(s2);
            stmt.executeBatch();
            conn.commit();

            Lg.s(Inventory_barcodes.class, "Successfully Deleted");
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data(String search) {
        List<to_inventory> datas = new ArrayList();

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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory where "
                    + " barcode like '%" + search + "%' "
                    + " or description like '%" + search + "%' "
                    + " ";

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
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(49);
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data22(String where) {
        List<to_inventory> datas = new ArrayList();

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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory  "
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
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }

            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data22_cloud(String where) {
        List<to_inventory> datas = new ArrayList();

        try {
            Connection conn = MyConnection.cloud_connect();
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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory  "
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
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            MyConnection.close();
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static List<to_inventory> ret_data3(String search) {
        List<to_inventory> datas = new ArrayList();

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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory where "
                    + " barcode = '" + search + "' "
                    //                    + " or description like '%" + search + "%' "
                    + " ";

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
                int is_uploaded = rs.getInt(37);

                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data4(String where) {
        List<to_inventory> datas = new ArrayList();
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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes  "
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
                String main_barcode = rs.getString(27);
                String brand = rs.getString(28);
                String brand_id = rs.getString(29);
                String model = rs.getString(30);
                String model_id = rs.getString(31);
                int selling_type = rs.getInt(32);
                String branch = rs.getString(33);
                String branch_code = rs.getString(34);
                String location = rs.getString(35);
                String location_id = rs.getString(36);
                int is_uploaded = rs.getInt(37);

                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory to = new to_inventory(id, main_barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data6(String where) {
        List<to_inventory> datas = new ArrayList();
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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory  "
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
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data5(String where) {
        List<to_inventory> datas = new ArrayList();
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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory_barcodes  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String branch1 = "";
            String location1 = "";
            String def_branch = "";
            String def_location = "";
            List<String> data = new ArrayList();
            List<String> data2 = new ArrayList();

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
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
//                int exist = 0;
//                for (String s : data) {
//                    if (s.equals(branch)) {
//                        exist = 1;
//                    }
//                }
//                if (exist == 0) {
//                    data.add(branch);
//                    branch1 = branch;
//                } else {
//                    branch1 = "";
//                }
//
//                int exist2 = 0;
//                for (String s : data2) {
//                    if (s.equals(location)) {
//                        exist2 = 1;
//                    }
//                }
//                if (exist2 == 0) {
//                    data2.add(location);
//                    location1 = location;
//                } else {
//                    location1 = "";
//                }
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, branch, location, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
//            for (String s : data) {
//                System.out.println("Branch: " + s);
//            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data7(String where) {
        List<to_inventory> datas = new ArrayList();
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
                    + ",is_uploaded"
                    + ",allow_negative_inventory"
                    + ",auto_order"
                    + ",show_to_sales"
                    + " from inventory  "
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
                int is_uploaded = rs.getInt(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales = rs.getInt(40);
                String s2 = "select "
                        + "product_qty"
                        + " from inventory_barcodes  "
                        + " where main_barcode like '" + barcode + "' and location_id='" + location_id + "' limit 1 ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    product_qty = rs2.getDouble(1);
                }
                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        List<to_item> datas = ret_data2("");
        for (to_item to : datas) {
            int id = 0;
            String barcode = "" + to.code;
            String description = to.descr;
            String generic_name = "";
            String category = to.category_code;
            String category_id = to.category_code;
            String classification = to.class_code;
            String classification_id = to.class_code;
            String sub_classification = to.sub_class_code;
            String sub_classification_id = to.sub_class_code;
            double product_qty = 0;
            String unit = to.uom;
            double conversion = 1;
            double selling_price = 0;
            String date_added = DateType.now();
            String user_name = "";
            String item_type = "";
            int status = 1;
            String supplier = "";
            int fixed_price = 0;
            double cost = FitIn.toDouble(to.average_cost);
            String supplier_id = "";
            int multi_level_pricing = 0;
            int vatable = 1;
            double reorder_level = FitIn.toDouble(to.reorder_quantity);
            double markup = 0;
            String barcodes = "";
            String brand = "" + to.brand_code;
            String brand_id = "" + to.brand_code;
            String model = "" + to.model_code;
            String model_id = "" + to.model_code;
            int selling_type = 0;
            if (to.selling_type.equals("LOT")) {
                selling_type = 1;
            }
            String location = to.location;
            String location_id = to.location_id;
            int is_uploaded = 0;
            int allow_negative_inventory = 0;
            int auto_order = 1;
            int show_to_sales = 1;
            to_inventory t1 = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, to.branch, to.branch_id, location, location_id, false, is_uploaded, allow_negative_inventory, auto_order, show_to_sales);
            add_inventory(t1);
            Inventory_barcodes.to_inventory_barcodes codes = new Inventory_barcodes.to_inventory_barcodes(id, "", description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcode, brand, brand_id, model, model_id, selling_type, to.branch, to.branch_id, to.location, to.location_id, "", "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);
//          S1_inventory_barcodes.add_inventory_barcodes(codes);
        }
    }

    public static class to_item {

        public final int code;
        public final String descr;
        public final String category_code;
        public final String class_code;
        public final String sub_class_code;
        public final int brand_code;
        public final int model_code;
        public final String color;
        public final String size_dimension;
        public final String uom;
        public final String last_receipt_cost;
        public final String average_cost;
        public final String part_no;
        public final String gross_weight;
        public final String net_weight;
        public final String weight_uom;
        public final String reorder_quantity;
        public final String status;
        public final String selling_type;
        public final String location;
        public final String location_id;
        public final String branch;
        public final String branch_id;

        public to_item(int code, String descr, String category_code, String class_code, String sub_class_code, int brand_code, int model_code, String color, String size_dimension, String uom, String last_receipt_cost, String average_cost, String part_no, String gross_weight, String net_weight, String weight_uom, String reorder_quantity, String status, String selling_type, String location, String location_id, String branch, String branch_id) {
            this.code = code;
            this.descr = descr;
            this.category_code = category_code;
            this.class_code = class_code;
            this.sub_class_code = sub_class_code;
            this.brand_code = brand_code;
            this.model_code = model_code;
            this.color = color;
            this.size_dimension = size_dimension;
            this.uom = uom;
            this.last_receipt_cost = last_receipt_cost;
            this.average_cost = average_cost;
            this.part_no = part_no;
            this.gross_weight = gross_weight;
            this.net_weight = net_weight;
            this.weight_uom = weight_uom;
            this.reorder_quantity = reorder_quantity;
            this.status = status;
            this.selling_type = selling_type;
            this.location = location;
            this.location_id = location_id;
            this.branch = branch;
            this.branch_id = branch_id;
        }
    }

    public static List<to_item> ret_data2(String search) {
        List<to_item> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "code"
                    + ",descr"
                    + ",category_code"
                    + ",class_code"
                    + ",sub_class_code"
                    + ",brand_code"
                    + ",model_code"
                    + ",color"
                    + ",size_dimension"
                    + ",uom"
                    + ",last_receipt_cost"
                    + ",average_cost"
                    + ",part_no"
                    + ",gross_weight"
                    + ",net_weight"
                    + ",weight_uom"
                    + ",reorder_quantity"
                    + ",status"
                    + ",selling_type"
                    + " from pisps_dbo.item where "
                    + " descr like'%" + search + "%' and code>7927"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int code = rs.getInt(1);
                String descr = rs.getString(2);
                String category_code = rs.getString(3);
                String class_code = rs.getString(4);
                String sub_class_code = rs.getString(5);
                int brand_code = rs.getInt(6);
                int model_code = rs.getInt(7);
                String color = rs.getString(8);
                String size_dimension = rs.getString(9);
                String uom = rs.getString(10);
                String last_receipt_cost = rs.getString(11);
                String average_cost = rs.getString(12);
                String part_no = rs.getString(13);
                String gross_weight = rs.getString(14);
                String net_weight = rs.getString(15);
                String weight_uom = rs.getString(16);
                String reorder_quantity = rs.getString(17);
                String status = rs.getString(18);
                String selling_type = rs.getString(19);

                to_item to = new to_item(code, descr, category_code, class_code, sub_class_code, brand_code, model_code, color, size_dimension, uom, last_receipt_cost, average_cost, part_no, gross_weight, net_weight, weight_uom, reorder_quantity, status, selling_type, "", "", "", "");
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from inventory where location_id like '' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "0";
            } else {
                String s2 = "select barcode from inventory where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }
            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id_special(String location_id) {
        String ids = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from inventory where location_id like '" + location_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = location_id + "00000";
            } else {
                String s2 = "select barcode from inventory where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }
            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_barcode(String item_code, String barcode) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inventory set "
                    + " barcodes= :barcodes"
                    + " ,is_uploaded= 2"
                    + " where "
                    + " barcode ='" + item_code + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("barcodes", barcode)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory.class, "Successfully Updated");

            String s2 = "update inventory_barcodes set "
                    + "barcode= :barcode"
                    + " ,is_uploaded= 2"
                    + " where "
                    + " main_barcode ='" + item_code + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("barcode", barcode)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Inventory.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_price(String item_code, double price, String unit, User_price_change_request_logs.to_user_price_change_request_logs log) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("");
            String s0 = "update inventory set "
                    + " selling_price= :selling_price"
                    + ",unit= :unit"
                    + " where "
                    + " barcode ='" + item_code + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("selling_price", price)
                    .setString("unit", unit)
                    .ok();

            stmt.addBatch(s0);

            String s2 = "update inventory_barcodes set "
                    + " selling_price= :selling_price"
                    + ",unit= :unit"
                    + " where "
                    + " main_barcode ='" + item_code + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("selling_price", price)
                    .setString("unit", unit)
                    .ok();
            stmt.addBatch(s2);

            String s3 = "insert into user_price_change_request_logs("
                    + "user_id"
                    + ",user_name"
                    + ",created_at"
                    + ",updated_at"
                    + ",item_code"
                    + ",description"
                    + ",old_unit"
                    + ",new_unit"
                    + ",old_price"
                    + ",new_price"
                    + ",status"
                    + ")values("
                    + ":user_id"
                    + ",:user_name"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:item_code"
                    + ",:description"
                    + ",:old_unit"
                    + ",:new_unit"
                    + ",:old_price"
                    + ",:new_price"
                    + ",:status"
                    + ")";

            s3 = SqlStringUtil.parse(s3)
                    .setString("user_id", log.user_id)
                    .setString("user_name", log.user_name)
                    .setString("created_at", log.created_at)
                    .setString("updated_at", log.updated_at)
                    .setString("item_code", log.item_code)
                    .setString("description", log.description)
                    .setString("old_unit", log.old_unit)
                    .setString("new_unit", log.new_unit)
                    .setNumber("old_price", log.old_price)
                    .setNumber("new_price", log.new_price)
                    .setNumber("status", log.status)
                    .ok();
            stmt.addBatch(s3);
            stmt.executeBatch();
            conn.commit();

            Lg.s(Inventory.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void set_console(List<String> query) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            for (String s : query) {
                PreparedStatement stmt = conn.prepareStatement(s);
                stmt.execute();
            }
            conn.commit();
            Lg.s(Inventory.class, "Successfully Executed!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
