/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;


import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import servicing.inventory.Inventory_barcodes;
import servicing.utils.MyConnection;

/**
 *
 * @author Ronald
 */
public class S1_branch_locations {

    public static class to_branch_locations {

        public final int id;
        public final String branch;
        public final String branch_id;
        public final String code;
        public final String location;
        public final String type;
        public final int status;

        public to_branch_locations(int id, String branch, String branch_id, String code, String location, String type, int status) {
            this.id = id;
            this.branch = branch;
            this.branch_id = branch_id;
            this.code = code;
            this.location = location;
            this.type = type;
            this.status = status;
        }
    }

    public static void add_branch_locations(to_branch_locations to_branch_locations, int add_item) {
        try {
            Connection conn = MyConnection.connect();
            List<String> query = new ArrayList();
            Gson gson = new Gson();
            System.out.println("adding record....");

            String s0 = "insert into branch_locations("
                    + "branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + ")values("
                    + ":branch"
                    + ",:branch_id"
                    + ",:code"
                    + ",:location"
                    + ",:type"
                    + ",status"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("branch", to_branch_locations.branch).
                    setString("branch_id", to_branch_locations.branch_id).
                    setString("code", to_branch_locations.code).
                    setString("location", to_branch_locations.location).
                    setString("type", to_branch_locations.type).
                    setNumber("status", to_branch_locations.status).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_branch_locations.class, "Successfully Added");
            query.add(s0);

            String s4 = "select "
                    + " id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations"
                    + " where branch_id='" + to_branch_locations.branch_id + "' "
                    + " and location = '" + to_branch_locations.location + "' ";

            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            String location_ids = "";
            if (rs4.next()) {
                int id = rs4.getInt(1);
                String branch = rs4.getString(2);
                String branch_id = rs4.getString(3);
                String code = rs4.getString(4);
                String location = rs4.getString(5);
                String type = rs4.getString(6);
                int status = rs4.getInt(7);
                location_ids = "" + id;
            }

            if (add_item == 1) {
                String s2 = "select "
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
                        + ",allow_negative_inventory"
                        + ",auto_order"
                        + ",show_to_sales"
                        + " from inventory"
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt.executeQuery(s2);
                while (rs2.next()) {
                    int id = rs2.getInt(1);
                    String barcode = rs2.getString(2);
                    String description = rs2.getString(3);
                    String generic_name = rs2.getString(4);
                    String category = rs2.getString(5);
                    String category_id = rs2.getString(6);
                    String classification = rs2.getString(7);
                    String classification_id = rs2.getString(8);
                    String sub_classification = rs2.getString(9);
                    String sub_classification_id = rs2.getString(10);
                    double product_qty = rs2.getDouble(11);
                    String unit = rs2.getString(12);
                    double conversion = rs2.getDouble(13);
                    double selling_price = rs2.getDouble(14);
                    String date_added = rs2.getString(15);
                    String user_name = rs2.getString(16);
                    String item_type = rs2.getString(17);
                    int status = rs2.getInt(18);
                    String supplier = rs2.getString(19);
                    int fixed_price = rs2.getInt(20);
                    double cost = rs2.getDouble(21);
                    String supplier_id = rs2.getString(22);
                    int multi_level_pricing = rs2.getInt(23);
                    int vatable = rs2.getInt(24);
                    double reorder_level = rs2.getDouble(25);
                    double markup = rs2.getDouble(26);
                    String barcodes = rs2.getString(27);
                    String brand = rs2.getString(28);
                    String brand_id = rs2.getString(29);
                    String model = rs2.getString(30);
                    String model_id = rs2.getString(31);
                    int selling_type = rs2.getInt(32);
                    String branch = to_branch_locations.branch;
                    String branch_code = "" + to_branch_locations.branch_id;
                    String location = to_branch_locations.location;
                    String location_id = location_ids;
                    int allow_negative_inventory = rs2.getInt(37);
                    int auto_order = rs2.getInt(38);
                    int show_to_sales = rs2.getInt(39);
                    Inventory_barcodes.to_inventory_barcodes to_inventory_barcodes = new Inventory_barcodes.to_inventory_barcodes(0, "", description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, "", "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, show_to_sales);

                    String s5 = "insert into inventory_barcodes("
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
                            + ")";

                    s5 = SqlStringUtil.parse(s5).
                            setString("barcode", barcodes).
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
                            setString("branch", to_inventory_barcodes.branch).
                            setString("branch_code", to_inventory_barcodes.branch_code).
                            setString("location", location).
                            setString("location_id", "" + location_id).
                            setString("serial_no", to_inventory_barcodes.serial_no).
                            ok();
                    PreparedStatement stmt5 = conn.prepareStatement(s5);
                    stmt5.execute();
                    Lg.s(Inventory_barcodes.class, "Successfully Added" + " Barcode:" + to_inventory_barcodes.main_barcode + " = " + to_inventory_barcodes.location);

                }
            }

            String json = gson.toJson(query);
//            Main_branch_query_uploads.add_data(new Main_branch_query_uploads.to_main_branch_query_uploads(0, json, "", "", "Branch Location - Inventory", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0));
            System.out.println("Record added....");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_branch_locations(to_branch_locations to_branch_locations) {
        try {
            Connection conn = MyConnection.connect();
            List<String> query = new ArrayList();
            Gson gson = new Gson();
            System.out.println("updating record....");

            String s0 = "update branch_locations set "
                    + "branch= :branch"
                    + ",branch_id= :branch_id"
                    + ",code= :code"
                    + ",location= :location"
                    + ",type= :type"
                    + ",status= :status"
                    + " where "
                    + " id ='" + to_branch_locations.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("branch", to_branch_locations.branch).
                    setString("branch_id", to_branch_locations.branch_id).
                    setString("code", to_branch_locations.code).
                    setString("location", to_branch_locations.location).
                    setString("type", to_branch_locations.type).
                    setNumber("status", to_branch_locations.status).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_branch_locations.class, "Successfully Updated");
            query.add(s0);

            String s2 = "update inventory_barcodes set location='" + to_branch_locations.location + "' "
                    + " where location_id='" + to_branch_locations.id + "' "
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_branch_locations.class, "Successfully Updated");
            query.add(s2);

            String json = gson.toJson(query);
//            Main_branch_query_uploads.add_data(new Main_branch_query_uploads.to_main_branch_query_uploads(0, json, "", "", "Branch Location - Inventory", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0));
//            System.out.println("Record updated....");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_branch_locations(to_branch_locations to_branch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from branch_locations where "
                    + " id ='" + to_branch_locations.id + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_branch_locations.class, "Successfully Deleted");

            String s2 = "delete from inventory_barcodes  "
                    + " where location_id='" + to_branch_locations.id + "' "
                    + " ";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_branch_locations.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_data(String search) {
        List<to_branch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations where "
                    + " location like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);
                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_data2(String where) {
        List<to_branch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);
                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_data_by_branch_id(String branch_ids, String locations) {
        List<to_branch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations where "
                    + " branch_id = '" + branch_ids + "' "
                    + " and "
                    + " location like '%" + locations + "%'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);
                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_data_branch(String search, String branch_ids) {
        List<to_branch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations where "
                    + "branch_id like'%" + branch_ids + "%'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);
                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_where(String where) {
        List<to_branch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);
                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_where2(String where) {
        List<to_branch_locations> datas = new ArrayList();
        to_branch_locations to2 = new to_branch_locations(0, "", "", "", "All", "", 0);
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);
                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branch_locations> ret_location_where(String where) {
        List<to_branch_locations> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",branch"
                    + ",branch_id"
                    + ",code"
                    + ",location"
                    + ",type"
                    + ",status"
                    + " from branch_locations  "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch = rs.getString(2);
                String branch_id = rs.getString(3);
                String code = rs.getString(4);
                String location = rs.getString(5);
                String type = rs.getString(6);
                int status = rs.getInt(7);

                to_branch_locations to = new to_branch_locations(id, branch, branch_id, code, location, type, status);
                datas.add(to);
            }
            MyConnection.close();
            return datas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_branch_location {

        public final String name;
        public final String type;
        public final String branch_code2;

        public to_branch_location(String name, String type, String branch_code2) {
            this.name = name;
            this.type = type;
            this.branch_code2 = branch_code2;
        }
    }

    public static void main2(String[] args) {
        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "name"
                    + ",type"
                    + ",branch_code2"
                    + " from pisps_dbo.branch_location where "
                    + " name like'%" + "" + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String type = rs.getString(2);
                String branch_code2 = rs.getString(3);
                int id = 0;
                String branch = branch_code2;
                String branch_id = branch_code2;
                String code = "";
                String location = name;
                to_branch_locations t = new to_branch_locations(id, branch, branch_id, code, location, type, 0);
                add_branch_locations(t,0);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main3(String[] args) {
        List<to_branch_locations> datas = ret_data("");
        List<Inventory_barcodes.to_inventory_barcodes> items = Inventory_barcodes.
                ret_data3("");
        System.out.println(items.size());
        for (to_branch_locations t : datas) {
            if (t.id == 6) {
//                System.out.println(t.location + " : " + t.id);
            } else {
                for (Inventory_barcodes.to_inventory_barcodes to : items) {
                    int id = 0;
                    String barcode = to.barcode;
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
                    String main_barcode = to.main_barcode;
                    String brand = to.brand;
                    String brand_id = to.brand_id;
                    String model = to.model;
                    String model_id = to.model_id;
                    int selling_type = to.selling_type;
                    String branch = t.branch;
                    String branch_code = t.branch_id;
                    String location = t.location;
                    String location_id = "" + t.id;
                    String serial_no = "";
                    int allow_negative_inventory = to.allow_negative_inventory;
                    int auto_order = to.auto_order;
                    Inventory_barcodes.to_inventory_barcodes ti = new Inventory_barcodes.to_inventory_barcodes(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, vatable, reorder_level, markup, main_barcode, brand, brand_id, model, model_id, selling_type, branch, branch_code, location, location_id, serial_no, "", 0, 0, "", "", "", 0, 0, allow_negative_inventory, auto_order, to.show_to_sales);
                    Inventory_barcodes.add_inventory_barcodes(ti);
                }

            }
        }
    }

    public static void change_default_location(to_branch_locations to_branch_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update branch_locations set "
                    + "status= :status "
                    + " where id='" + to_branch_locations.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("status", 1)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update branch_locations set "
                    + "status= :status "
                    + " where id<>'" + to_branch_locations.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setNumber("status", 0)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(S1_branch_locations.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main5(String[] args) {
        try {
            Connection conn = MyConnection.connect();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
