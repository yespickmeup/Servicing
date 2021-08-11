/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;

import servicing.branch_locations.Branch_locations;
import servicing.inventory.Inventory_barcodes.to_inventory_barcodes;
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
import servicing.branch_locations.S1_branch_locations.to_branch_locations;

/**
 *
 * @author Ronald
 */
public class S2_inventory_barcodes {

    public static void add_inventory_barcodes(to_inventory_barcodes to_inventory_barcodes) {
        try {
            Connection conn = MyConnection.connect();
            List<to_branch_locations> datas = Branch_locations.ret_all_locations();
            for (to_branch_locations to : datas) {
                String s0 = "insert into inventory_barcodes("
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
                        + ")";

                s0 = SqlStringUtil.parse(s0).
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
                        setNumber("status", to_inventory_barcodes.status).
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
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory_barcodes.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to.location);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory_barcodes> ret_data(String where) {
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
                    + " from inventory_barcodes   "
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
                String serial_no = rs.getString(37);
                int allow_negative_inventory = rs.getInt(38);
                int auto_order = rs.getInt(39);
                int show_to_sales=rs.getInt(40);
//                to_inventory_barcodes to = new to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0,allow_negative_inventory,auto_order,show_to_sales
//);
//                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_inventory_barcodes(String item_code, String location_id, double qty_ledger, double qty_maintenance) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String s4 = "update inventory_barcodes set "
                    + " product_qty='" + qty_ledger + "'"
                    + " where  main_barcode= '" + item_code + "' and location_id='" + location_id + "' "
                    + "";
            stmt.addBatch(s4);

            stmt.executeBatch();
            conn.commit();
            Lg.s(S2_inventory_barcodes.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
