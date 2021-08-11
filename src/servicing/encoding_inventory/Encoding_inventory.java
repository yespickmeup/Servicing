/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.encoding_inventory;

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
 * @author Ronald
 */
public class Encoding_inventory {

    public static class to_encoding_inventory {

        public final int id;
        public final String item_code;
        public final String barcode;
        public final String description;
        public final String branch;
        public final String branch_id;
        public final String location;
        public final String location_id;
        public final double qty;
        public final String date_added;
        public final String user_name;
        public final String screen_name;
        public final String sheet_no;
        public final int status;
        public final String counted_by;
        public final String checked_by;
        public final double cost;
        public final double selling_price;
        public final String user_id;
        public final String user_screen_name;
        public final String remarks;

        public to_encoding_inventory(int id, String item_code, String barcode, String description, String branch, String branch_id, String location, String location_id, double qty, String date_added, String user_name, String screen_name, String sheet_no, int status, String counted_by, String checked_by, double cost, double selling_price, String user_id, String user_screen_name, String remarks) {
            this.id = id;
            this.item_code = item_code;
            this.barcode = barcode;
            this.description = description;
            this.branch = branch;
            this.branch_id = branch_id;
            this.location = location;
            this.location_id = location_id;
            this.qty = qty;
            this.date_added = date_added;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.sheet_no = sheet_no;
            this.status = status;
            this.counted_by = counted_by;
            this.checked_by = checked_by;
            this.cost = cost;
            this.selling_price = selling_price;
            this.user_id = user_id;
            this.user_screen_name = user_screen_name;
            this.remarks = remarks;
        }
    }

