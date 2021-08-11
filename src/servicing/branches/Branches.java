/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.branches;


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
import servicing.users.MyUser;
import servicing.utils.DateType;
import servicing.utils.MyConnection;

/**
 *
 * @author i1
 */
public class Branches {

    public static class to_branches {

        public final int id;
        public final String code;
        public final String branch;
        public final String address;
        public final int status;

        public to_branches(int id, String code, String branch, String address, int status) {
            this.id = id;
            this.code = code;
            this.branch = branch;
            this.address = address;
            this.status = status;
        }
    }

    public static void add_branches(to_branches to_branches) {
        try {
            Connection conn = MyConnection.connect();
            List<String> query = new ArrayList();
            Gson gson = new Gson();
            System.out.println("adding record....");

            String s0 = "insert into branches("
                    + "code"
                    + ",branch"
                    + ",address"
                    + ",status"
                    + ")values("
                    + ":code"
                    + ",:branch"
                    + ",:address"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_branches.code).
                    setString("branch", to_branches.branch).
                    setString("address", to_branches.address).
                    setNumber("status", to_branches.status).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Branches.class, "Successfully Added");
            query.add(s0);

            String json = gson.toJson(query);
//            Main_branch_query_uploads.add_data(new Main_branch_query_uploads.to_main_branch_query_uploads(0, json,"","", "Branches", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0));
//            System.out.println("Record added....");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_branches(to_branches to_branches) {
        try {
            Connection conn = MyConnection.connect();

            List<String> query = new ArrayList();
            Gson gson = new Gson();
            System.out.println("updating record....");

            String s0 = "update branches set "
                    + "code= :code"
                    + ",branch= :branch"
                    + ",address= :address"
                    + ",status= :status"
                    + " where "
                    + " id ='" + to_branches.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("code", to_branches.code).
                    setString("branch", to_branches.branch).
                    setString("address", to_branches.address).
                    setNumber("status", to_branches.status).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Branches.class, "Successfully Updated");
            query.add(s0);
            String json = gson.toJson(query);
//            Main_branch_query_uploads.add_data(new Main_branch_query_uploads.to_main_branch_query_uploads(0, json,"","", "Branches", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0));
//            System.out.println("Record updated....");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_branches(to_branches to_branches) {
        try {
            Connection conn = MyConnection.connect();

            List<String> query = new ArrayList();
            Gson gson = new Gson();
            System.out.println("deleting record....");

            String s0 = "delete from  branches where "
                    + " id ='" + to_branches.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Branches.class, "Successfully Deleted");
            query.add(s0);

            String json = gson.toJson(query);
//            Main_branch_query_uploads.add_data(new Main_branch_query_uploads.to_main_branch_query_uploads(0, json,"","", "Branches", MyUser.getBranch(), MyUser.getBranch_id(), MyUser.getLocation(), MyUser.getLocation_id(), DateType.datetime.format(new Date()), 0));
//            System.out.println("Record deleted....");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branches> ret_data(String search) {
        List<to_branches> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",branch"
                    + ",address"
                    + ",status"
                    + " from branches where "
                    + " branch like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String branch = rs.getString(3);
                String address = rs.getString(4);
                int status = rs.getInt(5);
                to_branches to = new to_branches(id, code, branch, address, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branches> ret_where(String where) {
        List<to_branches> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",branch"
                    + ",address"
                    + ",status"
                    + " from branches  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String branch = rs.getString(3);
                String address = rs.getString(4);
                int status = rs.getInt(5);
                to_branches to = new to_branches(id, code, branch, address, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branches> ret_where2(String where) {
        List<to_branches> datas = new ArrayList();
        to_branches to2 = new to_branches(0, "", "All", "", 0);
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",branch"
                    + ",address"
                    + ",status"
                    + " from branches  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String branch = rs.getString(3);
                String address = rs.getString(4);
                int status = rs.getInt(5);
                to_branches to = new to_branches(id, code, branch, address, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branches> ret_data3(String search) {
        List<to_branches> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",branch"
                    + ",address"
                    + ",status"
                    + " from branches where "
                    + " branch like'%" + search + "%' "
                    + " ";

//            S1_branches.to_branches a1 = new S1_branches.to_branches(0, "", "All Branches", "",0);
//            datas.add(a1);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String branch = rs.getString(3);
                String address = rs.getString(4);
                int status = rs.getInt(5);
                to_branches to = new to_branches(id, code, branch, address, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branches> ret_data_notAll(String search) {
        List<to_branches> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",code"
                    + ",branch"
                    + ",address"
                    + ",status"
                    + " from branches where "
                    + " branch like'%" + search + "%' "
                    + " ";

//            S1_branches.to_branches a1 = new S1_branches.to_branches(0, "", "All Branches", "");
//            datas.add(a1);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String branch = rs.getString(3);
                String address = rs.getString(4);
                int status = rs.getInt(5);
                to_branches to = new to_branches(id, code, branch, address, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_branch {

        public final String code;
        public final String name;
        public final String address;

        public to_branch(String code, String name, String address) {
            this.code = code;
            this.name = name;
            this.address = address;
        }
    }

    public static void main(String[] args) {
        List<to_branch> datas = ret_data2("");
        for (to_branch t : datas) {
            int id = 0;
            String code = t.code;
            String branch = t.name;
            String address = t.address;

            to_branches to = new to_branches(id, code, branch, address, 0);
            add_branches(to);

        }
    }

    public static List<to_branch> ret_data2(String search) {
        List<to_branch> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect2();
            String s0 = "select "
                    + "code"
                    + ",name"
                    + ",address"
                    + " from pisps_dbo.branch where "
                    + " name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);

                to_branch to = new to_branch(code, name, address);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
