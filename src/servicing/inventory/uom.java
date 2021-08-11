/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;

import servicing.inventory.Inventory.to_inventory;
import servicing.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class uom {

    public static void main2(String[] args) {
        String uoms = "[pc:765.00/1^1],[box:14000.01/100^0],[sack:15000.50/105^0]";
        String[] list = uoms.split(",");
        for (String s : list) {
            int i = s.indexOf(":");
            int ii = s.indexOf("/");
            int iii = s.indexOf("^");
            String uom = s.substring(1, i);
            double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
            double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
            int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
            System.out.println("Uom: " + uom);
            System.out.println("Conversion : " + FitIn.fmt_woc(conversion));
            System.out.println("Price: " + FitIn.fmt_wc_0(selling_price));
            System.out.println("Default: " + is_default);
        }
    }

    public static String convert_to_string(String uom, double conversion, double selling_price, int is_default) {
        String uoms = "[" + uom + ":" + selling_price + "/" + conversion + "^" + is_default + "]";
        return uoms;
    }

    public static String convert_to_string2(String uoms, Dlg_inventory_uom.to_uom default_uom) {
        List<Dlg_inventory_uom.to_uom> datas = new ArrayList();
        String[] list = uoms.split(",");
        int exist = 0;
        for (String s : list) {
            int i = s.indexOf(":");
            int ii = s.indexOf("/");
            int iii = s.indexOf("^");
            String uom = s.substring(1, i);
            double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
            double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
            int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
            if (default_uom.uom.equalsIgnoreCase(uom)) {
                is_default = 1;
                conversion = default_uom.conversion;
                selling_price = default_uom.selling_price;
                exist = 1;
            }
            Dlg_inventory_uom.to_uom to = new Dlg_inventory_uom.to_uom(0, uom, conversion, selling_price, is_default);
            datas.add(to);
        }
        if (exist == 0) {
            datas.add(default_uom);
        }
        String uom = "";
        for (Dlg_inventory_uom.to_uom to : datas) {
            uom = uom + ",[" + to.uom + ":" + to.selling_price + "/" + to.conversion + "^" + to.is_default + "]";
        }
        uom = uom.substring(1, uom.length());
        return uom;
    }

    public static Dlg_inventory_uom.to_uom default_uom(String uoms) {

        try {
            String[] list = uoms.split(",");
            Dlg_inventory_uom.to_uom to = new Dlg_inventory_uom.to_uom(0, "", 0, 0, 0);

            for (String s : list) {
                int i = s.indexOf(":");
                int ii = s.indexOf("/");
                int iii = s.indexOf("^");

                String uom = s.substring(1, i);
                double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                if (is_default == 1) {
                    to = new Dlg_inventory_uom.to_uom(0, uom, conversion, selling_price, is_default);
                    break;
                }
            }
            return to;
        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String[] args) {
        Connection conn = MyConnection.connect();
        try {
            List<to_inventory> datas = ret_data("");
            for (to_inventory to : datas) {
                String uom = "pc";
                double conversion = 1;
                double selling_price = to.selling_price;
                int is_default = 1;
                System.out.println();
                String uoms = convert_to_string(uom, conversion, selling_price, is_default);

                String s0 = "update inventory set unit='" + uoms + "' "
                        + " where barcode='" + to.barcode + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s2 = "update inventory_barcodes set unit='" + uoms + "' "
                        + " where main_barcode='" + to.barcode + "' "
                        + " ";
                s2 = SqlStringUtil.parse(s2)
                        .ok();
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                System.out.println("Item Code: " + to.barcode + " : " + uoms);
                Lg.s(uom.class, "Successfully Updated: " + to.barcode);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory> ret_data(String where) {
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
                    + " from inventory"
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
                int show_to_sales=rs.getInt(40);
//                to_inventory to = new to_inventory(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcodes, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, false, is_uploaded,allow_negative_inventory,auto_order,show_to_sales);
//                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