    public static void add_encoding_inventory(to_encoding_inventory to_encoding_inventory) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into encoding_inventory("
                    + "item_code"
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
                    + ")values("
                    + ":item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:qty"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:sheet_no"
                    + ",:status"
                    + ",:counted_by"
                    + ",:checked_by"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:remarks"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("item_code", to_encoding_inventory.item_code).
                    setString("barcode", to_encoding_inventory.barcode).
                    setString("description", to_encoding_inventory.description).
                    setString("branch", to_encoding_inventory.branch).
                    setString("branch_id", to_encoding_inventory.branch_id).
                    setString("location", to_encoding_inventory.location).
                    setString("location_id", to_encoding_inventory.location_id).
                    setNumber("qty", to_encoding_inventory.qty).
                    setString("date_added", to_encoding_inventory.date_added).
                    setString("user_name", to_encoding_inventory.user_name).
                    setString("screen_name", to_encoding_inventory.screen_name).
                    setString("sheet_no", to_encoding_inventory.sheet_no).
                    setNumber("status", to_encoding_inventory.status).
                    setString("counted_by", to_encoding_inventory.counted_by).
                    setString("checked_by", to_encoding_inventory.checked_by).
                    setNumber("cost", to_encoding_inventory.cost).
                    setNumber("selling_price", to_encoding_inventory.selling_price).
                    setString("user_id", to_encoding_inventory.user_id).
                    setString("user_screen_name", to_encoding_inventory.user_screen_name).
                    setString("remarks", to_encoding_inventory.remarks).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Encoding_inventory.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_encoding_inventory_cloud(to_encoding_inventory to_encoding_inventory) {
        try {
            Connection conn = MyConnection.cloud_connect();
            Connection conn2 = MyConnection.connect();
            conn.setAutoCommit(false);
            conn2.setAutoCommit(false);
            String s0 = "insert into encoding_inventory("
                    + "item_code"
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
                    + ")values("
                    + ":item_code"
                    + ",:barcode"
                    + ",:description"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:location"
                    + ",:location_id"
                    + ",:qty"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:sheet_no"
                    + ",:status"
                    + ",:counted_by"
                    + ",:checked_by"
                    + ",:cost"
                    + ",:selling_price"
                    + ",:user_id"
                    + ",:user_screen_name"
                    + ",:remarks"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("item_code", to_encoding_inventory.item_code).
                    setString("barcode", to_encoding_inventory.barcode).
                    setString("description", to_encoding_inventory.description).
                    setString("branch", to_encoding_inventory.branch).
                    setString("branch_id", to_encoding_inventory.branch_id).
                    setString("location", to_encoding_inventory.location).
                    setString("location_id", to_encoding_inventory.location_id).
                    setNumber("qty", to_encoding_inventory.qty).
                    setString("date_added", to_encoding_inventory.date_added).
                    setString("user_name", to_encoding_inventory.user_name).
                    setString("screen_name", to_encoding_inventory.screen_name).
                    setString("sheet_no", to_encoding_inventory.sheet_no).
                    setNumber("status", to_encoding_inventory.status).
                    setString("counted_by", to_encoding_inventory.counted_by).
                    setString("checked_by", to_encoding_inventory.checked_by).
                    setNumber("cost", to_encoding_inventory.cost).
                    setNumber("selling_price", to_encoding_inventory.selling_price).
                    setString("user_id", to_encoding_inventory.user_id).
                    setString("user_screen_name", to_encoding_inventory.user_screen_name).
                    setString("remarks", to_encoding_inventory.remarks).
                    ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = " update encoding_inventory set is_uploaded=1 where id='" + to_encoding_inventory.id + "'";
            PreparedStatement stmt2 = conn2.prepareStatement("");
            stmt2.addBatch(s2);

            stmt.executeBatch();
            conn.commit();

            stmt2.executeBatch();
            conn2.commit();

            conn.close();
            conn2.close();
            Lg.s(Encoding_inventory.class, "Successfully Added: " + to_encoding_inventory.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_encoding_inventory(to_encoding_inventory to_encoding_inventory) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update encoding_inventory set "
                    + " item_code= :item_code"
                    + ",barcode= :barcode"
                    + ",description= :description"
                    + ",branch= :branch"
                    + ",branch_id= :branch_id"
                    + ",location= :location"
                    + ",location_id= :location_id"
                    + ",qty= :qty"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",screen_name= :screen_name"
                    + ",sheet_no= :sheet_no"
                    + ",status= :status"
                    + ",counted_by= :counted_by"
                    + ",checked_by= :checked_by"
                    + ",cost= :cost"
                    + ",selling_price= :selling_price"
                    + ",user_id= :user_id"
                    + ",user_screen_name= :user_screen_name"
                    + ",remarks= :remarks"
                    + " where "
                    + " id ='" + to_encoding_inventory.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("item_code", to_encoding_inventory.item_code).
                    setString("barcode", to_encoding_inventory.barcode).
                    setString("description", to_encoding_inventory.description).
                    setString("branch", to_encoding_inventory.branch).
                    setString("branch_id", to_encoding_inventory.branch_id).
                    setString("location", to_encoding_inventory.location).
                    setString("location_id", to_encoding_inventory.location_id).
                    setNumber("qty", to_encoding_inventory.qty).
                    setString("date_added", to_encoding_inventory.date_added).
                    setString("user_name", to_encoding_inventory.user_name).
                    setString("screen_name", to_encoding_inventory.screen_name).
                    setString("sheet_no", to_encoding_inventory.sheet_no).
                    setNumber("status", to_encoding_inventory.status).
                    setString("counted_by", to_encoding_inventory.counted_by).
                    setString("checked_by", to_encoding_inventory.checked_by).
                    setNumber("cost", to_encoding_inventory.cost).
                    setNumber("selling_price", to_encoding_inventory.selling_price).
                    setString("user_id", to_encoding_inventory.user_id).
                    setString("user_screen_name", to_encoding_inventory.user_screen_name).
                    setString("remarks", to_encoding_inventory.remarks).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Encoding_inventory.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_encoding_inventory(to_encoding_inventory to_encoding_inventory) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from encoding_inventory where "
                    + " id ='" + to_encoding_inventory.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Encoding_inventory.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_encoding_inventory2(to_encoding_inventory to_encoding_inventory) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update  encoding_inventory set status = 2 where "
                    + " id ='" + to_encoding_inventory.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            double my_qty = 0;
            String unit = "";
            double conversion = 0;
            String s3 = "select"
                    + " product_qty"
                    + " ,unit"
                    + " ,conversion"
                    + " from inventory_barcodes where "
                    + "  main_barcode ='" + to_encoding_inventory.item_code + "' "
                    + " and location_id ='" + to_encoding_inventory.location_id + "' "
                    + " ";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            if (rs3.next()) {
                my_qty = rs3.getDouble(1);
                unit = rs3.getString(2);
                conversion = rs3.getDouble(3);
            }

            double new_qty = my_qty - to_encoding_inventory.qty;
            String s2 = " update inventory_barcodes set "
                    + " product_qty= :product_qty"
                    + " where "
                    + " main_barcode ='" + to_encoding_inventory.item_code + "' "
                    + " and location_id='" + to_encoding_inventory.location_id + "'"
                    + " ";
            s2 = SqlStringUtil.parse(s2)
                    .setNumber("product_qty", new_qty)
                    .ok();
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Encoding_inventory.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_encoding_inventory> ret_data(String search, String user_name1) {
        List<to_encoding_inventory> datas = new ArrayList();

        int count = 1;
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
                    + " from encoding_inventory where "
                    + " sheet_no ='" + search + "' and user_name='" + user_name1 + "'"
                    + " order by id desc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = "" + count;
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
                count++;
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_encoding_inventory> ret_data_report(String search) {
        List<to_encoding_inventory> datas = new ArrayList();

        int count = 1;
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
                    + " from encoding_inventory where "
                    + " sheet_no ='" + search + "'"
                    + " order by id desc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String item_code = rs.getString(2);
                String barcode = rs.getString(3);
                String description = rs.getString(4);
                String branch = rs.getString(5);
                String branch_id = rs.getString(6);
                String location = "" + count;
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
                count++;
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_encoding_inventory> ret_data_encoding(String where) {
        List<to_encoding_inventory> datas = new ArrayList();

        int count = 1;
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
                    + " from encoding_inventory "
                    + " "
                    + " " + where
                    + " order by id desc";

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
                String screen_name = "" + count;
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
                count++;
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_encoding_inventory> ret_data_encoding2(String where) {
        List<to_encoding_inventory> datas = new ArrayList();

        int count = 1;
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
                String screen_name = "" + count;
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
                count++;
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
