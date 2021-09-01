/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.reports;

import servicing.inventory.Inventory;
import servicing.inventory.Inventory.to_inventory;
import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Srpt_report_item {

    public static void edit_model(List<to_inventory> inventory, String model, String model_id) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory to_inventory : inventory) {
                String s0 = "update inventory set "
                        + "model= :model"
                        + ",model_id= :model_id"
                        + " where "
                        + " barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setString("model", model)
                        .setString("model_id", model_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);

                String s2 = "update inventory_barcodes set "
                        + "model= :model"
                        + ",model_id= :model_id"
                        + " where "
                        + " main_barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setString("model", model)
                        .setString("model_id", model_id)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_brand(List<to_inventory> inventory, String brand, String brand_id) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory to_inventory : inventory) {
                String s0 = "update inventory set "
                        + "brand= :brand"
                        + ",brand_id= :brand_id"
                        + " where "
                        + " barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setString("brand", brand)
                        .setString("brand_id", brand_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);

                String s2 = "update inventory_barcodes set "
                        + "brand= :brand"
                        + ",brand_id= :brand_id"
                        + " where "
                        + " main_barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setString("brand", brand)
                        .setString("brand_id", brand_id)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sub_classification(List<to_inventory> inventory, String sub_classification, String sub_classification_id) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory to_inventory : inventory) {
                String s0 = "update inventory set "
                        + "sub_classification= :sub_classification"
                        + ",sub_classification_id= :sub_classification_id"
                        + " where "
                        + " barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setString("sub_classification", sub_classification)
                        .setString("sub_classification_id", sub_classification_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);

                String s2 = "update inventory_barcodes set "
                        + "sub_classification= :sub_classification"
                        + ",sub_classification_id= :sub_classification_id"
                        + " where "
                        + " main_barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setString("sub_classification", sub_classification)
                        .setString("sub_classification_id", sub_classification_id)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_classification(List<to_inventory> inventory, String classification, String classification_id) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory to_inventory : inventory) {
                String s0 = "update inventory set "
                        + "classification= :classification"
                        + ",classification_id= :classification_id"
                        + " where "
                        + " barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setString("classification", classification)
                        .setString("classification_id", classification_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);

                String s2 = "update inventory_barcodes set "
                        + "classification= :classification"
                        + ",classification_id= :classification_id"
                        + " where "
                        + " main_barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setString("classification", classification)
                        .setString("classification_id", classification_id)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_category(List<to_inventory> inventory, String category, String category_id) {
        try {
            Connection conn = MyConnection.connect();
            for (to_inventory to_inventory : inventory) {
                String s0 = "update inventory set "
                        + "category= :category"
                        + ",category_id= :category_id"
                        + " where "
                        + " barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setString("category", category)
                        .setString("category_id", category_id)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);

                String s2 = "update inventory_barcodes set "
                        + "category= :category"
                        + ",category_id= :category_id"
                        + " where "
                        + " main_barcode ='" + to_inventory.barcodes + "' "
                        + " ";

                s2 = SqlStringUtil.parse(s2)
                        .setString("category", category)
                        .setString("category_id", category_id)
                        .ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(Inventory.class, "Successfully Updated: " + to_inventory.barcodes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
